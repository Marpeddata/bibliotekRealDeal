package Dialog;

import DB.Facade;

import java.sql.SQLException;

public class Menu {

    public static void sprogValg() throws SQLException {

        int svar;

        while (true) {
            svar = TerminalIO.getInt("\n Velkommen til biblioteket \n \n" +
                    "1. For at fortsætte på dansk tast 1 \n" +
                    "2. To switch to English press 2 \n");

            switch (svar){

                case 1:
                    menuDansk();
                    break;
                case 2:
                    menuEngelsk();
            }
        }

    }

    public static void menuEngelsk() throws SQLException {

        int svar;

        while (true) {

            svar = TerminalIO.getInt("\n Welcome to the library, how can we help you? \n \n" +
                    "  1. Do you wish to register a new book press 1 \n" +
                    "  2. Do you wish to erase a book press 2 \n" +
                    "  3. Do you wish to view all books press 3 \n" +
                    "  4. Do you wish to register a new user press 4 \n" +
                    "  5. Do you wish to erase a user press 5 \n" +
                    "  6. Do you wish to view all users press 6 \n" +
                    "  7. Do you wish to check out a book press 7 \n" +
                    "  8. Do you wish to return a book press 8 \n" +
                    "  9. Do you wish to view all checked out books press 9 \n " +
                    "10. Do you wish to changes language press 10 \n");

            switch (svar) {

                case 1:
                    Bibliotek.opretBog();
                    break;
                case 2:
                    Bibliotek.sletBog();
                    break;
                case 3:
                    Bibliotek.hentBøger();
                    break;
                case 4:
                    Bibliotek.opretLåner();
                    break;
                case 5:
                    Bibliotek.sletLåner();
                    break;
                case 6:
                    Bibliotek.hentLånere();
                    break;
                case 7:
                    Bibliotek.lånBog();
                    break;
                case 8:
                    Bibliotek.sletUdlån();
                    break;
                case 9:
                    Bibliotek.seUdlån();
                    break;
                case 10:
                    sprogValg();
                    break;
                default:
                    System.out.println("You did not choose one of the given options, try again");
            }
        }
    }


    public static void menuDansk() throws SQLException {

        int svar;

        while (true) {

            svar = TerminalIO.getInt("\n Velkommen til biblioteket, hvad kan vi hjælpe dig med? \n \n" +
                    "  1. Ønsker du at oprette en ny bog tast 1 \n" +
                    "  2. Ønsker du at slette en bog tast 2 \n" +
                    "  3. Ønsker du at se alle bøger tast 3 \n" +
                    "  4. Ønsker du at oprette en ny låner tast 4 \n" +
                    "  5. Ønsker du at slette en låner tast 5 \n" +
                    "  6. Ønsker du at se alle lånere tast 6 \n" +
                    "  7. Ønsker du at låne en bog tast 7 \n" +
                    "  8. Ønsker du at aflevere en bog tast 8 \n" +
                    "  9. Ønsker du at se alle udlånte bøger tast 9 \n " +
                    "10. Ønsker du skifte sprog tast 10 \n");

            switch (svar) {

                case 1:
                    Bibliotek.opretBog();
                    break;
                case 2:
                    Bibliotek.sletBog();
                    break;
                case 3:
                    Bibliotek.hentBøger();
                    break;
                case 4:
                    Bibliotek.opretLåner();
                    break;
                case 5:
                    Bibliotek.sletLåner();
                    break;
                case 6:
                    Bibliotek.hentLånere();
                    break;
                case 7:
                    Bibliotek.lånBog();
                    break;
                case 8:
                    Bibliotek.sletUdlån();
                    break;
                case 9:
                    Bibliotek.seUdlån();
                    break;
                case 10:
                    sprogValg();
                    break;
                default:
                    System.out.println("Du valgte ikke en af de givne muligheder, prøv igen");
            }
        }
    }
}



