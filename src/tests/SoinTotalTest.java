package tests;

import Pokemon.Affinity.Fire;
import Pokemon.Effects.Abilities.Resistance;
import Pokemon.Effects.Abilities.SoinTotal;
import Pokemon.Pokemon;
import Pokemon.PokemonWithPower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoinTotalTest {
    @Test
    public void activate()
    {
        SoinTotal soin = new SoinTotal();
        PokemonWithPower p = new PokemonWithPower("Eevee", 100, 50, new Fire(),soin);
        Pokemon p2 = new Pokemon("Pikachu", 200, 100, new Fire());
        soin.setOwner(p);
        p.attack(p2);
        p.attack(p2);
        p.getEffect().activate(p2);
        assertEquals(200,p2.getHPMax());
    }

}