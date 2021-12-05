package cli;

import cli.home.Homepage;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class launch_program {

    public static void main(String[] args) throws SQLException, InvocationTargetException, IllegalAccessException {
        new Homepage();
    }


}
