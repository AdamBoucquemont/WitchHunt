package Model;

import java.util.LinkedList;


/**
 * Nous avons ici la classe PointedHat qui donne les actions faites par cette m�me carte
 * 
 * 
 * @author Adam
 *
 */

public class PointedHat extends CarteRumeur {
	
	/**
	 * Cette argument sert � voir si la condition est v�rifi�e ou pas.
	 *
	 */
	private boolean condition;
	
	/**
	 * Cette m�thode permet de cr�er un objet du type PointedHat
	 * Il initialise la condition � false par d�faut.
	 * Quand la conditon est sur faux, la carte ne peux pas �tre utilis�e.
	 *
	 */
	public PointedHat() {
		condition=false;
	}
	
	/**
	 * Cette m�thode permet de v�rifier si la condition est bonne avant d'utiliser la carte.
	 * La condition est de savoir si une carte � d�ja �tait jou� par le joueur. Donc on regarde la taille du paquet de carte utilis�.
	 * Et si c'est �gal � 0 la condition n'est pas v�rifi�e.
	 * 
	 * @param carte c'est une liste des cartes d�ja jouer par le joueur
	 * @return un boolean �tant � true si la condition est vrai et fausse sinon
	 *
	 */
    public boolean v�rifieCondition(LinkedList<Carte> carte) {
		if (carte.size() == 0) {
			System.out.println("La condition n'est pas v�rifi�e!");
			this.condition=false;
		}
		else {
			System.out.println("La condition est v�rifi�e");
			this.condition=true;
		}
		return condition;    	
    }

	/**
	 * Cette m�thode ex�cute la whitch action de la carte PointedHat
	 *
	 */
    public void witchAction() {
    	System.out.println("Choisissez une carte rumeur d�j� jou�e que vous soihaitez r�cup�rer. ");
    }

	/**
	 * Cette m�thode ex�cute la hunt action de la carte PointedHat
	 *
	 */
    public void huntAction() {
    	System.out.println("Choisissez une carte rumeur d�j� jou�e que vous soihaitez r�cup�rer. ");
    }

}
