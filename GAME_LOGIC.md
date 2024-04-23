<!-- HOW DOES THE GAME WORK
I - We create a new instance of the Jeu
In the constructor of the jeu, We call the debuterPartie() method
PLAYERS CREATION
We determine the first player by using the determinerPremierJoueur() method
We create two players, one human and one IA
TERRAIN CREATION
We create the terrain of each player
We create the pioche and the defausse of each player
We create the main of each player
II - We start the game
In debuterPartie() method :
Initialiser la variable tour à 1
Afficher l'art de début de jeu en utilisant la fonction afficheDebutJeu()
Tant que le jeu n'est pas terminé, on appelle la méthode prochainTour()
III - We play the game
In prochainTour() method :
On affiche les terrains des deux joueurs
On appelle la méthode jouerTour() du joueur dont c'est le tour
On change de joueur
IV - We finish the game
In finaliserPartie() method :
On affiche le vainqueur
On affiche l'art de fin de jeu
On demande si on veut rejouer
Si oui, on creer une nouvelle instance de Jeu
Logic of classes
Jeu
Attributes
joueur <Joueur> : The current player
joueurIA <JoueurIA> : The Computer player
tour <Integer> : The current turn of the game
vainqueur <Joueur/JoueurIA> : The winner of the game
Methods
debuterPartie()
{
determinerPremierJoueur()
finaliserPartie()
prochainTour()
afficherTerrains()
} -->
