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
<<<<<<< HEAD

    /**
     * Retourne l'élément du pokémon
     * @return élément
=======
    /**
     * Retourne l'élément de l'affinité
     * @return Element
>>>>>>> a506022917e5b700aec548365e1c6e53a4ae78b7
     */
    public Element getElement()
    {
        return m_element;
    }
}
