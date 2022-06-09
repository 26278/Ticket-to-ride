package ttr.Constants;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorConstants {
    public static final String COLOR_RED = "red";
    public static final String COLOR_BLUE = "blue";
    public static final String COLOR_GREEN = "green";
    public static final String COLOR_YELLOW = "yellow";
    public static final String COLOR_WHITE = "white";
    public static final String COLOR_BLACK = "black";
    public static final String COLOR_RAINBOW = "loco";
    public static final String COLOR_BROWN = "brown";
    public static final String COLOR_PURPLE = "purple";

    public static ArrayList<String> getColors() {
        return new ArrayList<>(Arrays.asList(COLOR_RAINBOW, COLOR_BLACK, COLOR_BLUE, COLOR_BROWN, COLOR_GREEN,
                COLOR_PURPLE, COLOR_YELLOW, COLOR_WHITE, COLOR_RED));
    }
}
