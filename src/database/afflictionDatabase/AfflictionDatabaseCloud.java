package database.afflictionDatabase;

import java.sql.*;

public class AfflictionDatabaseCloud implements AfflictionCloudInterface {
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
     * Reads patient data and returns a result set
     * @return
     */

    @Override
    public ResultSet readData() {
        String sql = "SELECT * FROM diseasedata.diseases";
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

}
