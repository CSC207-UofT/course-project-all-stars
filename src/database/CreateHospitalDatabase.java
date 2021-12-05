package database;

import java.sql.*;

public class CreateHospitalDatabase {

    final String url = "jdbc:postgresql://34.121.72.40/hospitals";
    final String user = "postgres";
    final String password = "stocks";

    /**
     * Connect to the postgres sql database on Google Cloud
     */

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * Creates a hospital database on Google CLoud and the corresponding tables
     */

    public void createHospital(String name){

        String hospital = "CREATE schema " + name;
        String patient = "";
        String disease = "";
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(hospital);
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
