import DB.Facade;
import Entitet.Bog;
import Entitet.TerminalIO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        List<Bog> bogList = new LinkedList<>();

        while(true) {

            switch (TerminalIO.getString("hvad ønsker du?")){

                case "opret bog":
                    Bog bog = new Bog(TerminalIO.getString("Angiv titel"),TerminalIO.getString("Angiv forfatter"), TerminalIO.getInt("angiv udgivelsesår"));
                    System.out.println("Du har nu oprettet bogen : " + Facade.opretBog(bog).toString());
                    break;

                case "hent bøger":
                    bogList = Facade.hentBøer();
                    udskriv(bogList);
            }
        }


    }
    public static void udskriv(List<Bog> list){
        for (Bog bog : list) {
            System.out.println(bog.toString());
        }
    }

}


