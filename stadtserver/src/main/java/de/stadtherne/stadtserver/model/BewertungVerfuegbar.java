package de.stadtherne.stadtserver.model;

public class BewertungVerfuegbar extends Status {
        @Override
    public void umfrageVerfuegbarSetzen(Aktivitaet aktivitaet) {
       aktivitaet.setStatus(new UmfrageVerfuegbarStatus());
    }

}
