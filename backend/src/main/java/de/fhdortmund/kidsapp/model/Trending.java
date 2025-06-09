package de.fhdortmund.kidsapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Entity representing the trending status.
 */
@Entity
@Data
public class Trending extends Status{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Trending(Veranstaltung veranstaltung) {
        super(veranstaltung);
    }

    public Trending() {

    }

    @Override
    public void umfrageVerfuegbarSetzen() {

    }

    @Override
    public void bewertungVerfuegbarSetzen() {

    }

    @Override
    public void ausstehenSetzen() {

    }

    @Override
    public void liveSetzen() {

    }

    @Override
    public void stattfindendSetzen() {

    }

    @Override
    public void abgeschlossenSetzen() {

    }

    @Override
    public void geloeschtSetzen() {

    }

}