package Game;

import Pokemon.*;
import Player.Player;
import Player.AI;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import UI.Display;
import UI.UIFunctions;

public class Game
{
    private Player m_player;
    private AI m_ai;
    private Player m_currentPlayer;
    private Player m_opponent;
    private String m_winner;
    private Scanner m_scanner = new Scanner(System.in);

    private int m_turn;
    public Game()
    {
        // Initialise les attributs de la classe
        m_winner = null;
        m_turn = 1;
    }
    /**
     * Méthode pour démarrer le jeu
     */
    public void start()
    {
        // appelez la méthode welcome
        Display.intro();
        // Appelez la méthode initializePlayers
        intializePlayers();
        Display.coinFlip(m_player);
    }

    /**
     * Méthode pour jouer le jeu
     */
    public void play()
    {
        while (!isGameOver())
        {
            drawPhase();
            spawnPhase();
            EffectPhase();
            battlePhase();
            endPhase();
        }
        Display.outro(m_winner);
    }

    /**
     * La phase de pioche où le joueur actuel pioche des cartes
     */
    public void drawPhase()
    {
        // tant que la main du joueur actuel est vide et que le deck du joueur actuel n'est pas vide
        while(!m_currentPlayer.getHand().isFull() && !m_currentPlayer.getDeck().isEmpty()) m_currentPlayer.draw();
    }

    /**
     * La phase d'invocation où le joueur actuel invoque des pokémons
     */
    public void spawnPhase()
    {
        // tant que le joueur actuel a des cartes en main et que le terrain n'est pas plein
        while(!m_currentPlayer.getHand().isEmpty() && !m_currentPlayer.getField().isFull())
        {
            Display.gameStatus(m_turn, m_currentPlayer, m_player, m_ai);
            Display.spawnPhase();
            m_currentPlayer.spawn();
        }
    }

    /**
     * La phase d'effet où le joueur actuel utilise les effets de ses pokémons
     */

    public void EffectPhase()
    {
        // Tant que le joueur a des pokemons qui ont des effets pas encore utilisés
        boolean continueEffectPhase = true;
        while(m_currentPlayer.hasEffects() && continueEffectPhase)
        {
            Display.gameStatus(m_turn, m_currentPlayer, m_player, m_ai);
            Display.effectPhase();
            continueEffectPhase =  m_currentPlayer.playEffects(m_opponent);
        }
    }
    /**
     * La phase de bataille est une phase où le joueur actuel attaque l'adversaire
     */
    public void battlePhase()
    {
        // Mettez à jour les pokémons jouables du joueur actuel
        if(!m_opponent.getField().isEmpty()) m_currentPlayer.setPlayablePokemons();
        // tant que le joueur actuel a des pokemons jouables sur le terrain et que l'adversaire a des pokemons sur le terrain
        while(m_currentPlayer.hasPlayablePokemons() && !m_opponent.getField().isEmpty())
        {
            Display.gameStatus(m_turn, m_currentPlayer, m_player, m_ai);
            Display.battlePhase();
            m_currentPlayer.attack(m_opponent);
        } 
    }
    /**
     * La phase de fin où le joueur actuel passe au joueur suivant
     */
    public void endPhase()
    {
        // Passez au joueur suivant et incrémentez le tour
        if(m_currentPlayer == m_player)
        {
            m_currentPlayer = m_ai;
            m_opponent = m_player;
        }
        else
        {
            m_currentPlayer = m_player;
            m_opponent = m_ai;
        }
        m_turn++;
    }
    /**
     * Méthode pour initialiser les joueurs
     */
    public void intializePlayers()
    {
        // Générez les pokémons
        // Déterminez aléatoirement le premier joueur
        ArrayList<Pokemon> pokemons = PokemonGenerator.createPokemons();
        String playerName = promptUserName();
        boolean firstPlayer = decideFirstPlayer();
        if (firstPlayer)
        {
            m_player = new Player(new ArrayList<>(pokemons.subList(0, 20)),1,playerName);
            m_ai = new AI(new ArrayList<>(pokemons.subList(20,41)),2);
            m_currentPlayer = m_player;
            m_opponent = m_ai;
        }
        else
        {
            m_player = new Player(new ArrayList<>(pokemons.subList(20,41)),2,playerName);
            m_ai = new AI(new ArrayList<>(pokemons.subList(0, 20)),1);
            m_currentPlayer = m_ai;
            m_opponent = m_player;
        }
    }
    /**
     * Méthode pour déterminer le premier joueur
     * @return true si le joueur commence, false sinon
     */
    public boolean decideFirstPlayer()
    {
        System.out.println(UIFunctions.colorizeAndCenter("Deciding who starts ...", "purple", 100));
        // Prompt the user to press Enter to continue
        System.out.print(UIFunctions.colorize("(H)eads or (T)ails ? :  ","yellow"));
        String choice = m_scanner.nextLine().toLowerCase();
        System.out.println();
        while(!choice.equals("heads") && !choice.equals("tails") && !choice.equals("h") && !choice.equals("t"))
        {
            System.out.println(UIFunctions.colorize("Invalid choice, please enter (H)eads or (T)ails ? : ", "red"));
            choice = m_scanner.nextLine().toLowerCase();
            System.out.println();
        }
        Random rnd = new Random();
        int coin = rnd.nextInt(2) + 1;
        return ((coin == 1 && (choice.equals("heads") ||choice.equals("h"))) || ((coin == 2 && (choice.equals("tails") || choice.equals("t")))));
    }
    public String promptUserName()
    {
        System.out.print(UIFunctions.colorize("Enter your name: ", "yellow"));
        return m_scanner.nextLine();
    }
    /**
     * Méthode pour vérifier si le jeu est terminé
     * @return true si le jeu est terminé, false sinon
     */
    public boolean isGameOver()
    {
        // Le jeu est terminé si et seulement si player.isDefeated() ou ai.isDefeated() est vrai
        if(m_player.isDefeated())
        {
            m_winner = "Computer";
            return true;
        }
        if(m_ai.isDefeated())
        {
            m_winner = "You";
            return true;
        }
        // Si le jeu est terminé, mettez à jour le gagnant
        return false;
    }

}
