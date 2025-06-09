package de.fhdortmund.kidsapp.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Abstrakte Basisklasse für alle Status-Typen.
 * Implementiert das Zustandsmuster (State Pattern).
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Status {
    @OneToOne
    protected Veranstaltung veranstaltung;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Status(Veranstaltung veranstaltung) {
        this.veranstaltung = veranstaltung;
    }

    public Status() {

    }

    // Gemeinsame Methoden für alle Status
    public abstract void umfrageVerfuegbarSetzen();
    public abstract void bewertungVerfuegbarSetzen();
    public abstract void ausstehenSetzen();
    public abstract void liveSetzen();
    public abstract void stattfindendSetzen();
    public abstract void abgeschlossenSetzen();
    public abstract void geloeschtSetzen();
}