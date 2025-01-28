package Model;

/**
 * Cette interface permet de gerer le patron de conception strategy chaque
 * methode est abstraite ici et va etre rexpliquer dans
 * autres classes : defensif, agressive et aleatoire
 * 
 * @author Adam
 *
 */

public interface Comportement {

	/**
	 * Cette mehode abstraite permet au bot de choisir aleatoirement sont camp en
	 * fonction de son choix de strategie
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
	public int choisirCamp();

	/**
	 * Cette mehode abstraite permet au bot de choisir aleatoirement quelle action
	 * realiser en fonction de son choix de strategie
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
	public int queFaire();

	/**
	 * Cette mehode abstraite permet au bot de choisir aleatoirement que faire s'il
	 * est accuse en fonction de son comportement
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
	public int estAccuse();

	/**
	 * Cette mehode abstraite permet au bot de choisir s'il accuse quelqu'un
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
	public int accuser();

	/**
	 * Cette mehode abstraite permet au bot de choisir ala carte qu'il doit utiliser
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
	public String choisirCarte();

	/**
	 * Cette mehode abstraite permet au bot de choisir quel joueur il va prendre
	 * pour cible
	 * 
	 * @return une chaine de caractere avec les deux premieres lettre de la carte
	 *         choisie
	 */
	public int quiChoisir();

	/**
	 * Cette mehode abstraite permet au bot de realiser l'action associee e la carte
	 * Ducking Stool
	 * 
	 * @return un entier qui va correspondre au choix que fais le bot
	 */
	public int actionDuckingStool();

}
