package Model;


/**
 * Nous avons ici la classe TheInquisition qui donne les actions faites par cette même carte
 * 
 * 
 * @author Adam
 *
 */

public class TheInquisition extends CarteRumeur {
	
	/**
	 * Cette argument sert à voir si la condition est vérifiée ou pas.
	 *
	 */
	private boolean condition;

	/**
	 * Cette méthode permet de créer un objet du type The Inquisition
	 * Il initialise la condition à false par défaut.
	 * Quand la conditon est sur faux, la carte ne peux pas être utilisée.
	 *
	 */
	TheInquisition() {
		condition=false;
	}
	
	/**
	 * Cette méthode permet de vérifier si la condition est bonne avant d'utiliser la carte.
	 * La condition est de savoir si le joueur à était révélée comme villageois.
	 * On commence par regarder si sa carte a était révélée.
	 * Puis on regarde si sa carte était villageois.
	 * Si les deux conditions sont à true on met la condition à true et il peut jouer sa carte.
	 * 
	 * @param b1 c'est un boolean étant à vrai si la carte rôle a était révélée
	 * @param b2 c'est un boolean  étant à vrai si le rôle est villageoins
	 * @return un boolean étant à true si la condition est vrai et fausse sinon
	 *
	 */
	public boolean vérifieCondition(boolean b1, boolean b2) {
		if (b1 == true && b2 == true) {
			System.out.println("La condition est vérifiée!");
			this.condition=true;
		}
		else {
			System.out.println("La condition n'est pas vérifiée");
		}
		return condition;
	}

	/**
	 * Cette méthode exécute la whitch action de la carte theInquisition
	 *
	 */
    public void witchAction() {
    	System.out.println("Vous devez vous débarasser d'une carte, laquelle choisissez vous? Rentrez un numéro");
    }

	/**
	 * Cette méthode exécute la whitch action de la carte the Inquisition
	 *
	 *@return un entier correspondant au numéro du prochain joueur.
	 */
    public int huntAction() {
    	int i = 0;
    	return i;
    }
}
