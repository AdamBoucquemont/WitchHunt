package Model;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Nous avons ici la classe DuckingStool qui donne les actions faites par cette même carte
 * 
 * 
 * @author Adam
 *
 */

public class DuckingStool extends CarteRumeur {
	
	/**
	 * Cette méthode exécute la whitch action de la carte DuckingStool
	 *
	 */
    public void witchAction() {
    	System.out.println("Qui prend le prochain tour ?");
    }

    /**
	 * Cette méthode exécute la hunt action de la carte DuckingStool
	 *
	 *@throws InputMismatchException cette exception est levée durant l'appel à cette méthode
	 */
    public void huntAction() throws InputMismatchException {

    }

}