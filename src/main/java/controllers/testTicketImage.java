package controllers;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.PlayerHandModel;
import models.TicketDeckModel;
import models.TicketModel;
import models.TrainCardDeckModel;

import java.util.Objects;


public class testTicketImage extends Application {
    private static TrainCardDeckModel trainCardDeckModel = new TrainCardDeckModel();
    TicketDeckModel ticketDeckModel;
    private PlayerHandModel playerHandModel;
    private Image ticketImage;

    @Override
    public void start(Stage stage) {

        TicketModel ticket1 = new TicketModel("eu", "amsterdam", "pamplona", 100, false);
        TicketDeckModel.ticketDeck.add(ticket1);

        playerHandModel.ticketHand.add(ticketDeckModel.ticketDeck.get(0));

        for (TicketModel ticketModel : playerHandModel.ticketHand) {
            String imageUrl = "ttr/tickets"+ ticketModel.getType() + "-" + ticketModel.getFirst_Destination() + "-" + ticketModel.getSecond_Destination()+".png";
            Image ticketImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imageUrl)));
        }
        try {
            ImageView iv1 = new ImageView();
            iv1.setImage(ticketImage);
            Group root = new Group();
            Scene scene = new Scene(root);
            HBox box = new HBox();
            box.getChildren().add(iv1);
            root.getChildren().add(box);

            stage.setTitle("ImageTicket");
            stage.setWidth(400);
            stage.setHeight(200);
            stage.setScene(scene);
            stage.sizeToScene();
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
