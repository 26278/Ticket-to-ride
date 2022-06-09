package ttr.Constants;

public class ClientConstants {
    String ID = new Token().getToken();
    public final static int screenX = 1280;
    public final static int screenY = 880;

    public static final String BOARD_STATE = "BoardState";
    public static final String STATION = "stationColor";
    public static final String TRAIN = "trainColor";

    public static String getBoardState() {
        return BOARD_STATE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

}
