package Model;

/**
 * Nous avons ici la classe TheInquisition qui donne les actions faites par
 * cette meme carte
 * 
 * 
 * @author Adam
 *
 */

public class TheInquisition extends CarteRumeur {

	/**
	 * Cette argument sert a voir si la condition est verifiee ou pas.
	 *
	 */
	private boolean condition;

	/**
	 * Cette methode permet de creer un objet du type The Inquisition
	 * Il initialise la condition e false par defaut.
	 * Quand la conditon est sur faux, la carte ne peux pas etre utilisee.
	 *
	 */
	TheInquisition() {
		condition = false;
	}

	/**
	 * Cette methode permet de verifier si la condition est bonne avant d'utiliser
	 * la carte.
	 * La condition est de savoir si le joueur e etait revelee comme villageois.
	 * On commence par regarder si sa carte a etait revelee.
	 * Puis on regarde si sa carte etait villageois.
	 * Si les deux conditions sont e true on met la condition e true et il peut
	 * jouer sa carte.
	 * 
	 * @param b1 c'est un boolean etant e vrai si la carte rele a etait revelee
	 * @param b2 c'est un boolean etant e vrai si le rele est villageoins
	 * @return un boolean etant e true si la condition est vrai et fausse sinon
	 *
	 */
	public boolean verifieCondition(boolean b1, boolean b2) {
		if (b1 == true && b2 == true) {
			System.out.println("La condition est verifiee!");
			this.condition = true;
		} else {
			System.out.println("La condition n'est pas verifiee");
		}
		return condition;
	}

	/**
	 * Cette methode execute la whitch action de la carte theInquisition
	 *
	 */
	public void witchAction() {
		System.out.println("Vous devez vous debarasser d'une carte, laquelle choisissez vous? Rentrez un numero");
	}

	/**
	 * Cette methode execute la whitch action de la carte the Inquisition
	 *
	 * @return un entier correspondant au numero du prochain joueur.
	 */
	public int huntAction() {
		int i = 0;
		return i;
	}
}
