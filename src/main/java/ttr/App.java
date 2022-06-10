package ttr;


import java.util.HashMap;
import java.util.Map;

import ttr.Constants.ClientConstants;
import ttr.Controllers.Controller;
import ttr.Controllers.FirebaseController;
import ttr.Services.FirestoreService;


public class App {
    ClientConstants cc = new ClientConstants();
    String gameIdentifier = cc.getID();
    Controller firebaseController = new FirebaseController();
    FirestoreService fbService;

    public App() {
        this.fbService = FirestoreService.getInstance();

        if (fbService.get(gameIdentifier) == null) {

            //create hashmap with board-data
            Map<String, Map<String, String>> board = new HashMap<String, Map<String, String>>();
            Map<String, String> trainInfo = new HashMap<String, String>();
            trainInfo.put("trainColor", null);
            trainInfo.put("stationColor", null);

            board.put("Edinburgh_London_R", trainInfo);
            board.put("Edinburgh_London_L", trainInfo);
            board.put("Brest_Diepe", trainInfo);
            board.put("Diepe_Paris", trainInfo);
            board.put("Brest_Paris", trainInfo);
            board.put("Diepe_Bruxelles", trainInfo);
            board.put("Amsterdam_Bruxelles", trainInfo);
            board.put("London_Diepe_L", trainInfo);
            board.put("London_Diepe_R", trainInfo);
            board.put("London_Amsterdam", trainInfo);
            board.put("Bruxelles_Paris_R", trainInfo);
            board.put("Bruxelles_Paris_L", trainInfo);
            board.put("Brest_Pamplona", trainInfo);
            board.put("Paris_Pamplona_L", trainInfo);
            board.put("Paris_Pamplona_R", trainInfo);
            board.put("Pamplona_Marseille", trainInfo);
            board.put("Paris_Marseille", trainInfo);
            board.put("Barcelona_Marseille", trainInfo);
            board.put("Pamplona_Barcelona", trainInfo);
            board.put("Madrid_Barcelona", trainInfo);
            board.put("Pamplona_Madrid_R", trainInfo);
            board.put("Pamplona_Madrid_L", trainInfo);
            board.put("Lisboa_Madrid", trainInfo);
            board.put("Cadiz_Madrid", trainInfo);
            board.put("Lisboa_Cadiz", trainInfo);
            board.put("Amsterdam_Essen", trainInfo);
            board.put("Paris_Zurich", trainInfo);
            board.put("Zurich_Marseille", trainInfo);
            board.put("Bruxelles_Frankfurt", trainInfo);
            board.put("Amsterdam_Frankfurt", trainInfo);
            board.put("Paris_Frankfurt_T", trainInfo);
            board.put("Paris_Frankfurt_B", trainInfo);
            board.put("Frankfurt_Essen", trainInfo);
            board.put("Frankfurt_Munchen", trainInfo);
            board.put("Munchen_Zurich", trainInfo);
            board.put("Zurich_Venezia", trainInfo);
            board.put("Munchen_Venezia", trainInfo);
            board.put("Venezia_Rome", trainInfo);
            board.put("Marseille_Roma", trainInfo);
            board.put("Roma_Palermo", trainInfo);
            board.put("Brindisi_Palermo", trainInfo);
            board.put("Roma_Brindisi", trainInfo);
            board.put("Venezia_Zagrab", trainInfo);
            board.put("Wien_Zagrab", trainInfo);
            board.put("Munchen_Wien", trainInfo);
            board.put("Frankfurt_Berlin_B", trainInfo);
            board.put("Frankfurt_Berlin_T", trainInfo);
            board.put("Essen_Berlin", trainInfo);
            board.put("Essen_KObenhavn_L", trainInfo);
            board.put("Essen_Kobenhavn_R", trainInfo);
            board.put("Kobenhavn_Stockholm_L", trainInfo);
            board.put("Kobenhavn_Stockholm_R", trainInfo);
            board.put("Stockholm_Petrograd", trainInfo);
            board.put("Berlin_Danzig", trainInfo);
            board.put("Danzig_Waszawa", trainInfo);
            board.put("Berlin_Warszawa_T", trainInfo);
            board.put("Berlin_Warszawa_B", trainInfo);
            board.put("Berlin_Wien", trainInfo);
            board.put("Wien_Budapest_T", trainInfo);
            board.put("Wien_Budapest_B", trainInfo);
            board.put("Budapest_Zagrab", trainInfo);
            board.put("Zagrab_Sarajevo", trainInfo);
            board.put("Budapest_Sarajevo", trainInfo);
            board.put("Warszawa_Wien", trainInfo);
            board.put("Sarajevo_Athina", trainInfo);
            board.put("Brindisi_Athina", trainInfo);
            board.put("Palermo_Smyrna", trainInfo);
            board.put("Athina_Smyrna", trainInfo);
            board.put("Sofia_Athina", trainInfo);
            board.put("Sarajevo_Sofia", trainInfo);
            board.put("Danzig_Riga", trainInfo);
            board.put("Riga_Petrograd", trainInfo);
            board.put("Riga_Wilno", trainInfo);
            board.put("Warszawa_Wilno", trainInfo);
            board.put("Petrograd_Wilno", trainInfo);
            board.put("Petrograd_Moskva", trainInfo);
            board.put("Wilno_Smolensk", trainInfo);
            board.put("Smolensk_Moskva", trainInfo);
            board.put("Moskva_Kharkov", trainInfo);
            board.put("Kyiv_Kharkov", trainInfo);
            board.put("Wilno_Kyiv", trainInfo);
            board.put("Warszawa_Kyiv", trainInfo);
            board.put("Smolensk_Kyiv", trainInfo);
            board.put("Kyiv_Budapest", trainInfo);
            board.put("Kyiv_Bucuresti", trainInfo);
            board.put("Budapest_Bucuresti", trainInfo);
            board.put("Bucuresti_Sofia", trainInfo);
            board.put("Kharkov_Rostov", trainInfo);
            board.put("Rostov_Sochi", trainInfo);
            board.put("Rostov_Sevastopol", trainInfo);
            board.put("Sevastopol_Sochi", trainInfo);
            board.put("Bucuresti_Sevastopol", trainInfo);
            board.put("Angora_Erzurum", trainInfo);
            board.put("Contantinople_Smyrna", trainInfo);
            board.put("Contantinople_Angora", trainInfo);
            board.put("Sevastopol_Erzurum", trainInfo);
            board.put("Sevastopol_Constantinople", trainInfo);
            board.put("Smyrna_Angora", trainInfo);
            board.put("Sochi_Erzurum", trainInfo);
            board.put("Sofia_Constantinople", trainInfo);
            board.put("Bucuresti_Constantinople", trainInfo);


            // create hashmap with traincardDeck
            Map trainCardDeck = new HashMap<String, String>();
            trainCardDeck.put("red", 12);
            trainCardDeck.put("blue", 12);
            trainCardDeck.put("yellow", 12);
            trainCardDeck.put("brown", 12);
            trainCardDeck.put("white", 12);
            trainCardDeck.put("black", 12);
            trainCardDeck.put("loco", 12);
            trainCardDeck.put("green", 12);

            //create hashmap with ticketDeck
            Map<String, String> ticketDeck = new HashMap<>();
            ticketDeck.put("1", "Barcelona_Munchen");

            // combine hashmaps or add necessary empty fields
            Map<String, Object> dataForFirebase = new HashMap<>();
            dataForFirebase.put("BoardState", board);
            dataForFirebase.put("TraincardDeck", trainCardDeck);
            dataForFirebase.put("TicketDeck", ticketDeck);
            dataForFirebase.put("current_player", 1);
            dataForFirebase.put("players", new HashMap<String, String>());
            dataForFirebase.put("final_turn", false);
            dataForFirebase.put("game_finished", false);

            //add data to firebase
            fbService.set(gameIdentifier, dataForFirebase);
        }
        //initialise listener for firebase
        fbService.listen(gameIdentifier, firebaseController);
    }

}
