package ttr.Services;

import com.google.cloud.firestore.Firestore;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.WriteResult;


import ttr.Config.Database;
import ttr.Controllers.Controller;


public class FirestoreService {
    private Firestore firestore;

    private static final String GAMES_PATH = "games";
    private CollectionReference colRef;


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
                System.out.println("Current data: " + snapshot.getData());
            }
            else {
                System.out.print("Current data: null");
            }
        });
    }



    public void set(String documentId, Map<String, Object> docData) {
        ApiFuture<WriteResult> future = this.colRef.document(documentId).set(docData);

        try {
            System.out.println("Update time : " + future.get().getUpdateTime());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
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
            else {
                System.out.println("No such document!");
            }
        }
        catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(String documentId) {
        ApiFuture<WriteResult> writeResult = this.colRef.document(documentId).delete();
    }
}