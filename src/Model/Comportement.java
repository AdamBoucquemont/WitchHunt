package Model;

/**
 * Cette interface permet de gérer le patron de conception strategy chaque méthode est abstraite ici et va être réxpliquer dans 
 * autres classes : défensif, agressive et aléatoire
 * 
 * @author Adam
 *
 */

public interface Comportement {

	/**
	 * Cette méhode abstraite permet au bot de choisir aléatoirement sont camp en fonction de son choix de stratégie
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
	public int choisirCamp();
	
	 /**
		 * Cette méhode abstraite permet au bot de choisir aléatoirement quelle action réaliser en fonction de son choix de stratégie
		 * 
		 * @return un entier qui va correspondre au choix que fais le bot
		 */
    public int queFaire();
    
    /**
	 * Cette méhode abstraite permet au bot de choisir aléatoirement que faire s'il est accusé en fonction de son comportement
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
    public int estAccusé();
    
    /**
	 * Cette méhode abstraite permet au bot de choisir s'il accuse quelqu'un 
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
    public int accuser();
    
    /**
	 * Cette méhode abstraite permet au bot de choisir ala carte qu'il doit utiliser
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
    public String choisirCarte();
    
    /**
	 * Cette méhode abstraite permet au bot de choisir quel joueur il va prendre pour cible
	 * 
	 * @return une chaine de caractère avec les deux premières lettre de la carte choisie
	 */
    public int quiChoisir();
    
    /**
	 * Cette méhode abstraite permet au bot de réaliser l'action associée à la carte Ducking Stool
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
    public int actionDuckingStool();

}
