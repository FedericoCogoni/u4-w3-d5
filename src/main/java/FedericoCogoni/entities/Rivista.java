package FedericoCogoni.entities;

import FedericoCogoni.enums.Periodicità;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
//@Table(name = "riviste")
public class Rivista extends ElementoCatalogo{
    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;

    public Rivista(){}

    public Rivista(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    public Rivista(String isbn, String titolo, int anno_di_pubblicazione, int numero_pagine, Periodicità periodicità) {
        super(isbn, titolo, anno_di_pubblicazione, numero_pagine);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicità=" + periodicità +
                ", isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", anno_di_pubblicazione=" + anno_di_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}
