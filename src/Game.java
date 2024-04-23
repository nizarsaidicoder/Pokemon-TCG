import Player.Player;
import Player.AI;

public class Game
{
    private Player m_player;
    private AI m_ai;
    private Player m_currentPlayer;
    private Player m_winner = null;
    private int m_turn;

    /**
     * Constructeur de la classe Game
     */
    public void Game()
    {
        // Initialise les attributs de la classe
    }

    /**
     * Méthode pour démarrer le jeu
     */
    public void start()
    {
        // appelez la méthode welcome

        // Initialisez le tour à 1

        // Déterminez aléatoirement le premier joueur

        // Affichez un message pour indiquer le début du jeu

        // Tant que le jeu n'est pas terminé

            // - Affichez le tour actuel

            // - Affichez le joueur actuel

            // - Affichez :
            //   - nombre de pokémons restants dans la pioche du joueur
            //   - nombre de pokemons dans la cimetiere du joueur
            //   - pokemon dans le terrain du joueur

            // - Affichez :
            //   - nombre de pokémons restants dans la pioche de l'IA
            //   - nombre de pokemons dans la cimetiere de l'IA
            //   - pokemon dans le terrain de l'IA
            //  Le joueur actuel joue

            //  Appellez la méthode nextTurn

        // Appelez la méthode end
    }
    /**
     * Méthode pour terminer le jeu
     */
    public void end()
    {
        // Affichez un message pour indiquer la fin du jeu
        // Affichez le gagnant
    }
    /**
     * Méthode pour déterminer le premier joueur
     * @return 1 si le joueur commence, 2 si l'IA commence
     */
    public int determineFirstPlayer()
    {
        // Choisissez aléatoirement le premier joueur

        // Affichez un message pour indiquer qui commence

        // Retourne "1" si le joueur commence ou "2" si l'IA commence
        return 1;
    }
    /**
     * Méthode pour basculer entre les joueurs
     */
    public void switchPlayer()
    {
        // Changez le joueur actuel
    }
    /**
     * Méthode pour passer au tour suivant
     */
    public void nextTurn()
    {
        // Incrémentez le tour actuel
        // Changez le joueur actuel
    }
    /**
     * Méthode pour vérifier si le jeu est terminé
     * @return true si le jeu est terminé, false sinon
     */
    public boolean isGameOver()
    {
        // Le jeu est terminé si et seulement si player.isDefeated() ou ai.isDefeated() est vrai
        // Si le jeu est terminé, mettez à jour le gagnant
        return false;
    }
    /**
     * Méthode pour afficher un message de bienvenue
     */
    public void welcome()
    {
        // Affiche le logo du jeu

        // Affiche un message de bienvenue
    }

}
