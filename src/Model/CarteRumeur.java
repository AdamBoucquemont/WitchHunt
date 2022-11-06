package Model;

import java.util.LinkedList;

/**
 * Nous avons ici la classe CarteRumeur
 * Au final, cette classe ne sera pas vraiment utilis�e et nous avons utilis�e une autre approche � propos des diff�rentes cartes.
 * En effet toute les cartes avaient des param�tres d'entr�es diff�rents et nous n'avons au final pas eu besoin d'utiliser une classe m�re.
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
     * Cette m�thode abstraite traite de l'utilisation de l'aspect witch d'une carte
     *
     */
    public abstract void witchAction();

    /**
     * Cette m�thode abstraite traite de l'utilisation de l'aspect hunt d'une carte
     *
     */
    //public abstract void huntAction();


}