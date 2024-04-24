package Player;
import Others.Deck;
import Others.Field;
import Others.Graveyard;
import Others.Hand;
import Pokemon.Pokemon;

public class Player {
    private Field m_field;
    private Graveyard m_graveyard;
    private Deck m_deck;
    private Hand m_hand;
    private int m_playerNumber;
    
    public Player()
    {
        // Initialise le deck, la main, le cimetière et le terrain
    }
    public void draw()
    {
        // Pioche un pokemon dans le deck

        // Ajoute le pokemon à la main

    }
    public void play(Player enemy)
    {
        // Phase de pioche

        // Phase d'invocation

        // Phase d'attaque
    }
    public void drawPhase()
    {
        // Phase de pioche
            // Tant que le joueur n'a pas 5 cartes en main
                // Pioche une carte
    }
    public void spawnPhase()
    {
        // Phase d'invocation
            // Tant que le joueur a des cartes en main et que le terrain n'est pas plein
                // Affiche la main
                // Demande au joueur de choisir une carte
                // Ajoute la carte au terrain
    }
    public void attackPhase()
    {
        // Phase d'attaque
        // Variable pour stocker les pokemons jouables
            // Tant que le joueur a des pokemons jouables sur le terrain et que l'adversaire a des pokemons sur le terrain
                // Affiche le terrain
                // Demande au joueur de choisir une carte
                // Attaque la carte choisie
    }
    public void showDeck()
    {
        // Affiche le deck
    }
    public void showGraveyard()
    {
        // Affiche le cimetière
    }
    public void showField()
    {
        // Affiche le terrain
    }
    public void showHand()
    {
        // Affiche la main
    }



}
