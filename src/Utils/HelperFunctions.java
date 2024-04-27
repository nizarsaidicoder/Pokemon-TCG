package Utils;

import Player.AI;
import Pokemon.Affinity;

public class HelperFunctions
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
        for (int i = 0; i < n; i++) {
            output.append(c);
        }
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
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            output.append(c);
        }
        return output + s;
    }
    public static String center(String s, int n)
    {
        String out = "";
        int pad = n - s.length();
        for (int i = 0; i < pad/2; i++) {
            out += " ";
        }
        out += s;
        for (int i = 0; i < pad/2; i++) {
            out += " ";
        }
        return out;
    }

    /**
     * Retourne la couleur en fonction de l'affinité envoyée en argument
     * @param affinity nom affinité
     * @return couleur
     */
    public static String getCorrespondingColor(Affinity affinity) {
        String RESET = "\u001B[0m";
        String RED_TEXT = "\u001B[31m";
        String GREEN_TEXT = "\u001B[32m";
        String YELLOW_TEXT = "\u001B[33m";
        String BLUE_TEXT = "\u001B[34m";
        String foreColor = switch (affinity.getAffinity()) {
            case EARTH -> YELLOW_TEXT;
            case FIRE -> RED_TEXT;
            case WATER -> BLUE_TEXT;
            case AIR -> GREEN_TEXT;
            default -> RESET;
        };
        return foreColor;
    }
    public static String getColorCode(String color) {
        return switch (color) {
            case "YELLOW_TEXT" -> "\u001B[33m";
            case "RED_TEXT", "AI_TEXT" -> "\u001B[31m";
            case "BLUE_TEXT" -> "\u001B[34m";
            case "GREEN_TEXT", "PLAYER_TEXT" -> "\u001B[32m";
            case "PURPLE_TEXT" -> "\u001B[35m";
            case "WHITE_TEXT" -> "\u001B[37m";
            case "CYAN_TEXT" -> "\u001B[36m";
            case "BLACK_TEXT" -> "\u001B[30m";
            case "RED_BACKGROUND", "AI_BACKGROUND" -> "\u001B[41m";
            case "GREEN_BACKGROUND", "PLAYER_BACKGROUND" -> "\u001B[42m";
            case "YELLOW_BACKGROUND" -> "\u001B[43m";
            case "BLUE_BACKGROUND" -> "\u001B[44m";
            case "PURPLE_BACKGROUND" -> "\u001B[45m";
            case "CYAN_BACKGROUND" -> "\u001B[46m";
            default -> "\u001B[0m";
        };
    }
}
