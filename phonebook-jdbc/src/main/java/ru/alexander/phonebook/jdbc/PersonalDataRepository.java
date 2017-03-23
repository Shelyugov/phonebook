package ru.alexander.phonebook.jdbc;

import ru.alexander.phonebook.entity.PersonalData;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Репозиторий персональных данных. Работает с JDBC.
 */
public class PersonalDataRepository {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/phonebook_database";

    private static final String USER = "phonebook_user";
    private static final String PASSWORD = "password";

    private static final String SQL_SELECT_BY_ID = "SELECT name, surname FROM personal_data WHERE id = ?";
    private static final String SQL_SELECT = "SELECT id, name, surname FROM personal_data";

    private static final String SQL_INSERT = "INSERT INTO personal_data(\"name\", \"surname\") VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE personal_data SET name = ?, surname = ? WHERE id = ?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM personal_data WHERE id = ?";

    /**
     * Создаёт новую запись персональных данных.
     */
    public boolean create(final PersonalData pd) {
        Connection con = null;
        boolean result = false;
        try {
            con = buildConnection();
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

    /**
     * Удаляет запись по идентификатору.
     */
    public boolean delete(final long id) {
        Connection con = null;
        boolean result = false;
        try {
            con = buildConnection();
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

    /**
     * Обновляет запись в базе данных.
     *
     * @param pd экземпляр персональных данных. Должен содержать корректный идентификатор.
     */
    public boolean update(PersonalData pd) {
        Connection con = null;
        boolean result = false;
        try {
            con = buildConnection();
            final PreparedStatement stmt = con.prepareStatement(SQL_UPDATE);
            stmt.setString(1, pd.getName());
            stmt.setString(2, pd.getSurname());
            stmt.setLong(3, pd.getId());

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

    public PersonalData getPersonalData(long id) {
        Connection con = null;
        PersonalData result;
        try {
            con = buildConnection();
            final PreparedStatement stmt = con.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setLong(1, id);
            final ResultSet rs = stmt.executeQuery();
            rs.next();
            result = new PersonalData();
            result.setId(id);
            result.setName(rs.getString("name"));
            result.setSurname(rs.getString("surname"));
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
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


    public List<PersonalData> getAllPersonalData() {
        Connection con = null;
        List<PersonalData> result;
        try {
            con = buildConnection();
            final Statement stmt = con.createStatement();
            final ResultSet rs = stmt.executeQuery(SQL_SELECT);
            result = new LinkedList<>();
            while (rs.next()) {
                PersonalData pd = new PersonalData();
                pd.setId(rs.getLong("id"));
                pd.setName(rs.getString("name"));
                pd.setSurname(rs.getString("surname"));
                result.add(pd);
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = null;
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

    private Connection buildConnection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
