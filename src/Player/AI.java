package Player;

import Pokemon.Pokemon;

import java.util.ArrayList;

public class AI extends Player
{
    /**
     * Constructeur de la classe AI
     */
    public AI (ArrayList<Pokemon> pokemons, int playerNumber, String name)
    {
        // Initialise le deck, la main, le cimetière et le terrain
        // Juste pour les tests pour l'instant
        super(pokemons,playerNumber,name);
    }

    @Override
    public void display()
    {
        // Affiche le joueur
        System.out.println("Player : " + m_name);
        m_field.display();
        m_deck.display();
        m_graveyard.display();
    }
}
