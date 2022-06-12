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


    public int getTrainCardValue(String color) {
        DocumentSnapshot ds = this.get(cc.getID());

        String field = TRAINCARD_DECK;
        Map<String, Object> currentMap = ds.getData();

        HashMap td = (HashMap) ds.get(field);
        String s = td.get(color).toString();
        int value = Integer.parseInt(s);

        return value;
    }


    public HashMap<Object, HashMap> getBoardState() {
        DocumentSnapshot ds = this.get(cc.getID());
        HashMap<Object, HashMap> td = (HashMap) ds.get(BOARD_STATE);

        return td;
    }


    public String getTrainOrStation(String route, String trainOrStation) {
        HashMap<Object, HashMap> td = getBoardState();

        HashMap<String, Object> target = td.get(route);
        Object value = target.get(trainOrStation);
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    public void updateValue(String field, Object value) {
        DocumentSnapshot ds = this.get(cc.getID());
        Map<String, Object> currentMap = ds.getData();

        currentMap.put(field, value);
        this.set(cc.getID(), currentMap);
    }


    public void updateField(String field, String key, Object value) {
        DocumentSnapshot ds = this.get(cc.getID());

        Map<String, Object> currentMap = ds.getData();

        HashMap td = (HashMap) ds.get(field);
        td.put(key, value);
        currentMap.put(field, td);
        this.set(cc.getID(), currentMap);
    }

    public void updateTicketCards() {

    }

    public void removeTicket(String key) {
        DocumentSnapshot ds = this.get(cc.getID());

        Map<String, Object> currentMap = ds.getData();

        HashMap td = (HashMap) ds.get(TICKET_DECK);
        if (td.get(key) != null) {
            td.remove(key);
            currentMap.put(TICKET_DECK, td);
            this.set(cc.getID(), currentMap);
        }
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

    public void delete(String documentId) {
        ApiFuture<WriteResult> writeResult = this.colRef.document(documentId).delete();
    }
}
