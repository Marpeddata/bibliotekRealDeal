package Entitet;

public class Bog {

    private int bogid;
    private String title;
    private String forfatter;
    private int udgivelsesår;

    public int getUdgivelsesår() {
        return udgivelsesår;
    }

    public void setUdgivelsesår(int udgivelsesår) {
        this.udgivelsesår = udgivelsesår;
    }

    //constructor fra db til object
    public Bog(int bogid, String title, String forfatter, int udgivelsesår) {
        this.bogid = bogid;
        this.title = title;
        this.forfatter = forfatter;
        this.udgivelsesår = udgivelsesår;
    }

    //constructor fra object til db - ved oprettelse af ny bog eksempelvis.
    public Bog(String title, String forfatter, int udgivelsesår) {
        this.title = title;
        this.forfatter = forfatter;
        this.udgivelsesår = udgivelsesår;
    }

    public int getBogid() {
        return bogid;
    }

    public void setBogid(int bogid) {
        this.bogid = bogid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getForfatter() {
        return forfatter;
    }

    public void setForfatter(String forfatter) {
        this.forfatter = forfatter;
    }

    @Override
    public String toString() {
        return "bogid : " + bogid +
                " - title : " + title + '\'' +
                " - forfatter : " + forfatter + '\'' +
                " - udgivelsesår : " + udgivelsesår + '\'';
    }
}
