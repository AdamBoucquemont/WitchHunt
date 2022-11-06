package Model;

import java.util.LinkedList;

/**
 * Nous avons ici la classe CarteRumeur
 * Au final, cette classe ne sera pas vraiment utilisée et nous avons utilisée une autre approche à propos des différentes cartes.
 * En effet toute les cartes avaient des paramètres d'entrées différents et nous n'avons au final pas eu besoin d'utiliser une classe mère.
 * 
 * @author Adam
 *
 */

public abstract class CarteRumeur {
	/**
     * Cet attribut est un string nous donnons le nom d'une carte rumeur
     *
     */
    public String nomCarte;

    /**
     * Cette méthode abstraite traite de l'utilisation de l'aspect witch d'une carte
     *
     */
    public abstract void witchAction();

    /**
     * Cette méthode abstraite traite de l'utilisation de l'aspect hunt d'une carte
     *
     */
    //public abstract void huntAction();


}