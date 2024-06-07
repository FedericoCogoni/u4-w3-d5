package FedericoCogoni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate inizio_prestito;
    private LocalDate data_restituzione_prevista;
    private LocalDate data_restituzione_effettiva;
    @ManyToOne
    @JoinColumn
    private Utente utente;
    @ManyToOne
    @JoinColumn
    private ElementoCatalogo elementoCatalogo;

    public Prestito () {}

    public Prestito(LocalDate inizio_prestito, LocalDate data_restituzione_prevista, LocalDate data_restituzione_effettiva) {
        this.inizio_prestito = inizio_prestito;
        this.data_restituzione_prevista = data_restituzione_prevista;
        this.data_restituzione_effettiva = data_restituzione_effettiva;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getInizio_prestito() {
        return inizio_prestito;
    }

    public void setInizio_prestito(LocalDate inizio_prestito) {
        this.inizio_prestito = inizio_prestito;
    }

    public LocalDate getData_restituzione_prevista() {
        return data_restituzione_prevista;
    }

    public void setData_restituzione_prevista(LocalDate data_restituzione_prevista) {
        this.data_restituzione_prevista = data_restituzione_prevista;
    }

    public LocalDate getData_restituzione_effettiva() {
        return data_restituzione_effettiva;
    }

    public void setData_restituzione_effettiva(LocalDate data_restituzione_effettiva) {
        this.data_restituzione_effettiva = data_restituzione_effettiva;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ElementoCatalogo getElementoCatalogo() {
        return elementoCatalogo;
    }

    public void setElementoCatalogo(ElementoCatalogo elementoCatalogo) {
        this.elementoCatalogo = elementoCatalogo;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", inizio_prestito=" + inizio_prestito +
                ", data_restituzione_prevista=" + data_restituzione_prevista +
                ", data_restituzione_effettiva=" + data_restituzione_effettiva +
                ", utente=" + utente +
                ", elementoCatalogo=" + elementoCatalogo +
                '}';
    }
}
