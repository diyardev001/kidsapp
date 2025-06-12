package de.stadtherne.stadtserver.model;

public class Aktivitaet {
    private String titel;
    //termin fehlt noch
    private Status status; 


    public void liveSetzen() { status.liveSetzen(this); }
    public void abgeschlossenSetzen() { status.abgeschlossenSetzen(this); }
    public void ausstehendSetzen() { status.ausstehendSetzen(this); }
    public void geloeschtSetzen() { status.geloeschtSetzen(this); }
    public void stattfindendSetzen() { status.stattfindendSetzen(this); }
    public void bewertungVerfuegbarSetzen() { status.bewertungVerfuegbarSetzen(this); }
    public void umfrageVerfuegbarSetzen() { status.umfrageVerfuegbarSetzen(this); }
    public void trendingSetzen() { status.trendingSetzen(this); }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
