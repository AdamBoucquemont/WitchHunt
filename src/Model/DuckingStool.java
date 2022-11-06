package Model;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Nous avons ici la classe DuckingStool qui donne les actions faites par cette m�me carte
 * 
 * 
 * @author Adam
 *
 */

public class DuckingStool extends CarteRumeur {
	
	/**
	 * Cette m�thode ex�cute la whitch action de la carte DuckingStool
	 *
	 */
    public void witchAction() {
    	System.out.println("Qui prend le prochain tour ?");
    }

    /**
	 * Cette m�thode ex�cute la hunt action de la carte DuckingStool
	 *
	 *@throws InputMismatchException cette exception est lev�e durant l'appel � cette m�thode
	 */
    public void huntAction() throws InputMismatchException {

    }

}