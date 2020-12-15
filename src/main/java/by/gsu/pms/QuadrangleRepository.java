package by.gsu.pms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuadrangleRepository {

    public List<String> getTrapezoidCoordinates() throws SQLException {
        return getCoordinates("SELECT * FROM quadrangle WHERE x3 < x4;");
    }

    public List<String> getParallelogramCoordinates() throws SQLException {
        return getCoordinates("SELECT * FROM quadrangle WHERE x4 - x1 = x3 - x2;");
    }

    private List<String> getCoordinates(final String query) throws SQLException {
        final ArrayList<String> result = new ArrayList<>();
        final ResultSet rs = JdbcUtil.getConnection().createStatement().executeQuery(query);
        while (rs.next()) {
            double x1 = rs.getDouble(1);
            double y1 = rs.getDouble(2);
            double x2 = rs.getDouble(3);
            double y2 = rs.getDouble(4);
            double x3 = rs.getDouble(5);
            double y3 = rs.getDouble(6);
            double x4 = rs.getDouble(7);
            double y4 = rs.getDouble(8);
            result.add(String.format("(%s; %s), (%s; %s), (%s; %s), (%s; %s)", x1, y1, x2, y2, x3, y3, x4, y4));
        }
        return result;
    }
}
