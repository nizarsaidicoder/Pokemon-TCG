package tests;

import Pokemon.Affinity.Fire;
import Pokemon.Effects.Abilities.Berserk;
import Pokemon.Effects.Abilities.Regeneration;
import Pokemon.Effects.Abilities.SoinTotal;
import Pokemon.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BerserkTest {

    @Test
    public void activate()
    {
        Berserk berserk = new Berserk();
        PokemonWithPower p = new PokemonWithPower("Eevee", 100, 50, new Fire(),berserk);
        Pokemon p2 = new Pokemon("Pikachu", 200, 100, new Fire());
        berserk.setOwner(p);
        p.getEffect().activate(p2);
        assertEquals(200,p2.getAttack());
    }

}