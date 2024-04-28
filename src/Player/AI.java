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
        super(pokemons,playerNumber,name);
    }
    @Override
    public void spawn()
    {
        // L'IA place le 1er Pokémon de sa main sur le terrain avec un délai de 1 seconde pour simuler la réflexion de l'IA
        try{Thread.sleep(1000);}
        catch(InterruptedException e){Thread.currentThread().interrupt();}
        m_field.addPokemon(m_hand.pickPokemon(0));
    }
    @Override
    public void attack(Player opponent)
    {
        // L'IA attaque un Pokémon adverse aléatoire avec un le premier Pokémon jouable sur son terrain
        // Ajout d'un délai pour simuler la réflexion de l'IA (STUPIIID !!!! oui je sais mais c'est pour l'exemple :D)
        try{Thread.sleep(1000);}
        catch(InterruptedException e){Thread.currentThread().interrupt();}
        // Récupère le premier pokemon jouable sur le terrain
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
        // Récupère un pokemon adverse aléatoire
        int opponentFieldSize = opponent.getField().getPokemons().size();
        Random random = new Random();
        int randomIndex = random.nextInt(opponentFieldSize);
        Pokemon enemyPokemon = opponent.getField().getPokemon(randomIndex);
        // L'IA attaque le pokemon adverse
        pokemon.attack(enemyPokemon);
        pokemon.setPlayable(false);
        if(!enemyPokemon.isAlive()) 
        {
            // Ajoute le pokemon adverse au cimetière de l'adversaire et le retire du terrain
            opponent.getGraveyard().addPokemon(enemyPokemon);
            opponent.getField().removePokemon(enemyPokemon.getName());
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
