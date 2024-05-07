package Collection;

import Pokemon.*;

// import java.util.ArrayList;

public class Hand extends CardCollection {

    /**
     * Constructeur
     */
    public Hand(int maxSize)
    {
        super(maxSize);
    }

    @Override

    public void display()
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
