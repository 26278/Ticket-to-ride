package ttr.Constants;

public class ClientConstants{
    String ID = new Token().getToken();
    int screenX = 1006;
    int screenY = 670;


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
