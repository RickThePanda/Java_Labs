package by.gsu.pms;

import org.h2.jdbcx.JdbcDataSource;
import org.hsqldb.cmdline.SqlFile;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;

public class JdbcUtil {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            initDb();
        }
        return connection;
    }

    private static void initDb() {
        try {
            final JdbcDataSource dataSource = new JdbcDataSource();
            dataSource.setURL("jdbc:h2:mem:quadrangle");
            dataSource.setUser("sa");
            dataSource.setPassword("sa");
            connection = dataSource.getConnection();

            try (final InputStream is = JdbcUtil.class.getResourceAsStream("/data.sql")) {
                final SqlFile sqlFile = new SqlFile(new InputStreamReader(is), "init", System.out, "UTF-8", false, new File("."));
                sqlFile.setConnection(getConnection());
                sqlFile.execute();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error on initializing DB");
        }
    }
}