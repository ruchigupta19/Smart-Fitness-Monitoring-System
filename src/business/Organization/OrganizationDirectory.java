/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
//import Business.Organization.Organization.Type2;
import java.util.ArrayList;

/**
 *
 * @author ruchi
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type) {
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())) {
            organization = new DoctorOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Intern.getValue())) {
            organization = new InternOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Patient.getValue())) {
            organization = new PatientOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Receptionist.getValue())) {
            organization = new ReceptionistOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.SalesPerson.getValue())) {
            organization = new SalesPersonOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Delivery.getValue())) {
            organization = new DeliveryOrganization();
            organizationList.add(organization);
        }
        return organization;
    }

    public void removeOrganization(Organization o) {
        organizationList.remove(o);
    }

    /**
     * public Organization createPharmacyOrganization(Type2 type2){ Organization
     * organization = null; if
     * (type2.getValue2().equals(Type2.SalesPerson.getValue2())){ organization =
     * new SalesPersonOrganization(); organizationList.add(organization); }
     * return organization; }
     */
}
