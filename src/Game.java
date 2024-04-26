import Player.Player;
import Player.AI;

import java.util.Random;

public class Game
{
    private final Player m_player;
    private final AI m_ai;
    private Player m_currentPlayer;
    private Player m_opponent;
    private String m_winner;
    private int m_turn;

    /**
     * Constructeur de la classe Game
     */
    public Game()
    {
        // Initialise les attributs de la classe
        welcome();
        boolean firstPlayer = isFirstPlayer();
        if (firstPlayer)
        {
            m_player = new Player(1);
            m_ai = new AI(2);
            m_currentPlayer = m_player;
            m_opponent = m_ai;
        }
        else
        {
            m_player = new Player(2);
            m_ai = new AI(1);
            m_currentPlayer = m_ai;
            m_opponent = m_player;
        }
        m_winner = null;
        m_turn = 0;
    }

    /**
     * Méthode pour démarrer le jeu
     */
    public void start()
    {
        // appelez la méthode welcome

        // Déterminez aléatoirement le premier joueur

        // Affichez un message pour indiquer le début du jeu

        // Tant que le jeu n'est pas terminé
//             drawPhase();
//             spawnPhase();
//             attackPhase();
//             endPhase();
        // Appelez la méthode end
    }
    /**
     * Méthode pour terminer le jeu
     */
    public void end()
    {
        // Affichez un message pour indiquer la fin du jeu
        // Affichez le gagnant
    }
    public void drawPhase()
    {
        // tant que le joueur actuel n'a pas 5 cartes en main
        // affiche le statut du jeu ( en-tete, joueur1, joueur2)
        //  currentPlayer.draw();
    }
    public void spawnPhase()
    {
        // tant que le joueur actuel a des cartes en main et que le terrain n'est pas plein
        // affiche le statut du jeu ( en-tete, joueur1, joueur2)
        //  currentPlayer.spawn();
    }
    public void attackPhase()
    {
        // tant que le joueur actuel a des pokemons jouables sur le terrain et que l'adversaire a des pokemons sur le terrain
        // affiche le statut du jeu ( en-tete, joueur1, joueur2)
        //  currentPlayer.attack(opponent);
        // !!! Attention !!!
        // Il faut passer l'autre joueur en paramètre de la méthode play, pour que le joueur actuel puisse attaquer l'autre joueur
    }

    public void endPhase()
    {
        // Phase de fin
        // basculer entre les joueurs
        // incrémenter le tour
    }
    /**
     * Méthode pour déterminer le premier joueur
     * @return 1 si le joueur commence, 2 si l'IA commence
     */

    public boolean isFirstPlayer()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        // Choisissez aléatoirement le premier joueur
        // Affichez un message pour indiquer qui commence
        System.out.println("Deciding who starts ...");
        // Prompt the user to press Enter to continue
        System.out.println("Press Enter to continue ...");
        // Wait for the user to press Enter
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        // Prompt the user to choose Heads or Tails
        System.out.println("Heads or Tails ?");
        // Wait for the user to enter Heads or Tails
        String choice = "";
        try
        {
            int character;
            while((character = System.in.read()) != '\n')
            {
                choice += (char) character;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(choice.equals("Heads") || choice.equals("Tails"))
        {
            Random rnd = new Random();
            int firstPlayer = rnd.nextInt(2) + 1;
            if((firstPlayer == 1 && choice.equals("Heads")) || (firstPlayer == 2 && choice.equals("Tails")))
            {
                System.out.println("You start !");
                return true;
            }
            else
            {
                System.out.println("Computer starts !");
                return false;
            }
            // Affichez le résultat du lancer de pièce

        }
        else
        {
            // Affichez un message d'erreur
            System.out.println("Invalid choice. Please enter Heads or Tails.");
            // Rappeler la méthode isFirstPlayer
            return isFirstPlayer();
        }
    }
    /**
     * Méthode pour basculer entre les joueurs
     */
    public void switchPlayer()
    {
        // Changez le joueur actuel
        m_currentPlayer = m_currentPlayer == m_player ? m_ai : m_player;
    }
    /**
     * Méthode pour passer au tour suivant
     */
    public void nextTurn()
    {
        // Incrémentez le tour actuel
        m_turn++;
    }
    /**
     * Méthode pour vérifier si le jeu est terminé
     * @return true si le jeu est terminé, false sinon
     */
    public boolean isGameOver()
    {
        // Le jeu est terminé si et seulement si player.isDefeated() ou ai.isDefeated() est vrai
        if(m_player.isDefeated())
        {
            m_winner = "Computer";
            return true;
        }
        if(m_ai.isDefeated())
        {
            m_winner = "You";
            return true;
        }
        // Si le jeu est terminé, mettez à jour le gagnant
        return false;
    }
    /**
     * Méthode pour afficher un message de bienvenue
     */
    public void welcome()
    {
        // Affiche le logo du jeu
        System.out.print("\033[H\033[2J");
        System.out.flush();
        final String RESET = "\033[0m";  // Text Reset
        final String YELLOW = "\033[0;33m";    // YELLOW
        String pikachuArt = "⠐⣶⣾⣭⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡄⠀⠄⠀⠀⠀⠀⠀\n" +
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
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠙⣦⠀⠀⠀⠳⠤⠴⠞⠛⠦⣤⠾⠃⠀⠀⣼⠋⠀⠈⣿⠀⠀⠈⣷⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣷⡄⠀⢀⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠄⠀⣰⡟⠀⠀⠀⠀⠻⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
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
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣛⣦⠴⢿⢶⣿⣿⡤⢴⣶⢿⡛⠁⠙⣿⣶⣤⣤⣾⣗⢶⣯⣤⣴⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";

        System.out.println( YELLOW+ pikachuArt +  RESET);
        // Affiche un message de bienvenue
        System.out.println("|------------ Welcome to Pokemon Battle -----------|");
        System.out.println("Game is starting ...");
    }
    /**
     * Méthode pour afficher le tour actuel et le joueur actuel
     */
    public void showTurnAndCurrentPlayer()
    {
        // Affiche le joueur actuel
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|---------Turn : "+ m_turn + "----------|" + "|----------Current Player : " + m_currentPlayer.getPlayerNumber() + " -------------|");
        System.out.println("-----------------------------------------------------------------------------------------");
    }
    public void showGameStatus()
    {
        // Affiche le statut du jeu
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("************************************** GAME STATUS **************************************");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        showTurnAndCurrentPlayer();
        m_ai.display();
        System.out.println();

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        m_player.display();
    }
}
