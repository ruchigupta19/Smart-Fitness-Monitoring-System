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
public class InitializeDrug {

    private DrugCatalog dc;

    public InitializeDrug(DrugCatalog drugCatalog) {
        this.dc = drugCatalog;
        dc.addDrug(new Drug("Ranitidine", "13-10-2015", "050 mg", "B ID-100", "15 C", "Baxter", "20"));
        dc.addDrug(new Drug("Aspirin", "14-10-2015", "100 mg", "B ID-200", "19 C", "Baxter", "40"));
        dc.addDrug(new Drug("Multivitamins", "19-10-2015", "060 mg", "B ID-300", "26 C", "Baxter", "10"));
        dc.addDrug(new Drug("Ibuprofen", "16-10-2015", "070 mg", "B ID-400", "09 C", "Baxter", "30"));
        dc.addDrug(new Drug("Diclofenac", "26-10-2015", "150 mg", "B ID-500", "06 C", "Baxter", "50"));
        dc.addDrug(new Drug("Tylenol", "13-10-2015", "050 mg", "B ID-600", "15 C", "Baxter", "20"));
        dc.addDrug(new Drug("Advil", "14-10-2015", "100 mg", "B ID-700", "19 C", "Baxter", "40"));
        dc.addDrug(new Drug("hydralyzin", "19-10-2015", "060 mg", "B ID-800", "26 C", "Baxter", "10"));
        dc.addDrug(new Drug("Mucinex", "16-10-2015", "070 mg", "B ID-900", "09 C", "Baxter", "30"));
        dc.addDrug(new Drug("Atenolol", "26-10-2015", "150 mg", "B ID-1000", "06 C", "Baxter", "50"));
        dc.addDrug(new Drug("Propanolol", "29-10-2015", "100 mg", "B ID-1001", "20 C", "Baxter", "60"));
        dc.addDrug(new Drug("Acebutanol", "10-11-2015", "150 mg", "B ID-1002", "12 C", "Baxter", "50"));
        dc.addDrug(new Drug("Hydrochlorothiazide", "19-12-2015", "10 mg", "B ID-1003", "10 C", "Baxter", "90"));
        dc.addDrug(new Drug("Furosemide", "01-10-2015", "100 mg", "B ID-1004", "09 C", "Baxter", "150"));
        dc.addDrug(new Drug("Metoprolol", "29-10-2015", "50 mg", "B ID-1005", "08 C", "Baxter", "70"));
        dc.addDrug(new Drug("Captopril", "18-10-2015", "150 mg", "B ID-1006", "15 C", "Baxter", "30"));
        dc.addDrug(new Drug("Metformin", "30-10-2015", "100 mg", "B ID-1007", "07 C", "Baxter", "70"));
        dc.addDrug(new Drug("Omeprazole", "30-10-2015", "100 mg", "B ID-1007", "07 C", "Baxter", "70"));
        dc.addDrug(new Drug("Lipitor", "30-10-2015", "100 mg", "B ID-1007", "07 C", "Baxter", "70"));
        dc.addDrug(new Drug("Glimeperide", "30-10-2015", "100 mg", "B ID-1007", "07 C", "Baxter", "70"));
        dc.addDrug(new Drug("Calpol", "30-10-2015", "100 mg", "B ID-1007", "07 C", "Baxter", "70"));
        dc.addDrug(new Drug("Paracetamol", "30-10-2015", "100 mg", "B ID-1007", "07 C", "Baxter", "70"));
        dc.addDrug(new Drug("Benadryl", "30-10-2015", "100 mg", "B ID-1007", "07 C", "Baxter", "70"));

    }
}
