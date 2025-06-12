package de.stadtherne.stadtserver.model;

public class Ausstehend extends Status{
     @Override
    public void liveSetzen(Aktivitaet a) {
        a.abgeschlossenSetzen(a);.setStatus(new LiveStatus());
    }

    @Override
    public void geloeschtSetzen(Aktivitaet a) {
        a.setStatus(new GeloeschtStatus());
    }
}
