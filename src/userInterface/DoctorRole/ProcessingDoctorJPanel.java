/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PharmacyEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.SalesPersonOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TestVitalsWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import sun.applet.AppletViewer;

/**
 *
 * @author ruchi
 */
public class ProcessingDoctorJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    TestVitalsWorkRequest request;
    private UserAccount userAccount;
    private ArrayList<String> treatmentList;
    private ArrayList<String> treatmentAdded;
    private Enterprise enterprise;

    /**
     * Creates new form ProcessingDoctorJPanel
     */
    public ProcessingDoctorJPanel(JPanel upc, UserAccount ua, Enterprise e, TestVitalsWorkRequest r) {
        initComponents();

        this.userProcessContainer = upc;
        this.request = r;
        this.enterprise = e;
        this.userAccount = ua;
        this.treatmentList = new ArrayList<>();
        this.treatmentAdded = new ArrayList<>();
        treatmentList.add("Ranitidine");
        treatmentList.add("Aspirin");
        treatmentList.add("Multivitamins");
        treatmentList.add("Ibuprofen");
        treatmentList.add("Diclofenac");
        treatmentList.add("Tylenol");
        treatmentList.add("Advil");
        treatmentList.add("hydralyzin");
        treatmentList.add("Mucinex");
        treatmentList.add("Atenolol");
        treatmentList.add("Propanolol");
        treatmentList.add("Acebutanol");
        treatmentList.add("Hydrochlorothiazide");
        treatmentList.add("Furosemide");
        treatmentList.add("Metoprolol");
        treatmentList.add("Captopril");
        treatmentList.add("Metformin");
        treatmentList.add("Omeprazole");
        treatmentList.add("Lipitor");
        treatmentList.add("Glimeperide");
        treatmentList.add("Calpol");
        treatmentList.add("Paracetamol");
        treatmentList.add("Benadryl");
        abnormalParameterComboBox.removeAllItems();
        for (String tl : treatmentList) {
            abnormalParameterComboBox.addItem(tl);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultJTextField1 = new javax.swing.JTextArea();
        submitJButton1 = new javax.swing.JButton();
        abnormalParameterComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        treatmentBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        backJButton.setText("<< BACK");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 770, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Medicines to be taken:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 131, -1, -1));

        resultJTextField1.setColumns(20);
        resultJTextField1.setRows(5);
        jScrollPane1.setViewportView(resultJTextField1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 190, 1058, -1));

        submitJButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        submitJButton1.setText("Submit/Place Order for Medicines");
        submitJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButton1ActionPerformed(evt);
            }
        });
        add(submitJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 290, -1));

        abnormalParameterComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        abnormalParameterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        abnormalParameterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abnormalParameterComboBoxActionPerformed(evt);
            }
        });
        add(abnormalParameterComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 396, 290, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Treatment:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(514, 399, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel3.setText("Select  medicines to be given");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 429, -1, -1));

        treatmentBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        treatmentBtn.setText("Add Medicines to the Prescription");
        treatmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treatmentBtnActionPerformed(evt);
            }
        });
        add(treatmentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 528, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("PROCESSING A REQUEST");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 60, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ruchi\\Desktop\\Final Project\\Project\\src\\userInterface\\Alien Ink 2560X1600 Abstract Background.jpg")); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1870, 1400));

        jLabel6.setText("jLabel6");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1870, 1520));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        UserInterface.DoctorRole.DoctorWorkAreaJPanel dwajp = (UserInterface.DoctorRole.DoctorWorkAreaJPanel) component;
        dwajp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void treatmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treatmentBtnActionPerformed
        String treatMent = (String) abnormalParameterComboBox.getSelectedItem();
        treatmentAdded.add(treatMent);
        addTreatment();
    }//GEN-LAST:event_treatmentBtnActionPerformed

    private void addTreatment() {
        String temp = "";
        for (String s : treatmentAdded) {
            temp = temp + s + "\n" + "\n";

        }

        request.setTestResult(temp);
        resultJTextField1.setText(temp);
        request.setMedicines(temp);
    }
    private void abnormalParameterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abnormalParameterComboBoxActionPerformed

    }//GEN-LAST:event_abnormalParameterComboBoxActionPerformed

    private void submitJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButton1ActionPerformed
        if (!resultJTextField1.getText().isEmpty()) {
            request.setStatus("Completed & Order has been places for medicines");
            resultJTextField1.setText("");
            EcoSystem system = EcoSystem.getInstance();
            Enterprise erp = null;
            for (Network n : system.getNetworkList()) {
                for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                    if (e instanceof PharmacyEnterprise) {
                        erp = e;
                        Organization org = null;
                        for (Organization organization : erp.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof SalesPersonOrganization) {
                                org = organization;
                                break;
                            }
                        }
                        if (org != null) {
                            org.getWorkQueue().getWorkRequestList().add(request);
                            userAccount.getWorkQueue().getWorkRequestList().add(request);
                        }

                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Order of medicines has been placed with pharmacy");
        } else {
            JOptionPane.showMessageDialog(null, "Please write medicines to be prescription");
        }

    }//GEN-LAST:event_submitJButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> abnormalParameterComboBox;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resultJTextField1;
    private javax.swing.JButton submitJButton1;
    private javax.swing.JButton treatmentBtn;
    // End of variables declaration//GEN-END:variables
}
