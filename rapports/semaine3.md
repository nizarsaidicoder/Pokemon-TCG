RENDU SEMAINE_3
Binôme : Haggui Nesrine | Saidi Nizar

# Fonctionnalités implémentées

## Fonctionnalité 1 : L'avancement du jeu

    - Implémentation de la classe Game qui gère le déroulement du jeu
    - Implémentation de la classe Player qui gère les actions du joueur
    - Implémentation de la classe IA qui gère les actions de l'ordinateur

## Fonctionnalité 2 : Optimisation de l'affichage

    - Ajout de couleurs pour les affinités
    - Ajout de couleurs pour les cartes
    - Ajout de couleurs pour les actions
    - Les classes ne gèrent plus leur propre affichage. Une classe 'Display' se charge de ça.

## Fonctionnalité 3 : Implémentations de l'algorithme de l'IA

    - L'IA peut maintenant jouer des pokemon de sa main
    - L'IA peut maintenant attaquer avec ses pokemons selon les règles données

## Fonctionnalité 4 [BONUS]:

    - Ajout de la musique de fond
    - Ajout d'un effet sonore lors de l'attaque d'un pokemon
    - Ajout du ASCII Art pour le logo du jeu et la fin du jeu
    - Pour choisir entre le premier joueur et l'IA, on a ajouté un algorithme face ou pile

# Choix de conception

## Déroulement du jeu

- Pour le déroulement du jeu on a choisi d'implémenter une classe Game qui gère le déroulement du jeu au travers de deux méthodes:
- `start` : qui initialise la partie (Les decks, les mains, les défausses... ainsi que le premier joueur)

- `play` : qui gère le déroulement du jeu à partir des phases

  - `Draw Phase` : Chaque joueur pioche une carte de son deck tant que sa main n'est pas pleine et que son deck n'est pas vide
  - `Spawn Phase` : Chaque joueur peut poser un pokemon sur le terrain
  - `Battle Phase` : Chaque joueur peut attaquer avec ses pokemons

  ![alt text](../rapports/fontionnementJeu.png)

## L'Affichage

- Pour l'affichage on a choisi d'ajouter des couleurs pour les affinités, les cartes pour rendre le jeu plus attrayant et plus lisible

## L'Input

- On a opter pour un input de type `int` pour les choix de l'utilisateur ainsi il suffit d'entrer l'indice du pokémon pour le sélectionner (écrire le nom du pokémon serait trop long). De plus, la gestion des erreurs est plus facile avec un input de type `int`

# Difficultés rencontrées

    - La gestion des phases du jeu
