package database;

import java.io.*;

public class PatientDatabaseText implements DatabaseInterface{
    @Override
    public String readData(int row, int column) {
        String relativePath = "src\\datasets\\Patient.txt";
        BufferedReader br = null;
        String line = "";
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
    public void writeData(String name, String address, String sex, int age, int health, boolean insurance, String symptomA, String symptomB, String symptomC) {
        String relativePath = "src\\datasets\\Patient.txt";
        try{


            FileWriter fw = new FileWriter(relativePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            fw.write(name + "," + address + "," + sex + "," + age + "," + health + "," + insurance + "," + symptomA + "," + symptomB + "," + symptomC);
            fw.close();

        }
        catch (IOException e){
            System.out.println("Unable to write to file");
            e.printStackTrace();
        }

    }

    @Override
    public boolean rowExist(int row) {
        String relativePath = "src\\datasets\\Patient.txt";
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
