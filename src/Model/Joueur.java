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
     * Valeur repr�sentant le num�ro du joueur
     * 
     * 
     */
    protected int numJoueur;
    
    /**
     * Valeur repr�sentant le num�ro du joueur
     * 
     * 
     */
    protected String nomJoueur;
    
    /**
     * Valeur repr�sentant le num�ro du joueur
     * 
     *
     */
    protected boolean villageois;
    
    /**
     * Valeur repr�sentant le num�ro du joueur
     * 
     * 
     */
    protected int point;
    
    /**
     * Valeur repr�sentant le num�ro du joueur
     * 
     * 
     */
    protected boolean carteR�v�l�e;
    
    /**
     * Valeur repr�sentant le num�ro du joueur
     * 
     * 
     */
    public boolean gagnant;
    
    /**
     * Valeur repr�sentant le num�ro du joueur
     * 
     * 
     */
    protected boolean protectionBroomstick = false;
    
    /**
     * Valeur repr�sentant le num�ro du joueur
     * 
     * 
     */
    protected boolean protectionWart = false;
    
    /**
     * Valeur repr�sentant le num�ro du joueur
     * 
     * 
     */
    protected boolean utilisationEvilEye=false;
    

    /**
     * Valeur repr�sentant le num�ro du joueur
     * 
     *
     */
    protected LinkedList<Carte> main;
    
    /**
     * Valeur repr�sentant le num�ro du joueur
     * 
     * 
     */
    protected LinkedList<Carte> nouvelleMain;
    
    /**
     * Valeur repr�sentant le num�ro du joueur
     * 
     *
     */
    protected LinkedList<Carte> carteJou�e;
    
    /**
     * Valeur repr�sentant le num�ro du joueur
     * 
     *
     */
    protected static List<Carte> cartesD�fauss�es = new ArrayList<Carte>();
    
    /**
     * Valeur repr�sentant le num�ro du joueur
     * 
     *
     */
    private Carte carte;

    /**
     * Valeur repr�sentant le num�ro du joueur
     * 
     *
     */
    
    /**
     * M�thode permettant de rammaser une carte et de l'ajouter aux siennes
     * 
     * @param carte la carte que l'on veut ramasser
     */
	public void ramasserCarte(Carte carte){ 
		main.add(carte); 
	}

    
    
	/**
     * Constructeur de la classe joueur.
     * 
     * @param i le num�ro du joueur
     */
    public Joueur(int i) {
    	this.numJoueur=i;
    	this.point=0;
    	this.gagnant=false;
    	this.main = new LinkedList<Carte>();
    	this.carteJou�e = new LinkedList<Carte>();
    }
    
    /**
     * Cette m�thode permet de retirer une carte de la main d'un des joueurs
     * 
     * @param c la carte que va �tre retir�e
     */
    public void retirerCarte(Carte c) {
    	Carte m = main.get(0);
    	int n = 0;
    	while (m.equals(c) == false) {
    		n = n+1;
    		m = main.get(n);
    	}
    	carteJou�e.add(m);
    	Partie witchHunt = new Partie();
    	cartesD�fauss�es.add(m);
    	main.remove(n);
    }

    // M�thodes abstraites permettant aux joueurs de faire leurs actions 
    
    
    /**
     * Cette fonction abstraite permet au joueur de choisir ce qu'il veut faire
     * 
     * @param n le num�ro du joueur � qui est le tour
     * @return un entier qui correspond � son choix (1 si il veut accuser un autre joueur et 2 s'il veut utiliser une carte hunt).
     *
     */
    public abstract int queFaire(int n);
    
    /**
     * Cette fonction permet de choisir quel joueur on veut accuser 
     * 
     * @param listeNum�ro c'est la liste de tous les joueurs accusable (dont la carte n'a pas �tait encore r�v�l�e.
     * @param joueursVie c'est le nombre de joueurs avec une carte non r�v�l�e.
     * @return un entier correspondant au num�ro du joueur que l'on veut accuser
     *
     */
    public abstract int accuser(ArrayList<Integer> listeNum�ro, int joueursVie);
    
    /**
     * Cette fonction abstraite permet de choisir quoi faire lorsque l'on se fait accuser.
     * 
     * @param i le num�ro du prochain joueur � joueur 
     * @return un entier repr�senant la d�cision prise; s'il est �gale � 1 le joueur va d�voiler sa carte, si c'est deux il va utiliser une carte whitch.
     *
     */
    public abstract int estAccus�(int i);
    
    /**
     * Cette fonction abstraite permet de d�voiler sa carte
     * 
     * @param i le num�ro du prochain joueur 
     * @param j le prochain joueur � jouer
     * @param nombre quantifie le nombre de joueurs avec une carte non d�voil�e
     * @param liste montre tous les jours avec une carte non d�voil�e 
     * @param listeNum�ro montre les num�ros de tous les joueurs avec une carte r�le non d�voil�e
     * @return un tableau d'entier correcpondant � chacune des r�sultats que fais cette m�thode.
     *
     */
    public abstract int[] d�voilerCarte(int i, Joueur j, int nombre, ArrayList<Joueur> liste, ArrayList<Integer> listeNum�ro);
    
    /**
     * Cette fonction abstraite permet au joueur de choisis son camp
     *
     */
    public abstract void choisirCamp();
    
    /**
     * Cette fonction abstraite peremt au joueur d'utiliser une carte hunt
     * 
     * @param prochain est le num�ro du prochain joueur
     * @param nombre est le nombre de joueurs avec une carte non d�voil�e 
     * @param liste est la liste de tous les joueurs avec une carte non d�voil�e
     * @param joueursVie est le nombre de joueurs en vie 
     * @param listeNum�ro est une liste des num�ros de tous les joueurs avec une carte non d�voil�e
     * @return un tableau d'entier correcpondant � chacune des r�sultats que fais cette m�thode.
     *
     */
    public abstract int[] utiliserCarteHunt(int prochain, int nombre, ArrayList<Joueur> liste, int joueursVie, ArrayList<Integer> listeNum�ro);
    
    /**
     * Cette fonction permet d'utiliser une carte witch apr�s s'�tre fait accuser par un autre joueur
     * 
     * @param prochain le joueur accus�.
     * @param j le joueur accus� qui va utiliser une carte whitch.
     * @param nombre le nombre de joueurs dans la partie 
     * @param listeNum�ro la liste des joueurs avec une carte non r�v�l�e.
     * @return un entier correspondant au num�ro du prochain joueur.
     *
     */
    public abstract int utiliserCarteWitch(int prochain, Joueur j, int nombre, ArrayList<Integer> listeNum�ro);
    
    /**
     * Cette fonction abstraite permet de faire l'action de la carte Angry Mob.
     * 
     * @param j le joueur cibl� par cette carte.
     * @param i le num�ro du prochain joueur.
     * @return un entier correspondant au num�ro du prochain joueur.
     *
     */
    public abstract int actionAngryMob(Joueur j, int i) ;
    
    /**
     * Cette fonction abstraite permet de faire l'action de la carte Hooked Nose.
     * 
     * @param j le joueur cibl� par cette carte.
     * @return un entier correspondant au num�ro du prochain joueur.
     *
     */
    public abstract int actionHookedNose(Joueur j);
    
    /**
     * Cette fonction abstraite permet au joueur qui l'utilise de faire l'action correcpondant � la carte ducking stool
     * 
     * @param j le joueur qui est cibl� par l'action de ducking stool
     * @param i le num�ro du prochain joueur � jouer
     * @param liste la liste des joueurs avec une carte encore non d�voil�es
     * @param joueursVie repr�sente le nombre de joueurs avec une carte encore non d�voil�e
     * @return un tableau d'entier correcpondant � chacune des r�sultats que fais cette m�thode.
     *
     */
    public abstract int[] actionDuckingStool(Joueur j, int i, ArrayList<Joueur> liste, int joueursVie);
	
    
    
    
    
    /**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de numJoueur.
     * 
     * @return on retourne la valeur de numJoueur
     */
	public int getNumJoueur() {
		return numJoueur;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de numJoueur
     * 
     * @param numJoueur la valeur que nous voulons d�finir
     */
	public void setNumJoueur(int numJoueur) {
		this.numJoueur = numJoueur;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de nomJoueur.
     * 
     * @return on retourne la valeur de nomJoueur
     */
	public String getNomJoueur() {
		return nomJoueur;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de nomJoueur
     * 
     * @param nomJoueur la valeur que nous voulons d�finir
     */
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de villageois.
     * 
     * @return on retourne la valeur de villageois
     */
	public boolean getRole() {
		return villageois;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de villageois
     * 
     * @param villageois la valeur que nous voulons d�finir
     */
	public void setRole(boolean villageois) {
		this.villageois = villageois;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de point.
     * 
     * @return on retourne la valeur de point
     */
	public int getPoint() {
		return point;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de point
     * 
     * @param point la valeur que nous voulons d�finir
     */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de gagnant.
     * 
     * @return on retourne la valeur de gagnant
     */
	public boolean isGagnant() {
		return gagnant;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de gagnant
     * 
     * @param gagnant la valeur que nous voulons d�finir
     */
	public void setGagnant(boolean gagnant) {
		this.gagnant = gagnant;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de villageois.
     * 
     * @return on retourne la valeur de villageois
     */
	public boolean isVillageois() {
		return villageois;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de villageois
     * 
     * @param villageois la valeur que nous voulons d�finir
     */
	public void setVillageois(boolean villageois) {
		this.villageois = villageois;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de carteR�v�l�e.
     * 
     * @return on retourne la valeur de carteR�v�l�e
     */
	public boolean isCarteR�v�l�e() {
		return carteR�v�l�e;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de carteR�v�l�e
     * 
     * @param carteR�v�l�e la valeur que nous voulons d�finir
     */
	public void setCarteR�v�l�e(boolean carteR�v�l�e) {
		this.carteR�v�l�e = carteR�v�l�e;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de protectionBroomstick.
     * 
     * @return on retourne la valeur de protectionBroomstick
     */
	public boolean isProtectionBroomstick() {
		return protectionBroomstick;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de protectionBroomstick
     * 
     * @param protectionBroomstick la valeur que nous voulons d�finir
     */
	public void setProtectionBroomstick(boolean protectionBroomstick) {
		this.protectionBroomstick = protectionBroomstick;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de protectionWart.
     * 
     * @return on retourne la valeur de protectionWart
     */
	public boolean isProtectionWart() {
		return protectionWart;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de protectionWart
     * Cette fonction nous dis si on est prot�ger gr�ce � la carte wart.
     * Elle prend true si c'est le cas et false sinon.
     * 
     * @param protectionWart la valeur que nous voulons d�finir
     */
	public void setProtectionWart(boolean protectionWart) {
		this.protectionWart = protectionWart;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de utilisationEvilEye.
     * 
     * @return on retourne la valeur de utilisationEvilEye
     */
	public boolean isUtilisationEvilEye() {
		return utilisationEvilEye;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de utilisationEvilEye
     * C'est un boolean qui se met � oui si la carte a d�ja �tait utilis�e et � non sinon.
     * 
     * @param utilisationEvilEye la valeur que nous voulons d�finir
     */
	public void setUtilisationEvilEye(boolean utilisationEvilEye) {
		this.utilisationEvilEye = utilisationEvilEye;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de main.
     * 
     * @return on retourne la valeur de main
     */
	public LinkedList<Carte> getMain() {
		return main;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de main.
     * 
     * @param main la valeur que nous voulons d�finir
     */
	public void setMain(LinkedList<Carte> main) {
		this.main = main;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de la nouvelle main.
     * Cela correspond aux nouvelles cartes qui vont �tre distribu�es.
     * 
     * @return on retourne la valeur de nouvelleMain
     */
	public LinkedList<Carte> getNouvelleMain() {
		return nouvelleMain;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de nouvelleMain.
     * 
     * @param nouvelleMain la valeur que nous voulons d�finir
     */
	public void setNouvelleMain(LinkedList<Carte> nouvelleMain) {
		this.nouvelleMain = nouvelleMain;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de carteJou�e.
     * 
     * @return on retourne la valeur de carteJou�e
     */
	public LinkedList<Carte> getCarteJou�e() {
		return carteJou�e;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de carteJou�e.
     * C'est une liste de plusieurs cartes qui ont d�ja �taient jou�es.
     * 
     * @param carteJou�e la valeur que nous voulons d�finir
     */
	public void setCarteJou�e(LinkedList<Carte> carteJou�e) {
		this.carteJou�e = carteJou�e;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de carteD�fauss�es.
     * 
     * @return on retourne la valeur de carteD�fauss�es
     */
	public static List<Carte> getCartesD�fauss�es() {
		return cartesD�fauss�es;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de carteD�fauss�es.
     * C'est une liste de plusieurs objets du type carte.
     * 
     * @param cartesD�fauss�es la valeur que nous voulons d�finir
     */
	public static void setCartesD�fauss�es(List<Carte> cartesD�fauss�es) {
		Joueur.cartesD�fauss�es = cartesD�fauss�es;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de carte.
     * 
     * @return on retourne la valeur de carte.
     */
	public Carte getCarte() {
		return carte;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de carte.
     * 
     * @param carte la valeur que nous voulons d�finir
     */
	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	
}
