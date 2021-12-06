package database.patientDatabase;

import java.sql.*;

/**
 * This is a public class that implements the DataInterfaceCloud interface and reads and writes the data from
 * the hospitals' database hosted on Google Cloud. It takes
 *
 * @author Ratantej
 * @version 2.0
 * @since 1.0
 */

public class PatientDatabaseCloud implements PatientCloudInterface {

    final String url = "jdbc:postgresql://34.121.72.40/hospitals";
    final String user = "postgres";
    final String password = "stocks";

    /**
     * Connect to the postgres sql database on Google Cloud
     */

    @Override
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * Reads patient data and returns a result set
     * @return
     */
    @Override
    public ResultSet readData() {

        String sql = "SELECT * FROM patientdata.patients";

        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    /**
     * Writes patient data onto the database on Cloud SQL
     */
    @Override
    public void writeData(int id, String name, String address, String sex, int age, int health, boolean insurance,
                          String symptomA, String symptomB, String symptomC) {

        String sql = "INSERT INTO patientdata.patients(id, name, address, sex, age, health, insurance, symptom1, " +
                "symptom2, symptom3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            Connection conn = connect();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.setString(2, name);
            stat.setString(3, address);
            stat.setString(4, sex);
            stat.setInt(5, age);
            stat.setInt(6, health);
            stat.setBoolean(7, insurance);
            stat.setString(8, symptomA);
            stat.setString(9, symptomB);
            stat.setString(10, symptomC);
            stat.executeUpdate();

        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
