package Dialog;

import DB.Facade;
import Entitet.Bog;
import Entitet.Låner;
import Entitet.Udlån;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Bibliotek {

    static List<Bog> bogList = new LinkedList<>();
    static List<Låner> lånerList = new LinkedList<>();
    static List<Udlån> udlånList = new LinkedList<>();

    public static void opretBog() throws SQLException {
        Bog bog = new Bog(TerminalIO.getString("Indtast bogens titel: "),TerminalIO.getString("Indtast forfatterens navn: "), TerminalIO.getInt("Indtast bogens udgivelsesår: "));
        System.out.println("Du har nu oprettet en ny bog\n" + Facade.opretBog(bog).toString());
    }

    public static void sletBog() throws SQLException {
        System.out.println(Facade.sletBog(TerminalIO.getInt("Skriv ID'et på den bog du ønsker at slette: ")));
    }

    public static void hentBøger() throws SQLException {
        bogList = Facade.hentBøger();
        udskrivBog(bogList);
    }

    public static void opretLåner() throws SQLException {
        Låner låner = new Låner(TerminalIO.getString("Indtast lånerens navn: "),TerminalIO.getString("Indtast lånerens adresse: "), TerminalIO.getInt("Indtast lånerens postnr: "));
        System.out.println("Du har nu oprettet en ny låner\n" + Facade.opretLåner(låner).toString());
    }

    public static void sletLåner() throws SQLException {
        System.out.println(Facade.sletLåner(TerminalIO.getInt("Skriv ID'et på den låner du ønsker at slette: ")));
    }

    public static void hentLånere() throws SQLException {
        lånerList = Facade.hentLånere();
        udskrivLåner(lånerList);
    }

    public static void lånBog() throws SQLException {
        Facade.lånBog(new Udlån(TerminalIO.getInt("Indtast lånerens ID: "),TerminalIO.getInt("Indtast bogens ID: ")));
        System.out.println("Du har nu lånt bogen \nGod læselyst");
    }

    public static void sletUdlån() throws SQLException {
        System.out.println(Facade.sletUdlån(TerminalIO.getInt("Indtast udlånets ID: ")));
    }

    public static void seUdlån() throws SQLException {
        udlånList = Facade.seUdlån();
        udskrivUdLån(udlånList);
    }

    public static void udskrivBog(List<Bog> list){
        for (Bog bog : list) {
            System.out.println(bog.toString());
        }
    }

    public static void udskrivLåner(List<Låner> list){
        for (Låner låner : list) {
            System.out.println(låner.toString());
        }
    }

    public static void udskrivUdLån(List<Udlån> list){
        for (Udlån udlån : list) {
            System.out.println(udlån.toString());
        }
    }
}
