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
            System.out.print(HelperFunctions.padRight("|   " + foreColor + pokemon.getName(),26)+ RESET+ "|");
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
            System.out.print(HelperFunctions.padRight("| Attack: " + Integer.toString(pokemon.getAttack()),21) + "|");
            System.out.print("\t\t");
        }
        System.out.println();

        for(Pokemon pokemon : pokemons)
        {
            System.out.print(HelperFunctions.padRight("| HP: " + Integer.toString(pokemon.getHP()),21) + "|");
            System.out.print("\t\t");
        }
        System.out.println();

        for(Pokemon pokemon : pokemons)
        {
            String foreColor = HelperFunctions.getCorrespondingColor(pokemon.getAffinity());
            System.out.print(HelperFunctions.padRight("| Affinity : " + foreColor + pokemon.getAffinity(),26) + RESET + "|");
            System.out.print("\t\t");
        }
        System.out.println();
        // DUMMY LOOP THAT SHOWS THE ELEMENTS THAT THE POKEMON IS STRONG AGAINST
        for(Pokemon pokemon : pokemons)
        {
            System.out.print("| Strong against :   |");
            System.out.print("\t\t");
        }
        System.out.println();
        for(Pokemon pokemon : pokemons) {
            String foreColor = HelperFunctions.getCorrespondingColor("fire");
            System.out.print(HelperFunctions.padRight("| " + foreColor + "fire", 26) + RESET + "|");
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
