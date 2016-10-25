/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.ReceptionistRole;

import Business.Enterprise.Enterprise;
import Business.Organization.ReceptionistOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author ruchi
 */
public class ReceptionistWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ReceptionistOrganization rOrganization;
    private Enterprise enterprise;
    private UserAccount userAccount;

    /**
     * Creates new form ReceptionistWorkAreaJPanelNew
     */
    public ReceptionistWorkAreaJPanel(JPanel upc, UserAccount ua, ReceptionistOrganization o, Enterprise e) {
        initComponents();
        this.userProcessContainer = upc;
        this.rOrganization = o;
        this.enterprise = e;
        this.userAccount = ua;
        valueLabel.setText(userAccount.getEmployee().getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("WELCOME ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valueLabel.setText("<label>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("ROLES AND RESPONSIBLITIES");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 159, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setText("Register A Person with the system");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 238, 277, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setText("View Requests /Process Requests");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 337, 277, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ruchi\\Desktop\\Final Project\\Project\\src\\userInterface\\Alien Ink 2560X1600 Abstract Background.jpg")); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2110, 1230));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ProcessRequestsReceptionist prr = new ProcessRequestsReceptionist(userProcessContainer, userAccount, rOrganization, enterprise);
        userProcessContainer.add("prr", prr);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CreatePatientJPanel cpjp = new CreatePatientJPanel(userProcessContainer, userAccount, rOrganization, enterprise);
        userProcessContainer.add("cpjp", cpjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}