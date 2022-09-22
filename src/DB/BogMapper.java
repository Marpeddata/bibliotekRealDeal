package DB;

import Entitet.Bog;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BogMapper {
    protected static Bog opretBog(Bog bog) throws SQLException {

        String sql = "INSERT INTO bogtabel (Forfatter , Title, udgivelsesår ) VALUES (?, ?, ?)";

        try (Connection con = ConnectionConfig.getConnection();

             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            try {
                ps.setString(1, bog.getForfatter());
                ps.setString(2, bog.getTitle());
                ps.setInt(3, bog.getUdgivelsesår());

                ps.executeUpdate();


                ResultSet rs = ps.getGeneratedKeys();
                rs.next();

                bog.setBogid(rs.getInt(1));


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            return bog;
        }
    }

    protected static List<Bog> hentBøger() throws SQLException {

        List<Bog> bogList = new LinkedList<>();

        String sql = "Select * FROM bogtabel";

        try (Connection con = ConnectionConfig.getConnection();

             PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet resultSet = ps.executeQuery();


            while (resultSet.next()) {
                int idBog = resultSet.getInt("bogid");
                String forfatter = resultSet.getString("forfatter");
                String title = resultSet.getString("title");
                int udgivelsesår = resultSet.getInt("udgivelsesår");

                bogList.add(new Bog(idBog, title, forfatter, udgivelsesår));

            }

            return bogList;

        }
    }

    protected static String sletBog(int bog_id) throws SQLException {

        String sql = "Delete FROM bogtabel where bogid = ?";

        try (Connection con = ConnectionConfig.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setInt(1, bog_id);

            int res = ps.executeUpdate();

            if (res > 0) {

                return "En bog med bog id" + bog_id + "er blevet slettet";

            }

            return "Kunne ikke finde bogen med id" + bog_id;
        }

    }


}
