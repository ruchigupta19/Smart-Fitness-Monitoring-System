/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Drug;

import java.util.ArrayList;

/**
 *
 * @author ruchi
 */
public class DrugCatalog {

    private ArrayList<Drug> drugList;

    public DrugCatalog() {
        this.drugList = new ArrayList<>();
    }

    public ArrayList<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(ArrayList<Drug> drugList) {
        this.drugList = drugList;
    }

    public void addDrug(Drug d) {
        drugList.add(d);

    }

    public Drug searchDrug(String s) {
        for (Drug drug : drugList) {
            if (drug.getDrugName().equals(s)) {
                return drug;
            }
        }
        return null;
    }

}
