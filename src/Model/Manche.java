package Model;

/**
 * Nous avons ici la classe Manche et toutes les méthodes et arguments associées.
 * 
 * 
 * @author Adam
 *
 */

public class Manche {
	
	/**
     * Cet argument renvoit le numéro de la manche.
     */
    public int numéroManche;
    
    
    /**
     * Cette fonction permet de construire une nouvelle manche.
     * On initialise au début le numéro de manche à 0.
     */
    public Manche() {
    	this.numéroManche=0;
    }
    
    /**
     * Cette fonction permet de créer une nouvelle manche ce qui va avoir pour effet d'augmenter d'un le numéro de la manche.
     */
    public void nouvelleManche() {
    	this.numéroManche +=1;
    	System.out.println("Nous allons commencer la manche numéro " +this.numéroManche + " du jeu");
    }

    /**
     * Cette fonction est un getter nous permettant de récupérer la valeur de numéro de manche.
     * 
     * @return on retourne la valeur du numéro de la manche;
     */
	public int getNuméroManche() {
		return numéroManche;
	}
	
	/**
     * Cette fonction est le setter nous permettant de définir la valeur de numéro de manche
     * 
     * @param numéroManche la valeur que nous voulons définir
     */
	public void setNuméroManche(int numéroManche) {
		this.numéroManche = numéroManche;
	}
    
    


}
