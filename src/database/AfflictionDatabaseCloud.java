package database;

import java.sql.*;

public class AfflictionDatabaseCloud implements DataInterfaceCloud{
    final String url = "jdbc:postgresql://34.133.180.113/diseasedata";
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
        String sql = "SELECT * FROM diseases.diseasedata";
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
