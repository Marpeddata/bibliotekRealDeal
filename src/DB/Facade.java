package DB;

import Entitet.Bog;

import java.sql.SQLException;

public class Facade {

    public static Bog opretBog(Bog bog) throws SQLException {

        return BogMapper.opretBog(bog);


    }


}
