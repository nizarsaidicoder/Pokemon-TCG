package UI;

import UI.UIFunctions;
import Player.*;
import Pokemon.*;
import Pokemon.Effects.Effect;

import java.util.ArrayList;
import java.util.List;
//import java.util.Arrays;
// Cette classe est utilisée pour afficher les différentes étapes du jeu et les informations des joueurs
public class Display {
    public static int screenSize = 120;
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
        System.out.println(UIFunctions.colorizeAndCenter("Welcome to the Pokemon card game!", "purple", screenSize));
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
        System.out.println(UIFunctions.colorizeAndCenter("Game.Game Over", "red", screenSize));
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
            System.out.println(UIFunctions.colorizeAndCenter(currentPlayer.getName() + "'s turn", "blue", screenSize - screenSize/6));
        }
        else
        {
            System.out.println(UIFunctions.colorizeAndCenter("AI's turn", "red", screenSize - screenSize/6));
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
            System.out.print(" ________________________ ");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            System.out.print("|                        |");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            if(i > pokemons.size() - 1)
            {
                System.out.print("|                        |");
                System.out.print("\t\t");
            }
            else
            {
                String foreColor = UIFunctions.getCorrespondingColor(pokemons.get(i).getAffinity().getElement());
                System.out.print(UIFunctions.padRight("| ("+(i+1)+") " + foreColor + pokemons.get(i).getName(),30)+ RESET+ "|");
                System.out.print("\t\t");
            }
        }
        System.out.println();

        for(int i = 0; i < 3; i++)
        {
            System.out.print("|________________________|");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            System.out.print("|                        |");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i=0;i<3;i++)
        {
            if(pokemons.size() > i)
            {
                System.out.print(UIFunctions.padRight("| Attack: " + Integer.toString(pokemons.get(i).getAttack()),25) + "|");
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                        |");
                System.out.print("\t\t");
            }

        }
        System.out.println();

        for(int i = 0; i < 3; i++)
        {
            if(pokemons.size() > i)
            {
                System.out.print(UIFunctions.padRight("| HP: " + Integer.toString(pokemons.get(i).getHP()) + "/" + Integer.toString(pokemons.get(i).getHPMax()),25) + "|");
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                        |");
                System.out.print("\t\t");
            }
        }
        System.out.println();

        for(int i = 0; i < 3; i++)
        {
            if(pokemons.size() > i)
            {
                String foreColor = UIFunctions.getCorrespondingColor(pokemons.get(i).getAffinity().getElement());
                System.out.print(UIFunctions.padRight("| Affinity : " + foreColor + pokemons.get(i).getAffinity().getElement(),30) + RESET + "|");
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                        |");
                System.out.print("\t\t");
            }
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            if(pokemons.size() > i)
            {
                String foreColor = UIFunctions.getCorrespondingColor(pokemons.get(i).getAffinity().getStrength());
                System.out.print(UIFunctions.padRight("| Strength : " + foreColor + pokemons.get(i).getAffinity().getStrength(), 30) + RESET + "|");
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                        |");
                System.out.print("\t\t");
            }
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            if(pokemons.size() > i)
            {
                String foreColor = UIFunctions.getCorrespondingColor(pokemons.get(i).getAffinity().getStrength());
                if(pokemons.get(i).hasEffect())
                {
                    PokemonWithPower pokemonWithPower = (PokemonWithPower) pokemons.get(i);
                    System.out.print(UIFunctions.padRight("| Ability : " + foreColor + pokemonWithPower.getEffect().getPower(), 30) + RESET + "|");
                }
                else
                {
                    System.out.print("|                        |");
                }
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                        |");
                System.out.print("\t\t");
            }
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            System.out.print("|________________________|");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            System.out.print("\\________________________/");
            System.out.print("\t\t");
        }
        System.out.println();
    }
    //Resistance: Upon use, the Pokémon with this current effect can select an ally (including itself). Until the end of the battle or the death of the chosen Pokémon, that Pokémon takes 10 less damage from each attack.
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
        System.out.println();
        System.out.println(UIFunctions.colorizeAndCenter("HAND", "purple", screenSize));
        System.out.println("POKEMON                | HP                   | AFFINITY             | ATTACK           | EFFECT");
        for(int i=0; i< pokemons.size(); i++)
        {
            System.out.print((i+1) + " ");
            printPokemon(pokemons.get(i));
        }
    }

    public static void printAI(Player ai)
    {
        // Affiche le joueur
        System.out.println(UIFunctions.colorizeAndCenter("AI", "red", screenSize));
        String out = " _________________________ \t\t _________________________ \n" +
                "|        DECK: " + UIFunctions.padLeft(Integer.toString(ai.getDeck().getSize()),2,'0') + "         |\t\t" +"|      GRAVEYARD: " + UIFunctions.padLeft(Integer.toString(ai.getGraveyard().getSize()),2,'0') + "      |" + "\n" +
                "|_________________________|\t\t|_________________________|";
        out = UIFunctions.colorize(out, "red");
        System.out.println(out);
        printField(ai.getField().getPokemons());
    }

    public static void printPlayer(Player player)
    {
        System.out.println(UIFunctions.colorizeAndCenter(player.getName(), "blue", screenSize));
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
        String out = UIFunctions.getCorrespondingColor(pokemon.getAffinity().getElement()) + UIFunctions.padRight(pokemon.getName(),20) + UIFunctions.getColorCode("reset") +  " | " + UIFunctions.padRight(Integer.toString(pokemon.getHP()) ,20) + " | " + UIFunctions.getCorrespondingColor(pokemon.getAffinity().getElement()) + UIFunctions.padRight( pokemon.getAffinity().getElement().toString(), 20 )+ UIFunctions.getColorCode("reset") + " | " + pokemon.getAttack();
        if(pokemon.hasEffect())
        {
            PokemonWithPower pokemonWithPower = (PokemonWithPower) pokemon;
            out += "               | " + UI.UIFunctions.getCorrespondingColor(pokemonWithPower.getEffect().getPower()) + pokemonWithPower.getEffect().getPower() + UIFunctions.getColorCode("reset");
        }
        System.out.println(out);
    }
    public static void printEffects(ArrayList<Effect> effects)
    {
        System.out.println(UIFunctions.colorizeAndCenter("Effects", "purple", screenSize));
        System.out.println("ABILITY                          | TARGET TYPE");
        int i = 1;
        for(Effect effect : effects)
        {
            String target = effect.getTargetType().toString();
            System.out.println(i + " " + UIFunctions.getCorrespondingColor(effect.getPower()) + UIFunctions.padRight(effect.getPower().toString(),30) + UIFunctions.getColorCode("reset") + " | " + target);
            i++;
        }
    }
    public static void printEffect(Effect effect)
    {
        List<String> split = UIFunctions.splitString(effect.getDescription(), 27);
        System.out.println(" _______________________________");
        System.out.println("|                               |");
        System.out.println("|" + UIFunctions.colorizeAndCenter(effect.getPower().toString(), UIFunctions.getCorrespondingColor(effect.getPower()),30) + " |");
        System.out.println("|_______________________________|");
        System.out.println("| Type      : Buff              |");
        System.out.println("| Duration  : Unique            |");
        System.out.println("|                               |");
        for(String s : split)
        {
            System.out.println("| " + UIFunctions.center(s, 30) + "|");
        }
        System.out.println("|                               |");
        System.out.println("|_______________________________|");
    }
    /*
     * Affiche la phase de bataille
     */
    public static void battlePhase()
    {
        System.out.println(UIFunctions.colorizeAndCenter("Battle phase ⚔️", "blue", screenSize));
    }
    public static void effectPhase()
    {
        System.out.println(UIFunctions.colorizeAndCenter("Effect phase 🌀", "blue", screenSize));
    }
}
