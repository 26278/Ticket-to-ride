package ttr.Model;

import ttr.Constants.CardColorTypes;

public class TrainCardModel {
    private CardColorTypes colortype;
    String cardColor;

    public TrainCardModel(CardColorTypes colortype) {
        this.colortype = colortype;
    }

    public TrainCardModel(String cardColor) {
        this.cardColor = cardColor;
    }

    public String getCardColor() {
        return cardColor;
    }

    public CardColorTypes getColorType() { return this.colortype; }
}
