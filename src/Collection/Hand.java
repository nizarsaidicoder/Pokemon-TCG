package Collection;

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
    public String toString()
    {
        return String.format("Main : %d pokémons", m_pokemons.size());
    }
}
