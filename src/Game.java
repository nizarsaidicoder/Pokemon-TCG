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
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Affichez un message pour indiquer le début du jeu
        System.out.println(HelperFunctions.colorizeAndCenter("LET'S DUEL !", "purple", 100));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Appelez la méthode play
        play();

    }
    public void play()
    {
        while (!isGameOver())
        {
            drawPhase();
            spawnPhase();
            attackPhase();
            endPhase();
        }
        Display.outro(m_winner);
    }

    public void drawPhase()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Draw Phase ...");
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
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Spawn Phase ...");
            Display.gameStatus(m_turn, m_currentPlayer, m_player, m_ai);
            m_currentPlayer.spawn();
        }
        m_currentPlayer.setPlayablePokemons();
    }
    public void attackPhase()
    {
        
        // tant que le joueur actuel a des pokemons jouables sur le terrain et que l'adversaire a des pokemons sur le terrain
        while(m_currentPlayer.hasPlayablePokemons() && !m_opponent.getField().isEmpty())
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Attack Phase ...");
            Display.gameStatus(m_turn, m_currentPlayer, m_player, m_ai);
            // Prompt the player to choose a pokemon to attack with
            System.out.println("Choose a pokemon to attack with");
            // Recupere le pokemon à jouer
            String pokemonName = m_scanner.nextLine();
            while(m_currentPlayer.getField().containsPokemon(pokemonName) == -1)
            {
                System.out.println("Invalid pokemon name, please enter a valid pokemon name");
                pokemonName = m_scanner.nextLine();
            }
            Pokemon pokemon = m_currentPlayer.getField().getPokemon(pokemonName);
            // Prompt the player to choose a pokemon to attack
            System.out.println("Choose a pokemon to attack");
            // Recupere le pokemon à attaquer
            String enemyPokemonName = m_scanner.nextLine();
            while(m_opponent.getField().containsPokemon(enemyPokemonName) == -1)
            {
                System.out.println("Invalid pokemon name, please enter a valid pokemon name");
                enemyPokemonName = m_scanner.nextLine();
            }
            Pokemon enemyPokemon = m_opponent.getField().getPokemon(enemyPokemonName);
            System.out.println(pokemon.getName());
            // Attaque le pokemon
            m_currentPlayer.attack(pokemon, enemyPokemon);
            if(!enemyPokemon.isAlive()) {
                // Ajoute le pokemon adverse au cimetière
                m_opponent.getGraveyard().addPokemon(enemyPokemon);
                m_opponent.getField().removePokemon(enemyPokemonName);
            }

        }
        // !!! Attention !!!
        // Il faut passer l'autre joueur en paramètre de la méthode play, pour que le joueur actuel puisse attaquer l'autre joueur
    }

    public void endPhase()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("End Phase ...");
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
            m_player = new Player(new ArrayList<>(pokemons.subList(0, 5)),1,"Marie");
            m_ai = new AI(new ArrayList<>(pokemons.subList(5,8)),2,"Computer");
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
        // Choisissez aléatoirement le premier joueur
        // Affichez un message pour indiquer qui commence
        System.out.println("Deciding who starts ...");
        // Prompt the user to press Enter to continue
        System.out.println("Heads or Tails ?");
        String choice = m_scanner.nextLine().toLowerCase();
        while(!choice.equals("heads") && !choice.equals("tails"))
        {
            System.out.println("Invalid choice, please enter Heads or Tails");
            choice = m_scanner.nextLine().toLowerCase();
        }
        Random rnd = new Random();
        int coin = rnd.nextInt(2);
        System.out.println(HelperFunctions.colorizeAndCenter("Flipping the coin ...","purple" , 100));

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if((coin == 0 && choice.equals("Heads")) || (coin == 1 && choice.equals("Tails")))
        {
            System.out.println(HelperFunctions.colorizeAndCenter("You start !", "green", 100));
            return true;
        }
        else
        {
            System.out.println(HelperFunctions.colorizeAndCenter("Computer starts !", "red", 100));
            return false;
        }
    }
    /**
     * Méthode pour basculer entre les joueurs
     */
    public void switchPlayer()
    {

        m_currentPlayer = m_currentPlayer == m_player ? m_ai : m_player;
        m_opponent = m_opponent == m_player ? m_ai : m_player;
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
