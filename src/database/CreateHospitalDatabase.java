package database;

import java.sql.*;

public class CreateHospitalDatabase {

    final String url = "jdbc:postgresql://34.133.180.113/";
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

        String hospital = "CREATE DATABASE " + name;
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
