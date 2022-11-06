package Model;

import java.util.LinkedList;


/**
 * Nous avons ici la classe PointedHat qui donne les actions faites par cette même carte
 * 
 * 
 * @author Adam
 *
 */

public class PointedHat extends CarteRumeur {
	
	/**
	 * Cette argument sert à voir si la condition est vérifiée ou pas.
	 *
	 */
	private boolean condition;
	
	/**
	 * Cette méthode permet de créer un objet du type PointedHat
	 * Il initialise la condition à false par défaut.
	 * Quand la conditon est sur faux, la carte ne peux pas être utilisée.
	 *
	 */
	public PointedHat() {
		condition=false;
	}
	
	/**
	 * Cette méthode permet de vérifier si la condition est bonne avant d'utiliser la carte.
	 * La condition est de savoir si une carte à déja était joué par le joueur. Donc on regarde la taille du paquet de carte utilisé.
	 * Et si c'est égal à 0 la condition n'est pas vérifiée.
	 * 
	 * @param carte c'est une liste des cartes déja jouer par le joueur
	 * @return un boolean étant à true si la condition est vrai et fausse sinon
	 *
	 */
    public boolean vérifieCondition(LinkedList<Carte> carte) {
		if (carte.size() == 0) {
			System.out.println("La condition n'est pas vérifiée!");
			this.condition=false;
		}
		else {
			System.out.println("La condition est vérifiée");
			this.condition=true;
		}
		return condition;    	
    }

	/**
	 * Cette méthode exécute la whitch action de la carte PointedHat
	 *
	 */
    public void witchAction() {
    	System.out.println("Choisissez une carte rumeur déjà jouée que vous soihaitez récupérer. ");
    }

	/**
	 * Cette méthode exécute la hunt action de la carte PointedHat
	 *
	 */
    public void huntAction() {
    	System.out.println("Choisissez une carte rumeur déjà jouée que vous soihaitez récupérer. ");
    }

}
