package Model;

/**
 * Nous avons ici la classe Cauldron qui donne les actions faites par cette m�me carte
 * 
 * 
 * @author Adam
 *
 */

public class Cauldron extends CarteRumeur {

	/**
	 * Cette m�thode ex�cute la whitch action de la carte Cauldron
	 *
	 */
    public void witchAction() {
    	System.out.println("Vous prenez le prochain tour");
    }

	/**
	 * Cette m�thode ex�cute la hunt action de la carte Cauldron
	 *
	 */
    public void huntAction() {
    	System.out.println("Vous aller r�v�ler votre carte r�le");
    }
}
