package diagnosis;

import affliction.AfflictionConstructor;
import person.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This is a class that is responsible for diagnosing a patient with a disease.
 *
 * @author Shysta and Roa
 * @version 2.0
 * @since 1.0
 */

public class Diagnosis {
    /**
     * Diagnoses a patient with the disease by matching their symptoms to the symptoms for various diseases.
     */
    public static void diagnose_patient(Patient p) throws SQLException {
        Hashtable<String, ArrayList<String>> disease_data = AfflictionConstructor.disease_data();
        for (String keys : disease_data.keySet()) {
            int i = 0;
            for (String symptoms : p.getSymptoms()) {
                if (disease_data.get(keys).contains(symptoms)) {
                    i += 1;
                }
            }
            if (i == 3) {
                p.setDiagnose(keys);
                break;
            }
        }
        p.setDiagnose("No known disease");
    }
}
