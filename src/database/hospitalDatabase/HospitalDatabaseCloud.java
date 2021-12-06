package database.hospitalDatabase;

import person.Doctor;

import java.sql.*;
import java.util.ArrayList;

public class HospitalDatabaseCloud implements HospitalCloudInterface{

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
     * Creates a hospital database on Google CLoud and the corresponding tables
     */

    @Override
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

    @Override
    public ResultSet readPatientData(String name){

        String sql = "SELECT * FROM "+name+".patients";

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
    public ResultSet readDoctorData(String hospital_name){

        String sql = "SELECT * FROM "+hospital_name+".doctors";

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
    public void writeDoctorData(String hospital, Doctor doctor){

        int id = doctor.getId();
        String name = doctor.getName();
        String address = doctor.getAddress();
        String sex = doctor.getSex();
        int age = doctor.getAge();
        String specialization = doctor.getSpecialization();

        String sql = "INSERT INTO "+hospital+".doctors(id, name, address, sex, age, specialization) " +
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

    @Override
    public ArrayList<String> listHospitals(){

        String hospital = "SELECT schema_name FROM information_schema.schemata WHERE schema_name NOT LIKE 'pg%' " +
                "AND schema_name NOT LIKE 'information_schema' AND schema_name NOT LIKE 'public' AND schema_name " +
                "NOT LIKE 'patientdata' AND schema_name NOT LIKE 'diseasedata' AND schema_name NOT LIKE 'doctordata' ";
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

    @Override
    public void writePatientData(String hospital_name, int id, String name, String address, String sex, int age,
                                 int health, boolean insurance,
                          String symptomA, String symptomB, String symptomC) {

        String sql = "INSERT INTO "+ hospital_name+".patients(id, name, address, sex, age, health, insurance, " +
                "symptom1, symptom2, symptom3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
