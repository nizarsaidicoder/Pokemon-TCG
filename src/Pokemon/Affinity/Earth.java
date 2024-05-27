package Pokemon.Affinity;

public class Earth extends Affinity
{
    public Earth()
    {
        super(Element.EARTH);
    }

    public Element getWeakness()
    {
        return Element.AIR;
    }

    public Element getStrength()
    {
        return Element.WATER;
    }
    
}
