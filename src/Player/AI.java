package Player;

import Pokemon.Pokemon;
import java.util.ArrayList;


public class AI extends Player
{
    /**
     * Constructeur de la classe AI
     */
    public AI (ArrayList<Pokemon> pokemons, int playerNumber)
    {
        // Initialise le deck, la main, le cimetière et le terrain
        // Juste pour les tests pour l'instant
        super(pokemons,playerNumber,"Computer");
    }
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
            if(m_field.getPokemon(i).getSkillPoints() > 0)
            {
                pokemonIndex = i;
                break;
            }
        }
        Pokemon pokemon = m_field.getPokemon(pokemonIndex);
        // get the pokemon that is weak to the current pokemon
        Pokemon enemyPokemon = getOpponentPokemon(pokemon, opponent.getField().getPokemons());
        
        if(pokemon.getSkillPoints() > 0)
        {
            pokemon.attack(enemyPokemon);
            pokemon.setSkillPoints(pokemon.getSkillPoints()-1);
            if(!enemyPokemon.isAlive())
            {
                // Ajoute le pokemon adverse au cimetière
                opponent.getGraveyard().addPokemon(enemyPokemon);
                opponent.getField().removePokemon(enemyPokemon);
            }
        }

    }
    public Pokemon getOpponentPokemon(Pokemon pokemon,ArrayList<Pokemon> pokemons)
    {
        // Pokemon enemyPokemonFound = null;
        // for(Pokemon enemyPokemon : pokemons)
        // {
        //     //attaque le pokémon dont l'affinité lui donne l'avantage
        //     if(pokemon.isStrongTo(enemyPokemon.getAffinity()))
        //     {
        //         enemyPokemonFound = enemyPokemon;
        //     }
        //     //attaque le pokémon dont l'affinité lui donne l'avantage et qui a le moins de points de vie
        //     if(pokemon.isStrongTo(enemyPokemon.getAffinity()) && enemyPokemon.getHP() < enemyPokemonFound.getHP()) enemyPokemonFound = enemyPokemon;
        //     //attaque l'un de ces Pokémons au hasard
        //     if(enemyPokemonFound == null)
        //     {

        //     }

        // }
        // return null;
        // 
        // Un Pokémon de l'ordinateur :

        // - attaque en priorité le Pokémon dont l'affinité lui donne l'avantage
        // - s'il n'y en a pas (ou s'il y en a plusieurs), il attaque le Pokémon qui possède le moins de points de vie (parmi ceux-ci).
        // - s'il y en a encore plusieurs, il attaque l'un de ces Pokémon au hasard.
        ArrayList<Pokemon> strongPokemons = new ArrayList<Pokemon>();
        for(Pokemon enemyPokemon : pokemons)
        {
            if(pokemon.isStrongTo(enemyPokemon.getAffinity()))
            {
                strongPokemons.add(enemyPokemon);
            }
        }
        if(strongPokemons.size() == 1)
        {
            return strongPokemons.get(0);
        }
        else if(strongPokemons.size() > 1)
        {
            Pokemon weakestPokemon = strongPokemons.get(0);
            for(Pokemon enemyPokemon : strongPokemons)
            {
                if(enemyPokemon.getHP() < weakestPokemon.getHP())
                {
                    weakestPokemon = enemyPokemon;
                }
            }   
            return weakestPokemon;
        }
        else
        {
            Pokemon weakestPokemon = pokemons.get(0);
            for(Pokemon enemyPokemon : pokemons)
            {
                if(enemyPokemon.getHP() < weakestPokemon.getHP())
                {
                    weakestPokemon = enemyPokemon;
                }
            }
            return weakestPokemon;
        }
    }
}
