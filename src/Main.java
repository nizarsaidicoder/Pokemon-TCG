public class Main {
    public static void main(String args[])
    {
        System.out.println("Lancement du jeu ...");
        Field field = new Field();
        field.addPokemon(new Pokemon("Pikachu", 100, 50,50, "earth"));
        field.addPokemon(new Pokemon("Bulbizarre", 100, 50, 80,"fire"));
        field.addPokemon(new Pokemon("Salamèche", 100, 50, 100,"water"));
        field.addPokemon(new Pokemon("Carapuce", 100, 50, 120,"air"));
        field.displayField();
    }
}
