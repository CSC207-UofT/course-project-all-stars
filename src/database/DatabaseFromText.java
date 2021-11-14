package database;

import java.io.BufferedReader;
import java.io.FileReader;

public class DatabaseFromText implements DatabaseInterface{

    static final String path = "";

    @Override
    public String readData(int row, int column) {
        String relativePath = path;
        BufferedReader br;
        String line;
        int textRow = 0;
        String returnData = " ";
        try{
            br = new BufferedReader(new FileReader(relativePath));
            while((line = br.readLine()) != null){ // Keep reading file until end of line
                String[] values = line.split(","); // Separate parameters from each line using "," as separation
                if (textRow == row){
                    returnData = values[column];
                    return returnData;
                }
                textRow = textRow + 1;
            }
            br.close(); // Close BufferedReader after reading file
        }
        catch (Exception e) {
            return null;
        }
        return returnData;
    }

    @Override
    public boolean rowExist(int row) {
        String relativePath = path;
        BufferedReader br = null;
        int textLine = 0;
        int textIndex = 0;

        try{
            br = new BufferedReader(new FileReader(relativePath));
            while(br.readLine() != null){ // Keep reading file until end of line
                textLine++;
            }
            br.close(); // Close BufferedReader after reading file
            textIndex = textLine - 1;
            if (row > textIndex){
                return false;
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
