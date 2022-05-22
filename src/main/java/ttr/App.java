package ttr;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import ttr.Config.Database;
import ttr.Services.FirestoreService;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;


public class App {

    private String player_1 = null;
    private String player_2 = null;
    private String player_3 = null;
    private String player_4 = null;
    private String player_5 = null;

    String gameIdentifier = "ABCDEF";

    public App() throws IOException, InterruptedException {

        Database setup = new Database();
        Firestore db = setup.getDb();

        DocumentReference docRef = db.collection("games").document(gameIdentifier);

        // We maken hier een hashmap met de gegevens van de spelers.
        Map playerData = new HashMap<String, String>();
        playerData.put("Player_1", player_1);
        playerData.put("Player_2", player_2);
        playerData.put("Player_3", player_3);
        playerData.put("Player_4", player_4);
        playerData.put("Player_5", player_5);

        // We maken hier de HashMap met de "game" gegevens.
        Map dataForFirebase = new HashMap<String, Object>();
        dataForFirebase.put("Players", playerData);
        dataForFirebase.put("current_player", "Player_1");

        FirestoreService fbService = new FirestoreService();		// Gebruik de firebase server voor contact met firebase.
        fbService.set(gameIdentifier, dataForFirebase);


        // De listener
        docRef.addSnapshotListener((snapshot, error) -> {
            if (error != null) {
                System.err.println("Listen failed: " + error);
                return;
            }

            if (snapshot != null && snapshot.exists()) {

                System.out.println("Current data: " + snapshot.getData());
            } else {
                System.out.print("Current data: null");
            }

        });
    }

}
