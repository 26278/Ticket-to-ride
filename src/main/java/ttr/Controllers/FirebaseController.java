package ttr.Controllers;

import com.google.cloud.firestore.DocumentSnapshot;

public class FirebaseController implements Controller {
    @Override
    public void update(DocumentSnapshot ds) {
        System.out.println("update received");

    }
}
