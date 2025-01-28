package Model;

/**
 * Cette classe permet de faire executer au bot des methodes particulieres dans
 * le cas ou ce dernier est de type agressif
 * 
 * @author Adam
 *
 */

public class Defensif implements Comportement {

	/**
	 * Cet attribut symbolise le comportement du bot
	 */
	int comportement;

	/**
	 * Cet classe peremt de cree un bot agressif
	 */
	public Defensif() {
		// System.out.println("Le bot est defensif");
		this.comportement = 3;
	}

	public int queFaire() {
		int choix;
		choix = (int) Math.floor(Math.random() * 4) + 1;
		if (choix <= 1) {
			System.out.println("Vous allez accuser un joueur!");
			choix = 1;
		} else {
			System.out.println("Vous avez choisi d'utiliser une carte hunt!");
			choix = 2;
		}
		return choix;
	}

	public int choisirCamp() {
		int choix;
		choix = (int) Math.floor(Math.random() * 4) + 1;
		if (choix <= 1) {
			choix = 1;
		} else {
			choix = 2;
		}
		return choix;
	}

	public int estAccuse() {
		int choix;
		choix = (int) Math.floor(Math.random() * 4) + 1;
		if (choix <= 1) {
			System.out.println("Vous allez reveler votre carte!");
			choix = 1;
		} else {
			System.out.println("Vous avez choisi d'utiliser une carte witch!");
			choix = 2;
		}
		return choix;
	}

	public int accuser() {
		return 1;
	}

	public String choisirCarte() {
		String m = "br";
		return m;
	}

	public int quiChoisir() {
		return 1;
	}

	public int actionDuckingStool() {
		int n = 2;
		return n;
	}

}
