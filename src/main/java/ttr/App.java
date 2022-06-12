package ttr;


import java.util.HashMap;
import java.util.Map;

import ttr.Constants.ClientConstants;
import ttr.Controllers.Controller;
import ttr.Controllers.FirebaseController;
import ttr.Services.FirestoreService;

import static ttr.Constants.ClientConstants.FINAL_SCORES;
import static ttr.Constants.ClientConstants.TRAIN;


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

            board.put("edinburgh_london_R", trainInfo);
            board.put("edinburgh_london_L", trainInfo);
            board.put("brest_Diepe", trainInfo);
            board.put("Diepe_paris", trainInfo);
            board.put("brest_paris", trainInfo);
            board.put("Diepe_bruxelles", trainInfo);
            board.put("amsterdam_bruxelles", trainInfo);
            board.put("london_Diepe_L", trainInfo);
            board.put("london_Diepe_R", trainInfo);
            board.put("london_amsterdam", trainInfo);
            board.put("bruxelles_paris_R", trainInfo);
            board.put("bruxelles_paris_L", trainInfo);
            board.put("brest_pamplona", trainInfo);
            board.put("paris_pamplona_L", trainInfo);
            board.put("paris_pamplona_R", trainInfo);
            board.put("pamplona_marseille", trainInfo);
            board.put("paris_marseille", trainInfo);
            board.put("barcelona_marseille", trainInfo);
            board.put("pamplona_barcelona", trainInfo);
            board.put("madrid_barcelona", trainInfo);
            board.put("pamplona_madrid_R", trainInfo);
            board.put("pamplona_madrid_L", trainInfo);
            board.put("lisboa_madrid", trainInfo);
            board.put("cadiz_madrid", trainInfo);
            board.put("lisboa_cadiz", trainInfo);
            board.put("amsterdam_essen", trainInfo);
            board.put("paris_zurich", trainInfo);
            board.put("zurich_marseille", trainInfo);
            board.put("bruxelles_frankfurt", trainInfo);
            board.put("amsterdam_frankfurt", trainInfo);
            board.put("paris_frankfurt_T", trainInfo);
            board.put("paris_frankfurt_B", trainInfo);
            board.put("frankfurt_essen", trainInfo);
            board.put("frankfurt_munchen", trainInfo);
            board.put("munchen_zurich", trainInfo);
            board.put("zurich_venezia", trainInfo);
            board.put("munchen_venezia", trainInfo);
            board.put("venezia_roma", trainInfo);
            board.put("marseille_roma", trainInfo);
            board.put("roma_palermo", trainInfo);
            board.put("brindisi_palermo", trainInfo);
            board.put("roma_brindisi", trainInfo);
            board.put("venezia_zagrab", trainInfo);
            board.put("wien_zagrab", trainInfo);
            board.put("munchen_wien", trainInfo);
            board.put("frankfurt_berlin_B", trainInfo);
            board.put("frankfurt_berlin_T", trainInfo);
            board.put("essen_berlin", trainInfo);
            board.put("essen_kobenhavn_L", trainInfo);
            board.put("essen_kobenhavn_R", trainInfo);
            board.put("kobenhavn_stockholm_L", trainInfo);
            board.put("kobenhavn_stockholm_R", trainInfo);
            board.put("stockholm_petrograd", trainInfo);
            board.put("berlin_danzig", trainInfo);
            board.put("danzig_warszawa", trainInfo);
            board.put("berlin_warszawa_T", trainInfo);
            board.put("berlin_warszawa_B", trainInfo);
            board.put("berlin_wien", trainInfo);
            board.put("wien_budapest_T", trainInfo);
            board.put("wien_budapest_B", trainInfo);
            board.put("budapest_zagrab", trainInfo);
            board.put("zagrab_sarajevo", trainInfo);
            board.put("budapest_sarajevo", trainInfo);
            board.put("warszawa_wien", trainInfo);
            board.put("sarajevo_athina", trainInfo);
            board.put("brindisi_athina", trainInfo);
            board.put("palermo_smyrna", trainInfo);
            board.put("athina_smyrna", trainInfo);
            board.put("sofia_athina", trainInfo);
            board.put("sarajevo_sofia", trainInfo);
            board.put("danzig_riga", trainInfo);
            board.put("riga_petrograd", trainInfo);
            board.put("riga_wilno", trainInfo);
            board.put("warszawa_wilno", trainInfo);
            board.put("petrograd_wilno", trainInfo);
            board.put("petrograd_moskva", trainInfo);
            board.put("wilno_smolensk", trainInfo);
            board.put("smolensk_moskva", trainInfo);
            board.put("moskva_kharkov", trainInfo);
            board.put("kyiv_kharkov", trainInfo);
            board.put("wilno_kyiv", trainInfo);
            board.put("warszawa_kyiv", trainInfo);
            board.put("smolensk_kyiv", trainInfo);
            board.put("kyiv_budapest", trainInfo);
            board.put("kyiv_bucuresti", trainInfo);
            board.put("budapest_bucuresti", trainInfo);
            board.put("bucuresti_sofia", trainInfo);
            board.put("kharkov_rostov", trainInfo);
            board.put("rostov_sochi", trainInfo);
            board.put("rostov_sevastopol", trainInfo);
            board.put("sevastopol_sochi", trainInfo);
            board.put("bucuresti_sevastopol", trainInfo);
            board.put("angora_erzurum", trainInfo);
            board.put("constantinople_smyrna", trainInfo);
            board.put("constantinople_angora", trainInfo);
            board.put("sevastopol_erzurum", trainInfo);
            board.put("sevastopol_constantinople", trainInfo);
            board.put("smyrna_angora", trainInfo);
            board.put("sochi_erzurum", trainInfo);
            board.put("sofia_constantinople", trainInfo);
            board.put("bucuresti_constantinople", trainInfo);


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
            trainCardDeck.put("purple", 12);


            //create hashmap with ticketDeck
            Map<String, Integer> ticketDeck = new HashMap<>();
            ticketDeck.put("barcelona_munchen", 8);
            ticketDeck.put("amsterdam_pamplona", 7);
            ticketDeck.put("amsterdam_wilno", 12);
            ticketDeck.put("angora_kharkov", 1);
            ticketDeck.put("athina_angora", 5);
            ticketDeck.put("athina_wilno", 11);
            ticketDeck.put("barcelona_bruxelles", 8);
            ticketDeck.put("berlin_bucuresti", 8);
            ticketDeck.put("berlin_moskva", 12);
            ticketDeck.put("berlin_roma", 9);
            ticketDeck.put("brest_marseille", 7);
            ticketDeck.put("brest_petrograd", 20);
            ticketDeck.put("brest_venezia", 8);
            ticketDeck.put("bruxelles_danzig", 9);
            ticketDeck.put("budapest_sofia", 5);
            ticketDeck.put("cadiz_stockholm", 21);
            ticketDeck.put("edinburgh_athina", 21);
            ticketDeck.put("edinburgh_paris", 7);
            ticketDeck.put("essen_kyiv", 10);
            ticketDeck.put("frankfurt_kobenhavn", 5);
            ticketDeck.put("frankfurt_smolensk", 13);
            ticketDeck.put("kobenhavn_erzuren", 21);
            ticketDeck.put("kyiv_petrograd", 6);
            ticketDeck.put("kyiv_sochi", 8);
            ticketDeck.put("lisboa_danzig", 20);
            ticketDeck.put("london_berlin", 7);
            ticketDeck.put("london_wien", 10);
            ticketDeck.put("madrid_dieppe", 8);
            ticketDeck.put("madrid_zurich", 8);
            ticketDeck.put("marseille_essen", 8);
            ticketDeck.put("palermo_constantinople", 5);
            ticketDeck.put("palermo_moskva", 20);
            ticketDeck.put("paris_wien", 8);
            ticketDeck.put("paris_zagrab", 7);
            ticketDeck.put("riga_bucuresti", 10);
            ticketDeck.put("roma_smyrna", 8);
            ticketDeck.put("rostov_erzurum", 5);
            ticketDeck.put("sarajevo_sevastopol", 8);
            ticketDeck.put("smolensk_rostov", 8);
            ticketDeck.put("sofia_smyrna", 5);
            ticketDeck.put("stockholm_wien", 11);
            ticketDeck.put("venezia_constantinople", 10);
            ticketDeck.put("warszawa_smolensk", 6);
            ticketDeck.put("zagrab_brindisi", 6);
            ticketDeck.put("zurich_brindisi", 6);
            ticketDeck.put("zurich_budapest", 6);

            // combine hashmaps or add necessary empty fields
            Map<String, Object> dataForFirebase = new HashMap<>();
            dataForFirebase.put("BoardState", board);
            dataForFirebase.put("TraincardDeck", trainCardDeck);
            dataForFirebase.put("TicketDeck", ticketDeck);
            dataForFirebase.put("current_player", 1);
            dataForFirebase.put("players", new HashMap<String, String>());
            dataForFirebase.put("final_turn", false);
            dataForFirebase.put("game_finished", false);
            dataForFirebase.put(FINAL_SCORES, new HashMap<String, Integer>());

            //add data to firebase
            fbService.set(gameIdentifier, dataForFirebase);
        }
        //initialise listener for firebase
        fbService.listen(gameIdentifier, firebaseController);

    }

}
