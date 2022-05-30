package ttr.Controllers;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import ttr.Constants.ClientConstants;
import ttr.Model.PlayerModel;
import ttr.Services.FirestoreService;

import java.util.HashMap;
import java.util.Map;

public class FirebaseController implements Controller {
    FirestoreService fs = new FirestoreService();
    ClientConstants cc = new ClientConstants();

    @Override
    public void update(DocumentSnapshot ds) {
        Map<String, Object> currentMap = ds.getData();
        HashMap td = (HashMap) ds.get("TraincardDeck");
        td.put("black", 5);
        currentMap.put("TraincardDeck", td);
        fs.set(cc.getID(), currentMap);
    }
}

