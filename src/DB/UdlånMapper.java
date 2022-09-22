package DB;

import Entitet.Bog;
import Entitet.Låner;
import Entitet.Udlån;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UdlånMapper {
    public static Udlån lånBog(Udlån udlån) throws SQLException {

        String sql = "INSERT INTO lånertabel (bogid , lånerid ) VALUES (?, ?)";

        try (Connection con = ConnectionConfig.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            try {
                ps.setInt(1, udlån.getBogID());
                ps.setInt(2, udlån.getLånerID());
                ps.executeUpdate();


                ResultSet rs = ps.getGeneratedKeys();
                rs.next();

                udlån.setUdlånsID(rs.getInt(1));


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return udlån;
        }

    }

    public static List<Udlån> seUdlån() throws SQLException {

        List<Udlån> udlånList = new LinkedList<>();

        String sql = "Select udlånstabel.udlånsid, lånertabel.lånerid, lånertabel.navn, bogtabel.Title  from lånertabel join udlånstabel on lånertabel.lånerid = udlånstabel.lånerid join bogtabel on  bogtabel.bogid = udlånstabel.bogid;";

        try (Connection con = ConnectionConfig.getConnection();

             PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet resultSet = ps.executeQuery();


            while (resultSet.next()) {
                int udlånsid = resultSet.getInt("udlånsid");
                int lånerid = resultSet.getInt("lånerid");
                String navn = resultSet.getString("navn");
                String title = resultSet.getString("title");

                udlånList.add(new Udlån(udlånsid, lånerid, navn, title));

            }

            return udlånList;

        }

    }

    public static String sletUdlån(int udlånid) throws SQLException {

        String sql = "Delete FROM udlånstabel where udlånsid = ?";

        try (Connection con = ConnectionConfig.getConnection();

             PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setInt(1, udlånid);

            int res = ps.executeUpdate();

            if (res > 0) {

                return "En låner med lånerID " + udlånid + " er blevet slettet";

            }

            return "Kunne ikke finde låneren med id " + udlånid;
        }

    }

}

