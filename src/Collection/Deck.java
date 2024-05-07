package Collection;

// import Pokemon.*;
// import java.util.ArrayList;

import Pokemon.Pokemon;
import Utils.HelperFunctions;

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
        // _________________________
        //|        DECK: 21         |
        //|_________________________|
        String out = " _________________________ " + "\n" +
                "|        DECK: " + HelperFunctions.padLeft(Integer.toString(m_size),2,'0') + "         |" + "\n" +
                "|_________________________|";
        out = HelperFunctions.colorize(out, "blue");
        System.out.println(out);
    }
    
    @Override 
    public String toString()
    {
        return String.format("pioche : %d pokémons", m_pokemons.size());
    }
}
