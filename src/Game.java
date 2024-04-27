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
        m_turn = 0;
    }

    /**
     * Méthode pour démarrer le jeu
     */
    public void start()
    {
        // appelez la méthode welcome
        Display.displayStartGame();
        // Générez les pokémons
        ArrayList<Pokemon> pokemons = generatePokemons();
        // Déterminez aléatoirement le premier joueur
        boolean firstPlayer = isFirstPlayer();
        if (firstPlayer)
        {
            m_player = new Player(new ArrayList<>(pokemons.subList(0, 2)),1,"Marie");
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
        // Affichez un message pour indiquer le début du jeu
        System.out.println("Let's DUEL !");
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
        end();
    }
    /**
     * Méthode pour terminer le jeu
     */
    public void end()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Game Over !");
        showWinner();
        showCredits();
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
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Attack Phase ...");
            showGameStatus();
            // Prompt the player to choose a pokemon to attack with
            System.out.print("Choose a pokemon to attack with : (");
            for(Pokemon pokemon : m_currentPlayer.getField().getPokemons())
            {
                if(pokemon.isPlayable()) System.out.print(pokemon.getName() + "/ ");
            }
            System.out.println(")");
            // Recupere le pokemon à jouer
            String pokemonName = m_scanner.nextLine();
            while(m_currentPlayer.getField().containsPokemon(pokemonName) == -1)
            {
                System.out.println("Invalid pokemon name, please enter a valid pokemon name");
                pokemonName = m_scanner.nextLine();
            }
            Pokemon pokemon = m_currentPlayer.getField().getPokemon(pokemonName);
            // Prompt the player to choose a pokemon to attack
            System.out.print("Choose a pokemon to attack : (");
            for(Pokemon enemyPokemon : m_opponent.getField().getPokemons())
            {
                System.out.print(enemyPokemon.getName() + "/ ");
            }
            System.out.println(")");
            // Recupere le pokemon à attaquer
            String enemyPokemonName = m_scanner.nextLine();
            while(m_opponent.getField().containsPokemon(enemyPokemonName) == -1)
            {
                System.out.println("Invalid pokemon name, please enter a valid pokemon name");
                enemyPokemonName = m_scanner.nextLine();
            }
            Pokemon enemyPokemon = m_opponent.getField().getPokemon(enemyPokemonName);
            System.out.println(pokemon.getName());

            System.out.println(" Before Attack : \nPokemon " + enemyPokemon.getName() + " has " + enemyPokemon.getHP() + "/" + enemyPokemon.getHPMax() );

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

    public void showGameStatus()
    {
        // Affiche le statut du jeu
        
        System.out.println(HelperFunctions.getColorCode("PURPLE_BACKGROUND") + HelperFunctions.center("TURN "+ m_turn,50)  + HelperFunctions.getColorCode("RESET"));
        System.out.println();

        m_ai.display();
        System.out.println();
        System.out.println(HelperFunctions.getColorCode("PURPLE_BACKGROUND") + "-----------------------------------------------------------------------------------------" + HelperFunctions.getColorCode("RESET"));
        System.out.println();
        m_player.display();
        if(m_currentPlayer == m_player)
        {
            System.out.println(HelperFunctions.getColorCode("PLAYER_BACKGROUND") + HelperFunctions.center(m_currentPlayer.getName() + "'s turn", 30)  + HelperFunctions.getColorCode("RESET"));
        }
        else
        {
            System.out.println(HelperFunctions.getColorCode("AI_BACKGROUND") + HelperFunctions.center(m_currentPlayer.getName() + "'s turn", 30)  + HelperFunctions.getColorCode("RESET"));
        }
    }
    public void showWinner()
    {
        // Affiche le gagnant
        if(m_winner.equals( "Computer"))
        {
            System.out.println("Computer wins !");
        }
        else if(m_winner.equals( "You"))
        {
            System.out.println("You win !");
        }
    }
    public void showCredits()
    {
        // Affiche les crédits
        System.out.println("************************************** CREDITS **************************************");
        System.out.println("Developed by : ");
        System.out.println("HAGGUI NESRINE AND SAIDI NIZAR");
    }
}
