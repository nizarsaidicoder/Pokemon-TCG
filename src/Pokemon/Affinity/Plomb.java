package Pokemon.Affinity;

public class Plomb extends Affinity{
    public Plomb()
    {
        super(Element.PLOMB);
    }

    public Element getWeakness()
    {
        return Element.ALL;
    }
    public Element getStrength()
    {
        return Element.NONE;
    }
    public Element getElement()
    {
        return Element.PLOMB;
    }
}
