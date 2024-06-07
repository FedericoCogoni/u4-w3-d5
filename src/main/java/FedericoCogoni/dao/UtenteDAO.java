package FedericoCogoni.dao;

import FedericoCogoni.entities.ElementoCatalogo;
import FedericoCogoni.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UtenteDAO {
    private final EntityManager em;
    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save (Utente utente){
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(utente);
            transaction.commit();
            System.out.println("Evento - " + utente.getId_tessera() + " - creato!");
        } catch (Exception e) {
            System.out.println((e.getMessage()));
        }

    }

    public Utente findById(UUID id_tessera) {
        try {
            if (id_tessera != null) {

                Utente utente = em.find(Utente.class, id_tessera);
                return utente;
            }
        } catch (Exception e) {
            System.out.println((e.getMessage()));
        }
        return null;
    }
}
