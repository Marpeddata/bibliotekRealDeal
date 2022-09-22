package DB;

import Entitet.Bog;
import Entitet.Låner;

import java.sql.SQLException;
import java.util.List;

public class Facade {

    public static Bog opretBog(Bog bog) throws SQLException {

        return BogMapper.opretBog(bog);


    }


    public static List<Bog> hentBøer() throws SQLException{

        return BogMapper.hentBøer();
    }

    public static String sletBog(int bog_id) throws SQLException {
        return BogMapper.sletBog(bog_id);
    }

    public static Låner opretLåner(Låner låner) throws SQLException {
        return LånerMapper.opretLåner(låner);
    }

    public static List<Låner> hentLånere() throws SQLException{

        return LånerMapper.hentLånere();
    }


    public static String sletLåner(int lånerID) throws SQLException {
        return LånerMapper.sletLåner(lånerID);
    }
}
