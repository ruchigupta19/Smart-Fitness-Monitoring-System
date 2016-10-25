/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientRole;

import Business.Enterprise.Enterprise;
import Business.Organization.PatientOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.SystemAdminWorkArea.ManageNetworkJPanel;
import business.Validation.MyDoubleVerifier;
import business.Validation.MyNumericVerifier;
import business.VitalSigns.VitalSigns;
import business.VitalSigns.VitalSignsHistory;
import java.awt.CardLayout;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ruchi
 */
public class PatientWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private PatientOrganization organization;
    private Enterprise enterprise;
    private UserAccount account;
    String deviceid="SENSOREDEVICE-IS";

    /**
     * Creates new form PatientWorkAreaJPanel
     */
    public PatientWorkAreaJPanel(JPanel upc, UserAccount a, PatientOrganization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = upc;
        this.organization = organization;
        this.enterprise = enterprise;
        this.account = a;
        valueLabel.setText(account.getEmployee().getName());
        populateTable();
        MyDoubleVerifier wt = new MyDoubleVerifier();
        txtWt.setInputVerifier(wt);
        MyDoubleVerifier diabp = new MyDoubleVerifier();
        txtDysBp.setInputVerifier(diabp);
        MyDoubleVerifier hr = new MyDoubleVerifier();
        txtHr.setInputVerifier(hr);
        MyDoubleVerifier cho = new MyDoubleVerifier();
        txtCho.setInputVerifier(cho);
        MyDoubleVerifier pulse = new MyDoubleVerifier();
        txtPulseR.setInputVerifier(pulse);
        MyDoubleVerifier bloodsugar = new MyDoubleVerifier();
        txtBloodSugar.setInputVerifier(bloodsugar);
        MyDoubleVerifier respr = new MyDoubleVerifier();
        txtRespRate.setInputVerifier(respr);
        MyDoubleVerifier temp = new MyDoubleVerifier();
        txtTemp.setInputVerifier(temp);
        MyDoubleVerifier hb = new MyDoubleVerifier();
        txtBloodHb.setInputVerifier(hb);
        MyDoubleVerifier ph = new MyDoubleVerifier();
        txtBloodPh.setInputVerifier(ph);
        MyDoubleVerifier height = new MyDoubleVerifier();
        txtHeight.setInputVerifier(height);
        MyDoubleVerifier bmi = new MyDoubleVerifier();
        txtBmi.setInputVerifier(bmi);
        MyNumericVerifier age = new MyNumericVerifier();
        txtAge.setInputVerifier(age);
        valueLabel1.setText(enterprise.getName());
        txtWt2.setVisible(false);
        txtSysBp2.setVisible(false);
        txtHr2.setVisible(false);
        txtDysBp2.setVisible(false);
        txtAge2.setVisible(false);
        txtBmi2.setVisible(false);
        txtHeight2.setVisible(false);
        txtBloodPh2.setVisible(false);
        txtBloodHb2.setVisible(false);
        txtTemp2.setVisible(false);
        txtRespRate2.setVisible(false);
        txtBloodSugar2.setVisible(false);
        txtPulseR2.setVisible(false);
        txtCho2.setVisible(false);
        jLabel33.setVisible(false);
        jLabel58.setVisible(false);
        jLabel57.setVisible(false);
        jLabel56.setVisible(false);
        jLabel55.setVisible(false);
        jLabel54.setVisible(false);
        jLabel53.setVisible(false);
        jLabel61.setVisible(false);
        jLabel62.setVisible(false);
        jLabel63.setVisible(false);
        jLabel64.setVisible(false);
        jLabel65.setVisible(false);
        jLabel66.setVisible(false);
        jLabel67.setVisible(false);
        jLabel71.setVisible(false);
        jLabel72.setVisible(false);
        jLabel73.setVisible(false);
        jLabel60.setVisible(false);
        jLabel69.setVisible(false);
        jLabel70.setVisible(false);
        jLabel68.setVisible(false);
        jLabel17.setVisible(false);
        jLabel49.setVisible(false);
        jLabel15.setVisible(false);
        jLabel59.setVisible(false);
        jLabel52.setVisible(false);
        jLabel50.setVisible(false);
        jLabel51.setVisible(false);
        txtViewSens.setVisible(false);
        jLabel79.setVisible(false);
         txtWt2.setEnabled(false);
        txtSysBp2.setEnabled(false);
        txtHr2.setEnabled(false);
        txtDysBp2.setEnabled(false);
        txtAge2.setEnabled(false);
        txtBmi2.setEnabled(false);
        txtHeight2.setEnabled(false);
        txtBloodPh2.setEnabled(false);
        txtBloodHb2.setEnabled(false);
        txtTemp2.setEnabled(false);
        txtRespRate2.setEnabled(false);
        txtBloodSugar2.setEnabled(false);
        txtPulseR2.setEnabled(false);
        txtCho2.setEnabled(false);
      
    }

    private void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) vitalsTable.getModel();
        int rowCount = vitalsTable.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        dtm.setRowCount(0);

        for (VitalSigns vs : account.getEmployee().getVitalSignHistory().getVitalSignList()) {
            Object row[] = new Object[3];
            row[0] = vs;
            row[1] = account.getEmployee().getGender();
            String stat = createStatus(vs);
            row[2] = stat;
            vs.setStatus(stat);
            dtm.addRow(row);
        }
    }

    public String createStatus(VitalSigns vs) {
        String status = "";
        String SysBpstatus = "";
        String DiasBpstatus = "";
        String pulseStatus = "";
        String choStatus = "";
        String resprStatus = "";
        String tempStatus = "";
        String hbStatus = "";
        String pHStatus = "";
        String heightStatus = "";
        String weightStatus = "";
        String bmiStatus = "";
        String heartStatus = "";
        String suagrStatus = "";
        if (vs.getAge() > 10 && vs.getAge() < 20) {

            if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                heightStatus = "normal";
                weightStatus = "normal";
                bmiStatus = "normal";
            } else {
                heightStatus = "HighRisk";
                weightStatus = "HighRisk";
                bmiStatus = "HighRisk";
            }
            if (vs.getSysbp() >= 120 && vs.getSysbp() < 122) {
                SysBpstatus = "normal";
            } else if (vs.getSysbp() >= 122 && vs.getSysbp() <= 124) {
                SysBpstatus = "moderate";
            } else {
                SysBpstatus = "HighRisk";
            }
            if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                suagrStatus = "normal";
            } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                suagrStatus = "moderate";
            } else {
                suagrStatus = "HighRisk";
            }
            if (vs.getBloodHb() >= 11.5 && vs.getBloodHb() <= 15.5) {
                hbStatus = "normal";
            } else if (vs.getBloodHb() >= 10 && vs.getBloodHb() < 11.5) {
                hbStatus = "moderate";
            } else {
                hbStatus = "HighRisk";
            }
            if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 23) {
                resprStatus = "normal";
            } else if (vs.getRespiratioRate() > 23 && vs.getRespiratioRate() <= 25) {
                resprStatus = "moderate";
            } else {
                resprStatus = "HighRisk";
            }
            if (vs.getDyspBp() >= 78 && vs.getDyspBp() <= 85) {
                DiasBpstatus = "normal";
            } else if (vs.getDyspBp() >= 76 && vs.getDyspBp() < 78) {
                DiasBpstatus = "Moderate";
            } else {
                DiasBpstatus = "High Risk";
            }
            if (vs.getCholesterol() <= 170) {
                choStatus = "normal";
            } else if (vs.getCholesterol() > 170 && vs.getCholesterol() <= 199) {
                choStatus = "Moderate";
            } else {
                choStatus = "HighRisk";
            }
            if (vs.getPulseRate() >= 100 && vs.getPulseRate() <= 170) {
                pulseStatus = "normal";
            } else if ((vs.getPulseRate() > 170 && vs.getPulseRate() <= 180) || (vs.getPulseRate() >= 90 && vs.getPulseRate() < 100)) {
                pulseStatus = "moderate";
            } else {
                pulseStatus = "HighRisk";
            }
            if (vs.getBodyTemperature() == 98.7) {
                tempStatus = "normal";
            } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                tempStatus = "moderate";
            } else {
                tempStatus = "HighRisk";
            }
            if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                pHStatus = "normal";
            } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                pHStatus = "Moderate";
            } else {
                pHStatus = "HighRisk";
            }
            if (vs.getHeartRate() >= 80 && vs.getHeartRate() <= 140) {
                heartStatus = "normal";
            } else if ((vs.getHeartRate() >= 75 && vs.getHeartRate() < 80) || (vs.getHeartRate() > 141 && vs.getHeartRate() < 150)) {
                heartStatus = "Moderate";
            } else {
                heartStatus = "HighRisk";
            }
        } else if (vs.getAge() > 20 && vs.getAge() < 30) {

            if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                heightStatus = "normal";
                weightStatus = "normal";
                bmiStatus = "normal";
            } else {
                heightStatus = "HighRisk";
                weightStatus = "HighRisk";
                bmiStatus = "HighRisk";
            }
            if (vs.getSysbp() >= 120 && vs.getSysbp() < 122) {
                SysBpstatus = "normal";
            } else if (vs.getSysbp() >= 122 && vs.getSysbp() <= 124) {
                SysBpstatus = "moderate";
            } else {
                SysBpstatus = "HighRisk";
            }
            if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                suagrStatus = "normal";
            } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                suagrStatus = "moderate";
            } else {
                suagrStatus = "HighRisk";
            }
            if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                hbStatus = "normal";
            } else if (vs.getBloodHb() >= 10 & vs.getBloodHb() < 11.9) {
                hbStatus = "moderate";
            } else {
                hbStatus = "HighRisk";
            }
            if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                resprStatus = "normal";
            } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                resprStatus = "moderate";
            } else {
                resprStatus = "HighRisk";
            }
            if (vs.getDyspBp() >= 80 && vs.getDyspBp() <= 86) {
                DiasBpstatus = "normal";
            } else if (vs.getDyspBp() >= 78 && vs.getDyspBp() < 80) {
                DiasBpstatus = "Moderate";
            } else {
                DiasBpstatus = "High Risk";
            }
            if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                choStatus = "normal";
            } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                choStatus = "Moderate";
            } else {
                choStatus = "HighRisk";
            }
            if (vs.getPulseRate() >= 90 && vs.getPulseRate() <= 162) {
                pulseStatus = "normal";
            } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 90) || (vs.getPulseRate() > 162 && vs.getPulseRate() <= 170)) {
                pulseStatus = "moderate";
            } else {
                pulseStatus = "HighRisk";
            }
            if (vs.getBodyTemperature() == 98.7) {
                tempStatus = "normal";
            } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                tempStatus = "moderate";
            } else {
                tempStatus = "HighRisk";
            }
            if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                pHStatus = "normal";
            } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                pHStatus = "Moderate";
            } else {
                pHStatus = "HighRisk";
            }
            if (vs.getHeartRate() >= 100 && vs.getHeartRate() <= 162) {
                heartStatus = "normal";
            } else if ((vs.getHeartRate() >= 95 && vs.getHeartRate() < 100) || (vs.getHeartRate() > 162 && vs.getHeartRate() < 170)) {
                heartStatus = "Moderate";
            } else {
                heartStatus = "HighRisk";
            }
        } else if (vs.getAge() > 30 && vs.getAge() < 40) {

            if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                heightStatus = "normal";
                weightStatus = "normal";
                bmiStatus = "normal";
            } else {
                heightStatus = "HighRisk";
                weightStatus = "HighRisk";
                bmiStatus = "HighRisk";
            }
            if (vs.getSysbp() >= 122 && vs.getSysbp() < 125) {
                SysBpstatus = "normal";
            } else if (vs.getSysbp() > 125 && vs.getSysbp() <= 127) {
                SysBpstatus = "moderate";
            } else {
                SysBpstatus = "HighRisk";
            }
            if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                suagrStatus = "normal";
            } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                suagrStatus = "moderate";
            } else {
                suagrStatus = "HighRisk";
            }
            if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                hbStatus = "normal";
            } else if (vs.getBloodHb() >= 10 & vs.getBloodHb() < 11.9) {
                hbStatus = "moderate";
            } else {
                hbStatus = "HighRisk";
            }
            if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                resprStatus = "normal";
            } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                resprStatus = "moderate";
            } else {
                resprStatus = "HighRisk";
            }
            if (vs.getDyspBp() >= 80 && vs.getDyspBp() <= 82) {
                DiasBpstatus = "normal";
            } else if (vs.getDyspBp() >= 78 && vs.getDyspBp() < 80) {
                DiasBpstatus = "Moderate";
            } else {
                DiasBpstatus = "HighRisk";
            }
            if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                choStatus = "normal";
            } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                choStatus = "Moderate";
            } else {
                choStatus = "HighRisk";
            }
            if (vs.getPulseRate() >= 85 && vs.getPulseRate() <= 149) {
                pulseStatus = "normal";
            } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 85) || (vs.getPulseRate() > 149 && vs.getPulseRate() <= 155)) {
                pulseStatus = "moderate";
            } else {
                pulseStatus = "HighRisk";
            }
            if (vs.getBodyTemperature() == 98.7) {
                tempStatus = "normal";
            } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                tempStatus = "moderate";
            } else {
                tempStatus = "HighRisk";
            }
            if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                pHStatus = "normal";
            } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                pHStatus = "Moderate";
            } else {
                pHStatus = "HighRisk";
            }
            if (vs.getHeartRate() >= 95 && vs.getHeartRate() <= 153) {
                heartStatus = "normal";
            } else if ((vs.getHeartRate() >= 90 && vs.getHeartRate() < 95) || (vs.getHeartRate() > 153 && vs.getHeartRate() < 160)) {
                heartStatus = "Moderate";
            } else {
                heartStatus = "HighRisk";
            }
        } else if (vs.getAge() > 40 && vs.getAge() < 50) {

            if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                heightStatus = "normal";
                weightStatus = "normal";
                bmiStatus = "normal";
            } else {
                heightStatus = "HighRisk";
                weightStatus = "HighRisk";
                bmiStatus = "HighRisk";
            }
            if (vs.getSysbp() >= 125 && vs.getSysbp() < 127) {
                SysBpstatus = "normal";
            } else if (vs.getSysbp() > 127 && vs.getSysbp() <= 130) {
                SysBpstatus = "moderate";
            } else {
                SysBpstatus = "HighRisk";
            }
            if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                suagrStatus = "normal";
            } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                suagrStatus = "moderate";
            } else {
                suagrStatus = "HighRisk";
            }
            if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                hbStatus = "normal";
            } else if (vs.getBloodHb() >= 10 & vs.getBloodHb() < 11.9) {
                hbStatus = "moderate";
            } else {
                hbStatus = "HighRisk";
            }
            if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                resprStatus = "normal";
            } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                resprStatus = "moderate";
            } else {
                resprStatus = "HighRisk";
            }
            if (vs.getDyspBp() >= 83 && vs.getDyspBp() <= 85) {
                DiasBpstatus = "normal";
            } else if (vs.getDyspBp() >= 80 && vs.getDyspBp() < 83) {
                DiasBpstatus = "Moderate";
            } else {
                DiasBpstatus = "HighRisk";
            }
            if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                choStatus = "normal";
            } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                choStatus = "Moderate";
            } else {
                choStatus = "HighRisk";
            }
            if (vs.getPulseRate() >= 85 && vs.getPulseRate() <= 153) {
                pulseStatus = "normal";
            } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 85) || (vs.getPulseRate() > 149 && vs.getPulseRate() <= 153)) {
                pulseStatus = "moderate";
            } else {
                pulseStatus = "HighRisk";
            }
            if (vs.getBodyTemperature() == 98.7) {
                tempStatus = "normal";
            } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                tempStatus = "moderate";
            } else {
                tempStatus = "HighRisk";
            }
            if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                pHStatus = "normal";
            } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                pHStatus = "Moderate";
            } else {
                pHStatus = "HighRisk";
            }
            if (vs.getHeartRate() >= 90 && vs.getHeartRate() <= 145) {
                heartStatus = "normal";
            } else if ((vs.getHeartRate() >= 85 && vs.getHeartRate() < 90) || (vs.getHeartRate() > 145 && vs.getHeartRate() <= 150)) {
                heartStatus = "Moderate";
            } else {
                heartStatus = "HighRisk";
            }
        } else if (vs.getAge() > 30 && vs.getAge() < 40) {

            if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                heightStatus = "normal";
                weightStatus = "normal";
                bmiStatus = "normal";
            } else {
                heightStatus = "HighRisk";
                weightStatus = "HighRisk";
                bmiStatus = "HighRisk";
            }
            if (vs.getSysbp() >= 122 && vs.getSysbp() < 125) {
                SysBpstatus = "normal";
            } else if (vs.getSysbp() > 125 && vs.getSysbp() <= 127) {
                SysBpstatus = "moderate";
            } else {
                SysBpstatus = "HighRisk";
            }
            if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                suagrStatus = "normal";
            } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                suagrStatus = "moderate";
            } else {
                suagrStatus = "HighRisk";
            }
            if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                hbStatus = "normal";
            } else if (vs.getBloodHb() >= 10 & vs.getBloodHb() < 11.9) {
                hbStatus = "moderate";
            } else {
                hbStatus = "HighRisk";
            }
            if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                resprStatus = "normal";
            } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                resprStatus = "moderate";
            } else {
                resprStatus = "HighRisk";
            }
            if (vs.getDyspBp() >= 80 && vs.getDyspBp() <= 82) {
                DiasBpstatus = "normal";
            } else if (vs.getDyspBp() >= 78 && vs.getDyspBp() < 80) {
                DiasBpstatus = "Moderate";
            } else {
                DiasBpstatus = "HighRisk";
            }
            if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                choStatus = "normal";
            } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                choStatus = "Moderate";
            } else {
                choStatus = "HighRisk";
            }
            if (vs.getPulseRate() >= 85 && vs.getPulseRate() <= 149) {
                pulseStatus = "normal";
            } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 85) || (vs.getPulseRate() > 149 && vs.getPulseRate() <= 155)) {
                pulseStatus = "moderate";
            } else {
                pulseStatus = "HighRisk";
            }
            if (vs.getBodyTemperature() == 98.7) {
                tempStatus = "normal";
            } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                tempStatus = "moderate";
            } else {
                tempStatus = "HighRisk";
            }
            if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                pHStatus = "normal";
            } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                pHStatus = "Moderate";
            } else {
                pHStatus = "HighRisk";
            }
            if (vs.getHeartRate() >= 95 && vs.getHeartRate() <= 153) {
                heartStatus = "normal";
            } else if ((vs.getHeartRate() >= 90 && vs.getHeartRate() < 95) || (vs.getHeartRate() > 153 && vs.getHeartRate() < 160)) {
                heartStatus = "Moderate";
            } else {
                heartStatus = "HighRisk";
            }
        } else if (vs.getAge() > 40 && vs.getAge() < 50) {

            if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                heightStatus = "normal";
                weightStatus = "normal";
                bmiStatus = "normal";
            } else {
                heightStatus = "HighRisk";
                weightStatus = "HighRisk";
                bmiStatus = "HighRisk";
            }
            if (vs.getSysbp() >= 125 && vs.getSysbp() < 127) {
                SysBpstatus = "normal";
            } else if (vs.getSysbp() > 127 && vs.getSysbp() <= 130) {
                SysBpstatus = "moderate";
            } else {
                SysBpstatus = "HighRisk";
            }
            if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                suagrStatus = "normal";
            } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                suagrStatus = "moderate";
            } else {
                suagrStatus = "HighRisk";
            }
            if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                hbStatus = "normal";
            } else if (vs.getBloodHb() >= 10 & vs.getBloodHb() < 11.9) {
                hbStatus = "moderate";
            } else {
                hbStatus = "HighRisk";
            }
            if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                resprStatus = "normal";
            } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                resprStatus = "moderate";
            } else {
                resprStatus = "HighRisk";
            }
            if (vs.getDyspBp() >= 83 && vs.getDyspBp() <= 85) {
                DiasBpstatus = "normal";
            } else if (vs.getDyspBp() >= 80 && vs.getDyspBp() < 83) {
                DiasBpstatus = "Moderate";
            } else {
                DiasBpstatus = "HighRisk";
            }
            if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                choStatus = "normal";
            } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                choStatus = "Moderate";
            } else {
                choStatus = "HighRisk";
            }
            if (vs.getPulseRate() >= 85 && vs.getPulseRate() <= 153) {
                pulseStatus = "normal";
            } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 85) || (vs.getPulseRate() > 149 && vs.getPulseRate() <= 153)) {
                pulseStatus = "moderate";
            } else {
                pulseStatus = "HighRisk";
            }
            if (vs.getBodyTemperature() == 98.7) {
                tempStatus = "normal";
            } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                tempStatus = "moderate";
            } else {
                tempStatus = "HighRisk";
            }
            if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                pHStatus = "normal";
            } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                pHStatus = "Moderate";
            } else {
                pHStatus = "HighRisk";
            }
            if (vs.getHeartRate() >= 90 && vs.getHeartRate() <= 145) {
                heartStatus = "normal";
            } else if ((vs.getHeartRate() >= 85 && vs.getHeartRate() < 90) || (vs.getHeartRate() > 145 && vs.getHeartRate() <= 150)) {
                heartStatus = "Moderate";
            } else {
                heartStatus = "HighRisk";
            }
        } else if (vs.getAge() > 50 && vs.getAge() < 60) {

            if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                heightStatus = "normal";
                weightStatus = "normal";
                bmiStatus = "normal";
            } else {
                heightStatus = "HighRisk";
                weightStatus = "HighRisk";
                bmiStatus = "HighRisk";
            }
            if (vs.getSysbp() >= 127 && vs.getSysbp() < 129) {
                SysBpstatus = "normal";
            } else if (vs.getSysbp() > 129 && vs.getSysbp() <= 130) {
                SysBpstatus = "moderate";
            } else {
                SysBpstatus = "HighRisk";
            }
            if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                suagrStatus = "normal";
            } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                suagrStatus = "moderate";
            } else {
                suagrStatus = "HighRisk";
            }
            if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                hbStatus = "normal";
            } else if (vs.getBloodHb() >= 10 & vs.getBloodHb() < 11.9) {
                hbStatus = "moderate";
            } else {
                hbStatus = "HighRisk";
            }
            if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                resprStatus = "normal";
            } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                resprStatus = "moderate";
            } else {
                resprStatus = "HighRisk";
            }
            if (vs.getDyspBp() >= 85 && vs.getDyspBp() <= 86) {
                DiasBpstatus = "normal";
            } else if (vs.getDyspBp() >= 80 && vs.getDyspBp() < 85) {
                DiasBpstatus = "Moderate";
            } else {
                DiasBpstatus = "HighRisk";
            }
            if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                choStatus = "normal";
            } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                choStatus = "Moderate";
            } else {
                choStatus = "HighRisk";
            }
            if (vs.getPulseRate() >= 83 && vs.getPulseRate() <= 140) {
                pulseStatus = "normal";
            } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 82) || (vs.getPulseRate() > 130 && vs.getPulseRate() <= 140)) {
                pulseStatus = "moderate";
            } else {
                pulseStatus = "HighRisk";
            }
            if (vs.getBodyTemperature() == 98.7) {
                tempStatus = "normal";
            } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                tempStatus = "moderate";
            } else {
                tempStatus = "HighRisk";
            }
            if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                pHStatus = "normal";
            } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                pHStatus = "Moderate";
            } else {
                pHStatus = "HighRisk";
            }
            if (vs.getHeartRate() >= 85 && vs.getHeartRate() <= 136) {
                heartStatus = "normal";
            } else if ((vs.getHeartRate() >= 80 && vs.getHeartRate() < 85) || (vs.getHeartRate() >= 130 && vs.getHeartRate() < 136)) {
                heartStatus = "Moderate";
            } else {
                heartStatus = "HighRisk";
            }
        } else {

            if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                heightStatus = "normal";
                weightStatus = "normal";
                bmiStatus = "normal";
            } else {
                heightStatus = "HighRisk";
                weightStatus = "HighRisk";
                bmiStatus = "HighRisk";
            }
            if (vs.getSysbp() >= 131 && vs.getSysbp() < 134) {
                SysBpstatus = "normal";
            } else if (vs.getSysbp() >= 127 && vs.getSysbp() < 131) {
                SysBpstatus = "moderate";
            } else {
                SysBpstatus = "HighRisk";
            }
            if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                suagrStatus = "normal";
            } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                suagrStatus = "moderate";
            } else {
                suagrStatus = "HighRisk";
            }
            if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                hbStatus = "normal";
            } else if (vs.getBloodHb() >= 10 & vs.getBloodHb() < 11.9) {
                hbStatus = "moderate";
            } else {
                hbStatus = "HighRisk";
            }
            if (vs.getRespiratioRate() >= 10 && vs.getRespiratioRate() <= 32) {
                resprStatus = "normal";
            } else if (vs.getRespiratioRate() > 32 && vs.getRespiratioRate() <= 35) {
                resprStatus = "moderate";
            } else {
                resprStatus = "HighRisk";
            }
            if (vs.getDyspBp() >= 85 && vs.getDyspBp() <= 86) {
                DiasBpstatus = "normal";
            } else if (vs.getDyspBp() > 86 && vs.getDyspBp() <= 88) {
                DiasBpstatus = "Moderate";
            } else {
                DiasBpstatus = "HighRisk";
            }
            if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                choStatus = "normal";
            } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                choStatus = "Moderate";
            } else {
                choStatus = "HighRisk";
            }
            if (vs.getPulseRate() >= 75 && vs.getPulseRate() <= 132) {
                pulseStatus = "normal";
            } else if ((vs.getPulseRate() >= 70 && vs.getPulseRate() < 75) || (vs.getPulseRate() > 132 && vs.getPulseRate() <= 135)) {
                pulseStatus = "moderate";
            } else {
                pulseStatus = "HighRisk";
            }
            if (vs.getBodyTemperature() == 98.7) {
                tempStatus = "normal";
            } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                tempStatus = "moderate";
            } else {
                tempStatus = "HighRisk";
            }
            if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                pHStatus = "normal";
            } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                pHStatus = "Moderate";
            } else {
                pHStatus = "HighRisk";
            }
            if (vs.getHeartRate() >= 80 && vs.getHeartRate() <= 128) {
                heartStatus = "normal";
            } else if ((vs.getHeartRate() >= 75 && vs.getHeartRate() < 80) || (vs.getHeartRate() > 128 && vs.getHeartRate() <= 135)) {
                heartStatus = "Moderate";
            } else {
                heartStatus = "HighRisk";
            }
        }
        if (SysBpstatus.equals("normal") && heightStatus.equals("normal") && weightStatus.equals("normal") && bmiStatus.equals("normal") && heartStatus.equals("normal") && pHStatus.equals("normal") && tempStatus.equals("normal") && DiasBpstatus.equals("normal") && choStatus.equals("normal") && pulseStatus.equals("normal") && resprStatus.equals("normal")) {
            status = "NORMAL";
        }
        if (SysBpstatus.equals("Moderate") || heartStatus.equals("Moderate") || pHStatus.equals("Moderate") || tempStatus.equals("Moderate") || DiasBpstatus.equals("Moderate") || choStatus.equals("Moderate") || pulseStatus.equals("moderate") || resprStatus.equals("Moderate")) {
            status = "BORDERLINE";
        }
        if (SysBpstatus.equals("HighRisk") || heightStatus.equals("HighRisk") || weightStatus.equals("HighRisk") || bmiStatus.equals("HighRisk") || heartStatus.equals("HighRisk") || pHStatus.equals("HighRisk") || tempStatus.equals("HighRisk") || DiasBpstatus.equals("HighRisk") || choStatus.equals("HighRisk") || pulseStatus.equals("HighRisk") || resprStatus.equals("HighRisk")) {
            status = "HIGHRISK";
        }
        return status;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        vitalsTable = new javax.swing.JTable();
        btnSendtoHospital = new javax.swing.JButton();
        btnViewDetails = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        valueLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSysBp = new javax.swing.JTextField();
        txtDysBp = new javax.swing.JTextField();
        txtCho = new javax.swing.JTextField();
        txtPulseR = new javax.swing.JTextField();
        txtWt = new javax.swing.JTextField();
        txtRespRate = new javax.swing.JTextField();
        txtTemp = new javax.swing.JTextField();
        txtBloodHb = new javax.swing.JTextField();
        txtBloodPh = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        txtBmi = new javax.swing.JTextField();
        txtHr = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        txtBloodSugar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtSysBp2 = new javax.swing.JTextField();
        txtDysBp2 = new javax.swing.JTextField();
        txtCho2 = new javax.swing.JTextField();
        txtPulseR2 = new javax.swing.JTextField();
        txtWt2 = new javax.swing.JTextField();
        txtRespRate2 = new javax.swing.JTextField();
        txtTemp2 = new javax.swing.JTextField();
        txtBloodHb2 = new javax.swing.JTextField();
        txtBloodPh2 = new javax.swing.JTextField();
        txtHeight2 = new javax.swing.JTextField();
        txtBmi2 = new javax.swing.JTextField();
        txtHr2 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtAge2 = new javax.swing.JTextField();
        txtBloodSugar2 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        txtViewSens = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vitalsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Gender", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vitalsTable);
        if (vitalsTable.getColumnModel().getColumnCount() > 0) {
            vitalsTable.getColumnModel().getColumn(0).setResizable(false);
            vitalsTable.getColumnModel().getColumn(1).setResizable(false);
            vitalsTable.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 610, 118));

        btnSendtoHospital.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSendtoHospital.setText("Send to Hospital/View Requests");
        btnSendtoHospital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendtoHospitalActionPerformed(evt);
            }
        });
        add(btnSendtoHospital, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 230, -1));

        btnViewDetails.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnViewDetails.setText("View Details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });
        add(btnViewDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 230, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel30.setText("Select from the table above to view their details");
        add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 350, 370, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel31.setText("Click here to send  the latest parameters to Hospital");
        add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, 370, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("PATIENT:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, -1, -1));

        valueLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 160, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel32.setText("ENTERPRISE:");
        add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, -1, -1));

        valueLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        valueLabel1.setText("<value>");
        add(valueLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 200, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("SYSTOLIC BP:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        txtSysBp.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtSysBp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 170, -1));

        txtDysBp.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDysBp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDysBpActionPerformed(evt);
            }
        });
        add(txtDysBp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 170, -1));

        txtCho.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtCho, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 170, -1));

        txtPulseR.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPulseR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPulseRActionPerformed(evt);
            }
        });
        add(txtPulseR, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 170, -1));

        txtWt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtWt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 170, -1));

        txtRespRate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtRespRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespRateActionPerformed(evt);
            }
        });
        add(txtRespRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 170, -1));

        txtTemp.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 170, -1));

        txtBloodHb.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodHb, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 170, -1));

        txtBloodPh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodPh, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 170, -1));

        txtHeight.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, 170, -1));

        txtBmi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBmi, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, 170, -1));

        txtHr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtHr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHrActionPerformed(evt);
            }
        });
        add(txtHr, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 650, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("HEART RATE:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setText("BMI:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 600, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("HEIGHT:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("BLOOD HAEMOGLOBIN:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("BLOOD PH:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("BODY TEMPERATURE:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("RESPIRATION RATE:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("WEIGHT:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("PULSE RATE:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("CHOLESTEROL:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setText("DIASTOLIC BP:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        txtAge.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });
        add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 700, 170, -1));

        txtBloodSugar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodSugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 750, 170, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("BLOOD SUGAR LEVEL:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 760, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setText("AGE:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 570, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 870, 100, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setText("PLEASE INSERT THE ESSENTIAL BODY PARAMETERS");
        add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 500, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel35.setText("mg/dL");
        add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 760, -1, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel36.setText("mmHg");
        add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel37.setText("mmHg");
        add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel38.setText("mg/dL");
        add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel39.setText("beats/Min");
        add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel40.setText("lbs");
        add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel41.setText("breath/min");
        add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, -1, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel42.setText("fahrenheit");
        add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, -1, -1));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel43.setText("g/dL");
        add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, -1, -1));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel44.setText("phUnits");
        add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, -1, -1));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel45.setText("cms");
        add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 560, -1, -1));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel46.setText("cm/lb");
        add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 610, -1, -1));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel47.setText("bpm");
        add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 660, -1, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel48.setText("years");
        add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 710, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel33.setText("SYSTOLIC BP:");
        add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 820, -1, -1));

        txtSysBp2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtSysBp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 820, 170, -1));

        txtDysBp2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDysBp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDysBp2ActionPerformed(evt);
            }
        });
        add(txtDysBp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 510, 170, -1));

        txtCho2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtCho2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 560, 170, -1));

        txtPulseR2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPulseR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPulseR2ActionPerformed(evt);
            }
        });
        add(txtPulseR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 610, 170, -1));

        txtWt2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtWt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 660, 170, -1));

        txtRespRate2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtRespRate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespRate2ActionPerformed(evt);
            }
        });
        add(txtRespRate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 710, 170, -1));

        txtTemp2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtTemp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 760, 170, -1));

        txtBloodHb2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodHb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 770, 170, -1));

        txtBloodPh2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodPh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 670, 170, -1));

        txtHeight2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtHeight2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 720, 170, -1));

        txtBmi2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBmi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 820, 170, -1));

        txtHr2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtHr2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHr2ActionPerformed(evt);
            }
        });
        add(txtHr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 520, 170, -1));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel49.setText("HEART RATE:");
        add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 520, -1, -1));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel50.setText("HEIGHT:");
        add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 720, -1, -1));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel51.setText("BLOOD HAEMOGLOBIN:");
        add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 770, -1, -1));

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel52.setText("BLOOD PH:");
        add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 670, -1, -1));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel53.setText("BODY TEMPERATURE:");
        add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 760, -1, -1));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel54.setText("RESPIRATION RATE:");
        add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 710, -1, -1));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel55.setText("WEIGHT:");
        add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 660, -1, -1));

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel56.setText("PULSE RATE:");
        add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 610, -1, -1));

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel57.setText("CHOLESTEROL:");
        add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 560, -1, -1));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel58.setText("DIASTOLIC BP:");
        add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 510, -1, -1));

        txtAge2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtAge2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAge2ActionPerformed(evt);
            }
        });
        add(txtAge2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 570, 170, -1));

        txtBloodSugar2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodSugar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 620, 170, -1));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel59.setText("BLOOD SUGAR LEVEL:");
        add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 620, -1, -1));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel60.setText("mg/dL");
        add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 630, -1, -1));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel61.setText("mmHg");
        add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 820, -1, -1));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel62.setText("mmHg");
        add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 520, -1, -1));

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel63.setText("mg/dL");
        add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 570, -1, -1));

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel64.setText("beats/Min");
        add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 620, -1, -1));

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel65.setText("lbs");
        add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 670, -1, -1));

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel66.setText("breath/min");
        add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 720, -1, -1));

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel67.setText("fahrenheit");
        add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 770, -1, -1));

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel68.setText("g/dL");
        add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 770, -1, -1));

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel69.setText("phUnits");
        add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 670, -1, -1));

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel70.setText("cms");
        add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 720, -1, -1));

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel71.setText("cm/lb");
        add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 820, -1, -1));

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel72.setText("bpm");
        add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 530, -1, -1));

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel73.setText("years");
        add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 580, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setText("BMI:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 820, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("AGE:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 710, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 51));
        jLabel19.setText("*");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 51));
        jLabel20.setText("*");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("*");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 51));
        jLabel22.setText("*");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 51));
        jLabel23.setText("*");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 0, 51));
        jLabel24.setText("*");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 51));
        jLabel25.setText("*");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, -1, -1));

        jLabel26.setForeground(new java.awt.Color(255, 0, 51));
        jLabel26.setText("*");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 850, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 51));
        jLabel27.setText("*");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 51));
        jLabel28.setText("*");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 51));
        jLabel29.setText("*");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 650, -1, -1));

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 0, 51));
        jLabel74.setText("*");
        add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 0, 51));
        jLabel75.setText("*");
        add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 760, -1, -1));

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 0, 51));
        jLabel77.setText("*");
        add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, -1, -1));

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 0, 51));
        jLabel76.setText("*");
        add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 710, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("Mandatory Field");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 850, 120, -1));

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel79.setText("DEVICE ID:");
        add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, -1, -1));

        txtViewSens.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        add(txtViewSens, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 450, 250, -1));

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel78.setIcon(new javax.swing.ImageIcon("C:\\Users\\ruchi\\Desktop\\Final Project\\Project\\src\\userInterface\\Alien Ink 2560X1600 Abstract Background.jpg")); // NOI18N
        add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1610, 1170));
    }// </editor-fold>//GEN-END:initComponents

    private void txtPulseRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPulseRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPulseRActionPerformed

    private void txtRespRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRespRateActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtDysBpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDysBpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDysBpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       
        String wht = txtWt.getText();
        String s = txtSysBp.getText();
        String dysb = txtDysBp.getText();
        String heart = txtHr.getText();
        String chol = txtCho.getText();
        String pulse = txtPulseR.getText();
        String sugar = txtBloodSugar.getText();
        String respirate = txtRespRate.getText();
        String tempera = txtTemp.getText();
        String haemoglobin = txtBloodHb.getText();
        String phOfBody = txtBloodPh.getText();
        String heig = txtHeight.getText();
        String bm = txtBmi.getText();
        String umar = txtAge.getText();
        if (s.isEmpty()||wht.isEmpty()||dysb.isEmpty()||heart.isEmpty()||chol.isEmpty()||pulse.isEmpty()||sugar.isEmpty()||respirate.isEmpty()||tempera.isEmpty()
                ||haemoglobin.isEmpty()||phOfBody.isEmpty()||heig.isEmpty()||bm.isEmpty()||umar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You cannot leave any field empty");
        } else {
            
            if (s.matches("[0-9]{1,13}(\\.[0-9]*)?"))
            {
            double sBp = Double.parseDouble(s);
            double wt = Double.parseDouble(wht);
            double dBp = Double.parseDouble(dysb);
            double hr = Double.parseDouble(heart);
            double cho = Double.parseDouble(txtCho.getText());
            double pr = Double.parseDouble(txtPulseR.getText());
            double bloods = Double.parseDouble(txtBloodSugar.getText());
            double respr = Double.parseDouble(txtRespRate.getText());
            double temp = Double.parseDouble(txtTemp.getText());
            double bloodHb = Double.parseDouble(txtBloodHb.getText());
            double bloodPh = Double.parseDouble(txtBloodPh.getText());
            double hei = Double.parseDouble(txtHeight.getText());
            double bmi = Double.parseDouble(txtBmi.getText());
            int age = Integer.parseInt(txtAge.getText());
            int rands=RandomNumber();
            String sens=deviceid+rands;
            
            VitalSigns vs = account.getEmployee().getVitalSignHistory().createVitalSign();
            vs.setWeight(wt);
            vs.setSysbp(sBp);
            vs.setDyspBp(dBp);
            vs.setHeartRate(hr);
            vs.setCholesterol(cho);
            vs.setPulseRate(pr);
            vs.setBloodSugarLevel(bloods);
            vs.setRespiratioRate(respr);
            vs.setBodyTemperature(temp);
            vs.setBloodHb(bloodHb);
            vs.setBloodPh(bloodPh);
            vs.setHeight(hei);
            vs.setBmi(bmi);
            vs.setAge(age);
            vs.setCurrentDate();
            vs.setDeviceId(sens);
            JOptionPane.showMessageDialog(null, "Body Parameters are recored successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            populateTable();
            resetFields();
            }
            else
            {
              JOptionPane.showMessageDialog(null,"Please enter the value of Systolic Bp in digits","Error",JOptionPane.ERROR_MESSAGE);
            }
            
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        int selectedRow = vitalsTable.getSelectedRow();
        if (selectedRow >= 0) {
            txtWt2.setVisible(true);
            txtSysBp2.setVisible(true);
            txtViewSens.setVisible(true);
             jLabel79.setVisible(true);
            txtHr2.setVisible(true);
            txtDysBp2.setVisible(true);
            txtAge2.setVisible(true);
            txtBmi2.setVisible(true);
            txtHeight2.setVisible(true);
            txtBloodPh2.setVisible(true);
            txtBloodHb2.setVisible(true);
            txtTemp2.setVisible(true);
            txtRespRate2.setVisible(true);
            txtBloodSugar2.setVisible(true);
            txtPulseR2.setVisible(true);
            txtCho2.setVisible(true);
            jLabel33.setVisible(true);
            jLabel58.setVisible(true);
            jLabel57.setVisible(true);
            jLabel56.setVisible(true);
            jLabel55.setVisible(true);
            jLabel54.setVisible(true);
            jLabel53.setVisible(true);
            jLabel61.setVisible(true);
            jLabel62.setVisible(true);
            jLabel63.setVisible(true);
            jLabel64.setVisible(true);
            jLabel65.setVisible(true);
            jLabel66.setVisible(true);
            jLabel67.setVisible(true);
            jLabel71.setVisible(true);
            jLabel72.setVisible(true);
            jLabel73.setVisible(true);
            jLabel60.setVisible(true);
            jLabel69.setVisible(true);
            jLabel70.setVisible(true);
            jLabel68.setVisible(true);
            jLabel17.setVisible(true);
            jLabel49.setVisible(true);
            jLabel15.setVisible(true);
            jLabel59.setVisible(true);
            jLabel52.setVisible(true);
            jLabel50.setVisible(true);
            jLabel51.setVisible(true);
            VitalSigns vs = (VitalSigns) vitalsTable.getValueAt(selectedRow, 0);
            txtWt2.setText(String.valueOf(vs.getWeight()));
            txtSysBp2.setText(String.valueOf(vs.getSysbp()));
            txtHr2.setText(String.valueOf(vs.getHeartRate()));
            txtDysBp2.setText(String.valueOf(vs.getDyspBp()));
            txtAge2.setText(String.valueOf(vs.getAge()));
            txtBmi2.setText(String.valueOf(vs.getBmi()));
            txtHeight2.setText(String.valueOf(vs.getHeight()));
            txtBloodPh2.setText(String.valueOf(vs.getBloodPh()));
            txtBloodHb2.setText(String.valueOf(vs.getBloodPh()));
            txtTemp2.setText(String.valueOf(vs.getBodyTemperature()));
            txtRespRate2.setText(String.valueOf(vs.getRespiratioRate()));
            txtBloodSugar2.setText(String.valueOf(vs.getBloodSugarLevel()));
            txtPulseR2.setText(String.valueOf(vs.getPulseRate()));
            txtCho2.setText(String.valueOf(vs.getCholesterol()));
            txtViewSens.setText(vs.getDeviceId());

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    public int RandomNumber() {
       int result = 0;
       int min = 2;
       int max = 5;
       result = min + (int) (Math.random() * (max - min)) * 100;
       return result;
   }
    private void btnSendtoHospitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendtoHospitalActionPerformed
        userInterface.PatientRole.SendToHospitalNew sthn = new userInterface.PatientRole.SendToHospitalNew(userProcessContainer, account, organization, enterprise);
        userProcessContainer.add("sthn", sthn);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnSendtoHospitalActionPerformed

    private void txtHrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHrActionPerformed

    private void txtDysBp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDysBp2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDysBp2ActionPerformed

    private void txtPulseR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPulseR2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPulseR2ActionPerformed

    private void txtRespRate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespRate2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRespRate2ActionPerformed

    private void txtHr2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHr2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHr2ActionPerformed

    private void txtAge2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAge2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAge2ActionPerformed

    private void resetFields() {
        txtWt.setText("");
        txtHr.setText("");
        txtSysBp.setText("");
        txtDysBp.setText("");
        txtAge.setText("");
        txtBmi.setText("");
        txtHeight.setText("");
        txtBloodPh.setText("");
        txtBloodHb.setText("");
        txtTemp.setText("");
        txtRespRate.setText("");
        txtBloodSugar.setText("");
        txtPulseR.setText("");
        txtCho.setText("");
        txtHeight.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendtoHospital;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtAge2;
    private javax.swing.JTextField txtBloodHb;
    private javax.swing.JTextField txtBloodHb2;
    private javax.swing.JTextField txtBloodPh;
    private javax.swing.JTextField txtBloodPh2;
    private javax.swing.JTextField txtBloodSugar;
    private javax.swing.JTextField txtBloodSugar2;
    private javax.swing.JTextField txtBmi;
    private javax.swing.JTextField txtBmi2;
    private javax.swing.JTextField txtCho;
    private javax.swing.JTextField txtCho2;
    private javax.swing.JTextField txtDysBp;
    private javax.swing.JTextField txtDysBp2;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtHeight2;
    private javax.swing.JTextField txtHr;
    private javax.swing.JTextField txtHr2;
    private javax.swing.JTextField txtPulseR;
    private javax.swing.JTextField txtPulseR2;
    private javax.swing.JTextField txtRespRate;
    private javax.swing.JTextField txtRespRate2;
    private javax.swing.JTextField txtSysBp;
    private javax.swing.JTextField txtSysBp2;
    private javax.swing.JTextField txtTemp;
    private javax.swing.JTextField txtTemp2;
    private javax.swing.JTextField txtViewSens;
    private javax.swing.JTextField txtWt;
    private javax.swing.JTextField txtWt2;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JLabel valueLabel1;
    private javax.swing.JTable vitalsTable;
    // End of variables declaration//GEN-END:variables
}
