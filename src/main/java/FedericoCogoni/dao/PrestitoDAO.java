package FedericoCogoni.dao;

import FedericoCogoni.entities.ElementoCatalogo;
import FedericoCogoni.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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

    public List<Prestito> findByIdTessera (UUID id) {
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.utente.id_tessera = :id_tessera AND p.data_restituzione_effettiva IS NULL", Prestito.class);
                query.setParameter("id_tessera", id);
                return query.getResultList();
    }

    public List<Prestito> findPrestitiScaduti () {
        TypedQuery<Prestito> query = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.data_restituzione_effettiva IS NULL AND p.data_restituzione_prevista < :data_attuale", Prestito.class);
                query.setParameter("data_attuale", LocalDate.now());
                return query.getResultList();

    }
}
