module com.example.iipsene_ttr {
    requires javafx.controls;
    requires javafx.fxml;
    requires google.cloud.firestore;
    requires com.google.api.apicommon;
    requires firebase.admin;
    requires com.google.auth.oauth2;
    requires google.cloud.core;
    requires com.google.auth;
    requires javafx.graphics;

    opens com.example.iipsene_ttr to javafx.fxml;
    exports com.example.iipsene_ttr;
    exports com.example.iipsene_ttr.Controllers;
    opens com.example.iipsene_ttr.Controllers to javafx.fxml;
    exports com.example.iipsene_ttr.Views;
    opens com.example.iipsene_ttr.Views to javafx.fxml;


}