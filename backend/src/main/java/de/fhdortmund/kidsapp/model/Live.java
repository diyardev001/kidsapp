package de.fhdortmund.kidsapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity representing the live status.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Live extends Status {
    public Live(Veranstaltung veranstaltung) {
        super(veranstaltung);
    }

    public Live() {

    }

    @Override
    public void umfrageVerfuegbarSetzen() {
        throw new IllegalStateException("Kann nicht von Live zu UmfrageVerfuegbar wechseln");
    }

    @Override
    public void bewertungVerfuegbarSetzen() {
        throw new IllegalStateException("Kann nicht von Live zu BewertungVerfuegbar wechseln");
    }

    @Override
    public void ausstehenSetzen() {
        throw new IllegalStateException("Kann nicht von Live zu Ausstehend wechseln");
    }

    @Override
    public void liveSetzen() {
        // Bereits in diesem Status
    }

    @Override
    public void stattfindendSetzen() {
        veranstaltung.setStatus(new Stattfindend());
    }

    @Override
    public void abgeschlossenSetzen() {
        veranstaltung.setStatus(new Abgeschlossen());
    }

    @Override
    public void geloeschtSetzen() {
        veranstaltung.setStatus(new Geloescht());
    }
}