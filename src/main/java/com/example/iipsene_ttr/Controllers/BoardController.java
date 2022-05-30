package com.example.iipsene_ttr.Controllers;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;

public class BoardController {

    public Rectangle Edinburgh_London_R1;
    public Rectangle Edinburgh_London_R2;
    public Rectangle Edinburgh_London_R3;
    public Rectangle Edinburgh_London_R4;
    public ArrayList<Rectangle> route = new ArrayList<>();
    public javafx.scene.layout.AnchorPane AnchorPane;
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

 ArrayList<Rectangle> Edinburgh_London_R = new ArrayList<Rectangle>();
    ArrayList<Rectangle> Edinburgh_London_L = new ArrayList<Rectangle>();
    ArrayList<Rectangle> Brest_Diepe = new ArrayList<Rectangle>();
    ArrayList<Rectangle> Brest_Paris = new ArrayList<Rectangle>();
    ArrayList<Rectangle> Diepe_Paris = new ArrayList<Rectangle>();
    ArrayList<Rectangle> Diepe_Bruxelles = new ArrayList<Rectangle>();
    ArrayList<Rectangle> Amsterdam_Bruxelles = new ArrayList<Rectangle>();
    ArrayList<Rectangle>  London_Diepe_L = new ArrayList<Rectangle>();
    ArrayList<Rectangle>  London_Diepe_R = new ArrayList<Rectangle>();

    HashMap <String,ArrayList<Rectangle>> verbinding = new HashMap<>();

    public BoardController(){
        initialize();
    }
    public void initialize(){
        Edinburgh_London_R();
        verbinding.put("Edinburgh_London_R",Edinburgh_London_R);
        Edinburgh_London_L();
        verbinding.put("Edinburgh_London_L",Edinburgh_London_L);
        Brest_Diepe();
        verbinding.put("Brest_Diepe",Brest_Diepe);
        Diepe_Paris();
        verbinding.put("Diepe_Paris",Diepe_Bruxelles);
        Diepe_Bruxelles();
        verbinding.put("Diepe_Bruxelles",Diepe_Bruxelles);
        System.out.println(verbinding);
    }


    public void Edinburgh_London_R() {
        Edinburgh_London_R.add(Edinburgh_London_R1);
        Edinburgh_London_R.add(Edinburgh_London_R2);
        Edinburgh_London_R.add(Edinburgh_London_R3);
        Edinburgh_London_R.add(Edinburgh_London_R4);
    }
    public void Edinburgh_London_L() {
        Edinburgh_London_L.add(Edinburgh_London_L1);
        Edinburgh_London_L.add(Edinburgh_London_L2);
        Edinburgh_London_L.add(Edinburgh_London_L3);
        Edinburgh_London_L.add(Edinburgh_London_L4);

    }
    public void Brest_Diepe(){
        Brest_Diepe.add(Brest_Diepe_1);
        Brest_Diepe.add(Brest_Diepe_2);

    }
    public void Diepe_Paris(){
        Diepe_Paris.add(Diepe_Paris_1);
    }
    public void Diepe_Bruxelles(){
        Diepe_Bruxelles.add(Diepe_Bruxelles_1);
        Diepe_Bruxelles.add(Diepe_Bruxelles_2);

    }
    public void Brest_Paris(){
        Brest_Paris.add(Brest_Paris_1);
        Brest_Paris.add(Brest_Paris_2);
        Brest_Paris.add(Brest_Paris_3);
    }
    public void Amsterdam_Bruxelles(){

        Amsterdam_Bruxelles.add(Amsterdam_Bruxelles_1);
    }
    public void London_diepe_L(){
        London_Diepe_L.add(London_Diepe_L1);
        London_Diepe_L.add(London_Diepe_L2);
    }
    public void London_diepe_R(){
        London_Diepe_R.add(London_Diepe_R1);
        London_Diepe_R.add(London_Diepe_R2);

    }







    @FXML
    public void highlight() {

        // functie om het geselecteerde vakje te highlighten

        Glow glow = new Glow();
        glow.setLevel(1);
        for (int i = 0; i < route.size(); i++) {
                route.get(i).setEffect(glow);
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
