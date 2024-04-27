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

    /*
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

    /*
     * Methode pour piocher une carte
     */
    public void draw()
    {
        // Pioche un pokemon dans le deck
//        for(Pokemon pokemon : m_deck.getPokemons())
//        {
//            pokemon.display();
//        }
        Pokemon pokemon = m_deck.pickPokemon(0);
        // Ajoute le pokemon à la main
        m_hand.addPokemon(pokemon);
    }
    public void spawn()
    {
        // Prompt the player to choose a pokemon to spawn from the hand
        System.out.print("Choose a pokemon to spawn : ( ");
        for(Pokemon pokemon : m_hand.getPokemons())
        {
            System.out.print(pokemon.getName() + "/");
        }
        System.out.println(")");
        // Recupere le pokemon à jouer
        String pokemonName = m_scanner.nextLine();
        // check if the player entered a valid pokemon name
        while(m_hand.containsPokemon(pokemonName) == -1)
        {
            System.out.println("Invalid pokemon name, please enter a valid pokemon name");
            pokemonName = m_scanner.nextLine();
        }
        // Ajoute un pokemon du terrain
        m_field.addPokemon(m_hand.pickPokemon(pokemonName));
    }
    /*
     * Methode pour attaquer un joueur
     */
    public void attack(Pokemon playerPokemon, Pokemon enemyPokemon)
    {
        // Attaque le pokemon adverse
        playerPokemon.attack(enemyPokemon);
        playerPokemon.setPlayable(false);
    }
    public void setPlayablePokemons()
    {
        // Parcourt la main et met à jour les pokemons jouables
        for(Pokemon pokemon : m_field.getPokemons())
        {
            pokemon.setPlayable(true);
        }
    }
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
        System.out.println();
        m_hand.display();
    }

    /**
     * Retourn le numéro du joueur
     * @return numéro joueur
     */
    public int getPlayerNumber()
    {
        return m_playerNumber;
    }
    public String getName(){return m_name;}
    public Field getField()
    {
        return m_field;
    }
    public Deck getDeck()
    {
        return m_deck;
    }
    public Hand getHand()
    {
        return m_hand;
    }
    public Graveyard getGraveyard()
    {
        return m_graveyard;
    }

}
