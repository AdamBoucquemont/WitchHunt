package Model;

/**
 * Nous avons ici la classe AngryMob qui donne les actions faites par cette même carte
 * 
 * 
 * @author Adam
 *
 */

public class AngryMob extends CarteRumeur {

	/**
	 * Cette argument sert à voir si la condition est vérifiée ou pas.
	 *
	 */
	private boolean condition;
	
	/**
	 * Cette méthode permet de créer un objet du type Angry Mob
	 * Il initialise la condition à false par défaut.
	 * Quand la conditon est sur faux, la carte ne peux pas être utilisée.
	 *
	 */
	public AngryMob() {
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
	 * Cette méthode exécute la whitch action de la carte Angry Mob
	 *
	 */
    public void witchAction() {
    	System.out.println("Vous prenez le prochain tour");
    }

    /**
	 * Cette méthode exécute la whitch action de la carte the Angry Mob
	 *
	 */
    public void huntAction() {
    	System.out.println("Vous choisissez le prochain joueur.");
    }
    
}
