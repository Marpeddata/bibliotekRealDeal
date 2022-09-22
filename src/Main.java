import DB.Facade;
import Entitet.Bog;
import Entitet.Låner;
import Entitet.TerminalIO;
import Entitet.Udlån;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class Main {

    public static void main(String[] args) throws SQLException {





        List<Bog> bogList = new LinkedList<>();
        List<Låner> lånerList = new LinkedList<>();
        List<Udlån> udlånList = new LinkedList<>();

        while(true) {

            switch (TerminalIO.getString("hvad ønsker du?")){

                case "opret bog":
                    Bog bog = new Bog(TerminalIO.getString("Angiv titel"),TerminalIO.getString("Angiv forfatter"), TerminalIO.getInt("angiv udgivelsesår"));
                    System.out.println("Du har nu oprettet bogen : " + Facade.opretBog(bog).toString());
                    break;

                case "hent bøger":
                    bogList = Facade.hentBøer();
                    udskrivBog(bogList);
                    break;

                case "slet bog":
                    System.out.println(Facade.sletBog(TerminalIO.getInt("Skriv bogid")));
                    break;

                case "opret låner":
                    Låner låner = new Låner(TerminalIO.getString("Angiv låner navn"),TerminalIO.getString("Angiv låners adresse"), TerminalIO.getInt("angiv låners postnr"));
                    System.out.println("Du har nu oprettet låner : " + Facade.opretLåner(låner).toString());
                    break;

                case "hent lånere":
                    lånerList = Facade.hentLånere();
                    udskrivLåner(lånerList);
                    break;

                case "slet låner":
                    System.out.println(Facade.sletLåner(TerminalIO.getInt("Skriv lånerID")));
                    break;

                case "lån bog":
                    Facade.lånBog(new Udlån(TerminalIO.getInt("Skriv lånerID"),TerminalIO.getInt("Skriv bogID")));
                    break;

                case "se udlån":
                    udlånList = Facade.seUdlån();
                    udskrivUdLån(udlånList);
                    break;

                case "slet udlån":
                    System.out.println(Facade.sletUdlån(TerminalIO.getInt("Skriv udlånid")));
                    break;
            }
        }


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


