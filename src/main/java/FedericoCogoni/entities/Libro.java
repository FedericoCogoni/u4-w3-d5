package FedericoCogoni.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "libri")
public class Libro extends ElementoCatalogo{

    private String autore;
    private String genere;

    public Libro () {}

    public Libro(String isbn, String titolo, int anno_di_pubblicazione, int numero_pagine, String autore, String genere) {
        super(isbn, titolo, anno_di_pubblicazione, numero_pagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                ", isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", anno_di_pubblicazione=" + anno_di_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}
