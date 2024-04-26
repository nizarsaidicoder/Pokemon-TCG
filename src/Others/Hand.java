package Others;

import Pokemon.*;

import java.util.ArrayList;

public class Hand 
{
    /**
     * Attributs
     */
    private ArrayList<Pokemon> m_pokemons;

    /**
     * Constructeur
     */
    public Hand()
    {
        m_pokemons= new ArrayList<>();
    }

    /**
     * Constructeur avec paramètres
     * @param pokemons
     */
    public Hand(ArrayList<Pokemon> pokemons)
    {
        m_pokemons = pokemons;
    }

    /**
     * Ajoute un pokemon à notre main
     * @param pokemon
     */
    public void addPokemon(Pokemon pokemon)
    {
        m_pokemons.add(pokemon);
    }

    /**
     * Affichage de la main
     */
    public void displayHand()
    {
        System.out.println("En main : ");
        for(Pokemon pokemon : m_pokemons)
        {
            System.out.println(String.format(" - %s", pokemon.toString()));
        }
    }

    @Override
    public String toString()
    {
        return String.format("Main : %d pokémons", m_pokemons.size());
    }
}
