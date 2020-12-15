import by.gsu.pms.JdbcUtil;
import by.gsu.pms.QuadrangleRepository;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        final QuadrangleRepository repository = new QuadrangleRepository();

        final String trapezoidCoordinates = String.join("\n", repository.getTrapezoidCoordinates());
        System.out.println("Trapezoid coordinates:\n" + trapezoidCoordinates);

        final String parallelogramCoordinates = String.join("\n", repository.getParallelogramCoordinates());
        System.out.println("Parallelogram coordinates:\n" + parallelogramCoordinates);

        JdbcUtil.getConnection().close();
    }
}
