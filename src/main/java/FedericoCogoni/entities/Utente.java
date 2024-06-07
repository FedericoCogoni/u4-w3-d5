package FedericoCogoni.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue

    private UUID id_tessera;
    private String nome;
    private String cognome;
    private LocalDate data_di_nascita;

    @OneToMany(mappedBy = "utente")
    private List<Prestito> listaPrestiti;



    public Utente () {}

    public Utente( String nome, String cognome, LocalDate data_di_nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_di_nascita = data_di_nascita;
    }

    public UUID getId_tessera() {
        return id_tessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id_tessera=" + id_tessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                '}';
    }
}
