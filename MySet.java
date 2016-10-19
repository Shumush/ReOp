
import java.util.Scanner;

class MySet extends List<SubSet> {

  // besoin d'un scanner pour lire les nombres entres par
  // l'utilisateur
  private static final Scanner in = new Scanner(System.in);

  public MySet() {
  }

  /**
   * demande un nombre a l'utilisateur puis renvoie true ou false
   * selon si le nombre est contenu dans le set
   */
  public boolean contains() {

    // demande du nombre a l'utilisateur
    System.out.println("Please, input a number : ");
    int x = in.nextInt();


    Iterator<SubSet> it = this.iterator();

    // on itere jusqu'a la fin de la liste
    while (!it.isOnFlag()) {
      // recuperation de l'objet pointe par l'iterateur
      SubSet sub = it.getValue();

      // cf. definition de l'appartenance a un MySet du TP5
      if (sub.rank == x/256 && sub.set.contains(x%256))
        return true;

      it.goForward();
    }

    return false;
  }

  /**
   * supprime du set toutes les valeurs saisies par l'utilisateur
   * et affiche le nouveau contenu. (la saisie s'arrete a l'input -1)
   */
  public void remove() {
    
    System.out.println("Please, input the values to remove : ");

    int x = 0;

    // a chaque tour de boucle, lis un nouvel entier
    // et s'arrete a -1
    while ((x = in.nextInt()) != -1) {
      Iterator<SubSet> it = this.iterator();

      // meme style de boucle que dans contains()
      while (!it.isOnFlag()) {
        SubSet sub = it.getValue();

        if (sub.rank == x/256 && sub.set.contains(x%256)) {
          sub.set.remove(x%256);

          // break, car seulement un SubSet contient un tel x
          break;
        }

        it.goForward();
      }
    }
  }

  /**
   * change this en l'union de lui meme et de celui en
   * parametre
   * @param s : MySet le deuxieme set
   */
  public void union(MySet s) {
    Iterator<SubSet> it = this.iterator();

    // pour tout SubSet de this
    while (!it.isOnFlag()) {
      SubSet ss1 = it.getValue();
      Iterator<SubSet> jt = s.iterator();

      // pour tout SubSet de s
      while (!jt.isOnFlag()) {
        SubSet ss2 = it.getValue();


        // si les subset contiennent les memes
        // plages de nombres (definies par le rank)
        // alors on unie leur SubSet, et on passe
        // au SubSets suivants
        if (ss1.rank == ss2.rank) {
          ss1.set.union(ss2.set);
          break;
        }

        jt.goForward();
      }

      it.goForward();
    }
  }
}
