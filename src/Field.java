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
        String RESET = "\033[0m";  // Text Color Reset
        for(int i = 0; i < pokemons.size(); i++)
        {
            System.out.print(" ____________________ ");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i = 0; i < pokemons.size(); i++)
        {
            System.out.print("|                    |");
            System.out.print("\t\t");
        }
        System.out.println();
        for(Pokemon pokemon : pokemons)
        {
            String foreColor = HelperFunctions.getCorrespondingColor(pokemon.getAffinity());
            System.out.print("|     " + foreColor + HelperFunctions.padRight(pokemon.getName(),15)+ RESET+ "|");
            System.out.print("\t\t");
        }
        System.out.println();

        for(int i = 0; i < pokemons.size(); i++)
        {
            System.out.print("|____________________|");
            System.out.print("\t\t");
        }
        System.out.println();

        for(Pokemon pokemon : pokemons)
        {
            System.out.print("| Attack: " + HelperFunctions.padRight(Integer.toString(pokemon.getAttack()),11) + "|");
            System.out.print("\t\t");
        }
        System.out.println();

        for(Pokemon pokemon : pokemons)
        {
            System.out.print("| HP: " + HelperFunctions.padRight(Integer.toString(pokemon.getHP()),15) + "|");
            System.out.print("\t\t");
        }
        System.out.println();

        for(Pokemon pokemon : pokemons)
        {
            String foreColor = HelperFunctions.getCorrespondingColor(pokemon.getAffinity());
            System.out.print("| Affinity : " + foreColor + HelperFunctions.padRight(pokemon.getAffinity(),8) + RESET + "|");
            System.out.print("\t\t");
        }
        System.out.println();

        for(int i = 0; i < pokemons.size(); i++)
        {
            System.out.print("|____________________|");
            System.out.print("\t\t");
        }
        System.out.println();
        for(int i = 0; i < pokemons.size(); i++)
        {
            System.out.print("\\____________________/");
            System.out.print("\t\t");
        }
        System.out.println();
    }
}
