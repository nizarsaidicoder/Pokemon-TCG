package tests;

import Pokemon.Affinity.Fire;
import Pokemon.Effects.Abilities.Resistance;
import Pokemon.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResistanceTest {
    @Test
    public void activate()
    {
        Resistance r = new Resistance();
        PokemonWithPower p = new PokemonWithPower("Eevee", 100, 100, new Fire(),r);
        Pokemon p2 = new Pokemon("Pikachu", 100, 100, new Fire());
        r.setOwner(p);
        p.getEffect().activate(p2);
        assertEquals(10, p2.getDefense());
    }
}