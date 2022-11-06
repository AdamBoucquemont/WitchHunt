package Model;

import java.util.*;

/**
 * Dans la classe partie nous avons le coeur du code de notre projet.
 * En effet c'est dans cette classe qu'est pr�sent la m�thode main qui fait le d�roulement de jeu.
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
	 * Cette variable d�signe une action
	 */
	private int action;
	
	/**
	 * Cette variable est le num�ro d'une autre carte
	 */
	private int autreCarte;
	
	/**
	 * Cette variable est un tableau contenant tous les retours d'une fonction
	 */
	private static int [] retour;
	
	/**
	 * Cette variable est le r�sultat d'une action
	 */
	private int r�sultat;
	
	/**
	 * Cette variable est le nombre de joueur encore en vie 
	 */
	private int joueursVie;
	
	/**
	 * Cette variable est le num�ro du prochain joueur 
	 */
	private int prochainJoueur;
	
	/**
	 * Cette variable est le num�ro d'un joueur accus�
	 */
	private int joueurAccus�;
	
	/**
	 * Cette variable est une r�f�rence � la d�cision que doit prendre un joueur
	 */
	private int d�cision;
	
	/**
	 * Cette variable est le meilleur score atteint
	 */
	private int scoreMax;
	
	/**
	 * Cette variable est un num�ro de jouer qui a atteint le meilleur score
	 */
	private int joueurScoreMax;
	
	/**
	 * Cette variable est le nombre de bot jouant � la partie
	 */
	private int nombreBot;
	
	/**
	 * Cette variable est le nombre de personne jouant � la partie
	 */
	private int nombrePersonne;
	
	/**
	 * Cette variable contient le nombre de cartes
	 */
	private int nombreCartes;
	
	/**
	 * Cette variable est un appel � une nouvelle partie 
	 */
	private static Partie idPartie = null;
	
	/**
	 * Cette variable est un appel � un nouveau jeu de carte
	 */
    private JeuCartes jeu;
    
    /**
	 * Cette variable est la liste de tous les joueurs 
	 */
    private ArrayList<Joueur> listJoueurs; 
    
    /**
	 * Cette variable est une liste des joueurs avec une carte non dvoil�e
	 */
    private ArrayList<Joueur> JoueursEnVie;
    
    /**
	 * Cette variable est une liste des num�ros des joueurs
	 */
    private ArrayList<Integer> numJoueursVie= new ArrayList<Integer>();
    
    /**
	 * Cette variableest une liste des num�ros des joueurs
	 */
    private ArrayList<Integer> numJoueursVieSvg= new ArrayList<Integer>();
    
    /**
	 * Cette variable est une liste des num�ros des joueurs
	 */
    private ArrayList<Integer> numJoueursEvilEye= new ArrayList<Integer>();
    
    /**
	 * Cette variable d�signe, part son num�ro, le joueur gagnant
	 */
    private int gagnantPartie;
    
    /**
	 * Cette variable est un appel � un jeu de carte
	 */
    private JeuCartes carteEnTrop;
    
    /**
	 * Cette variable est un appel � un objet joueur
	 */
	private Joueur joueur;
	
	/**
	 * Cette variable contient un appel � un objet manche
	 */
	private Manche manche;


	/**
	 * Cette variable est une liste de joueurs qui vont prendre part � la partie
	 */
    public List<Joueur> contient = new ArrayList<Joueur> ();

    /**
	 * Cette m�thode permet de cr�er une nouvelle partie
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
	 * Cette m�thode est le contructeur de la partie
	 * De base tous les joueurs sont � 0, il y a 12 cartes et on cr�� une liste de joueurs et de cartes.
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
	 * Cette m�thode permet de rentrer le nombre de joueurs 
	 * 
	 * @throws InputMismatchException cette exception est lev�e, elle enl�ve la possibilit� de mettre des lettres au lieux d'entier.
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
    				System.out.println("Le nombre de joueur renseign� n'est pas possible, veuillez renseigner un nouveau nombre de joueur en 3 et 6.");
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
	 * Cette m�thode permet de rentrer le nombre de personnes
	 * 
	 * @param n c'est le nombre de joueurs, ainsi on ne peut pas rentrer un nombre de personne sup�rieur au nombre de joueurs
	 * @throws InputMismatchException cette exception est lev�e, elle enl�ve la possibilit� de mettre des lettres au lieux d'entier.
	 * @return un entier correspondant au nombre de personnes (entre 0 et le nombre de joueurs)
	 */
    public int rentreNombrePersonne(int n) throws InputMismatchException{
    	int m=0;
    	boolean erreur;
    	do {
    		erreur = false;
    		try {
    			Scanner reader = new Scanner(System.in);
    			System.out.println("Combien de personne vont jouer � la partie ? Vous pouvez choisir au maximum " + n + " joueurs");
    			m = reader.nextInt();
    	    	while (m<0 || m>n) {
    	    		System.out.println("Le nombre de personne renseign� n'est pas possible, veuillez renseigner un nouveau nombre de joueur en 0 et " + n);
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
	 * Cette m�thode permet de calculer le nombre bots
	 * 
	 * @param n c'est le nombre de joueurs, 
	 * @param m c'est le nombre personnes
	 * @return un entier correspondant au nombre de bot (diff�rence entre le nombre de joueurs et le nombre de bots)
	 */
    public int calculNombreBot(int n, int m) {
    	return n - m;
    }
    
    /**
	 * Cette m�thode permet de distribuer des cartes � chaque joueurs.
	 * Si le compte n'est pas ronds, les cartes restantes seront laiss�es au milieu.
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
	 * Cette m�thode permet de faire passer une action en rentrant n'importe quel caract�re
	 */
	public void appuyer() {
		Scanner reader = new Scanner(System.in);
    	System.out.println("Rentrez un caract�re pour continuer");
    	String m = reader.nextLine();
    	System.out.println("\n");
	}
	
	/**
	 * Cette m�thode permet d'ajouter un joueur � la liste des joueurs
	 * 
	 * @param joueur c'est le joueur � ajouter
	 */
	public void ajouterUnJoueur(Joueur joueur){ 
		listJoueurs.add(joueur);
	} 
	
	/**
	 * Cette m�thode permet d'ajouter un num�ro
	 * 
	 * @param i c'est le num�ro � ajouter � la liste
	 */
	public void ajouterUnNum�ro(int i){ 
		numJoueursVieSvg.add(i);
	}
	
	/**
	 * Cette m�thode est la m�thode principal du projet, c'est elle qui fait se d�rouler toute la partie.
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
    		witchHunt.ajouterUnNum�ro(i);
    		System.out.println("\n");
    	}
    	for (int i=witchHunt.nombrePersonne+1; i<=witchHunt.nombreJoueurs; i++) {
    		joueurs[i-1]=new Bot(i);
    		witchHunt.ajouterUnJoueur(joueurs[i-1]);
    		witchHunt.ajouterUnNum�ro(i);
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
    			joueurs[j].carteR�v�l�e=false;
    			witchHunt.appuyer();
    		}
    		while (witchHunt.joueursVie > 1) {
    			System.out.println(witchHunt.JoueursEnVie);
    			witchHunt.numJoueursEvilEye = witchHunt.numJoueursVie;
    			System.out.println("\n");
    			System.out.println("Voici les cartes qui ont �t�es d�fauss�es");
    			System.out.println(Joueur.cartesD�fauss�es);
    			System.out.println("\n");
    			witchHunt.action=joueurs[witchHunt.prochainJoueur].queFaire(witchHunt.prochainJoueur+1);
    			if (witchHunt.action == 1) {
    				witchHunt.joueurAccus�=joueurs[witchHunt.prochainJoueur].accuser(witchHunt.numJoueursVie, witchHunt.joueursVie);
    				witchHunt.d�cision=joueurs[witchHunt.joueurAccus�].estAccus�(witchHunt.prochainJoueur);
    				if (witchHunt.d�cision == 1) {
    					retour=joueurs[witchHunt.prochainJoueur].d�voilerCarte(witchHunt.prochainJoueur, joueurs[witchHunt.joueurAccus�], witchHunt.joueursVie, witchHunt.JoueursEnVie, witchHunt.numJoueursVie);
    					witchHunt.prochainJoueur=retour[0];
    					witchHunt.joueursVie=retour[1];
    				}
    				else {
    					witchHunt.prochainJoueur=joueurs[witchHunt.joueurAccus�].utiliserCarteWitch(witchHunt.joueurAccus�, joueurs[witchHunt.prochainJoueur], witchHunt.nombreJoueurs, witchHunt.numJoueursVie);
    					
    					// ----- Si la carte Evil Eye a �t� utilis�e -----
    					if (joueurs[witchHunt.joueurAccus�].utilisationEvilEye) {
    						
    						// --- Si il y a plus que les deux joueur ---
    						if(witchHunt.numJoueursVie.size()>2) {
        						int i = 0;
        						boolean joueurRetir� = false;
        						while (i<witchHunt.numJoueursEvilEye.size() && !joueurRetir�) {
        							if(witchHunt.joueurAccus� == witchHunt.numJoueursEvilEye.get(i) ) {
        								witchHunt.numJoueursEvilEye.remove(i);
        								joueurRetir� = true;
        							}
        							i++;
        						}
        					}
    						// ---	---
    						witchHunt.joueurAccus�=joueurs[witchHunt.prochainJoueur].accuser(witchHunt.numJoueursEvilEye, witchHunt.joueursVie);
        	    			witchHunt.d�cision=joueurs[witchHunt.joueurAccus�].estAccus�(witchHunt.prochainJoueur);
        	    			if (witchHunt.d�cision == 1) {
        	    				retour=joueurs[witchHunt.prochainJoueur].d�voilerCarte(witchHunt.prochainJoueur, joueurs[witchHunt.joueurAccus�], witchHunt.joueursVie, witchHunt.JoueursEnVie, witchHunt.numJoueursVie);
        	    				witchHunt.prochainJoueur=retour[0];
        	    				witchHunt.joueursVie=retour[1];
        	    			}
        	    			else {
        	    					witchHunt.prochainJoueur=joueurs[witchHunt.joueurAccus�].utiliserCarteWitch(witchHunt.joueurAccus�, joueurs[witchHunt.prochainJoueur], witchHunt.nombreJoueurs, witchHunt.numJoueursVie);
        	    			}
    					}
    					// ----- Fin carte evil eye -----
    				}
    			}
    			else {
    				retour=joueurs[witchHunt.prochainJoueur].utiliserCarteHunt(witchHunt.prochainJoueur, witchHunt.nombreJoueurs, witchHunt.JoueursEnVie, witchHunt.joueursVie, witchHunt.numJoueursVie);
    				witchHunt.r�sultat=retour[2];
    				witchHunt.joueursVie=retour[3];
    				witchHunt.prochainJoueur=retour[0];
    				witchHunt.joueurAccus�=retour[1];
    				if (witchHunt.r�sultat != -1) {
        				if (witchHunt.r�sultat == 1) {
        					witchHunt.prochainJoueur=joueurs[witchHunt.prochainJoueur].actionAngryMob(joueurs[witchHunt.joueurAccus�], witchHunt.prochainJoueur);
        				}
        				else if(witchHunt.r�sultat == 2) {
        					witchHunt.prochainJoueur=joueurs[witchHunt.prochainJoueur].actionHookedNose(joueurs[witchHunt.joueurAccus�]);
        				}
        				else if(witchHunt.r�sultat == 3) {
        					retour=joueurs[witchHunt.prochainJoueur].actionDuckingStool(joueurs[witchHunt.joueurAccus�], witchHunt.prochainJoueur, witchHunt.JoueursEnVie, witchHunt.joueursVie);
        					witchHunt.prochainJoueur=retour[0];
        					witchHunt.joueursVie=retour[1];
        				}
        				else if(witchHunt.r�sultat == 4) {
        					
        					// ----- Action d'evil eye -----        					
        					if(witchHunt.numJoueursVie.size()>2) {
        						
        						// --- Si il y a plus que les deux joueur ---
        						int i = 0;
        						boolean joueurRetir� = false;
        						while (i<witchHunt.numJoueursEvilEye.size() && !joueurRetir�) {
        							if(witchHunt.joueurAccus� == witchHunt.numJoueursEvilEye.get(i) ) {
        								witchHunt.numJoueursEvilEye.remove(i);
        								joueurRetir� = true;
        							}
        							i++;
        						}
        						// ---	---
        					}        					
        					witchHunt.joueurAccus�=joueurs[witchHunt.prochainJoueur].accuser(witchHunt.numJoueursEvilEye, witchHunt.joueursVie);
        	    			witchHunt.d�cision=joueurs[witchHunt.joueurAccus�].estAccus�(witchHunt.prochainJoueur);
        	    			if (witchHunt.d�cision == 1) {
        	    				retour=joueurs[witchHunt.prochainJoueur].d�voilerCarte(witchHunt.prochainJoueur, joueurs[witchHunt.joueurAccus�], witchHunt.joueursVie, witchHunt.JoueursEnVie, witchHunt.numJoueursVie);
        	    				witchHunt.prochainJoueur=retour[0];
        	    				witchHunt.joueursVie=retour[1];
        	    			}
        	    			else {
        	    					witchHunt.prochainJoueur=joueurs[witchHunt.joueurAccus�].utiliserCarteWitch(witchHunt.joueurAccus�, joueurs[witchHunt.prochainJoueur], witchHunt.nombreJoueurs, witchHunt.numJoueursVie);
        	    			}
        	    			// ----- Fin action evil eye -----
        	    			
        				}
    				}
    			}
    			System.out.println("Il reste " +witchHunt.joueursVie+ " joueurs avec une carte non d�voil�e");
    			System.out.println("\n");
    			try {
    				Thread.sleep(2000);
    				} catch (InterruptedException e) {
    				e.printStackTrace();
    				}
    		}   		 
    		for (int i=0; i<witchHunt.nombreJoueurs; i++) {
    			if (joueurs[i].carteR�v�l�e == false ) {
    				witchHunt.prochainJoueur=joueurs[i].numJoueur-1;
    				System.out.println("\n");
    				System.out.println("Le joueur " +joueurs[i].numJoueur+ " a gagn� la mache " +manche.num�roManche);
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
    		System.out.println("Le score maximum de la manche " +manche.num�roManche+ " est de " +witchHunt.scoreMax+ " atteint par le joueur num�ro " +witchHunt.joueurScoreMax);
    		if (witchHunt.scoreMax>=5) {
    			witchHunt.gagnantPartie=witchHunt.joueurScoreMax;
    		}
    		witchHunt.JoueursEnVie.clear();
    		witchHunt.numJoueursVie.clear();
    		for (int i=0; i<witchHunt.nombreJoueurs; i++) {
    			witchHunt.JoueursEnVie.add(joueurs[i]);
    			witchHunt.numJoueursVie.add(joueurs[i].numJoueur);
    			joueurs[i].main.clear();
    			if (joueurs[i].carteJou�e!=null) {
    				joueurs[i].carteJou�e.clear();
    			}
    			Joueur.cartesD�fauss�es.clear();
    		}
    		witchHunt.jeu = new JeuCartes();
    	}
    	System.out.println("\n");
    	System.out.println("La partie est termin�e!");
    	System.out.println("Le joueur num�ro "+witchHunt.joueurScoreMax+ " a gagn� la partie");
    	System.out.println("F�licitation !");
    	System.out.println("Vous pouvez relancer une partie");
    }

  
    /**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de joueur.
     * 
     * @return on retourne la valeur de joueur.
     */
	public Joueur getJoueur() {
		return joueur;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de joueur.
     * 
     * @param joueur la valeur que nous voulons d�finir
     */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de contient.
     * 
     * @return on retourne la valeur de contient.
     */
	public List<Joueur> getContient() {
		return contient;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de contient.
     * 
     * @param contient la valeur que nous voulons d�finir
     */
	public void setContient(List<Joueur> contient) {
		this.contient = contient;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de nombreJoueurs.
     * 
     * @return on retourne la valeur de nombreJoueurs.
     */
	public int getNombreJoueurs() {
		return nombreJoueurs;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de nombreJoueurs.
     * 
     * @param nombreJoueurs la valeur que nous voulons d�finir
     */
	public void setNombreJoueurs(int nombreJoueurs) {
		this.nombreJoueurs = nombreJoueurs;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de action.
     * 
     * @return on retourne la valeur de action.
     */
	public int getAction() {
		return action;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de action.
     * 
     * @param action la valeur que nous voulons d�finir
     */
	public void setAction(int action) {
		this.action = action;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de autreCarte.
     * 
     * @return on retourne la valeur de autreCarte.
     */
	public int getAutreCarte() {
		return autreCarte;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de autreCarte.
     * 
     * @param autreCarte la valeur que nous voulons d�finir
     */
	public void setAutreCarte(int autreCarte) {
		this.autreCarte = autreCarte;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de retour.
     * 
     * @return on retourne la valeur de retour.
     */
	public static int[] getRetour() {
		return retour;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de retour.
     * 
     * @param retour la valeur que nous voulons d�finir
     */
	public static void setRetour(int[] retour) {
		Partie.retour = retour;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de r�sultat.
     * 
     * @return on retourne la valeur de r�sultat.
     */
	public int getR�sultat() {
		return r�sultat;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de r�sultat.
     * 
     * @param r�sultat la valeur que nous voulons d�finir
     */
	public void setR�sultat(int r�sultat) {
		this.r�sultat = r�sultat;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de joueursVie.
     * 
     * @return on retourne la valeur de joueursVie.
     */
	public int getJoueursVie() {
		return joueursVie;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de joueursVie.
     * 
     * @param joueursVie la valeur que nous voulons d�finir
     */
	public void setJoueursVie(int joueursVie) {
		this.joueursVie = joueursVie;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de prochainJoueur.
     * 
     * @return on retourne la valeur de prochainJoueur.
     */
	public int getProchainJoueur() {
		return prochainJoueur;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de prochainJoueur.
     * 
     * @param prochainJoueur la valeur que nous voulons d�finir
     */
	public void setProchainJoueur(int prochainJoueur) {
		this.prochainJoueur = prochainJoueur;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de joueurAccus�.
     * 
     * @return on retourne la valeur de joueurAccus�.
     */
	public int getJoueurAccus�() {
		return joueurAccus�;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de joueurAccus�.
     * 
     * @param joueurAccus� la valeur que nous voulons d�finir
     */
	public void setJoueurAccus�(int joueurAccus�) {
		this.joueurAccus� = joueurAccus�;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de d�cision.
     * 
     * @return on retourne la valeur de d�cision.
     */
	public int getD�cision() {
		return d�cision;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de d�cision.
     * 
     * @param d�cision la valeur que nous voulons d�finir
     */
	public void setD�cision(int d�cision) {
		this.d�cision = d�cision;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de scoreMax.
     * 
     * @return on retourne la valeur de scoreMax.
     */
	public int getScoreMax() {
		return scoreMax;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de scoreMax.
     * 
     * @param scoreMax la valeur que nous voulons d�finir
     */
	public void setScoreMax(int scoreMax) {
		this.scoreMax = scoreMax;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de joueurScoreMax.
     * 
     * @return on retourne la valeur de joueurScoreMax.
     */
	public int getJoueurScoreMax() {
		return joueurScoreMax;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de joueurScoreMax.
     * 
     * @param joueurScoreMax la valeur que nous voulons d�finir
     */
	public void setJoueurScoreMax(int joueurScoreMax) {
		this.joueurScoreMax = joueurScoreMax;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de nombreBot.
     * 
     * @return on retourne la valeur de nombreBot.
     */
	public int getNombreBot() {
		return nombreBot;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de nombreBot.
     * 
     * @param nombreBot la valeur que nous voulons d�finir
     */
	public void setNombreBot(int nombreBot) {
		this.nombreBot = nombreBot;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de nombrePersonne.
     * 
     * @return on retourne la valeur de nombrePersonne.
     */
	public int getNombrePersonne() {
		return nombrePersonne;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de nombrePersonne.
     * 
     * @param nombrePersonne la valeur que nous voulons d�finir
     */
	public void setNombrePersonne(int nombrePersonne) {
		this.nombrePersonne = nombrePersonne;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de nombreCartes.
     * 
     * @return on retourne la valeur de nombreCartes.
     */
	public int getNombreCartes() {
		return nombreCartes;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de nombreCartes.
     * 
     * @param nombreCartes la valeur que nous voulons d�finir
     */
	public void setNombreCartes(int nombreCartes) {
		this.nombreCartes = nombreCartes;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de idPartie.
     * 
     * @return on retourne la valeur de idPartie.
     */
	public static Partie getIdPartie() {
		return idPartie;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de idPartie.
     * 
     * @param idPartie la valeur que nous voulons d�finir
     */
	public static void setIdPartie(Partie idPartie) {
		Partie.idPartie = idPartie;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de jeu.
     * 
     * @return on retourne la valeur de jeu.
     */
	public JeuCartes getJeu() {
		return jeu;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de jeu.
     * 
     * @param jeu la valeur que nous voulons d�finir
     */
	public void setJeu(JeuCartes jeu) {
		this.jeu = jeu;
	}
	
	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de listJoueurs.
     * 
     * @return on retourne la valeur de listJoueurs.
     */
	public ArrayList<Joueur> getListJoueurs() {
		return listJoueurs;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de listJoueurs.
     * 
     * @param listJoueurs la valeur que nous voulons d�finir
     */
	public void setListJoueurs(ArrayList<Joueur> listJoueurs) {
		this.listJoueurs = listJoueurs;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de JoueursEnVie.
     * 
     * @return on retourne la valeur de JoueursEnVie.
     */
	public ArrayList<Joueur> getJoueursEnVie() {
		return JoueursEnVie;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de JoueursEnVie.
     * 
     * @param joueursEnVie la valeur que nous voulons d�finir
     */
	public void setJoueursEnVie(ArrayList<Joueur> joueursEnVie) {
		JoueursEnVie = joueursEnVie;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de numJoueursVie.
     * 
     * @return on retourne la valeur de numJoueursVie.
     */
	public ArrayList<Integer> getNumJoueursVie() {
		return numJoueursVie;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de numJoueursVie.
     * 
     * @param numJoueursVie la valeur que nous voulons d�finir
     */
	public void setNumJoueursVie(ArrayList<Integer> numJoueursVie) {
		this.numJoueursVie = numJoueursVie;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de numJoueursVieSvg.
     * 
     * @return on retourne la valeur de numJoueursVieSvg.
     */
	public ArrayList<Integer> getNumJoueursVieSvg() {
		return numJoueursVieSvg;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de numJoueursVieSvg.
     * 
     * @param numJoueursVieSvg la valeur que nous voulons d�finir
     */
	public void setNumJoueursVieSvg(ArrayList<Integer> numJoueursVieSvg) {
		this.numJoueursVieSvg = numJoueursVieSvg;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de numJoueursEvilEye.
     * 
     * @return on retourne la valeur de numJoueursEvilEye.
     */
	public ArrayList<Integer> getNumJoueursEvilEye() {
		return numJoueursEvilEye;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de numJoueursEvilEye.
     * 
     * @param numJoueursEvilEye la valeur que nous voulons d�finir
     */
	public void setNumJoueursEvilEye(ArrayList<Integer> numJoueursEvilEye) {
		this.numJoueursEvilEye = numJoueursEvilEye;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de gagnantPartie.
     * 
     * @return on retourne la valeur de gagnantPartie.
     */
	public int getGagnantPartie() {
		return gagnantPartie;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de gagnantPartie.
     * 
     * @param gagnantPartie la valeur que nous voulons d�finir
     */
	public void setGagnantPartie(int gagnantPartie) {
		this.gagnantPartie = gagnantPartie;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de carteEnTrop.
     * 
     * @return on retourne la valeur de carteEnTrop.
     */
	public JeuCartes getCarteEnTrop() {
		return carteEnTrop;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de carteEnTrop.
     * 
     * @param carteEnTrop la valeur que nous voulons d�finir
     */
	public void setCarteEnTrop(JeuCartes carteEnTrop) {
		this.carteEnTrop = carteEnTrop;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de manche.
     * 
     * @return on retourne la valeur de manche.
     */
	public Manche getManche() {
		return manche;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de manche.
     * 
     * @param manche la valeur que nous voulons d�finir
     */
	public void setManche(Manche manche) {
		this.manche = manche;
	}
	
	

}
