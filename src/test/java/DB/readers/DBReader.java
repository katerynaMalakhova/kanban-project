package DB.readers;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBReader {

    private final static String URL = "jdbc:mariadb://localhost:3306/kanboard?user=kanboard&password=kanboard-secret";
    private final static String USER_NAME = "kanboard";
    private final static String USER_PASSWORD = "kanboard-secret";


    public static Jdbi init() {
        Jdbi jdbi = Jdbi.create(URL);
        jdbi.installPlugin(new SqlObjectPlugin());

        return jdbi;
    }

}