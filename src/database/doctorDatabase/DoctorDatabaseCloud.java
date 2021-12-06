package database.doctorDatabase;

import database.patientDatabase.PatientCloudInterface;

import java.sql.*;

public class DoctorDatabaseCloud implements DoctorCloudInterface {

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

    @Override
    public ResultSet readData() {

        String sql = "SELECT * FROM doctordata.doctors";

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

    @Override
    public void writeData(int id, String name, String address, String sex, int age, String specialization) {

        String sql = "INSERT INTO patientdata.patients(id, name, address, sex, age, specialization) " +
                "VALUES (?, ?, ?, ?, ?, ?);";

        try {
            Connection conn = connect();
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, id);
            stat.setString(2, name);
            stat.setString(3, address);
            stat.setString(4, sex);
            stat.setInt(5, age);
            stat.setString(6, specialization);
            stat.executeUpdate();

        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }


}
