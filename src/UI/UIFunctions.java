package UI;
import Pokemon.Affinity.Element;
import Pokemon.Effects.Power;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Centrer une chaîne de caractères
     * @param s chaîne de caractères à centrer
     * @param n nombre d'espaces nécessaire
     * @return la chaîne de caractère modifiée
     */
     public static String center(String s, int n)
    {
        StringBuilder out = new StringBuilder();
        int pad = n - s.length();
        out.append(" ".repeat(Math.max(0, pad / 2))).append(s).append(" ".repeat(Math.max(0, pad / 2)));
        return pad % 2 == 0 ? out.toString() : out.append(" ").toString();
    }

    /**
     * La couleur correspondant à l'affinité
     * @param affinity affinité
     * @return la couleur correspondante
     */
    public static String getCorrespondingColor(Element affinity) {
        String RESET = "\u001B[0m";
        String RED_TEXT = "\u001B[31m";
        String GREEN_TEXT = "\u001B[32m";
        String YELLOW_TEXT = "\u001B[33m";
        String BLUE_TEXT = "\u001B[34m";
        String PURPLE_TEXT = "\u001B[35m";
        String CYAN_TEXT = "\u001B[36m";
        String out = "";
        switch (affinity) {
            case EARTH:
                out = YELLOW_TEXT;
                break;
            case FIRE:
                out = RED_TEXT;
                break;
            case WATER:
                out = BLUE_TEXT;
                break;
            case AIR:
                out = GREEN_TEXT;
                break;
            case ETHER:
                out = PURPLE_TEXT;
                break;
            case PLOMB:
                out = CYAN_TEXT;
                break;
            case ALL :
                out = PURPLE_TEXT;
                break;
            case NONE:
                out = CYAN_TEXT;
                break;
            default:
                out = RESET;
                break;
        }
        return out;
    }

    /**
     * La couleur correspondant à la puissance
     * @param power puissance
     * @return la couleur correspondante
     */
    public static String  getCorrespondingColor(Power power) {
        String RESET = "\u001B[0m";
        String RED_TEXT = "\u001B[31m";
        String GREEN_TEXT = "\u001B[32m";
        String YELLOW_TEXT = "\u001B[33m";
        String BLUE_TEXT = "\u001B[34m";
        String out = "";
        switch (power) {
            case RESISTANCE :
                out = GREEN_TEXT;
                break;
            case BERSERK:
                out = RED_TEXT;
                break;
            case SOIN_TOTAL:
                out = GREEN_TEXT;
                break;
            case KAMIKAZE:
                out = RED_TEXT;
                break;
            case ETHER:
                out = BLUE_TEXT;
                break;
            case REGENERATION:
                out = GREEN_TEXT;
                break;
            case PLOMB:
                out = YELLOW_TEXT;
                break;
            case DEJA_VU:
                out = BLUE_TEXT;
                break;
            default:
                out = RESET;
                break;
        }
        return out;
    }

    /**
     * La couleur correspondant à la couleur envoyée en argument
     * @param color couleur
     * @return la couleur correspondante
     */
    public static String getColorCode(String color) {
        String out = "";
        switch (color.toUpperCase()) {
            case "YELLOW_TEXT":
                out = "\u001B[33m";
                break;
            case "RED_TEXT":
            case "AI_TEXT":
                out = "\u001B[31m";
                break;
            case "BLUE_TEXT":
                out = "\u001B[34m";
                break;
            case "GREEN_TEXT":
            case "PLAYER_TEXT":
                out = "\u001B[32m";
                break;
            case "PURPLE_TEXT":
                out = "\u001B[35m";
                break;
            case "WHITE_TEXT":
                out = "\u001B[37m";
                break;
            case "CYAN_TEXT":
                out = "\u001B[36m";
                break;
            case "BLACK_TEXT":
                out = "\u001B[30m";
                break;
            case "RED_BACKGROUND":
            case "AI_BACKGROUND":
                out = "\u001B[41m";
                break;
            case "GREEN_BACKGROUND":
            case "PLAYER_BACKGROUND":
                out = "\u001B[42m";
                break;
            case "YELLOW_BACKGROUND":
                out = "\u001B[43m";
                break;
            case "BLUE_BACKGROUND":
                out = "\u001B[44m";
                break;
            case "PURPLE_BACKGROUND":
                out = "\u001B[45m";
                break;
            case "CYAN_BACKGROUND":
                out = "\u001B[46m";
                break;
            default:
                out = "\u001B[0m";
                break;
        }
        return out;
    }

    /**
     * Efface le terminal
     */
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
    public static String colorize(String text, String color) 
    {
        return getColorCode(color + "_text") + text + getColorCode("RESET");
    }

    /**
     * Colorise le texte en fonction de la couleur envoyée en argument et le centre
     * @param text texte à coloriser
     * @param color couleur
     * @param n nombre d'espaces nécessaire
     * @return texte colorisé
     */
    public static String colorizeAndCenter(String text, String color, int n) 
    {
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

    /**
     * Divise une chaîne de caractères en morceaux de taille maximale
     * @param input chaîne de caractères à diviser
     * @param maxChunkSize taille maximale
     * @return liste de morceaux
     */
    public static List<String> splitString(String input, int maxChunkSize) {
        List<String> chunks = new ArrayList<>();

        String[] words = input.split("\\s+"); // Split the input string into words

        StringBuilder chunk = new StringBuilder();
        for (String word : words) {
            if (chunk.length() + word.length() <= maxChunkSize) {
                // If adding the word to the current chunk doesn't exceed the max size
                if (chunk.length() > 0) {
                    // Add a space before appending the word if it's not the first word
                    chunk.append(" ");
                }
                chunk.append(word);
            } else {
                // If adding the word exceeds the max size, start a new chunk
                chunks.add(chunk.toString());
                chunk = new StringBuilder(word);
            }
        }

        // Add the last chunk
        chunks.add(chunk.toString());

        return chunks;
    }
}
