package Pokemon.Effects;
import Pokemon.Effects.Abilities.Ability;
import Pokemon.Pokemon;

import java.util.ArrayList;

abstract public class EffectPokemon extends Effect {

    protected ArrayList<Pokemon> target = new ArrayList<>();
    public EffectPokemon(Ability ability, int triggerCount, Pokemon caster, EffectType effectType)
    {
        super(ability, triggerCount, caster, effectType);
    }
    public Pokemon promptPokemon(ArrayList<Pokemon> allyPokemons)
    {
        Pokemon selectedPokemon = null;
        while(selectedPokemon == null)
        {
            System.out.println("Select a Pokemon to use the ability on:");
            // INPUT WITH NUMBER
            int i = -1;
            try
            {
                i = Integer.parseInt(m_scanner.nextLine()) - 1;
                if(i < 0 || i >= allyPokemons.size())
                {
                    System.out.println("Invalid input. Please enter a valid pokemon number between 1 and " + allyPokemons.size());
                    continue;
                }
                selectedPokemon = allyPokemons.get(i);
            }
            catch(NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return selectedPokemon;
    }

    public Pokemon promptEnemyPokemon(ArrayList<Pokemon> enemyPokemons)
    {
        Pokemon selectedPokemon = null;
        while(selectedPokemon == null)
        {
            System.out.println("Select an enemy Pokemon to use the ability on:");
            // INPUT WITH NUMBER
            int i = -1;
            try
            {
                i = Integer.parseInt(m_scanner.nextLine()) - 1;
                if(i < 0 || i >= enemyPokemons.size())
                {
                    System.out.println("Invalid input. Please enter a valid pokemon number between 1 and " + enemyPokemons.size());
                    continue;
                }
                selectedPokemon = enemyPokemons.get(i);
            }
            catch(NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return selectedPokemon;
    }
    public ArrayList<Pokemon> getTarget()
    {
        return target;
    }
}
