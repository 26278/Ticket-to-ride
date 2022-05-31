package com.example.iipsene_ttr.Controllers;

import javafx.fxml.FXML;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class BoardController {

    public Rectangle Edinburgh_London_R1;
    public Rectangle Edinburgh_London_R2;
    public Rectangle Edinburgh_London_R3;
    public Rectangle Edinburgh_London_R4;
    public ArrayList<Rectangle> route = new ArrayList<>();
    public Rectangle Edinburgh_London_L1;
    public Rectangle Edinburgh_London_L2;
    public Rectangle Edinburgh_London_L3;
    public Rectangle Edinburgh_London_L4;
    public Rectangle Brest_Diepe_1;
    public Rectangle Brest_Diepe_2;
    public Rectangle Diepe_Paris_1;
    public Rectangle Brest_Paris_1;
    public Rectangle Brest_Paris_2;
    public Rectangle Brest_Paris_3;
    public Rectangle Diepe_Bruxelles_2;
    public Rectangle Diepe_Bruxelles_1;
    public Rectangle Amsterdam_Bruxelles_1;
    public Rectangle London_Diepe_L2;
    public Rectangle London_Diepe_R2;
    public Rectangle London_Amsterdam_1;
    public Rectangle London_Amsterdam_2;
    public Rectangle London_Diepe_L1;
    public Rectangle London_Diepe_R1;
    public Rectangle Bruxelles_Paris_R1;
    public Rectangle Bruxelles_Paris_R2;
    public Rectangle Bruxelles_Paris_L1;
    public Rectangle Bruxelles_Paris_L2;
    public Rectangle Brest_Pamplona_4;
    public Rectangle Brest_Pamplona_3;
    public Rectangle Brest_Pamplona_2;
    public Rectangle Brest_Pamplona_1;
    public Rectangle Paris_Pamplona_L1;
    public Rectangle Paris_Pamplona_L2;
    public Rectangle Paris_Pamplona_L3;
    public Rectangle Paris_Pamplona_L4;
    public Rectangle Paris_Pamplona_R1;
    public Rectangle Paris_Pamplona_R2;
    public Rectangle Paris_Pamplona_R3;
    public Rectangle Paris_Pamplona_R4;
    public Rectangle Pamplona_Marseille_1;
    public Rectangle Pamplona_Marseille_2;
    public Rectangle Pamplona_Marseille_3;
    public Rectangle Pamplona_Marseille_4;
    public Rectangle Paris_Marseille_1;
    public Rectangle Paris_Marseille_2;
    public Rectangle Paris_Marseille_3;
    public Rectangle Paris_Marseille_4;


    @FXML
    public void highlight(MouseEvent event) {
        // functie om het geselecteerde vakje te highlighten
        route.add(Edinburgh_London_R1);
        route.add(Edinburgh_London_R2);
        route.add(Edinburgh_London_R3);
        route.add(Edinburgh_London_R4);
        route.add(Edinburgh_London_L1);
        route.add(Edinburgh_London_L2);
        route.add(Edinburgh_London_L3);
        route.add(Edinburgh_London_L4);
        route.add(Brest_Diepe_1);
        route.add(Brest_Diepe_2);
        route.add(Brest_Paris_1);
        route.add(Brest_Paris_2);
        route.add(Brest_Paris_3);
        route.add(Diepe_Paris_1);
        route.add(Diepe_Bruxelles_1);
        route.add(Diepe_Bruxelles_2);
        route.add(Amsterdam_Bruxelles_1);
        route.add(London_Diepe_L1);
        route.add(London_Diepe_L2);
        route.add(London_Amsterdam_1);
        route.add(London_Amsterdam_2);
        route.add(London_Diepe_R1);
        route.add(London_Diepe_R2);
        route.add(Bruxelles_Paris_L1);
        route.add(Bruxelles_Paris_L2);
        route.add(Bruxelles_Paris_R1);
        route.add(Bruxelles_Paris_R2);
        route.add(Brest_Pamplona_1);
        route.add(Brest_Pamplona_2);
        route.add(Brest_Pamplona_3);
        route.add(Brest_Pamplona_4);
        route.add(Paris_Pamplona_L1);
        route.add(Paris_Pamplona_L2);
        route.add(Paris_Pamplona_L3);
        route.add(Paris_Pamplona_L4);
        route.add(Paris_Pamplona_R1);
        route.add(Paris_Pamplona_R2);
        route.add(Paris_Pamplona_R3);
        route.add(Paris_Pamplona_R4);
        route.add(Pamplona_Marseille_1);
        route.add(Pamplona_Marseille_2);
        route.add(Pamplona_Marseille_3);
        route.add(Pamplona_Marseille_4);
        route.add(Paris_Marseille_1);
        route.add(Paris_Marseille_2);
        route.add(Paris_Marseille_3);
        route.add(Paris_Marseille_4);
        String id = event.getPickResult().getIntersectedNode().getId();
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
