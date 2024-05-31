package tests;

import Pokemon.Affinity.Fire;
import Pokemon.Effects.Abilities.Kamikaze;
import Pokemon.Effects.Abilities.Regeneration;
import Pokemon.Effects.Abilities.SoinTotal;
import Pokemon.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KamikazeTest {
    @Test
    public void activate()
    {
        Kamikaze kamikaze = new Kamikaze();
        PokemonWithPower p = new PokemonWithPower("Eevee", 100, 50, new Fire(),kamikaze);
        Pokemon p2 = new Pokemon("Pikachu", 200, 100, new Fire());
        kamikaze.setOwner(p);
        p.getEffect().activate(p2);
        assertTrue(p2.getHP() == 0 && p.getHP() == 0);
    }
}