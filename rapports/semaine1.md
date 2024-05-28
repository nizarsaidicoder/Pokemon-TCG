# RENDU SEMAINE_1

Binôme : Haggui Nesrine | Saidi Nizar

## Fonctionnalités implémentées

- **Fonctionnalité 1** : L'affichage :
  - Du status du jeu
  - De la pioche du joueur/ordinateur
  - De la main du joueur/ordinateur
  - De la défausse du joueur/ordinateur
  - Du terrain du joueur/ordinateur
- **Fonctionnalité 2** : Un pokémon peut attaquer un autre pokémon
- **Fonctionnalité 3** : Initialiser les class Game.Game et Player pour le développement

## Choix de conception

- Chaque joueur à ses propres attributs (Field, Hand, Deck, Graveyard)
- terrain, main, pioche, défausse sont des classes (Field, Hand, Deck, Graveyard)
- Les classes (Field, Hand, Deck, Graveyard) sont initialisées dans la classe Player

On a estimé qu'un terrain, une main, un deck et une défausse dépendent de chaque joueur.
Mais étant donné que tous ses attributs ont des méthodes quelques peu similaires, une optimisation de cela est à prévoir.

- Les classes sont initialisées dans la classe Game.Game.

La classe Game.Game se charge de gérer le bon déroulement du jeu. (A voir si cette classe a une trop grande responsabilité)

- On a une classe Player et AI qui hérite de Player

Le joueur AI (ordi) réalise les mêmes actions du joueur à quelques différences près.

## Difficultés rencontrées

- 1 heure pour comprendre le sujet
- La gestion du git et des branches
- La gestion des classes et des attributs 

## Prévision pour la semaine prochaine

- Implémenter les fonctionnalités suivantes
  - Déroulement du jeu
  - Gestion des affinités
  - Gestion des mains
  - Gestion des decks
  - Gestion des terrains
  - Gestion des défausses
  - Gestion des attaques
