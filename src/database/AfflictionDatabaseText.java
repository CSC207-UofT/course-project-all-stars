package database;

import java.io.*;

public class AfflictionDatabaseText extends DatabaseFromText{

    public void writeData(String name, int urgencyLevel, int cureTime, String symptom1, String symptom2, String symptom3) {
        String relativePath = "src\\datasets\\Disease.txt";
        try{


            FileWriter fw = new FileWriter(relativePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            fw.write(name + "," + urgencyLevel + "," + cureTime + "," + symptom1 + "," + symptom2 + "," + symptom3);
            fw.close();

        }
        catch (IOException e){
            System.out.println("Unable to write to file");
            e.printStackTrace();
        }

    }

}
