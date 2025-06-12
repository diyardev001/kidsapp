package de.stadtherne.stadtserver.model;

import java.util.ArrayList;
import java.util.List;

public class Umfrage {
    private List<Fragentyp> fragen = new ArrayList<>();

    public void add(Fragentyp frage) { fragen.add(frage); }
    public void remove(Fragentyp frage) { fragen.remove(frage); }
    public Fragentyp getFragentypt(int n) { return fragen.get(n); }
    public List<Fragentyp> getFragentypen() { return fragen; }
}
