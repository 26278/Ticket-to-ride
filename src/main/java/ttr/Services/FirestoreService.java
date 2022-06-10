package ttr.Services;

import com.google.cloud.firestore.Firestore;

import java.util.*;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.WriteResult;

import ttr.Config.Database;
import ttr.Constants.ClientConstants;
import ttr.Controllers.Controller;

import static ttr.Constants.ClientConstants.*;


public class FirestoreService {
    private Firestore firestore;

    private static final String GAMES_PATH = "games";
    private ClientConstants cc = new ClientConstants();
    private CollectionReference colRef;

    static FirestoreService firebaseService;

    public static FirestoreService getInstance() {
        if (firebaseService == null) {
            firebaseService = new FirestoreService();
        }
        return firebaseService;
    }

    public FirestoreService() {
        Database db = new Database();
        this.firestore = db.getDb();
        this.colRef = this.firestore.collection(GAMES_PATH);
    }


    public void listen(String documentId, final Controller controller) {

        DocumentReference docRef = this.colRef.document(documentId);

        docRef.addSnapshotListener((snapshot, e) -> {
            if (e != null) {
                System.err.println("Listen failed: " + e);
                return;
            }

            if (snapshot != null && snapshot.exists()) {
                controller.update(snapshot);
            }
        });
    }

    public void set(String documentId, Map<String, Object> docData) {
        ApiFuture<WriteResult> future = this.colRef.document(documentId).set(docData);

    }


    public DocumentSnapshot get(String documentId) {

        DocumentReference docRef = this.colRef.document(documentId);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document;

        try {
            document = future.get();
            if (document.exists()) {
                return document;
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateValue(String field, Object value) {
        DocumentSnapshot ds = this.get(cc.getID());
        Map<String, Object> currentMap = ds.getData();

        currentMap.put(field, value);
        this.set(cc.getID(), currentMap);
    }

    //update specific field
    public void updateField(String field, String key, String value) {
        DocumentSnapshot ds = this.get(cc.getID());

        Map<String, Object> currentMap = ds.getData();

        HashMap td = (HashMap) ds.get(field);
        td.put(key, value);
        currentMap.put(field, td);
        this.set(cc.getID(), currentMap);
    }


    public void updateTrainOrStation(String route, String trainOrStation, String color) {
        DocumentSnapshot ds = this.get(cc.getID());

        Map<String, Object> currentMap = ds.getData();

        HashMap<String, Object> td = (HashMap) ds.get(BOARD_STATE);

        HashMap<String, String> tosMap = new HashMap<>();
        tosMap.put(TRAIN, null);
        tosMap.put(STATION, null);
        tosMap.put(trainOrStation, color);

        td.put(route, tosMap);
        currentMap.put(BOARD_STATE, td);
        this.set(cc.getID(), currentMap);
    }


    public HashMap<Object, HashMap> getBoardState() {
        DocumentSnapshot ds = this.get(cc.getID());
        HashMap<Object, HashMap> td = (HashMap) ds.get(BOARD_STATE);

        return td;
    }


    public void delete(String documentId) {
        ApiFuture<WriteResult> writeResult = this.colRef.document(documentId).delete();
    }
}
