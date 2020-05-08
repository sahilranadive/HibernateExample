import model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main {

  public static void main(String[] args) {

    System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

    Book book = new Book(123L,"H2G2", "Best IT Scifi Book", 12.5f, "1234-5678-5678", 247);

    EntityManager em = PersistenceManager.getEntityManager();
    em.getTransaction()
            .begin();
    em.persist(book);
    em.getTransaction()
            .commit();
    em.close();
    PersistenceManager.close();
  }
}


