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
     * Methode pour verifier si un pokemon existe dans la collection
     * @return l'indice du pokemon dans la collection, -1 sinon
     */
    public int containsPokemon(String name)
    {
        // Verifie si le pokemon existe
        for(int i = 0; i < m_pokemons.size(); i++)
        {
            if(m_pokemons.get(i).getName() == name)
            {
                return i;
            }
        }
        // retourne l'indice du pokemon, si non -1
        return -1;
    }

    /**
     * Methode pour retirer un pokemon de la collection
     * @param name le nom du pokemon à retirer
     */
    public void removePokemon(String name)
    {
        // Verifie si la collection n'est pas vide
        if(!isEmpty())
        {
            int i = containsPokemon(name);
            // Verifie si le pokemon existe
            if(i != -1)
            {
                // Retire le pokemon de la main
                m_pokemons.remove(i);
                // decremente m_size par 1
                m_size--;
            }
        }
    }

    /**
     * Methode pour retirer un pokemon de la collection
     * @param pokemon le pokemon à retirer
     */
    public void removePokemon(Pokemon pokemon)
    {
        removePokemon(pokemon.getName());
    }

    /**
     * Supprime le pokemon de la collection et le retourne
     * @param name le nom du pokemon à recuperer
     * @return le pokemon à recuperer
     */
    public Pokemon pickPokemon(String name)
    {
        // Verifie si la collection n'est pas vide
        if(!isEmpty())
        {
            int i = containsPokemon(name);
            // Verifie si le pokemon existe
            if(i != -1)
            {
                // decremente m_size par 1
                m_size--;
                // Retire le pokemon de la main et le retourne
                return m_pokemons.remove(i);
            }
        }
        // Sinon
        return null;
    }

    /**
     * Supprime le pokemon de la collection et le retourne
     * @param l'indice du pokemon à recuperer
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
     * @param name le nom du pokemon à recuperer
     * @return le pokemon à recuperer
     */
    public Pokemon getPokemon(String name)
    {
        // Verifie si la collection n'est pas vide
        if(!isEmpty())
        {
            int i = containsPokemon(name);
            // Verifie si le pokemon existe
            if(i != -1)
            {
                // retourne le pokemon avec le nom passé par parametre
                return m_pokemons.get(i);
            }
        }
        // cette methode ne retourne pas une copie
        // Sinon
        return null;
    }

    /**
     * Methode pour recuperer un pokemon de la collection
     * Cette methode Supprime pas le pokemon de la collection
     * @param name le nom du pokemon à recuperer
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
     * Methode pour afficher les pokemons de la collection
     */
    public abstract void display();
}