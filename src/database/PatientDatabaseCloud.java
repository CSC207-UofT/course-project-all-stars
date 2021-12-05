package database;

import java.sql.*;

public class PatientDatabaseCloud implements DataInterfaceCloud {

    final String url = "jdbc:postgresql://34.121.72.40/hospitals";
    final String user = "postgres";
    final String password = "stocks";

    final String hospital_name;
    public PatientDatabaseCloud(String hospital_name) {
        this.hospital_name = hospital_name;
    }

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

        String sql = "SELECT * FROM " + hospital_name + ".patients";

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
    public void writeData(int id, String name, String address, String sex, int age, int health, boolean insurance,
                                 String symptomA, String symptomB, String symptomC) {

        String sql = "INSERT INTO "+hospital_name+".patients(id, name, address, sex, age, health, insurance, symptom1, " +
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
