package tests;

import Pokemon.Affinity.Element;
import Pokemon.Affinity.Fire;
import Pokemon.Effects.Abilities.A_Ether;
import Pokemon.Effects.Abilities.A_Plomb;
import Pokemon.Pokemon;
import Pokemon.PokemonWithPower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A_EtherTest {
    @Test
    public void activate()
    {
        A_Ether ether = new A_Ether();
        PokemonWithPower p = new PokemonWithPower("Eevee", 100, 50, new Fire(),ether);
        Pokemon p2 = new Pokemon("Pikachu", 200, 100, new Fire());
        ether.setOwner(p);
        p.getEffect().activate(p2);
        assertEquals(Element.ETHER,p2.getAffinity().getElement());
    }

}