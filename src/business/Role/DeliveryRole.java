package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DeliveryOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.DeliveryRole.DeliveryWorkAreaJPanel;

/**
 *
 * @author ruchi
 */
public class DeliveryRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new DeliveryWorkAreaJPanel(userProcessContainer, account, (DeliveryOrganization) organization, enterprise);

    }
}
