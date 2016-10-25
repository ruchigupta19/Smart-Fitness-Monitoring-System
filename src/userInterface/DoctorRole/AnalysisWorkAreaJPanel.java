/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.DoctorRole;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.TestVitalsWorkRequest;
import business.VitalSigns.VitalSigns;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author ruchi
 */
public class AnalysisWorkAreaJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    TestVitalsWorkRequest request;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private VitalSigns vs;
    String txtHeight2 = "";
    String txtWt2 = "";
    String txtBmi2 = "";
    String txtSysBp2 = "";
    String txtBloodHb2 = "";
    String txtBloodSugar2 = "";
    String txtRespRate2 = "";
    String txtDysBp2 = "";
    String txtBloodPh2 = "";
    String txtTemp2 = "";
    String txtCho2 = "";
    String txtHr2 = "";
    String txtPulseR2 = "";
    int resprateflag = 0;
    int rrcount = 0;
    int phflag = 0;
    int phcount = 0;
    int tempflag = 0;
    int tempcount = 0;
    int choflag = 0;
    int hrflag = 0;
    int prflag = 0;
    int chocount = 0;
    int hrcount = 0;
    int prcount = 0;
    int dbpflag = 0;
    int dbpcount = 0;
    int wthtbmiflag = 0;
    int sysBpFlag = 0;
    int sysbpcount = 0;
    String result = "";
    int BloodHbflag = 0;
    int bloodhbcount = 0;
    int bloodsugarflag = 0;
    int bloodsugarcount = 0;

    /**
     * Creates new form AnalysisWorkAreaJPanel
     */
    public AnalysisWorkAreaJPanel(JPanel upc, UserAccount ua, Enterprise e, TestVitalsWorkRequest r) {
        initComponents();
        this.userProcessContainer = upc;
        this.request = r;
        this.enterprise = e;
        this.userAccount = ua;
        Vitals();

    }

    private void Vitals() {
        vs = request.getVitalSigns();
        if (vs.getAge() >= 10 && vs.getAge() < 20) {

            if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                txtHeight2 = "normal";
                txtWt2 = "normal";
                txtBmi2 = "normal";
            } else {
                wthtbmiflag = 1;
                txtHeight2 = "HighRisk";
                txtWt2 = "HighRisk";
                txtBmi2 = "HighRisk";
            }
            if (vs.getSysbp() >= 120 && vs.getSysbp() < 122) {
                txtSysBp2 = "normal";

            } else if (vs.getSysbp() >= 122 && vs.getSysbp() <= 124) {
                txtSysBp2 = "moderate";

            } else {
                txtSysBp2 = "HighRisk";
                sysBpFlag = 1;

            }
            if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                txtBloodSugar2 = "normal";

            } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                txtBloodSugar2 = "moderate";

            } else {
                txtBloodSugar2 = "HighRisk";
                bloodsugarflag = 1;

            }
            if (vs.getBloodHb() >= 11.5 && vs.getBloodHb() <= 15.5) {
                txtBloodHb2 = "normal";

            } else if (vs.getBloodHb() >= 10 && vs.getBloodHb() < 11.5) {
                txtBloodHb2 = "moderate";

            } else {
                txtBloodHb2 = "HighRisk";
                BloodHbflag = 1;
            }
            if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 23) {
                txtRespRate2 = "normal";

            } else if (vs.getRespiratioRate() > 23 && vs.getRespiratioRate() <= 25) {
                txtRespRate2 = "Moderate";

            } else {
                txtRespRate2 = "HighRisk";
                resprateflag = 1;
            }
            if (vs.getDyspBp() >= 78 && vs.getDyspBp() <= 85) {
                txtDysBp2 = "normal";

            } else if (vs.getDyspBp() >= 76 && vs.getDyspBp() < 78) {
                txtDysBp2 = "Moderate";

            } else {
                txtDysBp2 = "HighRisk";
                dbpflag = 1;
            }
            if (vs.getCholesterol() <= 170) {
                txtCho2 = "normal";

            } else if (vs.getCholesterol() > 170 && vs.getCholesterol() <= 199) {
                txtCho2 = "Moderate";

            } else {
                txtCho2 = "HighRisk";
                choflag = 1;
            }
            if (vs.getPulseRate() >= 100 && vs.getPulseRate() <= 170) {
                txtPulseR2 = "normal";

            } else if ((vs.getPulseRate() > 170 && vs.getPulseRate() <= 180) || (vs.getPulseRate() >= 90 && vs.getPulseRate() < 100)) {
                txtPulseR2 = "Moderate";

            } else {
                txtPulseR2 = "HighRisk";
                prflag = 1;
            }
            if (vs.getBodyTemperature() == 98.7) {
                txtTemp2 = "normal";

            } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                txtTemp2 = "Moderate";

            } else {
                txtTemp2 = "HighRisk";
                tempflag = 1;

            }
            if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                txtBloodPh2 = "normal";

            } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                txtBloodPh2 = "Moderate";

            } else {
                txtBloodPh2 = "HighRisk";
                phflag = 1;
            }
            if (vs.getHeartRate() >= 80 && vs.getHeartRate() <= 140) {
                txtHr2 = "normal";

            } else if ((vs.getHeartRate() >= 75 && vs.getHeartRate() < 80) || (vs.getHeartRate() > 141 && vs.getHeartRate() < 150)) {
                txtHr2 = "Moderate";

            } else {
                txtHr2 = "HighRisk";
                hrflag = 1;

            }
        } else if (vs.getAge() >= 20 && vs.getAge() < 30) {

            if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                txtHeight2 = "normal";
                txtWt2 = "normal";
                txtBmi2 = "normal";
            } else {
                wthtbmiflag = 1;
                txtHeight2 = "HighRisk";
                txtWt2 = "HighRisk";
                txtBmi2 = "HighRisk";
            }
            if (vs.getSysbp() >= 120 && vs.getSysbp() < 122) {
                txtSysBp2 = "normal";

            } else if (vs.getSysbp() >= 122 && vs.getSysbp() <= 124) {
                txtSysBp2 = "moderate";

            } else {
                txtSysBp2 = "HighRisk";
                sysBpFlag = 1;

            }
            if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                txtBloodSugar2 = "normal";

            } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                txtBloodSugar2 = "moderate";

            } else {
                txtBloodSugar2 = "HighRisk";
                bloodsugarflag = 1;

            }
            if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                txtBloodHb2 = "normal";

            } else if (vs.getBloodHb() >= 10 && vs.getBloodHb() < 11.9) {
                txtBloodHb2 = "moderate";

            } else {
                txtBloodHb2 = "HighRisk";
                BloodHbflag = 1;
            }
            if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                txtRespRate2 = "normal";

            } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                txtRespRate2 = "Moderate";
            } else {
                txtRespRate2 = "HighRisk";
                resprateflag = 1;
            }
            if (vs.getDyspBp() >= 80 && vs.getDyspBp() <= 86) {
                txtDysBp2 = "normal";

            } else if (vs.getDyspBp() >= 78 && vs.getDyspBp() < 80) {
                txtDysBp2 = "Moderate";

            } else {
                txtDysBp2 = "HighRisk";
                dbpflag = 1;
            }
            if (vs.getCholesterol() > 180 && vs.getCholesterol() <= 199) {
                txtCho2 = "normal";

            } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                txtCho2 = "Moderate";

            } else {
                txtCho2 = "HighRisk";
                choflag = 1;
            }
            if (vs.getPulseRate() >= 90 && vs.getPulseRate() <= 162) {
                txtPulseR2 = "normal";

            } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 90) || (vs.getPulseRate() > 162 && vs.getPulseRate() <= 170)) {
                txtPulseR2 = "Moderate";

            } else {
                txtPulseR2 = "HighRisk";
                prflag = 1;
            }
            if (vs.getBodyTemperature() == 98.7) {
                txtTemp2 = "normal";

            } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                txtTemp2 = "Moderate";

            } else {
                txtTemp2 = "HighRisk";
                tempflag = 1;

            }
            if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                txtBloodPh2 = "normal";

            } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                txtBloodPh2 = "Moderate";

            } else {
                txtBloodPh2 = "HighRisk";
                phflag = 1;
            }
            if (vs.getHeartRate() >= 100 && vs.getHeartRate() <= 160) {
                txtHr2 = "normal";

            } else if ((vs.getHeartRate() >= 95 && vs.getHeartRate() < 100) || (vs.getHeartRate() > 162 && vs.getHeartRate() < 170)) {
                txtHr2 = "Moderate";

            } else {
                txtHr2 = "HighRisk";
                hrflag = 1;

            }
        } else if (vs.getAge() >= 30 && vs.getAge() < 40) {
            if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                txtHeight2 = "normal";
                txtWt2 = "normal";
                txtBmi2 = "normal";
            } else {
                wthtbmiflag = 1;
                txtHeight2 = "HighRisk";
                txtWt2 = "HighRisk";
                txtBmi2 = "HighRisk";
            }
            if (vs.getSysbp() >= 122 && vs.getSysbp() < 125) {
                txtSysBp2 = "normal";

            } else if (vs.getSysbp() >= 125 && vs.getSysbp() <= 127) {
                txtSysBp2 = "moderate";

            } else {
                txtSysBp2 = "HighRisk";
                sysBpFlag = 1;

            }
            if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                txtBloodSugar2 = "normal";

            } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                txtBloodSugar2 = "moderate";

            } else {
                txtBloodSugar2 = "HighRisk";
                bloodsugarflag = 1;

            }
            if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                txtBloodHb2 = "normal";

            } else if (vs.getBloodHb() >= 10 && vs.getBloodHb() < 11.9) {
                txtBloodHb2 = "moderate";

            } else {
                txtBloodHb2 = "HighRisk";
                BloodHbflag = 1;
            }
            if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                txtRespRate2 = "normal";

            } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                txtRespRate2 = "Moderate";

            } else {
                txtRespRate2 = "HighRisk";
                resprateflag = 1;
            }
            if (vs.getDyspBp() >= 80 && vs.getDyspBp() <= 82) {
                txtDysBp2 = "normal";

            } else if (vs.getDyspBp() >= 78 && vs.getDyspBp() < 80) {
                txtDysBp2 = "Moderate";

            } else {
                txtDysBp2 = "HighRisk";
                dbpflag = 1;
            }
            if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                txtCho2 = "normal";

            } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                txtCho2 = "Moderate";

            } else {
                txtCho2 = "HighRisk";
                choflag = 1;
            }
            if (vs.getPulseRate() >= 85 && vs.getPulseRate() <= 149) {
                txtPulseR2 = "normal";

            } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 85) || (vs.getPulseRate() > 149 && vs.getPulseRate() <= 155)) {
                txtPulseR2 = "Moderate";

            } else {
                txtPulseR2 = "HighRisk";
                prflag = 1;
            }
            if (vs.getBodyTemperature() == 98.7) {
                txtTemp2 = "normal";

            } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                txtTemp2 = "Moderate";

            } else {
                txtTemp2 = "HighRisk";
                tempflag = 1;

            }
            if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                txtBloodPh2 = "normal";

            } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                txtBloodPh2 = "Moderate";

            } else {
                txtBloodPh2 = "HighRisk";
                phflag = 1;
            }
            if (vs.getHeartRate() >= 95 && vs.getHeartRate() <= 153) {
                txtHr2 = "normal";

            } else if ((vs.getHeartRate() >= 90 && vs.getHeartRate() < 95) || (vs.getHeartRate() > 153 && vs.getHeartRate() < 160)) {
                txtHr2 = "Moderate";

            } else {
                txtHr2 = "HighRisk";
                hrflag = 1;

            }
        } else if (vs.getAge() >= 40 && vs.getAge() < 50) {

            if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                txtHeight2 = "normal";
                txtWt2 = "normal";
                txtBmi2 = "normal";
            } else {
                wthtbmiflag = 1;
                txtHeight2 = "HighRisk";
                txtWt2 = "HighRisk";
                txtBmi2 = "HighRisk";
            }
            if (vs.getSysbp() >= 125 && vs.getSysbp() < 127) {
                txtSysBp2 = "normal";

            } else if (vs.getSysbp() >= 127 && vs.getSysbp() <= 130) {
                txtSysBp2 = "moderate";

            } else {
                txtSysBp2 = "HighRisk";
                sysBpFlag = 1;

            }
            if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                txtBloodSugar2 = "normal";

            } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                txtBloodSugar2 = "moderate";

            } else {
                txtBloodSugar2 = "HighRisk";
                bloodsugarflag = 1;

            }
            if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                txtBloodHb2 = "normal";

            } else if (vs.getBloodHb() >= 10 && vs.getBloodHb() < 11.9) {
                txtBloodHb2 = "moderate";

            } else {
                txtBloodHb2 = "HighRisk";
                BloodHbflag = 1;
            }
            if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                txtRespRate2 = "normal";

            } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                txtRespRate2 = "Moderate";

            } else {
                txtRespRate2 = "HighRisk";
                resprateflag = 1;
            }
            if (vs.getDyspBp() >= 83 && vs.getDyspBp() <= 85) {
                txtDysBp2 = "normal";

            } else if (vs.getDyspBp() >= 80 && vs.getDyspBp() < 83) {
                txtDysBp2 = "Moderate";

            } else {
                txtDysBp2 = "HighRisk";
                dbpflag = 1;
            }
            if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                txtCho2 = "normal";

            } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                txtCho2 = "Moderate";

            } else {
                txtCho2 = "HighRisk";
                choflag = 1;
            }
            if (vs.getPulseRate() >= 85 && vs.getPulseRate() <= 153) {
                txtPulseR2 = "normal";

            } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 85) || (vs.getPulseRate() > 149 && vs.getPulseRate() <= 153)) {
                txtPulseR2 = "Moderate";

            } else {
                txtPulseR2 = "HighRisk";
                prflag = 1;
            }
            if (vs.getBodyTemperature() == 98.7) {
                txtTemp2 = "normal";

            } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                txtTemp2 = "Moderate";

            } else {
                txtTemp2 = "HighRisk";
                tempflag = 1;

            }
            if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                txtBloodPh2 = "normal";

            } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                txtBloodPh2 = "Moderate";

            } else {
                txtBloodPh2 = "HighRisk";
                phflag = 1;
            }
            if (vs.getHeartRate() >= 90 && vs.getHeartRate() <= 145) {
                txtHr2 = "normal";

            } else if ((vs.getHeartRate() >= 85 && vs.getHeartRate() < 90) || (vs.getHeartRate() > 145 && vs.getHeartRate() < 150)) {
                txtHr2 = "Moderate";

            } else {
                txtHr2 = "HighRisk";
                hrflag = 1;

            }
        } else if (vs.getAge() >= 50 && vs.getAge() < 60) {
            if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                txtHeight2 = "normal";
                txtWt2 = "normal";
                txtBmi2 = "normal";
            } else {
                wthtbmiflag = 1;
                txtHeight2 = "HighRisk";
                txtWt2 = "HighRisk";
                txtBmi2 = "HighRisk";
            }
            if (vs.getSysbp() >= 127 && vs.getSysbp() < 129) {
                txtSysBp2 = "normal";

            } else if (vs.getSysbp() >= 129 && vs.getSysbp() <= 130) {
                txtSysBp2 = "moderate";

            } else {
                txtSysBp2 = "HighRisk";
                sysBpFlag = 1;

            }
            if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                txtBloodSugar2 = "normal";

            } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                txtBloodSugar2 = "moderate";

            } else {
                txtBloodSugar2 = "HighRisk";
                bloodsugarflag = 1;

            }
            if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                txtBloodHb2 = "normal";

            } else if (vs.getBloodHb() >= 10 && vs.getBloodHb() < 11.9) {
                txtBloodHb2 = "moderate";

            } else {
                txtBloodHb2 = "HighRisk";
                BloodHbflag = 1;
            }
            if (vs.getRespiratioRate() >= 12 && vs.getRespiratioRate() <= 28) {
                txtRespRate2 = "normal";

            } else if (vs.getRespiratioRate() > 28 && vs.getRespiratioRate() <= 30) {
                txtRespRate2 = "Moderate";

            } else {
                txtRespRate2 = "HighRisk";
                resprateflag = 1;
            }
            if (vs.getDyspBp() >= 85 && vs.getDyspBp() <= 86) {
                txtDysBp2 = "normal";

            } else if (vs.getDyspBp() >= 80 && vs.getDyspBp() < 85) {
                txtDysBp2 = "Moderate";

            } else {
                txtDysBp2 = "HighRisk";
                dbpflag = 1;
            }
            if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                txtCho2 = "normal";

            } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                txtCho2 = "Moderate";

            } else {
                txtCho2 = "HighRisk";
                choflag = 1;
            }
            if (vs.getPulseRate() >= 83 && vs.getPulseRate() <= 140) {
                txtPulseR2 = "normal";

            } else if ((vs.getPulseRate() >= 80 && vs.getPulseRate() < 85) || (vs.getPulseRate() > 149 && vs.getPulseRate() <= 153)) {
                txtPulseR2 = "Moderate";

            } else {
                txtPulseR2 = "HighRisk";
                prflag = 1;
            }
            if (vs.getBodyTemperature() == 98.7) {
                txtTemp2 = "normal";

            } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                txtTemp2 = "Moderate";

            } else {
                txtTemp2 = "HighRisk";
                tempflag = 1;

            }
            if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                txtBloodPh2 = "normal";

            } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                txtBloodPh2 = "Moderate";

            } else {
                txtBloodPh2 = "HighRisk";
                phflag = 1;
            }
            if (vs.getHeartRate() >= 85 && vs.getHeartRate() <= 136) {
                txtHr2 = "normal";

            } else if ((vs.getHeartRate() >= 80 && vs.getHeartRate() < 95) || (vs.getHeartRate() > 130 && vs.getHeartRate() < 136)) {
                txtHr2 = "Moderate";

            } else {
                txtHr2 = "HighRisk";
                hrflag = 1;

            }
        } else {

            if ((vs.getHeight() >= 148 && vs.getHeight() <= 152 && vs.getWeight() >= 109 && vs.getWeight() <= 148) || (vs.getHeight() >= 153 && vs.getHeight() <= 168 && vs.getWeight() >= 115 && vs.getWeight() <= 163) || (vs.getHeight() >= 168 && vs.getHeight() <= 183 && vs.getWeight() >= 115 && vs.getWeight() <= 163)) {
                txtHeight2 = "normal";
                txtWt2 = "normal";
                txtBmi2 = "normal";
            } else {
                wthtbmiflag = 1;
                txtHeight2 = "HighRisk";
                txtWt2 = "HighRisk";
                txtBmi2 = "HighRisk";
            }
            if (vs.getSysbp() >= 131 && vs.getSysbp() < 134) {
                txtSysBp2 = "normal";

            } else if (vs.getSysbp() >= 127 && vs.getSysbp() < 131) {
                txtSysBp2 = "moderate";

            } else {
                txtSysBp2 = "HighRisk";
                sysBpFlag = 1;

            }
            if (vs.getBloodSugarLevel() >= 70 && vs.getBloodSugarLevel() <= 150) {
                txtBloodSugar2 = "normal";

            } else if ((vs.getBloodSugarLevel() > 150 && vs.getBloodSugarLevel() <= 170) || (vs.getBloodSugarLevel() >= 65 && vs.getBloodSugarLevel() < 70)) {
                txtBloodSugar2 = "moderate";

            } else {
                txtBloodSugar2 = "HighRisk";
                bloodsugarflag = 1;

            }
            if (vs.getBloodHb() >= 12 && vs.getBloodHb() <= 16) {
                txtBloodHb2 = "normal";

            } else if (vs.getBloodHb() >= 10 && vs.getBloodHb() < 11.9) {
                txtBloodHb2 = "moderate";

            } else {
                txtBloodHb2 = "HighRisk";
                BloodHbflag = 1;
            }
            if (vs.getRespiratioRate() >= 10 && vs.getRespiratioRate() <= 32) {
                txtRespRate2 = "normal";

            } else if (vs.getRespiratioRate() > 32 && vs.getRespiratioRate() <= 35) {
                txtRespRate2 = "Moderate";

            } else {
                txtRespRate2 = "HighRisk";
                resprateflag = 1;
            }
            if (vs.getDyspBp() >= 85 && vs.getDyspBp() <= 86) {
                txtDysBp2 = "normal";

            } else if (vs.getDyspBp() >= 80 && vs.getDyspBp() < 85) {
                txtDysBp2 = "Moderate";

            } else {
                txtDysBp2 = "HighRisk";
                dbpflag = 1;
            }
            if (vs.getCholesterol() >= 180 && vs.getCholesterol() <= 199) {
                txtCho2 = "normal";

            } else if (vs.getCholesterol() >= 200 && vs.getCholesterol() <= 239) {
                txtCho2 = "Moderate";

            } else {
                txtCho2 = "HighRisk";
                choflag = 1;
            }
            if (vs.getPulseRate() >= 75 && vs.getPulseRate() <= 132) {
                txtPulseR2 = "normal";

            } else if ((vs.getPulseRate() >= 70 && vs.getPulseRate() < 75) || (vs.getPulseRate() > 132 && vs.getPulseRate() <= 135)) {
                txtPulseR2 = "Moderate";

            } else {
                txtPulseR2 = "HighRisk";
                prflag = 1;
            }
            if (vs.getBodyTemperature() == 98.7) {
                txtTemp2 = "normal";

            } else if ((vs.getBodyTemperature() > 98.7 && vs.getBodyTemperature() < 99.5) || (vs.getBodyTemperature() >= 97.5 && vs.getBodyTemperature() < 98.7)) {
                txtTemp2 = "Moderate";

            } else {
                txtTemp2 = "HighRisk";
                tempflag = 1;

            }
            if (vs.getBloodPh() >= 7.35 && vs.getBloodPh() <= 7.45) {
                txtBloodPh2 = "normal";

            } else if (vs.getBloodPh() >= 7 && vs.getBloodPh() < 7.35) {
                txtBloodPh2 = "Moderate";

            } else {
                txtBloodPh2 = "HighRisk";
                phflag = 1;
            }
            if (vs.getHeartRate() >= 80 && vs.getHeartRate() <= 128) {
                txtHr2 = "normal";

            } else if ((vs.getHeartRate() >= 75 && vs.getHeartRate() < 80) || (vs.getHeartRate() > 128 && vs.getHeartRate() < 135)) {
                txtHr2 = "Moderate";

            } else {
                txtHr2 = "HighRisk";
                hrflag = 1;

            }
        }

        if (sysBpFlag == 1) {
            for (VitalSigns vital : request.getVitalSignHistory().getVitalSignList()) {
                if (vital.getAge() >= 10 && vital.getAge() < 20) {
                    if (vital.getSysbp() < 120 || vital.getSysbp() > 124) {
                        sysbpcount++;
                    }
                } else if (vital.getAge() >= 20 && vital.getAge() < 30) {
                    if (vital.getSysbp() < 120 || vital.getSysbp() > 124) {
                        sysbpcount++;
                    }

                } else if (vital.getAge() >= 30 && vital.getAge() < 40) {

                    if (vital.getSysbp() < 122 || vital.getSysbp() > 127) {
                        sysbpcount++;
                    }
                } else if (vital.getAge() >= 40 && vital.getAge() < 50) {

                    if (vital.getSysbp() < 125 || vital.getSysbp() > 130) {
                        sysbpcount++;
                    }
                } else if (vital.getAge() >= 50 && vital.getAge() < 60) {
                    if (vital.getSysbp() < 127 || vital.getSysbp() > 130) {
                        sysbpcount++;
                    }

                } else if (vital.getSysbp() < 127 || vital.getSysbp() > 134) {
                    sysbpcount++;
                }

            }
        }

        if (bloodsugarflag == 1) {
            for (VitalSigns vital : request.getVitalSignHistory().getVitalSignList()) {
                if (vital.getBloodSugarLevel() > 170 || vital.getBloodSugarLevel() < 65) {
                    bloodsugarcount++;

                }
            }
        }

        if (BloodHbflag == 1) {
            for (VitalSigns vital : request.getVitalSignHistory().getVitalSignList()) {
                if (vital.getAge() >= 10 && vital.getAge() < 20) {
                    if (vital.getBloodHb() < 10 || vital.getBloodHb() > 15.5) {
                        bloodhbcount++;
                    }
                } else if (vital.getAge() >= 20 && vital.getAge() < 30) {
                    if (vital.getBloodHb() < 10 || vital.getBloodHb() > 16) {
                        bloodhbcount++;
                    }

                } else if (vital.getAge() >= 30 && vital.getAge() < 40) {

                    if (vital.getBloodHb() < 10 || vital.getBloodHb() > 16) {
                        bloodhbcount++;
                    }
                } else if (vital.getAge() >= 40 && vital.getAge() < 50) {

                    if (vital.getBloodHb() < 10 || vital.getBloodHb() > 16) {
                        bloodhbcount++;
                    }
                } else if (vital.getAge() >= 50 && vital.getAge() < 60) {
                    if (vital.getBloodHb() < 10 || vital.getBloodHb() > 16) {
                        bloodhbcount++;
                    }

                } else if (vital.getAge() >= 60) {
                    if (vital.getBloodHb() < 10 || vital.getBloodHb() > 16) {
                        bloodhbcount++;
                    }
                }

            }

        }
        if (dbpflag == 1) {
            for (VitalSigns vital : request.getVitalSignHistory().getVitalSignList()) {
                if (vital.getAge() >= 10 && vital.getAge() < 20) {
                    if(vital.getDyspBp()>76 && vital.getDyspBp()>85)
                    {
                        dbpcount++;
                    }
                } else if (vital.getAge() >= 20 && vital.getAge() < 30) {
                     if(vital.getDyspBp()>78 && vital.getDyspBp()>86)
                    {
                        dbpcount++;
                    }
                } else if (vital.getAge() >= 30 && vital.getAge() < 40) {
                     if(vital.getDyspBp()>78 && vital.getDyspBp()>82)
                    {
                        dbpcount++;
                    }
                } else if (vital.getAge() >= 40 && vital.getAge() < 50) {
                     if(vital.getDyspBp()>80 && vital.getDyspBp()>85)
                    {
                        dbpcount++;
                    }
                } else if (vital.getAge() >= 50 && vital.getAge() < 60) {
                     if(vital.getDyspBp()>80 && vital.getDyspBp()>86)
                    {
                        dbpcount++;
                    }
                } else {
                     if(vital.getDyspBp()>80 && vital.getDyspBp()>86)
                    {
                        dbpcount++;
                    }
                }

            }
        }
        
         if (phflag == 1) {
             for (VitalSigns vital : request.getVitalSignHistory().getVitalSignList()) {
                if (vital.getBloodPh() < 7 || vital.getBloodPh()>7.45) {
                    phcount++;

                }
            }
        }
       
          if (choflag == 1) {
            for (VitalSigns vital : request.getVitalSignHistory().getVitalSignList()) {
                if (vital.getAge() >= 10 && vital.getAge() < 20) {
                    if(vital.getCholesterol()>=200)
                    {
                        chocount++;
                    }
                } else if (vital.getAge() >= 20 && vital.getAge() < 30) {
                     if(vital.getCholesterol()<=180 && vital.getCholesterol()>239)
                    {
                        chocount++;
                    }
                } else if (vital.getAge() >= 30 && vital.getAge() < 40) {
                     if(vital.getCholesterol()<=180 && vital.getCholesterol()>239)
                    {
                        chocount++;
                    }
                } else if (vital.getAge() >= 40 && vital.getAge() < 50) {
                     if(vital.getCholesterol()<=180 && vital.getCholesterol()>239)
                    {
                        chocount++;
                    }
                } else if (vital.getAge() >= 50 && vital.getAge() < 60) {
                     if(vital.getCholesterol()<=180 && vital.getCholesterol()>239)
                    {
                        chocount++;
                    }
                } else {
                     if(vital.getCholesterol()<=180 && vital.getCholesterol()>239)
                    {
                        chocount++;
                    }

                }

            }
        }
             if (resprateflag == 1) {
            for (VitalSigns vital : request.getVitalSignHistory().getVitalSignList()) {
                if (vital.getAge() >= 10 && vital.getAge() < 20) {
                    if(vital.getRespiratioRate()>12 && vital.getRespiratioRate()<25)
                    {
                        rrcount++;
                    }
                } else if (vital.getAge() >= 20 && vital.getAge() < 30) {
                     if(vital.getRespiratioRate()>12 && vital.getRespiratioRate()<30)
                    {
                        rrcount++;
                    }
                } else if (vital.getAge() >= 30 && vital.getAge() < 40) {
                     if(vital.getRespiratioRate()>12 && vital.getRespiratioRate()<30)
                    {
                        rrcount++;
                    }
                } else if (vital.getAge() >= 40 && vital.getAge() < 50) {
                     if(vital.getRespiratioRate()>12 && vital.getRespiratioRate()<30)
                    {
                        rrcount++;
                    }
                } else if (vital.getAge() >= 50 && vital.getAge() < 60) {
                     if(vital.getRespiratioRate()>12 && vital.getRespiratioRate()<30)
                    {
                        rrcount++;
                    }
                } else {
                     if(vital.getRespiratioRate()>10 && vital.getRespiratioRate()<35)
                    {
                        rrcount++;
                    }
                }

            }
        }
             
               if (tempflag == 1) {
           for (VitalSigns vital : request.getVitalSignHistory().getVitalSignList()) {
                if (vital.getBodyTemperature() < 97.5 || vital.getBodyTemperature()>99.5) {
                    tempflag++;

                }
            }
        }
            if (hrflag == 1) {
            for (VitalSigns vital : request.getVitalSignHistory().getVitalSignList()) {
                if (vital.getAge() >= 10 && vital.getAge() < 20) {
                    if(vital.getHeartRate()<75 || vital.getHeartRate()>150)
                    {
                        hrcount++;
                    }
                } else if (vital.getAge() >= 20 && vital.getAge() < 30) {
                     if(vital.getHeartRate()<95 || vital.getHeartRate()>170)
                    {
                        hrcount++;
                    }
                } else if (vital.getAge() >= 30 && vital.getAge() < 40) {
                     if(vital.getHeartRate()<90 || vital.getHeartRate()>160)
                    {
                        hrcount++;
                    }
                } else if (vital.getAge() >= 40 && vital.getAge() < 50) {
                     if(vital.getHeartRate()<85 || vital.getHeartRate()>150)
                    {
                        hrcount++;
                    }
                } else if (vital.getAge() >= 50 && vital.getAge() < 60) {
                     if(vital.getHeartRate()<80 || vital.getHeartRate()>136)
                    {
                        hrcount++;
                    }
                } else {
                     if(vital.getHeartRate()<75 || vital.getHeartRate()>135)
                    {
                        hrcount++;
                    }
                }

            }
        }
        if (sysbpcount >= 3) {
            result = result + "the patient has constantly high Blood pressure." + "\n" + "Patient has a danger of following things:" + "\n" + "heart attack, heart failure and hypertensive kidney disease. "+"\n" +"\n"+"\n";

        }
        if(bloodsugarcount>=3)
        {
            result=result+"The patient doen't have proper sugar level" +"\n" + "He may have chances of " +"\n"
                    +"Cardiovascular disease" +"\n"+"Nerve damage (neuropathy)"+"\n"+"Kidney damage (nephropathy) or kidney failure,Damage to the blood vessels of the retina (diabetic retinopathy), potentially leading to blindness"
                    +"\n" +"Clouding of the normally clear lens of your eye (cataract)" +"\n"+"Feet problems caused by damaged nerves or poor blood flow that can lead to serious infections"+"\n" +"\n"+"\n";
            
        }
        if(bloodhbcount>=3)
        {
            result=result+"The patient doen't have proper Blood Haemoglobin level" +"\n" + "He may have chances of " +"\n"
                   + "Peripheral cyanosis and impaired mental function resulting from compromised cerebral blood circulation are the two most common symptoms of elevated hemoglobin"
                    +"\n" +"Additionally, because of the poor blood flow, the risk of thrombo-embolism increases significantly."+"\n"+"\n"+"\n";
        }
        if(phcount>=3)
        {
            result=result+"The patient doen't have proper Blood Ph level" +"\n" + "He may have chances of " +"\n"+"Arrhythmia"+"\n" +
"Coma"+"\n" +
"Low Potassium Levels"+"\n" +
"Impaired Organ Function"+"\n" +
"Respiratory Failure"+"\n" +
"Seizures"+"\n" +
"Shock or Death"+"\n"+"\n"+"\n";
        }
        if(dbpcount>=3)
        {
            result=result+"The patient doen't have proper Distolic Blood Pressure level" +"\n" + "He may have chances of " +"\n"+"Prehypertension"+"\n"
                    +"60 percent of diabetics also have high blood pressure."+"\n" +"\n"+"\n";
        }
        if(chocount>=3)
        {
            result=result+"The patient doen't have proper Cholesterol level" +"\n" + "He may have chances of " +"\n"+"heart disease"+"\n" +"stroke and peripheral artery disease."+"\n" +"\n"+"\n";
        }
        if(tempcount>=3)
        {
         result="\n" +result+"The patient doen't have proper Body Temperature" +"\n" + "He may have chances of " +"\n"+"Thyphoid"+"\n"+"Maleria"+"\n" +"\n"+"\n";   
        }
        if(hrcount>=3)
        {
            result="\n" +result+"The patient doen't have proper heart rate" +"\n" + "He may have chances of " +"\n"+"Dizziness"+"\n" +
"Lightheadedness"+"\n" +
"Rapid heartbeat or palpitations"+"\n" +
"Angina (chest pain),Shortness of breath" +"\n"+
"--In extreme cases, atrial or SVT may cause Unconsciousness and Cardiac arrest"+"\n" +"\n"+"\n";
        }
        if(rrcount>=3)
        {
            result="\n" +result+"The patient doen't have proper Respiration Rate" +"\n" + "He may have chances of " +"\n"+"Heart attack"+"\n" +
"Lung disorders"+"\n" +
"Asthma"+"\n" +
"Bronchitis"+"\n" +
"Chronic bronchitis"+"\n" +
"Emphysema"+"\n" +
"Pneumonia"+"\n" +"\n"+"\n";
        }
        area1.setText(result);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        area1 = new javax.swing.JTextArea();
        bckbtm = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("The patient has following Parameters to be looked for as they are in high Range constantly:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 41, -1, -1));

        area1.setColumns(20);
        area1.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        area1.setRows(5);
        jScrollPane1.setViewportView(area1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 81, 1280, 860));

        bckbtm.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        bckbtm.setText("<< BACK");
        bckbtm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bckbtmActionPerformed(evt);
            }
        });
        add(bckbtm, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 980, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\ruchi\\Documents\\NetBeansProjects\\JavaApplication11\\src\\userInterface\\Alien Ink 2560X1600 Abstract Background.jpg")); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1640, 1490));
    }// </editor-fold>//GEN-END:initComponents

    private void bckbtmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bckbtmActionPerformed
     userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);        // TODO add your handling code here:
    }//GEN-LAST:event_bckbtmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area1;
    private javax.swing.JButton bckbtm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
