package Player;
import Collection.Deck;
import Collection.Field;
import Collection.Graveyard;
import Collection.Hand;
import Pokemon.Pokemon;

import java.util.ArrayList;

public class Player 
{
    /**
     * Attributs
     */
    protected Field m_field;
    protected Graveyard m_graveyard;
    protected Deck m_deck;
    protected Hand m_hand;
    protected int m_playerNumber;

    /*
     * Constructeur de la classe Player
     */
    public Player(ArrayList<Pokemon> pokemons,int playerNumber)
    {
        // Initialise le deck, la main, le cimetière et le terrain
        // Juste pour les tests pour l'instant
    }

    /*
    * Methode pour piocher une carte
    */
    public void draw()
    {
        // Pioche un pokemon dans le deck

        // Ajoute le pokemon à la main

    }
    public void spawn()
    {
        // Ajoute un pokemon du terrain
    }
    /*
     * Methode pour attaquer un joueur
     */
    public void attack(Player enemy)
    {
    }
    public void setPlayablePokemons()
    {
        // Parcourt la main et met à jour les pokemons jouables
//        for(Pokemon pokemon : m_field.getPokemons())
//        {
//            pokemon.setPlayable(true);
//        }
    }
    public boolean hasPlayablePokemons()
    {
        ArrayList<Pokemon> playablePokemons = new ArrayList<>();
        for(Pokemon pokemon : m_field.getPokemons())
        {
            if(pokemon.isPlayable())
            {
                return true;
            }
        }
        return false;
    }
    public ArrayList<Pokemon> getPlayablePokemons()
    {
        ArrayList<Pokemon> playablePokemons = new ArrayList<>();
        for(Pokemon pokemon : m_field.getPokemons())
        {
            if(pokemon.isPlayable())
            {
                playablePokemons.add(pokemon);
            }
        }
        return playablePokemons;
    }
    /*
     * Methode pour savoir si le joueur est vaincu
     * @return true si le joueur est vaincu, false sinon
     */
    public boolean isDefeated()
    {
        return m_field.isEmpty() && m_hand.isEmpty() && m_deck.isEmpty();
    }
    /*
     * Methode pour afficher les informations du joueur (main, pioche, cimetière, terrain)
     */
    public void display()
    {
        // Affiche le joueur
        System.out.println("Player : " + m_playerNumber);
        m_field.display();
        System.out.println();
        m_deck.display();
        System.out.println();
        m_graveyard.display();
        System.out.println();
        m_hand.display();
    }

    /**
     * Retourn le numéro du joueur
     * @return numéro joueur
     */
    public int getPlayerNumber()
    {
        return m_playerNumber;
    }
    public Field getField()
    {
        return m_field;
    }
    public Deck getDeck()
    {
        return m_deck;
    }
    public Hand getHand()
    {
        return m_hand;
    }
    public Graveyard getGraveyard()
    {
        return m_graveyard;
    }

}
