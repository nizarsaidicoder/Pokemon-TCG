import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PowerTests
{
    @Test
    void test_Resistance()
    {
        PokemonWithPower p1 = new PokemonWithPower("salamèche", 100, 30, new FIRE(), new Resistance());
        Pokemon p2 = new Pokemon("dracaufeu", 100, 30, new FIRE());
        p1.getEffect().activate();
        p2.attack(p2);
        assertsEquals(p1.getHp(), 80);
    }

}