package de.stadtherne.stadtserver.model;

public class UmfrageVerfuegbarStatus extends Status {

    @Override
    public void trendingSetzen(Aktivitaet a) {
      a.setStatus(new Trending());
    }

    
}

