package Model;


/**
 * Nous avons ici la classe Petnewt qui donne les actions faites par cette même carte
 * 
 * 
 * @author Adam
 *
 */

public class PetNewt extends CarteRumeur{

	/**
	 * Cette méthode exécute la whitch action de la carte Petnewt 
	 *
	 */
    public void witchAction() {
    	System.out.println("Vous prenez le prochain tour");
    }

	/**
	 * Cette méthode exécute la hunt action de la carte Petnewt 
	 *
	 */
    public void huntAction() {
    	System.out.println("Récupérez une carte défaussée par un autre joueur. Indiquez le numéro.");
    }
}
