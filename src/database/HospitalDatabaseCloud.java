package database;

import java.sql.*;
import java.util.ArrayList;

public class HospitalDatabaseCloud {

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

    public ArrayList<String> listHospitals(){

        String hospital = "SELECT schema_name FROM information_schema.schemata WHERE schema_name NOT LIKE 'pg%' " +
                "AND schema_name NOT LIKE 'information_schema' AND schema_name NOT LIKE 'public' AND schema_name " +
                "NOT LIKE 'pateintdata' AND schema_name NOT LIKE 'diseasedata'";
        ArrayList<String> list_hospitals = new ArrayList<>();
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(hospital);
            while(rs.next()){
                list_hospitals.add(rs.getString(1));
            }
            return list_hospitals;
        }
        catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
