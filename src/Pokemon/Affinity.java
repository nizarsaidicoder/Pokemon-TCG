package Pokemon;

public abstract class Affinity
{
    /**
     * Attributs
     */
    private Element m_element;

    public Affinity(Element element)
    {
        m_element = element;
    }


    public abstract Element getWeakness();
    public abstract Element getStrenght();

    public Element getElement()
    {
        return m_element;
    }
}
