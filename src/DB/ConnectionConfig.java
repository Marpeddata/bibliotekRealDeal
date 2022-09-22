package DB;

import Entitet.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {

    private static String pass = null;

    public static Connection getConnection() {

        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/Bibliotek?serverTimezone=CET&allowPublicKeyRetrieval=true&useSSL=false";
        String user = "root";
        String password;

        if (connSwitch("Grycecilie0510")) {
            password = "Grycecilie0510";
        } else {
            password = "elvinha-17";
        }

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static boolean connSwitch(String pass) {

        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/Bibliotek?serverTimezone=CET&allowPublicKeyRetrieval=true&useSSL=false";
        String user = "root";

        String password = pass;

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public static Connection alterConnection() {

        if (pass == null) {
            pass = TerminalIO.getString("angiv password");
        }

        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/Bibliotek?serverTimezone=CET&allowPublicKeyRetrieval=true&useSSL=false";
        String user = "root";
        String password = pass;

        try {

            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return connection;

    }

}


