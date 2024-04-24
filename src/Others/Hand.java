package Others;

import Pokemon.*;

import java.util.ArrayList;

public class Hand 
{
    private ArrayList<Pokemon> m_pokemons;
    //constructeur
    public Hand()
    {
        m_pokemons= new ArrayList<>();
    }

    public Hand(ArrayList<Pokemon> pokemons)
    {
        m_pokemons = pokemons;
    }

    public void addPokemon(Pokemon pokemon)
    {
        m_pokemons.add(pokemon);
    }

    //affichage de la main
    public void displayHand()
    {
        System.out.println("En main : ");
        for(Pokemon pokemon : m_pokemons)
        {
            System.out.println(String.format(" - %s", pokemon.toString()));
        }
    }
}
