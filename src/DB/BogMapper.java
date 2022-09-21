package DB;

import Entitet.Bog;

import java.sql.*;

public class BogMapper {
    public static Bog opretBog(Bog bog) throws SQLException {

        String sql = "INSERT INTO bogtabel (Forfatter , Title, udgivelsesår ) VALUES (?, ?, ?)";

        try (Connection con = ConnectionConfig.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);)
        {
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
}