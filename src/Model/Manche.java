package Model;

/**
 * Nous avons ici la classe Manche et toutes les methodes et arguments
 * associees.
 * 
 * 
 * @author Adam
 *
 */

public class Manche {

     /**
      * Cet argument renvoit le numero de la manche.
      */
     public int numeroManche;

     /**
      * Cette fonction permet de construire une nouvelle manche.
      * On initialise au debut le numero de manche e 0.
      */
     public Manche() {
          this.numeroManche = 0;
     }

     /**
      * Cette fonction permet de creer une nouvelle manche ce qui va avoir pour effet
      * d'augmenter d'un le numero de la manche.
      */
     public void nouvelleManche() {
          this.numeroManche += 1;
          System.out.println("Nous allons commencer la manche numero " + this.numeroManche + " du jeu");
     }

     /**
      * Cette fonction est un getter nous permettant de recuperer la valeur de numero
      * de manche.
      * 
      * @return on retourne la valeur du numero de la manche;
      */
     public int getNumeroManche() {
          return numeroManche;
     }

     /**
      * Cette fonction est le setter nous permettant de definir la valeur de numero
      * de manche
      * 
      * @param numeroManche la valeur que nous voulons definir
      */
     public void setNumeroManche(int numeroManche) {
          this.numeroManche = numeroManche;
     }

}
