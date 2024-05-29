package Pokemon.Affinity;

public class Ether extends Affinity {
    public Ether()
    {
        super(Element.ETHER);
    }

    public Element getWeakness()
    {
        return Element.NONE;
    }
    public Element getStrength()
    {
        return Element.ALL;
    }
    public Element getElement()
    {
        return Element.ETHER;
    }

}
