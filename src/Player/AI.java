package Player;

import Pokemon.Pokemon;
import Utils.HelperFunctions;

import java.util.ArrayList;
import java.util.Random;

public class AI extends Player
{
    /**
     * Constructeur de la classe AI
     */
    public AI (ArrayList<Pokemon> pokemons, int playerNumber, String name)
    {
        // Initialise le deck, la main, le cimetière et le terrain
        // Juste pour les tests pour l'instant
        super(pokemons,playerNumber,name);
    }
    // try {
    //            Thread.sleep(1000);
    //        } catch (InterruptedException e) {
    //            Thread.currentThread().interrupt();
    //        }
    // TO IMPLEMENT WHEN CODING THE AI
    @Override
    public void spawn()
    {
        //Place un Pokémon de sa main face visible sur chaque emplacement vide sur son terrain, dans l'ordre de sa main
        try{Thread.sleep(1000);}
        catch(InterruptedException e){Thread.currentThread().interrupt();}
        m_field.addPokemon(m_hand.pickPokemon(0));
    }
    @Override
    public void attack(Player opponent)
    {
        //Attaque une fois avec chacun des Pokémons de son terrain dans l'ordre de ses terrains.
        try{Thread.sleep(1000);}
        catch(InterruptedException e){Thread.currentThread().interrupt();}
        // get a playable pokemon
        int pokemonIndex = -1;
        for(int i = 0; i < m_field.getPokemons().size(); i++)
        {
            if(m_field.getPokemon(i).isPlayable())
            {
                pokemonIndex = i;
                break;
            }
        }
        Pokemon pokemon = m_field.getPokemon(pokemonIndex);
        int opponentFieldSize = opponent.getField().getPokemons().size();
        Random random = new Random();
        int randomIndex = random.nextInt(opponentFieldSize);
        Pokemon enemyPokemon = opponent.getField().getPokemon(randomIndex);
        if(pokemon.isPlayable())
        {
            pokemon.attack(enemyPokemon);
            pokemon.setPlayable(false);
            if(!enemyPokemon.isAlive()) 
            {
            // Ajoute le pokemon adverse au cimetière
            opponent.getGraveyard().addPokemon(enemyPokemon);
            opponent.getField().removePokemon(enemyPokemon.getName());
            }
        }
        
    }
    @Override
    public void display()
    {
        // Affiche le joueur
        System.out.println(HelperFunctions.colorizeAndCenter("AI", "red", 100));
        m_graveyard.display();
        m_deck.display();
        m_field.display();
    }
}
