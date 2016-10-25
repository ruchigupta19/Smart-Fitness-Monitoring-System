/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.InternRole;

import Business.WorkQueue.TestVitalsWorkRequest;
import business.VitalSigns.VitalSigns;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ruchi
 */
public class ProcessingInternJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private TestVitalsWorkRequest request;
    private ArrayList<String> treatmentList;
    private ArrayList<String> treatmentAdded;

    /**
     * Creates new form ProcessingInternJPanel
     */
    public ProcessingInternJPanel(JPanel upc, TestVitalsWorkRequest r) {
        initComponents();
        this.userProcessContainer = upc;
        this.request = r;
        this.treatmentList = new ArrayList<>();
        this.treatmentAdded = new ArrayList<>();
        txtWt2.setVisible(false);
        txtSysBp2.setVisible(false);
        txtHr2.setVisible(false);
        txtDysBp2.setVisible(false);
        txtBmi2.setVisible(false);
        txtHeight2.setVisible(false);
        txtBloodPh2.setVisible(false);
        txtBloodHb2.setVisible(false);
        txtTemp2.setVisible(false);
        txtRespRate2.setVisible(false);
        txtBloodSugar2.setVisible(false);
        txtPulseR2.setVisible(false);
        txtCho2.setVisible(false);
        jLabel13.setVisible(false);
        jLabel17.setVisible(false);
        jLabel18.setVisible(false);
        jLabel19.setVisible(false);
        jLabel20.setVisible(false);
        jLabel21.setVisible(false);
        jLabel22.setVisible(false);
        jLabel23.setVisible(false);
        jLabel24.setVisible(false);
        jLabel25.setVisible(false);
        jLabel26.setVisible(false);
        jLabel27.setVisible(false);
        jLabel28.setVisible(false);
        treatmentList.add("Slightly OverWeight:Start hitting the gym and follow a basic diet chart");
        treatmentList.add("Slightly UnderWeight:Eat smaller meals, more frequently & Load up on carbs.");
        treatmentList.add("BP Slightly high:Cut on consumption of salt and common painkillers");
        treatmentList.add("BP Slightly low:Eat a diet higher in salt and limit alcoholic beverages");
        treatmentList.add("Slightly High Cholestrol:Eat better,maintain weight and exercise more");
        treatmentList.add("Slightly Low Cholestrol:Refrain from smoking and Consume foods that promote healthy HDL levels.");
        treatmentList.add("Slightly high pulse Rate:Do meditation and eat plenty of fish,salmon and mackerel");
        treatmentList.add("Slightly low pulse Rate: quit smoking,increase the consumption of Omega 3 fatty acid supplements");
        treatmentList.add("Slightly high blood Sugar:eat Cinnamon,Fenugreek,Indian Gooseberry,Black Plum and Bitter Gourd");
        treatmentList.add("Slightly low blood sugar:Avoid sweet fruits and juices such as grape and prune and Avoid skipping meals");
        treatmentList.add("Slightly high Respiration Rate:attempt to breathe into your belly (diaphragm) rather than your chest");
        treatmentList.add("Slightly low Respiration Rate:Deep Breathing,Cold Water, Blackstrap Molasses,Increase Magnesium Intake");
        treatmentList.add("Slightly high Temperature:Have Orange juice and other fruit juices rich in vitamin C and cold grapes");
        treatmentList.add("Slightly low Temperature:Increase activity level, change the diet and limit toxin exposure ");
        treatmentList.add("Slightly low Hb:Eat Iron-Rich Foods,Take Folic Acid and Increase Vitamin C Intake");
        treatmentList.add("Slightly high BloodPh:Drink one or two glasses of organic apple cider vinegar and water daily");
        treatmentList.add("Slightly low BloodPh:Have plenty of fluids and you can take oral sodium bicarbonate");
        treatmentList.add("Slightly Short height:Try to play games to increase your height");
        treatmentList.add("Slightly high HeartRate:eat plenty of fish,salmon and mackerel and start exercising");
        treatmentList.add("Slightly low HeartRate:increase the consumption of Omega 3 fatty acid supplements");
        abnormalParameterComboBox.removeAllItems();
        for (String tl : treatmentList) {
            abnormalParameterComboBox.addItem(tl);
        }

        VitalSigns vs = request.getVitalSigns();
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

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        resultJTextField1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        submitJButton1 = new javax.swing.JButton();
        abnormalParameterComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        treatmentBtn = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtWt2 = new javax.swing.JTextField();
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
        txtHr2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        resultJTextField1.setColumns(20);
        resultJTextField1.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        resultJTextField1.setRows(5);
        jScrollPane2.setViewportView(resultJTextField1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 200, 1050, 112));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("RESULTS:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, -1, -1));

        submitJButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        submitJButton1.setText("Submit Result");
        submitJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButton1ActionPerformed(evt);
            }
        });
        add(submitJButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 200, -1));

        abnormalParameterComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        abnormalParameterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        abnormalParameterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abnormalParameterComboBoxActionPerformed(evt);
            }
        });
        add(abnormalParameterComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 488, 800, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel3.setText("Select  measures to be taken");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 210, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Treatment:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, -1, -1));

        treatmentBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        treatmentBtn.setText("Add treatment to the results");
        treatmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treatmentBtnActionPerformed(evt);
            }
        });
        add(treatmentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 660, -1, -1));

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        backJButton.setText("<< BACK");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 850, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("PROCESSING A REQUEST");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setText("WEIGHT:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 200, -1, -1));

        txtWt2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtWt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWt2ActionPerformed(evt);
            }
        });
        add(txtWt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 190, 87, -1));

        txtSysBp2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtSysBp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 230, 87, -1));

        txtDysBp2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDysBp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDysBp2ActionPerformed(evt);
            }
        });
        add(txtDysBp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 270, 87, -1));

        txtCho2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtCho2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 310, 87, -1));

        txtPulseR2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPulseR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPulseR2ActionPerformed(evt);
            }
        });
        add(txtPulseR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 350, 87, -1));

        txtBloodSugar2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodSugar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 400, 87, -1));

        txtRespRate2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtRespRate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespRate2ActionPerformed(evt);
            }
        });
        add(txtRespRate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 440, 87, -1));

        txtTemp2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtTemp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 480, 87, -1));

        txtBloodHb2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodHb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 520, 87, -1));

        txtBloodPh2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBloodPh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 560, 89, -1));

        txtHeight2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtHeight2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 600, 89, -1));

        txtBmi2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBmi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 640, 89, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setText("SYSTOLIC BP:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 240, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("DIASTOLIC BP:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 280, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setText("CHOLESTEROL:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 320, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setText("PULSE RATE:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 360, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel21.setText("BLOOD SUGAR LEVEL:");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 400, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel22.setText("RESPIRATION RATE:");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 440, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setText("BODY TEMPERATURE:");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 480, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel24.setText("BLOOD HAEMOGLOBIN:");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 520, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel25.setText("BLOOD PH:");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 560, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel26.setText("HEIGHT:");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 600, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel27.setText("BMI:");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 640, -1, -1));

        txtHr2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtHr2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 680, 89, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel28.setText("HEART RATE:");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 680, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setText("View Parameters");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(841, 660, 270, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\ruchi\\Desktop\\Final Project\\Project\\src\\userInterface\\Alien Ink 2560X1600 Abstract Background.jpg")); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -60, 1870, 1720));
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButton1ActionPerformed
        if (resultJTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please write a treatment to be sent");
        } else {
            request.setStatus("Completed and prevention added");
            resultJTextField1.setText("");
            JOptionPane.showMessageDialog(null, "Result has been sent to the patient");
        }

    }//GEN-LAST:event_submitJButton1ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        userinterface.InternRole.InternWorkAreaJPanel iwajp = (userinterface.InternRole.InternWorkAreaJPanel) component;
        iwajp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void abnormalParameterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abnormalParameterComboBoxActionPerformed

    }//GEN-LAST:event_abnormalParameterComboBoxActionPerformed

    private void treatmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treatmentBtnActionPerformed
        String treatMent = (String) abnormalParameterComboBox.getSelectedItem();
        treatmentAdded.add(treatMent);
        refreshData();
    }//GEN-LAST:event_treatmentBtnActionPerformed

    private void txtWt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWt2ActionPerformed

    }//GEN-LAST:event_txtWt2ActionPerformed

    private void txtDysBp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDysBp2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDysBp2ActionPerformed

    private void txtPulseR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPulseR2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPulseR2ActionPerformed

    private void txtRespRate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespRate2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRespRate2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtWt2.setVisible(true);
        txtSysBp2.setVisible(true);
        txtHr2.setVisible(true);
        txtDysBp2.setVisible(true);
        txtBmi2.setVisible(true);
        txtHeight2.setVisible(true);
        txtBloodPh2.setVisible(true);
        txtBloodHb2.setVisible(true);
        txtTemp2.setVisible(true);
        txtRespRate2.setVisible(true);
        txtBloodSugar2.setVisible(true);
        txtPulseR2.setVisible(true);
        txtCho2.setVisible(true);
        jLabel13.setVisible(true);
        jLabel17.setVisible(true);
        jLabel18.setVisible(true);
        jLabel19.setVisible(true);
        jLabel20.setVisible(true);
        jLabel21.setVisible(true);
        jLabel22.setVisible(true);
        jLabel23.setVisible(true);
        jLabel24.setVisible(true);
        jLabel25.setVisible(true);
        jLabel26.setVisible(true);
        jLabel27.setVisible(true);
        jLabel28.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void refreshData() {
        String temp = "";
        for (String s : treatmentAdded) {
            temp = temp + s + "\n" + "\n";

        }

        request.setTestResult(temp);
        resultJTextField1.setText(temp);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> abnormalParameterComboBox;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea resultJTextField1;
    private javax.swing.JButton submitJButton1;
    private javax.swing.JButton treatmentBtn;
    private javax.swing.JTextField txtBloodHb2;
    private javax.swing.JTextField txtBloodPh2;
    private javax.swing.JTextField txtBloodSugar2;
    private javax.swing.JTextField txtBmi2;
    private javax.swing.JTextField txtCho2;
    private javax.swing.JTextField txtDysBp2;
    private javax.swing.JTextField txtHeight2;
    private javax.swing.JTextField txtHr2;
    private javax.swing.JTextField txtPulseR2;
    private javax.swing.JTextField txtRespRate2;
    private javax.swing.JTextField txtSysBp2;
    private javax.swing.JTextField txtTemp2;
    private javax.swing.JTextField txtWt2;
    // End of variables declaration//GEN-END:variables
}
