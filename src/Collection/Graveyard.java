package Collection;

import Pokemon.*;
import Utils.HelperFunctions;

import java.util.ArrayList;

public class Graveyard  extends CardCollection
{
    /**
     * Constructeur
     */
    public Graveyard(int maxSize)
    {
        super(maxSize);
    }
    /**
     * Affichage de la défausse
     */
    @Override
    public void display()
    {
        // _________________________
        //|                         |
        //|      GRAVEYARD: 21      |
        //|_________________________|

        String out = " _________________________ " + "\n" +
                    "|                         |" + "\n" +
                    "|      GRAVEYARD: " + HelperFunctions.padLeft(Integer.toString(m_size),2,'0') + "      |" + "\n" +
                    "|_________________________|";
        out = HelperFunctions.colorize(out, "red");
        System.out.println(out);
    }
    
    @Override 
    public String toString()
    {
        return String.format("défausse : %d pokémons", m_pokemons.size());
    }
}
