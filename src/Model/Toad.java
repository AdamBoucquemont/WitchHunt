package Model;

/**
 * Nous avons ici la classe Toad qui donne les actions faites par cette m�me carte
 * 
 * 
 * @author Adam
 *
 */

public class Toad extends CarteRumeur{

	/**
	 * Cette m�thode ex�cute la whitch action de la carte toad
	 *
	 */
    public void witchAction() {
    	System.out.println("Vous prenez le prochain tour");
    }

    /**
	 * Cette m�thode ex�cute la hunt action de la carte toad 
	 *
	 */
    public void huntAction() {
    	System.out.println("Vous aller r�v�ler votre carte r�le");
    }
}
