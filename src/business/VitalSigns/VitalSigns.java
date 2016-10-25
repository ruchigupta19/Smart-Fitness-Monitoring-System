/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.VitalSigns;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Date;

/**
 *
 * @author ruchi
 */
public class VitalSigns {

    double weight;
    double Sysbp;
    double dyspBp;
    double heartRate;
    double cholesterol;
    double pulseRate;
    double bloodSugarLevel;
    double respiratioRate;
    double bodyTemperature;
    double bloodHb;
    double bloodPh;
    double bmi;
    double height;
    Date currentDate;
    int age;
    String status;
    String deviceId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setCurrentDate() {
        this.currentDate = new Date();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSysbp() {
        return Sysbp;
    }

    public void setSysbp(double Sysbp) {
        this.Sysbp = Sysbp;
    }

    public double getDyspBp() {
        return dyspBp;
    }

    public void setDyspBp(double dyspBp) {
        this.dyspBp = dyspBp;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public double getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(double pulseRate) {
        this.pulseRate = pulseRate;
    }

    public double getBloodSugarLevel() {
        return bloodSugarLevel;
    }

    public void setBloodSugarLevel(double bloodSugarLevel) {
        this.bloodSugarLevel = bloodSugarLevel;
    }

    public double getRespiratioRate() {
        return respiratioRate;
    }

    public void setRespiratioRate(double respiratioRate) {
        this.respiratioRate = respiratioRate;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public double getBloodHb() {
        return bloodHb;
    }

    public void setBloodHb(double bloodHb) {
        this.bloodHb = bloodHb;
    }

    public double getBloodPh() {
        return bloodPh;
    }

    public void setBloodPh(double bloodPh) {
        this.bloodPh = bloodPh;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return String.valueOf(currentDate);
    }

}
