package Model;

/**
 * Nous avons ici la classe Toad qui donne les actions faites par cette même carte
 * 
 * 
 * @author Adam
 *
 */

public class Toad extends CarteRumeur{

	/**
	 * Cette méthode exécute la whitch action de la carte toad
	 *
	 */
    public void witchAction() {
    	System.out.println("Vous prenez le prochain tour");
    }

    /**
	 * Cette méthode exécute la hunt action de la carte toad 
	 *
	 */
    public void huntAction() {
    	System.out.println("Vous aller révéler votre carte rôle");
    }
}
