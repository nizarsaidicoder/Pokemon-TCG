package Pokemon;

public class Air extends Affinity
{
    public Air()
    {
        super(Element.AIR);
    }

    public Element getWeakness()
    {
        return Element.FIRE;
    }

    public Element getStrenght()
    {
        return Element.EARTH;
    }
}
