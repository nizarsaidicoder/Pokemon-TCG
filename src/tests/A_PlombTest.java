package tests;

import Pokemon.Affinity.Fire;
import Pokemon.Effects.Abilities.A_Plomb;
import Pokemon.Affinity.Element;
import Pokemon.Pokemon;
import Pokemon.PokemonWithPower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A_PlombTest {
    @Test
    public void activate()
    {
        A_Plomb plomb = new A_Plomb();
        PokemonWithPower p = new PokemonWithPower("Eevee", 100, 50, new Fire(),plomb);
        Pokemon p2 = new Pokemon("Pikachu", 200, 100, new Fire());
        plomb.setOwner(p);
        p.getEffect().activate(p2);
        assertEquals(Element.PLOMB,p2.getAffinity().getElement());
    }
}