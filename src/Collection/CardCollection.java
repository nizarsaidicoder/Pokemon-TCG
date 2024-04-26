package Collection;
import Pokemon.*;
import java.util.ArrayList;

public abstract class CardCollection {
    protected ArrayList<Pokemon> m_pokemons;
    protected int m_size;
    protected int m_maxSize;

    public CardCollection(int maxSize) {
        m_maxSize= maxSize;
        m_size = 0;
        m_pokemons = new ArrayList<>(maxSize);
    }
    public boolean isEmpty()
    {
        // retourne vrai si le nombre des pokemon de la collection est egal à 0
        return false;
    }
    public boolean isFull()
    {
        // retourne vrai si le nombre des pokemon de la collection est egal à a la taille maximale de la collection
        return false;
    }
    public void addPokemon(Pokemon pokemon)
    {
        // Verifie si la collection n'est pas plein
            // Ajoute le pokemon à la collection
            // incremente m_size par 1
    }
    public void removePokemon(String name)
    {
        // Verifie si la collection n'est pas plein
            // Verifie si le pokemon existe
            // Retire le pokemon de la main
            // decremente m_size par 1
    }
    public Pokemon pickPokemon(String name)
    {
        // Verifie si le pokemon ecist
            // Retire le pokemon de la main
            // decremente m_size par 1
            // Retourne le pokemon
        // Sinon
        return null;
    }
    public int containsPokemon(String name)
    {
        // Verifie si le pokemon exist
        // retourne l'indice du pokemon, si non -1
        return -1;
    }
    public Pokemon getPokemon(String name)
    {
        // verifie si le pokemon existe
        // retourne le pokemon avec le nom passé par parametre
        // cette methode ne retourne pas une copie
        return null;
    }
    public abstract void display();
}