package Model;

/**
 * Nous avons ici la classe EvilEye qui donne les actions faites par cette m�me carte
 * 
 * 
 * @author Adam
 *
 */

public class EvilEye extends CarteRumeur {

	/**
	 * Cette m�thode ex�cute la whitch action de la carte EvilEye
	 *
	 */
    public void witchAction() {
    	huntAction();
    }

    /**
	 * Cette m�thode ex�cute la hunt action de la carte EvilEye
	 *
	 */
    public void huntAction() {
    	System.out.println("Vous choisissez qui prend le prochain tour. Ce joueur ne pourra pas vous accuser si c'est possible");
    }
}
