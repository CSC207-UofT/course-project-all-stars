package cli.hospital;

import database.hospitalDatabase.HospitalCloudInterface;
import database.hospitalDatabase.HospitalDatabaseCloud;
import hospital.DoctorsFactory;
import hospital.Hospital;
import person.Doctor;

import java.util.Scanner;

public class AddDoctor {

    private static Hospital hospital;
    public AddDoctor(Hospital hospital){
        AddDoctor.hospital = hospital;
    }

    public static void addDoctor(){

        HospitalCloudInterface database = new HospitalDatabaseCloud();
        final String name, address, sex, specialization;
        final int id, age;

        System.out.println();
        System.out.println("Enter the doctor details as follows:");
        System.out.println();
        Scanner option = new Scanner(System.in);
        System.out.println("Enter Name:");
        System.out.println();
        name = option.nextLine();
        System.out.println();
        System.out.println("Enter Doctor Id Number:");
        System.out.println();

        int id_temp;
        while (true) {
            option = new Scanner(System.in);
            try {
                id_temp = option.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Not a valid Id Number (Ids must be integers)");
            }
        }
        id = id_temp;
        System.out.println();
        System.out.println("Enter Address:");
        System.out.println();
        address = option.next();
        System.out.println();
        System.out.println("Enter Sex:");
        System.out.println();
        option.nextLine();
        sex = option.next();
        System.out.println();
        System.out.println("Enter Age:");
        System.out.println();

        int age_temp;
        while (true) {
            option = new Scanner(System.in);
            try {
                age_temp = option.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Not a valid age (ages must be integers)");
            }
        }
        age = age_temp;
        System.out.println();
        System.out.println("Enter Specialization from the following [Immunologist, Oncologist, Orthopedist, " +
                "Rheumatologist, Doctor(General), Psychiatrist, Infectious, Cardiologist] :");
        System.out.println();
        option.nextLine();
        specialization = option.nextLine();
        System.out.println();

        Doctor doctor = DoctorsFactory.doctorCreator(specialization, name, address, sex, id, age);
        database.writeDoctorData(hospital.getName(), doctor);
        String message = hospital.hireDoctor(doctor);
        System.out.println(message);
    }

}
