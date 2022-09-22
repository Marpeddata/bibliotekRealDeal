package DB;

import Entitet.Bog;
import Entitet.Låner;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class LånerMapper {

    protected static Låner opretLåner(Låner låner) throws SQLException {

        String sql = "INSERT INTO lånertabel (navn , adresse, postnr ) VALUES (?, ?, ?)";

        try (Connection con = ConnectionConfig.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);)
        {
            try {
                ps.setString(1, låner.getNavn());
                ps.setString(2, låner.getAdresse());
                ps.setInt(3, låner.getPostNr());
                ps.executeUpdate();


                ResultSet rs = ps.getGeneratedKeys();
                rs.next();

                låner.setLånerId(rs.getInt(1));



            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return låner;
        }

    }


    public static List<Låner> hentLånere() throws SQLException {

        List<Låner> lånerList = new LinkedList<>();

        //String sql = "Select * FROM bogtabel";

        String sql = "Select lånertabel.lånerid, lånertabel.navn, lånertabel.adresse, lånertabel.postnr, postnr.bynavn from lånertabel inner join postnr ON lånertabel.postnr = postnr.postnr;";

        try (Connection con = ConnectionConfig.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet resultSet = ps.executeQuery();


            while (resultSet.next()) {
                int lånerId = resultSet.getInt("lånerid");
                String navn = resultSet.getString("navn");
                String adresse = resultSet.getString("adresse");
                int postNr = resultSet.getInt("postnr");
                String byNavn = resultSet.getString("bynavn");

                lånerList.add(new Låner(lånerId, navn, adresse, postNr, byNavn));

            }


            return lånerList;

        }
    }


    public static String sletLåner(int lånerID) throws SQLException{
        String sql = "Delete FROM lånertabel where lånerid = ?";

        try (Connection con = ConnectionConfig.getConnection();

             PreparedStatement ps = con.prepareStatement(sql);){

            ps.setInt(1, lånerID);

            int res = ps.executeUpdate();

            if(res > 0){

                return "En låner med lånerID" + lånerID + "er blevet slettet";

            }

            return "kunn ikke finde låneren med id"+ lånerID;
        }


    }



//        public static String hentByNavn(int postNr) throws SQLException {
//
//            String byNavn;
//
//            String sql = "Select postnr.postnr from lånertabel inner join postnr ON lånertabel.postnr = postnr.postnr where lånertabel.postNr = ?;";
//
//
//
//            try (Connection con = ConnectionConfig.getConnection();  // får en connection
//
//                 // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
//                 PreparedStatement ps = con.prepareStatement(sql)) {
//                ps.setInt(1, postNr);
//
//                ResultSet resultSet = ps.executeQuery();
//
//                byNavn = resultSet.getString("bynavn");
//
//
//
//
//
//            }
//            return byNavn;
//        }


    }

