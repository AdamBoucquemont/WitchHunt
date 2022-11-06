package Model;


/**
 * Cette classe permet de faire ex�cuter au bot des m�thodes particuli�res dans le cas ou ce dernier est de type al�atoire
 * 
 * @author Adam
 *
 */

public class Al�atoire implements Comportement {
	
	/**
	 * Cet attribut symbolise le comportement du bot
	 */
	int comportement;
	
	/**
	 * Cet classe peremt de cr�e un bot al�atoire
	 */
	public Al�atoire() {
		//System.out.println("Le bot est al�atoire");
		this.comportement = 2;
	}
	
	public int queFaire() {
		int choix;
		choix = (int) Math.floor(Math.random()*2)+1;
		if (choix == 1) {
			System.out.println("Vous allez accusez un joueur!");
		}
		else {
			System.out.println("Vous avez choisi d'utiliser une carte hunt!");
		}
		return choix;
	}

	public int choisirCamp() {
		int choix;
		choix = (int) Math.floor(Math.random()*2)+1;
		return choix;
	}

	public int estAccus�() {
		int choix;
		choix = (int) Math.floor(Math.random()*2)+1;
		if (choix == 1) {
			System.out.println("Vous allez r�v�ler votre carte!");
		}
		else {
			System.out.println("Vous avez choisi d'utiliser une carte witch!");
		}
		return choix;
	}
	
	public int accuser() {
		return 1;
	}
	
	public String choisirCarte() {
		String m ="BR";
		return m;
	}
	
	public int quiChoisir() {
		return 1;
	}	

	public int actionDuckingStool() {
		int choix;
		choix = (int) Math.floor(Math.random()*2)+1;
		return choix;
	}

}