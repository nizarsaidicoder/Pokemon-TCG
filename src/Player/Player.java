package Player;
import Others.Deck;
import Others.Field;
import Others.Graveyard;
import Others.Hand;
import Pokemon.Pokemon;

import java.util.ArrayList;

public class Player {
    protected Field m_field;
    protected Graveyard m_graveyard;
    protected Deck m_deck;
    protected Hand m_hand;
    protected int m_playerNumber;
    
    public Player()
    {
        // Initialise le deck, la main, le cimetière et le terrain
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
    }
    public void draw()
    {
        // Pioche un pokemon dans le deck

        // Ajoute le pokemon à la main

    }
    public void attack(Player enemy)
    {
        //
    }
    public void displayPlayer()
    {
        // Affiche le joueur
        System.out.println("Player : " + m_playerNumber);
        showField();
        showDeck();
        showGraveyard();
        showHand();
    }

    public void showDeck()
    {
        // Affiche le deck
        m_deck.displayDeck();
    }
    public void showGraveyard()
    {
        // Affiche le cimetière
        m_graveyard.displayGraveyard();
    }
    public void showField()
    {
        // Affiche le terrain
        m_field.displayField();
    }
    public void showHand()
    {
        // Affiche la main
        m_hand.displayHand();
    }



}
