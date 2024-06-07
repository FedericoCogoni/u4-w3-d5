package FedericoCogoni.dao;

import FedericoCogoni.entities.ElementoCatalogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ElementoCatalogoDAO {

    private final EntityManager em;
    public ElementoCatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void save (ElementoCatalogo elementoCatalogo){
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(elementoCatalogo);
            transaction.commit();
            System.out.println("Evento - " + elementoCatalogo.getTitolo() + " - creato!");
        } catch (Exception e) {
            System.out.println((e.getMessage()));
        }
    }
}
