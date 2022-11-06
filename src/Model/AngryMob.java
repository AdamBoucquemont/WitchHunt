package Model;

/**
 * Nous avons ici la classe AngryMob qui donne les actions faites par cette m�me carte
 * 
 * 
 * @author Adam
 *
 */

public class AngryMob extends CarteRumeur {

	/**
	 * Cette argument sert � voir si la condition est v�rifi�e ou pas.
	 *
	 */
	private boolean condition;
	
	/**
	 * Cette m�thode permet de cr�er un objet du type Angry Mob
	 * Il initialise la condition � false par d�faut.
	 * Quand la conditon est sur faux, la carte ne peux pas �tre utilis�e.
	 *
	 */
	public AngryMob() {
		condition=false;
	}
	
	/**
	 * Cette m�thode permet de v�rifier si la condition est bonne avant d'utiliser la carte.
	 * La condition est de savoir si le joueur � �tait r�v�l�e comme villageois.
	 * On commence par regarder si sa carte a �tait r�v�l�e.
	 * Puis on regarde si sa carte �tait villageois.
	 * Si les deux conditions sont � true on met la condition � true et il peut jouer sa carte.
	 * 
	 * @param b1 c'est un boolean �tant � vrai si la carte r�le a �tait r�v�l�e
	 * @param b2 c'est un boolean  �tant � vrai si le r�le est villageoins
	 * @return un boolean �tant � true si la condition est vrai et fausse sinon
	 *
	 */
	public boolean v�rifieCondition(boolean b1, boolean b2) {
		if (b1 == true && b2 == true) {
			System.out.println("La condition est v�rifi�e!");
			this.condition=true;
		}
		else {
			System.out.println("La condition n'est pas v�rifi�e");
		}
		return condition;
	}
	
	/**
	 * Cette m�thode ex�cute la whitch action de la carte Angry Mob
	 *
	 */
    public void witchAction() {
    	System.out.println("Vous prenez le prochain tour");
    }

    /**
	 * Cette m�thode ex�cute la whitch action de la carte the Angry Mob
	 *
	 */
    public void huntAction() {
    	System.out.println("Vous choisissez le prochain joueur.");
    }
    
}
