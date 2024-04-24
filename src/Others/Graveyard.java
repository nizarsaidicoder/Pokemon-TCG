package Others;

import Pokemon.*;
import java.util.ArrayList;

public class Graveyard 
{
    /**
     * Attributs
     */
    private ArrayList<Pokemon> m_pokemons;

    /**
     * Constructeur
     */
    public Graveyard()
    {
        m_pokemons = new ArrayList<>();
    }

    /**
     * Ajoute un pokemon à la défausse
     * @param pokemon
     */
    public void addPokemon(Pokemon pokemon)
    {
        m_pokemons.add(pokemon);
    }

    /**
     * Affichage de la défausse
     */
    public void displayGraveyard()
    {
        System.out.println(this.toString());
    }
    
    @Override 
    public String toString()
    {
        return String.format("défausse : %d pokémons", m_pokemons.size());
    }
}
