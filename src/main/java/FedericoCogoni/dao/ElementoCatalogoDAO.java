package FedericoCogoni.dao;

import FedericoCogoni.entities.ElementoCatalogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    public ElementoCatalogo findById(String id) {
        try {
            if (id != null) {

                ElementoCatalogo elementoCatalogo = em.find(ElementoCatalogo.class, id);
                return elementoCatalogo;
            }
        } catch (Exception e) {
            System.out.println((e.getMessage()));
        }
            return null;
    }



    public void deleteById (String id) {
        try {
            if (id != null) {
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                ElementoCatalogo elementoCatalogo = em.find(ElementoCatalogo.class, id);
                em.remove(elementoCatalogo);
                tx.commit();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public List<ElementoCatalogo> findByAnnoDiPubblicazione (int anno_di_pubblicazione) {
        try {
            TypedQuery<ElementoCatalogo> query = em.createQuery(
                    "SELECT e FROM ElementoCatalogo e WHERE e.annoDiPubblicazione = :anno", ElementoCatalogo.class);
            query.setParameter("anno", anno_di_pubblicazione);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public List<ElementoCatalogo> findByAutore (String autore) {
        try {
            TypedQuery<ElementoCatalogo> query = em.createQuery(
                    "SELECT e FROM ElementoCatalogo e WHERE e.autore ILIKE :autore", ElementoCatalogo.class);
            query.setParameter("autore", autore);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<ElementoCatalogo> findByTitolo (String titolo) {
        try {
            TypedQuery<ElementoCatalogo> query = em.createQuery(
                    "SELECT e FROM ElementoCatalogo e WHERE e.titolo ILIKE :titolo", ElementoCatalogo.class);
            query.setParameter("titolo", "%"+titolo+"%");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    

}
