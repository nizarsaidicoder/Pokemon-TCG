package tests;

import Pokemon.Affinity.Fire;
import Pokemon.*;
import Pokemon.Effects.Abilities.DejaVu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DejaVuTest {
    @Test
    public void activate()
    {
        DejaVu dejaVu = new DejaVu();
        PokemonWithPower p = new PokemonWithPower("Eevee", 100, 50, new Fire(),dejaVu);
        Pokemon p2 = new Pokemon("Pikachu", 200, 100, new Fire());
        dejaVu.setOwner(p);
        p2.setSkillPoints(1);
        p.getEffect().activate(p2);
        assertEquals(2,p2.getAttackPoints());
    }

}