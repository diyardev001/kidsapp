package de.stadtherne.stadtserver.model;

public abstract class Fragentyp {

    protected String titel;
    protected String beschreibung;

    public Fragentyp(String titel, String beschreibung) {
        this.titel = titel;
        this.beschreibung = beschreibung;
    }

    public abstract String getTitel();

    public abstract String getBeschreibung();
}
