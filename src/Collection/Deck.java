package Collection;
import java.util.ArrayList;
import Pokemon.Pokemon;
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
}
