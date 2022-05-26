package ttr;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import ttr.Config.Database;
import ttr.Constants.ClientConstants;
import ttr.Controllers.Controller;
import ttr.Controllers.FirebaseController;
import ttr.Services.FirestoreService;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;


public class App {

    private String player_1 = null;
    private String player_2 = null;
    private String player_3 = null;
    private String player_4 = null;
    private String player_5 = null;

    ClientConstants cc = new ClientConstants();
    String gameIdentifier = cc.getID();
    Controller firebaseController = new FirebaseController();

    public App() {

        Database setup = new Database();
        Firestore db = setup.getDb();

        DocumentReference docRef = db.collection("games").document(gameIdentifier);

        // create hashmap with traincardDeck
        Map trainCardDeck = new HashMap<String, String>();
        trainCardDeck.put("red", 12);
        trainCardDeck.put("blue", 12);
        trainCardDeck.put("yellow", 12);
        trainCardDeck.put("orange", 12);
        trainCardDeck.put("white", 12);
        trainCardDeck.put("black", 12);
        trainCardDeck.put("rainbow", 12);
        trainCardDeck.put("green", 12);

        //create hasmap with ticketDeck
        Map ticketDeck = new HashMap<String, String>();
        ticketDeck.put("1", "Barcelona_Munchen");

        // combine hashmaps
        Map dataForFirebase = new HashMap<String, Object>();
        dataForFirebase.put("TraincardDeck", trainCardDeck);
        dataForFirebase.put("TicketDeck", ticketDeck);
        dataForFirebase.put("current_player", 1);

        //add data to firebase
        FirestoreService fbService = new FirestoreService();
        fbService.set(gameIdentifier, dataForFirebase);

        //initialise listener for firebase
        fbService.listen(gameIdentifier, firebaseController);
    }

}
