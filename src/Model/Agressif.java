package Model;

/**
 * Cette classe permet de faire ex�cuter au bot des m�thodes particuli�res dans le cas ou ce dernier est de type agressif
 * 
 * @author Adam
 *
 */

public class Agressif implements Comportement {
	
	/**
	 * Cet attribut symbolise le comportement du bot
	 */
	int comportement;

	/**
	 * Cet classe peremt de cr�e un bot agressif
	 */
	public Agressif() {
		//System.out.println("Le bot est agressif");
		this.comportement = 1;
	}

	public int queFaire() {
		int choix;
		choix = (int) Math.floor(Math.random()*4)+1;
		if (choix <=3) {
			System.out.println("Vous allez accuser un joueur!");
			choix=1;
		}
		else {
			System.out.println("Vous avez choisi d'utiliser une carte hunt!");
			choix=2;
		}
		return choix;
	}

	public int choisirCamp() {
		int choix;
		choix = (int) Math.floor(Math.random()*4)+1;
		if (choix <=3) {
			choix=1;
		}
		else  {
			choix=2;
		}
		return choix;
	}

	public int estAccus�() {
		int choix;
		choix = (int) Math.floor(Math.random()*4)+1;
		if (choix <=3) {
			System.out.println("Vous allez r�v�ler votre carte!");
			choix=1;
		}
		else {
			System.out.println("Vous avez choisi d'utiliser une carte witch!");
			choix=2;
		}
		return choix;
	}
	
	public int accuser() {
		return 1;
	}
	
	public String choisirCarte() {
		String m ="br";
		return m;
	}
	
	public int quiChoisir() {
		return 1;
	}
	
	public int actionDuckingStool() {
		int n = 1;
		return n;
	}
	
}
