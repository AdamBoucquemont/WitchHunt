package Model;

/**
 * Nous avons ici la classe EvilEye qui donne les actions faites par cette même carte
 * 
 * 
 * @author Adam
 *
 */

public class EvilEye extends CarteRumeur {

	/**
	 * Cette méthode exécute la whitch action de la carte EvilEye
	 *
	 */
    public void witchAction() {
    	huntAction();
    }

    /**
	 * Cette méthode exécute la hunt action de la carte EvilEye
	 *
	 */
    public void huntAction() {
    	System.out.println("Vous choisissez qui prend le prochain tour. Ce joueur ne pourra pas vous accuser si c'est possible");
    }
}
