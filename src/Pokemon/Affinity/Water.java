package Pokemon.Affinity;

public class Water extends Affinity
{
    public Water()
    {
        super(Element.WATER);
    }

    public Element getWeakness()
    {
        return Element.EARTH;
    }

    public Element getStrength()
    {
        return Element.FIRE;
    }   
}
