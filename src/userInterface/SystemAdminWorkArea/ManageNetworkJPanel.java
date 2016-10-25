/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Network.Network;
import business.Validation.MyStringVerifier;
import business.Validation.NotEmptyVerifier;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ruchi
 */
public class ManageNetworkJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private ArrayList<String> countrylist;
    private ArrayList<String> continentList;

    /**
     *
     * Creates new form ManageNetworkJPanel
     */
    public ManageNetworkJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        if (system.getNetworkList().size() < 0) {
            removeNetwork.setEnabled(false);
        } else {
            removeNetwork.setEnabled(true);
        }
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        countrylist = new ArrayList<String>();
        continentList = new ArrayList<>();

        populateNetworkTable();
        comboBoxContinent.removeAllItems();
        comboBoxGeography.removeAllItems();

        Locale locale = Locale.ENGLISH;
        for (String country : Locale.getISOCountries()) {
            countrylist.add((new Locale("", country).getDisplayCountry(locale)));
        }

        continentList.add(new String("Asia"));
        continentList.add(new String("Africa"));
        continentList.add(new String("Antarctica"));
        continentList.add(new String("Australia"));
        continentList.add(new String("Europe"));
        continentList.add(new String("North America"));
        continentList.add(new String("South America"));

        for (String country : countrylist) {
            comboBoxGeography.addItem(country);
        }

        for (String continent : continentList) {
            comboBoxContinent.addItem(continent);
        }
        MyStringVerifier ms = new MyStringVerifier();
        txtNameNetwork.setInputVerifier(ms);

    }

    private void populateNetworkTable() {
        DefaultTableModel model = (DefaultTableModel) networkJTable.getModel();
        int rowCount = networkJTable.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            Object[] row = new Object[4];
            row[0] = network;
            row[1] = network.getGeography();
            row[2] = network.getContinent();
            row[3] = network.getDate();
            model.addRow(row);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DateChooser = new com.toedter.calendar.JDateChooser();
        submitJButton = new javax.swing.JButton();
        comboBoxContinent = new javax.swing.JComboBox();
        comboBoxGeography = new javax.swing.JComboBox();
        txtNameNetwork = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        networkJTable = new javax.swing.JTable();
        removeNetwork = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        backJButton.setText("<< BACK");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 800, 100, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 137, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Country:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 189, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Continent:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Date:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 287, -1, -1));
        add(DateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 287, 230, -1));

        submitJButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, -1, -1));

        comboBoxContinent.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        comboBoxContinent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(comboBoxContinent, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 237, 230, -1));

        comboBoxGeography.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        comboBoxGeography.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(comboBoxGeography, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 186, 230, -1));

        txtNameNetwork.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtNameNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 134, 230, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("NETWORK INFORMATION");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 240, 30));

        networkJTable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        networkJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Country", "Continent", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(networkJTable);
        if (networkJTable.getColumnModel().getColumnCount() > 0) {
            networkJTable.getColumnModel().getColumn(0).setResizable(false);
            networkJTable.getColumnModel().getColumn(1).setResizable(false);
            networkJTable.getColumnModel().getColumn(2).setResizable(false);
            networkJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 503, 1020, 180));

        removeNetwork.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        removeNetwork.setText("Remove");
        removeNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeNetworkActionPerformed(evt);
            }
        });
        add(removeNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 710, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("NETWORK DETAILS");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\ruchi\\Desktop\\Final Project\\Project\\src\\userInterface\\Alien Ink 2560X1600 Abstract Background.jpg")); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1910, 1180));
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed

        String name = txtNameNetwork.getText();
        String geography = (String) comboBoxGeography.getSelectedItem();
        String continent = (String) comboBoxContinent.getSelectedItem();
        Date d1 = DateChooser.getDate();
        if (DateChooser.getDate() == null||continent.isEmpty()||geography.isEmpty()||name.isEmpty()) {
            if(continent.isEmpty()||geography.isEmpty()||name.isEmpty())
            {
                 JOptionPane.showMessageDialog(null, "You cannot leave any field empty");
            }
            else
            {
                 JOptionPane.showMessageDialog(null, "Please choose a date first");
            }
           
        } else {
            Boolean chk = chkForUnique(name);
            if (chk) {
                Network network = system.createAndAddNetwork();
                network.setName(name);
                network.setGeography(geography);
                network.setContinent(continent);
                network.setDate(d1);

                populateNetworkTable();
                txtNameNetwork.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Please enter another name.This name already exists");
            }
        }

    }//GEN-LAST:event_submitJButtonActionPerformed

    private Boolean chkForUnique(String name) {
        int flag = 0;
        for (Network n : system.getNetworkList()) {
            if (n.getName().equals(name)) {
                flag = 1;
            }
        }
        if (flag == 0) {
            return true;
        } else {
            return false;
        }
    }
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void removeNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeNetworkActionPerformed
        int row = networkJTable.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Network n = (Network) networkJTable.getValueAt(row, 0);
        system.removeNetwork(n);
        JOptionPane.showMessageDialog(null, "Network deleted successfully");
        populateNetworkTable();
        
    }//GEN-LAST:event_removeNetworkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox comboBoxContinent;
    private javax.swing.JComboBox comboBoxGeography;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable networkJTable;
    private javax.swing.JButton removeNetwork;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTextField txtNameNetwork;
    // End of variables declaration//GEN-END:variables
}
