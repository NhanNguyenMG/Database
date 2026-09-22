package murach.data;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class UserDB {
    private String dbURL = "jdbc:mysql://localhost:3306/email";
    private String dbUser = "root";
    private String dbPassword = "123456";

    public boolean emailExists(String email) {
        try {
        Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            
        }
        }
    }
}
