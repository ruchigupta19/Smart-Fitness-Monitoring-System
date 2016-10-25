/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.DeliveryRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author ruchi
 */
public class DeliveryOrganization extends Organization {

    public DeliveryOrganization() {
        super(Organization.Type.Delivery.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DeliveryRole());
        return roles;
    }

}
