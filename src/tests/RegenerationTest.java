package tests;

import Pokemon.Affinity.Fire;
import Pokemon.Effects.Abilities.Regeneration;
import Pokemon.Effects.Abilities.SoinTotal;
import Pokemon.Pokemon;
import Pokemon.PokemonWithPower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegenerationTest {

    @Test
    public void activate()
    {
        Regeneration regen = new Regeneration();
        SoinTotal soin = new SoinTotal();
        PokemonWithPower p = new PokemonWithPower("Eevee", 100, 50, new Fire(),regen);
        PokemonWithPower p2 = new PokemonWithPower("Pikachu", 200, 100, new Fire(),soin);
        regen.setOwner(p);
        p2.getEffect().activate(p);
        p.getEffect().activate(p2);
        assertEquals(false,p2.getEffect().isUsed());
    }

}