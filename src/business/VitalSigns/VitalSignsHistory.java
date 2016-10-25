/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.VitalSigns;

import java.util.ArrayList;

/**
 *
 * @author ruchi
 */
public class VitalSignsHistory {

    private ArrayList<VitalSigns> vitalSignList;

    public VitalSignsHistory() {
        vitalSignList = new ArrayList<>();
    }

    public ArrayList<VitalSigns> getVitalSignList() {
        return vitalSignList;
    }

    public void setVitalSignList(ArrayList<VitalSigns> vitalSignList) {
        this.vitalSignList = vitalSignList;
    }

    public VitalSigns createVitalSign() {
        VitalSigns vs = new VitalSigns();
        vitalSignList.add(vs);
        return vs;
    }

    public void removeVitalSign(VitalSigns v) {
        vitalSignList.remove(v);
    }
}
