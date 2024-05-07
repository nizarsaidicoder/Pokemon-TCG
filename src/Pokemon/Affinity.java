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

    /**
     * Retourne l'élément faible du pokémon
     * @return Element faible
     */
    
    public abstract Element getWeakness();
    /**
     * Retourne l'élément fort du pokémon
     * @return Element fort
     */
    public abstract Element getStrength();
    /**
     * Retourne l'élément de l'affinité
     * @return Element
     */
    public Element getElement()
    {
        return m_element;
    }
}
