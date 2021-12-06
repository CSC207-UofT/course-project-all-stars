package database.doctorDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DoctorCloudInterface {

    public Connection connect() throws SQLException;

    public ResultSet readData();
    /**
     * Method to read data from database on Cloud SQL
     * Format: Id, Name, Address, Sex, Age, Health, Insurance, Symptom A, Symptom B, Symptom C
     *    0       1      2
     * 1 Name  Address  Age
     * 2 Name  Address  Age <-- Reading information row by row
     * @return Result Set from Cloud SQL patientdata database
     */

    public void writeData(int id, String name, String address, String sex, int age, String specialization);
    /**
     * Method to write data onto the cloud
     */

}
