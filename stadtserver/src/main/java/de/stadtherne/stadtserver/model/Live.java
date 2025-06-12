package de.stadtherne.stadtserver.model;

public class Live extends Status {
     @Override
    public void abgeschlossenSetzen(Aktivitaet a) {
        a.setStatus(new Abgeschlossen());
        
    }
    
}
