module ttr {
    requires javafx.controls;
    requires javafx.fxml;
    requires google.cloud.firestore;
    requires com.google.api.apicommon;
    requires firebase.admin;
    requires com.google.auth.oauth2;
    requires google.cloud.core;
    requires com.google.auth;
    requires javafx.graphics;

    opens ttr to javafx.fxml;
    exports ttr;
    exports ttr.Controllers;
    opens ttr.Controllers to javafx.fxml;
}