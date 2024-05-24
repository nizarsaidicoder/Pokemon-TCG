import Utils.UIFunctions;
import Player.*;
import Pokemon.*;
import java.util.ArrayList;
// Cette classe est utilisée pour afficher les différentes étapes du jeu et les informations des joueurs
public class Display {
    public static int screenSize = 100;
    /*
     * Afficher l'introduction du jeu
     */
    public static void intro()
    {
        UIFunctions.clearTerminal();

        String pikachuArt = UIFunctions.colorize( "⠐⣶⣾⣭⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡄⠀⠄⠀⠀⠀⠀⠀\n" +
                "⠀⠹⣿⣿⣧⠈⠙⠳⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⠴⢻⣿⣿⣿⢇⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠘⢿⣿⡄⠀⠀⠀⠙⢿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡴⠛⠉⠀⠀⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠈⠻⣧⠀⠀⠀⠀⠀⠙⢿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠟⠉⠀⠀⠀⠀⢰⣿⣿⡿⠃⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠘⢷⣀⠀⠀⠀⠀⠀⠹⣦⡀⠀⢀⣀⣀⣀⣰⣶⣦⣀⣀⡀⠀⠀⣠⡶⠋⠁⠀⠀⠀⠀⠀⢀⣾⡻⠋⠀⠀⡀⣀⣄⣤⡤⣦\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠙⢦⣄⠀⠀⠀⠀⠈⣷⠶⠛⠉⠉⠁⠀⠀⠈⠉⠉⠛⠿⡿⠟⠁⠀⠀⠀⠀⢀⣠⣶⡿⠋⣀⣤⠼⠗⠛⠉⠁⠀⠀⡟\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⠷⢦⣀⣰⠖⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣄⣤⣶⣟⣣⡽⡿⠟⠋⠀⠀⠀⠀⠀⠀⢀⣾⡟\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢐⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠒⠿⡷⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣼⠏⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢫⣯⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⣴⣿⠻⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⣴⡻⣿⣷⡀⠀⢹⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠃⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⠇⠀⣿⡿⢿⣿⠃⠀⠀⠀⣀⣀⠀⠀⠀⣿⣿⣿⣿⠇⠀⢸⡀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣴⣾⠟⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⡤⣤⡈⠉⠉⠁⠀⠀⠀⠀⠉⠉⠀⠀⠀⠀⠉⠛⠃⢀⣠⣈⣧⠀⠀⣤⣴⡶⠿⠿⠛⠉⠉⠁⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠙⣦⠀⠀⠀⠳⠤⠴⠞⠛⠦⣤⠾⠃⠀⠀⣼⠋⠀⠈⣿⠀⠀⠈⣷⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" ,"blue")+
                UIFunctions.colorize("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣷⡄⠀⢀⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠄⠀⣰⡟⠀⠀⠀⠀⠻⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣶⣛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢒⣶⣿⢻⣷⣤⠀⠀⠀⠈⢻⣦⡀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣽⡇⠙⠳⣦⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⠶⠋⢸⡷⠞⠋⠀⣀⣠⣶⠞⠿⠙⠃⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡿⠁⠀⠀⠀⠉⠓⠭⣷⣦⣤⣤⡴⠦⣺⠛⠉⠀⠀⠀⠈⣷⠀⢶⣿⣟⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡞⠁⠀⠀⠀⠀⠀⠀⠀⣦⠀⠀⠀⠀⣰⠏⠀⠀⠀⠀⠀⠀⠘⣷⣀⣨⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡆⠀⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⡋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⣠⣄⣀⣠⡟⠀⢀⡄⠀⠀⠀⠀⠀⠀⠀⠈⣇⠀⠀⣼⠁⠀⠀⠀⠀⠀⠀⢀⡇⠀⠘⣷⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⢰⣿⣿⣛⣿⣁⠀⠀⣧⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⣾⠁⠀⠀⢸⣱⣿⣷⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠈⢿⣿⠻⣤⣉⠷⠀⠸⣇⠀⠀⠀⠀⠀⠀⠀⣿⠰⠠⡏⠀⠀⠀⠀⠀⠀⣰⠇⠀⢀⡴⢛⣱⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠈⠛⢷⡀⠈⠳⣄⠀⠹⣦⠀⠀⠀⠀⠀⠀⡟⠀⠀⣷⠀⠀⠀⠀⠀⣰⠏⠀⢀⣴⠚⠉⣸⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⢹⣦⡀⠈⠃⣦⠘⢷⡀⠀⠀⠀⢀⣧⣤⣤⣿⠀⠀⠀⢀⣼⠃⣀⠒⠛⢀⣤⣾⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣛⣦⠴⢿⢶⣿⣿⡤⢴⣶⢿⡛⠁⠙⣿⣶⣤⣤⣾⣗⢶⣯⣤⣴⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀","purple");
        System.out.println(pikachuArt);
        System.out.println(UIFunctions.colorizeAndCenter("Welcome to the Pokemon card game!", "purple", 300));
        System.out.println();
        credits();
        System.out.println();
        System.out.println(UIFunctions.colorizeAndCenter("Please resize your terminal to have a better experience with the game", "red", screenSize));
        try {Thread.sleep(2000);}
        catch (InterruptedException e) {e.printStackTrace();}
        System.out.println(UIFunctions.colorizeAndCenter("Preparing the game", "blue", screenSize));
        try {Thread.sleep(2000);}
        catch (InterruptedException e) {e.printStackTrace();}
        UIFunctions.clearTerminal();
    }
    /*
     * Afficher la fin du jeu
     * @param winner le gagnant
     */
    public static void outro(String winner)
    {
        UIFunctions.clearTerminal();
        String pikachuArt = "⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛\n" +
                "⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛\n" +
                "⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛⬛⬛\n" +
                "⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛🟨🟨🟨⬛⬛⬛\n" +
                "⬜⬜⬜⬛⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛🟨🟨🟨🟨⬛⬛⬜\n" +
                "⬜⬜⬜⬛⬛⬛🟧🟧🟧⬛⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛🟨🟨🟨🟨🟧⬛⬛⬜\n" +
                "⬜⬜⬜⬜⬜⬛⬛🟫🟨🟨🟨🟨🟧⬛⬛⬛⬛⬜⬛⬛⬛⬛⬛⬛⬛⬜⬛⬛🟨🟨🟨🟨🟧🟧⬛⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬜⬛⬛🟫🟧🟨🟨🟨🟨🟨🟨🟧⬛🟨🟨🟨🟨🟨🟨🟨⬛🟧🟨🟨🟨🟨🟧🟧⬛⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬜⬜⬛⬛🟧🟧🟧🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟧🟧🟧⬛⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛🟧🟧🟧🟧🟧🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟧⬛🟧⬛⬜⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛🟧⬛🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟧⬛⬜⬜⬜⬜⬜⬜\n" +
                "⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨⬛⬜⬜⬜⬜⬜⬜\n" +
                "⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛🟨🟨🟨⬛⬛🟨🟨🟨🟨🟨🟨🟨🟨⬛⬛🟨🟨⬛⬜⬜⬜⬜⬜⬜\n" +
                "⬛🟧⬛⬜⬜⬜⬜⬜⬜⬜⬜⬛🟧🟨🟨⬛⬛⬜⬛🟨🟨🟨🟨🟨🟨⬛⬛⬜⬛🟨🟧⬛⬜⬜⬜⬜⬜\n" +
                "⬛🟨🟧⬛⬜⬜⬜⬜⬜⬜⬜⬛🟨🟨🟨⬛⬛⬛⬛🟨🟨🟨🟨🟨🟨⬛⬛⬛⬛🟨🟨⬛⬜⬜⬜⬜⬜\n" +
                "⬛🟨🟨🟧⬛⬜⬜⬜⬜⬜⬜⬛🟨🟨🟨🟨⬛⬛🟨🟨🟨🟨🟨🟨🟨🟨⬛⬛🟨🟨🟨⬛⬜⬜⬜⬜⬜\n" +
                "⬛🟨🟨🟨🟧⬛⬜⬜⬜⬜⬛🟨🟨🟥🟥🟨🟨🟨🟨🟨🟨⬛⬛🟨🟨🟨🟨🟨🟨🟥🟥🟨⬛⬜⬜⬜⬜\n" +
                "⬛🟨🟨🟨🟨🟧⬛⬜⬜⬜⬛🟨🟥🟥🟥🟥🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟥🟥🟥🟥⬛⬜⬜⬜⬜\n" +
                "⬛🟨🟨🟨🟨🟨🟧⬛⬜⬜⬛🟨🟥🟥🟥🟥🟨🟨⬛🟨🟨⬛⬛🟨🟨⬛🟨🟨🟥🟥🟥🟥⬛⬜⬜⬜⬜\n" +
                "⬛🟨🟨🟨🟨🟨🟨🟧⬛⬜⬛🟨🟨🟥🟥🟨🟨🟨🟨⬛⬛🟨🟨⬛⬛🟨🟨🟨🟨🟥🟥🟨⬛⬜⬜⬜⬜\n" +
                "⬛🟨🟨🟨🟨🟨🟨🟨🟧⬛⬛⬛🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨⬛⬜⬜⬜⬜⬜\n" +
                "⬛🟨🟨🟨🟨🟨🟨🟨🟨🟧⬛⬛🟧🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟧⬛⬜⬜⬜⬜⬜\n" +
                "⬜⬛🟨🟨🟨🟨🟨🟨🟨🟨⬛⬜⬛🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨⬛⬜⬜⬜⬜⬜⬜\n" +
                "⬜⬜⬛🟨🟨🟨🟨🟨🟨⬛⬜⬛🟧🟨🟨🟨🟨🟨🟨🟨🟧🟧🟧🟧🟨🟨🟨🟨🟨🟨🟧⬛⬜⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬛🟨🟨🟨🟨⬛⬜⬜⬛⬛🟨🟨🟨🟨🟨🟨🟨🟨🟧🟧🟨🟨🟨🟨🟨🟨🟨🟨⬛⬜⬜⬜⬜⬜\n" +
                "⬜⬜⬛🟨🟨🟨🟨⬛⬜⬜⬜⬛🟨🟨🟨🟨🟨🟨⬛🟨🟨🟨🟨🟨🟨⬛🟨🟨🟨🟨🟨⬛⬜⬜⬜⬜⬜\n" +
                "⬜⬜⬛🟨🟨🟨🟨🟨⬛⬜⬛🟨🟨🟨⬛🟨🟨🟨⬛🟨🟨🟨🟨🟨🟨⬛🟨🟨🟨⬛🟨⬛⬜⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬛🟨🟨🟨🟨🟨⬛⬛🟨🟨🟨⬛🟨🟨🟨🟨⬛🟨🟨🟨🟨⬛🟨🟨🟨🟨⬛🟨🟨⬛⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬛🟨🟨🟧🟧🟫⬛🟨🟨🟨🟧⬛🟨🟨🟨⬛🟨🟨🟨🟨⬛🟨🟨🟨⬛🟧🟨🟨⬛⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬛🟧🟧🟧⬛⬛🟨🟨🟨🟧⬛🟨🟨🟨⬛🟨🟨🟨🟨⬛🟨🟨🟨⬛🟧🟨🟨⬛⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬜⬛🟧🟫🟫⬛🟨🟨🟨🟨🟧⬛🟨🟨⬛🟨🟨🟨🟨⬛🟨🟨⬛🟧🟨🟨🟨⬛⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬛🟫🟫🟫🟫⬛🟨🟨🟨🟨🟨🟧⬛⬛🟨🟨🟨🟨🟨🟨⬛⬛🟧🟨🟨🟨🟨⬛⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬜⬛🟫🟫🟫⬛🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨⬛⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬜⬜⬛⬛🟫⬛🟧🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨⬛⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨⬛⬜⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛🟧🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨🟨⬛⬜⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛🟨🟨🟨🟨🟨🟨🟧🟧🟧🟧🟧🟨🟨🟨🟨🟨🟨⬛⬜⬜⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛🟧🟨🟧🟧⬛⬛⬛⬛⬛⬛⬛🟧🟧🟨🟧⬛⬜⬜⬜⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛🟨🟨🟨⬛⬛⬛⬜⬜⬜⬜⬜⬜⬛⬛🟨🟨🟨⬛⬜⬜⬜⬜⬜⬜\n" +
                "⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬜⬜⬜⬜⬛⬛⬛⬛⬛⬜⬜⬜⬜⬜⬜\n";
        System.out.println(UIFunctions.colorizeAndCenter("Game Over", "red", screenSize));
        winner(winner);
        credits();
        System.out.println(pikachuArt);
    }
    /*
     * Afficher le gagnant
     * @param winner le gagnant
     */
    public static void winner(String winner)
    {
        if(winner.equalsIgnoreCase("computer"))
            System.out.println(UIFunctions.colorizeAndCenter(winner + " wins!", "red", screenSize));
        else
            System.out.println(UIFunctions.colorizeAndCenter(winner + " wins!", "green", screenSize));
    }
    /*
     * Afficher les crédits
     */
    public static void credits()
    {
        System.out.println(UIFunctions.colorizeAndCenter("Developed by: ", "purple", screenSize));
        System.out.println(UIFunctions.colorizeAndCenter("By: Haggui nesrine", "purple", screenSize));
        System.out.println(UIFunctions.colorizeAndCenter("And: Saidi Nizar", "blue", screenSize));
    }
    /*
     * Afficher le jeu : (Le terrain de jeu, la main, le tour actuel)
     */
    public static void gameStatus(int turn, Player currentPlayer, Player player, Player ai)
    {
        // Affiche le statut du jeu
        UIFunctions.clearTerminal();
        System.out.print(UIFunctions.getColorCode("PURPLE_BACKGROUND") + UIFunctions.center("TURN "+ turn,screenSize/6)  + UIFunctions.getColorCode("RESET"));
        if(currentPlayer == player)
        {
            System.out.println(UIFunctions.colorizeAndCenter(currentPlayer.getName() + "'s turn", "blue", screenSize));
        }
        else
        {
            System.out.println(UIFunctions.colorizeAndCenter("AI's turn", "red", screenSize));
        }
        System.out.println();
        printAI(ai);
        System.out.println();
        System.out.println();
        printPlayer(player);
    }
    /*
     * Affiche qui commence le jeu
     */
    public static void coinFlip(Player player)
    {
        System.out.println(UIFunctions.colorizeAndCenter("Flipping the coin ...","purple" , 100));
        try {Thread.sleep(1500);}
        catch (InterruptedException e) {e.printStackTrace();}
        if(player.getPlayerNumber() == 1) System.out.println(UIFunctions.colorizeAndCenter("You start !", "green", 100));
        else System.out.println(UIFunctions.colorizeAndCenter("Computer starts !", "red", 100));
        try {Thread.sleep(1500);}
        catch (InterruptedException e) {e.printStackTrace();}
        System.out.println(UIFunctions.colorizeAndCenter("LET'S DUEL !", "purple", 100));
        try {Thread.sleep(1500);}
        catch (InterruptedException e) {e.printStackTrace();}
    }
    /*
     * Affiche la phase d'invoquation
     */
    public static void spawnPhase()
    {
        System.out.println(UIFunctions.colorizeAndCenter("Spawn phase 🐣", "blue", screenSize));
    }

    public static void printDeck(int size)
    {
        String out = " _________________________ " + "\n" +
                "|        DECK: " + UIFunctions.padLeft(Integer.toString(size),2,'0') + "         |" + "\n" +
                "|_________________________|";
        out = UIFunctions.colorize(out, "blue");
        System.out.println(out);
    }

    public static void printField(ArrayList<Pokemon> pokemons)
    {
        String RESET = "\033[0m";  // Text Color Reset
        for(int i = 0; i < 3; i++)
        {
            System.out.print(" ____________________ ");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            System.out.print("|                    |");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            if(i > pokemons.size() - 1)
            {
                System.out.print("|                    |");
                System.out.print("\t\t");
            }
            else
            {
                String foreColor = UIFunctions.getCorrespondingColor(pokemons.get(i).getAffinity().getElement());
                System.out.print(UIFunctions.padRight("| ("+(i+1)+") " + foreColor + pokemons.get(i).getName(),26)+ RESET+ "|");
                System.out.print("\t\t");
            }
        }
        System.out.println();

        for(int i = 0; i < 3; i++)
        {
            System.out.print("|____________________|");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            System.out.print("|                    |");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i=0;i<3;i++)
        {
            if(pokemons.size() > i)
            {
                System.out.print(UIFunctions.padRight("| Attack: " + Integer.toString(pokemons.get(i).getAttack()),21) + "|");
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                    |");
                System.out.print("\t\t");
            }

        }
        System.out.println();

        for(int i = 0; i < 3; i++)
        {
            if(pokemons.size() > i)
            {
                System.out.print(UIFunctions.padRight("| HP: " + Integer.toString(pokemons.get(i).getHP()) + "/" + Integer.toString(pokemons.get(i).getHPMax()),21) + "|");
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                    |");
                System.out.print("\t\t");
            }
        }
        System.out.println();

        for(int i = 0; i < 3; i++)
        {
            if(pokemons.size() > i)
            {
                String foreColor = UIFunctions.getCorrespondingColor(pokemons.get(i).getAffinity().getElement());
                System.out.print(UIFunctions.padRight("| Affinity : " + foreColor + pokemons.get(i).getAffinity().getElement(),26) + RESET + "|");
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                    |");
                System.out.print("\t\t");
            }
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            if(pokemons.size() > i)
            {
                String foreColor = UIFunctions.getCorrespondingColor(pokemons.get(i).getAffinity().getStrength());
                System.out.print(UIFunctions.padRight("| Strength : " + foreColor + pokemons.get(i).getAffinity().getStrength(), 26) + RESET + "|");
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                    |");
                System.out.print("\t\t");
            }
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            if(pokemons.size() > i)
            {
                String foreColor = UIFunctions.getCorrespondingColor(pokemons.get(i).getAffinity().getWeakness());
                System.out.print(UIFunctions.padRight("| Weakness : " + foreColor + pokemons.get(i).getAffinity().getWeakness(), 26) + RESET + "|");
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                    |");
                System.out.print("\t\t");
            }
        }
        System.out.println();

        for(int i = 0; i < 3; i++)
        {
            System.out.print("|____________________|");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            System.out.print("\\____________________/");
            System.out.print("\t\t");
        }
        System.out.println();
    }

    public static void printGraveyard(int size)
    {
        String out = " _________________________ " + "\n" +
                "|      GRAVEYARD: " + UIFunctions.padLeft(Integer.toString(size),2,'0') + "      |" + "\n" +
                "|_________________________|";
        out = UIFunctions.colorize(out, "red");
        System.out.println(out);
    }

    public static void printHand(ArrayList<Pokemon> pokemons)
    {
        System.out.println(UIFunctions.colorizeAndCenter("HAND", "purple", 100));
        System.out.println("POKEMON                | HP                   | AFFINITY             | ATTACK");
        for(int i=0; i< pokemons.size(); i++)
        {
            System.out.print((i+1) + " ");
            printPokemon(pokemons.get(i));
        }
    }

    public static void printAI(Player ai)
    {
        // Affiche le joueur
        System.out.println(UIFunctions.colorizeAndCenter("AI", "red", 100));
        String out = " _________________________ \t\t _________________________ \n" +
                "|        DECK: " + UIFunctions.padLeft(Integer.toString(ai.getDeck().getSize()),2,'0') + "         |\t\t" +"|      GRAVEYARD: " + UIFunctions.padLeft(Integer.toString(ai.getGraveyard().getSize()),2,'0') + "      |" + "\n" +
                "|_________________________|\t\t|_________________________|";
        out = UIFunctions.colorize(out, "red");
        System.out.println(out);
        printField(ai.getField().getPokemons());
    }

    public static void printPlayer(Player player)
    {
        System.out.println(UIFunctions.colorizeAndCenter(player.getName(), "blue", 100));
        printField(player.getField().getPokemons());
        String out = " _________________________ \t\t _________________________ \n" +
                "|        DECK: " + UIFunctions.padLeft(Integer.toString(player.getDeck().getSize()),2,'0') + "         |\t\t" +"|      GRAVEYARD: " + UIFunctions.padLeft(Integer.toString(player.getGraveyard().getSize()),2,'0') + "      |" + "\n" +

                "|_________________________|\t\t|_________________________|";
        out = UIFunctions.colorize(out, "blue");
        System.out.println(out);
        printHand(player.getHand().getPokemons());
        System.out.println();
    }

    public static void printPokemon(Pokemon pokemon)
    {
        String out = UIFunctions.getCorrespondingColor(pokemon.getAffinity().getElement()) + UIFunctions.padRight(pokemon.getName(),20) + UIFunctions.getColorCode("reset") +  " | " + UIFunctions.padRight(Integer.toString(pokemon.getHP()) ,20) + " | " + UIFunctions.getCorrespondingColor(pokemon.getAffinity().getElement()) + UIFunctions.padRight( pokemon.getAffinity().getElement().toString(), 20 )+ UIFunctions.getColorCode("reset") + " | " + pokemon.getAttack() ;
        System.out.println(out);
    }

    /*
     * Affiche la phase de bataille
     */
    public static void battlePhase()
    {
        System.out.println(UIFunctions.colorizeAndCenter("Battle phase ⚔️", "blue", screenSize));
    }


}
