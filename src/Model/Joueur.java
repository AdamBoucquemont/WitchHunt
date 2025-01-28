package Model;

import java.util.*;

/**
 * Nous avons ici la classe Joueur
 * 
 * 
 * @author Adam
 *
 */

public abstract class Joueur {

     /**
      * Valeur representant le numero du joueur
      * 
      * 
      */
     protected int numJoueur;

     /**
      * Valeur representant le numero du joueur
      * 
      * 
      */
     protected String nomJoueur;

     /**
      * Valeur representant le numero du joueur
      * 
      *
      */
     protected boolean villageois;

     /**
      * Valeur representant le numero du joueur
      * 
      * 
      */
     protected int point;

     /**
      * Valeur representant le numero du joueur
      * 
      * 
      */
     protected boolean carteRevelee;

     /**
      * Valeur representant le numero du joueur
      * 
      * 
      */
     public boolean gagnant;

     /**
      * Valeur representant le numero du joueur
      * 
      * 
      */
     protected boolean protectionBroomstick = false;

     /**
      * Valeur representant le numero du joueur
      * 
      * 
      */
     protected boolean protectionWart = false;

     /**
      * Valeur representant le numero du joueur
      * 
      * 
      */
     protected boolean utilisationEvilEye = false;

     /**
      * Valeur representant le numero du joueur
      * 
      *
      */
     protected LinkedList<Carte> main;

     /**
      * Valeur representant le numero du joueur
      * 
      * 
      */
     protected LinkedList<Carte> nouvelleMain;

     /**
      * Valeur representant le numero du joueur
      * 
      *
      */
     protected LinkedList<Carte> carteJouee;

     /**
      * Valeur representant le numero du joueur
      * 
      *
      */
     protected static List<Carte> cartesDefaussees = new ArrayList<Carte>();

     /**
      * Valeur representant le numero du joueur
      * 
      *
      */
     private Carte carte;

     /**
      * Valeur representant le numero du joueur
      * 
      *
      */

     /**
      * Methode permettant de rammaser une carte et de l'ajouter aux siennes
      * 
      * @param carte la carte que l'on veut ramasser
      */
     public void ramasserCarte(Carte carte) {
          main.add(carte);
     }

     /**
      * Constructeur de la classe joueur.
      * 
      * @param i le numero du joueur
      */
     public Joueur(int i) {
          this.numJoueur = i;
          this.point = 0;
          this.gagnant = false;
          this.main = new LinkedList<Carte>();
          this.carteJouee = new LinkedList<Carte>();
     }

     /**
      * Cette methode permet de retirer une carte de la main d'un des joueurs
      * 
      * @param c la carte que va etre retiree
      */
     public void retirerCarte(Carte c) {
          Carte m = main.get(0);
          int n = 0;
          while (m.equals(c) == false) {
               n = n + 1;
               m = main.get(n);
          }
          carteJouee.add(m);
          Partie witchHunt = new Partie();
          cartesDefaussees.add(m);
          main.remove(n);
     }

     // Methodes abstraites permettant aux joueurs de faire leurs actions

     /**
      * Cette fonction abstraite permet au joueur de choisir ce qu'il veut faire
      * 
      * @param n le numero du joueur e qui est le tour
      * @return un entier qui correspond e son choix (1 si il veut accuser un autre
      *         joueur et 2 s'il veut utiliser une carte hunt).
      *
      */
     public abstract int queFaire(int n);

     /**
      * Cette fonction permet de choisir quel joueur on veut accuser
      * 
      * @param listeNumero c'est la liste de tous les joueurs accusable (dont la
      *                    carte n'a pas etait encore revelee.
      * @param joueursVie  c'est le nombre de joueurs avec une carte non revelee.
      * @return un entier correspondant au numero du joueur que l'on veut accuser
      *
      */
     public abstract int accuser(ArrayList<Integer> listeNumero, int joueursVie);

     /**
      * Cette fonction abstraite permet de choisir quoi faire lorsque l'on se fait
      * accuser.
      * 
      * @param i le numero du prochain joueur e joueur
      * @return un entier represenant la decision prise; s'il est egale e 1 le joueur
      *         va devoiler sa carte, si c'est deux il va utiliser une carte whitch.
      *
      */
     public abstract int estAccuse(int i);

     /**
      * Cette fonction abstraite permet de devoiler sa carte
      * 
      * @param i           le numero du prochain joueur
      * @param j           le prochain joueur e jouer
      * @param nombre      quantifie le nombre de joueurs avec une carte non devoilee
      * @param liste       montre tous les jours avec une carte non devoilee
      * @param listeNumero montre les numeros de tous les joueurs avec une carte rele
      *                    non devoilee
      * @return un tableau d'entier correcpondant e chacune des resultats que fais
      *         cette methode.
      *
      */
     public abstract int[] devoilerCarte(int i, Joueur j, int nombre, ArrayList<Joueur> liste,
               ArrayList<Integer> listeNumero);

     /**
      * Cette fonction abstraite permet au joueur de choisis son camp
      *
      */
     public abstract void choisirCamp();

     /**
      * Cette fonction abstraite peremt au joueur d'utiliser une carte hunt
      * 
      * @param prochain    est le numero du prochain joueur
      * @param nombre      est le nombre de joueurs avec une carte non devoilee
      * @param liste       est la liste de tous les joueurs avec une carte non
      *                    devoilee
      * @param joueursVie  est le nombre de joueurs en vie
      * @param listeNumero est une liste des numeros de tous les joueurs avec une
      *                    carte non devoilee
      * @return un tableau d'entier correcpondant e chacune des resultats que fais
      *         cette methode.
      *
      */
     public abstract int[] utiliserCarteHunt(int prochain, int nombre, ArrayList<Joueur> liste, int joueursVie,
               ArrayList<Integer> listeNumero);

     /**
      * Cette fonction permet d'utiliser une carte witch apres s'etre fait accuser
      * par un autre joueur
      * 
      * @param prochain    le joueur accuse.
      * @param j           le joueur accuse qui va utiliser une carte whitch.
      * @param nombre      le nombre de joueurs dans la partie
      * @param listeNumero la liste des joueurs avec une carte non revelee.
      * @return un entier correspondant au numero du prochain joueur.
      *
      */
     public abstract int utiliserCarteWitch(int prochain, Joueur j, int nombre, ArrayList<Integer> listeNumero);

     /**
      * Cette fonction abstraite permet de faire l'action de la carte Angry Mob.
      * 
      * @param j le joueur cible par cette carte.
      * @param i le numero du prochain joueur.
      * @return un entier correspondant au numero du prochain joueur.
      *
      */
     public abstract int actionAngryMob(Joueur j, int i);

     /**
      * Cette fonction abstraite permet de faire l'action de la carte Hooked Nose.
      * 
      * @param j le joueur cible par cette carte.
      * @return un entier correspondant au numero du prochain joueur.
      *
      */
     public abstract int actionHookedNose(Joueur j);

     /**
      * Cette fonction abstraite permet au joueur qui l'utilise de faire l'action
      * correcpondant e la carte ducking stool
      * 
      * @param j          le joueur qui est cible par l'action de ducking stool
      * @param i          le numero du prochain joueur e jouer
      * @param liste      la liste des joueurs avec une carte encore non devoilees
      * @param joueursVie represente le nombre de joueurs avec une carte encore non
      *                   devoilee
      * @return un tableau d'entier correcpondant e chacune des resultats que fais
      *         cette methode.
      *
      */
     public abstract int[] actionDuckingStool(Joueur j, int i, ArrayList<Joueur> liste, int joueursVie);

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de
      * numJoueur.
      * 
      * @return on retourne la valeur de numJoueur
      */
     public int getNumJoueur() {
          return numJoueur;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de
      * numJoueur
      * 
      * @param numJoueur la valeur que nous voulons definir
      */
     public void setNumJoueur(int numJoueur) {
          this.numJoueur = numJoueur;
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de
      * nomJoueur.
      * 
      * @return on retourne la valeur de nomJoueur
      */
     public String getNomJoueur() {
          return nomJoueur;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de
      * nomJoueur
      * 
      * @param nomJoueur la valeur que nous voulons definir
      */
     public void setNomJoueur(String nomJoueur) {
          this.nomJoueur = nomJoueur;
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de
      * villageois.
      * 
      * @return on retourne la valeur de villageois
      */
     public boolean getRole() {
          return villageois;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de
      * villageois
      * 
      * @param villageois la valeur que nous voulons definir
      */
     public void setRole(boolean villageois) {
          this.villageois = villageois;
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de point.
      * 
      * @return on retourne la valeur de point
      */
     public int getPoint() {
          return point;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de point
      * 
      * @param point la valeur que nous voulons definir
      */
     public void setPoint(int point) {
          this.point = point;
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de
      * gagnant.
      * 
      * @return on retourne la valeur de gagnant
      */
     public boolean isGagnant() {
          return gagnant;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de gagnant
      * 
      * @param gagnant la valeur que nous voulons definir
      */
     public void setGagnant(boolean gagnant) {
          this.gagnant = gagnant;
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de
      * villageois.
      * 
      * @return on retourne la valeur de villageois
      */
     public boolean isVillageois() {
          return villageois;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de
      * villageois
      * 
      * @param villageois la valeur que nous voulons definir
      */
     public void setVillageois(boolean villageois) {
          this.villageois = villageois;
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de
      * carteRevelee.
      * 
      * @return on retourne la valeur de carteRevelee
      */
     public boolean isCarteRevelee() {
          return carteRevelee;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de
      * carteRevelee
      * 
      * @param carteRevelee la valeur que nous voulons definir
      */
     public void setCarteRevelee(boolean carteRevelee) {
          this.carteRevelee = carteRevelee;
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de
      * protectionBroomstick.
      * 
      * @return on retourne la valeur de protectionBroomstick
      */
     public boolean isProtectionBroomstick() {
          return protectionBroomstick;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de
      * protectionBroomstick
      * 
      * @param protectionBroomstick la valeur que nous voulons definir
      */
     public void setProtectionBroomstick(boolean protectionBroomstick) {
          this.protectionBroomstick = protectionBroomstick;
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de
      * protectionWart.
      * 
      * @return on retourne la valeur de protectionWart
      */
     public boolean isProtectionWart() {
          return protectionWart;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de
      * protectionWart
      * Cette fonction nous dis si on est proteger grece e la carte wart.
      * Elle prend true si c'est le cas et false sinon.
      * 
      * @param protectionWart la valeur que nous voulons definir
      */
     public void setProtectionWart(boolean protectionWart) {
          this.protectionWart = protectionWart;
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de
      * utilisationEvilEye.
      * 
      * @return on retourne la valeur de utilisationEvilEye
      */
     public boolean isUtilisationEvilEye() {
          return utilisationEvilEye;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de
      * utilisationEvilEye
      * C'est un boolean qui se met e oui si la carte a deja etait utilisee et e non
      * sinon.
      * 
      * @param utilisationEvilEye la valeur que nous voulons definir
      */
     public void setUtilisationEvilEye(boolean utilisationEvilEye) {
          this.utilisationEvilEye = utilisationEvilEye;
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de main.
      * 
      * @return on retourne la valeur de main
      */
     public LinkedList<Carte> getMain() {
          return main;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de main.
      * 
      * @param main la valeur que nous voulons definir
      */
     public void setMain(LinkedList<Carte> main) {
          this.main = main;
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de la
      * nouvelle main.
      * Cela correspond aux nouvelles cartes qui vont etre distribuees.
      * 
      * @return on retourne la valeur de nouvelleMain
      */
     public LinkedList<Carte> getNouvelleMain() {
          return nouvelleMain;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de
      * nouvelleMain.
      * 
      * @param nouvelleMain la valeur que nous voulons definir
      */
     public void setNouvelleMain(LinkedList<Carte> nouvelleMain) {
          this.nouvelleMain = nouvelleMain;
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de
      * carteJouee.
      * 
      * @return on retourne la valeur de carteJouee
      */
     public LinkedList<Carte> getCarteJouee() {
          return carteJouee;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de
      * carteJouee.
      * C'est une liste de plusieurs cartes qui ont deja etaient jouees.
      * 
      * @param carteJouee la valeur que nous voulons definir
      */
     public void setCarteJouee(LinkedList<Carte> carteJouee) {
          this.carteJouee = carteJouee;
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de
      * carteDefaussees.
      * 
      * @return on retourne la valeur de carteDefaussees
      */
     public static List<Carte> getCartesDefaussees() {
          return cartesDefaussees;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de
      * carteDefaussees.
      * C'est une liste de plusieurs objets du type carte.
      * 
      * @param cartesDefaussees la valeur que nous voulons definir
      */
     public static void setCartesDefaussees(List<Carte> cartesDefaussees) {
          Joueur.cartesDefaussees = cartesDefaussees;
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de carte.
      * 
      * @return on retourne la valeur de carte.
      */
     public Carte getCarte() {
          return carte;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de carte.
      * 
      * @param carte la valeur que nous voulons definir
      */
     public void setCarte(Carte carte) {
          this.carte = carte;
     }

}
