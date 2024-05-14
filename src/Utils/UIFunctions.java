package Utils;
import Pokemon.Element;
public class UIFunctions
{
    /**
     * Remplit n caractères c nécessaire pour compléter une chaîne de caractères par la droite
     * @param s chaîne de caractères à compléter
     * @param n nombre espaces nécessaire
     * @param c caractère à ajouter
     * @return la chaîne de caractère modifiée
     */
    public static String padRight(String s, int n,char c)
    {
        StringBuilder output = new StringBuilder(s);
        output.append(String.valueOf(c).repeat(Math.max(0, n)));
        return output.toString();
    }
    /**
     * Remplit n espaces nécessaire pour compléter une chaîne de caractères par la droite
     * @param s chaîne de caractères à compléter
     * @param n nombre espaces nécessaire
     * @return la chaîne de caractère modifiée
     */
    public static String padRight(String s, int n)
    {
        return String.format("%-" + n + "s", s);
    }
    /**
     * Remplit n espaces nécessaire pour compléter une chaîne de caractères par la gauche
     * @param s chaîne de caractères à compléter
     * @param n nombre espaces nécessaire
     * @return la chaîne de caractère modifiée
     */
    public static String padLeft(String s, int n)
    {
        return String.format("%" + n + "s", s);
    }
    /**
     * Remplit n caractères c nécessaire pour compléter une chaîne de caractères par la gauche
     * @param s chaîne de caractères à compléter
     * @param n nombre espaces nécessaire
     * @param c caractère à ajouter
     * @return la chaîne de caractère modifiée
     */
    public static String padLeft(String s, int n,char c)
    {
        // If the string is already longer than n, return the string
        if (s.length() >= n) return s;
        StringBuilder output = new StringBuilder();
        output.append(String.valueOf(c).repeat(Math.max(0, n - s.length()))).append(s);
        return output.toString();
    }
    public static String center(String s, int n)
    {
        StringBuilder out = new StringBuilder();
        int pad = n - s.length();
        out.append(" ".repeat(Math.max(0, pad / 2))).append(s).append(" ".repeat(Math.max(0, pad / 2)));
        return pad % 2 == 0 ? out.toString() : out.append(" ").toString();
    }

    /**
     * Retourne la couleur en fonction de l'affinité envoyée en argument
     * @param affinity nom affinité
     * @return couleur
     */
    public static String getCorrespondingColor(Element affinity) {
        String RESET = "\u001B[0m";
        String RED_TEXT = "\u001B[31m";
        String GREEN_TEXT = "\u001B[32m";
        String YELLOW_TEXT = "\u001B[33m";
        String BLUE_TEXT = "\u001B[34m";
        String out = "";
        switch (affinity) {
            case EARTH -> out = YELLOW_TEXT;
            case FIRE -> out = RED_TEXT;
            case WATER -> out = BLUE_TEXT;
            case AIR -> out = GREEN_TEXT;
            default -> out = RESET;
        };
        return out;
    }
    public static String getColorCode(String color) {
        String out = "";
         switch (color.toUpperCase()) {
            case "YELLOW_TEXT" -> out="\u001B[33m";
            case "RED_TEXT", "AI_TEXT" -> out="\u001B[31m";
            case "BLUE_TEXT" -> out="\u001B[34m";
            case "GREEN_TEXT", "PLAYER_TEXT" -> out="\u001B[32m";
            case "PURPLE_TEXT" -> out="\u001B[35m";
            case "WHITE_TEXT" -> out="\u001B[37m";
            case "CYAN_TEXT" -> out="\u001B[36m";
            case "BLACK_TEXT" -> out="\u001B[30m";
            case "RED_BACKGROUND", "AI_BACKGROUND" -> out="\u001B[41m";
            case "GREEN_BACKGROUND", "PLAYER_BACKGROUND" -> out="\u001B[42m";
            case "YELLOW_BACKGROUND" -> out="\u001B[43m";
            case "BLUE_BACKGROUND" -> out="\u001B[44m";
            case "PURPLE_BACKGROUND" -> out="\u001B[45m";
            case "CYAN_BACKGROUND" -> out="\u001B[46m";
            default -> out = "\u001B[0m";
        };
        return out;
    }
    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Colorise le texte en fonction de la couleur envoyée en argument
     * @param text texte à coloriser
     * @param color couleur
     * @return
     */
    public static String colorize(String text, String color) {
        return getColorCode(color + "_text") + text + getColorCode("RESET");
    }
    public static String colorizeAndCenter(String text, String color, int n) {
        return colorize(center(text,n),"",color);
    }
    /*
     * Colorise le texte en fonction de la couleur envoyée en argument
     * @param text texte à coloriser
     * @param foreColor couleur avant
     * @param backColor couleur arrière
     * @return texte colorisé
     */
    public static String colorize(String text, String foreColor, String backColor) {
        return getColorCode(foreColor + "_text") + getColorCode(backColor + "_background") + text + getColorCode("RESET");
    }
}
