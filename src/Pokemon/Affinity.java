package Pokemon;

public abstract class Affinity 
{
    /**
     * Attributs
     */
    private Element m_element;

    /**
     * Constructeur
     * @param element
     */
    public Affinity(Element element)
    {
        m_element = element;
    }
    
    public abstract Element getWeakness();
    public abstract Element getStrength();

    /**
     * Retourne l'élément du pokémon
     * @return élément
     */
    public Element getElement()
    {
        return m_element;
    }
}
