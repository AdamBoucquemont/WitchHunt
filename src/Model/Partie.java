package Model;

import java.util.*;

/**
 * Dans la classe partie nous avons le coeur du code de notre projet.
 * En effet c'est dans cette classe qu'est présent la méthode main qui fait le déroulement de jeu.
 * 
 * 
 * @author Adam 
 *
 */

public class Partie {
	
	/**
	 * Cette variable contient le nombre de joueurs dans la partie
	 */
	private int nombreJoueurs;
	
	/**
	 * Cette variable désigne une action
	 */
	private int action;
	
	/**
	 * Cette variable est le numéro d'une autre carte
	 */
	private int autreCarte;
	
	/**
	 * Cette variable est un tableau contenant tous les retours d'une fonction
	 */
	private static int [] retour;
	
	/**
	 * Cette variable est le résultat d'une action
	 */
	private int résultat;
	
	/**
	 * Cette variable est le nombre de joueur encore en vie 
	 */
	private int joueursVie;
	
	/**
	 * Cette variable est le numéro du prochain joueur 
	 */
	private int prochainJoueur;
	
	/**
	 * Cette variable est le numéro d'un joueur accusé
	 */
	private int joueurAccusé;
	
	/**
	 * Cette variable est une référence à la décision que doit prendre un joueur
	 */
	private int décision;
	
	/**
	 * Cette variable est le meilleur score atteint
	 */
	private int scoreMax;
	
	/**
	 * Cette variable est un numéro de jouer qui a atteint le meilleur score
	 */
	private int joueurScoreMax;
	
	/**
	 * Cette variable est le nombre de bot jouant à la partie
	 */
	private int nombreBot;
	
	/**
	 * Cette variable est le nombre de personne jouant à la partie
	 */
	private int nombrePersonne;
	
	/**
	 * Cette variable contient le nombre de cartes
	 */
	private int nombreCartes;
	
	/**
	 * Cette variable est un appel à une nouvelle partie 
	 */
	private static Partie idPartie = null;
	
	/**
	 * Cette variable est un appel à un nouveau jeu de carte
	 */
    private JeuCartes jeu;
    
    /**
	 * Cette variable est la liste de tous les joueurs 
	 */
    private ArrayList<Joueur> listJoueurs; 
    
    /**
	 * Cette variable est une liste des joueurs avec une carte non dvoilée
	 */
    private ArrayList<Joueur> JoueursEnVie;
    
    /**
	 * Cette variable est une liste des numéros des joueurs
	 */
    private ArrayList<Integer> numJoueursVie= new ArrayList<Integer>();
    
    /**
	 * Cette variableest une liste des numéros des joueurs
	 */
    private ArrayList<Integer> numJoueursVieSvg= new ArrayList<Integer>();
    
    /**
	 * Cette variable est une liste des numéros des joueurs
	 */
    private ArrayList<Integer> numJoueursEvilEye= new ArrayList<Integer>();
    
    /**
	 * Cette variable désigne, part son numéro, le joueur gagnant
	 */
    private int gagnantPartie;
    
    /**
	 * Cette variable est un appel à un jeu de carte
	 */
    private JeuCartes carteEnTrop;
    
    /**
	 * Cette variable est un appel à un objet joueur
	 */
	private Joueur joueur;
	
	/**
	 * Cette variable contient un appel à un objet manche
	 */
	private Manche manche;


	/**
	 * Cette variable est une liste de joueurs qui vont prendre part à la partie
	 */
    public List<Joueur> contient = new ArrayList<Joueur> ();

    /**
	 * Cette méthode permet de créer une nouvelle partie
	 * 
	 * @return un identifiant unique de la partie
	 */
    public static Partie getInstance() {
    	if (idPartie == null) {
    		idPartie = new Partie();
    	}
    	return idPartie;
    }

    /**
	 * Cette méthode est le contructeur de la partie
	 * De base tous les joueurs sont à 0, il y a 12 cartes et on créé une liste de joueurs et de cartes.
	 */
    public Partie() {
    	this.nombrePersonne=0;
    	this.nombreJoueurs=0;
    	this.nombreBot=0;
    	this.nombreCartes=12;
		this.listJoueurs=new ArrayList<Joueur>(); 
		this.jeu = new JeuCartes();
		this.carteEnTrop = new JeuCartes(); 
		this.gagnantPartie=8;
    }

    /**
	 * Cette méthode permet de rentrer le nombre de joueurs 
	 * 
	 * @throws InputMismatchException cette exception est levée, elle enlève la possibilité de mettre des lettres au lieux d'entier.
	 * @return un entier correspondant au nombre joueurs (entre 3 et 6)
	 */
    public int rentreNombreJoueurs() throws InputMismatchException{
    	int n=0;
    	boolean erreur;
    	do {
    		erreur = false;
    		try {
    			Scanner reader = new Scanner(System.in);
    			System.out.println("A combien de joueurs va se jouer la partie (entre 3 et 6) ?");
    			n = reader.nextInt();
    			while (n<3 || n>6) {
    				System.out.println("Le nombre de joueur renseigné n'est pas possible, veuillez renseigner un nouveau nombre de joueur en 3 et 6.");
    				n = reader.nextInt();
    			}
    		}
    		catch (InputMismatchException e) {
    			erreur = true;
    			System.out.println("Veuillez rentrer un entier");
    		}
    	} while (erreur);
    	return n;
    }
    
    /**
	 * Cette méthode permet de rentrer le nombre de personnes
	 * 
	 * @param n c'est le nombre de joueurs, ainsi on ne peut pas rentrer un nombre de personne supérieur au nombre de joueurs
	 * @throws InputMismatchException cette exception est levée, elle enlève la possibilité de mettre des lettres au lieux d'entier.
	 * @return un entier correspondant au nombre de personnes (entre 0 et le nombre de joueurs)
	 */
    public int rentreNombrePersonne(int n) throws InputMismatchException{
    	int m=0;
    	boolean erreur;
    	do {
    		erreur = false;
    		try {
    			Scanner reader = new Scanner(System.in);
    			System.out.println("Combien de personne vont jouer à la partie ? Vous pouvez choisir au maximum " + n + " joueurs");
    			m = reader.nextInt();
    	    	while (m<0 || m>n) {
    	    		System.out.println("Le nombre de personne renseigné n'est pas possible, veuillez renseigner un nouveau nombre de joueur en 0 et " + n);
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
    
    
    /**
	 * Cette méthode permet de calculer le nombre bots
	 * 
	 * @param n c'est le nombre de joueurs, 
	 * @param m c'est le nombre personnes
	 * @return un entier correspondant au nombre de bot (différence entre le nombre de joueurs et le nombre de bots)
	 */
    public int calculNombreBot(int n, int m) {
    	return n - m;
    }
    
    /**
	 * Cette méthode permet de distribuer des cartes à chaque joueurs.
	 * Si le compte n'est pas ronds, les cartes restantes seront laissées au milieu.
	 * Les cartes seront directement mis dans la main de chaque joueurs.
	 * 
	 * @param n c'est le nombre de joueurs
	 */
	public void distribuerCartes(int n){
		if (n == 5) {
			int i = 0;
			jeu.melanger(); 
			while (i!=10){ 
				Iterator<Joueur> it =listJoueurs.iterator(); 
				while(it.hasNext()){ 
					Carte carte = jeu.distribuerUneCarte(); 
					it.next().ramasserCarte(carte); 
					i = i+ 1;
				} 
			}
		}
		else {
			jeu.melanger(); 
			while (jeu.estVide() == false){ 
				Iterator<Joueur> it =listJoueurs.iterator(); 
				while(it.hasNext()){ 
					Carte carte = jeu.distribuerUneCarte(); 
					it.next().ramasserCarte(carte); 
				} 
			}
		}	
	}
	
	/**
	 * Cette méthode permet de faire passer une action en rentrant n'importe quel caractère
	 */
	public void appuyer() {
		Scanner reader = new Scanner(System.in);
    	System.out.println("Rentrez un caractère pour continuer");
    	String m = reader.nextLine();
    	System.out.println("\n");
	}
	
	/**
	 * Cette méthode permet d'ajouter un joueur à la liste des joueurs
	 * 
	 * @param joueur c'est le joueur à ajouter
	 */
	public void ajouterUnJoueur(Joueur joueur){ 
		listJoueurs.add(joueur);
	} 
	
	/**
	 * Cette méthode permet d'ajouter un numéro
	 * 
	 * @param i c'est le numéro à ajouter à la liste
	 */
	public void ajouterUnNuméro(int i){ 
		numJoueursVieSvg.add(i);
	}
	
	/**
	 * Cette méthode est la méthode principal du projet, c'est elle qui fait se dérouler toute la partie.
	 * 
	 * @param args la liste des arguments dont se sert la fonction main
	 */
    public static void main (String[] args) {
    	Partie witchHunt = Partie.getInstance();
    	System.out.println("Bonjour.");
    	System.out.println("Bienvenue dans une nouvelle partie du jeu Witch Hunt !");
    	witchHunt.nombreJoueurs=witchHunt.rentreNombreJoueurs();
    	witchHunt.nombrePersonne=witchHunt.rentreNombrePersonne(witchHunt.nombreJoueurs);
    	witchHunt.nombreBot=witchHunt.calculNombreBot(witchHunt.nombreJoueurs, witchHunt.nombrePersonne);
    	System.out.println("\n");
    	System.out.println("Nombres de joueurs : " + witchHunt.nombreJoueurs);
    	System.out.println("Nombres de personnes : " + witchHunt.nombrePersonne);
    	System.out.println("Nombre de Bot : " + witchHunt.nombreBot);
    	System.out.println("\n");
    	Joueur[] joueurs = new Joueur[witchHunt.nombreJoueurs];
    	for (int i=1; i<=witchHunt.nombrePersonne; i++) {
    		joueurs[i-1]=new Personne(i);
    		witchHunt.ajouterUnJoueur(joueurs[i-1]);
    		witchHunt.ajouterUnNuméro(i);
    		System.out.println("\n");
    	}
    	for (int i=witchHunt.nombrePersonne+1; i<=witchHunt.nombreJoueurs; i++) {
    		joueurs[i-1]=new Bot(i);
    		witchHunt.ajouterUnJoueur(joueurs[i-1]);
    		witchHunt.ajouterUnNuméro(i);
    		System.out.println("\n");
    	}
    	witchHunt.numJoueursVie=witchHunt.numJoueursVieSvg;
    	//System.out.println(witchHunt.numJoueursVie);
    	witchHunt.gagnantPartie=8;
    	witchHunt.nombreCartes=JeuCartes.nombreCarteParJoueur(witchHunt.nombreJoueurs);
    	witchHunt.scoreMax=0;
    	witchHunt.prochainJoueur=0;
    	Manche manche = new Manche();
    	while (witchHunt.gagnantPartie == 8) {
    		manche.nouvelleManche();
    		System.out.println("\n");
    		witchHunt.distribuerCartes(witchHunt.nombreJoueurs); 
    		System.out.println(witchHunt.listJoueurs);
    		witchHunt.joueursVie=witchHunt.nombreJoueurs;
    		witchHunt.JoueursEnVie=witchHunt.listJoueurs;
    		System.out.println("\n");
    		for (int j=0; j<witchHunt.nombreJoueurs; j++) {
    			joueurs[j].choisirCamp(); 
    			joueurs[j].carteRévélée=false;
    			witchHunt.appuyer();
    		}
    		while (witchHunt.joueursVie > 1) {
    			System.out.println(witchHunt.JoueursEnVie);
    			witchHunt.numJoueursEvilEye = witchHunt.numJoueursVie;
    			System.out.println("\n");
    			System.out.println("Voici les cartes qui ont étées défaussées");
    			System.out.println(Joueur.cartesDéfaussées);
    			System.out.println("\n");
    			witchHunt.action=joueurs[witchHunt.prochainJoueur].queFaire(witchHunt.prochainJoueur+1);
    			if (witchHunt.action == 1) {
    				witchHunt.joueurAccusé=joueurs[witchHunt.prochainJoueur].accuser(witchHunt.numJoueursVie, witchHunt.joueursVie);
    				witchHunt.décision=joueurs[witchHunt.joueurAccusé].estAccusé(witchHunt.prochainJoueur);
    				if (witchHunt.décision == 1) {
    					retour=joueurs[witchHunt.prochainJoueur].dévoilerCarte(witchHunt.prochainJoueur, joueurs[witchHunt.joueurAccusé], witchHunt.joueursVie, witchHunt.JoueursEnVie, witchHunt.numJoueursVie);
    					witchHunt.prochainJoueur=retour[0];
    					witchHunt.joueursVie=retour[1];
    				}
    				else {
    					witchHunt.prochainJoueur=joueurs[witchHunt.joueurAccusé].utiliserCarteWitch(witchHunt.joueurAccusé, joueurs[witchHunt.prochainJoueur], witchHunt.nombreJoueurs, witchHunt.numJoueursVie);
    					
    					// ----- Si la carte Evil Eye a été utilisée -----
    					if (joueurs[witchHunt.joueurAccusé].utilisationEvilEye) {
    						
    						// --- Si il y a plus que les deux joueur ---
    						if(witchHunt.numJoueursVie.size()>2) {
        						int i = 0;
        						boolean joueurRetiré = false;
        						while (i<witchHunt.numJoueursEvilEye.size() && !joueurRetiré) {
        							if(witchHunt.joueurAccusé == witchHunt.numJoueursEvilEye.get(i) ) {
        								witchHunt.numJoueursEvilEye.remove(i);
        								joueurRetiré = true;
        							}
        							i++;
        						}
        					}
    						// ---	---
    						witchHunt.joueurAccusé=joueurs[witchHunt.prochainJoueur].accuser(witchHunt.numJoueursEvilEye, witchHunt.joueursVie);
        	    			witchHunt.décision=joueurs[witchHunt.joueurAccusé].estAccusé(witchHunt.prochainJoueur);
        	    			if (witchHunt.décision == 1) {
        	    				retour=joueurs[witchHunt.prochainJoueur].dévoilerCarte(witchHunt.prochainJoueur, joueurs[witchHunt.joueurAccusé], witchHunt.joueursVie, witchHunt.JoueursEnVie, witchHunt.numJoueursVie);
        	    				witchHunt.prochainJoueur=retour[0];
        	    				witchHunt.joueursVie=retour[1];
        	    			}
        	    			else {
        	    					witchHunt.prochainJoueur=joueurs[witchHunt.joueurAccusé].utiliserCarteWitch(witchHunt.joueurAccusé, joueurs[witchHunt.prochainJoueur], witchHunt.nombreJoueurs, witchHunt.numJoueursVie);
        	    			}
    					}
    					// ----- Fin carte evil eye -----
    				}
    			}
    			else {
    				retour=joueurs[witchHunt.prochainJoueur].utiliserCarteHunt(witchHunt.prochainJoueur, witchHunt.nombreJoueurs, witchHunt.JoueursEnVie, witchHunt.joueursVie, witchHunt.numJoueursVie);
    				witchHunt.résultat=retour[2];
    				witchHunt.joueursVie=retour[3];
    				witchHunt.prochainJoueur=retour[0];
    				witchHunt.joueurAccusé=retour[1];
    				if (witchHunt.résultat != -1) {
        				if (witchHunt.résultat == 1) {
        					witchHunt.prochainJoueur=joueurs[witchHunt.prochainJoueur].actionAngryMob(joueurs[witchHunt.joueurAccusé], witchHunt.prochainJoueur);
        				}
        				else if(witchHunt.résultat == 2) {
        					witchHunt.prochainJoueur=joueurs[witchHunt.prochainJoueur].actionHookedNose(joueurs[witchHunt.joueurAccusé]);
        				}
        				else if(witchHunt.résultat == 3) {
        					retour=joueurs[witchHunt.prochainJoueur].actionDuckingStool(joueurs[witchHunt.joueurAccusé], witchHunt.prochainJoueur, witchHunt.JoueursEnVie, witchHunt.joueursVie);
        					witchHunt.prochainJoueur=retour[0];
        					witchHunt.joueursVie=retour[1];
        				}
        				else if(witchHunt.résultat == 4) {
        					
        					// ----- Action d'evil eye -----        					
        					if(witchHunt.numJoueursVie.size()>2) {
        						
        						// --- Si il y a plus que les deux joueur ---
        						int i = 0;
        						boolean joueurRetiré = false;
        						while (i<witchHunt.numJoueursEvilEye.size() && !joueurRetiré) {
        							if(witchHunt.joueurAccusé == witchHunt.numJoueursEvilEye.get(i) ) {
        								witchHunt.numJoueursEvilEye.remove(i);
        								joueurRetiré = true;
        							}
        							i++;
        						}
        						// ---	---
        					}        					
        					witchHunt.joueurAccusé=joueurs[witchHunt.prochainJoueur].accuser(witchHunt.numJoueursEvilEye, witchHunt.joueursVie);
        	    			witchHunt.décision=joueurs[witchHunt.joueurAccusé].estAccusé(witchHunt.prochainJoueur);
        	    			if (witchHunt.décision == 1) {
        	    				retour=joueurs[witchHunt.prochainJoueur].dévoilerCarte(witchHunt.prochainJoueur, joueurs[witchHunt.joueurAccusé], witchHunt.joueursVie, witchHunt.JoueursEnVie, witchHunt.numJoueursVie);
        	    				witchHunt.prochainJoueur=retour[0];
        	    				witchHunt.joueursVie=retour[1];
        	    			}
        	    			else {
        	    					witchHunt.prochainJoueur=joueurs[witchHunt.joueurAccusé].utiliserCarteWitch(witchHunt.joueurAccusé, joueurs[witchHunt.prochainJoueur], witchHunt.nombreJoueurs, witchHunt.numJoueursVie);
        	    			}
        	    			// ----- Fin action evil eye -----
        	    			
        				}
    				}
    			}
    			System.out.println("Il reste " +witchHunt.joueursVie+ " joueurs avec une carte non dévoilée");
    			System.out.println("\n");
    			try {
    				Thread.sleep(2000);
    				} catch (InterruptedException e) {
    				e.printStackTrace();
    				}
    		}   		 
    		for (int i=0; i<witchHunt.nombreJoueurs; i++) {
    			if (joueurs[i].carteRévélée == false ) {
    				witchHunt.prochainJoueur=joueurs[i].numJoueur-1;
    				System.out.println("\n");
    				System.out.println("Le joueur " +joueurs[i].numJoueur+ " a gagné la mache " +manche.numéroManche);
    			}
    		}
    		if (joueurs[witchHunt.prochainJoueur].villageois == true) {
    			joueurs[witchHunt.prochainJoueur].point += 1;
    		}
    		else {
    			joueurs[witchHunt.prochainJoueur].point += 2;
    		}
    		System.out.println(witchHunt.listJoueurs);
    		for (int i=0; i<witchHunt.nombreJoueurs; i++) {
    			if (joueurs[i].point > witchHunt.scoreMax ) {
    				witchHunt.scoreMax = joueurs[i].point;
    				witchHunt.joueurScoreMax=joueurs[i].numJoueur;
    			}
    		}
    		System.out.println("Le score maximum de la manche " +manche.numéroManche+ " est de " +witchHunt.scoreMax+ " atteint par le joueur numéro " +witchHunt.joueurScoreMax);
    		if (witchHunt.scoreMax>=5) {
    			witchHunt.gagnantPartie=witchHunt.joueurScoreMax;
    		}
    		witchHunt.JoueursEnVie.clear();
    		witchHunt.numJoueursVie.clear();
    		for (int i=0; i<witchHunt.nombreJoueurs; i++) {
    			witchHunt.JoueursEnVie.add(joueurs[i]);
    			witchHunt.numJoueursVie.add(joueurs[i].numJoueur);
    			joueurs[i].main.clear();
    			if (joueurs[i].carteJouée!=null) {
    				joueurs[i].carteJouée.clear();
    			}
    			Joueur.cartesDéfaussées.clear();
    		}
    		witchHunt.jeu = new JeuCartes();
    	}
    	System.out.println("\n");
    	System.out.println("La partie est terminée!");
    	System.out.println("Le joueur numéro "+witchHunt.joueurScoreMax+ " a gagné la partie");
    	System.out.println("Félicitation !");
    	System.out.println("Vous pouvez relancer une partie");
    }

  
    /**
     * Cette fonction est un getter nous permettant de récupérer la valeur de joueur.
     * 
     * @return on retourne la valeur de joueur.
     */
	public Joueur getJoueur() {
		return joueur;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de joueur.
     * 
     * @param joueur la valeur que nous voulons définir
     */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de contient.
     * 
     * @return on retourne la valeur de contient.
     */
	public List<Joueur> getContient() {
		return contient;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de contient.
     * 
     * @param contient la valeur que nous voulons définir
     */
	public void setContient(List<Joueur> contient) {
		this.contient = contient;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de nombreJoueurs.
     * 
     * @return on retourne la valeur de nombreJoueurs.
     */
	public int getNombreJoueurs() {
		return nombreJoueurs;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de nombreJoueurs.
     * 
     * @param nombreJoueurs la valeur que nous voulons définir
     */
	public void setNombreJoueurs(int nombreJoueurs) {
		this.nombreJoueurs = nombreJoueurs;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de action.
     * 
     * @return on retourne la valeur de action.
     */
	public int getAction() {
		return action;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de action.
     * 
     * @param action la valeur que nous voulons définir
     */
	public void setAction(int action) {
		this.action = action;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de autreCarte.
     * 
     * @return on retourne la valeur de autreCarte.
     */
	public int getAutreCarte() {
		return autreCarte;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de autreCarte.
     * 
     * @param autreCarte la valeur que nous voulons définir
     */
	public void setAutreCarte(int autreCarte) {
		this.autreCarte = autreCarte;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de retour.
     * 
     * @return on retourne la valeur de retour.
     */
	public static int[] getRetour() {
		return retour;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de retour.
     * 
     * @param retour la valeur que nous voulons définir
     */
	public static void setRetour(int[] retour) {
		Partie.retour = retour;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de résultat.
     * 
     * @return on retourne la valeur de résultat.
     */
	public int getRésultat() {
		return résultat;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de résultat.
     * 
     * @param résultat la valeur que nous voulons définir
     */
	public void setRésultat(int résultat) {
		this.résultat = résultat;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de joueursVie.
     * 
     * @return on retourne la valeur de joueursVie.
     */
	public int getJoueursVie() {
		return joueursVie;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de joueursVie.
     * 
     * @param joueursVie la valeur que nous voulons définir
     */
	public void setJoueursVie(int joueursVie) {
		this.joueursVie = joueursVie;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de prochainJoueur.
     * 
     * @return on retourne la valeur de prochainJoueur.
     */
	public int getProchainJoueur() {
		return prochainJoueur;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de prochainJoueur.
     * 
     * @param prochainJoueur la valeur que nous voulons définir
     */
	public void setProchainJoueur(int prochainJoueur) {
		this.prochainJoueur = prochainJoueur;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de joueurAccusé.
     * 
     * @return on retourne la valeur de joueurAccusé.
     */
	public int getJoueurAccusé() {
		return joueurAccusé;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de joueurAccusé.
     * 
     * @param joueurAccusé la valeur que nous voulons définir
     */
	public void setJoueurAccusé(int joueurAccusé) {
		this.joueurAccusé = joueurAccusé;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de décision.
     * 
     * @return on retourne la valeur de décision.
     */
	public int getDécision() {
		return décision;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de décision.
     * 
     * @param décision la valeur que nous voulons définir
     */
	public void setDécision(int décision) {
		this.décision = décision;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de scoreMax.
     * 
     * @return on retourne la valeur de scoreMax.
     */
	public int getScoreMax() {
		return scoreMax;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de scoreMax.
     * 
     * @param scoreMax la valeur que nous voulons définir
     */
	public void setScoreMax(int scoreMax) {
		this.scoreMax = scoreMax;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de joueurScoreMax.
     * 
     * @return on retourne la valeur de joueurScoreMax.
     */
	public int getJoueurScoreMax() {
		return joueurScoreMax;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de joueurScoreMax.
     * 
     * @param joueurScoreMax la valeur que nous voulons définir
     */
	public void setJoueurScoreMax(int joueurScoreMax) {
		this.joueurScoreMax = joueurScoreMax;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de nombreBot.
     * 
     * @return on retourne la valeur de nombreBot.
     */
	public int getNombreBot() {
		return nombreBot;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de nombreBot.
     * 
     * @param nombreBot la valeur que nous voulons définir
     */
	public void setNombreBot(int nombreBot) {
		this.nombreBot = nombreBot;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de nombrePersonne.
     * 
     * @return on retourne la valeur de nombrePersonne.
     */
	public int getNombrePersonne() {
		return nombrePersonne;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de nombrePersonne.
     * 
     * @param nombrePersonne la valeur que nous voulons définir
     */
	public void setNombrePersonne(int nombrePersonne) {
		this.nombrePersonne = nombrePersonne;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de nombreCartes.
     * 
     * @return on retourne la valeur de nombreCartes.
     */
	public int getNombreCartes() {
		return nombreCartes;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de nombreCartes.
     * 
     * @param nombreCartes la valeur que nous voulons définir
     */
	public void setNombreCartes(int nombreCartes) {
		this.nombreCartes = nombreCartes;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de idPartie.
     * 
     * @return on retourne la valeur de idPartie.
     */
	public static Partie getIdPartie() {
		return idPartie;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de idPartie.
     * 
     * @param idPartie la valeur que nous voulons définir
     */
	public static void setIdPartie(Partie idPartie) {
		Partie.idPartie = idPartie;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de jeu.
     * 
     * @return on retourne la valeur de jeu.
     */
	public JeuCartes getJeu() {
		return jeu;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de jeu.
     * 
     * @param jeu la valeur que nous voulons définir
     */
	public void setJeu(JeuCartes jeu) {
		this.jeu = jeu;
	}
	
	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de listJoueurs.
     * 
     * @return on retourne la valeur de listJoueurs.
     */
	public ArrayList<Joueur> getListJoueurs() {
		return listJoueurs;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de listJoueurs.
     * 
     * @param listJoueurs la valeur que nous voulons définir
     */
	public void setListJoueurs(ArrayList<Joueur> listJoueurs) {
		this.listJoueurs = listJoueurs;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de JoueursEnVie.
     * 
     * @return on retourne la valeur de JoueursEnVie.
     */
	public ArrayList<Joueur> getJoueursEnVie() {
		return JoueursEnVie;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de JoueursEnVie.
     * 
     * @param joueursEnVie la valeur que nous voulons définir
     */
	public void setJoueursEnVie(ArrayList<Joueur> joueursEnVie) {
		JoueursEnVie = joueursEnVie;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de numJoueursVie.
     * 
     * @return on retourne la valeur de numJoueursVie.
     */
	public ArrayList<Integer> getNumJoueursVie() {
		return numJoueursVie;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de numJoueursVie.
     * 
     * @param numJoueursVie la valeur que nous voulons définir
     */
	public void setNumJoueursVie(ArrayList<Integer> numJoueursVie) {
		this.numJoueursVie = numJoueursVie;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de numJoueursVieSvg.
     * 
     * @return on retourne la valeur de numJoueursVieSvg.
     */
	public ArrayList<Integer> getNumJoueursVieSvg() {
		return numJoueursVieSvg;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de numJoueursVieSvg.
     * 
     * @param numJoueursVieSvg la valeur que nous voulons définir
     */
	public void setNumJoueursVieSvg(ArrayList<Integer> numJoueursVieSvg) {
		this.numJoueursVieSvg = numJoueursVieSvg;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de numJoueursEvilEye.
     * 
     * @return on retourne la valeur de numJoueursEvilEye.
     */
	public ArrayList<Integer> getNumJoueursEvilEye() {
		return numJoueursEvilEye;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de numJoueursEvilEye.
     * 
     * @param numJoueursEvilEye la valeur que nous voulons définir
     */
	public void setNumJoueursEvilEye(ArrayList<Integer> numJoueursEvilEye) {
		this.numJoueursEvilEye = numJoueursEvilEye;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de gagnantPartie.
     * 
     * @return on retourne la valeur de gagnantPartie.
     */
	public int getGagnantPartie() {
		return gagnantPartie;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de gagnantPartie.
     * 
     * @param gagnantPartie la valeur que nous voulons définir
     */
	public void setGagnantPartie(int gagnantPartie) {
		this.gagnantPartie = gagnantPartie;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de carteEnTrop.
     * 
     * @return on retourne la valeur de carteEnTrop.
     */
	public JeuCartes getCarteEnTrop() {
		return carteEnTrop;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de carteEnTrop.
     * 
     * @param carteEnTrop la valeur que nous voulons définir
     */
	public void setCarteEnTrop(JeuCartes carteEnTrop) {
		this.carteEnTrop = carteEnTrop;
	}

	/**
     * Cette fonction est un getter nous permettant de récupérer la valeur de manche.
     * 
     * @return on retourne la valeur de manche.
     */
	public Manche getManche() {
		return manche;
	}

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de manche.
     * 
     * @param manche la valeur que nous voulons définir
     */
	public void setManche(Manche manche) {
		this.manche = manche;
	}
	
	

}
