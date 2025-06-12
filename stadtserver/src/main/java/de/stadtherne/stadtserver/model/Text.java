
package de.stadtherne.stadtserver.model;

public class Text extends Fragentyp {

    public Text(String titel, String beschreibung) {
        super(titel, beschreibung);
    }

    @Override
    public String getTitel() {
        return this.titel;
    }

    @Override
    public String getBeschreibung() {
        return this.beschreibung;
        
    }


}
