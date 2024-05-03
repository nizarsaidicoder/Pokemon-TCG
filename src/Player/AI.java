package Player;

import Pokemon.Pokemon;

import java.util.ArrayList;

public class AI extends Player
{
    /**
     * Constructeur de la classe AI
     */
    public AI (ArrayList<Pokemon> pokemons, int playerNumber)
    {
        // Initialise le deck, la main, le cimetière et le terrain
        // Juste pour les tests pour l'instant
        super(pokemons,playerNumber);
    }

    @Override
    public void display()
    {
        // Affiche le joueur
        System.out.println("Player : " + m_playerNumber);
        m_field.display();
        System.out.println();
        m_deck.display();
        System.out.println();
        m_graveyard.display();
    }
}
