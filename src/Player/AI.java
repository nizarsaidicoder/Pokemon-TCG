package Player;

import Pokemon.*;
import Pokemon.Effects.TargetType;

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
    public boolean playEffects(Player opponent)
    {
        // Prompt the player to choose a pokemon to attack
        return useEffects(opponent);
    }
    @Override
    public boolean useEffects(Player opponent)
    {
        for(PokemonWithPower p : getField().getPokemonsWithPower())
        {
            if(p.getEffect().getTargetType() == TargetType.ENEMY && opponent.getField().isEmpty()) return false;
            if(!p.getEffect().isUsed())
            {
                if(p.getEffect().getTargetType() == TargetType.ENEMY && !opponent.getField().getPokemons().isEmpty())
                {
                    Pokemon enemyPokemon = getOpponentPokemon(p, opponent.getField().getPokemons());
                    p.getEffect().activate(enemyPokemon);
                }
                else if(p.getEffect().getTargetType() == TargetType.ALLY )
                {
                    Pokemon allyPokemon = getField().getPokemons().get(0);
                    p.getEffect().activate(allyPokemon);
                }
                else if (p.getEffect().getTargetType() == TargetType.BOTH && !opponent.getField().getPokemons().isEmpty())
                {
                    Pokemon enemyPokemon = getOpponentPokemon(p, opponent.getField().getPokemons());
                    p.getEffect().activate(enemyPokemon);
                    Pokemon allyPokemon = getField().getPokemons().get(0);
                    p.getEffect().activate(allyPokemon);
                }
                killDeadPokemons(opponent);
            }
        }
        return true;
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
            if(m_field.getPokemon(i).getAttackPoints() > 0)
            {
                pokemonIndex = i;
                break;
            }
        }
        Pokemon pokemon = m_field.getPokemon(pokemonIndex);
        // get the pokemon that is weak to the current pokemon
        Pokemon enemyPokemon = getOpponentPokemon(pokemon, opponent.getField().getPokemons());
        
        if(pokemon.getAttackPoints() > 0)
        {
            pokemon.attack(enemyPokemon);
            pokemon.setSkillPoints(pokemon.getAttackPoints()-1);
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
            return strongPokemons.getFirst();
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
