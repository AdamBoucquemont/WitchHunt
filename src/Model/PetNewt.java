package Model;


/**
 * Nous avons ici la classe Petnewt qui donne les actions faites par cette m�me carte
 * 
 * 
 * @author Adam
 *
 */

public class PetNewt extends CarteRumeur{

	/**
	 * Cette m�thode ex�cute la whitch action de la carte Petnewt 
	 *
	 */
    public void witchAction() {
    	System.out.println("Vous prenez le prochain tour");
    }

	/**
	 * Cette m�thode ex�cute la hunt action de la carte Petnewt 
	 *
	 */
    public void huntAction() {
    	System.out.println("R�cup�rez une carte d�fauss�e par un autre joueur. Indiquez le num�ro.");
    }
}
