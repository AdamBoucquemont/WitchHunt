package Model;

import java.util.*;

/**
 * Dans la classe Personnes nous allons r�expliquer toute les m�thodes de joueurs mais pour des joueurs qui sont des intelligences artificielles.
 * 
 * 
 * @author Adam 
 *
 */

public class Bot extends Joueur {

	/**
	 * Cet attribut permet d'importer un comportement pour le bot
	 */
	public Comportement comportement;
	
	/**
	 * Cet attribut permet de stocker le choix que va faire le bot ce qui va influencer ses actions
	 */
    private int choix;
    
    /**
     * Cet attribut permet d'importer un comportement entre agressif, d�fensif et al�atoire
     *
     */
	private Comportement c;
	
	// Constructeur d'un bot  
	
	/**
	 * Cette m�thode permet de cr�er une personne qui sera un joueur mais avec des attributs en plus :
	 * Une strat�gie est d�cider al�atoirement au d�but 
	 * 
	 * @param i le num�ro du joueur 
	 *
	 */
    public Bot(int i) {
    	super(i);
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Quel est le nom du Bot " +i);
    	String n = sc.nextLine();
    	this.nomJoueur=n;
    	this.choix = (int) Math.floor(Math.random()*3);
    	if (this.choix == 0) {
    		Comportement c = new Agressif();
    		this.c=c;
    	}
    	else if (this.choix == 1) {
    		Comportement c = new D�fensif();
    		this.c=c;
    	}
    	else {
    		Comportement c = new Al�atoire();
    		this.c=c;
    	}
    	System.out.println("Le bot "+i+" s'appelle " +nomJoueur);
    }
    
    // M�thode permettant au bot de choisir son camp en fonction de sa strat�gie
    public void choisirCamp() {
    	System.out.println(this.nomJoueur+ ", voici les cartes en votre possession");
		System.out.println(this.main);
    	int m=this.c.choisirCamp();
    	if (m == 1) {
    		this.villageois=true;
    		System.out.println(this.nomJoueur + " est un villageois. \n");
    	}
    	else {
    		this.villageois=false;
    		System.out.println(this.nomJoueur + " est une sorci�re.\n");
    	}
    	this.carteR�v�l�e=false;
    }
    
    
    // M�thode permettant au bot de choisir quoi faire en fonction de son type de strat�gie
    public int queFaire(int n) {
    	System.out.println(this.nomJoueur + ", Veuillez choisir entre accuser un autre joueur (1) ou utiliser une carte rumeur (2)");
    	System.out.println("\n");
    	int m=this.c.queFaire();
    	return m;
    }
    
    // M�thode permettant au bot d'accuser un autre joueur
    public int accuser(ArrayList<Integer> listeNum�ro, int joueursVie) {
    	int m=0;
    	int jv1=0;
    	int jv2=0;
    	int jv3=0;
    	int jv4=0;
    	int jv5=0;
    	int jv6=0;
    	Iterator<Integer> it = listeNum�ro.iterator();
    	boolean erreur;
    	do {
    		erreur = false;
    	    try {
    	    	while (it.hasNext())
    		    {
    		      	if (jv1 == 0) {
    		     		jv1= (Integer)it.next();
    		       	}
    		       	else if (jv2 == 0) {
    		      		jv2= (Integer)it.next();
    		       	}
    		       	else if (jv3 == 0) {
    		     		jv3= (Integer)it.next();
    		       	}
    		       	else if (jv4 == 0) {
    		       		jv4= (Integer)it.next();
    		       	}
    		       	else if (jv5 == 0) {
    		       		jv5= (Integer)it.next();
    		       	}
    		       	else if (jv6 == 0) {
    		       		jv6= (Integer)it.next();
    		       	}
    		    }
    	    }
    	   	catch (NoSuchElementException e) {
    	    	erreur = true;
    	    	System.out.println("Il y a une erreur c'est triste");
    	    }
   	    }
   	    	while (erreur);
   	    	System.out.println("Vous avez choisi d'accuser quelqu'un, qui voulez vous accuser ?");
   	    	System.out.println("\n");
   	    	while (m==this.numJoueur  || (m != jv1 && m !=jv2 && m !=jv3 && m != jv4 && m != jv5 && m != jv6) || m == 0) {
   	        	m = (int) Math.floor(Math.random()*6)+1;
   	        	//System.out.println("Vous vouliez accuser le joueur " +m);
   	    	}
    	System.out.println("Vous avez choisi d'accuser le joueur " +m);
    	System.out.println("\n");
    	return m-1;    	
    }
    
    // M�thode permettant de faire les actions quand il se fait accuser
    public int estAccus�(int i) {
    	int m = this.c.estAccus�();
    	System.out.println("\n");
    	if (m == 1) {
        	this.carteR�v�l�e=true;
    	}
    	return m;    	
    }
    
    // Le Bot d�voile sa carte !
    public int[] d�voilerCarte(int i, Joueur j, int nombre, ArrayList<Joueur> liste, ArrayList<Integer> listeNum�ro) {
    	System.out.println(j.nomJoueur + " Vous avez choisi de d�voiler votre carte r�le");
        if (j.villageois == true) {
        	System.out.println("Vous �tes un villageois");
        	i=j.numJoueur-1;
        }
        else {
        	System.out.println("Vous �tiez une sorci�re");
        	this.point = this.point + 1;
        } 
        nombre -= 1;
        liste.remove(j);
        int[] retour = {i, nombre};
        return retour;
    }
    
    
    
    
    
    
    
    
    
    // Le bot utilise la m�thode hunt d'une carte rumeur
    public int[] utiliserCarteHunt(int prochain, int nombre, ArrayList<Joueur> liste, int joueursVie, ArrayList<Integer> listeNum�ro) {
    	System.out.println("Voici les cartes que vous avez en votre possession :");
    	System.out.println(this.main);
    	System.out.println("\n");
    	System.out.println(this.nomJoueur + ", quelle carte voulez vous utiliser ?");
    	System.out.println("\n");
    	int jv1=0;
    	int jv2=0;
    	int jv3=0;
    	int jv4=0;
    	int jv5=0;
    	int jv6=0;
    	Iterator<Integer> it = listeNum�ro.iterator();
    	boolean erreur2;
    	do {
    		erreur2 = false;
    		try {
    		while (it.hasNext())
	        {
	        	if (jv1 == 0) {
	        		jv1= (Integer)it.next();
	        	}
	        	else if (jv2 == 0) {
	        		jv2= (Integer)it.next();
	        	}
	        	else if (jv3 == 0) {
	        		jv3= (Integer)it.next();
	        	}
	        	else if (jv4 == 0) {
	        		jv4= (Integer)it.next();
	        	}
	        	else if (jv5 == 0) {
	        		jv5= (Integer)it.next();
	        	}
	        	else if (jv6 == 0) {
	        		jv6= (Integer)it.next();
	        	}
	    	}
        }
    	catch (NoSuchElementException e) {
    		erreur2 = true;
    		System.out.println("Il y a une erreur c'est triste");
    	}
    	}
    	while (erreur2);
    	String m = "u";
    	int joueurCibl�=0;
    	int r�sultat=-1;int i = 0;
    	boolean erreur;
    	boolean cartePossede = false;
    	String carteReferenceId = null;
    	Scanner reader = new Scanner(System.in);
    	boolean suite = false;
    	do {
    		erreur = false;
    		try {
    			Carte carteReference;
    	    	int choixCartes = (int) Math.floor(Math.random()*12);
    			if (choixCartes == 0) {
    				m = "an";	
    			}
    			else if (choixCartes == 1) {
    				m = "th";
    			}
    			else if (choixCartes == 2) {
    				m = "po";
    			}
    			else if (choixCartes == 3) {
    				m = "ho";
    			}
    			else if (choixCartes == 4) {
    				m = "br";
    			}
    			else if (choixCartes == 5) {
    				m = "wa";
    			}
    			else if (choixCartes == 6) {
    				m = "du";
    			}
    			else if (choixCartes == 7) {
    				m = "to";
    			}
    			else if (choixCartes == 8) {
    				m = "ev";
    			}
    			else if (choixCartes == 9) {
    				m = "ca";
    			}
    			else if (choixCartes == 10) {
    				m = "bl";
    			}
    			else if (choixCartes == 11) {
    				m = "pe";
    			}
    	    	while (m.equalsIgnoreCase("an")==false && m.equalsIgnoreCase("th")==false && m.equalsIgnoreCase("po")==false && m.equalsIgnoreCase("ho")==false && m.equalsIgnoreCase("br")==false && m.equalsIgnoreCase("wa")==false && m.equalsIgnoreCase("du")==false && m.equalsIgnoreCase("ca")==false && m.equalsIgnoreCase("ev")==false && m.equalsIgnoreCase("to")==false && m.equalsIgnoreCase("bl")==false && m.equalsIgnoreCase("pe")==false) {
    	    		System.out.println(m);
    	    	}
    	    	
    	    	while(!suite) {
    	    		i = 0;
    	    		while((!cartePossede) && (i<=main.size())) {
    	    			if(m.equals(carteReferenceId)) {
    	    				cartePossede = true;
    	    			}
    	    			else {
    	    				carteReference = main.get(i);
    	    				carteReferenceId = carteReference.getidCarte();
    	    			}
    	    			i++;
    	    		}
    	    		
    	    		if (cartePossede) {
    	    			suite = true;
    	    		}
    	    		else {
    	    			System.out.println("Vous ne poss�dez pas cette carte, veuillez res�lectionner une carte parmis votre main :");
    	    			System.out.println(this.main);
    	    			System.out.println("\n");
    	    			System.out.println("Renseingez les deux premi�res lettres correspondant � la carte que vous voulez utiliser!");
    	    	    	System.out.println("\n");
    	    	    	m = reader.nextLine();
    	    		}
    	    	}
    		}
    		catch (IndexOutOfBoundsException e) {
    			erreur = true;
    		}
    	} while (erreur);
    	
    	
    	
    	
    	
    	
    	// Angry Mob hunt action
    	if (m.equalsIgnoreCase("an")) {
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Angry Mob.");
    		AngryMob angryMob= new AngryMob();
    		boolean b = angryMob.v�rifieCondition(this.villageois, this.carteR�v�l�e);
    		if (b) {
    			CarteRumeurEnum[] c=CarteRumeurEnum.values();
        		Carte carte = new Carte(c[0]);
        		retirerCarte(carte);
    			angryMob.huntAction();
    			joueurCibl� = (int) Math.floor(Math.random()*6)+1;
    			while(liste.get(joueurCibl�).protectionBroomstick == true && joueurCibl�==this.numJoueur  || (joueurCibl� != jv1 && joueurCibl� !=jv2 && joueurCibl� !=jv3 && joueurCibl� != jv4 && joueurCibl� != jv5 && joueurCibl� != jv6) || joueurCibl� == 0) {
    				joueurCibl� = (int) Math.floor(Math.random()*6)+1;
    			}
    		}
    		else {
    			System.out.println("Vous ne pouvez pas utiliser cette carte");
    		}
    		r�sultat = 1;
    	}
    	
    	
    	// The Inquisition hunt action
    	else if (m.equalsIgnoreCase("th")){
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte The Inquisition.");
    		TheInquisition theInquisition= new TheInquisition();
    		boolean b = theInquisition.v�rifieCondition(this.villageois, this.carteR�v�l�e);
    		if(b) {
    			CarteRumeurEnum[] c=CarteRumeurEnum.values();
        		Carte carte = new Carte(c[9]);
        		retirerCarte(carte);
    			joueurCibl� = theInquisition.huntAction();
    		}
    		else {
    			System.out.println("Vous ne pouvez pas utiliser cette carte");
    		}    		
    	}
    	
    	// PointedHat hunt action
    	else if (m.equalsIgnoreCase("po")) {
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Pointed Hat.");
    		PointedHat pointedHat= new PointedHat();
    		boolean b = pointedHat.v�rifieCondition(this.carteJou�e);
    		if (b == true) {
    			CarteRumeurEnum[] c=CarteRumeurEnum.values();
        		Carte carte = new Carte(c[8]);
        		retirerCarte(carte);
    			pointedHat.huntAction();
    			System.out.println("Voici les cartes que vous avez d�ja utilis�es :");
    			System.out.println(carteJou�e);
    			int v = (int) Math.floor(Math.random()*11)+1;
    			while (v<1 || v>carteJou�e.size()) {
    				v = (int) Math.floor(Math.random()*11)+1;
    			}
    			main.add(carteJou�e.get(v-1));
    			carteJou�e.remove(v-1);

    	    	System.out.println("Qui va jouer au prochain tour ? Veuillez choisir un joueur encore en jeu et ne pas vous choisir vous m�me ! ");
    	    	int n = (int) Math.floor(Math.random()*6)+1;
    	    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
    	        	n = (int) Math.floor(Math.random()*6)+1;
    	    	}
    	    	prochain=n-1;
    		}
    		else {
    			System.out.println("Vous ne v�rifiez pas la condition");
    		}
    	}
    	
    	//Hooked Nose hunt action
    	else if (m.equalsIgnoreCase("ho")){
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[6]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Hooked Nose.");
    		HookedNose hookedNose= new HookedNose();    		
	    	joueurCibl� = (int) Math.floor(Math.random()*6);
	    	while (joueurCibl�==this.numJoueur  || (joueurCibl� != jv1 && joueurCibl� !=jv2 && joueurCibl� !=jv3 && joueurCibl� != jv4 && joueurCibl� != jv5 && joueurCibl� != jv6) || joueurCibl� == 0) {
	        	joueurCibl� = (int) Math.floor(Math.random()*6);
	    	}
	    	r�sultat = 2;
	    	prochain=joueurCibl�-1;
    	}
    	
    	// Broomstick hunt action
    	else if (m.equalsIgnoreCase("br")) {
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[2]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Broomstick.");
    		this.protectionBroomstick = true;
    		Broomstick broomstick= new Broomstick();
    		broomstick.huntAction();
	    	System.out.println("Qui va jouer au prochain tour ? Veuillez choisir un joueur encore en jeu et ne pas vous choisir vous m�me ! ");
	    	int n = (int) Math.floor(Math.random()*6)+1;
	    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
	        	n = (int) Math.floor(Math.random()*6)+1;
	    	}
	    	prochain=n-1;
    	}
    	
    	// Wart hunt action 
    	else if (m.equalsIgnoreCase("wa")){
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[11]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Wart.");
    		this.protectionWart = true;
    		Wart wart= new Wart();
    		wart.huntAction();
	    	System.out.println("Qui va jouer au prochain tour ? Veuillez choisir un joueur encore en jeu et ne pas vous choisir vous m�me ! ");
	    	int n = (int) Math.floor(Math.random()*6)+1;
	    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
	        	n = (int) Math.floor(Math.random()*6)+1;
	    	}
	    	prochain=n-1;
    	}
    	
    	//Ducking Stool hunt action
    	else if (m.equalsIgnoreCase("du")) {
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[4]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Ducking Stool.");
    		DuckingStool duckingStool= new DuckingStool();
    		int n=0;
        	boolean erreur5;
    		do {
        		erreur5 = false;
        		try {
        	    	System.out.println("Veuillez choisir de quel joueur vous voulez r�v�ler la carte.");
        	    	n = (int) Math.floor(Math.random()*6)+1; 
        		}
        		catch (InputMismatchException e) {
        			erreur5 = true;
        			System.out.println("Veuillez rentrer un entier");
        		}
        	} while (erreur5);
        	System.out.println("Vous avez choisi d'accuser le joueur " +n); 
        	joueurCibl� = n-1;
    		if(liste.get(joueurCibl�).protectionWart == true && joueurCibl�==this.numJoueur  || (joueurCibl� != jv1 && joueurCibl� !=jv2 && joueurCibl� !=jv3 && joueurCibl� != jv4 && joueurCibl� != jv5 && joueurCibl� != jv6) || joueurCibl� == 0) {
				System.out.println("Le joueur choisi est prot�g� par la carte Wart, choisissez un autre joueur.");
				do {
	        		erreur5 = false;
	        		try {
	        	    	System.out.println("Veuillez choisir de quel joueur vous voulez r�v�ler la carte.");
	        	    	n = (int) Math.floor(Math.random()*6)+1;
	        		}
	        		catch (InputMismatchException e) {
	        			erreur5 = true;
	        			System.out.println("Veuillez rentrer un entier");
	        		}
	        	} while (erreur5);
	        	System.out.println("Vous avez choisi d'accuser le joueur " +n); 
	        	joueurCibl� = n-1;
			}
    		r�sultat = 3;
    	}
    	
    	// toad hunt action
    	else if (m.equalsIgnoreCase("to")){
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[10]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Toad.");
    		Toad toad= new Toad();
    		toad.huntAction();
    		if (this.villageois == true ) {
    			System.out.println("Vous �tiez un villageois");
    	    	System.out.println("Qui va jouer au prochain tour ? Veuillez choisir un joueur encore en jeu et ne pas vous choisir vous m�me ! ");
    	    	int n = (int) Math.floor(Math.random()*6)+1;
    	    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
    	        	n = (int) Math.floor(Math.random()*6)+1;
    	    	}
    	    	prochain=n-1;
    		}
    		else {
    			System.out.println("Vous �tiez une sorci�re");
    			if (prochain == 0) {
    				prochain=nombre-1;
    			}
    			else {
    				prochain=prochain-1;
    			}
    		}
    		joueursVie = joueursVie -1;
            liste.remove(this);
            listeNum�ro.remove(this.numJoueur-1);
    		this.carteR�v�l�e=true;
    	}
    	
    	
    	
    	//Evil eye hunt action
    	else if (m.equalsIgnoreCase("ev")) {
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[5]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Evil Eye.");
    		EvilEye evilEye= new EvilEye();
    		evilEye.huntAction();
	    	int n = (int) Math.floor(Math.random()*6)+1;
	    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
	    		n = (int) Math.floor(Math.random()*6)+1;
	    	}
	    	joueurCibl� = this.numJoueur;
	    	prochain=n-1;
    	}
    	
    	//Cauldron hunt action 
    	else if (m.equalsIgnoreCase("ca")){
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[3]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Cauldron.");
    		Cauldron cauldron= new Cauldron();
    		cauldron.huntAction();
    		if (this.villageois == true ) {
    			System.out.println("Vous �tiez un villageois");
    	    	System.out.println("Qui va jouer au prochain tour ? Veuillez choisir un joueur encore en jeu et ne pas vous choisir vous m�me ! ");
    	    	int n = (int) Math.floor(Math.random()*6)+1;
    	    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
    	    		n = (int) Math.floor(Math.random()*6)+1;
    	    	}
    	    	prochain=n-1;
    		}
    		else {
    			System.out.println("Vous �tiez une sorci�re");
    			if (prochain == 0) {
    				prochain=nombre-1;
    			}
    			else {
    				prochain=prochain-1;
    			}
    		}
    		this.carteR�v�l�e=true;
    		joueursVie = joueursVie -1;
            liste.remove(this);
            listeNum�ro.remove(this.numJoueur-1);
    	}
    	
    	//Black Cat hunt action
    	else if (m.equalsIgnoreCase("bl")) {
    		List<Carte> cartesD�fauss�es = new ArrayList<Carte>();
    		cartesD�fauss�es = carteJou�e ;
    		if (cartesD�fauss�es.size() == 0) {
    			System.out.println("Vous n'avez jou� aucune carte, vous ne pouvez pas utiliser cette carte");
    		}
    		else {
        		CarteRumeurEnum[] c=CarteRumeurEnum.values();
        		Carte carte = new Carte(c[1]);
        		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Black Cat.");
        		BlackCat blackCat= new BlackCat();
        		blackCat.huntAction();
        		System.out.println("Voici les cartes que vous avez d�ja utilis�es :");
        		System.out.println(carteJou�e);
    			System.out.println("Quelle carte voulez vous r�cup�rer ?");
    			int v = (int) Math.floor(Math.random()*11)+1;
    			while (v<1 || v>carteJou�e.size()) {
    				v = (int) Math.floor(Math.random()*11)+1;
    			}
    			main.add(carteJou�e.get(v-1));
    			carteJou�e.remove(v-1);
    			retirerCarte(carte);
    		}
    	}
    	
    	//Pet Newt hunt action
    	else if (m.equalsIgnoreCase("pe")){
    		List<Carte> cartesD�fauss�esAutresJoueurs = new ArrayList<Carte>();
    		cartesD�fauss�esAutresJoueurs = cartesD�fauss�es ;
    		if (cartesD�fauss�esAutresJoueurs.size() == 0) {
    			System.out.println("Aucune carte n'a �tait d�fauss�e, vous ne pouvez pas utiliser cette carte.");
    		}
    		else {
	    	    CarteRumeurEnum[] c=CarteRumeurEnum.values();
	    		Carte carte = new Carte(c[7]);
	    		retirerCarte(carte);
	    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Pet Newt.");
	    		PetNewt petNewt= new PetNewt();
	    		petNewt.huntAction();
	    		for (int k=1; k<cartesD�fauss�es.size()+1; k++) {
	    			for(int j=0; j<carteJou�e.size(); j++) {
	    				if(cartesD�fauss�es.get(k-1).equals(carteJou�e.get(j))) {
	    					cartesD�fauss�es.remove(k-1);
	    					k--;
	    				}
	    			}
	    		}
	    		System.out.println(cartesD�fauss�es);
	    		Scanner sc = new Scanner(System.in);
	    		int k = 1;
	    		main.add(cartesD�fauss�es.get(k-1));
	    		cartesD�fauss�es.remove(k-1);
		    	System.out.println("Qui va jouer au prochain tour ? Veuillez choisir un joueur encore en jeu et ne pas vous choisir vous m�me ! ");
		    	int n = (int) Math.floor(Math.random()*6)+1;
		    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
		    		n = (int) Math.floor(Math.random()*6)+1;
		    	}
		    	prochain=n-1;
    		}
    	}
    	
    	
    	System.out.println("\n");
    	int[] retour= {prochain, joueurCibl�, r�sultat, joueursVie};
    	return retour;
    }
    
    
    //***********************************************************************
    
    
    //Utiliser la m�thode witch d'une carte rumeur
    public int utiliserCarteWitch(int prochain, Joueur j, int nombre, ArrayList<Integer> listeNum�ro) {
    	int jv1=0;
    	int jv2=0;
    	int jv3=0;
    	int jv4=0;
    	int jv5=0;
    	int jv6=0;
    	Iterator<Integer> it = listeNum�ro.iterator();
    	boolean erreur2;
    	do {
    		erreur2 = false;
    		try {
    		while (it.hasNext())
	        {
	        	if (jv1 == 0) {
	        		jv1= (Integer)it.next();
	        	}
	        	else if (jv2 == 0) {
	        		jv2= (Integer)it.next();
	        	}
	        	else if (jv3 == 0) {
	        		jv3= (Integer)it.next();
	        	}
	        	else if (jv4 == 0) {
	        		jv4= (Integer)it.next();
	        	}
	        	else if (jv5 == 0) {
	        		jv5= (Integer)it.next();
	        	}
	        	else if (jv6 == 0) {
	        		jv6= (Integer)it.next();
	        	}
	    	}
        }
    	catch (NoSuchElementException e) {
    		erreur2 = true;
    		System.out.println("Il y a une erreur c'est triste");
    	}
    	}
    	while (erreur2);
    	String m = "u";
    	int joueurCibl�=0;
    	int r�sultat=-1;int i = 0;
    	boolean erreur;
    	boolean cartePossede = false;
    	String carteReferenceId = null;
    	Scanner reader = new Scanner(System.in);
    	boolean suite = false;
    	do {
    		erreur = false;
    		try {
    			Carte carteReference;
    	    	System.out.println("Voici les cartes que vous avez en votre possession :");
    	    	System.out.println(this.main);
    	    	System.out.println("\n");
    	    	System.out.println(this.nomJoueur + ", quelle carte voulez vous utiliser ?");
    	    	System.out.println("\n");
    	    	int choixCartes = (int) Math.floor(Math.random()*12);
    			if (choixCartes == 0) {
    				m = "an";	
    			}
    			else if (choixCartes == 1) {
    				m = "th";
    			}
    			else if (choixCartes == 2) {
    				m = "po";
    			}
    			else if (choixCartes == 3) {
    				m = "ho";
    			}
    			else if (choixCartes == 4) {
    				m = "br";
    			}
    			else if (choixCartes == 5) {
    				m = "wa";
    			}
    			else if (choixCartes == 6) {
    				m = "du";
    			}
    			else if (choixCartes == 7) {
    				m = "to";
    			}
    			else if (choixCartes == 8) {
    				m = "ev";
    			}
    			else if (choixCartes == 9) {
    				m = "ca";
    			}
    			else if (choixCartes == 10) {
    				m = "bl";
    			}
    			else if (choixCartes == 11) {
    				m = "pe";
    			}
    	    	while (m.equalsIgnoreCase("an")==false && m.equalsIgnoreCase("th")==false && m.equalsIgnoreCase("po")==false && m.equalsIgnoreCase("ho")==false && m.equalsIgnoreCase("br")==false && m.equalsIgnoreCase("wa")==false && m.equalsIgnoreCase("du")==false && m.equalsIgnoreCase("ca")==false && m.equalsIgnoreCase("ev")==false && m.equalsIgnoreCase("to")==false && m.equalsIgnoreCase("bl")==false && m.equalsIgnoreCase("pe")==false) {
    	    		System.out.println(m);
    	    	}
    	    	
    	    	while(!suite) {
    	    		i = 0;
    	    		while((!cartePossede) && (i<=main.size())) {
    	    			if(m.equals(carteReferenceId)) {
    	    				cartePossede = true;
    	    			}
    	    			else {
    	    				carteReference = main.get(i);
    	    				carteReferenceId = carteReference.getidCarte();
    	    			}
    	    			i++;
    	    		}
    	    		
    	    		if (cartePossede) {
    	    			suite = true;
    	    		}
    	    		else {
    	    			System.out.println("Vous ne poss�dez pas cette carte, veuillez res�lectionner une carte parmis votre main :");
    	    			System.out.println(this.main);
    	    			System.out.println("\n");
    	    			System.out.println("Renseingez les deux premi�res lettres correspondant � la carte que vous voulez utiliser!");
    	    	    	System.out.println("\n");
    	    	    	m = reader.nextLine();
    	    		}
    	    	}
    		}
    		catch (IndexOutOfBoundsException e) {
    			erreur = true;
    		}
    	} while (erreur);
    	
    	// Angry Mob witch action
    	if (m.equalsIgnoreCase("an")) {
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[0]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Angry Mob.");
    		AngryMob angryMob= new AngryMob();
    		angryMob.witchAction();
    		prochain=this.numJoueur-1;
    		System.out.println("Voici votre main :");
    		System.out.println(this.main);
    		System.out.println(this.carteJou�e);
    	}
    	
    	
    	// The Inquisition witch action
    	else if (m.equalsIgnoreCase("th")){
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[9]);
    		retirerCarte(carte);
    		Scanner sc = new Scanner(System.in);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte The Inquisition.");
    		TheInquisition theInquisition= new TheInquisition();
    		theInquisition.witchAction();
    		System.out.println("Voici votre main :");
    		System.out.println(main);
    		int n = sc.nextInt();
    		retirerCarte(main.get(n-1));
    		
    		//carteJou�e.add(main.get(n-1));
    		//cartesD�fauss�es.add(main.get(n-1));
    		//main.remove(n-1);
    		System.out.println("Voici votre main :");
    		System.out.println(main);
    		prochain = this.numJoueur-1;
    	}
    	
    	
    	// Pointed Hat witch action
    	else if (m.equalsIgnoreCase("po")) {
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[8]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Pointed Hat.");
    		PointedHat pointedHat= new PointedHat();
    		pointedHat.witchAction();
    		System.out.println("Voici les cartes que vous avez d�ja utilis�es :");
			System.out.println(carteJou�e);
			int v = (int) Math.floor(Math.random()*11)+1;
			while (v<1 || v>carteJou�e.size()) {
				v = (int) Math.floor(Math.random()*11)+1;
			}
			main.add(carteJou�e.get(v-1));
			carteJou�e.remove(v-1);
			prochain = this.numJoueur-1;
    	}
    	
    	
    	// Hooked Nose witch action
    	else if (m.equalsIgnoreCase("ho")){
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[6]);
    		retirerCarte(carte);
    		Scanner sc = new Scanner(System.in);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Hooked Nose.");
    		HookedNose houkedNose= new HookedNose();
    		houkedNose.witchAction();
    		System.out.println("Voici votre main :");
    		System.out.println(j.main);
    		int n = sc.nextInt();
    		main.add(j.main.get(n-1));
    		j.main.remove(n-1);
    		System.out.println("Voici votre main :");
    		System.out.println(main);
    		prochain = this.numJoueur-1;
    	}
    	
    	
    	// Broomstick witch action
    	else if (m.equalsIgnoreCase("br")) {
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[2]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Broomstick.");
    		Broomstick broomstick= new Broomstick();
    		broomstick.witchAction();
    		this.protectionBroomstick = true;
    		prochain = this.numJoueur-1;
    	}
    	
    	
    	// Wart witch action
    	else if (m.equalsIgnoreCase("wa")){
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[11]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Wart.");
    		Wart wart= new Wart();
    		wart.witchAction();
    		this.protectionWart = true;
    		prochain = this.numJoueur-1;
    	}
    	
    	
    	// Ducking Stool witch action
    	else if (m.equalsIgnoreCase("du")) {
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[4]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Ducking Stool.");
    		DuckingStool duckingStool= new DuckingStool();
    		duckingStool.witchAction();
    		int n=0;
        	boolean erreur3;
        	do {
        		erreur3 = false;
        		try {
        	    	n = (int) Math.floor(Math.random()*6)+1;
        	    	while (n==this.numJoueur && n>nombre) {
        	    		n = (int) Math.floor(Math.random()*6)+1;
        	    	}
            		prochain = n-1;
        		}
        		catch (InputMismatchException e) {
        			erreur3 = true;
        			System.out.println("Veuillez rentrer un entier");
        		}
        	} while (erreur3);
    	}
    	
    	
    	// Cauldron witch action
    	else if (m.equalsIgnoreCase("ca")){
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[3]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Cauldron.");
    		Cauldron cauldron= new Cauldron();
    		Random obj = new Random();
    		int n = obj.nextInt(j.main.size());
    		System.out.println("La carte " + j.main.get(n-1) + " est retir�e de la main du joueur " + j.nomJoueur);
    		j.carteJou�e.add(j.main.get(n-1));
    		cartesD�fauss�es.add(j.main.get(n-1));
    		j.main.remove(n-1);
    		cauldron.witchAction();
    		prochain = this.numJoueur-1;
    	}
    	
    	
    	// Evil Eye witch action
    	else if (m.equalsIgnoreCase("ev")) {
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[5]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Evil Eye.");
    		EvilEye EvilEye= new EvilEye();
    		EvilEye.witchAction();
	    	int n = (int) Math.floor(Math.random()*6)+1;
	    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
	    		n = (int) Math.floor(Math.random()*6)+1;
	    	}
	    	utilisationEvilEye = true;
	    	prochain=n-1;
    	}
    	
    	
    	// Toad witch action
    	else if (m.equalsIgnoreCase("to")){
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[10]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Toad.");
    		Toad toad= new Toad();
    		toad.witchAction();
    		prochain = this.numJoueur-1;
    	}
    	
    	
    	// Black Cat witch action
    	else if (m.equalsIgnoreCase("bl")) {
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[1]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Black Cat.");
    		BlackCat blackCat= new BlackCat();
    		blackCat.witchAction();
    		prochain = this.numJoueur-1;
    	}
    	
    	
    	// Pet Newt witch action
    	else if (m.equalsIgnoreCase("pe")){
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[8]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Pet Newt.");
    		PetNewt petNewt= new PetNewt();
    		petNewt.witchAction();
    		prochain = this.numJoueur-1;
    	}
    	System.out.println("\n");
    	return prochain;
    }
    
    
    public int actionAngryMob(Joueur j, int i) {
        if (j.villageois == true) {
        	System.out.println("Le joueur accus� �tait un villageois");
        	this.point -= 2;
        	i=j.numJoueur-1;
        }
        else {
        	System.out.println("Le joueur accus� �tait une sorci�re");
        	this.point += 2;
        	i=this.numJoueur-1;
        }
        this.carteR�v�l�e=true;   
        return i;
    }
    
    public int actionHookedNose(Joueur j) {
    	Random obj = new Random();
		int n = obj.nextInt(j.main.size());
		main.add(j.main.get(n-1));
		j.main.remove(n-1);
    	return j.numJoueur-1;
    }
    
    public int[] actionDuckingStool(Joueur j, int i, ArrayList<Joueur> liste, int joueursVie) throws InputMismatchException {
    	int n=0;
    	boolean erreur;
    	do {
    		erreur = false;
    		try {
    			System.out.println("Joueur " + j.numJoueur + " souhaitez vous r�v�ler votre identit� (1) ou vous d�barasser d'une carte (2) ?");
    	    	n = c.actionDuckingStool();
    		}
    		catch (InputMismatchException e) {
    			erreur = true;
    		}
    	} while (erreur);
    	if(n==1) {
    		if (j.villageois == true) {
            	System.out.println("Le joueur " + j.numJoueur + " �tait un villageois");
            	this.point -= 1;
            	i=j.numJoueur-1;
            }
            else {
            	System.out.println("Le joueur " + j.numJoueur + " �tait une sorci�re");
            	this.point += 1;
            	i=this.numJoueur-1;
            }
    		this.carteR�v�l�e = true;
    		joueursVie = joueursVie-1;
    		liste.remove(j);
    	}
    	else {
    		int m=0;
        	do {
        		erreur = false;
        		try {
        			System.out.println("Quelle carte voulez vous d�fausser choisissez entre 1 et " + j.main.size() + " ?");
            		System.out.println(j.main);
            		m = (int) Math.floor(Math.random()*11)+1;
            		while(m<1 && m>j.main.size()) {
            			m = (int) Math.floor(Math.random()*11)+1;
            		}
        		}
        		catch (InputMismatchException e2) {
        			erreur = true;
        		}
        	} while (erreur);     	        	
    		System.out.println("Vous avez choisi de d�fausser la carte" + j.main.get(m-1));
    		j.retirerCarte(j.main.get(m-1));
    		System.out.println("Voici votre nouvelle main :");
    		System.out.println(j.main);
    		i=j.numJoueur-1;
    	}
    	System.out.println("\n");
    	int[] retour= {i, joueursVie};
    	return retour;
    }
    
    
    
    
    
    

	public String toString () {
		StringBuffer sb = new StringBuffer();
		sb.append("Le joueur " +this.numJoueur+ " est un bot. Il s'appelle ");
		sb.append(this.nomJoueur);
		sb.append(" et il a  " +  main.size() + " cartes dans sa main \n");
		sb.append("Et le joueur a " +this.point+ " points.");
		sb.append("\n");
		sb.append("\n");
		return sb.toString();
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de comportement.
     * 
     * @return on retourne la valeur de comportement.
     */
	public Comportement getComportement() {
		return comportement;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de comportement.
     * 
     * @param comportement la valeur que nous voulons d�finir
     */
	public void setComportement(Comportement comportement) {
		this.comportement = comportement;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de choix.
     * 
     * @return on retourne la valeur de choix.
     */
	public int getChoix() {
		return choix;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de choix.
     * 
     * @param choix la valeur que nous voulons d�finir
     */
	public void setChoix(int choix) {
		this.choix = choix;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de c.
     * 
     * @return on retourne la valeur de c.
     */
	public Comportement getC() {
		return c;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de c.
     * 
     * @param c la valeur que nous voulons d�finir
     */
	public void setC(Comportement c) {
		this.c = c;
	}
	
	
	
}
