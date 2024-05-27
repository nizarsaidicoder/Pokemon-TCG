package Pokemon.Affinity;

public class Fire extends Affinity 
{
    public Fire()
    {
        super(Element.FIRE);
    }

    public Element getWeakness()
    {
        return Element.WATER;
    }

    public Element getStrength()
    {
        return Element.AIR;
    }
}
