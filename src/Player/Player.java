package Player;
import Collection.Deck;
import Collection.Field;
import Collection.Graveyard;
import Collection.Hand;
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
    public void display()
    {
        // Affiche le joueur
        System.out.println("Player : " + m_playerNumber);
        m_field.display();
        System.out.println();
        m_deck.display();
        System.out.println();
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
}
