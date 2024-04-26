import Player.Player;
import Player.AI;
import Pokemon.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class Game
{
    private Player m_player;
    private AI m_ai;
    private Player m_currentPlayer;
    private Player m_opponent;
    private String m_winner;
    private ArrayList<String> m_pokemonNames;
    private int m_turn;

    /**
     * Constructeur de la classe Game
     */
    public Game()
    {
        // Initialise les attributs de la classe
        m_pokemonNames = new ArrayList<>(Arrays.asList("Pikachu", "Charmander", "Bulbasaur", "Squirtle", "Jigglypuff", "Mewtwo", "Gengar", "Eevee", "Snorlax", "Dragonite", "Mew", "Gyarados", "Vaporeon", "Flareon", "Jolteon", "Articuno", "Zapdos", "Moltres", "Ditto", "Machamp", "Alakazam", "Blastoise", "Venusaur", "Raichu", "Sandslash", "Nidoking", "Nidoqueen", "Clefable", "Ninetales", "Wigglytuff", "Vileplume", "Parasect", "Venomoth", "Dugtrio", "Persian", "Golduck", "Primeape", "Arcanine", "Poliwrath", "Victreebel", "Tentacruel", "Golem", "Rapidash", "Slowbro", "Magneton", "Farfetch'd", "Dodrio", "Dewgong"));
        m_winner = null;
        m_turn = 0;
    }

    /**
     * Méthode pour démarrer le jeu
     */
    public void start()
    {
        // appelez la méthode welcome
        welcome();
        // Générez les pokémons
        ArrayList<Pokemon> pokemons = generatePokemons();
        // Déterminez aléatoirement le premier joueur
        boolean firstPlayer = isFirstPlayer();
        if (firstPlayer)
        {
            m_player = new Player(new ArrayList<>(pokemons.subList(0, 20)),1);
            m_ai = new AI(new ArrayList<>(pokemons.subList(20,41)),2);
            m_currentPlayer = m_player;
            m_opponent = m_ai;
        }
        else
        {
            m_player = new Player(new ArrayList<>(pokemons.subList(20,41)),2);
            m_ai = new AI(new ArrayList<>(pokemons.subList(0, 20)),1);
            m_currentPlayer = m_ai;
            m_opponent = m_player;
        }
        //Testez si les pokémons sont générés correctement
        // for each pokemon in pokemons print pokemon
        System.out.println("Player's pokemons : ");
        for(Pokemon pokemon : m_player.getDeck().getPokemons())
        {
            pokemon.display();
        }
        System.out.println("AI's pokemons : ");
        for(Pokemon pokemon : m_ai.getDeck().getPokemons())
        {
            pokemon.display();
        }

        // Affichez un message pour indiquer le début du jeu
        System.out.println("Let's DUEL !");

    }
    public void play()
    {
        while (!isGameOver())
        {
            showGameStatus();
            drawPhase();
            spawnPhase();
            attackPhase();
            endPhase();
        }
        end();
    }
    /**
     * Méthode pour terminer le jeu
     */
    public void end()
    {
        System.out.println("Game Over !");
        showWinner();
        showCredits();
    }
    public void drawPhase()
    {
        // tant que la main du joueur actuel est vide et que le deck du joueur actuel n'est pas vide
        while(m_currentPlayer.getHand().isEmpty() && !m_currentPlayer.getDeck().isEmpty())
        {
            showGameStatus();
            m_currentPlayer.draw();
        }
    }
    public void spawnPhase()
    {
        // tant que le joueur actuel a des cartes en main et que le terrain n'est pas plein
        while(!m_currentPlayer.getHand().isEmpty() && !m_currentPlayer.getField().isFull())
        {
            showGameStatus();
            m_currentPlayer.spawn();
        }
        m_currentPlayer.setPlayablePokemons();
    }
    public void attackPhase()
    {
        // tant que le joueur actuel a des pokemons jouables sur le terrain et que l'adversaire a des pokemons sur le terrain
        while(m_currentPlayer.hasPlayablePokemons() && !m_opponent.getField().isEmpty())
        {
            showGameStatus();
            m_currentPlayer.attack(m_opponent);
        }
        // !!! Attention !!!
        // Il faut passer l'autre joueur en paramètre de la méthode play, pour que le joueur actuel puisse attaquer l'autre joueur
    }

    public void endPhase()
    {
        // Phase de fin
        switchPlayer();
        nextTurn();
    }
    public ArrayList<Pokemon> generatePokemons()
    {
        //Génération des Pokémons
        //À chaque partie, les Pokémons de chaque pioche sont générées selon l'algorithme suivant :
        //
        //leur nom est tiré aléatoirement parmi une liste de noms fixe, mais deux Pokémons ne peuvent pas avoir le même nom,
        //leur nombre de points de vie est un multiple de 10, compris entre 100 et 200 et déterminé aléatoirement,
        //leur valeur d'attaque est un multiple de 10 compris entre 10 et 40 et déterminé aléatoirement,
        //leur affinité est choisie aléatoirement.
        ArrayList<Pokemon> pokemons = new ArrayList<>(41);
        for(int i = 0; i < 41; i++)
        {
            String name = m_pokemonNames.get(i);
            int hp = (int) (Math.random() * 11) * 10 + 100;
            int attack = (int) (Math.random() * 4 + 1) * 10;
            Affinity affinity = generateRandomAffinity();
            pokemons.add(new Pokemon(name, hp,attack, affinity));
        }
        // shuffle the pokemons
        Random rnd = new Random();
        for(int i = 0; i < pokemons.size(); i++)
        {
            int randomIndexToSwap = rnd.nextInt(pokemons.size());
            Pokemon temp = pokemons.get(randomIndexToSwap);
            pokemons.set(randomIndexToSwap, pokemons.get(i));
            pokemons.set(i, temp);
        }
        return pokemons;
    }
    public Affinity generateRandomAffinity()
    {
        //Génération d'une affinité aléatoire
        //Les affinités sont générées aléatoirement parmi les 3 affinités suivantes : EARTH, FIRE, WATER, AIR.
        Affinity[] affinities = {new Earth(), new Fire(), new Water(), new Air()};
        Random rnd = new Random();
        return affinities[rnd.nextInt(4)];
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
        m_currentPlayer = m_currentPlayer == m_player ? m_ai : m_player;
    }
    /**
     * Méthode pour passer au tour suivant
     */
    public void nextTurn()
    {
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
    public void showWinner()
    {
        // Affiche le gagnant
        if(m_winner == "Computer")
        {
            System.out.println("Computer wins !");
        }
        else if(m_winner == "You")
        {
            System.out.println("You win !");
        }
    }
    public void showCredits()
    {
        // Affiche les crédits
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("************************************** CREDITS **************************************");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Developed by : ");
        System.out.println("HAGGUI NESRINE AND SAIDI NIZAR");
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
