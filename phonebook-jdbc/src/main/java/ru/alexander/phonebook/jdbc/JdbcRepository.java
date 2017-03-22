package ru.alexander.phonebook.jdbc;

import ru.alexander.phonebook.entity.PersonalData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Репозиторий, хранящий данные JDBC.
 */
public class JdbcRepository {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/phonebook_database";

    private static final String USER = "phonebook_user";
    private static final String PASSWORD = "password";

    private static final String SQL_INSERT = "INSERT INTO personal_data(\"name\", \"surname\") VALUES (?, ?)";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM personal_data WHERE id = ?";

    public boolean save(final PersonalData pd) {
        Connection con = null;
        boolean result = false;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            final PreparedStatement stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, pd.getName());
            stmt.setString(2, pd.getSurname());
            stmt.executeUpdate();
            stmt.close();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public boolean delete(final long id) {
        Connection con = null;
        boolean result = false;
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            final PreparedStatement stmt = con.prepareStatement(SQL_DELETE_BY_ID);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            stmt.close();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
