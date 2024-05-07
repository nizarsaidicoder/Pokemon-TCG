package Collection;

// import Pokemon.*;
// import java.util.ArrayList;

import Pokemon.Pokemon;

import java.util.ArrayList;

public class Deck extends CardCollection
{

    /**
     * Constructeur avec paramètres
     */
    public Deck(int maxSize, ArrayList<Pokemon> pokemons)
    {
        super(maxSize);
        m_pokemons = pokemons;
        m_size = pokemons.size();

    }


    /**
     * Affichage du deck
     */
    public void display()
    {
        System.out.println(this.toString());
    }
    
    @Override 
    public String toString()
    {
        return String.format("pioche : %d pokémons", m_pokemons.size());
    }
}
