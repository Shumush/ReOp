
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
      }
    }
  }
}
