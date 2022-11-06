package Model;

/**
 * Cette interface permet de g�rer le patron de conception strategy chaque m�thode est abstraite ici et va �tre r�xpliquer dans 
 * autres classes : d�fensif, agressive et al�atoire
 * 
 * @author Adam
 *
 */

public interface Comportement {

	/**
	 * Cette m�hode abstraite permet au bot de choisir al�atoirement sont camp en fonction de son choix de strat�gie
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
	public int choisirCamp();
	
	 /**
		 * Cette m�hode abstraite permet au bot de choisir al�atoirement quelle action r�aliser en fonction de son choix de strat�gie
		 * 
		 * @return un entier qui va correspondre au choix que fais le bot
		 */
    public int queFaire();
    
    /**
	 * Cette m�hode abstraite permet au bot de choisir al�atoirement que faire s'il est accus� en fonction de son comportement
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
    public int estAccus�();
    
    /**
	 * Cette m�hode abstraite permet au bot de choisir s'il accuse quelqu'un 
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
    public int accuser();
    
    /**
	 * Cette m�hode abstraite permet au bot de choisir ala carte qu'il doit utiliser
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
    public String choisirCarte();
    
    /**
	 * Cette m�hode abstraite permet au bot de choisir quel joueur il va prendre pour cible
	 * 
	 * @return une chaine de caract�re avec les deux premi�res lettre de la carte choisie
	 */
    public int quiChoisir();
    
    /**
	 * Cette m�hode abstraite permet au bot de r�aliser l'action associ�e � la carte Ducking Stool
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
    public int actionDuckingStool();

}
