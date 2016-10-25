/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TestVitalsWorkRequest;
import Business.WorkQueue.WorkRequest;
import business.VitalSigns.VitalSigns;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.BasicStroke;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author ruchi
 */
public class DoctorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private DoctorOrganization dOrganization;
    private Enterprise enterprise;
    private UserAccount userAccount;

    private String s = "";

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public DoctorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, DoctorOrganization organization, Enterprise enterprise) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.dOrganization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        valueLabel.setText(enterprise.getName());
        valueLabel1.setText(userAccount.getEmployee().getName());
        populateTable();
        btnWtChart.setVisible(false);
        btnSysBpChart.setVisible(false);
        btnDysBpChart.setVisible(false);
        btnChoChart.setVisible(false);
        btnPulseChart.setVisible(false);
        btnBloodSugarChart.setVisible(false);
        btnRespirationChart.setVisible(false);
        BtnBodyTempChart.setVisible(false);
        btnBloodHbChart.setVisible(false);
        btnBloodPhChart.setVisible(false);
        btnHeightChart.setVisible(false);
        btnBmiChart.setVisible(false);
        btnHeartChart.setVisible(false);

        for (WorkRequest request : dOrganization.getWorkQueue().getWorkRequestList()) {
            if (request.getReceiver() == null) {
                playSound();
            }
        }
    }

    private void playSound() {
        try {

            File file = new File("C:/Users/ruchi/Documents/NetBeansProjects/latestnewCompleteProject/src/userInterface/DeliveryRole/youvegotmail.mp3");
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            try {
                Player player = new Player(bis);
                player.play();

            } catch (JavaLayerException ex) {

            }

        } catch (IOException e) {
        }
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (WorkRequest request : dOrganization.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[7];
            row[0] = request;
            row[1] = request.getPatientSender().getEmployee().getName();
            row[2] = request.getReceptionistSender().getEmployee().getName();
            row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[4] = request.getStatus();
            row[5] = request.getVitalSigns();
            row[6] = request.getVitalSigns().getStatus();
            request.setDoctorSender(userAccount);
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

        txtWt2 = new javax.swing.JTextField();
        txtWt1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtAge1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtHr1 = new javax.swing.JTextField();
        txtBmi1 = new javax.swing.JTextField();
        txtHeight1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSysBp1 = new javax.swing.JTextField();
        txtDysBp1 = new javax.swing.JTextField();
        txtCho1 = new javax.swing.JTextField();
        txtPulseR1 = new javax.swing.JTextField();
        txtBloodSugar1 = new javax.swing.JTextField();
        txtRespRate1 = new javax.swing.JTextField();
        txtTemp1 = new javax.swing.JTextField();
        txtBloodHb1 = new javax.swing.JTextField();
        txtBloodPh1 = new javax.swing.JTextField();
        txtSysBp2 = new javax.swing.JTextField();
        txtDysBp2 = new javax.swing.JTextField();
        txtCho2 = new javax.swing.JTextField();
        txtPulseR2 = new javax.swing.JTextField();
        txtBloodSugar2 = new javax.swing.JTextField();
        txtRespRate2 = new javax.swing.JTextField();
        txtTemp2 = new javax.swing.JTextField();
        txtBloodHb2 = new javax.swing.JTextField();
        txtBloodPh2 = new javax.swing.JTextField();
        txtHeight2 = new javax.swing.JTextField();
        txtBmi2 = new javax.swing.JTextField();
        txtHr2 = new javax.swing.JTextField();
        process = new javax.swing.JButton();
        btnWtChart = new javax.swing.JButton();
        btnSysBpChart = new javax.swing.JButton();
        btnDysBpChart = new javax.swing.JButton();
        btnChoChart = new javax.swing.JButton();
        btnPulseChart = new javax.swing.JButton();
        btnBloodSugarChart = new javax.swing.JButton();
        btnRespirationChart = new javax.swing.JButton();
        BtnBodyTempChart = new javax.swing.JButton();
        btnBloodHbChart = new javax.swing.JButton();
        btnBloodPhChart = new javax.swing.JButton();
        btnHeightChart = new javax.swing.JButton();
        btnBmiChart = new javax.swing.JButton();
        btnHeartChart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        btnAssignToMe = new javax.swing.JButton();
        btnViewDetails = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        valueLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        individual = new javax.swing.JButton();
        consolidated = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtWt2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtWt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWt2ActionPerformed(evt);
            }
        });
        add(txtWt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 345, 87, -1));

        txtWt1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtWt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 346, 87, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setText("WEIGHT:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 349, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setText("SYSTOLIC BP:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 390, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("DIASTOLIC BP:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 431, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setText("CHOLESTEROL:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 475, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setText("PULSE RATE:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 516, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel21.setText("BLOOD SUGAR LEVEL:");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 557, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel22.setText("RESPIRATION RATE:");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 598, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setText("BODY TEMPERATURE:");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 639, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel24.setText("BLOOD HAEMOGLOBIN:");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 680, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel26.setText("HEIGHT:");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 762, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel25.setText("BLOOD PH:");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 721, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel27.setText("BMI:");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 803, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel28.setText("HEART RATE:");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 844, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel29.setText("AGE:");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 885, -1, -1));

        txtAge1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtAge1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAge1ActionPerformed(evt);
            }
        });
        add(txtAge1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 882, 89, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setText("years");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 885, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setText("bpm");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 844, -1, -1));

        txtHr1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtHr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 841, 89, -1));

        txtBmi1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBmi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 800, 89, -1));

        txtHeight1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtHeight1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 759, 89, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setText("cms");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 762, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("ph units");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 721, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("g/dl");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 680, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Fahrenhite");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 639, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("breath/min");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 598, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("mg/dl");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 557, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("beats/min");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 516, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("mg/dl");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 475, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("mmHg");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 431, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("mmHg");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 390, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Lbs");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 349, -1, -1));

        txtSysBp1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtSysBp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 387, 87, -1));

        txtDysBp1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDysBp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDysBp1ActionPerformed(evt);
            }
        });
        add(txtDysBp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 428, 87, -1));

        txtCho1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtCho1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 472, 87, -1));

        txtPulseR1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPulseR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPulseR1ActionPerformed(evt);
            }
        });
        add(txtPulseR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 513, 87, -1));

        txtBloodSugar1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodSugar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 554, 87, -1));

        txtRespRate1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtRespRate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespRate1ActionPerformed(evt);
            }
        });
        add(txtRespRate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 595, 87, -1));

        txtTemp1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtTemp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 636, 87, -1));

        txtBloodHb1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodHb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 677, 89, -1));

        txtBloodPh1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodPh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 718, 89, -1));

        txtSysBp2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtSysBp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 386, 87, -1));

        txtDysBp2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDysBp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDysBp2ActionPerformed(evt);
            }
        });
        add(txtDysBp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 427, 87, -1));

        txtCho2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtCho2, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 471, 87, -1));

        txtPulseR2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPulseR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPulseR2ActionPerformed(evt);
            }
        });
        add(txtPulseR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 512, 87, -1));

        txtBloodSugar2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodSugar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 555, 87, -1));

        txtRespRate2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtRespRate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespRate2ActionPerformed(evt);
            }
        });
        add(txtRespRate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 596, 87, -1));

        txtTemp2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtTemp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 637, 87, -1));

        txtBloodHb2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodHb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 678, 87, -1));

        txtBloodPh2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodPh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 719, 89, -1));

        txtHeight2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtHeight2, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 759, 89, -1));

        txtBmi2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBmi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 800, 89, -1));

        txtHr2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtHr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 841, 89, -1));

        process.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        process.setText("Process");
        process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processActionPerformed(evt);
            }
        });
        add(process, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 952, -1, -1));

        btnWtChart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnWtChart.setText("View Weight History ");
        btnWtChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWtChartActionPerformed(evt);
            }
        });
        add(btnWtChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 320, 295, -1));

        btnSysBpChart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSysBpChart.setText("View Systolic Blood Pressure History");
        btnSysBpChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSysBpChartActionPerformed(evt);
            }
        });
        add(btnSysBpChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 380, 295, -1));

        btnDysBpChart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnDysBpChart.setText("View Diastolic Blood Pressure History");
        btnDysBpChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDysBpChartActionPerformed(evt);
            }
        });
        add(btnDysBpChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 430, -1, -1));

        btnChoChart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnChoChart.setText("View Cholesterol History");
        btnChoChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoChartActionPerformed(evt);
            }
        });
        add(btnChoChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 480, 295, -1));

        btnPulseChart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnPulseChart.setText("View Pulse Rate History");
        btnPulseChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPulseChartActionPerformed(evt);
            }
        });
        add(btnPulseChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 530, 295, -1));

        btnBloodSugarChart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBloodSugarChart.setText("View Blood Sugar Level History");
        btnBloodSugarChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloodSugarChartActionPerformed(evt);
            }
        });
        add(btnBloodSugarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 580, 295, -1));

        btnRespirationChart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnRespirationChart.setText("View Respiration Rate History");
        btnRespirationChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRespirationChartActionPerformed(evt);
            }
        });
        add(btnRespirationChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 630, 295, -1));

        BtnBodyTempChart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        BtnBodyTempChart.setText("View Body Temperature History");
        BtnBodyTempChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBodyTempChartActionPerformed(evt);
            }
        });
        add(BtnBodyTempChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 680, 295, -1));

        btnBloodHbChart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBloodHbChart.setText("View Blood Haemoglobin History");
        btnBloodHbChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloodHbChartActionPerformed(evt);
            }
        });
        add(btnBloodHbChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 730, 295, -1));

        btnBloodPhChart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBloodPhChart.setText("View Blood Ph History");
        btnBloodPhChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloodPhChartActionPerformed(evt);
            }
        });
        add(btnBloodPhChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 780, 295, -1));

        btnHeightChart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnHeightChart.setText("View Height History");
        btnHeightChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeightChartActionPerformed(evt);
            }
        });
        add(btnHeightChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 830, 295, -1));

        btnBmiChart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBmiChart.setText("View BMI History");
        btnBmiChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBmiChartActionPerformed(evt);
            }
        });
        add(btnBmiChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 880, 295, -1));

        btnHeartChart.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnHeartChart.setText("View Heart Rate History");
        btnHeartChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHeartChartActionPerformed(evt);
            }
        });
        add(btnHeartChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 930, 295, -1));

        workRequestJTable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Patient", "Receptionist", "Receiver", "Status", "Date on which Vital Sign was recorded", "Body Parameters Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 1170, 97));

        btnAssignToMe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAssignToMe.setText("Assign to me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });
        add(btnAssignToMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 270, 170, -1));

        btnViewDetails.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnViewDetails.setText("View Details ");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });
        add(btnViewDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setText("REQUESTS TABLE:");
        add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel33.setText("Lbs/cm");
        add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 803, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel31.setText("Click here to view the details of the patient");
        add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 314, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel34.setText("Click here to assign the request to yourself");
        add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 314, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("ENTERPRISE:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        valueLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 273, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("DOCTOR:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 40, -1, -1));

        valueLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        valueLabel1.setText("<value>");
        add(valueLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 40, 221, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setText("Predictive Analysis");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 630, 310, -1));

        individual.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        individual.setText("View graph for Individual Parameter");
        individual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                individualActionPerformed(evt);
            }
        });
        add(individual, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 310, -1));

        consolidated.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        consolidated.setText("View Consolidated Graph");
        consolidated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consolidatedActionPerformed(evt);
            }
        });
        add(consolidated, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 530, 310, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setText("Save the graph as PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, 310, -1));

        jLabel30.setIcon(new javax.swing.ImageIcon("C:\\Users\\ruchi\\Desktop\\Final Project\\Project\\src\\userInterface\\Alien Ink 2560X1600 Abstract Background.jpg")); // NOI18N
        add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2180, 1230));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBloodHbChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloodHbChartActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to view its history");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (VitalSigns vs : request.getPatientSender().getEmployee().getVitalSignHistory().getVitalSignList()) {
                dataset.setValue(vs.getBloodHb(), "Blood Haemoglobin", vs.getCurrentDate());
            }
            JFreeChart chart = ChartFactory.createBarChart("Essential Body Parameters Bar Chart", "Timestamp", "Blood Haemoglobin", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Blood Haemoglobin", chart);
            frame.setVisible(true);
            frame.setSize(450, 500);
        }

    }//GEN-LAST:event_btnBloodHbChartActionPerformed

    private void btnRespirationChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRespirationChartActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to view its history");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (VitalSigns vs : request.getPatientSender().getEmployee().getVitalSignHistory().getVitalSignList()) {
                dataset.setValue(vs.getRespiratioRate(), "Respiration Rate", vs.getCurrentDate());
            }
            JFreeChart chart = ChartFactory.createBarChart("Essential Body Parameters Bar Chart", "Timestamp", "Resepiration Rate", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Respiration Rate", chart);
            frame.setVisible(true);
            frame.setSize(450, 500);
        }

    }//GEN-LAST:event_btnRespirationChartActionPerformed

    private void processActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to be processed");
        } else {
            TestVitalsWorkRequest request = (TestVitalsWorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            if (request.getReceiver() != null && !request.getStatus().equals("Completed & Order has been places for medicines")) {
                request.setStatus("Processing by doctor");
                userInterface.DoctorRole.ProcessingDoctorJPanel pdjp = new userInterface.DoctorRole.ProcessingDoctorJPanel(userProcessContainer, userAccount, enterprise, request);
                userProcessContainer.add("pdjp", pdjp);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            } else if (request.getStatus().equals("Completed & Order has been places for medicines")) {
                JOptionPane.showMessageDialog(null, "This request has already been processed and sent to pharmacy");
            } else {
                JOptionPane.showMessageDialog(null, "Please assign the request first");
            }

        }

    }//GEN-LAST:event_processActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        UserAccount uAccont = request.getPatientSender();
        if (selectedRow >= 0) {
            int i = uAccont.getEmployee().getVitalSignHistory().getVitalSignList().size() - 1;
            VitalSigns vs = uAccont.getEmployee().getVitalSignHistory().getVitalSignList().get(i);
            txtWt1.setText(String.valueOf(vs.getWeight()));
            txtSysBp1.setText(String.valueOf(vs.getSysbp()));
            txtHr1.setText(String.valueOf(vs.getHeartRate()));
            txtDysBp1.setText(String.valueOf(vs.getDyspBp()));
            txtAge1.setText(String.valueOf(vs.getAge()));
            txtBmi1.setText(String.valueOf(vs.getBmi()));
            txtHeight1.setText(String.valueOf(vs.getHeight()));
            txtBloodPh1.setText(String.valueOf(vs.getBloodPh()));
            txtBloodHb1.setText(String.valueOf(vs.getBloodPh()));
            txtTemp1.setText(String.valueOf(vs.getBodyTemperature()));
            txtRespRate1.setText(String.valueOf(vs.getRespiratioRate()));
            txtBloodSugar1.setText(String.valueOf(vs.getBloodSugarLevel()));
            txtPulseR1.setText(String.valueOf(vs.getPulseRate()));
            txtCho1.setText(String.valueOf(vs.getCholesterol()));

            if (vs.getAge() >= 10 && vs.getAge() < 20) {

                if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                    txtHeight2.setText("normal");
                    txtHeight2.setBackground(new Color(51, 255, 153));
                    txtWt2.setText("normal");
                    txtWt2.setBackground(new Color(51, 255, 153));
                    txtBmi2.setText("normal");
                    txtBmi2.setBackground(new Color(51, 255, 153));
                } else {
                    txtHeight2.setText("HighRisk");
                    txtWt2.setText("HighRisk");
                    txtBmi2.setText("HighRisk");
                    txtHeight2.setBackground(new Color(255, 180, 180));
                    txtWt2.setBackground(new Color(255, 180, 180));
                    txtBmi2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getSysbp() >= 120 && vs.getSysbp() < 122) {
                    txtSysBp2.setText("normal");
                    txtSysBp2.setBackground(new Color(51, 255, 153));
                } else if (vs.getSysbp() >= 122 && vs.getSysbp() <= 124) {
                    txtSysBp2.setText("moderate");
                    txtSysBp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtSysBp2.setText("HighRisk");
                    txtSysBp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                    txtBloodSugar2.setText("normal");
                    txtBloodSugar2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                    txtBloodSugar2.setText("moderate");
                    txtBloodSugar2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodSugar2.setText("HighRisk");
                    txtBloodSugar2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodHb() >= 11.5 && vs.getBloodHb() <= 15.5) {
                    txtBloodHb2.setText("normal");
                    txtBloodHb2.setBackground(new Color(51, 255, 153));
                } else if (vs.getBloodHb() >= 10 && vs.getBloodHb() < 11.5) {
                    txtBloodHb2.setText("moderate");
                    txtBloodHb2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodHb2.setText("HighRisk");
                    txtBloodHb2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 23) {
                    txtRespRate2.setText("normal");
                    txtRespRate2.setBackground(new Color(51, 255, 153));
                } else if (vs.getRespiratioRate() > 23 && vs.getRespiratioRate() <= 25) {
                    txtRespRate2.setText("Moderate");
                    txtRespRate2.setBackground(new Color(244, 247, 170));
                } else {
                    txtRespRate2.setText("HighRisk");
                    txtRespRate2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getDyspBp() >= 78 && vs.getDyspBp() <= 85) {
                    txtDysBp2.setText("normal");
                    txtDysBp2.setBackground(new Color(51, 255, 153));
                } else if (vs.getDyspBp() >= 76 && vs.getDyspBp() < 78) {
                    txtDysBp2.setText("Moderate");
                    txtDysBp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtDysBp2.setText("HighRisk");
                    txtDysBp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getCholesterol() <= 170) {
                    txtCho2.setText("normal");
                    txtCho2.setBackground(new Color(51, 255, 153));
                } else if (vs.getCholesterol() > 170 && vs.getCholesterol() <= 199) {
                    txtCho2.setText("Moderate");
                    txtCho2.setBackground(new Color(244, 247, 170));
                } else {
                    txtCho2.setText("HighRisk");
                    txtCho2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getPulseRate() >= 100 && vs.getPulseRate() <= 170) {
                    txtPulseR2.setText("normal");
                    txtPulseR2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getPulseRate() > 170 && vs.getPulseRate() <= 180) || (vs.getPulseRate() >= 90 && vs.getPulseRate() < 100)) {
                    txtPulseR2.setText("Moderate");
                    txtPulseR2.setBackground(new Color(244, 247, 170));
                } else {
                    txtPulseR2.setText("HighRisk");
                    txtPulseR2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBodyTemperature() == 98.7) {
                    txtTemp2.setText("normal");
                    txtTemp2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                    txtTemp2.setText("Moderate");
                    txtTemp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtTemp2.setText("HighRisk");
                    txtTemp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                    txtBloodPh2.setText("normal");
                    txtBloodPh2.setBackground(new Color(51, 255, 153));
                } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                    txtBloodPh2.setText("Moderate");
                    txtBloodPh2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodPh2.setText("HighRisk");
                    txtBloodPh2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getHeartRate() >= 80 && vs.getHeartRate() <= 140) {
                    txtHr2.setText("normal");
                    txtHr2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getHeartRate() >= 75 && vs.getHeartRate() < 80) || (vs.getHeartRate() > 141 && vs.getHeartRate() < 150)) {
                    txtHr2.setText("Moderate");
                    txtHr2.setBackground(new Color(244, 247, 170));
                } else {
                    txtHr2.setText("HighRisk");
                    txtHr2.setBackground(new Color(255, 180, 180));
                }
            } else if (vs.getAge() >= 20 && vs.getAge() < 30) {

                if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                    txtHeight2.setText("normal");
                    txtHeight2.setBackground(new Color(51, 255, 153));
                    txtWt2.setText("normal");
                    txtWt2.setBackground(new Color(51, 255, 153));
                    txtBmi2.setText("normal");
                    txtBmi2.setBackground(new Color(51, 255, 153));
                } else {
                    txtHeight2.setText("HighRisk");
                    txtWt2.setText("HighRisk");
                    txtBmi2.setText("HighRisk");
                    txtHeight2.setBackground(new Color(255, 180, 180));
                    txtWt2.setBackground(new Color(255, 180, 180));
                    txtBmi2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getSysbp() >= 120 && vs.getSysbp() < 122) {
                    txtSysBp2.setText("normal");
                    txtSysBp2.setBackground(new Color(51, 255, 153));
                } else if (vs.getSysbp() >= 122 && vs.getSysbp() <= 124) {
                    txtSysBp2.setText("moderate");
                    txtSysBp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtSysBp2.setText("HighRisk");
                    txtSysBp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                    txtBloodSugar2.setText("normal");
                    txtBloodSugar2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                    txtBloodSugar2.setText("moderate");
                    txtBloodSugar2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodSugar2.setText("HighRisk");
                    txtBloodSugar2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                    txtBloodHb2.setText("normal");
                    txtBloodHb2.setBackground(new Color(51, 255, 153));
                } else if (vs.getBloodHb() >= 10 && vs.getBloodHb() < 11.9) {
                    txtBloodHb2.setText("moderate");
                    txtBloodHb2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodHb2.setText("HighRisk");
                    txtBloodHb2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                    txtRespRate2.setText("normal");
                    txtRespRate2.setBackground(new Color(51, 255, 153));
                } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                    txtRespRate2.setText("Moderate");
                    txtRespRate2.setBackground(new Color(244, 247, 170));
                } else {
                    txtRespRate2.setText("HighRisk");
                    txtRespRate2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getDyspBp() >= 80 && vs.getDyspBp() <= 86) {
                    txtDysBp2.setText("normal");
                    txtDysBp2.setBackground(new Color(51, 255, 153));
                } else if (vs.getDyspBp() >= 78 && vs.getDyspBp() < 80) {
                    txtDysBp2.setText("Moderate");
                    txtDysBp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtDysBp2.setText("HighRisk");
                    txtDysBp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                    txtCho2.setText("normal");
                    txtCho2.setBackground(new Color(51, 255, 153));
                } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                    txtCho2.setText("Moderate");
                    txtCho2.setBackground(new Color(244, 247, 170));
                } else {
                    txtCho2.setText("HighRisk");
                    txtCho2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getPulseRate() >= 90 && vs.getPulseRate() <= 162) {
                    txtPulseR2.setText("normal");
                    txtPulseR2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 90) || (vs.getPulseRate() > 162 && vs.getPulseRate() <= 170)) {
                    txtPulseR2.setText("Moderate");
                    txtPulseR2.setBackground(new Color(244, 247, 170));
                } else {
                    txtPulseR2.setText("HighRisk");
                    txtPulseR2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBodyTemperature() == 98.7) {
                    txtTemp2.setText("normal");
                    txtTemp2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                    txtTemp2.setText("Moderate");
                    txtTemp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtTemp2.setText("HighRisk");
                    txtTemp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                    txtBloodPh2.setText("normal");
                    txtBloodPh2.setBackground(new Color(51, 255, 153));
                } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                    txtBloodPh2.setText("Moderate");
                    txtBloodPh2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodPh2.setText("HighRisk");
                    txtBloodPh2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getHeartRate() >= 100 && vs.getHeartRate() <= 162) {
                    txtHr2.setText("normal");
                    txtHr2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getHeartRate() >= 95 && vs.getHeartRate() < 100) || (vs.getHeartRate() > 162 && vs.getHeartRate() < 170)) {
                    txtHr2.setText("Moderate");
                    txtHr2.setBackground(new Color(244, 247, 170));
                } else {
                    txtHr2.setText("HighRisk");
                    txtHr2.setBackground(new Color(255, 180, 180));
                }
            } else if (vs.getAge() >= 30 && vs.getAge() < 40) {

                if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                    txtHeight2.setText("normal");
                    txtHeight2.setBackground(new Color(51, 255, 153));
                    txtWt2.setText("normal");
                    txtWt2.setBackground(new Color(51, 255, 153));
                    txtBmi2.setText("normal");
                    txtBmi2.setBackground(new Color(51, 255, 153));
                } else {
                    txtHeight2.setText("HighRisk");
                    txtWt2.setText("HighRisk");
                    txtBmi2.setText("HighRisk");
                    txtHeight2.setBackground(new Color(255, 180, 180));
                    txtWt2.setBackground(new Color(255, 180, 180));
                    txtBmi2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getSysbp() >= 122 && vs.getSysbp() < 125) {
                    txtSysBp2.setText("normal");
                    txtSysBp2.setBackground(new Color(51, 255, 153));
                } else if (vs.getSysbp() > 125 && vs.getSysbp() <= 127) {
                    txtSysBp2.setText("moderate");
                    txtSysBp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtSysBp2.setText("HighRisk");
                    txtSysBp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                    txtBloodSugar2.setText("normal");
                    txtBloodSugar2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                    txtBloodSugar2.setText("moderate");
                    txtBloodSugar2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodSugar2.setText("HighRisk");
                    txtBloodSugar2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                    txtBloodHb2.setText("normal");
                    txtBloodHb2.setBackground(new Color(51, 255, 153));
                } else if (vs.getBloodHb() >= 10 && vs.getBloodHb() < 11.9) {
                    txtBloodHb2.setText("moderate");
                    txtBloodHb2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodHb2.setText("HighRisk");
                    txtBloodHb2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                    txtRespRate2.setText("normal");
                    txtRespRate2.setBackground(new Color(51, 255, 153));
                } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                    txtRespRate2.setText("Moderate");
                    txtRespRate2.setBackground(new Color(244, 247, 170));
                } else {
                    txtRespRate2.setText("HighRisk");
                    txtRespRate2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getDyspBp() >= 80 && vs.getDyspBp() <= 82) {
                    txtDysBp2.setText("normal");
                    txtDysBp2.setBackground(new Color(51, 255, 153));
                } else if (vs.getDyspBp() >= 78 && vs.getDyspBp() < 80) {
                    txtDysBp2.setText("Moderate");
                    txtDysBp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtDysBp2.setText("HighRisk");
                    txtDysBp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                    txtCho2.setText("normal");
                    txtCho2.setBackground(new Color(51, 255, 153));
                } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                    txtCho2.setText("Moderate");
                    txtCho2.setBackground(new Color(244, 247, 170));
                } else {
                    txtCho2.setText("HighRisk");
                    txtCho2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getPulseRate() >= 85 && vs.getPulseRate() <= 149) {
                    txtPulseR2.setText("normal");
                    txtPulseR2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 85) || (vs.getPulseRate() > 149 && vs.getPulseRate() <= 155)) {
                    txtPulseR2.setText("Moderate");
                    txtPulseR2.setBackground(new Color(244, 247, 170));
                } else {
                    txtPulseR2.setText("HighRisk");
                    txtPulseR2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBodyTemperature() == 98.7) {
                    txtTemp2.setText("normal");
                    txtTemp2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                    txtTemp2.setText("Moderate");
                    txtTemp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtTemp2.setText("HighRisk");
                    txtTemp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                    txtBloodPh2.setText("normal");
                    txtBloodPh2.setBackground(new Color(51, 255, 153));
                } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                    txtBloodPh2.setText("Moderate");
                    txtBloodPh2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodPh2.setText("HighRisk");
                    txtBloodPh2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getHeartRate() >= 95 && vs.getHeartRate() <= 153) {
                    txtHr2.setText("normal");
                    txtHr2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getHeartRate() >= 90 && vs.getHeartRate() < 95) || (vs.getHeartRate() > 153 && vs.getHeartRate() < 160)) {
                    txtHr2.setText("Moderate");
                    txtHr2.setBackground(new Color(244, 247, 170));
                } else {
                    txtHr2.setText("HighRisk");
                    txtHr2.setBackground(new Color(255, 180, 180));
                }
            } else if (vs.getAge() >= 20 && vs.getAge() < 30) {

                if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                    txtHeight2.setText("normal");
                    txtHeight2.setBackground(new Color(51, 255, 153));
                    txtWt2.setText("normal");
                    txtWt2.setBackground(new Color(51, 255, 153));
                    txtBmi2.setText("normal");
                    txtBmi2.setBackground(new Color(51, 255, 153));
                } else {
                    txtHeight2.setText("HighRisk");
                    txtWt2.setText("HighRisk");
                    txtBmi2.setText("HighRisk");
                    txtHeight2.setBackground(new Color(255, 180, 180));
                    txtWt2.setBackground(new Color(255, 180, 180));
                    txtBmi2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getSysbp() >= 120 && vs.getSysbp() < 122) {
                    txtSysBp2.setText("normal");
                    txtSysBp2.setBackground(new Color(51, 255, 153));
                } else if (vs.getSysbp() >= 122 && vs.getSysbp() <= 124) {
                    txtSysBp2.setText("moderate");
                    txtSysBp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtSysBp2.setText("HighRisk");
                    txtSysBp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                    txtBloodSugar2.setText("normal");
                    txtBloodSugar2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                    txtBloodSugar2.setText("moderate");
                    txtBloodSugar2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodSugar2.setText("HighRisk");
                    txtBloodSugar2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                    txtBloodHb2.setText("normal");
                    txtBloodHb2.setBackground(new Color(51, 255, 153));
                } else if (vs.getBloodHb() >= 10 && vs.getBloodHb() < 11.9) {
                    txtBloodHb2.setText("moderate");
                    txtBloodHb2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodHb2.setText("HighRisk");
                    txtBloodHb2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                    txtRespRate2.setText("normal");
                    txtRespRate2.setBackground(new Color(51, 255, 153));
                } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                    txtRespRate2.setText("Moderate");
                    txtRespRate2.setBackground(new Color(244, 247, 170));
                } else {
                    txtRespRate2.setText("HighRisk");
                    txtRespRate2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getDyspBp() >= 80 && vs.getDyspBp() <= 86) {
                    txtDysBp2.setText("normal");
                    txtDysBp2.setBackground(new Color(51, 255, 153));
                } else if (vs.getDyspBp() >= 78 && vs.getDyspBp() < 80) {
                    txtDysBp2.setText("Moderate");
                    txtDysBp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtDysBp2.setText("HighRisk");
                    txtDysBp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                    txtCho2.setText("normal");
                    txtCho2.setBackground(new Color(51, 255, 153));
                } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                    txtCho2.setText("Moderate");
                    txtCho2.setBackground(new Color(244, 247, 170));
                } else {
                    txtCho2.setText("HighRisk");
                    txtCho2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getPulseRate() >= 90 && vs.getPulseRate() <= 162) {
                    txtPulseR2.setText("normal");
                    txtPulseR2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 90) || (vs.getPulseRate() > 162 && vs.getPulseRate() <= 170)) {
                    txtPulseR2.setText("Moderate");
                    txtPulseR2.setBackground(new Color(244, 247, 170));
                } else {
                    txtPulseR2.setText("HighRisk");
                    txtPulseR2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBodyTemperature() == 98.7) {
                    txtTemp2.setText("normal");
                    txtTemp2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                    txtTemp2.setText("Moderate");
                    txtTemp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtTemp2.setText("HighRisk");
                    txtTemp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                    txtBloodPh2.setText("normal");
                    txtBloodPh2.setBackground(new Color(51, 255, 153));
                } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                    txtBloodPh2.setText("Moderate");
                    txtBloodPh2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodPh2.setText("HighRisk");
                    txtBloodPh2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getHeartRate() >= 100 && vs.getHeartRate() <= 162) {
                    txtHr2.setText("normal");
                    txtHr2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getHeartRate() >= 95 && vs.getHeartRate() < 100) || (vs.getHeartRate() > 162 && vs.getHeartRate() < 170)) {
                    txtHr2.setText("Moderate");
                    txtHr2.setBackground(new Color(244, 247, 170));
                } else {
                    txtHr2.setText("HighRisk");
                    txtHr2.setBackground(new Color(255, 180, 180));
                }
            } else if (vs.getAge() >= 40 && vs.getAge() < 50) {

                if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                    txtHeight2.setText("normal");
                    txtHeight2.setBackground(new Color(51, 255, 153));
                    txtWt2.setText("normal");
                    txtWt2.setBackground(new Color(51, 255, 153));
                    txtBmi2.setText("normal");
                    txtBmi2.setBackground(new Color(51, 255, 153));
                } else {
                    txtHeight2.setText("HighRisk");
                    txtWt2.setText("HighRisk");
                    txtBmi2.setText("HighRisk");
                    txtHeight2.setBackground(new Color(255, 180, 180));
                    txtWt2.setBackground(new Color(255, 180, 180));
                    txtBmi2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getSysbp() >= 125 && vs.getSysbp() < 127) {
                    txtSysBp2.setText("normal");
                    txtSysBp2.setBackground(new Color(51, 255, 153));
                } else if (vs.getSysbp() > 127 && vs.getSysbp() <= 130) {
                    txtSysBp2.setText("moderate");
                    txtSysBp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtSysBp2.setText("HighRisk");
                    txtSysBp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                    txtBloodSugar2.setText("normal");
                    txtBloodSugar2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                    txtBloodSugar2.setText("moderate");
                    txtBloodSugar2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodSugar2.setText("HighRisk");
                    txtBloodSugar2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                    txtBloodHb2.setText("normal");
                    txtBloodHb2.setBackground(new Color(51, 255, 153));
                } else if (vs.getBloodHb() >= 10 && vs.getBloodHb() < 11.9) {
                    txtBloodHb2.setText("moderate");
                    txtBloodHb2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodHb2.setText("HighRisk");
                    txtBloodHb2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                    txtRespRate2.setText("normal");
                    txtRespRate2.setBackground(new Color(51, 255, 153));
                } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                    txtRespRate2.setText("Moderate");
                    txtRespRate2.setBackground(new Color(244, 247, 170));
                } else {
                    txtRespRate2.setText("HighRisk");
                    txtRespRate2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getDyspBp() >= 83 && vs.getDyspBp() <= 85) {
                    txtDysBp2.setText("normal");
                    txtDysBp2.setBackground(new Color(51, 255, 153));
                } else if (vs.getDyspBp() >= 80 && vs.getDyspBp() < 83) {
                    txtDysBp2.setText("Moderate");
                    txtDysBp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtDysBp2.setText("HighRisk");
                    txtDysBp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                    txtCho2.setText("normal");
                    txtCho2.setBackground(new Color(51, 255, 153));
                } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                    txtCho2.setText("Moderate");
                    txtCho2.setBackground(new Color(244, 247, 170));
                } else {
                    txtCho2.setText("HighRisk");
                    txtCho2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getPulseRate() >= 85 && vs.getPulseRate() <= 153) {
                    txtPulseR2.setText("normal");
                    txtPulseR2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 85) || (vs.getPulseRate() > 149 && vs.getPulseRate() <= 153)) {
                    txtPulseR2.setText("Moderate");
                    txtPulseR2.setBackground(new Color(244, 247, 170));
                } else {
                    txtPulseR2.setText("HighRisk");
                    txtPulseR2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBodyTemperature() == 98.7) {
                    txtTemp2.setText("normal");
                    txtTemp2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                    txtTemp2.setText("Moderate");
                    txtTemp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtTemp2.setText("HighRisk");
                    txtTemp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                    txtBloodPh2.setText("normal");
                    txtBloodPh2.setBackground(new Color(51, 255, 153));
                } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                    txtBloodPh2.setText("Moderate");
                    txtBloodPh2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodPh2.setText("HighRisk");
                    txtBloodPh2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getHeartRate() >= 90 && vs.getHeartRate() <= 145) {
                    txtHr2.setText("normal");
                    txtHr2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getHeartRate() >= 85 && vs.getHeartRate() < 90) || (vs.getHeartRate() > 145 && vs.getHeartRate() <= 150)) {
                    txtHr2.setText("Moderate");
                    txtHr2.setBackground(new Color(244, 247, 170));
                } else {
                    txtHr2.setText("HighRisk");
                    txtHr2.setBackground(new Color(255, 180, 180));
                }
            } else if (vs.getAge() >= 50 && vs.getAge() < 60) {

                if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                    txtHeight2.setText("normal");
                    txtHeight2.setBackground(new Color(51, 255, 153));
                    txtWt2.setText("normal");
                    txtWt2.setBackground(new Color(51, 255, 153));
                    txtBmi2.setText("normal");
                    txtBmi2.setBackground(new Color(51, 255, 153));
                } else {
                    txtHeight2.setText("HighRisk");
                    txtWt2.setText("HighRisk");
                    txtBmi2.setText("HighRisk");
                    txtHeight2.setBackground(new Color(255, 180, 180));
                    txtWt2.setBackground(new Color(255, 180, 180));
                    txtBmi2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getSysbp() >= 127 && vs.getSysbp() < 129) {
                    txtSysBp2.setText("normal");
                    txtSysBp2.setBackground(new Color(51, 255, 153));
                } else if (vs.getSysbp() > 129 && vs.getSysbp() <= 130) {
                    txtSysBp2.setText("moderate");
                    txtSysBp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtSysBp2.setText("HighRisk");
                    txtSysBp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                    txtBloodSugar2.setText("normal");
                    txtBloodSugar2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                    txtBloodSugar2.setText("moderate");
                    txtBloodSugar2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodSugar2.setText("HighRisk");
                    txtBloodSugar2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                    txtBloodHb2.setText("normal");
                    txtBloodHb2.setBackground(new Color(51, 255, 153));
                } else if (vs.getBloodHb() >= 10 && vs.getBloodHb() < 11.9) {
                    txtBloodHb2.setText("moderate");
                    txtBloodHb2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodHb2.setText("HighRisk");
                    txtBloodHb2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                    txtRespRate2.setText("normal");
                    txtRespRate2.setBackground(new Color(51, 255, 153));
                } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                    txtRespRate2.setText("Moderate");
                    txtRespRate2.setBackground(new Color(244, 247, 170));
                } else {
                    txtRespRate2.setText("HighRisk");
                    txtRespRate2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getDyspBp() >= 85 && vs.getDyspBp() <= 86) {
                    txtDysBp2.setText("normal");
                    txtDysBp2.setBackground(new Color(51, 255, 153));
                } else if (vs.getDyspBp() >= 80 && vs.getDyspBp() < 85) {
                    txtDysBp2.setText("Moderate");
                    txtDysBp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtDysBp2.setText("HighRisk");
                    txtDysBp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                    txtCho2.setText("normal");
                    txtCho2.setBackground(new Color(51, 255, 153));
                } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                    txtCho2.setText("Moderate");
                    txtCho2.setBackground(new Color(244, 247, 170));
                } else {
                    txtCho2.setText("HighRisk");
                    txtCho2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getPulseRate() >= 83 && vs.getPulseRate() <= 140) {
                    txtPulseR2.setText("normal");
                    txtPulseR2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 82) || (vs.getPulseRate() > 130 && vs.getPulseRate() <= 140)) {
                    txtPulseR2.setText("Moderate");
                    txtPulseR2.setBackground(new Color(244, 247, 170));
                } else {
                    txtPulseR2.setText("HighRisk");
                    txtPulseR2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBodyTemperature() == 98.7) {
                    txtTemp2.setText("normal");
                    txtTemp2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                    txtTemp2.setText("Moderate");
                    txtTemp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtTemp2.setText("HighRisk");
                    txtTemp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                    txtBloodPh2.setText("normal");
                    txtBloodPh2.setBackground(new Color(51, 255, 153));
                } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                    txtBloodPh2.setText("Moderate");
                    txtBloodPh2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodPh2.setText("HighRisk");
                    txtBloodPh2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getHeartRate() >= 85 && vs.getHeartRate() <= 136) {
                    txtHr2.setText("normal");
                    txtHr2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getHeartRate() >= 80 && vs.getHeartRate() < 85) || (vs.getHeartRate() > 130 && vs.getHeartRate() <= 136)) {
                    txtHr2.setText("Moderate");
                    txtHr2.setBackground(new Color(244, 247, 170));
                } else {
                    txtHr2.setText("HighRisk");
                    txtHr2.setBackground(new Color(255, 180, 180));
                }
            } else {

                if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                    txtHeight2.setText("normal");
                    txtHeight2.setBackground(new Color(51, 255, 153));
                    txtWt2.setText("normal");
                    txtWt2.setBackground(new Color(51, 255, 153));
                    txtBmi2.setText("normal");
                    txtBmi2.setBackground(new Color(51, 255, 153));
                } else {
                    txtHeight2.setText("HighRisk");
                    txtWt2.setText("HighRisk");
                    txtBmi2.setText("HighRisk");
                    txtHeight2.setBackground(new Color(255, 180, 180));
                    txtWt2.setBackground(new Color(255, 180, 180));
                    txtBmi2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getSysbp() >= 131 && vs.getSysbp() < 134) {
                    txtSysBp2.setText("normal");
                    txtSysBp2.setBackground(new Color(51, 255, 153));
                } else if (vs.getSysbp() > 127 && vs.getSysbp() <= 131) {
                    txtSysBp2.setText("moderate");
                    txtSysBp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtSysBp2.setText("HighRisk");
                    txtSysBp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                    txtBloodSugar2.setText("normal");
                    txtBloodSugar2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                    txtBloodSugar2.setText("moderate");
                    txtBloodSugar2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodSugar2.setText("HighRisk");
                    txtBloodSugar2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                    txtBloodHb2.setText("normal");
                    txtBloodHb2.setBackground(new Color(51, 255, 153));
                } else if (vs.getBloodHb() >= 10 && vs.getBloodHb() < 11.9) {
                    txtBloodHb2.setText("moderate");
                    txtBloodHb2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodHb2.setText("HighRisk");
                    txtBloodHb2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getRespiratioRate() >= 10 && vs.getRespiratioRate() <= 32) {
                    txtRespRate2.setText("normal");
                    txtRespRate2.setBackground(new Color(51, 255, 153));
                } else if (vs.getRespiratioRate() > 32 && vs.getRespiratioRate() <= 35) {
                    txtRespRate2.setText("Moderate");
                    txtRespRate2.setBackground(new Color(244, 247, 170));
                } else {
                    txtRespRate2.setText("HighRisk");
                    txtRespRate2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getDyspBp() >= 85 && vs.getDyspBp() <= 86) {
                    txtDysBp2.setText("normal");
                    txtDysBp2.setBackground(new Color(51, 255, 153));
                } else if (vs.getDyspBp() >= 80 && vs.getDyspBp() < 85) {
                    txtDysBp2.setText("Moderate");
                    txtDysBp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtDysBp2.setText("HighRisk");
                    txtDysBp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                    txtCho2.setText("normal");
                    txtCho2.setBackground(new Color(51, 255, 153));
                } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                    txtCho2.setText("Moderate");
                    txtCho2.setBackground(new Color(244, 247, 170));
                } else {
                    txtCho2.setText("HighRisk");
                    txtCho2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getPulseRate() >= 75 && vs.getPulseRate() <= 132) {
                    txtPulseR2.setText("normal");
                    txtPulseR2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getPulseRate() >= 70 && vs.getPulseRate() < 75) || (vs.getPulseRate() > 132 && vs.getPulseRate() <= 135)) {
                    txtPulseR2.setText("Moderate");
                    txtPulseR2.setBackground(new Color(244, 247, 170));
                } else {
                    txtPulseR2.setText("HighRisk");
                    txtPulseR2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBodyTemperature() == 98.7) {
                    txtTemp2.setText("normal");
                    txtTemp2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                    txtTemp2.setText("Moderate");
                    txtTemp2.setBackground(new Color(244, 247, 170));
                } else {
                    txtTemp2.setText("HighRisk");
                    txtTemp2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                    txtBloodPh2.setText("normal");
                    txtBloodPh2.setBackground(new Color(51, 255, 153));
                } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                    txtBloodPh2.setText("Moderate");
                    txtBloodPh2.setBackground(new Color(244, 247, 170));
                } else {
                    txtBloodPh2.setText("HighRisk");
                    txtBloodPh2.setBackground(new Color(255, 180, 180));
                }
                if (vs.getHeartRate() >= 80 && vs.getHeartRate() <= 128) {
                    txtHr2.setText("normal");
                    txtHr2.setBackground(new Color(51, 255, 153));
                } else if ((vs.getHeartRate() >= 75 && vs.getHeartRate() < 80) || (vs.getHeartRate() > 128 && vs.getHeartRate() <= 135)) {
                    txtHr2.setText("Moderate");
                    txtHr2.setBackground(new Color(244, 247, 170));
                } else {
                    txtHr2.setText("HighRisk");
                    txtHr2.setBackground(new Color(255, 180, 180));
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from the table to be viewed", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void txtDysBp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDysBp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDysBp1ActionPerformed

    private void txtPulseR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPulseR1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPulseR1ActionPerformed

    private void txtRespRate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespRate1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRespRate1ActionPerformed

    private void txtAge1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAge1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAge1ActionPerformed

    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to be assigned");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            if (request.getReceiver() != null) {
                JOptionPane.showMessageDialog(null, "The request has already been assigned to You");

            } else {
                request.setReceiver(userAccount);
                request.setStatus("Pending with doctor");
                populateTable();
                JOptionPane.showMessageDialog(null, "the request has been assigned to u");
            }

        }

    }//GEN-LAST:event_btnAssignToMeActionPerformed

    private void btnDysBpChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDysBpChartActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to view its history");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (VitalSigns vs : request.getPatientSender().getEmployee().getVitalSignHistory().getVitalSignList()) {
                dataset.setValue(vs.getSysbp(), "SysBp", vs.getCurrentDate());
            }
            JFreeChart chart = ChartFactory.createBarChart("Essential Body Parameters Bar Chart", "Timestamp", "Sysbp", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Systolic Bp Graph", chart);
            frame.setVisible(true);
            frame.setSize(450, 500);
        }

    }//GEN-LAST:event_btnDysBpChartActionPerformed

    private void btnWtChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWtChartActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to view its history");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (VitalSigns vs : request.getPatientSender().getEmployee().getVitalSignHistory().getVitalSignList()) {
                dataset.setValue(vs.getWeight(), "Weight", vs.getCurrentDate());
            }
            JFreeChart chart = ChartFactory.createBarChart("Essential Body Parameters Bar Chart", "Timestamp", "Weight", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Weight Graph", chart);
            frame.setVisible(true);
            frame.setSize(450, 500);
        }

    }//GEN-LAST:event_btnWtChartActionPerformed

    private void btnSysBpChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSysBpChartActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to view its history");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (VitalSigns vs : request.getPatientSender().getEmployee().getVitalSignHistory().getVitalSignList()) {
                dataset.setValue(vs.getSysbp(), "Systolic Blood Pressure", vs.getCurrentDate());
            }
            JFreeChart chart = ChartFactory.createBarChart("Essential Body Parameters Bar Chart", "Timestamp", "Systolic Blood Pressure", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Systolic Blood Pressure", chart);
            frame.setVisible(true);
            frame.setSize(450, 500);
        }

    }//GEN-LAST:event_btnSysBpChartActionPerformed

    private void btnChoChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoChartActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to view its history");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (VitalSigns vs : request.getPatientSender().getEmployee().getVitalSignHistory().getVitalSignList()) {
                dataset.setValue(vs.getCholesterol(), "Cholesterol", vs.getCurrentDate());
            }
            JFreeChart chart = ChartFactory.createBarChart("Essential Body Parameters Bar Chart", "Timestamp", "Cholesterol", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Cholesterol", chart);
            frame.setVisible(true);
            frame.setSize(450, 500);
        }

    }//GEN-LAST:event_btnChoChartActionPerformed

    private void btnPulseChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPulseChartActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to view its history");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (VitalSigns vs : request.getPatientSender().getEmployee().getVitalSignHistory().getVitalSignList()) {
                dataset.setValue(vs.getPulseRate(), "Pulse Rate", vs.getCurrentDate());
            }
            JFreeChart chart = ChartFactory.createBarChart("Essential Body Parameters Bar Chart", "Timestamp", "Pulse Rate", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Pulse Rate", chart);
            frame.setVisible(true);
            frame.setSize(450, 500);
        }

    }//GEN-LAST:event_btnPulseChartActionPerformed

    private void btnBloodSugarChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloodSugarChartActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to view its history");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (VitalSigns vs : request.getPatientSender().getEmployee().getVitalSignHistory().getVitalSignList()) {
                dataset.setValue(vs.getBloodSugarLevel(), "Blood Sugar Level", vs.getCurrentDate());
            }
            JFreeChart chart = ChartFactory.createBarChart("Essential Body Parameters Bar Chart", "Timestamp", "Blood Sugar Level", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Blood Suagr Level", chart);
            frame.setVisible(true);
            frame.setSize(450, 500);
        }

    }//GEN-LAST:event_btnBloodSugarChartActionPerformed

    private void BtnBodyTempChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBodyTempChartActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to view its history");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (VitalSigns vs : request.getPatientSender().getEmployee().getVitalSignHistory().getVitalSignList()) {
                dataset.setValue(vs.getBodyTemperature(), "Body Temperature", vs.getCurrentDate());
            }
            JFreeChart chart = ChartFactory.createBarChart("Essential Body Parameters Bar Chart", "Timestamp", "Body Temperature", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Body Temperature", chart);
            frame.setVisible(true);
            frame.setSize(450, 500);
        }

    }//GEN-LAST:event_BtnBodyTempChartActionPerformed

    private void btnBloodPhChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloodPhChartActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to view its history");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (VitalSigns vs : request.getPatientSender().getEmployee().getVitalSignHistory().getVitalSignList()) {
                dataset.setValue(vs.getBloodPh(), "Blood Ph", vs.getCurrentDate());
            }
            JFreeChart chart = ChartFactory.createBarChart("Essential Body Parameters Bar Chart", "Timestamp", "Blood Ph", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Blood Ph", chart);
            frame.setVisible(true);
            frame.setSize(450, 500);
        }

    }//GEN-LAST:event_btnBloodPhChartActionPerformed

    private void btnHeightChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeightChartActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to view its history");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (VitalSigns vs : request.getPatientSender().getEmployee().getVitalSignHistory().getVitalSignList()) {
                dataset.setValue(vs.getHeight(), "Height", vs.getCurrentDate());
            }
            JFreeChart chart = ChartFactory.createBarChart("Essential Body Parameters Bar Chart", "Timestamp", "Height", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("height", chart);
            frame.setVisible(true);
            frame.setSize(450, 500);
        }

    }//GEN-LAST:event_btnHeightChartActionPerformed

    private void btnBmiChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBmiChartActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to view its history");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (VitalSigns vs : request.getPatientSender().getEmployee().getVitalSignHistory().getVitalSignList()) {
                dataset.setValue(vs.getBmi(), "Bmi", vs.getCurrentDate());
            }
            JFreeChart chart = ChartFactory.createBarChart("Essential Body Parameters Bar Chart", "Timestamp", "bmi", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("bmi", chart);
            frame.setVisible(true);
            frame.setSize(450, 500);
        }

    }//GEN-LAST:event_btnBmiChartActionPerformed

    private void btnHeartChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeartChartActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to view its history");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (VitalSigns vs : request.getPatientSender().getEmployee().getVitalSignHistory().getVitalSignList()) {
                dataset.setValue(vs.getHeartRate(), "Heart Rate", vs.getCurrentDate());
            }
            JFreeChart chart = ChartFactory.createBarChart("Essential Body Parameters Bar Chart", "Timestamp", "Heart Rate", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Heart Rate", chart);
            frame.setVisible(true);
            frame.setSize(450, 500);
        }

    }//GEN-LAST:event_btnHeartChartActionPerformed

    private void txtRespRate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespRate2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRespRate2ActionPerformed

    private void txtPulseR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPulseR2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPulseR2ActionPerformed

    private void txtDysBp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDysBp2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDysBp2ActionPerformed

    private void txtWt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWt2ActionPerformed

    }//GEN-LAST:event_txtWt2ActionPerformed

    private void individualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_individualActionPerformed
        btnWtChart.setVisible(true);
        btnSysBpChart.setVisible(true);
        btnDysBpChart.setVisible(true);
        btnChoChart.setVisible(true);
        btnPulseChart.setVisible(true);
        btnBloodSugarChart.setVisible(true);
        btnRespirationChart.setVisible(true);
        BtnBodyTempChart.setVisible(true);
        btnBloodHbChart.setVisible(true);
        btnBloodPhChart.setVisible(true);
        btnHeightChart.setVisible(true);
        btnBmiChart.setVisible(true);
        btnHeartChart.setVisible(true);

    }//GEN-LAST:event_individualActionPerformed

    private void consolidatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consolidatedActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to view its history");
        } else {
            WorkRequest request = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
            TimeSeriesCollection ts = new TimeSeriesCollection();
            TimeSeries object1 = new TimeSeries("Weight");
            TimeSeries object2 = new TimeSeries("Systolic Blood Pressure");
            TimeSeries object3 = new TimeSeries("Diastolic Blood Pressure");
            TimeSeries object4 = new TimeSeries("Cholestrol");
            TimeSeries object5 = new TimeSeries("Pulse Rate");
            TimeSeries object6 = new TimeSeries("Blood Sugar");
            TimeSeries object7 = new TimeSeries("Respiration Rate");
            TimeSeries object8 = new TimeSeries("Body Temperature");
            TimeSeries object9 = new TimeSeries("Blood Haemoglobin");
            TimeSeries object10 = new TimeSeries("Blood Ph");
            TimeSeries object11 = new TimeSeries("Height");
            TimeSeries object12 = new TimeSeries("BMI");
            TimeSeries object13 = new TimeSeries("Heart Rate");
            s = request.getPatientSender().getEmployee().getName();

            for (VitalSigns vs : request.getPatientSender().getEmployee().getVitalSignHistory().getVitalSignList()) {
                double wt = vs.getWeight();
                double sysbp = vs.getSysbp();
                double disBp = vs.getDyspBp();
                double Cho = vs.getCholesterol();
                double pr = vs.getPulseRate();
                double bs = vs.getBloodSugarLevel();
                double rr = vs.getRespiratioRate();
                double temp = vs.getBodyTemperature();
                double hb = vs.getBloodHb();
                double ph = vs.getBloodPh();
                double height = vs.getHeight();
                double bmi = vs.getBmi();
                double hr = vs.getHeartRate();

                object1.add(new Second(vs.getCurrentDate()), wt);
                object2.add(new Second(vs.getCurrentDate()), sysbp);
                object3.add(new Second(vs.getCurrentDate()), disBp);
                object4.add(new Second(vs.getCurrentDate()), Cho);
                object5.add(new Second(vs.getCurrentDate()), pr);
                object6.add(new Second(vs.getCurrentDate()), bs);
                object7.add(new Second(vs.getCurrentDate()), rr);
                object8.add(new Second(vs.getCurrentDate()), temp);
                object9.add(new Second(vs.getCurrentDate()), hb);
                object10.add(new Second(vs.getCurrentDate()), ph);
                object11.add(new Second(vs.getCurrentDate()), height);
                object12.add(new Second(vs.getCurrentDate()), bmi);
                object13.add(new Second(vs.getCurrentDate()), hr);

            }

            ts.addSeries(object1);
            ts.addSeries(object2);
            ts.addSeries(object3);
            ts.addSeries(object4);
            ts.addSeries(object5);
            ts.addSeries(object6);
            ts.addSeries(object7);
            ts.addSeries(object8);
            ts.addSeries(object9);
            ts.addSeries(object10);
            ts.addSeries(object11);
            ts.addSeries(object12);
            ts.addSeries(object13);

            JFreeChart chart = ChartFactory.createTimeSeriesChart("Body Parameters", "TimeStamp", "Parameter Values", ts, true, true, true);
            chart.setBackgroundPaint(Color.white);
            chart.getTitle().setPaint(Color.red);
            XYPlot xy = (XYPlot) chart.getPlot();
            DateAxis da = (DateAxis) xy.getDomainAxis();
            da.setDateFormatOverride(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
            ChartFrame frame = new ChartFrame("Graph for Body Parameters", chart);
            frame.setVisible(true);
            frame.setSize(450, 350);

            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
            xy.setRenderer(renderer);
            renderer.setSeriesPaint(0, Color.red);
            renderer.setSeriesPaint(1, Color.GREEN);
            renderer.setSeriesPaint(2, Color.YELLOW);
            renderer.setSeriesPaint(3, Color.BLUE);
            renderer.setSeriesPaint(4, Color.LIGHT_GRAY);
            renderer.setSeriesPaint(5, Color.cyan);
            renderer.setSeriesPaint(6, Color.PINK);
            renderer.setSeriesPaint(7, Color.WHITE);
            renderer.setSeriesPaint(8, Color.MAGENTA);
            renderer.setSeriesPaint(9, Color.ORANGE);
            renderer.setSeriesPaint(10, Color.GRAY);
            renderer.setSeriesPaint(11, Color.black);
            renderer.setSeriesPaint(12, Color.GREEN);

            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            renderer.setSeriesStroke(1, new BasicStroke(2.0f));
            renderer.setSeriesStroke(2, new BasicStroke(2.0f));
            renderer.setSeriesStroke(3, new BasicStroke(2.0f));
            renderer.setSeriesStroke(4, new BasicStroke(2.0f));
            renderer.setSeriesStroke(5, new BasicStroke(2.0f));
            renderer.setSeriesStroke(6, new BasicStroke(2.0f));
            renderer.setSeriesStroke(7, new BasicStroke(2.0f));
            renderer.setSeriesStroke(8, new BasicStroke(2.0f));
            renderer.setSeriesStroke(9, new BasicStroke(2.0f));
            renderer.setSeriesStroke(10, new BasicStroke(2.0f));
            renderer.setSeriesStroke(11, new BasicStroke(2.0f));
            renderer.setSeriesStroke(12, new BasicStroke(2.0f));

            xy.setRenderer(renderer);
            xy.setBackgroundPaint(Color.GRAY);
            s = request.getPatientSender().getEmployee().getName();
            try {

                final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
                final File file1 = new File(request.getPatientSender().getEmployee().getName() + ".png");
                ChartUtilities.saveChartAsPNG(file1, chart, 600, 400);

            } catch (Exception e) {

            }

        }
    }//GEN-LAST:event_consolidatedActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            createPdf();
            JOptionPane.showMessageDialog(null, "Chart has been saved as " + s + ".pdf to your computer");
        } catch (Exception ex) {
            Logger.getLogger(DoctorWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to be analyzed");
        } else {
                TestVitalsWorkRequest request = (TestVitalsWorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
                userInterface.DoctorRole.AnalysisWorkAreaJPanel analysisWorkAreaJPanel = new userInterface.DoctorRole.AnalysisWorkAreaJPanel(userProcessContainer, userAccount, enterprise, request);
                userProcessContainer.add("analysisWorkAreaJPanel", analysisWorkAreaJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public void createPdf() throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(s + ".pdf"));
        document.open();
        document.add(new Paragraph(new Date().toString()));
        Image image = Image.getInstance(s + ".png");
        document.add(new Paragraph("All Parameters Chart"));
        document.add(image);

        document.close();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBodyTempChart;
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnBloodHbChart;
    private javax.swing.JButton btnBloodPhChart;
    private javax.swing.JButton btnBloodSugarChart;
    private javax.swing.JButton btnBmiChart;
    private javax.swing.JButton btnChoChart;
    private javax.swing.JButton btnDysBpChart;
    private javax.swing.JButton btnHeartChart;
    private javax.swing.JButton btnHeightChart;
    private javax.swing.JButton btnPulseChart;
    private javax.swing.JButton btnRespirationChart;
    private javax.swing.JButton btnSysBpChart;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JButton btnWtChart;
    private javax.swing.JButton consolidated;
    private javax.swing.JButton individual;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton process;
    private javax.swing.JTextField txtAge1;
    private javax.swing.JTextField txtBloodHb1;
    private javax.swing.JTextField txtBloodHb2;
    private javax.swing.JTextField txtBloodPh1;
    private javax.swing.JTextField txtBloodPh2;
    private javax.swing.JTextField txtBloodSugar1;
    private javax.swing.JTextField txtBloodSugar2;
    private javax.swing.JTextField txtBmi1;
    private javax.swing.JTextField txtBmi2;
    private javax.swing.JTextField txtCho1;
    private javax.swing.JTextField txtCho2;
    private javax.swing.JTextField txtDysBp1;
    private javax.swing.JTextField txtDysBp2;
    private javax.swing.JTextField txtHeight1;
    private javax.swing.JTextField txtHeight2;
    private javax.swing.JTextField txtHr1;
    private javax.swing.JTextField txtHr2;
    private javax.swing.JTextField txtPulseR1;
    private javax.swing.JTextField txtPulseR2;
    private javax.swing.JTextField txtRespRate1;
    private javax.swing.JTextField txtRespRate2;
    private javax.swing.JTextField txtSysBp1;
    private javax.swing.JTextField txtSysBp2;
    private javax.swing.JTextField txtTemp1;
    private javax.swing.JTextField txtTemp2;
    private javax.swing.JTextField txtWt1;
    private javax.swing.JTextField txtWt2;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JLabel valueLabel1;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
