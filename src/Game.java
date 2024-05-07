import Pokemon.*;
import Player.Player;
import Player.AI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import Utils.HelperFunctions;

public class Game
{
    private Player m_player;
    private AI m_ai;
    private Player m_currentPlayer;
    private Player m_opponent;
    private String m_winner;
    private final ArrayList<String> m_pokemonNames = new ArrayList<>(Arrays.asList("Pikachu", "Charmander", "Bulbasaur", "Squirtle", "Jigglypuff", "Mewtwo", "Gengar", "Eevee", "Snorlax", "Dragonite", "Mew", "Gyarados", "Vaporeon", "Flareon", "Jolteon", "Articuno", "Zapdos", "Moltres", "Ditto", "Machamp", "Alakazam", "Blastoise", "Venusaur", "Raichu", "Sandslash", "Nidoking", "Nidoqueen", "Clefable", "Ninetales", "Wigglytuff", "Vileplume", "Parasect", "Venomoth", "Dugtrio", "Persian", "Golduck", "Primeape", "Arcanine", "Poliwrath", "Victreebel", "Tentacruel", "Golem", "Rapidash", "Slowbro", "Magneton", "Farfetch'd", "Dodrio", "Dewgong"));
    private int m_turn;


    /**
     * Constructeur de la classe Game
     */
    public Game()
    {
        // Initialise les attributs de la classe
        m_winner = null;
        m_turn = 1;
    }
    /**
     * Méthode pour démarrer le jeu
     */
    public void start()
    {
        // appelez la méthode welcome
        Display.intro();
        // Appelez la méthode initializePlayers
        intializePlayers();
        Display.coinFlip(m_player);
        // Appelez la méthode play
        play();

    }

    /**
     * Méthode pour jouer le jeu
     */
    public void play()
    {
        while (!isGameOver())
        {
            drawPhase();
            spawnPhase();
            battlePhase();
            endPhase();
        }
        Display.outro(m_winner);
    }

    /**
     * La phase de pioche où le joueur actuel pioche des cartes
     */
    public void drawPhase()
    {
        // tant que la main du joueur actuel est vide et que le deck du joueur actuel n'est pas vide
        while(!m_currentPlayer.getHand().isFull() && !m_currentPlayer.getDeck().isEmpty())
        {
            m_currentPlayer.draw();
        }
    }

    /**
     * La phase d'invocation où le joueur actuel invoque des pokémons
     */
    public void spawnPhase()
    {
        // tant que le joueur actuel a des cartes en main et que le terrain n'est pas plein
        while(!m_currentPlayer.getHand().isEmpty() && !m_currentPlayer.getField().isFull())
        {
            Display.gameStatus(m_turn, m_currentPlayer, m_player, m_ai);
            Display.spawnPhase();
            m_currentPlayer.spawn();
        }
        // Mettez à jour les pokémons jouables du joueur actuel
        m_currentPlayer.setPlayablePokemons();
    }
    /**
     * La phase de bataille est une phase où le joueur actuel attaque l'adversaire
     */
    public void battlePhase()
    {
        
        // tant que le joueur actuel a des pokemons jouables sur le terrain et que l'adversaire a des pokemons sur le terrain
        while(m_currentPlayer.hasPlayablePokemons() && !m_opponent.getField().isEmpty())
        {
            Display.gameStatus(m_turn, m_currentPlayer, m_player, m_ai);
            Display.battlePhase();
            m_currentPlayer.attack(m_opponent);
        } 
    }
    /**
     * La phase de fin où le joueur actuel passe au joueur suivant
     */
    public void endPhase()
    {
        // Passez au joueur suivant et incrémentez le tour
        if(m_currentPlayer == m_player)
        {
            m_currentPlayer = m_ai;
            m_opponent = m_player;
        }
        else
        {
            m_currentPlayer = m_player;
            m_opponent = m_ai;
        }
        m_turn++;
    }
    /**
     * Méthode pour initialiser les joueurs
     */
    public void intializePlayers()
    {
        // Générez les pokémons
        // Déterminez aléatoirement le premier joueur
        ArrayList<Pokemon> pokemons = createPokemons();
        String playerName = promptUserName();
        boolean firstPlayer = isFirstPlayer();
        if (firstPlayer)
        {
            m_player = new Player(new ArrayList<>(pokemons.subList(0, 3)),1,playerName);
            m_ai = new AI(new ArrayList<>(pokemons.subList(20,41)),2);
            m_currentPlayer = m_player;
            m_opponent = m_ai;
        }
        else
        {
            m_player = new Player(new ArrayList<>(pokemons.subList(20,41)),2,playerName);
            m_ai = new AI(new ArrayList<>(pokemons.subList(0, 3)),1);
            m_currentPlayer = m_ai;
            m_opponent = m_player;
        }
    }
    /**
     * Méthode pour créer les pokémons
     * @return une liste de pokémons ordonnée aléatoirement
     */
    public ArrayList<Pokemon> createPokemons()
    {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        for(String pokemon : m_pokemonNames)
        {
            int hp = getRandom(1, 20) * 10;
            int attack = getRandom(1, 4) * 10 ;
            Element[] allElements = Element.values();
            int i = getRandom(0, allElements.length - 1);

            Affinity affinity;

            switch(allElements[i])
            {
                case FIRE:
                    affinity = new Fire();
                    break;
                case WATER:
                    affinity = new Water();
                    break;
                case EARTH:
                    affinity = new Earth();
                    break;
                case AIR:
                    affinity = new Air();
                    break;
                default:
                    affinity = new Fire();
                    break;
            }

            Pokemon p = new Pokemon(pokemon, hp, attack, affinity);

            pokemons.add(p);
        }
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
    /**
     * Méthode pour déterminer le premier joueur
     * @return true si le joueur commence, false sinon
     */
    public boolean isFirstPlayer()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(HelperFunctions.colorizeAndCenter("Deciding who starts ...", "purple", 100));
        // Prompt the user to press Enter to continue
        System.out.print(HelperFunctions.colorize("(H)eads or (T)ails ? :  ","yellow"));
        String choice = scanner.nextLine().toLowerCase();
        System.out.println();
        while(!choice.equals("heads") && !choice.equals("tails") && !choice.equals("h") && !choice.equals("t"))
        {
            System.out.println(HelperFunctions.colorize("Invalid choice, please enter (H)eads or (T)ails ? : ", "red"));
            choice = scanner.nextLine().toLowerCase();
            System.out.println();
        }
        Random rnd = new Random();
        int coin = rnd.nextInt(2) + 1;
        return ((coin == 1 && (choice.equals("heads") ||choice.equals("h"))) || ((coin == 2 && (choice.equals("tails") || choice.equals("t")))));
    }
    public String promptUserName()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(HelperFunctions.colorize("Enter your name: ", "yellow"));
        return scanner.nextLine();
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
     * Méthode pour obtenir un nombre aléatoire entre min et max
     * @param min le nombre minimum
     * @param max le nombre maximum
     * @return un nombre aléatoire entre min et max
     */

    public static int getRandom(int min, int max) {

        int range = (max - min) + 1;
        int random = (int) ((range * Math.random()) + min);
        return random;
    }
}
