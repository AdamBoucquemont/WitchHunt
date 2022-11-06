package Model;


/**
 * Nous avons ici la classe Carte
 * 
 * 
 * @author Adam
 *
 */

public class Carte {
	
	/**
     * Valeur repr�sentant le nom d'une carte d'apr�s une �num�ration.
     * 
     * 
     */
    public CarteRumeurEnum nomCarte;
    
    /**
     * Valeur repr�sentant l'id d'une carte
     * 
     * 
     */
    protected String idCarte;

    /**
     * Valeur repr�sentant une manche
     * 
     * 
     */
    public Manche distribution;
    
    /**
     * Cette fonction permet de comparer une carte avec une autre pour vous si elles sont �gales.
     * 
     * @param obj l'objet que l'on veut comparer avec la carte.
     * @return un boolean qui prendra la valeur true si les deux objets sont identiques et faux sinon.
     *
     */
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		if(!nomCarte.equals(other.nomCarte))
			return false;
		return true;
	}

	/**
     * Cette fonction est le constructeur de la carte.
     * 
     * @param nomCarte le nom de la carte concern�e 
     */
    public Carte (CarteRumeurEnum nomCarte) { 
    	this.nomCarte = nomCarte; 
    }
    
    /**
     * Cette fonction est un getter nous permettant de r�cup�rer l'ID de la carte concern�e.
     * 
     * @return on retourne l'ID de la carte
     */
    public String getidCarte(){
    	return this.nomCarte.idCarte;
    }
    

    /**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de distribution.
     * 
     * @return on retourne la valeur de distribution
     */
	public Manche getDistribution() {
		return distribution;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de distribution
     * 
     * @param distribution la valeur que nous voulons d�finir
     */
	public void setDistribution(Manche distribution) {
		this.distribution = distribution;
	}
	
	/**
     * Cette fonction est celle qui va s'executer lorsque nous chercherons � voir une carte.
     * Elle nous renverra le nom de la carte.
     * 
     * @return sb.toString qui est une chaine de caract�re contenant le nom de la carte.
     */
    public String toString() { 
	 StringBuffer sb = new StringBuffer(); 
	 sb.append(this.nomCarte); 
	 return sb.toString(); 
    }

    /**
     * Cette fonction est un getter nous permettant de r�cup�rer le nom de la carte.
     * 
     * @return on retourne la valeur de nomCarte.
     */
	public CarteRumeurEnum getNomCarte() {
		return nomCarte;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur du nom de la carte.
     * 
     * @param nomCarte la valeur que nous voulons d�finir
     */
	public void setNomCarte(CarteRumeurEnum nomCarte) {
		this.nomCarte = nomCarte;
	}

	/**
     * Cette fonction est un getter nous permettant de r�cup�rer la valeur de l'id de la carte.
     * 
     * @return on retourne la valeur de idCarte.
     */
	public String getIdCarte() {
		return idCarte;
	}

	/**
     * Cette fonction est le setter nous permettant de d�finir la valeur de l'ID de la carte
     * 
     * @param idCarte la valeur que nous voulons d�finir
     */
	public void setIdCarte(String idCarte) {
		this.idCarte = idCarte;
	}
    
    

}
