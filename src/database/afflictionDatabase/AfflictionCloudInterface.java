package database.afflictionDatabase;

import java.sql.ResultSet;

public interface AfflictionCloudInterface {

    public ResultSet readData();
    /**
     * Method to read data from database on Cloud SQL
     * Format: Id, Name, Address, Sex, Age, Health, Insurance, Symptom A, Symptom B, Symptom C
     *    0       1      2
     * 1 Name  Address  Age
     * 2 Name  Address  Age <-- Reading information row by row
     * @return Result Set from Cloud SQL patientdata database
     */

}
