package Entitet;

public class bog {

    private int bogid;
    private String title;
    private String forfatter;


    //constructor fra db til object
    public bog(int bogid, String title, String forfatter) {
        this.bogid = bogid;
        this.title = title;
        this.forfatter = forfatter;
    }

    //constructor fra object til db - ved oprettelse af ny bog eksempelvis.
    public bog(String title, String forfatter) {
        this.title = title;
        this.forfatter = forfatter;
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
}
