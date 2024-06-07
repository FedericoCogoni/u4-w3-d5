package FedericoCogoni;

import FedericoCogoni.dao.ElementoCatalogoDAO;
import FedericoCogoni.dao.PrestitoDAO;
import FedericoCogoni.dao.UtenteDAO;
import FedericoCogoni.entities.Libro;
import FedericoCogoni.entities.Rivista;
import FedericoCogoni.entities.Utente;
import FedericoCogoni.enums.Periodicità;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d5");

    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManager entityManager = emf.createEntityManager();
        ElementoCatalogoDAO elementoCatalogoDAO = new ElementoCatalogoDAO(entityManager);
        PrestitoDAO prestitoDAO = new PrestitoDAO(entityManager);
        UtenteDAO utenteDAO = new UtenteDAO(entityManager);


        Libro libro1 = new Libro("978-3-16-148410-0", "titolo1", 1990, 900, "autore1", "fantasy");
        Libro libro2 = new Libro("978-1-86197-876-9", "titolo2", 1989, 1200, "autore2", "school");
        Libro libro3 = new Libro("978-0-7432-7356-5", "titolo3", 1990, 350, "autore3", "horror");
        Rivista rivista1 = new Rivista("978-0-06-247210-5", "titolorivista1", 2020, 69, Periodicità.SETTIMANALE);
        Rivista rivista2 = new Rivista("978-0-394-58816-1", "titolorivista2", 2021, 25, Periodicità.MENSILE);
        Rivista rivista3 = new Rivista("978-1-250-08028-4", "titolorivista3", 2022, 50, Periodicità.SEMESTRALE);
        Utente utente1 = new Utente("utentenome1", "utentecognome1", LocalDate.of(1970, 2, 4));
        Utente utente2 = new Utente("utentenome2", "utentecognome2", LocalDate.of(1986, 8, 8));
        Utente utente3 = new Utente("utentenome3", "utentecognome3", LocalDate.of(1990, 1, 3));


       /* elementoCatalogoDAO.save(libro1);
        elementoCatalogoDAO.save(libro2);
        elementoCatalogoDAO.save(libro3);
        elementoCatalogoDAO.save(rivista1);
        elementoCatalogoDAO.save(rivista2);
        elementoCatalogoDAO.save(rivista3);
        utenteDAO.save(utente1);
        utenteDAO.save(utente2);
        utenteDAO.save(utente3);
        entityManager.close();
        emf.close(); */

        P
    }
}