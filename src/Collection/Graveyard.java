package Collection;

// import Pokemon.*;
// import java.util.ArrayList;

import Utils.HelperFunctions;

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
        String out = " _________________________ " + "\n" +
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
