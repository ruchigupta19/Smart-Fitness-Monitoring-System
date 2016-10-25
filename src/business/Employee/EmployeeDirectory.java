/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ruchi
 */
public class EmployeeDirectory {

    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee createEmployee(String name, String Address, String eMailId, String contactNo, Date dateOfBirth, String gender) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAddress(Address);
        employee.seteMailId(eMailId);
        employee.setContactNo(contactNo);
        employee.setDateOfBirth(dateOfBirth);
        employee.setGender(gender);
        employeeList.add(employee);
        return employee;
    }

    public void remove(Employee e) {
        employeeList.remove(e);
    }

}
