/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import business.VitalSigns.VitalSignsHistory;
import java.util.Date;

/**
 *
 * @author ruchi
 */
public class Employee {

    private String name;
    private static int count = 0;
    private int id;
    private String Address;
    private String eMailId;
    private String contactNo;
    private Date dateOfBirth;
    private String gender;
    private VitalSignsHistory vitalSignHistory;

    public Employee() {
        id = ++count;
        this.vitalSignHistory = new VitalSignsHistory();
    }

    public VitalSignsHistory getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(VitalSignsHistory vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String geteMailId() {
        return eMailId;
    }

    public void seteMailId(String eMailId) {
        this.eMailId = eMailId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

}
