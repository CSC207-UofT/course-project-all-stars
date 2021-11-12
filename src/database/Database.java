package database;

interface Database {

    public String retrieveData(int row, int column); // Row = individual object, Column = information within object

    public boolean lastItem(); // Return true if accessing last row (aka last object in the database)

}
