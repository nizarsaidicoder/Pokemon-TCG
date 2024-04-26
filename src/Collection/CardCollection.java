package Collection;
import Pokemon.*;
import java.util.ArrayList;

public abstract class CardCollection {
    protected ArrayList<Pokemon> m_pokemons;
    protected int m_size;
    protected int m_maxSize;

    public CardCollection(int maxSize) {
        m_maxSize= maxSize;
        m_pokemons = new ArrayList<>(maxSize);
        m_size = 0;
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
    /*
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
        // Ajoute le pokemon à la collection
        // incremente m_size par 1
    }
    /*
     * Methode pour retirer un pokemon de la collection
     * @param name le nom du pokemon à retirer
     */
    public void removePokemon(String name)
    {
        // Verifie si le pokemon existe
        // Retire le pokemon de la main
        // decremente m_size par 1
        int index = containsPokemon(name);
        if(index != -1)
        {
            m_pokemons.remove(index);
            m_size--;
        }
    }
    /*
     * Supprime le pokemon de la collection et le retourne
     * @param name le nom du pokemon à recuperer
     * @return le pokemon à recuperer
     */
    public Pokemon pickPokemon(String name)
    {
        // Verifie si le pokemon ecist
        // Retire le pokemon de la main
        // decremente m_size par 1
        // Retourne le pokemon
        // Sinon
        int index = containsPokemon(name);
        if(index != -1)
        {
            return pickPokemon(index);
        }
        return null;
    }
    public Pokemon pickPokemon(int index)
    {
        // Verifie si le pokemon ecist
        // Retire le pokemon de la main
        if(index != -1 && index < m_size)
        {
            Pokemon pokemon = m_pokemons.get(index);
            m_pokemons.remove(index);
            // decremente m_size par 1
            // Retourne le pokemon
            m_size--;
            return pokemon;
        }
        // Sinon
        return null;
    }
    /*
     * Methode pour verifier si un pokemon existe dans la collection
     * @return l'indice du pokemon dans la collection, -1 sinon
     */
    public int containsPokemon(String name)
    {
        // Verifie si le pokemon exist
        for (int i = 0; i < m_size; i++)
        {
            // si le pokemon existe
            if(m_pokemons.get(i).getName().equals(name)) return i;
        }
        // retourne l'indice du pokemon, si non -1
        return -1;
    }
    /*
     * Methode pour recuperer un pokemon de la collection
     * Cette methode Supprime pas le pokemon de la collection
     * @param name le nom du pokemon à recuperer
     * @return le pokemon à recuperer
     */
    public Pokemon getPokemon(String name)
    {
        // verifie si le pokemon existe
        int index = containsPokemon(name);
        if(index != -1)
        {
            // retourne le pokemon avec le nom passé par parametre
            // cette methode ne retourne pas une copie
            return m_pokemons.get(index);
        }
        return null;
    }
    public ArrayList<Pokemon> getPokemons()
    {
        return m_pokemons;
    }
    /*
     * Methode pour afficher les pokemons de la collection
     */
    public abstract void display();
}