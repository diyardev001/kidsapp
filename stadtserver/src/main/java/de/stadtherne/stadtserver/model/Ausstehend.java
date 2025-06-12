package de.stadtherne.stadtserver.model;

public class Ausstehend extends Status{
     @Override
    public void liveSetzen(Umfrage umfrage) {
        umfrage.setStatus(new LiveStatus());
    }

    @Override
    public void geloeschtSetzen(Umfrage umfrage) {
        umfrage.setStatus(new GeloeschtStatus());
    }
}
