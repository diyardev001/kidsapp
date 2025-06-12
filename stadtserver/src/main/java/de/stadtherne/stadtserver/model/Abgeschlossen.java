package de.stadtherne.stadtserver.model;

public class Abgeschlossen extends Status {

    @Override
    public void bewertungVerfuegbarSetzen(Aktivitaet aktivitaet) {
     aktivitaet.setStatus(new BewertungVerfuegbar());
    }

   
}


