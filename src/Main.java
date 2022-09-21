import DB.Facade;
import Entitet.Bog;
import Entitet.TerminalIO;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        //Bog bog = new Bog("lille ole i Skoven", "ole hansen", 2014);
        //Facade.opretBog(bog);

        while(true) {

            switch (TerminalIO.getString("hvad ønsker du?")){

                case "opret bog":
                    Bog bog = new Bog(TerminalIO.getString("Angiv titel"),TerminalIO.getString("Angiv forfatter"), TerminalIO.getInt("angiv udgivelsesår"));
                    System.out.println("Du har nu oprettet bogen : " + Facade.opretBog(bog).toString());
                    break;
            }
        }
        //Bibliotek.menu();

    }


}


