package ttr.Model;

/*
todo
ROTATION

*/

import javafx.scene.image.Image;

public class TrainModel implements Observable{
    public Image getGreen() {
        return green;
    }
    public Image getBlue() {
        return blue;
    }

    private Image red = new Image("src/main/resources/ttr/images/train-Red.png");
    private Image blue = new Image("src/main/resources/ttr/images/train-Blue.png");

    public Image getRed() {
        return red;
    }

    private Image green = new Image("src/main/resources/ttr/images/train-Green.png");

    public Image getPurple() {
        return purple;
    }

    private Image purple = new Image("src/main/resources/ttr/images/train-Purple.png");

    public Image getYellow() {
        return yellow;
    }

    private Image yellow = new Image("src/main/resources/ttr/images/train-Yellow.png");






    @Override
    public void notifyObservers() {

    }

    @Override
    public void addObserver() {

    }

    @Override
    public void removeObserver() {

    }


}
