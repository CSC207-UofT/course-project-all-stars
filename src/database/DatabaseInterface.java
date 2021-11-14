package database;

public interface DatabaseInterface {
    /**
     * Interface to define the basic layout of methods for different databases
     */

    public String readData(int row, int column);
        /**
         * Method to read data from database based on the row and column.
         * Index for row and column starts at 0.
         * Format: Name, Address, Sex, Age, Health, Insurance, Symptom A, Symptom B, Symptom C
         *    0       1      2
         * 1 Name  Address  Age
         * 2 Name  Address  Age <-- Reading information given a specific row and column
         * @return Data contained within the specified row (object) and column (different information within the object)
         */

    //public void writeData();
        /**
         * Method to write additional data into a new row of the database.
         * Index for row and column starts at 0.
         *    0       1      2
         * 1 Name  Address  Age
         * 2 Name  Address  Age
         * 3 Name  Address  Age <-- New row created to write new information
         * @return void
         */

    public boolean rowExist(int row);
        /**
         * Index for row and column starts at 0. This method is used to check if this is this row exists
         *    0       1      2
         * 1 Name  Address  Age
         * 2 Name  Address  Age
         * 3 Name  Address  Age <-- New row created to write new information
         * 4                    <-- Accessing an invalid row, return False
         * @return False if the row accessed does not exist or does not contain any data
         */

}
