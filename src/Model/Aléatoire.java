package Model;


/**
 * Cette classe permet de faire exécuter au bot des méthodes particulières dans le cas ou ce dernier est de type aléatoire
 * 
 * @author Adam
 *
 */

public class Aléatoire implements Comportement {
	
	/**
	 * Cet attribut symbolise le comportement du bot
	 */
	int comportement;
	
	/**
	 * Cet classe peremt de crée un bot aléatoire
	 */
	public Aléatoire() {
		//System.out.println("Le bot est aléatoire");
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

	public int estAccusé() {
		int choix;
		choix = (int) Math.floor(Math.random()*2)+1;
		if (choix == 1) {
			System.out.println("Vous allez révéler votre carte!");
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