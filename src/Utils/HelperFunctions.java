package Utils;

public class HelperFunctions {
    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
      }
    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
      }

    public static String getCorrespondingColor(String affinity) {
        String RESET = "\u001B[0m";
        String RED_TEXT = "\u001B[31m";
        String GREEN_TEXT = "\u001B[32m";
        String YELLOW_TEXT = "\u001B[33m";
        String BLUE_TEXT = "\u001B[34m";
        String foreColor = "";
        switch (affinity.toLowerCase()) {
            case "earth":
                foreColor = YELLOW_TEXT;
                break;
            case "fire":
                foreColor = RED_TEXT;
                break;
            case "water":
                foreColor = BLUE_TEXT;
                break;
            case "air":
                foreColor = GREEN_TEXT;
                break;
            default:
                foreColor = RESET;
        }
        return foreColor;
    }

}
