package Pokemon;

public class Earth extends Affinity
{
    public Earth()
    {
        super(Element.EARTH);
    }

    public Element getWeakness()
    {
        return Element.FIRE;
    }

    public Element getStrength()
    {
        return Element.WATER;
    }
    
}
