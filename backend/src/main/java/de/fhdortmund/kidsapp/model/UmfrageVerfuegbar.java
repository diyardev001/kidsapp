package de.fhdortmund.kidsapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Konkreter Status für verfügbare Umfragen
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class UmfrageVerfuegbar extends Status {
    @OneToOne
    private Umfrage umfrage;

    public UmfrageVerfuegbar(Veranstaltung veranstaltung) {
        super(veranstaltung);
    }

    public UmfrageVerfuegbar() {

    }

    @Override
    public void umfrageVerfuegbarSetzen() {
        // Bereits in diesem Status
    }

    @Override
    public void bewertungVerfuegbarSetzen() {
        BewertungVerfuegbar neuerStatus = new BewertungVerfuegbar();
        umfrage.getVeranstaltung().setStatus(neuerStatus);
    }

    @Override
    public void ausstehenSetzen() {
        Ausstehend neuerStatus = new Ausstehend();
        umfrage.getVeranstaltung().setStatus(neuerStatus);
    }

    @Override
    public void liveSetzen() {
        Live neuerStatus = new Live();
        umfrage.getVeranstaltung().setStatus(neuerStatus);
    }

    @Override
    public void stattfindendSetzen() {
        Stattfindend neuerStatus = new Stattfindend();
        umfrage.getVeranstaltung().setStatus(neuerStatus);
    }

    @Override
    public void abgeschlossenSetzen() {
        Abgeschlossen neuerStatus = new Abgeschlossen();
        umfrage.getVeranstaltung().setStatus(neuerStatus);
    }

    @Override
    public void geloeschtSetzen() {
        Geloescht neuerStatus = new Geloescht();
        umfrage.getVeranstaltung().setStatus(neuerStatus);
    }


}