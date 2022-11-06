package Model;

import java.util.*;

/**
 * Dans la classe JeuCartes nous avons tout ce qui est relatif au jeu de carte qui est une liste de plusieurs cartes
 * 
 * 
 * @author Adam 
 *
 */

public class JeuCartes { 
  
	/**
	* Cet attribut est un tas ppossédant toute les cartes du jeu
    */
	private LinkedList<Carte> tasCartes;
	
	/**
	* Cet attribut est une carte de classe carte
    */
	private Carte carte;

	/**
	* Cette méthode permet de créer un jeu de carte avec toutes les cartes à l'intérieur
    */
	public JeuCartes(){ 
		tasCartes = new LinkedList<Carte>();
		Carte[] cartes = new Carte[12];
		CarteRumeurEnum[] c=CarteRumeurEnum.values(); 
		for (int i=0; i<12;i++) {
			carte = new Carte(c[i]);
			cartes[i]=carte;
		tasCartes.add(carte); 
		}
	}
  
	/**
	* Cette méthode permet de distribuer une carte 
	* 
	* @return le résultat est un jeu de carte à laquelle une carte s'est ajoutée
    */
	public Carte distribuerUneCarte(){  
		return tasCartes.poll(); 
	} 
  
	/**
	* Cette méthode permet de mélanger un jeu de carte
    */
	public void melanger(){ 
		Collections.shuffle(tasCartes); 
	} 
 
	/**
	* Cette méthode permet de voir si un jeu de carte est vide ou pas
	* 
	* @return un boolean ayant pour valeur true si le jeu est vide et false sinon
    */
	public boolean estVide() { 
		return tasCartes.isEmpty(); 
	} 
  
	/**
	* Cette méthode permet d'afficher un jeu de carte
	* 
	* @return le résultat est la liste de toutes les cartes présentent dans le jeu
    */
	public String toString(){ 
		return tasCartes.toString(); 
	} 
 
	/**
	* Cette méthode est un getter pour récuperer la valeur du tas de cartes
	* 
	* @return la valeur de tasCartes
    */
	public LinkedList<Carte> getTasCartes(){ 
		return tasCartes; 
	} 
	
	/**
	* Cette méthode permet de calculer le nombre de cartes qu'aura chaque joueurs 
	* 
	* @param n un entier symbolisant le nombre de joueurs
	* @return un entier représentant le nombre de carte qu'aura chaque personnes
    */
    public static int nombreCarteParJoueur(int n) {
    	int m = 0;
    	if (n == 3) {
    		m=4;
    	}
    	else if (n == 4) {
    		m=3;
    	}
    	else if (n == 5 || n == 6) {
    		m=2;
    	}
    	System.out.println("Chaque joueur aura " +m+" carte rumeurs par manche.");
    	return m;
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

	/**
     * Cette fonction est le setter nous permettant de définir la valeur de tasCartes.
     * 
     * @param tasCartes la valeur que nous voulons définir
     */
	public void setTasCartes(LinkedList<Carte> tasCartes) {
		this.tasCartes = tasCartes;
	}
    
    
    
}