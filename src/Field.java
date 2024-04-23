import java.util.ArrayList;

public class Field {
//  - pokemons: Pokemon[]
//  + estVide() : Boolean
//  + <<Create>> Terrain()
//  + placerPokemon(pokemon: Pokemon)
//  + attaquer(adversaire: Terrain)
//  + afficheDebutJeu()
//  + getPokemons() : Pokemon[]
//  + afficherTerrain()
    private ArrayList<Pokemon> pokemons;
    public Field() {
        pokemons = new ArrayList<Pokemon>();
    }
    public boolean isEmpty()
    {
        return pokemons.isEmpty();
    }
    public void addPokemon(Pokemon pokemon)
    {
        pokemons.add(pokemon);
    }
}
