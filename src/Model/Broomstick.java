package Model;

/**
 * Nous avons ici la classe Broomstick qui donne les actions faites par cette m�me carte
 * 
 * 
 * @author Adam
 *
 */

public class Broomstick extends CarteRumeur {

	/**
	 * Cette m�thode ex�cute la whitch action de la carte Broomstick
	 *
	 */
    public void witchAction() {
    	System.out.println("Vous ne pourrez pas �tre choisi par la carte rumeur Angry Mob. Vous prenez le prochain tour");
    }

	/**
	 * Cette m�thode ex�cute la hunt action de la carte Broomstick
	 *
	 */
    public void huntAction() {
    	System.out.println("Vous choisissez le prochain joueur � jouer !");
    }

}
