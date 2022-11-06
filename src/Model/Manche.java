package Model;

/**
 * Nous avons ici la classe Manche et toutes les m�thodes et arguments associ�es.
 * 
 * 
 * @author Adam
 *
 */

public class Manche {
	
	/**
     * Cet argument renvoit le num�ro de la manche.
     */
    public int num�roManche;
    
    
    /**
     * Cette fonction permet de construire une nouvelle manche.
     * On initialise au d�but le num�ro de manche � 0.
     */
    public Manche() {
    	this.num�roManche=0;
    }
    
    /**
     * Cette fonction permet de cr�er une nouvelle manche ce qui va avoir pour effet d'augmenter d'un le num�ro de la manche.
     */
    public void nouvelleManche() {
    	this.num�roManche +=1;
    	System.out.println("Nous allons commencer la manche num�ro " +this.num�roManche + " du jeu");
    }

    /**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de num�ro de manche.
     * 
     * @return on retourne la valeur du num�ro de la manche;
     */
	public int getNum�roManche() {
		return num�roManche;
	}
	
	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de num�ro de manche
     * 
     * @param num�roManche la valeur que nous voulons d�finir
     */
	public void setNum�roManche(int num�roManche) {
		this.num�roManche = num�roManche;
	}
    
    


}
