package cli.home;

import database.hospitalDatabase.HospitalCloudInterface;
import database.hospitalDatabase.HospitalDatabaseCloud;
import hospital.DoctorsFactory;
import hospital.Hospital;
import hospital.PatientsFactory;
import person.Doctor;
import person.Patient;
import priority.Priority;
import priority.PriorityAdmission;
import priority.PriorityTreatment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a public class provides a User Interface to create a new instance of the Hospital class.
 *
 * @author Ratantej
 * @version 2.0
 * @since 1.0
 */
public class CreateHospital {

    public CreateHospital() throws SQLException {

        final String name;
        final int num_patients;

        HospitalCloudInterface database = new HospitalDatabaseCloud();

        System.out.println();
        System.out.println("Enter the Hospital details as follows:");
        System.out.println();
        Scanner option = new Scanner(System.in);
        System.out.println("Enter Name:");
        System.out.println();
        name = option.nextLine();
        System.out.println();
        System.out.println("Enter the number you would like in your hospital:");
        System.out.println();
        num_patients = option.nextInt();
        System.out.println();
        option.nextLine();

        //Initialize Hospital
        ArrayList<Patient> patients = PatientsFactory.createPatients(num_patients);
        ArrayList<Doctor> doctors = DoctorsFactory.createDoctors();

        if(!database.listHospitals().contains(name)) {
            database.createHospital(name);
        }
        else {
            System.out.println("Hospital by this name already exists. Try again.");
            new CreateHospital();
        }

        for(Doctor doctor: doctors){
            database.writeDoctorData(name, doctor);
        }

        for(Patient patient: patients){
            database.writePatientData(name, patient.getId(), patient.getName(), patient.getAddress(),
                    patient.getSex(), patient.getAge(), patient.getHealth(), patient.getInsurance(),
                    patient.getSymptoms().get(0), patient.getSymptoms().get(1), patient.getSymptoms().get(2));
        }

        System.out.println();
        System.out.println("Hospital Created Successfully");
        new Homepage();

    }
}
