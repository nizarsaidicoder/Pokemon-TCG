package Pokemon;

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

    public Element getStrenght()
    {
        return Element.AIR;
    }
}
