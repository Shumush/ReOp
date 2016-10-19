
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
}
