package Model;

/**
 * Nous avons ici la classe HookedNose qui donne les actions faites par cette même carte
 * 
 * 
 * @author Adam
 *
 */

public class HookedNose extends CarteRumeur {

	/**
	 * Cette méthode exécute la whitch action de la carte HookedNose
	 *
	 */
    public void witchAction() {
    	System.out.println("Choisissez une carte rumeur de celui qui vous a accusé.");
    }

    /**
	 * Cette méthode exécute la hunt action de la carte HookedNose
	 *
	 */
    public void huntAction() {
    	System.out.println("Qui va jouer au prochain tour ? Vous pourrez prendre une carte rumeur de sa main. Veuillez choisir un joueur encore en jeu et ne pas vous choisir vous même ! ");
    }

}
