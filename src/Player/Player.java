package Player;

import Collection.Deck;
import Collection.Field;
import Collection.Graveyard;
import Collection.Hand;
import Pokemon.Pokemon;
import Utils.HelperFunctions;

import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    /**
     * Attributs
     */
    protected String m_name;
    protected Field m_field;
    protected Graveyard m_graveyard;
    protected Deck m_deck;
    protected Hand m_hand;
    protected int m_playerNumber;
    private Scanner m_scanner = new Scanner(System.in);

    /*
     * Constructeur de la classe Player
     */
    public Player(ArrayList<Pokemon> pokemons,int playerNumber,String name)
    {
        // Initialise le deck, la main, le cimetière et le terrain
        m_field = new Field(3);
        m_graveyard = new Graveyard(6);
        m_deck = new Deck(6,pokemons);
        m_hand = new Hand(5);
        m_playerNumber = playerNumber;
        m_name = name;
    }

    /*
     * Methode pour piocher une carte
     */
    public void draw()
    {
        // Pioche un pokemon dans le deck
//        for(Pokemon pokemon : m_deck.getPokemons())
//        {
//            pokemon.display();
//        }
        Pokemon pokemon = m_deck.pickPokemon(0);
        // Ajoute le pokemon à la main
        m_hand.addPokemon(pokemon);
    }
    public void spawn()
    {
        // Prompt the player to choose a pokemon to spawn from the hand
        System.out.print(HelperFunctions.colorize("Choose a pokemon to spawn : ", "blue"));
        // Recupere le pokemon à jouer
        int index = -1;
        // check if the player entered a valid pokemon index
        while(index == -1)
        {
            try
            {
                index = Integer.parseInt(m_scanner.nextLine()) -1;
                if(index < 0 || index >= m_hand.getPokemons().size())
                {
                    System.out.println(HelperFunctions.colorize("Invalid index, please enter a valid index", "red"));
                    index = -1;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println(HelperFunctions.colorize("Invalid index, please enter a valid index", "red"));
            }
        }
        // Ajoute un pokemon du terrain
        m_field.addPokemon(m_hand.pickPokemon(index));
    }
    /*
     * Methode pour attaquer un joueur
     */
    public void attack(Player opponent)
    {

        Pokemon pokemon = promptPokemon();
        // Prompt the player to choose a pokemon to attack
        Pokemon enemyPokemon = promptEnemyPokemon(opponent);
        // Attaque le pokemon
        pokemon.attack(enemyPokemon);
        pokemon.setPlayable(false);
        if(!enemyPokemon.isAlive()) {
            // Ajoute le pokemon adverse au cimetière
            opponent.getGraveyard().addPokemon(enemyPokemon);
            opponent.getField().removePokemon(enemyPokemon.getName());
        }
    }
    public void setPlayablePokemons()
    {
        // Parcourt la main et met à jour les pokemons jouables
        for(Pokemon pokemon : m_field.getPokemons())
        {
            pokemon.setPlayable(true);
        }
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
    public Pokemon promptPokemon()
    {
        // Prompt the player to choose a pokemon to attack with
        System.out.print("Choose a pokemon to attack with : ( ");
        for(int i= 0; i < m_field.getPokemons().size(); i++)
        {
            if(m_field.getPokemon(i).isPlayable()) System.out.print(m_field.getPokemon(i).getName() + "(" + (i+1) + ") ");
        }
        System.out.print(" ) : ");
        // Recupere le pokemon à jouer
        // check if the player has entered the index of the pokemon
        // check if the player has entered a valid index
        int index = -1;
        while(index == -1)
        {
            try
            {
                index = Integer.parseInt(m_scanner.nextLine()) -1;
                if(index < 0 || index >= m_field.getPokemons().size() || !m_field.getPokemon(index).isPlayable())
                {
                    System.out.println(HelperFunctions.colorize("Invalid index, please enter a valid index","red"));
                    index = -1;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println(HelperFunctions.colorize("Invalid index, please enter a valid index","red"));
            }
        }
        return m_field.getPokemons().get(index); 
    }
    public Pokemon promptEnemyPokemon(Player opponent)
    {
        // Prompt the player to choose a pokemon to attack
        System.out.println("Choose a pokemon to attack : ( ");
        for(int i = 0; i < opponent.getField().getPokemons().size(); i++)
        {
            System.out.print(opponent.getField().getPokemon(i).getName() + " (" +  (i+1) + ") ");
        }
        System.out.print("): ");
        // Recupere le pokemon à attaquer
        int index = -1;
        while(index == -1)
        {
            try
            {
                index = Integer.parseInt(m_scanner.nextLine()) -1;
                if(index < 0 || index >= opponent.getField().getPokemons().size())
                {
                    System.out.println(HelperFunctions.colorize("Invalid index, please enter a valid index","red"));
                    index = -1;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println(HelperFunctions.colorize("Invalid index, please enter a valid index","red"));
            }
        }
        return opponent.getField().getPokemon(index); 
    }
    /*
     * Methode pour afficher les informations du joueur (main, pioche, cimetière, terrain)
     */
    public void display()
    {
        // Affiche le joueur
        System.out.println(HelperFunctions.colorizeAndCenter(m_name, "blue", 100));
        m_field.display();
        m_deck.display();
        m_graveyard.display();
        m_hand.display();
        System.out.println();
    }

    /**
     * Retourn le numéro du joueur
     * @return numéro joueur
     */
    public int getPlayerNumber()
    {
        return m_playerNumber;
    }
    public String getName(){return m_name;}
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
