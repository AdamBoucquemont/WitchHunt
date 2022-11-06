package Model;

/**
 * Nous avons ici la classe Wart qui donne les actions faites par cette même carte
 * 
 * 
 * @author Adam
 *
 */

public class Wart extends CarteRumeur {

	/**
	 * Cette méthode exécute la whitch action de la carte wart 
	 *
	 */
    public void witchAction() {
    	System.out.println("Vous ne pourrez pas être choisi par la carte rumeur Ducking Stool. Vous prenez le prochain tour");
    }

    /**
	 * Cette méthode exécute la hunt action de la carte wart 
	 *
	 */
    public void huntAction() {
    	System.out.println("Vous choisissez le prochain joueur à jouer !");
    }
    
}

