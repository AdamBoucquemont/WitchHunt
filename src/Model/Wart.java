package Model;

/**
 * Nous avons ici la classe Wart qui donne les actions faites par cette m�me carte
 * 
 * 
 * @author Adam
 *
 */

public class Wart extends CarteRumeur {

	/**
	 * Cette m�thode ex�cute la whitch action de la carte wart 
	 *
	 */
    public void witchAction() {
    	System.out.println("Vous ne pourrez pas �tre choisi par la carte rumeur Ducking Stool. Vous prenez le prochain tour");
    }

    /**
	 * Cette m�thode ex�cute la hunt action de la carte wart 
	 *
	 */
    public void huntAction() {
    	System.out.println("Vous choisissez le prochain joueur � jouer !");
    }
    
}

