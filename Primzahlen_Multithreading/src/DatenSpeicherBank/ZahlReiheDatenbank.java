package DatenSpeicherBank;
import java.sql.*;
import java.util.List;

public class ZahlReiheDatenbank {
    private Connection connection;
    private String tableName;

    public ZahlReiheDatenbank(String dbName, String tableName) {
        this.tableName = tableName;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://" + dbName, "postgres", "123");
            createTableIfNotExists();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (id SERIAL, value BIGINT PRIMARY KEY)";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public void addNumber(long number) {
        String sql = "INSERT INTO " + tableName + " (value) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, number);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNumbers(List<Long> numbers) {
        String sql = "INSERT INTO " + tableName + " (value) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (long number : numbers) {
                statement.setLong(1, number);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long[] getNumbers() {
        String sql = "SELECT value FROM " + tableName;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            int rowCount = getRowCount(resultSet);
            long[] numbers = new long[rowCount];
            int index = 0;

            while (resultSet.next()) {
                numbers[index] = resultSet.getInt("value");
                index++;
            }

            return numbers;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new long[0];
    }

    private int getRowCount(ResultSet resultSet) throws SQLException {
        int rowCount = 0;
        if (resultSet.last()) {
            rowCount = resultSet.getRow();
            resultSet.beforeFirst();
        }
        return rowCount;
    }
}
