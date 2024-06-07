package FedericoCogoni.dao;

import FedericoCogoni.entities.ElementoCatalogo;
import FedericoCogoni.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PrestitoDAO {
    private final EntityManager em;
    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save (Prestito prestito){
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(prestito);
            transaction.commit();
            System.out.println("Evento - " + prestito.getId() + " - creato!");
        } catch (Exception e) {
            System.out.println((e.getMessage()));
        }
    }

    public void deleteById (String id) {
        try {
            if (id != null) {
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                Prestito prestito = em.find(Prestito.class, id);
                em.remove(prestito);
                tx.commit();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
