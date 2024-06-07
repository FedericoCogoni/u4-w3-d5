package FedericoCogoni;

import FedericoCogoni.dao.ElementoCatalogoDAO;
import FedericoCogoni.dao.PrestitoDAO;
import FedericoCogoni.dao.UtenteDAO;
import FedericoCogoni.entities.ElementoCatalogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(

            "u4-w3-d5");
    public static void main(String[] args) {

        System.out.println("Hello World!");

        EntityManager entityManager = emf.createEntityManager();
        ElementoCatalogoDAO elementoCatalogoDAO = new ElementoCatalogoDAO(entityManager);
        PrestitoDAO prestitoDAO = new PrestitoDAO(entityManager);
        UtenteDAO utenteDAO = new UtenteDAO(entityManager);


    }


}
