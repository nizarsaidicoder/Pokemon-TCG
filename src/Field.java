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
    public void attack(Field opponent)
    {

    }
    public void displayField()
    {
        for (Pokemon pokemon : pokemons)
        {
            System.out.print(" ____________________ ");
            System.out.print("\t\t");
        }
        System.out.println();
        for(Pokemon pokemon : pokemons)
        {
            System.out.print("|                    |");
            System.out.print("\t\t");
        }
        System.out.println();
        for(Pokemon pokemon : pokemons)
        {
            System.out.print("|     " + HelperFunctions.padRight(pokemon.getName(),15)+ "|");
            System.out.print("\t\t");
        }
        System.out.println();

        for(Pokemon pokemon : pokemons)
        {
            System.out.print("|____________________|");
            System.out.print("\t\t");
        }
        System.out.println();

        for(Pokemon pokemon : pokemons)
        {
            System.out.print("| Attaque: " + HelperFunctions.padRight(Integer.toString(pokemon.getAttack()),10) + "|");
            System.out.print("\t\t");
        }
        System.out.println();

        for(Pokemon pokemon : pokemons)
        {
            System.out.print("| Vie: " + HelperFunctions.padRight(Integer.toString(pokemon.getHP()),14) + "|");
            System.out.print("\t\t");
        }
        System.out.println();

        for(Pokemon pokemon : pokemons)
        {
            System.out.print("| Affinité : " + HelperFunctions.padRight(pokemon.getAffinity(),8) + "|");
            System.out.print("\t\t");
        }
        System.out.println();

        for(Pokemon pokemon : pokemons)
        {
            System.out.print("|____________________|");
            System.out.print("\t\t");
        }
        System.out.println();
        for(Pokemon pokemon : pokemons)
        {
            System.out.print("\\____________________/");
            System.out.print("\t\t");
        }
        System.out.println();
    }
}
