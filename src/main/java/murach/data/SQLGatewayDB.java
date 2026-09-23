package murach.data;

import java.sql.*;

public class SQLGatewayDB {

    private static String dbURL = "jdbc:mysql://localhost:3306/email";
    private static String dbUser = "root";
    private static String dbPassword = "123456";

    public static String execute(String sqlStatement) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL driver not found", e);
        }

        Connection connection = null;
        Statement statement = null;
        String result;

        try {
            connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            statement = connection.createStatement();

            sqlStatement = sqlStatement.trim();

            if (sqlStatement.toLowerCase().startsWith("select")) {
                ResultSet rs = statement.executeQuery(sqlStatement);
                result = SQLUtil.getHtmlTable(rs);
                DBUtil.closeResultSet(rs);
            } else {
                int rowCount = statement.executeUpdate(sqlStatement);
                result = "<p>The statement executed successfully.<br>"
                        + rowCount + " row(s) affected.</p>";
            }

            return result;

        } finally {
            DBUtil.closeStatement(statement);
            if (connection != null) {
                connection.close();
            }
        }
    }
}