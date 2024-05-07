import Pokemon.*;
import java.util.ArrayList;

public class Pookemon {
  public static void main(String args[])
  {
    Game game = new Game();
    game.start();

    ArrayList<Pokemon> pokemons = game.createPokemons();

    for(Pokemon p : pokemons)
    {
      System.out.println(p.toString());
    }

  }
}
