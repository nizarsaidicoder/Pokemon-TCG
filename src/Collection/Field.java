package Collection;

import Utils.HelperFunctions;

public class Field extends CardCollection {

    /*
     * Constructeur de la classe Field
     */
    public Field(int maxSize)
    {
        super(maxSize);
    }

    /*
     * Methode pour afficher les pokemons sur le terrain
     */
    @Override
    public void display()
    {

        String RESET = "\033[0m";  // Text Color Reset
        for(int i = 0; i < 3; i++)
        {
            System.out.print(" ____________________ ");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            System.out.print("|                    |");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            if(i > m_pokemons.size() - 1)
            {
                System.out.print("|                    |");
                System.out.print("\t\t");
            }
            else
            {
                String foreColor = HelperFunctions.getCorrespondingColor(m_pokemons.get(i).getAffinity().getElement());
                System.out.print(HelperFunctions.padRight("| ("+(i+1)+") " + foreColor + m_pokemons.get(i).getName(),26)+ RESET+ "|");
                System.out.print("\t\t");
            }
        }
        System.out.println();

        for(int i = 0; i < 3; i++)
        {
            System.out.print("|____________________|");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            System.out.print("|                    |");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i=0;i<3;i++)
        {
            if(m_pokemons.size() > i)
            {
                System.out.print(HelperFunctions.padRight("| Attack: " + Integer.toString(m_pokemons.get(i).getAttack()),21) + "|");
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                    |");
                System.out.print("\t\t");
            }
            
        }
        System.out.println();

        for(int i = 0; i < 3; i++)
        {
            if(m_pokemons.size() > i)
            {
                System.out.print(HelperFunctions.padRight("| HP: " + Integer.toString(m_pokemons.get(i).getHP()),21) + "|");
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                    |");
                System.out.print("\t\t");
            }
        }
        System.out.println();

        for(int i = 0; i < 3; i++)
        {
            if(m_pokemons.size() > i)
            {
                String foreColor = HelperFunctions.getCorrespondingColor(m_pokemons.get(i).getAffinity().getElement());
                System.out.print(HelperFunctions.padRight("| Affinity : " + foreColor + m_pokemons.get(i).getAffinity().getElement(),26) + RESET + "|");
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                    |");
                System.out.print("\t\t");
            }
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            if(m_pokemons.size() > i)
            {
                String foreColor = HelperFunctions.getCorrespondingColor(m_pokemons.get(i).getAffinity().getStrenght());
                System.out.print(HelperFunctions.padRight("| Strength : " + foreColor + m_pokemons.get(i).getAffinity().getStrenght(), 26) + RESET + "|");
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                    |");
                System.out.print("\t\t");
            }
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            if(m_pokemons.size() > i)
            {
                String foreColor = HelperFunctions.getCorrespondingColor(m_pokemons.get(i).getAffinity().getWeakness());
                System.out.print(HelperFunctions.padRight("| Weakness : " + foreColor + m_pokemons.get(i).getAffinity().getWeakness(), 26) + RESET + "|");
                System.out.print("\t\t");
            }
            else
            {
                System.out.print("|                    |");
                System.out.print("\t\t");
            }
        }
        System.out.println();

        for(int i = 0; i < 3; i++)
        {
            System.out.print("|____________________|");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i = 0; i < 3; i++)
        {
            System.out.print("\\____________________/");
            System.out.print("\t\t");
        }
        System.out.println();
    }
}
