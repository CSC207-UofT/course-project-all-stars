package database;

import java.sql.ResultSet;

public interface DataInterfaceCloud {
    /**
     * Interface to define the basic layout of methods for different databases using Google Cloud SQL
     * @return
     */

    public ResultSet readData();
    /**
     * Method to read data from database on Cloud SQL
     * Format: Name, Address, Sex, Age, Health, Insurance, Symptom A, Symptom B, Symptom C
     *    0       1      2
     * 1 Name  Address  Age
     * 2 Name  Address  Age <-- Reading information row by row
     * @return Result Set from Cloud SQL patientdata database
     */

}
