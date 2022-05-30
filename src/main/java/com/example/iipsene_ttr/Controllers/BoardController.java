package com.example.iipsene_ttr.Controllers;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class BoardController {

    //public Rectangle Edinburgh_London_R1;
    public Rectangle Edinburgh_London_R2;
    public Rectangle Edinburgh_London_R3;
    public Rectangle Edinburgh_London_R4;
    public ArrayList<Rectangle> route = new ArrayList<>();
    public javafx.scene.layout.AnchorPane AnchorPane;


    @FXML
    public void highlight(MouseEvent event) {
        // functie om het geselecteerde vakje te highlighten
        String id = event.getPickResult().getIntersectedNode().getId();
        //route.add(Edinburgh_London_R1);
        route.add(Edinburgh_London_R2);
        route.add(Edinburgh_London_R3);
        route.add(Edinburgh_London_R4);
        Glow glow = new Glow();
        glow.setLevel(1);
        for (int i = 0; i < route.size(); i++) {
            if (route.get(i).getId() == id){
                route.get(i).setEffect(glow);
            }

        }
    }

    @FXML
    public void no_highlight() {
        Glow glow = new Glow();
        glow.setLevel(0);
        for (int i = 0; i < route.size(); i++) {
            route.get(i).setEffect(glow);

        }

    }

    @FXML
    public void place_train_or_station() {
        // functie om een trein of station te bouwen

        System.out.println("place");
    }
}
