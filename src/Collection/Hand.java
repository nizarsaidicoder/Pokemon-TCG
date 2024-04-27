package Collection;

import Pokemon.*;
import Utils.HelperFunctions;

import java.util.ArrayList;

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
        // _________________________
        //|                         |
        //|        HAND: 21         |
        //|_________________________|
        // |   NAME    | HP  |  TYPE  |  WEAKNESS  |  RESISTANCE  |  ATTACKS  |
        System.out.println(HelperFunctions.colorizeAndCenter("HAND", "purple", 100));
        System.out.println("POKEMON NAME         | HP                   | TYPE                 | ATTACK");
        System.out.println(HelperFunctions.colorize(HelperFunctions.padRight("", 100, '-'), "purple"));
        for(Pokemon pokemon : m_pokemons) pokemon.display();
    }
    @Override
    public String toString()
    {
        return String.format("Main : %d pokémons", m_pokemons.size());
    }
}
