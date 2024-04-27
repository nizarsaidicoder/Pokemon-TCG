package Player;

import Pokemon.Pokemon;
import Utils.HelperFunctions;

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
        System.out.println(HelperFunctions.colorizeAndCenter("AI", "red", 100));
        m_graveyard.display();
        m_deck.display();
        m_field.display();
    }
}
