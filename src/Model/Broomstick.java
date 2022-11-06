package Model;

/**
 * Nous avons ici la classe Broomstick qui donne les actions faites par cette même carte
 * 
 * 
 * @author Adam
 *
 */

public class Broomstick extends CarteRumeur {

	/**
	 * Cette méthode exécute la whitch action de la carte Broomstick
	 *
	 */
    public void witchAction() {
    	System.out.println("Vous ne pourrez pas être choisi par la carte rumeur Angry Mob. Vous prenez le prochain tour");
    }

	/**
	 * Cette méthode exécute la hunt action de la carte Broomstick
	 *
	 */
    public void huntAction() {
    	System.out.println("Vous choisissez le prochain joueur à jouer !");
    }

}
