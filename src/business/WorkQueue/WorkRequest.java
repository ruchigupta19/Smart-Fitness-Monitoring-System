/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import business.VitalSigns.VitalSigns;
import business.VitalSigns.VitalSignsHistory;
import java.util.Date;

/**
 *
 * @author ruchi
 */
public abstract class WorkRequest {

    private String message;
    private UserAccount patientSender;
    private UserAccount receptionistSender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private VitalSigns vitalSigns;
    private VitalSignsHistory vitalSignHistory;
    private UserAccount doctorSender;
    private String medicines;
    private UserAccount salesperson;
    private UserAccount deliveryBoy;
    private String orderId;
    private int TotAmount;

    public WorkRequest() {
        requestDate = new Date();
    }

    public int getTotAmount() {
        return TotAmount;
    }

    public void setTotAmount(int TotAmount) {
        this.TotAmount = TotAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public UserAccount getPatientSender() {
        return patientSender;
    }

    public UserAccount getDeliveryBoy() {
        return deliveryBoy;
    }

    public void setDeliveryBoy(UserAccount deliveryBoy) {
        this.deliveryBoy = deliveryBoy;
    }

    public UserAccount getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(UserAccount salesperson) {
        this.salesperson = salesperson;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public void setPatientSender(UserAccount patientSender) {
        this.patientSender = patientSender;
    }

    public UserAccount getDoctorSender() {
        return doctorSender;
    }

    public void setDoctorSender(UserAccount doctorSender) {
        this.doctorSender = doctorSender;
    }

    public UserAccount getReceptionistSender() {
        return receptionistSender;
    }

    public void setReceptionistSender(UserAccount receptionistSender) {
        this.receptionistSender = receptionistSender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public VitalSigns getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }

    public VitalSignsHistory getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(VitalSignsHistory vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    @Override
    public String toString() {
        return message;
    }

}
