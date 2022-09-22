package Entitet;

public class Låner {

    int lånerId;
    String navn;
    String adresse;
    int postNr;
    String byNavn;

    @Override
    public String toString() {
        return "Låner{" +
                "lånerId=" + lånerId +
                ", navn='" + navn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", postNr=" + postNr +
                ", byNavn='" + byNavn + '\'' +
                '}';
    }

    public Låner(int lånerId, String navn, String adresse, int postNr, String byNavn) {
        this.lånerId = lånerId;
        this.navn = navn;
        this.adresse = adresse;
        this.postNr = postNr;
        this.byNavn = byNavn;
    }

    public Låner(String navn, String adresse, int postNr) {
        this.navn = navn;
        this.adresse = adresse;
        this.postNr = postNr;
    }

    public int getLånerId() {
        return lånerId;
    }

    public void setLånerId(int lånerId) {
        this.lånerId = lånerId;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPostNr() {
        return postNr;
    }

    public void setPostNr(int postNr) {
        this.postNr = postNr;
    }

    public String getByNavn() {
        return byNavn;
    }

    public void setByNavn(String byNavn) {
        this.byNavn = byNavn;
    }
}
