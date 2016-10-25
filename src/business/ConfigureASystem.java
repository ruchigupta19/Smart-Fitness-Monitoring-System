package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ruchi
 */
public class ConfigureASystem {

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        Date birth = null;
        String birthDate = "30-MAR-2012";
        DateFormat formatter = null;
        try {
            formatter = new SimpleDateFormat("dd-MMM-yyyy");
            birth = (Date) formatter.parse(birthDate);
        } catch (ParseException e) {
            System.out.println("Exception :" + e);
        }
        Employee employee = system.getEmployeeDirectory().createEmployee("Administrator", "Smith Street", "admin@gmail.com", "8596325116", birth, "Male");

        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());

        return system;
    }

}
