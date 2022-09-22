package Entitet;

public class Udlån {

    int udlånsID;
    int lånerID;
    String lånerNavn;
    int bogID;
    String bogNavn;

    public Udlån(int lånerID, int bogID) {
        this.lånerID = lånerID;
        this.bogID = bogID;
    }

    public Udlån(int udlånsID, int lånerID, String lånerNavn, String bogNavn) {
        this.udlånsID = udlånsID;
        this.lånerID = lånerID;
        this.lånerNavn = lånerNavn;
        this.bogNavn = bogNavn;
    }

    @Override
    public String toString() {
        return "Udlåns ID: " + udlånsID +
                ", Låners ID: " + lånerID +
                ", Låners navn: " + lånerNavn +
                ", Bogens titel: " + bogNavn;
    }

    public int getUdlånsID() {
        return udlånsID;
    }

    public void setUdlånsID(int udlånsID) {
        this.udlånsID = udlånsID;
    }

    public int getLånerID() {
        return lånerID;
    }

    public void setLånerID(int lånerID) {
        this.lånerID = lånerID;
    }

    public String getLånerNavn() {
        return lånerNavn;
    }

    public void setLånerNavn(String lånerNavn) {
        this.lånerNavn = lånerNavn;
    }

    public int getBogID() {
        return bogID;
    }

    public void setBogID(int bogID) {
        this.bogID = bogID;
    }

    public String getBogNavn() {
        return bogNavn;
    }

    public void setBogNavn(String bogNavn) {
        this.bogNavn = bogNavn;
    }
}
