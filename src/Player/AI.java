package Player;

import Others.Deck;
import Others.Field;
import Others.Graveyard;
import Others.Hand;
import Pokemon.Pokemon;

import java.util.ArrayList;

public class AI extends Player {
    public AI ()
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
    @Override
    public void displayPlayer()
    {
        // Affiche le joueur
        System.out.println("Player : " + m_playerNumber);
        showDeck();
        showGraveyard();
        showField();
    }
}
