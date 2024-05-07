import Pokemon.*;
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
    private final Player m_player;
    private final AI m_ai;
    private Player m_currentPlayer;
    private Player m_opponent;
    private String m_winner;
    private final ArrayList<String> m_pokemonNames = new ArrayList<>(Arrays.asList("Pikachu", "Charmander", "Bulbasaur", "Squirtle", "Jigglypuff", "Mewtwo", "Gengar", "Eevee", "Snorlax", "Dragonite", "Mew", "Gyarados", "Vaporeon", "Flareon", "Jolteon", "Articuno", "Zapdos", "Moltres", "Ditto", "Machamp", "Alakazam", "Blastoise", "Venusaur", "Raichu", "Sandslash", "Nidoking", "Nidoqueen", "Clefable", "Ninetales", "Wigglytuff", "Vileplume", "Parasect", "Venomoth", "Dugtrio", "Persian", "Golduck", "Primeape", "Arcanine", "Poliwrath", "Victreebel", "Tentacruel", "Golem", "Rapidash", "Slowbro", "Magneton", "Farfetch'd", "Dodrio", "Dewgong"));
    private int m_turn;
    private Scanner m_scanner = new Scanner(System.in);


    /**
     * Constructeur de la classe Game
     */
    public Game()
    {
        // Initialise les attributs de la classe
        m_winner = null;
        m_turn = 1;
        m_turn = 99;
        m_pokemons = createPokemons();
    }

    public static int getRandom(int min, int max) {

        int range = (max - min) + 1;
         int random = (int) ((range * Math.random()) + min);
        return random;
    }

    public ArrayList<Pokemon> createPokemons()
    {
        ArrayList<String> namesPokemons = new ArrayList<>(Arrays.asList("Pikachu", "Salamèche", "Carapuce", "Herbizarre"));
        ArrayList<Pokemon> pokemons = new ArrayList<>();

        for(String pokemon : namesPokemons)
        {
            int hp = getRandom(100, 200);
            while(hp % 10 != 0)
            {
                hp = getRandom(100, 200);
            }

            int attack = getRandom(10, 40);
            while(attack % 10 != 0)
            {
                attack = getRandom(10, 40);
            }

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
        
        return pokemons;
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
     * Méthode pour passer à la phase suivante
     */
    public void endPhase()
    {
        // Phase de fin
        // Passez au joueur suivant et incrémentez le tour
        m_currentPlayer = m_currentPlayer == m_player ? m_ai : m_player;
        m_opponent = m_opponent == m_player ? m_ai : m_player;
        m_turn++;
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
        // Pour chaque nom de Pokémon, générez un Pokémon avec un nom, des points de vie, une valeur d'attaque et une affinité aléatoires
        //leur nombre de points de vie est un multiple de 10, compris entre 100 et 200 et déterminé aléatoirement,
        //leur valeur d'attaque est un multiple de 10 compris entre 10 et 40 et déterminé aléatoirement,
        //leur affinité est choisie aléatoirement. ! Appel de la méthode generateRandomAffinity()
        // SCHUFFLE AND RETURN THE LIST
    }
    /**
     * Méthode pour générer une affinité aléatoire
     * @return une affinité aléatoire
     */
    public Affinity generateRandomAffinity()
    {
        //Génération d'une affinité aléatoire
        //Les affinités sont générées aléatoirement parmi les 4 affinités suivantes : EARTH, FIRE, WATER, AIR.
        Affinity[] affinities = {new Earth(), new Fire(), new Water(), new Air()};
        Random rnd = new Random();
        return affinities[rnd.nextInt(4)];
    }
    /**
     * Méthode pour déterminer le premier joueur
     * @return true si le joueur commence, false sinon
     */
    public boolean isFirstPlayer()
    {
        System.out.println(HelperFunctions.colorizeAndCenter("Deciding who starts ...", "purple", 100));
        // Prompt the user to press Enter to continue
        System.out.print(HelperFunctions.colorize("Heads or Tails ? :  ","yellow"));
        String choice = m_scanner.nextLine().toLowerCase();
        System.out.println();
        while(!choice.equals("heads") && !choice.equals("tails"))
        {
            System.out.println(HelperFunctions.colorize("Invalid choice, please enter Heads or Tails ? : ", "red"));
            choice = m_scanner.nextLine().toLowerCase();
            System.out.println();
        }
        Random rnd = new Random();
        int coin = rnd.nextInt(2) + 1;
        return (coin == 1 && choice.equals("heads")) || (coin == 2 && choice.equals("tails"));
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
