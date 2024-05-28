package Collection;
import java.util.ArrayList;
import Pokemon.*;

public class Field extends CardCollection {

    /*
     * Constructeur de la classe Field
     */
    public Field(int maxSize)
    {
        super(maxSize);
    }

    public ArrayList<PokemonWithPower> getPokemonsWithPower()
    {
        ArrayList<PokemonWithPower> pokemonsWithPower = new ArrayList<>();
        for(Pokemon pokemon : m_pokemons)
        {
            if(pokemon.hasEffect())
            {
                pokemonsWithPower.add((PokemonWithPower)pokemon);
            }
        }
        return pokemonsWithPower;
    }
}
