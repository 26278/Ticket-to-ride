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
    FirestoreService fbService = new FirestoreService();

    public App() {
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
            board.put("Venezia_roma", trainInfo);
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
            board.put("Danzig_Warszawa", trainInfo);
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
            board.put("Constantinople_Smyrna", trainInfo);
            board.put("Constantinople_Angora", trainInfo);
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
            ticketDeck.put("Barcelona_Munchen", "8");
            ticketDeck.put("Amsterdam_Pamplona", "7");
            ticketDeck.put("Amsterdam_Wilno", "12");
            ticketDeck.put("Angora_Kharkov", "10");
            ticketDeck.put("Athina_Angora", "5");
            ticketDeck.put("Athina_Wilno", "11");
            ticketDeck.put("Barcelona_Bruxelles", "8");
            ticketDeck.put("Berlin_Bucuresti", "8");
            ticketDeck.put("Berlin_Moskva", "12");
            ticketDeck.put("Berlin_Roma", "9");
            ticketDeck.put("Brest_Marseille", "7");
            ticketDeck.put("Brest_petrograd", "20");
            ticketDeck.put("Brest_Venezia", "8");
            ticketDeck.put("Bruxelles_Danzig", "9");
            ticketDeck.put("Budapest_Sofia", "5");
            ticketDeck.put("Cadiz_Stockholm", "21");
            ticketDeck.put("Edinburgh_Athina", "21");
            ticketDeck.put("Edinburgh_Paris", "7");
            ticketDeck.put("Essen_Kyiv", "10");
            ticketDeck.put("Frankfurt_Kobenhavn", "5");
            ticketDeck.put("Frankfurt_Smolensk", "13");
            ticketDeck.put("Kobenhavn_erzuren", "21");
            ticketDeck.put("Kyiv_Petrograd", "6");
            ticketDeck.put("Kyiv_Sochi", "8");
            ticketDeck.put("Lisboa_Danzig", "20");
            ticketDeck.put("London_Berlin", "7");
            ticketDeck.put("London_Wien", "10");
            ticketDeck.put("Madrid_Dieppe", "8");
            ticketDeck.put("Madrid_Zurich", "8");
            ticketDeck.put("Marseille_Essen", "8");
            ticketDeck.put("Palermo_Constantinople", "5");
            ticketDeck.put("Palermo_Moskva", "20");
            ticketDeck.put("Paris_Wien", "8");
            ticketDeck.put("Paris_Zagrab", "7");
            ticketDeck.put("Riga_Bucuresti", "10");
            ticketDeck.put("Roma_Smyrna", "8");
            ticketDeck.put("Rostov_Erzurum", "5");
            ticketDeck.put("Sarajevo_Sevastopol", "8");
            ticketDeck.put("Smolensk_Rostov", "8");
            ticketDeck.put("Sofia_Smyrna", "5");
            ticketDeck.put("Stockholm_Wien", "11");
            ticketDeck.put("Venezia_Constantinople", "10");
            ticketDeck.put("Warszawa_Smolensk", "6");
            ticketDeck.put("Zagrab_Brindisi", "6");
            ticketDeck.put("Zurich_Brindisi", "6");
            ticketDeck.put("Zurich_Budapest", "6");

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
