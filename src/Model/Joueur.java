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
     * Valeur représentant le numéro du joueur
     * 
     * 
     */
    protected int numJoueur;
    
    /**
     * Valeur représentant le numéro du joueur
     * 
     * 
     */
    protected String nomJoueur;
    
    /**
     * Valeur représentant le numéro du joueur
     * 
     *
     */
    protected boolean villageois;
    
    /**
     * Valeur représentant le numéro du joueur
     * 
     * 
     */
    protected int point;
    
    /**
     * Valeur représentant le numéro du joueur
     * 
     * 
     */
    protected boolean carteRévélée;
    
    /**
     * Valeur représentant le numéro du joueur
     * 
     * 
     */
    public boolean gagnant;
    
    /**
     * Valeur représentant le numéro du joueur
     * 
     * 
     */
    protected boolean protectionBroomstick = false;
    
    /**
     * Valeur représentant le numéro du joueur
     * 
     * 
     */
    protected boolean protectionWart = false;
    
    /**
     * Valeur représentant le numéro du joueur
     * 
     * 
     */
    protected boolean utilisationEvilEye=false;
    

    /**
     * Valeur représentant le numéro du joueur
     * 
     *
     */
    protected LinkedList<Carte> main;
    
    /**
     * Valeur représentant le numéro du joueur
     * 
     * 
     */
    protected LinkedList<Carte> nouvelleMain;
    
    /**
     * Valeur représentant le numéro du joueur
     * 
     *
     */
    protected LinkedList<Carte> carteJouée;
    
    /**
     * Valeur représentant le numéro du joueur
     * 
     *
     */
    protected static List<Carte> cartesDéfaussées = new ArrayList<Carte>();
    
    /**
     * Valeur représentant le numéro du joueur
     * 
     *
     */
    private Carte carte;

    /**
     * Valeur représentant le numéro du joueur
     * 
     *
     */
    
    /**
     * Méthode permettant de rammaser une carte et de l'ajouter aux siennes
     * 
     * @param carte la carte que l'on veut ramasser
     */
	public void ramasserCarte(Carte carte){ 
		main.add(carte); 
	}

    
    
	/**
     * Constructeur de la classe joueur.
     * 
     * @param i le numéro du joueur
     */
    public Joueur(int i) {
    	this.numJoueur=i;
    	this.point=0;
    	this.gagnant=false;
    	this.main = new LinkedList<Carte>();
    	this.carteJouée = new LinkedList<Carte>();
    }
    
    /**
     * Cette méthode permet de retirer une carte de la main d'un des joueurs
     * 
     * @param c la carte que va être retirée
     */
    public void retirerCarte(Carte c) {
    	Carte m = main.get(0);
    	int n = 0;
    	while (m.equals(c) == false) {
    		n = n+1;
    		m = main.get(n);
    	}
    	carteJouée.add(m);
    	Partie witchHunt = new Partie();
    	cartesDéfaussées.add(m);
    	main.remove(n);
    }

    // Méthodes abstraites permettant aux joueurs de faire leurs actions 
    
    
    /**
     * Cette fonction abstraite permet au joueur de choisir ce qu'il veut faire
     * 
     * @param n le numéro du joueur à qui est le tour
     * @return un entier qui correspond à son choix (1 si il veut accuser un autre joueur et 2 s'il veut utiliser une carte hunt).
     *
     */
    public abstract int queFaire(int n);
    
    /**
     * Cette fonction permet de choisir quel joueur on veut accuser 
     * 
     * @param listeNuméro c'est la liste de tous les joueurs accusable (dont la carte n'a pas était encore révélée.
     * @param joueursVie c'est le nombre de joueurs avec une carte non révélée.
     * @return un entier correspondant au numéro du joueur que l'on veut accuser
     *
     */
    public abstract int accuser(ArrayList<Integer> listeNuméro, int joueursVie);
    
    /**
     * Cette fonction abstraite permet de choisir quoi faire lorsque l'on se fait accuser.
     * 
     * @param i le numéro du prochain joueur à joueur 
     * @return un entier représenant la décision prise; s'il est égale à 1 le joueur va dévoiler sa carte, si c'est deux il va utiliser une carte whitch.
     *
     */
    public abstract int estAccusé(int i);
    
    /**
     * Cette fonction abstraite permet de dévoiler sa carte
     * 
     * @param i le numéro du prochain joueur 
     * @param j le prochain joueur à jouer
     * @param nombre quantifie le nombre de joueurs avec une carte non dévoilée
     * @param liste montre tous les jours avec une carte non dévoilée 
     * @param listeNuméro montre les numéros de tous les joueurs avec une carte rôle non dévoilée
     * @return un tableau d'entier correcpondant à chacune des résultats que fais cette méthode.
     *
     */
    public abstract int[] dévoilerCarte(int i, Joueur j, int nombre, ArrayList<Joueur> liste, ArrayList<Integer> listeNuméro);
    
    /**
     * Cette fonction abstraite permet au joueur de choisis son camp
     *
     */
    public abstract void choisirCamp();
    
    /**
     * Cette fonction abstraite peremt au joueur d'utiliser une carte hunt
     * 
     * @param prochain est le numéro du prochain joueur
     * @param nombre est le nombre de joueurs avec une carte non dévoilée 
     * @param liste est la liste de tous les joueurs avec une carte non dévoilée
     * @param joueursVie est le nombre de joueurs en vie 
     * @param listeNuméro est une liste des numéros de tous les joueurs avec une carte non dévoilée
     * @return un tableau d'entier correcpondant à chacune des résultats que fais cette méthode.
     *
     */
    public abstract int[] utiliserCarteHunt(int prochain, int nombre, ArrayList<Joueur> liste, int joueursVie, ArrayList<Integer> listeNuméro);
    
    /**
     * Cette fonction permet d'utiliser une carte witch après s'être fait accuser par un autre joueur
     * 
     * @param prochain le joueur accusé.
     * @param j le joueur accusé qui va utiliser une carte whitch.
     * @param nombre le nombre de joueurs dans la partie 
     * @param listeNuméro la liste des joueurs avec une carte non révélée.
     * @return un entier correspondant au numéro du prochain joueur.
     *
     */
    public abstract int utiliserCarteWitch(int prochain, Joueur j, int nombre, ArrayList<Integer> listeNuméro);
    
    /**
     * Cette fonction abstraite permet de faire l'action de la carte Angry Mob.
     * 
     * @param j le joueur ciblé par cette carte.
     * @param i le numéro du prochain joueur.
     * @return un entier correspondant au numéro du prochain joueur.
     *
     */
    public abstract int actionAngryMob(Joueur j, int i) ;
    
    /**
     * Cette fonction abstraite permet de faire l'action de la carte Hooked Nose.
     * 
     * @param j le joueur ciblé par cette carte.
     * @return un entier correspondant au numéro du prochain joueur.
     *
     */
    public abstract int actionHookedNose(Joueur j);
    
    /**
     * Cette fonction abstraite permet au joueur qui l'utilise de faire l'action correcpondant à la carte ducking stool
     * 
     * @param j le joueur qui est ciblé par l'action de ducking stool
     * @param i le numéro du prochain joueur à jouer
     * @param liste la liste des joueurs avec une carte encore non dévoilées
     * @param joueursVie représente le nombre de joueurs avec une carte encore non dévoilée
     * @return un tableau d'entier correcpondant à chacune des résultats que fais cette méthode.
     *
     */
    public abstract int[] actionDuckingStool(Joueur j, int i, ArrayList<Joueur> liste, int joueursVie);
	
    
    
    
    
    /**
     * Cette fonction est un getter nous permettant de récupérer la valeur de numJoueur.
     * 
     * @return on retourne la valeur de numJoueur
     */
	public int getNumJoueur() {
		return numJoueur;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de numJoueur
     * 
     * @param numJoueur la valeur que nous voulons définir
     */
	public void setNumJoueur(int numJoueur) {
		this.numJoueur = numJoueur;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de nomJoueur.
     * 
     * @return on retourne la valeur de nomJoueur
     */
	public String getNomJoueur() {
		return nomJoueur;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de nomJoueur
     * 
     * @param nomJoueur la valeur que nous voulons définir
     */
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de villageois.
     * 
     * @return on retourne la valeur de villageois
     */
	public boolean getRole() {
		return villageois;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de villageois
     * 
     * @param villageois la valeur que nous voulons définir
     */
	public void setRole(boolean villageois) {
		this.villageois = villageois;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de point.
     * 
     * @return on retourne la valeur de point
     */
	public int getPoint() {
		return point;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de point
     * 
     * @param point la valeur que nous voulons définir
     */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de gagnant.
     * 
     * @return on retourne la valeur de gagnant
     */
	public boolean isGagnant() {
		return gagnant;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de gagnant
     * 
     * @param gagnant la valeur que nous voulons définir
     */
	public void setGagnant(boolean gagnant) {
		this.gagnant = gagnant;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de villageois.
     * 
     * @return on retourne la valeur de villageois
     */
	public boolean isVillageois() {
		return villageois;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de villageois
     * 
     * @param villageois la valeur que nous voulons définir
     */
	public void setVillageois(boolean villageois) {
		this.villageois = villageois;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de carteRévélée.
     * 
     * @return on retourne la valeur de carteRévélée
     */
	public boolean isCarteRévélée() {
		return carteRévélée;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de carteRévélée
     * 
     * @param carteRévélée la valeur que nous voulons définir
     */
	public void setCarteRévélée(boolean carteRévélée) {
		this.carteRévélée = carteRévélée;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de protectionBroomstick.
     * 
     * @return on retourne la valeur de protectionBroomstick
     */
	public boolean isProtectionBroomstick() {
		return protectionBroomstick;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de protectionBroomstick
     * 
     * @param protectionBroomstick la valeur que nous voulons définir
     */
	public void setProtectionBroomstick(boolean protectionBroomstick) {
		this.protectionBroomstick = protectionBroomstick;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de protectionWart.
     * 
     * @return on retourne la valeur de protectionWart
     */
	public boolean isProtectionWart() {
		return protectionWart;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de protectionWart
     * Cette fonction nous dis si on est protéger grâce à la carte wart.
     * Elle prend true si c'est le cas et false sinon.
     * 
     * @param protectionWart la valeur que nous voulons définir
     */
	public void setProtectionWart(boolean protectionWart) {
		this.protectionWart = protectionWart;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de utilisationEvilEye.
     * 
     * @return on retourne la valeur de utilisationEvilEye
     */
	public boolean isUtilisationEvilEye() {
		return utilisationEvilEye;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de utilisationEvilEye
     * C'est un boolean qui se met à oui si la carte a déja était utilisée et à non sinon.
     * 
     * @param utilisationEvilEye la valeur que nous voulons définir
     */
	public void setUtilisationEvilEye(boolean utilisationEvilEye) {
		this.utilisationEvilEye = utilisationEvilEye;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de main.
     * 
     * @return on retourne la valeur de main
     */
	public LinkedList<Carte> getMain() {
		return main;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de main.
     * 
     * @param main la valeur que nous voulons définir
     */
	public void setMain(LinkedList<Carte> main) {
		this.main = main;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de la nouvelle main.
     * Cela correspond aux nouvelles cartes qui vont être distribuées.
     * 
     * @return on retourne la valeur de nouvelleMain
     */
	public LinkedList<Carte> getNouvelleMain() {
		return nouvelleMain;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de nouvelleMain.
     * 
     * @param nouvelleMain la valeur que nous voulons définir
     */
	public void setNouvelleMain(LinkedList<Carte> nouvelleMain) {
		this.nouvelleMain = nouvelleMain;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de carteJouée.
     * 
     * @return on retourne la valeur de carteJouée
     */
	public LinkedList<Carte> getCarteJouée() {
		return carteJouée;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de carteJouée.
     * C'est une liste de plusieurs cartes qui ont déja étaient jouées.
     * 
     * @param carteJouée la valeur que nous voulons définir
     */
	public void setCarteJouée(LinkedList<Carte> carteJouée) {
		this.carteJouée = carteJouée;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de carteDéfaussées.
     * 
     * @return on retourne la valeur de carteDéfaussées
     */
	public static List<Carte> getCartesDéfaussées() {
		return cartesDéfaussées;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de carteDéfaussées.
     * C'est une liste de plusieurs objets du type carte.
     * 
     * @param cartesDéfaussées la valeur que nous voulons définir
     */
	public static void setCartesDéfaussées(List<Carte> cartesDéfaussées) {
		Joueur.cartesDéfaussées = cartesDéfaussées;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de carte.
     * 
     * @return on retourne la valeur de carte.
     */
	public Carte getCarte() {
		return carte;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de carte.
     * 
     * @param carte la valeur que nous voulons définir
     */
	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	
}
