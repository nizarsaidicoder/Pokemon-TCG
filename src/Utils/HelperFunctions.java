package Utils;

import Player.AI;
import Pokemon.Affinity;

public class HelperFunctions
{
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
}
