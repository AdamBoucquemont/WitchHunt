package Model;

import java.util.*;

/**
 * Dans la classe Personnes nous allons réexpliquer toute les méthodes de joueurs mais pour des joueurs qui sont des personnes 
 * 
 * 
 * @author Adam 
 *
 */

public class Personne extends Joueur {

	/**
	 * Cette méthode permet de créer une personne qui sera un joueur mais avec des attributs en plus :
	 * 
	 * @param i le numéro du joueur 
	 *
	 */
    public Personne(int i) {
    	super(i);
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Quel est le nom du Joueur " +i);
    	String n = sc.nextLine();
    	this.nomJoueur=n;
    	System.out.println("Le joueur "+i+" s'appelle " +nomJoueur);
    }
    
    public int queFaire(int n) throws InputMismatchException {
    	int m=0;
    	boolean erreur;
    	do {
    		erreur = false;
    		try {
    			Scanner reader = new Scanner(System.in);
    	    	System.out.println(this.nomJoueur + ", Veuillez choisir entre accuser un autre joueur (1) ou utiliser une carte rumeur (2)");
    	    	m = reader.nextInt();
    	    	System.out.println("\n");
    	    	while (m!=1 && m!=2) {
    	    		System.out.println("L'action renseignée n'est pas possible, veuillez choisir entre accuser un joueur (1) ou utiliser une carte rumeur (2)");
    	        	m = reader.nextInt();
    	    	}
    		}
    		catch (InputMismatchException e) {
    			erreur = true;
    			System.out.println("Veuillez rentrer un entier");
    		}
    	} while (erreur);
    	return m;
    }
    
    
    public int accuser(ArrayList<Integer> listeNuméro, int joueursVie) throws InputMismatchException {
    	int m=0;
    	boolean erreur;
    	do {
    		erreur = false;
    		try {
    			int jv1=0;
    	    	int jv2=0;
    	    	int jv3=0;
    	    	int jv4=0;
    	    	int jv5=0;
    	    	int jv6=0;
    	    	Iterator<Integer> it = listeNuméro.iterator();
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
    			Scanner reader = new Scanner(System.in);
    	    	System.out.println("Vous avez choisi d'accuser quelqu'un, qui voulez vous accuser ?");
    	    	m = reader.nextInt();
    	    	System.out.println("\n");
    	    	while (m==this.numJoueur  || (m != jv1 && m !=jv2 && m !=jv3 && m != jv4 && m != jv5 && m != jv6) || m == 0) {
    	    		System.out.println("L'action renseignée n'est pas possible, veuillez choisir le numéro du joueur que vous voulez accuser!");
    	    		System.out.println("Cette personne doit avoir une carte cachée et ne doit pas être vous.");
    	        	m = reader.nextInt();
    	    	}
    		}
    		catch (InputMismatchException e) {
    			erreur = true;
    			System.out.println("Veuillez rentrer un entier");
    		}
    	} while (erreur);
    	System.out.println("Vous avez choisi d'accuser le joueur " +m);
    	System.out.println("\n");
    	return m-1;    	
    }
    
    
    public int estAccusé(int i) throws InputMismatchException {
    	int m=0;
    	boolean erreur;
    	do {
    		erreur = false;
    		try {
    			Scanner reader = new Scanner(System.in);
    			int j = i+1;
    	    	System.out.println(this.nomJoueur +" Vous vous êtes fait accuser par le joueur " +j);
    	    	System.out.println("Que voulez vous faire ?");
    	    	System.out.println("Tapez 1 si vous voulez dévoiler votre carte rôle et taper 2 si vous voulez utiliser une de vos cartes rumeurs");
    	    	m = reader.nextInt();
    	    	while (m!=1 && m!=2) {
    	    		System.out.println("L'action renseignée n'est pas possible, veuillez choisir entre dévoiler votre carte (1) ou utiliser une carte (2)");
    	        	m = reader.nextInt();
    	    	}
    		}
    		catch (InputMismatchException e) {
    			erreur = true;
    			System.out.println("Veuillez rentrer un entier");
    		}
    	} while (erreur);
    	System.out.println("\n");
    	if (m == 1) {
        	this.carteRévélée=true;
    	}
    	else {
    		System.out.println("Vous avez choisi d'utiliser une de vos cartes rumeurs");
    	}
    	return m;    	
    }
    
    
    public int[] dévoilerCarte(int i, Joueur j, int nombre, ArrayList<Joueur> liste, ArrayList<Integer> listeNuméro) {
    	System.out.println(j.nomJoueur + " Vous avez choisi de dévoiler votre carte rôle");
        if (j.villageois == true) {
        	System.out.println("Vous êtes un villageois");
        	i=j.numJoueur-1;
        }
        else {
        	System.out.println("Vous étiez une sorcière");
        	this.point = this.point + 1;
        } 
        nombre -= 1;
        liste.remove(j);
        listeNuméro.remove(this.numJoueur-1);
        int[] retour = {i, nombre};
        return retour;
    }
    
    
    public void choisirCamp() throws InputMismatchException {
    	int m=0;
    	boolean erreur;
    	do {
    		erreur = false;
    		try {
    			System.out.println(this.nomJoueur+ ", voici les cartes en votre possession");
    			System.out.println(this.main);
    	    	Scanner reader = new Scanner(System.in);
    	    	System.out.println(this.nomJoueur + ", Veuillez choisir entre être villageois (1) ou sorcière (2)");
    	    	m = reader.nextInt();
    	    	while (m!=1 && m!=2) {
    	    		System.out.println("L'action renseignée n'est pas possible, veuillez choisir entre être villageois (1) ou être sorcière (2)");
    	        	m = reader.nextInt();
    	    	}
    		}
    		catch (InputMismatchException e) {
    			erreur = true;
    			System.out.println("Veuillez rentrer un entier");
    		}
    	} while (erreur);
    	if (m == 1) {
    		this.villageois=true;
    		System.out.println(this.nomJoueur + " est un villageois. \n");
    	}
    	else {
    		this.villageois=false;
    		System.out.println(this.nomJoueur + " est une sorcière.\n");
    	}
    	this.carteRévélée=false;
    }
    
    
    
    
    /////////////////////////////////
    
    
    
    public int[] utiliserCarteHunt(int prochain, int nombre, ArrayList<Joueur> liste, int joueursVie, ArrayList<Integer> listeNuméro) {
    	int jv1=0;
    	int jv2=0;
    	int jv3=0;
    	int jv4=0;
    	int jv5=0;
    	int jv6=0;
    	Iterator<Integer> it = listeNuméro.iterator();
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
    	int i = 0;
    	String m="u";
    	int joueurCiblé=0;
    	int résultat=-1;
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
    	    	System.out.println("Renseingez les deux premières lettres correspondant à la carte que vous voulez utiliser!");
    	    	System.out.println("\n");
    	    	m = reader.nextLine();
    	    	while (m.equalsIgnoreCase("an")==false && m.equalsIgnoreCase("th")==false && m.equalsIgnoreCase("po")==false && m.equalsIgnoreCase("ho")==false && m.equalsIgnoreCase("br")==false && m.equalsIgnoreCase("wa")==false && m.equalsIgnoreCase("du")==false && m.equalsIgnoreCase("ca")==false && m.equalsIgnoreCase("ev")==false && m.equalsIgnoreCase("to")==false && m.equalsIgnoreCase("bl")==false && m.equalsIgnoreCase("pe")==false) {
    	    		System.out.println("L'action renseignée n'est pas possible, veuillez renseigner les deux premières lettres d'une de vos cartes");
    	        	m = reader.nextLine();
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
    	    			System.out.println("Vous ne possédez pas cette carte, veuillez resélectionner une carte parmis votre main :");
    	    			System.out.println(this.main);
    	    			System.out.println("\n");
    	    			System.out.println("Renseingez les deux premières lettres correspondant à la carte que vous voulez utiliser!");
    	    	    	System.out.println("\n");
    	    	    	m = reader.nextLine();
    	    		}
    	    	}
    		}
    		catch (IndexOutOfBoundsException e) {
    			erreur = true;
    			System.out.println("Veuillez rentrer votre choix en minuscule");
    		}
    	} while (erreur);
    	
    	
    	
    	// Angry Mob hunt action
    	if (m.equalsIgnoreCase("an")) {
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Angry Mob.");
    		AngryMob angryMob= new AngryMob();
    		boolean b = angryMob.vérifieCondition(this.villageois, this.carteRévélée);
    		if (b) {
    			CarteRumeurEnum[] c=CarteRumeurEnum.values();
        		Carte carte = new Carte(c[0]);
        		retirerCarte(carte);
    			angryMob.huntAction();
    			Scanner sc = new Scanner(System.in);
    	    	System.out.println("Veuillez choisir de quel joueur vous voulez révéler la carte.");
    	    	joueurCiblé = sc.nextInt();
    			if(liste.get(joueurCiblé).protectionBroomstick == true) {
    				System.out.println("Le joueur choisi est protégé par la carte Broomstick, choisissez un autre joueur.");
    				joueurCiblé = sc.nextInt();
    			}
    		}
    		else {
    			System.out.println("Vous ne pouvez pas utiliser cette carte");
    		}
    		résultat = 1;
    	}
    	
    	
    	// The Inquisition hunt action
    	else if (m.equalsIgnoreCase("th")){
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte The Inquisition.");
    		TheInquisition theInquisition= new TheInquisition();
    		boolean b = theInquisition.vérifieCondition(this.villageois, this.carteRévélée);
    		if(b) {
    			CarteRumeurEnum[] c=CarteRumeurEnum.values();
        		Carte carte = new Carte(c[9]);
        		retirerCarte(carte);
    			joueurCiblé = theInquisition.huntAction();
    		}
    		else {
    			System.out.println("Vous ne pouvez pas utiliser cette carte");
    		}
    		
    	}
    	
    	// PointedHat hunt action
    	else if (m.equalsIgnoreCase("po")) {
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Pointed Hat.");
    		PointedHat pointedHat= new PointedHat();
    		boolean b = pointedHat.vérifieCondition(this.carteJouée);
    		if (b == true) {
    			CarteRumeurEnum[] c=CarteRumeurEnum.values();
        		Carte carte = new Carte(c[8]);
        		retirerCarte(carte);
    			pointedHat.huntAction();
    			System.out.println("Voici les cartes que vous avez déja utilisées :");
    			System.out.println(carteJouée);
    			Scanner lecteur = new Scanner(System.in);
    			int v = lecteur.nextInt();
    			while (v<1 || v>carteJouée.size()) {
    				System.out.println("Le numéro de carte renseigné n'est pas possible, rentrer un nouveau numéro de carte");
    				v = lecteur.nextInt();
    			}
    			main.add(carteJouée.get(v-1));
    			carteJouée.remove(v-1);
    			
    			Scanner sc = new Scanner(System.in);
    	    	System.out.println("Qui va jouer au prochain tour ? Veuillez choisir un joueur encore en jeu et ne pas vous choisir vous même ! ");
    	    	int n = sc.nextInt();
    	    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
    	    		System.out.println("L'action renseignée n'est pas possible, veuillez choisir un numéro de joueur valide ");
    	        	n = reader.nextInt();
    	    	}
    	    	prochain=n-1;
    		}
    		else {
    			System.out.println("Vous ne vérifiez pas la condition");
    		}
    	}
    	
    	//Hooked Nose hunt action
    	else if (m.equalsIgnoreCase("ho")){
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[6]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Hooked Nose.");
    		HookedNose hookedNose= new HookedNose();    		
    		hookedNose.huntAction();
			Scanner sc = new Scanner(System.in);
	    	joueurCiblé = sc.nextInt();
	    	while (joueurCiblé==this.numJoueur  || (joueurCiblé != jv1 && joueurCiblé !=jv2 && joueurCiblé !=jv3 && joueurCiblé != jv4 && joueurCiblé != jv5 && joueurCiblé != jv6) || joueurCiblé == 0) {
	    		System.out.println("L'action renseignée n'est pas possible, veuillez choisir un numéro de joueur valide ");
	        	joueurCiblé = reader.nextInt();
	    	}
	    	résultat = 2;
	    	prochain=joueurCiblé-1;
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
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Qui va jouer au prochain tour ? Veuillez choisir un joueur encore en jeu et ne pas vous choisir vous même ! ");
	    	int n = sc.nextInt();
	    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
	    		System.out.println("L'action renseignée n'est pas possible, veuillez choisir un numéro de joueur valide!");
	    		System.out.println("Veuillez mettre un autre joueur que vous.");
	        	n = reader.nextInt();
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
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Qui va jouer au prochain tour ? Veuillez choisir un joueur encore en jeu et ne pas vous choisir vous même ! ");
	    	int n = sc.nextInt();
	    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
	    		System.out.println("L'action renseignée n'est pas possible, veuillez choisir un numéro de joueur valide ");
	        	n = reader.nextInt();
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
        			Scanner sc = new Scanner(System.in);
        	    	System.out.println("Veuillez choisir de quel joueur vous voulez révéler la carte.");
        	    	n = sc.nextInt();  
        		}
        		catch (InputMismatchException e) {
        			erreur5 = true;
        			System.out.println("Veuillez rentrer un entier");
        		}
        	} while (erreur5);
        	System.out.println("Vous avez choisi d'accuser le joueur " +n); 
        	joueurCiblé = n-1;
    		if(liste.get(joueurCiblé).protectionWart == true) {
				System.out.println("Le joueur choisi est protégé par la carte Wart, choisissez un autre joueur.");
				do {
	        		erreur5 = false;
	        		try {
	        			Scanner sc = new Scanner(System.in);
	        	    	System.out.println("Veuillez choisir de quel joueur vous voulez révéler la carte.");
	        	    	n = sc.nextInt();  
	        		}
	        		catch (InputMismatchException e) {
	        			erreur5 = true;
	        			System.out.println("Veuillez rentrer un entier");
	        		}
	        	} while (erreur5);
	        	System.out.println("Vous avez choisi d'accuser le joueur " +n); 
	        	joueurCiblé = n-1;
			}
    		résultat = 3;
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
    			System.out.println("Vous étiez un villageois");
    	    	Scanner sc = new Scanner(System.in);
    	    	System.out.println("Qui va jouer au prochain tour ? Veuillez choisir un joueur encore en jeu et ne pas vous choisir vous même ! ");
    	    	int n = sc.nextInt();
    	    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
    	    		System.out.println("L'action renseignée n'est pas possible, veuillez choisir un numéro de joueur valide ");
    	        	n = reader.nextInt();
    	    	}
    	    	prochain=n-1;
    		}
    		else {
    			System.out.println("Vous étiez une sorcière");
    			if (prochain == 0) {
    				prochain=nombre-1;
    			}
    			else {
    				prochain=prochain-1;
    			}
    		}
    		joueursVie = joueursVie -1;
            liste.remove(this);
            listeNuméro.remove(this.numJoueur-1);
    		this.carteRévélée=true;
    	}
    	
    	
    	
    	//Evil eye hunt action
    	else if (m.equalsIgnoreCase("ev")) {
    		CarteRumeurEnum[] c=CarteRumeurEnum.values();
    		Carte carte = new Carte(c[5]);
    		retirerCarte(carte);
    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Evil Eye.");
    		EvilEye evilEye= new EvilEye();
    		evilEye.huntAction();
    		Scanner sc = new Scanner(System.in);
	    	int n = sc.nextInt();
	    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
	    		System.out.println("L'action renseignée n'est pas possible, veuillez choisir un numéro de joueur valide ");
	        	n = reader.nextInt();
	    	}
	    	joueurCiblé = this.numJoueur;
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
    			System.out.println("Vous étiez un villageois");
    	    	Scanner sc = new Scanner(System.in);
    	    	System.out.println("Qui va jouer au prochain tour ? Veuillez choisir un joueur encore en jeu et ne pas vous choisir vous même ! ");
    	    	int n = sc.nextInt();
    	    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
    	    		System.out.println("L'action renseignée n'est pas possible, veuillez choisir un numéro de joueur valide ");
    	        	n = reader.nextInt();
    	    	}
    	    	prochain=n-1;
    		}
    		else {
    			System.out.println("Vous étiez une sorcière");
    			if (prochain == 0) {
    				prochain=nombre-1;
    			}
    			else {
    				prochain=prochain-1;
    			}
    		}
    		this.carteRévélée=true;
    		joueursVie = joueursVie -1;
            liste.remove(this);
            listeNuméro.remove(this.numJoueur-1);
    	}
    	
    	//Black Cat hunt action
    	else if (m.equalsIgnoreCase("bl")) {
    		List<Carte> cartesDéfaussées = new ArrayList<Carte>();
    		cartesDéfaussées = carteJouée ;
    		if (cartesDéfaussées.size() == 0) {
    			System.out.println("Vous n'avez joué aucune carte, vous ne pouvez pas utiliser cette carte");
    		}
    		else {
        		CarteRumeurEnum[] c=CarteRumeurEnum.values();
        		Carte carte = new Carte(c[1]);
        		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Black Cat.");
        		BlackCat blackCat= new BlackCat();
        		blackCat.huntAction();
        		System.out.println("Voici les cartes que vous avez déja utilisées :");
        		System.out.println(carteJouée);
    			Scanner lecteur = new Scanner(System.in);
    			System.out.println("Quelle carte voulez vous récupérer ?");
    			int v = lecteur.nextInt();
    			while (v<1 || v>carteJouée.size()) {
    				System.out.println("Le numéro de carte renseigné n'est pas possible, rentrer un nouveau numéro de carte");
    				v = lecteur.nextInt();
    			}
    			main.add(carteJouée.get(v-1));
    			carteJouée.remove(v-1);
    			retirerCarte(carte);
    		}
    	}
    	
    	//Pet Newt hunt action
    	else if (m.equalsIgnoreCase("pe")){
    		List<Carte> cartesDéfausséesAutresJoueurs = new ArrayList<Carte>();
    		cartesDéfausséesAutresJoueurs = cartesDéfaussées ;
    		if (cartesDéfausséesAutresJoueurs.size() == 0) {
    			System.out.println("Aucune carte n'a était défaussée, vous ne pouvez pas utiliser cette carte.");
    		}
    		else {
	    	    CarteRumeurEnum[] c=CarteRumeurEnum.values();
	    		Carte carte = new Carte(c[7]);
	    		retirerCarte(carte);
	    		System.out.println(this.nomJoueur + " Vous avez choisi d'utiliser la carte Pet Newt.");
	    		PetNewt petNewt= new PetNewt();
	    		petNewt.huntAction();
	    		for (int k=1; k<cartesDéfaussées.size()+1; k++) {
	    			for(int j=0; j<carteJouée.size(); j++) {
	    				if(cartesDéfaussées.get(k-1).equals(carteJouée.get(j))) {
	    					cartesDéfaussées.remove(k-1);
	    					k--;
	    				}
	    			}
	    		}
	    		System.out.println(cartesDéfaussées);
	    		Scanner sc = new Scanner(System.in);
	    		int k = sc.nextInt();
	    		main.add(cartesDéfaussées.get(k-1));
	    		cartesDéfaussées.remove(k-1);
	    		Scanner lecteur = new Scanner(System.in);
		    	System.out.println("Qui va jouer au prochain tour ? Veuillez choisir un joueur encore en jeu et ne pas vous choisir vous même ! ");
		    	int n = lecteur.nextInt();
		    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
		    		System.out.println("L'action renseignée n'est pas possible, veuillez choisir un numéro de joueur valide ");
		        	n = lecteur.nextInt();
		    	}
		    	prochain=n-1;
    		}
    	}
    	
    	
    	System.out.println("\n");
    	int[] retour= {prochain, joueurCiblé, résultat, joueursVie};
    	return retour;
    }
    
    
    
    ///////////////////////////////////////////
    // Witch Action 
    
    public int utiliserCarteWitch(int prochain, Joueur j, int nombre, ArrayList<Integer> listeNuméro) {
    	int jv1=0;
    	int jv2=0;
    	int jv3=0;
    	int jv4=0;
    	int jv5=0;
    	int jv6=0;
    	Iterator<Integer> it = listeNuméro.iterator();
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
    	System.out.println("\n");
    	boolean cartePossede = false;
    	String carteReferenceId = null;
    	Carte carteReference;
    	boolean suite = false;
    	System.out.println("Voici les cartes que vous avez en votre possession :");
    	System.out.println(this.main);
    	System.out.println("\n");
    	Scanner reader = new Scanner(System.in);
    	System.out.println(this.nomJoueur + ", quelle carte voulais vous utiliser ?");
    	System.out.println("Renseingez les deux premières lettres correspondant à la carte que vous voulez utiliser!");
    	System.out.println("\n");
    	String m = reader.nextLine();
    	while (m.equalsIgnoreCase("an")==false && m.equalsIgnoreCase("th")==false && m.equalsIgnoreCase("po")==false && m.equalsIgnoreCase("ho")==false && m.equalsIgnoreCase("br")==false && m.equalsIgnoreCase("wa")==false && m.equalsIgnoreCase("du")==false && m.equalsIgnoreCase("ca")==false && m.equalsIgnoreCase("ev")==false && m.equalsIgnoreCase("to")==false && m.equalsIgnoreCase("bl")==false && m.equalsIgnoreCase("pe")==false) {
    		System.out.println("L'action renseignée n'est pas possible, veuillez renseigner les deux premières lettres de la carte que vous voulez utiliser.");
        	m = reader.nextLine();
    	}
    	
    	while(!suite) {
    		int i = 0;
    		while((!cartePossede) && (i<=main.size()-1)) {
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
    			System.out.println("Vous ne possédez pas cette carte, veuillez resélectionner une carte parmis votre main :");
    			System.out.println(this.main);
    			System.out.println("\n");
    			System.out.println("Renseingez les deux premières lettres correspondant à la carte que vous voulez utiliser!");
    	    	System.out.println("\n");
    	    	m = reader.nextLine();
    		}
    	}
    	
    	
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
    		System.out.println(this.carteJouée);
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
    		
    		//carteJouée.add(main.get(n-1));
    		//cartesDéfaussées.add(main.get(n-1));
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
    		System.out.println("Voici les cartes que vous avez déja utilisées :");
			System.out.println(carteJouée);
			Scanner lecteur = new Scanner(System.in);
			int v = lecteur.nextInt();
			while (v<1 || v>carteJouée.size()) {
				System.out.println("Le numéro de carte renseigné n'est pas possible, rentrer un nouveau numéro de carte");
				v = lecteur.nextInt();
			}
			main.add(carteJouée.get(v-1));
			carteJouée.remove(v-1);
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
        	boolean erreur;
        	do {
        		erreur = false;
        		try {
        			Scanner sc = new Scanner(System.in);
        	    	n = sc.nextInt();
        	    	while (n==this.numJoueur && n>nombre) {
        	    		System.out.println("L'action renseignée n'est pas possible, veuillez choisir un numéro de joueur valide ");
        	        	n = reader.nextInt();
        	    	}
            		prochain = n-1;
        		}
        		catch (InputMismatchException e) {
        			erreur = true;
        			System.out.println("Veuillez rentrer un entier");
        		}
        	} while (erreur);
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
    		System.out.println("La carte " + j.main.get(n-1) + " est retirée de la main du joueur " + j.nomJoueur);
    		j.carteJouée.add(j.main.get(n-1));
    		cartesDéfaussées.add(j.main.get(n-1));
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
    		Scanner sc = new Scanner(System.in);
	    	int n = sc.nextInt();
	    	while (n==this.numJoueur  || (n != jv1 && n !=jv2 && n !=jv3 && n != jv4 && n != jv5 && n != jv6) || n == 0) {
	    		System.out.println("L'action renseignée n'est pas possible, veuillez choisir un numéro de joueur valide ");
	        	n = reader.nextInt();
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
        	System.out.println("Le joueur accusé était un villageois");
        	this.point -= 2;
        	i=j.numJoueur-1;
        }
        else {
        	System.out.println("Le joueur accusé était une sorcière");
        	this.point += 2;
        	i=this.numJoueur-1;
        }
        this.carteRévélée=true;   
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
    			System.out.println("Joueur " + j.numJoueur + " souhaitez vous révéler votre identité (1) ou vous débarasser d'une carte (2) ?");
    	    	Scanner sc = new Scanner(System.in);
    	    	n = sc.nextInt();
    	    	while (n!=1 && n!=2) {
    	    		System.out.println("L'action renseigneé n'est pas possible, choisissez entre révéler votre identité (1) ou vous débarasser d'une carte (2).");
    	    		n = sc.nextInt();
    	    	}
    		}
    		catch (InputMismatchException e) {
    			erreur = true;
    			System.out.println("Veuillez rentrer un entier");
    		}
    	} while (erreur);
    	if(n==1) {
    		if (j.villageois == true) {
            	System.out.println("Le joueur " + j.numJoueur + " était un villageois");
            	this.point -= 1;
            	i=j.numJoueur-1;
            }
            else {
            	System.out.println("Le joueur " + j.numJoueur + " était une sorcière");
            	this.point += 1;
            	i=this.numJoueur-1;
            }
    		this.carteRévélée = true;
    		joueursVie = joueursVie-1;
    		liste.remove(j);
    	}
    	else {
    		int m=0;
        	do {
        		erreur = false;
        		try {
        			System.out.println("Quelle carte voulez vous défausser choisissez entre 1 et " + j.main.size() + " ?");
            		System.out.println(j.main);
            		Scanner reader = new Scanner(System.in);
            		m = reader.nextInt();
            		while(m<1 && m>j.main.size()) {
            			System.out.println("Le numéro de carte n'est pas possible, veuillez rentrer un numéro de carte entre 1 et" + j.main.size() + ".");
            			m = reader.nextInt();
            		}
        		}
        		catch (InputMismatchException e2) {
        			erreur = true;
        			System.out.println("Veuillez rentrer un entier");
        		}
        	} while (erreur);     	        	
    		System.out.println("Vous avez choisi de défausser la carte" + j.main.get(m-1));
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
		sb.append("Le joueur " +this.numJoueur+ " est une personne. Il s'appelle ");
		sb.append(this.nomJoueur);
		sb.append(" et il a  " +  main.size() + " cartes dans sa main \n");
		sb.append("Et le joueur a " +this.point+ " points.");
		sb.append("\n");
		sb.append("\n");
		return sb.toString();
	}

	
	
	
    

}
