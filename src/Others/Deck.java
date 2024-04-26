package Others;

import Pokemon.*;
import java.util.ArrayList;

public class Deck
{
    /**
     * Attributs
     */
    private ArrayList<Pokemon> m_pokemons;

    /**
     * Constructeur avec paramètres
     * @param pokemons
     */
    public Deck(ArrayList<Pokemon> pokemons)
    {
        m_pokemons = pokemons;
    }

    /**
     * Pioche une carte du deck
     * @param pokemon
     * @return un pokémon (une carte)
     */
    public Pokemon drawPokemon()
    {
        return m_pokemons.get(0);
    }

    /**
     * Affichage du deck
     */
    public void displayDeck()
    {
        System.out.println(this.toString());
    }
    
    @Override 
    public String toString()
    {
        return String.format("pioche : %d pokémons", m_pokemons.size());
    }
}
