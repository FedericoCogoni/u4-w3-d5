package FedericoCogoni;

import FedericoCogoni.dao.ElementoCatalogoDAO;
import FedericoCogoni.dao.PrestitoDAO;
import FedericoCogoni.dao.UtenteDAO;
import FedericoCogoni.entities.Libro;
import FedericoCogoni.entities.Prestito;
import FedericoCogoni.entities.Rivista;
import FedericoCogoni.entities.Utente;
import FedericoCogoni.enums.Periodicità;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.UUID;

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

        Utente utente1fromDB = utenteDAO.findById(UUID.fromString("c0391972-eb01-4efe-8656-03b1d419f5e0"));
        Libro libro1fromDB = (Libro) elementoCatalogoDAO.findById("978-3-16-148410-0");
        Utente utente2fromDB = utenteDAO.findById(UUID.fromString("19eae4ab-ad46-429a-ba22-aaf049f324ae"));
        Libro libro2fromDB = (Libro) elementoCatalogoDAO.findById("978-1-86197-876-9");
        Utente utente3fromDB = utenteDAO.findById(UUID.fromString("e37e42a8-031f-4742-b607-2cf8fa4fe263"));
        Libro libro3fromDB = (Libro) elementoCatalogoDAO.findById("978-0-7432-7356-5");

        Prestito prestito1 = new Prestito(LocalDate.now(), LocalDate.now().plusDays(45),null, utente1fromDB, libro1fromDB);
        Prestito prestito2 = new Prestito(LocalDate.of(2024, 1, 5), LocalDate.of(2024, 1, 5).plusDays(45),null, utente2fromDB, libro2fromDB);
        Prestito prestito3 = new Prestito(LocalDate.of(2024, 2, 15), LocalDate.of(2024, 2, 15).plusDays(45), LocalDate.of(2024, 3, 3), utente3fromDB, libro3fromDB);

        /*prestitoDAO.save(prestito1);
        prestitoDAO.save(prestito2);
        prestitoDAO.save(prestito3);

        elementoCatalogoDAO.save(libro1);
        elementoCatalogoDAO.save(libro2);
        elementoCatalogoDAO.save(libro3);
        elementoCatalogoDAO.save(rivista1);
        elementoCatalogoDAO.save(rivista2);
        elementoCatalogoDAO.save(rivista3);
        utenteDAO.save(utente1);
        utenteDAO.save(utente2);
        utenteDAO.save(utente3);*/

        System.out.println("--------------------TROVA TRAMITE ANNO DI PUBBLICAZIONE-----------------------");
        elementoCatalogoDAO.findByAnnoDiPubblicazione(1990).forEach(System.out::println);
        System.out.println("--------------------TROVA TRAMITE AUTORE-----------------------");
        elementoCatalogoDAO.findByAutore("autore1").forEach(System.out::println);
        System.out.println("--------------------TROVA TRAMITE TITOLO-----------------------");
        elementoCatalogoDAO.findByTitolo("titolo1").forEach(System.out::println);
        System.out.println("--------------------TROVA PRESTITI TRAMITE ID TESSERA-----------------------");
        prestitoDAO.findByIdTessera(UUID.fromString("19eae4ab-ad46-429a-ba22-aaf049f324ae")).forEach(System.out::println);
        System.out.println("--------------------TROVA PRESTITI SCADUTI E NON ANCORA RESTITUITI-----------------------");
        prestitoDAO.findPrestitiScaduti().forEach(System.out::println);

        entityManager.close();
        emf.close();



    }
}