/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Drug;

/**
 *
 * @author ruchi
 */
public class Drug {

    private String drugName;
    private static int counter = 0;
    private String expiryDate;
    private String power;
    private String batchId;
    private String storageTemp;
    private int id;
    private String supplier;
    private String price;

    public Drug(String s1, String ed, String p, String bId, String st, String supp, String pri) {
        counter++;
        id = counter;
        this.drugName = s1;
        this.expiryDate = ed;
        this.power = p;
        this.batchId = bId;
        this.storageTemp = st;
        this.supplier = supp;
        this.price = pri;

    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getStorageTemp() {
        return storageTemp;
    }

    public void setStorageTemp(String storageTemp) {
        this.storageTemp = storageTemp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return drugName;
    }

}
