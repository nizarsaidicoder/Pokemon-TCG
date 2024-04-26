package Player;
import Others.Deck;
import Others.Field;
import Others.Graveyard;
import Others.Hand;
import Pokemon.Pokemon;

import java.util.ArrayList;

public class Player 
{
    /**
     * Attributs
     */
    protected Field m_field;
    protected Graveyard m_graveyard;
    protected Deck m_deck;
    protected Hand m_hand;
    protected int m_playerNumber;

    /*
     * Constructeur de la classe Player
     */
    public Player(int playerNumber)
    {
        // Initialise le deck, la main, le cimetière et le terrain
        // Juste pour les tests pour l'instant
        m_field = new Field();
        m_field.addPokemon(new Pokemon("Pikachu", 100, 50,50, "earth"));
        m_field.addPokemon(new Pokemon("Bulbizarre", 100, 50, 80,"fire"));
        m_field.addPokemon(new Pokemon("Salamèche", 100, 50, 100,"water"));
        m_graveyard = new Graveyard();
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon("Pikachu", 100, 50,50, "earth"));
        m_deck = new Deck(pokemons);
        pokemons.add(new Pokemon("Raikachu", 100, 50,50, "earth"));
        m_hand = new Hand(pokemons);
        m_playerNumber = playerNumber;
    }

    /*
    * Methode pour piocher une carte
    */
    public void draw()
    {
        // Pioche un pokemon dans le deck

        // Ajoute le pokemon à la main

    }

    /*
     * Methode pour attaquer un joueur
     */
    public void attack(Player enemy)
    {
    }

    /*
     * Methode pour afficher les informations du joueur (main, pioche, cimetière, terrain)
     */
    public void displayPlayer()
    {
        // Affiche le joueur
        System.out.println("Player : " + m_playerNumber);
        m_field.displayField();
        System.out.println();
        m_deck.displayDeck();
        System.out.println();
        m_graveyard.displayGraveyard();
        System.out.println();
        m_hand.displayHand();
    }

    /**
     * Retourn le numéro du joueur
     * @return numéro joueur
     */
    public int getPlayerNumber()
    {
        return m_playerNumber;
    }
}
