import Player.Player;
import Player.AI;

public class Game
{
    private final Player m_player;
    private final AI m_ai;
    private Player m_currentPlayer;
    private String m_winner;
    private int m_turn;

    /**
     * Constructeur de la classe Game
     */
    public Game()
    {
        // Initialise les attributs de la classe
        m_player = new Player(1);
        m_ai = new AI(2);
        m_currentPlayer = m_player;
        m_winner = null;
        m_turn = 99;
    }

    /**
     * Méthode pour démarrer le jeu
     */
    public void start()
    {
        // appelez la méthode welcome

        // Déterminez aléatoirement le premier joueur

        // Affichez un message pour indiquer le début du jeu

        // Tant que le jeu n'est pas terminé
//             drawPhase();
//             spawnPhase();
//             attackPhase();
//             endPhase();
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
    public void drawPhase()
    {
        // tant que le joueur actuel n'a pas 5 cartes en main
        // affiche le statut du jeu ( en-tete, joueur1, joueur2)
        //  currentPlayer.draw();
    }
    public void spawnPhase()
    {
        // tant que le joueur actuel a des cartes en main et que le terrain n'est pas plein
        // affiche le statut du jeu ( en-tete, joueur1, joueur2)
        //  currentPlayer.spawn();
    }
    public void attackPhase()
    {
        // tant que le joueur actuel a des pokemons jouables sur le terrain et que l'adversaire a des pokemons sur le terrain
        // affiche le statut du jeu ( en-tete, joueur1, joueur2)
        //  currentPlayer.attack(opponent);
        // !!! Attention !!!
        // Il faut passer l'autre joueur en paramètre de la méthode play, pour que le joueur actuel puisse attaquer l'autre joueur
    }

    public void endPhase()
    {
        // Phase de fin
        // basculer entre les joueurs
        // incrémenter le tour
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
    /**
     * Méthode pour afficher le tour actuel et le joueur actuel
     */
    public void showTurnAndCurrentPlayer()
    {
        // Affiche le joueur actuel
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|---------Turn : "+ m_turn + "----------|" + "|----------Current Player : " + m_currentPlayer.getPlayerNumber() + " -------------|");
        System.out.println("-----------------------------------------------------------------------------------------");
    }
    public void showGameStatus()
    {
        // Affiche le statut du jeu
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("************************************** GAME STATUS **************************************");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        showTurnAndCurrentPlayer();
        m_ai.display();
        System.out.println();

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();

        m_player.display();
    }
}
