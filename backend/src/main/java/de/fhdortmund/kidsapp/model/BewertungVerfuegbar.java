package de.fhdortmund.kidsapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Konkreter Status für verfügbare Bewertungen
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class BewertungVerfuegbar extends Status {
    @OneToOne
    private Bewertung bewertung;

    public BewertungVerfuegbar(Veranstaltung veranstaltung) {
        super(veranstaltung);
    }

    public BewertungVerfuegbar() {

    }

    @Override
    public void umfrageVerfuegbarSetzen() {
        UmfrageVerfuegbar neuerStatus = new UmfrageVerfuegbar();
        bewertung.getVeranstaltung().setStatus(neuerStatus);
    }

    @Override
    public void bewertungVerfuegbarSetzen() {
        // Bereits in diesem Status
    }

    @Override
    public void ausstehenSetzen() {
        Ausstehend neuerStatus = new Ausstehend();
        bewertung.getVeranstaltung().setStatus(neuerStatus);
    }

    @Override
    public void liveSetzen() {
        Live neuerStatus = new Live();
        bewertung.getVeranstaltung().setStatus(neuerStatus);
    }

    @Override
    public void stattfindendSetzen() {
        Stattfindend neuerStatus = new Stattfindend();
        bewertung.getVeranstaltung().setStatus(neuerStatus);
    }

    @Override
    public void abgeschlossenSetzen() {
        Abgeschlossen neuerStatus = new Abgeschlossen();
        bewertung.getVeranstaltung().setStatus(neuerStatus);
    }

    @Override
    public void geloeschtSetzen() {
        Geloescht neuerStatus = new Geloescht();
        bewertung.getVeranstaltung().setStatus(neuerStatus);
    }
}