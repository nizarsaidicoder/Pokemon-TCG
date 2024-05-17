package Collection;

import Utils.UIFunctions;

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
        System.out.println(UIFunctions.colorizeAndCenter("HAND", "purple", 100));
        System.out.println("POKEMON                | HP                   | AFFINITY             | ATTACK");
        for(int i=0; i< m_pokemons.size(); i++)
        {
            System.out.print((i+1) + " ");
            m_pokemons.get(i).display();
        }
    }

    @Override
    public String toString()
    {
        return String.format("Main : %d pokémons", m_pokemons.size());
    }
}
