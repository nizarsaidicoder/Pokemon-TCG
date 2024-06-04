package Collection;
import Pokemon.*;
import java.util.ArrayList;

public abstract class CardCollection 
{
    protected ArrayList<Pokemon> m_pokemons;
    protected int m_size;
    protected int m_maxSize;

    public CardCollection(int maxSize) 
    {
        m_maxSize= maxSize;
        m_size = 0;
        m_pokemons = new ArrayList<>(maxSize);
    }

    /*
     * Methode pour verifier si la collection est vide
     * @return vrai si la collection est vide, faux sinon
     */
    public boolean isEmpty()
    {
        // retourne vrai si le nombre des pokemon de la collection est egal à 0
        return m_size == 0;
    }

    /*
     * Methode pour verifier si la collection est pleine
     * @return vrai si la collection est pleine, faux sinon
     */
    public boolean isFull()
    {
        // retourne vrai si le nombre des pokemon de la collection est egal à a la taille maximale de la collection
        return m_size == m_maxSize;
    }

    /**
     * Methode pour ajouter un pokemon à la collection
     * @param pokemon le pokemon à ajouter
     */
    public void addPokemon(Pokemon pokemon)
    {
        // Verifie si la collection n'est pas plein
        if(!isFull())
        {
            // Ajoute le pokemon à la collection
            m_pokemons.add(pokemon);
            // incremente m_size par 1
            m_size++;
        }
    }

    /**
     * Methode pour retirer un pokemon de la collection
     * @param pokemon le pokemon à retirer
     */
    public void removePokemon(Pokemon pokemon)
    {
        m_pokemons.remove(pokemon);
        m_size--;
    }

    /**
     * Supprime le pokemon de la collection et le retourne
     * @param index l'indice du pokemon à recuperer
     * @return le pokemon à recuperer
     */
    public Pokemon pickPokemon(int index)
    {
        // decremente m_size par 1
        m_size--;
        // Retire le pokemon de la main et le retourne
        return m_pokemons.remove(index);
    }

    /**
     * Methode pour recuperer un pokemon de la collection
     * Cette methode Supprime pas le pokemon de la collection
     * @param index l'index du pokemon à recuperer
     * @return le pokemon à recuperer
     */
    public Pokemon getPokemon(int index)
    {
        // retourne le pokemon
        return m_pokemons.get(index);
    }

    /**
     * Methode pour recuperer la liste des pokemons de la collection
     * @return la liste des pokemons
     */
    public ArrayList<Pokemon> getPokemons()
    {
        return m_pokemons;
    }

    /**
     * Methode pour recuperer la liste des pokemons de la collection avec pouvoir
     * @return la liste des pokemons avec pouvoir
     */
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
    public int getSize()
    {
        return m_size;
    }
}