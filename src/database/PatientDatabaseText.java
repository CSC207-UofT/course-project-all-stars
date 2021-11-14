package database;

import java.io.*;

public class PatientDatabaseText extends DatabaseFromText{

    static final String path = "src\\datasets\\Patient.txt";

    public void writeData(String name, String address, String sex, int age, int health, boolean insurance, String symptomA, String symptomB, String symptomC) {
        String relativePath = path;
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

}
