package Collection;
import java.util.ArrayList;
import Pokemon.Pokemon;
import Utils.UIFunctions;

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
        String out = " _________________________ " + "\n" +
                "|        DECK: " + UIFunctions.padLeft(Integer.toString(m_size),2,'0') + "         |" + "\n" +
                "|_________________________|";
        out = UIFunctions.colorize(out, "blue");
        System.out.println(out);
    }
    
    @Override 
    public String toString()
    {
        return String.format("pioche : %d pokémons", m_pokemons.size());
    }
}
