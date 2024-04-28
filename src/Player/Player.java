package Player;

import Collection.Deck;
import Collection.Field;
import Collection.Graveyard;
import Collection.Hand;
import Pokemon.Pokemon;
import Utils.HelperFunctions;

import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    /**
     * Attributs
     */
    protected String m_name;
    protected Field m_field;
    protected Graveyard m_graveyard;
    protected Deck m_deck;
    protected Hand m_hand;
    protected int m_playerNumber;
    private Scanner m_scanner = new Scanner(System.in);

    /**
     * Constructeur de la classe Player
     */
    public Player(ArrayList<Pokemon> pokemons,int playerNumber,String name)
    {
        // Initialise le deck, la main, le cimetière et le terrain
        m_field = new Field(3);
        m_graveyard = new Graveyard(6);
        m_deck = new Deck(6,pokemons);
        m_hand = new Hand(5);
        m_playerNumber = playerNumber;
        m_name = name;
    }

    /**
     * Pioche un pokemon dans le deck et l'ajoute à la main
     */
    public void draw()
    {
        Pokemon pokemon = m_deck.pickPokemon(0);
        m_hand.addPokemon(pokemon);
    }
    /**
     * Methode pour placer un pokemon sur le terrain
     */
    public void spawn()
    {
        // Prompt the player to choose a pokemon to spawn from the hand
        System.out.print(HelperFunctions.colorize("Choose a pokemon to spawn : ", "blue"));
        // Recupere le pokemon à jouer
        int index = -1;
        // check if the player entered a valid pokemon index
        while(index == -1)
        {
            try
            {
                index = Integer.parseInt(m_scanner.nextLine()) -1;
                if(index < 0 || index >= m_hand.getPokemons().size())
                {
                    System.out.println(HelperFunctions.colorize("Invalid index, please enter a valid index", "red"));
                    index = -1;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println(HelperFunctions.colorize("Invalid index, please enter a valid index", "red"));
            }
        }
        // Ajoute un pokemon du terrain
        m_field.addPokemon(m_hand.pickPokemon(index));
    }
    /**
     * Attaquer un joueur
     * @param opponent joueur adverse
     */
    public void attack(Player opponent)
    {
        // Demande au joueur de choisir un pokemon à attaquer avec
        Pokemon pokemon = promptPokemon();
        // Demande au joueur de choisir un pokemon à attaquer
        Pokemon enemyPokemon = promptEnemyPokemon(opponent);
        // Attaque le pokemon
        pokemon.attack(enemyPokemon);
        pokemon.setPlayable(false);
        if(!enemyPokemon.isAlive()) 
        {
            // Ajoute le pokemon adverse au cimetière s'il est mort
            opponent.getGraveyard().addPokemon(enemyPokemon);
            opponent.getField().removePokemon(enemyPokemon);
        }
    }
    /**
     * Donne à chaque pokemon du joueur dans le terrain la possibilité d'attaquer
     */
    public void setPlayablePokemons()
    {
        // Parcourt la main et met à jour les pokemons jouables
        for(Pokemon pokemon : m_field.getPokemons())
        {
            pokemon.setPlayable(true);
        }
    }
    /**
     * Methode pour savoir si le joueur a des pokemons jouables dans le terrain
     * @return true si le joueur a des pokemons jouables, false sinon
     */
    public boolean hasPlayablePokemons()
    {
        ArrayList<Pokemon> playablePokemons = new ArrayList<>();
        for(Pokemon pokemon : m_field.getPokemons())
        {
            if(pokemon.isPlayable())
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Methode pour recuperer les pokemons jouables du joueur dans le terrain
     * @return liste des pokemons jouables
     */
    public ArrayList<Pokemon> getPlayablePokemons()
    {
        ArrayList<Pokemon> playablePokemons = new ArrayList<>();
        for(Pokemon pokemon : m_field.getPokemons())
        {
            if(pokemon.isPlayable())
            {
                playablePokemons.add(pokemon);
            }
        }
        return playablePokemons;
    }
    /*
     * Methode pour savoir si le joueur est vaincu
     * @return true si le joueur est vaincu, false sinon
     */
    public boolean isDefeated()
    {
        return m_field.isEmpty() && m_hand.isEmpty() && m_deck.isEmpty();
    }
    /**
     * Demande au joueur de choisir un pokemon à attaquer avec
     * @return
     */
    public Pokemon promptPokemon()
    {
        // Demande au joueur de choisir un pokemon à attaquer avec
        System.out.print("Choose a pokemon to attack with : ( ");
        for(int i= 0; i < m_field.getPokemons().size(); i++)
        {
            if(m_field.getPokemon(i).isPlayable()) System.out.print(m_field.getPokemon(i).getName() + "(" + (i+1) + ") ");
        }
        System.out.print(" ) : ");
        // Recupere le pokemon à jouer
        int index = -1;
        while(index == -1)
        {
            try
            {
                index = Integer.parseInt(m_scanner.nextLine()) -1;
                // Si l'index est invalide on demande à l'utilisateur de rentrer un index valide
                if(index < 0 || index >= m_field.getPokemons().size() || !m_field.getPokemon(index).isPlayable())
                {
                    System.out.println(HelperFunctions.colorize("Invalid index, please enter a valid index","red"));
                    index = -1;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println(HelperFunctions.colorize("Invalid index, please enter a valid index","red"));
            }
        }
        return m_field.getPokemons().get(index); 
    }
    /**
     * Demande au joueur de choisir un pokemon à attaquer
     * @param opponent joueur adverse
     * @return pokemon à attaquer
     */
    public Pokemon promptEnemyPokemon(Player opponent)
    {
        // Demande au joueur de choisir un pokemon à attaquer
        System.out.println("Choose a pokemon to attack : ( ");
        for(int i = 0; i < opponent.getField().getPokemons().size(); i++)
        {
            System.out.print(opponent.getField().getPokemon(i).getName() + " (" +  (i+1) + ") ");
        }
        System.out.print("): ");
        // Recupere le pokemon à attaquer
        int index = -1;
        while(index == -1)
        {
            try
            {
                index = Integer.parseInt(m_scanner.nextLine()) -1;
                // Si l'index est invalide on demande à l'utilisateur de rentrer un index valide
                if(index < 0 || index >= opponent.getField().getPokemons().size())
                {
                    System.out.println(HelperFunctions.colorize("Invalid index, please enter a valid index","red"));
                    index = -1;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println(HelperFunctions.colorize("Invalid index, please enter a valid index","red"));
            }
        }
        return opponent.getField().getPokemon(index); 
    }
    /*
     * Methode pour afficher les informations du joueur (main, pioche, cimetière, terrain)
     */
    public void display()
    {
        // Affiche le joueur
        System.out.println(HelperFunctions.colorizeAndCenter(m_name, "blue", 100));
        m_field.display();
        m_deck.display();
        m_graveyard.display();
        m_hand.display();
        System.out.println();
    }

    /**
     * Retourn le numéro du joueur
     * @return numéro joueur
     */
    public int getPlayerNumber()
    {
        return m_playerNumber;
    }
    /**
     * Retourne le nom du joueur
     * @return nom du joueur
     */
    public String getName()
    {
        return m_name;
    }
    /**
     * Retourne le terrain du joueur
     * @return terrain du joueur
     */
    public Field getField()
    {
        return m_field;
    }
    /**
     * Retourne la main du joueur
     * @return main du joueur
     */
    public Deck getDeck()
    {
        return m_deck;
    }
    /**
     * Retourne la main du joueur
     * @return main du joueur
     */
    public Hand getHand()
    {
        return m_hand;
    }
    /**
     * Retourne le cimetière du joueur
     * @return cimetière du joueur
     */
    public Graveyard getGraveyard()
    {
        return m_graveyard;
    }

}
