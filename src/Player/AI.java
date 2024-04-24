package Player;

import Others.Deck;
import Others.Field;
import Others.Graveyard;
import Others.Hand;
import Pokemon.Pokemon;

import java.util.ArrayList;

public class AI extends Player {
    /**
     * Constructeur de la classe AI
     */
    public AI (int playerNumber)
    {
        // Initialise le deck, la main, le cimetière et le terrain
        // Juste pour les tests pour l'instant
        super(playerNumber);
    }
    @Override
    public void displayPlayer()
    {
        // Affiche le joueur
        System.out.println("Player : " + m_playerNumber);
        m_field.displayField();
        System.out.println();
        m_deck.displayDeck();
        System.out.println();
        m_graveyard.displayGraveyard();
    }
}
