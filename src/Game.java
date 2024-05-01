import Player.Player;
import Player.AI;
import Pokemon.*;
import Utils.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;


public class Game
{
    private Player m_player;
    private AI m_ai;
    private Player m_currentPlayer;
    private Player m_opponent;
    private String m_winner;
    private ArrayList<String> m_pokemonNames;
    private int m_turn;
    private Scanner m_scanner = new Scanner(System.in);


    /**
     * Constructeur de la classe Game
     */
    public Game()
    {
        // Initialise les attributs de la classe
        m_pokemonNames = new ArrayList<>(Arrays.asList("Pikachu", "Charmander", "Bulbasaur", "Squirtle", "Jigglypuff", "Mewtwo", "Gengar", "Eevee", "Snorlax", "Dragonite", "Mew", "Gyarados", "Vaporeon", "Flareon", "Jolteon", "Articuno", "Zapdos", "Moltres", "Ditto", "Machamp", "Alakazam", "Blastoise", "Venusaur", "Raichu", "Sandslash", "Nidoking", "Nidoqueen", "Clefable", "Ninetales", "Wigglytuff", "Vileplume", "Parasect", "Venomoth", "Dugtrio", "Persian", "Golduck", "Primeape", "Arcanine", "Poliwrath", "Victreebel", "Tentacruel", "Golem", "Rapidash", "Slowbro", "Magneton", "Farfetch'd", "Dodrio", "Dewgong"));
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

    public void drawPhase()
    {
        Display.drawPhase();
        // tant que la main du joueur actuel est vide et que le deck du joueur actuel n'est pas vide
        while(!m_currentPlayer.getHand().isFull() && !m_currentPlayer.getDeck().isEmpty())
        {
            m_currentPlayer.draw();
        }
    }
    public void spawnPhase()
    {
        // tant que le joueur actuel a des cartes en main et que le terrain n'est pas plein
        while(!m_currentPlayer.getHand().isEmpty() && !m_currentPlayer.getField().isFull())
        {
            Display.gameStatus(m_turn, m_currentPlayer, m_player, m_ai);
            Display.spawnPhase();
            m_currentPlayer.spawn();
        }
        m_currentPlayer.setPlayablePokemons();
    }
    public void battlePhase()
    {
        
        // tant que le joueur actuel a des pokemons jouables sur le terrain et que l'adversaire a des pokemons sur le terrain
        while(m_currentPlayer.hasPlayablePokemons() && !m_opponent.getField().isEmpty())
        {
            Display.gameStatus(m_turn, m_currentPlayer, m_player, m_ai);
            Display.battlePhase();
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
    public void intializePlayers()
    {
        // Générez les pokémons
        // Déterminez aléatoirement le premier joueur
        ArrayList<Pokemon> pokemons = generatePokemons();
        boolean firstPlayer = isFirstPlayer();
        if (firstPlayer)
        {
            m_player = new Player(new ArrayList<>(pokemons.subList(0, 20)),1,"Marie");
            m_ai = new AI(new ArrayList<>(pokemons.subList(20,41)),2,"Computer");
            m_currentPlayer = m_player;
            m_opponent = m_ai;
        }
        else
        {
            m_player = new Player(new ArrayList<>(pokemons.subList(20,41)),2,"Marie");
            m_ai = new AI(new ArrayList<>(pokemons.subList(0, 20)),1,"Computer");
            m_currentPlayer = m_ai;
            m_opponent = m_player;
        }
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
            int attack = (int) (Math.random() * 4 + 1) * 10 + 100;
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
        System.out.println(HelperFunctions.colorizeAndCenter("Deciding who starts ...", "purple", 100));
        // Prompt the user to press Enter to continue
        System.out.print(HelperFunctions.colorize("(H)eads or (T)ails ? :  ","yellow"));
        String choice = m_scanner.nextLine().toLowerCase();
        System.out.println();
        while(!choice.equals("heads") && !choice.equals("tails") && !choice.equals("h") && !choice.equals("t"))
        {
            System.out.println(HelperFunctions.colorize("Invalid choice, please enter (H)eads or (T)ails ? : ", "red"));
            choice = m_scanner.nextLine().toLowerCase();
            System.out.println();
        }
        Random rnd = new Random();
        int coin = rnd.nextInt(2) + 1;
        return ((coin == 1 && (choice.equals("heads") ||choice.equals("h"))) || ((coin == 2 && (choice.equals("tails") || choice.equals("t")))));
    }
    /**
     * Méthode pour basculer entre les joueurs
     */
    public void switchPlayer()
    {
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
}
