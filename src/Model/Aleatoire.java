package Model;

/**
 * Cette classe permet de faire executer au bot des methodes particulieres dans
 * le cas ou ce dernier est de type aleatoire
 * 
 * @author Adam
 *
 */

public class Aleatoire implements Comportement {

	/**
	 * Cet attribut symbolise le comportement du bot
	 */
	int comportement;

	/**
	 * Cet classe peremt de cree un bot aleatoire
	 */
	public Aleatoire() {
		// System.out.println("Le bot est aleatoire");
		this.comportement = 2;
	}

	public int queFaire() {
		int choix;
		choix = (int) Math.floor(Math.random() * 2) + 1;
		if (choix == 1) {
			System.out.println("Vous allez accusez un joueur!");
		} else {
			System.out.println("Vous avez choisi d'utiliser une carte hunt!");
		}
		return choix;
	}

	public int choisirCamp() {
		int choix;
		choix = (int) Math.floor(Math.random() * 2) + 1;
		return choix;
	}

	public int estAccuse() {
		int choix;
		choix = (int) Math.floor(Math.random() * 2) + 1;
		if (choix == 1) {
			System.out.println("Vous allez reveler votre carte!");
		} else {
			System.out.println("Vous avez choisi d'utiliser une carte witch!");
		}
		return choix;
	}

	public int accuser() {
		return 1;
	}

	public String choisirCarte() {
		String m = "BR";
		return m;
	}

	public int quiChoisir() {
		return 1;
	}

	public int actionDuckingStool() {
		int choix;
		choix = (int) Math.floor(Math.random() * 2) + 1;
		return choix;
	}

}