RENDU SEMAINE_2
Binôme : Haggui Nesrine | Saidi Nizar

# Fonctionnalités implémentées


## Fonctionnalité 1 : Les affinités
    - Les pokémons ont maintenant une affinités prédéfini (Earth, Fire, Air, Water)
    - Les affinités ont un impact sur les attaques

## Fonctionnalité 2 : La gestion des collections suivantes
    - Gestion des mains
    - Gestion des decks
    - Gestion des terrains
    - Gestion des défausses

## Fonctionnalité 3 : la génération aléatoire des pokémons

# Choix de conception

- Pour ne pas dupliquer le code : Field, Hand, Deck et Graveyard sont des *Collections* (hérite de la classe CardCollection) puisqu'il ont les mêmes attributs ainsi que les méthodes.
- On génére les pokémons dans le main à partir d'une liste des noms de pokémons, et puis on les fournissent à chaque joueur pour qu'il les stockent dans sa pioche (DECK)
- Une affinité est une classe qui contient un seul attribut (m_element) de type Element, et deux méthodes abstraites getStrength() et getWeakness() qui doît être implémentées par les classes filles(Earth, Fire, Air, Water), comme ça on peut faciliter la création d'une nouvelle affinité sans utiliser des switchs.

# Difficultés rencontrées

    - La gestion des affinités
    - L'organisation de la classe CardCollection


# Prévision pour la semaine prochaine

    - Déroulement des tours du jeu
    - Implémentation des actions du joueur/ordinateur
    - Optimisation de l'affichage
