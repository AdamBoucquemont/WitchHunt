package Model;

import java.util.LinkedList;

/**
 * Nous avons ici la classe PointedHat qui donne les actions faites par cette
 * meme carte
 * 
 * 
 * @author Adam
 *
 */

public class PointedHat extends CarteRumeur {

	/**
	 * Cette argument sert e voir si la condition est verifiee ou pas.
	 *
	 */
	private boolean condition;

	/**
	 * Cette methode permet de creer un objet du type PointedHat
	 * Il initialise la condition e false par defaut.
	 * Quand la conditon est sur faux, la carte ne peux pas etre utilisee.
	 *
	 */
	public PointedHat() {
		condition = false;
	}

	/**
	 * Cette methode permet de verifier si la condition est bonne avant d'utiliser
	 * la carte.
	 * La condition est de savoir si une carte e deja etait joue par le joueur. Donc
	 * on regarde la taille du paquet de carte utilise.
	 * Et si c'est egal e 0 la condition n'est pas verifiee.
	 * 
	 * @param carte c'est une liste des cartes deja jouer par le joueur
	 * @return un boolean etant e true si la condition est vrai et fausse sinon
	 *
	 */
	public boolean verifieCondition(LinkedList<Carte> carte) {
		if (carte.size() == 0) {
			System.out.println("La condition n'est pas verifiee!");
			this.condition = false;
		} else {
			System.out.println("La condition est verifiee");
			this.condition = true;
		}
		return condition;
	}

	/**
	 * Cette methode execute la whitch action de la carte PointedHat
	 *
	 */
	public void witchAction() {
		System.out.println("Choisissez une carte rumeur deje jouee que vous soihaitez recuperer. ");
	}

	/**
	 * Cette methode execute la hunt action de la carte PointedHat
	 *
	 */
	public void huntAction() {
		System.out.println("Choisissez une carte rumeur deje jouee que vous soihaitez recuperer. ");
	}

}
