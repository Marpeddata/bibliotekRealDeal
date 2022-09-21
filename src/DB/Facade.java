package DB;

import Entitet.Bog;

import java.sql.SQLException;
import java.util.List;

public class Facade {

    public static Bog opretBog(Bog bog) throws SQLException {

        return BogMapper.opretBog(bog);


    }


    public static List<Bog> hentBøer() throws SQLException{

        return BogMapper.hentBøer();
    }
}
