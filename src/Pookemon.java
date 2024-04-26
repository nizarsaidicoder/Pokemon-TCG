public class Pookemon {
  public static void main(String args[])
  {
    System.out.println("Lancement du jeu ...");
    Game game = new Game();
    game.showGameStatus();

    //tests Pokemon
    // Pokemon pikachu = new Pokemon("Pikachu", 100, 100,50, "earth");
    // Pokemon bulbizarre = new Pokemon("Bulbizarre", 100, 100, 80,"fire");

    // System.out.println(bulbizarre.toString());
    // pikachu.attack(bulbizarre);
    // System.out.println(bulbizarre.toString());
  }
}
