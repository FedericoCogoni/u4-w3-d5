package FedericoCogoni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "elementi_del_catalogo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ElementoCatalogo {
    @Id
    //@Column(nullable = false) in questo caso, stiamo riempiendo noi il db quindi non ha senso inserire il
    //nullable. Nel caso di inserimento dei dati da parte di un utente x, lo inserirei.
    protected String isbn;
    protected String titolo;
    protected LocalDate anno_di_pubblicazione;
    protected int numero_pagine;

    @OneToMany(mappedBy = "elementoCatalogo")
    protected List<Prestito> elementiPrestati;

    public ElementoCatalogo(){}

    public ElementoCatalogo(String isbn, String titolo, LocalDate anno_di_pubblicazione, int numero_pagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.anno_di_pubblicazione = anno_di_pubblicazione;
        this.numero_pagine = numero_pagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        isbn = isbn;
    }

    public LocalDate getAnno_di_pubblicazione() {
        return anno_di_pubblicazione;
    }

    public void setAnno_di_pubblicazione(LocalDate anno_di_pubblicazione) {
        this.anno_di_pubblicazione = anno_di_pubblicazione;
    }

    public int getNumero_pagine() {
        return numero_pagine;
    }

    public void setNumero_pagine(int numero_pagine) {
        this.numero_pagine = numero_pagine;
    }

    @Override
    public String toString() {
        return "ElementoCatalogo{" +
                "Isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", anno_di_pubblicazione=" + anno_di_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}
