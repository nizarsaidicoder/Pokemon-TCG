package Player;

import Collection.Deck;
import Collection.Field;
import Collection.Graveyard;
import Collection.Hand;
import Pokemon.Effects.*;
import Pokemon.Pokemon;
import Pokemon.PokemonWithPower;
import UI.UIFunctions;
import UI.Display;

import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    /**
     * Attributs
     */
    protected String m_name;
    protected Field m_field;
    protected Graveyard m_graveyard;
    protected Deck m_deck;
    protected Hand m_hand;
    protected int m_playerNumber;
    private Scanner m_scanner = new Scanner(System.in);

    /*
     * Constructeur de la classe Player
     */
    public Player(ArrayList<Pokemon> pokemons,int playerNumber,String name)
    {
        // Initialise le deck, la main, le cimetière et le terrain
        m_field = new Field(3);
        m_graveyard = new Graveyard(21);
        m_deck = new Deck(21,pokemons);
        m_hand = new Hand(5);
        m_playerNumber = playerNumber;
        m_name = name;
    }

    /*
     * Methode pour piocher une carte
     */
    public void draw()
    {
        Pokemon pokemon = m_deck.pickPokemon(0);
        // Ajoute le pokemon à la main
        m_hand.addPokemon(pokemon);
    }
    /**
     * Methode pour piocher un pokemon
     */
    public void spawn()
    {
        // Prompt the player to choose a pokemon to spawn from the hand
        System.out.print(UIFunctions.colorize("Choose a pokemon to spawn : ", "blue"));
        // Recupere le pokemon à jouer
        int index = -1;
        // check if the player entered a valid pokemon index
        while(index == -1)
        {
            try
            {
                index = Integer.parseInt(m_scanner.nextLine()) -1;
                if(index < 0 || index >= m_hand.getPokemons().size())
                {
                    System.out.println(UIFunctions.colorize("Invalid index, please enter a valid index", "red"));
                    System.out.print(UIFunctions.colorize("Choose a pokemon to spawn : ", "blue"));
                    index = -1;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println(UIFunctions.colorize("Invalid index, please enter a valid index", "red"));
                System.out.print(UIFunctions.colorize("Choose a pokemon to spawn : ", "blue"));
            }
        }
        // Ajoute un pokemon du terrain
        m_field.addPokemon(m_hand.pickPokemon(index));
    }
    public boolean playEffects(Player opponent) {
        boolean continueEffectPhase = true;
        while (continueEffectPhase) {
            String choice = getUserChoice(opponent);
            switch (choice) {
                case "y":
                case "yes":
                    continueEffectPhase = handleYesChoice(opponent);
                    break;
                case "n":
                case "no":
                    return false;
                case "s":
                    handleSeeChoice(opponent);
                    break;
                case "q":
                case "quit":
                    return false;
                default:
                    System.out.print(UIFunctions.colorize("Invalid choice, please enter (Y)es, (N)o, or (S)ee the effects preview: ", "red"));
            }
        }
        return false;
    }

    /**
     * Methode pour demander au joueur de choisir une action
     * @return choix du joueur
     */
    private String getUserChoice(Player opponent)
    {
        ArrayList<PokemonWithPower> pokemonsWithPower = m_field.getPokemonsWithPower();
        boolean canPlayEffect = false;
        for(PokemonWithPower pokemon : pokemonsWithPower)
        {
            Display.printPokemon(pokemon);
            canPlayEffect = pokemon.getEffect().getTargetType() != TargetType.ENEMY || !opponent.getField().isEmpty();
            if(canPlayEffect) break;
        }
        if(canPlayEffect)
        {
            System.out.print("Do you want to play a pokemon effect : (Y)es, (N)o, (S)ee the effects preview : ");
        }
        else
        {
            System.out.print("(Q)uit or (S)ee the effects preview : ");
        }
        return m_scanner.nextLine().toLowerCase();
    }

    /**
     * Methode qui permet au joueur de jouer un effet
     * @param opponent joueur adverse
     * @return true si le joueur à toujours des effets à jouer, false sinon
     */
    private boolean handleYesChoice(Player opponent) {
        useEffects(opponent);
        return hasEffects();
    }

    /**
     * Methode pour afficher les effets
     * @param opponent joueur adverse
     */
    private void handleSeeChoice(Player opponent) {
        ArrayList<Effect> activeEffects = new ArrayList<>();
        activeEffects.addAll(getActiveEffects());
        activeEffects.addAll(opponent.getActiveEffects());
        Display.printEffects(activeEffects);
        
        StringBuilder message = new StringBuilder("Which Effect you want to see its description: ");
        for (int i = 0; i < activeEffects.size(); i++) {
            message.append(activeEffects.get(i).getPower()).append(" (").append(i + 1).append(") ");
        }
        message.append(" OR (0) to exit: ");
        System.out.print(message.toString());
        
        int index = getUserEffectChoice(activeEffects.size(), message.toString());
        if (index != 0) {
            Display.printEffect(activeEffects.get(index - 1));
        }
    }

    /**
     * Methode pour demander au joueur de choisir un effet
     * @param effectCount nombre d'effets
     * @param message message à afficher
     * @return index de l'effet choisi
     */
    private int getUserEffectChoice(int effectCount, String message) {
        int index = -1;
        while (index == -1) {
            try {
                index = Integer.parseInt(m_scanner.nextLine());
                if (index < 0 || index > effectCount) {
                    System.out.println(UIFunctions.colorize("Invalid index, please enter a valid index", "red"));
                    System.out.print(message);
                    index = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println(UIFunctions.colorize("Invalid index, please enter a valid index", "red"));
                System.out.print(message);
            }
        }
        return index;
    }

    /**
     * Methode pour savoir si le joueur a des effets à jouer
     * @return true si le joueur a des effets à jouer, false sinon
     */
    public boolean hasEffects()
    {
        for(PokemonWithPower pokemon : m_field.getPokemonsWithPower())
        {
            if(!pokemon.getEffect().isUsed())
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Methode pour jouer les effets
     * @param opponent joueur adverse
     */
    public boolean useEffects(Player opponent)
    {
        PokemonWithPower pokemonWithPower = promptPokemonWithPower(opponent);
        if(pokemonWithPower == null) return false;
        Pokemon targetPokemon = getTargetPokemon(pokemonWithPower,opponent);
        pokemonWithPower.activateEffect(targetPokemon);
        killDeadPokemons(opponent);
        return true;
    }

    /**
     * Methode pour tuer les pokemons qui n'ont plus de points de vie
     * @param opponent joueur adverse
     */
    public void killDeadPokemons(Player opponent)
    {
        ArrayList<Pokemon> pokemosToKill = new ArrayList<>();
        try
        {
            for(int i = 0; i < m_field.getPokemons().size(); i++)
            {
                if(!m_field.getPokemon(i).isAlive())
                {
                    pokemosToKill.add(m_field.getPokemon(i));
                }
            }
            for(Pokemon pokemon : pokemosToKill)
            {
                m_graveyard.addPokemon(pokemon);
                m_field.removePokemon(pokemon);
            }
            pokemosToKill.clear();
            for(int i = 0; i < opponent.getField().getPokemons().size(); i++)
            {
                if(!opponent.getField().getPokemon(i).isAlive())
                {
                    pokemosToKill.add(opponent.getField().getPokemon(i));
                }
            }
            for(Pokemon pokemon : pokemosToKill)
            {
                opponent.getGraveyard().addPokemon(pokemon);
                opponent.getField().removePokemon(pokemon);
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Methode pour attaquer un joueur
     * @param opponent joueur adverse
     */
    public void attack(Player opponent)
    {
        Pokemon pokemon = promptPokemon();
        // Prompt the player to choose a pokemon to attack
        Pokemon enemyPokemon = promptEnemyPokemon(opponent);
        // Attaque le pokemon
        pokemon.attack(enemyPokemon);
        if(!enemyPokemon.isAlive()) {
            // Ajoute le pokemon adverse au cimetière
            opponent.getGraveyard().addPokemon(enemyPokemon);
            opponent.getField().removePokemon(enemyPokemon);
        }
    }
    /**
     * Methode pour attribuer les pokemons jouables
     */
    public void setPlayablePokemons()
    {
        // Parcourt la main et met à jour les pokemons jouables
        for(Pokemon pokemon : m_field.getPokemons())
        {
            pokemon.setAttackPoints(pokemon.getAttackPoints() + 1);
        }
    }
    /**
     * Methode pour savoir si le joueur a des pokemons jouables
     * @return true si le joueur a des pokemons jouables, false sinon
     */
    public boolean hasPlayablePokemons()
    {
        for(Pokemon pokemon : m_field.getPokemons())
        {
            if(pokemon.getAttackPoints() > 0)
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Methode pour recuperer les pokemons jouables
     * @return liste des pokemons jouables
     */
    public ArrayList<Pokemon> getPlayablePokemons()
    {
        ArrayList<Pokemon> playablePokemons = new ArrayList<>();
        for(Pokemon pokemon : m_field.getPokemons())
        {
            if(pokemon.getAttackPoints() > 0)
            {
                playablePokemons.add(pokemon);
            }
        }
        return playablePokemons;
    }
    /*
     * Methode pour savoir si le joueur est vaincu
     * @return true si le joueur est vaincu, false sinon
     */
    public boolean isDefeated()
    {
        return m_field.isEmpty() && m_hand.isEmpty() && m_deck.isEmpty();
    }

    /**
     * Methode pour demander au joueur de choisir un pokemon
     * @return pokemon choisi
     */
    public Pokemon promptPokemon()
    {
        // Prompt the player to choose a pokemon to attack with
        StringBuilder message = new StringBuilder("Choose a pokemon to attack with : ( ");
        for(int i= 0; i < m_field.getPokemons().size(); i++)
        {
            if(m_field.getPokemon(i).getAttackPoints()>0) message.append(m_field.getPokemon(i).getName()).append("(").append(i + 1).append(") ");
        }
        message.append(" ) : ");
        System.out.print(message);
        // Recupere le pokemon à jouer
        int index = -1;
        while(index == -1)
        {
            try
            {
                index = Integer.parseInt(m_scanner.nextLine()) -1;
                if(index < 0 || index >= m_field.getPokemons().size() || m_field.getPokemon(index).getAttackPoints() < 1)
                {
                    System.out.println(UIFunctions.colorize("Invalid index, please enter a valid index","red"));
                    System.out.print(message);
                    index = -1;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println(UIFunctions.colorize("Invalid index, please enter a valid index","red"));
                System.out.print(message);
            }
        }
        return m_field.getPokemons().get(index);
    }
    public PokemonWithPower promptPokemonWithPower(Player opponent)
    {
        // Prompt the player to choose a pokemon to attack with
        ArrayList<PokemonWithPower> pokemonsWithPower = m_field.getPokemonsWithPower();
        for(PokemonWithPower pokemon : pokemonsWithPower)
        {
           if( pokemon.getEffect().getTargetType() == TargetType.ENEMY && opponent.getField().isEmpty())
               pokemonsWithPower.remove(pokemon);
        }
        if(pokemonsWithPower.isEmpty()) return null;
        StringBuilder message = new StringBuilder("Choose a pokemon to use its effect : ( ");
        for(int i=0; i< pokemonsWithPower.size(); i++)
        {
            if(!pokemonsWithPower.get(i).getEffect().isUsed())
                message.append(pokemonsWithPower.get(i).getName()).append("(").append(i + 1).append(") ");
        }
        message.append(" ) : ");
        System.out.print(message);
        // Recupere le pokemon à jouer
        int index = -1;
        while(index == -1)
        {
            try
            {
                index = Integer.parseInt(m_scanner.nextLine()) -1;
                if(index < 0 || index >= pokemonsWithPower.size() || pokemonsWithPower.get(index).getEffect().isUsed())
                {
                    System.out.println(UIFunctions.colorize("Invalid index, please enter a valid pokemon index","red"));
                    System.out.print(message);
                    index = -1;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println(UIFunctions.colorize("Invalid index, please enter a valid pokemon index","red"));
                System.out.print(message);
            }
        }
        return pokemonsWithPower.get(index);
    }

    /**
     * Methode pour demander au joueur de choisir un pokemon adverse
     * @param pokemonWithPower pokemon avec pouvoir
     * @param opponent joueur adverse
     * @return pokemon adverse choisi
     */
    public Pokemon getTargetPokemon(PokemonWithPower pokemonWithPower, Player opponent)
    {
        // Prompt the player to choose a pokemon to attack
        String message = "Choose a pokemon to target with " + pokemonWithPower.getName() + " : ( ";
        ArrayList<Pokemon> targetPokemons = new ArrayList<>();
        if(pokemonWithPower.getEffect().getTargetType() == TargetType.ENEMY)
        {
            targetPokemons = opponent.getField().getPokemons();
        }
        else if(pokemonWithPower.getEffect().getTargetType() == TargetType.ALLY)
        {
            targetPokemons = m_field.getPokemons();
        }
        else if(pokemonWithPower.getEffect().getTargetType() == TargetType.BOTH)
        {
            targetPokemons.addAll(m_field.getPokemons());
            targetPokemons.addAll(opponent.getField().getPokemons());
        }
        for(int i = 0; i < targetPokemons.size(); i++)
        {
            message += targetPokemons.get(i).getName() + " (" + (i+1) + ") ";
        }
        message += " ) : ";
        System.out.print(message);
        // Recupere le pokemon à attaquer
        int index = -1;
        while(index == -1)
        {
            try
            {
                index = Integer.parseInt(m_scanner.nextLine()) -1;
                if(index < 0 || index >= targetPokemons.size())
                {
                    System.out.println(UIFunctions.colorize("Invalid index, please enter a valid index","red"));
                    System.out.print(message);
                    index = -1;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println(UIFunctions.colorize("Invalid index, please enter a valid index","red"));
                System.out.print(message);
            }
        }
        return targetPokemons.get(index);
    }
    /**
     * Methode pour demander au joueur de choisir un pokemon adverse
     * @param opponent joueur adverse
     * @return pokemon adverse choisi
     */
    public Pokemon promptEnemyPokemon(Player opponent)
    {
        // Prompt the player to choose a pokemon to attack
        StringBuilder message = new StringBuilder("Choose a pokemon to attack ( ");
        for(int i = 0; i < opponent.getField().getPokemons().size(); i++)
        {
            message.append(opponent.getField().getPokemon(i).getName()).append(" (").append(i + 1).append(") ");
        }
        message.append(" ) : ");
        System.out.print(message);
        // Recupere le pokemon à attaquer
        int index = -1;
        while(index == -1)
        {
            try
            {
                index = Integer.parseInt(m_scanner.nextLine()) -1;
                if(index < 0 || index >= opponent.getField().getPokemons().size())
                {
                    System.out.println(UIFunctions.colorize("Invalid index, please enter a valid index","red"));
                    System.out.print(message);
                    index = -1;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println(UIFunctions.colorize("Invalid index, please enter a valid index","red"));
                System.out.print(message);
            }
        }
        return opponent.getField().getPokemon(index);
    }
    /**
     * Retourn le numéro du joueur
     * @return numéro joueur
     */
    public int getPlayerNumber()
    {
        return m_playerNumber;
    }
    /**
     * Retourne le nom du joueur
     * @return nom joueur
     */
    public String getName(){return m_name;}
    /**
     * Retourne le terrain du joueur
     * @return terrain joueur
     */
    public Field getField()
    {
        return m_field;
    }
    /**
     * Retourne la main du joueur
     * @return main joueur
     */
    public Deck getDeck()
    {
        return m_deck;
    }
    /**
     * Retourne la main du joueur
     * @return main joueur
     */
    public Hand getHand()
    {
        return m_hand;
    }
    /**
     * Retourne le cimetière du joueur
     * @return cimetière joueur
     */
    public Graveyard getGraveyard()
    {
        return m_graveyard;
    }

    /**
     * Methode pour recuperer les effets actifs
     * @return liste des effets actifs
     */
    public ArrayList<Effect> getActiveEffects()
    {
        ArrayList<Effect> activeEffects = new ArrayList<>();
        for(PokemonWithPower pokemon : m_field.getPokemonsWithPower())
        {
            if(!pokemon.getEffect().isUsed())
            {
                activeEffects.add(pokemon.getEffect());
            }
        }
        return activeEffects;
    }

}
