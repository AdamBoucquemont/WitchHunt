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
	* Cet attribut est un tas pposs�dant toute les cartes du jeu
    */
	private LinkedList<Carte> tasCartes;
	
	/**
	* Cet attribut est une carte de classe carte
    */
	private Carte carte;

	/**
	* Cette m�thode permet de cr�er un jeu de carte avec toutes les cartes � l'int�rieur
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
	* Cette m�thode permet de distribuer une carte 
	* 
	* @return le r�sultat est un jeu de carte � laquelle une carte s'est ajout�e
    */
	public Carte distribuerUneCarte(){  
		return tasCartes.poll(); 
	} 
  
	/**
	* Cette m�thode permet de m�langer un jeu de carte
    */
	public void melanger(){ 
		Collections.shuffle(tasCartes); 
	} 
 
	/**
	* Cette m�thode permet de voir si un jeu de carte est vide ou pas
	* 
	* @return un boolean ayant pour valeur true si le jeu est vide et false sinon
    */
	public boolean estVide() { 
		return tasCartes.isEmpty(); 
	} 
  
	/**
	* Cette m�thode permet d'afficher un jeu de carte
	* 
	* @return le r�sultat est la liste de toutes les cartes pr�sentent dans le jeu
    */
	public String toString(){ 
		return tasCartes.toString(); 
	} 
 
	/**
	* Cette m�thode est un getter pour r�cuperer la valeur du tas de cartes
	* 
	* @return la valeur de tasCartes
    */
	public LinkedList<Carte> getTasCartes(){ 
		return tasCartes; 
	} 
	
	/**
	* Cette m�thode permet de calculer le nombre de cartes qu'aura chaque joueurs 
	* 
	* @param n un entier symbolisant le nombre de joueurs
	* @return un entier repr�sentant le nombre de carte qu'aura chaque personnes
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

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de tasCartes.
     * 
     * @param tasCartes la valeur que nous voulons d�finir
     */
	public void setTasCartes(LinkedList<Carte> tasCartes) {
		this.tasCartes = tasCartes;
	}
    
    
    
}