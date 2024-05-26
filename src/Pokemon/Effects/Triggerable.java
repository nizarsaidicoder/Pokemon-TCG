package Pokemon.Effects;
import  Player.Player;

public interface Triggerable {
    abstract public void activate(Player currentPlayer, Player opponentPlayer);
    abstract public void deactivate();
}
