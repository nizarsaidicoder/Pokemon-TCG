RENDU SEMAINE_4
Binôme : Haggui Nesrine | Saidi Nizar

# Fonctionnalités implémentées

## Fonctionnalité 1 : Pouvoir des pokémons

    - Implémentation du package 'Effects' :

        - Implémentation de la classe 'Effect' qui gère les pouvoirs des pokémons
        - Implémentation de l'énumération 'Power' qui liste les noms de tous les pouvoirs implémentés
        - Implémentation de l'énumération 'TargetType' qui liste les cibles que peut avoir un pouvoir

    - Implémentation du package 'Abilities' :

        - Implémentation de la classe 'A_Ether'
        - Implémentation de la classe 'A_Plomb'
        - Implémentation de la classe 'Berserk'
        - Implémentation de la classe 'DejaVu'
        - Implémentation de la classe 'Kamikaze'
        - Implémentation de la classe 'Regeneration'
        - Implémentation de la classe 'Resistance'
        - Implémentation de la classe 'SoinTotal'

## Fonctionnalité 2 : Nouvelles affinités

    - Implémentation de la classe 'Ether' (pouvoir)
    - Implémentation de la clases 'Plomb' (pouvoir)

## Fonctionnalité 3 : Tests des pouvoirs

    - Implémentation des tests pour tester chaque pouvoir

## Fonctionnalité 4 : Génération aléatoire des pokémons

    - Séparation de la génération des pokémons de la classe 'Game' => création d'une classe 'PokemonGenerator'

# Choix de conception

## Les pouvoirs des pokémons

    - Un pokémon possède un effet, et chaque effet possède un 'owner', un propriétaire. Ainsi la classe 'Effect' est abstraite et d'elle découle tous les autres pouvoirs.
    - Un pouvoir s'active grâce à la méthode abstraite 'activate()' pour qu'on puisse activer un pouvoir de la même façon pour tous.

# Difficultés rencontrées

    - La gestion des pouvoirs : 
        on a passés de nombreuses heures à imaginer, tester, implémenter plusieurs structures différentes pour pouvoir implémenter les pouvoirs des pokémons.
