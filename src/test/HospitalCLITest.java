package test;
import database.hospitalDatabase.HospitalDatabaseCloud;
import org.junit.Test;

import java.sql.SQLException;

public class HospitalCLITest {

    @Test
    public void test_selectHospital() throws SQLException {
        HospitalDatabaseCloud database = new HospitalDatabaseCloud();
            assert database.listHospitals().contains("test_hospital");
        }
    }

