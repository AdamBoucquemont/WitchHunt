package Model;

/**
 * Nous avons ici l'énumération carteRumeurEnum
 * 
 * 
 * @author Adam
 *
 */

public enum CarteRumeurEnum {
	/**
	 * Associe la chaine de caractère "an" à la carte nommée Angry Mob.
	 */
	AngryMob("an"),
	//0
	
	/**
	 * Associe la chaine de caractère "bl" à la carte nommée Black Cat.
	 */
	BlackCat("bl"),
	//1
	
	/**
	 * Associe la chaine de caractère "br" à la carte nommée Broomstick.
	 */
	Broomstick("br"), 
	//2
	
	/**
	 * Associe la chaine de caractère "ca" à la carte nommée Cauldron.
	 */
	Cauldron("ca"), 
	//3
	
	/**
	 * Associe la chaine de caractère "du" à la carte nommée Ducking Stool.
	 */
	DuckingStool("du"), 
	//4
	
	/**
	 * Associe la chaine de caractère "ev" à la carte nommée Evil Eye.
	 */
	EvilEye("ev"), 
	//5
	
	/**
	 * Associe la chaine de caractère "ho" à la carte nommée Hooked Nose.
	 */
	HookedNose("ho"), 
	//6
	
	/**
	 * Associe la chaine de caractère "pe" à la carte nommée Pet Newt.
	 */
	PetNewt("pe"), 
	//7
	
	/**
	 * Associe la chaine de caractère "po" à la carte nommée Pointed Hat.
	 */
	PointedHat("po"), 
	//8
	
	/**
	 * Associe la chaine de caractère "th" à la carte nommée The Inquisition.
	 */
	TheInquisition("th"), 
	//9
	
	/**
	 * Associe la chaine de caractère "to" à la carte nommée Toad.
	 */
	Toad("to"),
	//10
	
	/**
	 * Associe la chaine de caractère "wa" à la carte nommée Wart.
	 */
	Wart("wa");
	//11
	
	/**
	 * Cette argument est l'id de la carte
	 *
	 */
	protected String idCarte;
	

	/**
	 * Cette Méthode est le sette associée à l'id de la carte
	 * 
	 * @param idCarte l'id de la carte
	 *
	 */
	private CarteRumeurEnum (String idCarte){
		this.idCarte = idCarte;
	}
	
	/**
	 * Cette Méthode est un getter correspondant à l'id de la carte
	 * 
	 * @return la valeur de l'id de la carte
	 *
	 */
	private String idCarte() {
		return idCarte;
	}

	
}
