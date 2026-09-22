package murach.data;

import java.sql.*;
import murach.business.User;


public class UserDB {
    private static String dbURL = "jdbc:mysql://localhost:3306/email";
    private static String dbUser = "root";
    private static String dbPassword = "123456";

    public static boolean emailExists(String email) throws SQLException {
        String query = "select * from User where email = ?";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);

            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            if(connection != null){
                connection.close();
        }
        }
    }

    public static int insert(User user) throws SQLException {
        String query = "insert into User(Email, FirstName, LastName) values ( ?, ?, ?)";
        Connection connection = null;
        PreparedStatement ps = null;
        try{
            connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            return ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            if(connection != null){
                connection.close();
            }
        }
    }
}
