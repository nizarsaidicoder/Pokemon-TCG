package Collection;

// import Pokemon.*;
// import java.util.ArrayList;


public class Graveyard  extends CardCollection
{
    /**
     * Constructeur
     */
    public Graveyard(int maxSize)
    {
        super(maxSize);
    }


    @Override 
    public String toString()
    {
        return String.format("défausse : %d pokémons", m_pokemons.size());
    }
}
