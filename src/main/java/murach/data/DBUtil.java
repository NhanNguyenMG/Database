package murach.data;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBUtil {
    private static final EntityManagerFactory emf = createFactory();

    private static EntityManagerFactory createFactory() {
        Map<String, String> props = new HashMap<>();
        props.put("jakarta.persistence.jdbc.url", getRequiredEnv("DB_URL"));
        props.put("jakarta.persistence.jdbc.user", getRequiredEnv("DB_USER"));
        props.put("jakarta.persistence.jdbc.password", getRequiredEnv("DB_PASSWORD"));
        return Persistence.createEntityManagerFactory("emailListPU", props);
    }

    private static String getRequiredEnv(String name) {
        String value = System.getenv(name);
        if (value == null || value.isEmpty()) {
            throw new IllegalStateException("Missing environment variable: " + name);
        }
        return value;
    }

    public static EntityManagerFactory getEmFactory(){
        return emf;
    }

    public static void closePreparedStatement(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

