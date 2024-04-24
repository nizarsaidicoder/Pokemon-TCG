package Player;
import Others.Deck;
import Others.Field;
import Others.Graveyard;
import Others.Hand;
import Pokemon.Pokemon;

public class Player {
    private Field m_field;
    private Graveyard m_graveyard;
    private Deck m_deck;
    private Hand m_hand;
    private int m_playerNumber;
    public Player()
    {
        // Initialise le deck, la main, le cimetière et le terrain
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

    public void showDeck()
    {
        // Affiche le deck
    }
    public void showGraveyard()
    {
        // Affiche le cimetière
    }
    public void showField()
    {
        // Affiche le terrain
    }
    public void showHand()
    {
        // Affiche la main
    }



}
