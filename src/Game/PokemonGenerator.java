package Game;
import Pokemon.*;
import Pokemon.Affinity.*;
import Pokemon.Effects.*;
import Pokemon.Effects.Abilities.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PokemonGenerator {
    public static final ArrayList<String> m_pokemonNames =new ArrayList<>(
            Arrays.asList(
                    "Pikachu","Pedro","Salamèche", "Carapuce", "Bulbizarre", "Evoli", "Mentali", "Herbizarre", "Florizarre", "Reptincel", "Dracaufeu", "Carabaffe", "Tortank", "Chenipan", "Chrisacier", "Papilusion", "Rattata", "Rattatac", "Raichu", "Goupix", "Feunard", "Rondoudou", "Grodoudou", "Taupiqueur", "Triopikeur", "Miaouss", "Psykokwak", "Akwakwak", "Caninos", "Arcanin", "Ponyta", "Galopa", "Canarticho", "Otaria", "Lamantine", "Kokyas", "Fantominus", "Poissirène", "Magicarpe", "Léviator", "Aquali", "Voltali", "Pyroli"
            ));
    public static ArrayList<Effect> m_effects = new ArrayList<>(
            Arrays.asList(
                    new Resistance(), new Berserk(), new DejaVu(), new A_Ether(), new Kamikaze(), new Regeneration(), new SoinTotal(), new A_Plomb()
            )
    );
    public static final ArrayList<Affinity> m_affinities = new ArrayList<>(Arrays.asList(new Fire(), new Water(), new Earth(), new Air()));

    /**
     * Méthode pour créer les pokémons
     * @return une liste de pokémons ordonnée aléatoirement
     */
    public static ArrayList<Pokemon> createPokemons()
    {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        int powerCount = 0;
        for(String pokemon : m_pokemonNames)
        {
            int hp = getRandom(10, 20) * 10;
            int attack = getRandom(1, 4) * 10;
            Affinity affinity = getRandomAffinity();
//            if(getRandom(0,1) == 1 && powerCount < 8)
//            {
//                Effect effect = getRandomEffect();
//                PokemonWithPower p = new PokemonWithPower(pokemon, hp, attack, affinity, effect);
//                pokemons.add(p);
//                powerCount++;
//            }
//            else pokemons.add(new Pokemon(pokemon, hp, attack, affinity));
            Kamikaze kamikaze = new Kamikaze();
            PokemonWithPower p = new PokemonWithPower(pokemon, hp, attack, affinity, kamikaze);
            pokemons.add(p);
        }
        shuffle(pokemons);
        return pokemons;
    }
    /**
     * Méthode pour obtenir une affinité aléatoire
     * @return une affinité aléatoire
     */
    public static Affinity getRandomAffinity()
    {
        int index = getRandom(0, m_affinities.size() - 1);
        return m_affinities.get(index);
    }
    /**
     * Méthode pour obtenir un effet aléatoire
     * @return un effet aléatoire
     */
    public static Effect getRandomEffect()
    {
        int index = getRandom(0, m_effects.size() - 1);
        if(m_effects.isEmpty()) return null;
        return m_effects.remove(index);
    }
    /**
     * Méthode pour mélanger une liste de pokémons
     * @param pokemons liste de pokémons à mélanger
     */
    public static void shuffle(ArrayList<Pokemon> pokemons)
    {
        Random rnd = new Random();
        for(int i = 0; i < pokemons.size(); i++)
        {
            int randomIndexToSwap = rnd.nextInt(pokemons.size());
            Pokemon temp = pokemons.get(randomIndexToSwap);
            pokemons.set(randomIndexToSwap, pokemons.get(i));
            pokemons.set(i, temp);
        }
    }
    /**
     * Méthode pour obtenir un nombre aléatoire entre min et max
     * @param min le nombre minimum
     * @param max le nombre maximum
     * @return un nombre aléatoire entre min et max
     */
    public static int getRandom(int min, int max) {

        int range = (max - min) + 1;
        int random = (int) ((range * Math.random()) + min);
        return random;
    }
}
