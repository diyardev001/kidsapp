package de.stadtherne.stadtserver.model;

public class StattfindendStatus extends Status {

    @Override
    public void abgeschlossenSetzen(Aktivitaet a) {
        a.setStatus(new Abgeschlossen());
       
    }

    
}

