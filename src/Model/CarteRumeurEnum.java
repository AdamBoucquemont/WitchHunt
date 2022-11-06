package Model;

/**
 * Nous avons ici l'�num�ration carteRumeurEnum
 * 
 * 
 * @author Adam
 *
 */

public enum CarteRumeurEnum {
	/**
	 * Associe la chaine de caract�re "an" � la carte nomm�e Angry Mob.
	 */
	AngryMob("an"),
	//0
	
	/**
	 * Associe la chaine de caract�re "bl" � la carte nomm�e Black Cat.
	 */
	BlackCat("bl"),
	//1
	
	/**
	 * Associe la chaine de caract�re "br" � la carte nomm�e Broomstick.
	 */
	Broomstick("br"), 
	//2
	
	/**
	 * Associe la chaine de caract�re "ca" � la carte nomm�e Cauldron.
	 */
	Cauldron("ca"), 
	//3
	
	/**
	 * Associe la chaine de caract�re "du" � la carte nomm�e Ducking Stool.
	 */
	DuckingStool("du"), 
	//4
	
	/**
	 * Associe la chaine de caract�re "ev" � la carte nomm�e Evil Eye.
	 */
	EvilEye("ev"), 
	//5
	
	/**
	 * Associe la chaine de caract�re "ho" � la carte nomm�e Hooked Nose.
	 */
	HookedNose("ho"), 
	//6
	
	/**
	 * Associe la chaine de caract�re "pe" � la carte nomm�e Pet Newt.
	 */
	PetNewt("pe"), 
	//7
	
	/**
	 * Associe la chaine de caract�re "po" � la carte nomm�e Pointed Hat.
	 */
	PointedHat("po"), 
	//8
	
	/**
	 * Associe la chaine de caract�re "th" � la carte nomm�e The Inquisition.
	 */
	TheInquisition("th"), 
	//9
	
	/**
	 * Associe la chaine de caract�re "to" � la carte nomm�e Toad.
	 */
	Toad("to"),
	//10
	
	/**
	 * Associe la chaine de caract�re "wa" � la carte nomm�e Wart.
	 */
	Wart("wa");
	//11
	
	/**
	 * Cette argument est l'id de la carte
	 *
	 */
	protected String idCarte;
	

	/**
	 * Cette M�thode est le sette associ�e � l'id de la carte
	 * 
	 * @param idCarte l'id de la carte
	 *
	 */
	private CarteRumeurEnum (String idCarte){
		this.idCarte = idCarte;
	}
	
	/**
	 * Cette M�thode est un getter correspondant � l'id de la carte
	 * 
	 * @return la valeur de l'id de la carte
	 *
	 */
	private String idCarte() {
		return idCarte;
	}

	
}
