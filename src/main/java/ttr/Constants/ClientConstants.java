package ttr.Constants;

public class ClientConstants{
    String ID = new Token().getToken();
    static int screenX = 1280;
    static int screenY = 880;


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
