package database;

import java.sql.*;

public class PatientDatabaseCloud implements DataInterfaceCloud {

    final String url = "jdbc:postgresql://34.133.180.113/patientdata";
    final String user = "postgres";
    final String password = "stocks";

    /**
     * Connect to the postgres sql database on Google Cloud
     */

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * Reads patient data and returns a result set
     * @return
     */
    @Override
    public ResultSet readData() {

        String sql = "SELECT * FROM patients.patientdata";

        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
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
    public void writeData(String name, String address, String sex, int age, int health, boolean insurance,
                                 String symptomA, String symptomB, String symptomC) {

        String sql = "INSERT INTO patients.patientdata(name, address, sex, age, health, insurance, symptom_1, " +
                "symptom_2, symptom_3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            Connection conn = connect();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, name);
            stat.setString(2, address);
            stat.setString(3, sex);
            stat.setInt(4, age);
            stat.setInt(5, health);
            stat.setBoolean(6, insurance);
            stat.setString(7, symptomA);
            stat.setString(8, symptomB);
            stat.setString(9, symptomC);
            stat.executeUpdate();

        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
