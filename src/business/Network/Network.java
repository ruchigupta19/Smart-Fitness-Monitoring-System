/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import java.util.Date;

/**
 *
 * @author ruchi
 */
public class Network {

    private String name;
    private String Geography;
    private String Continent;
    private Date date;
    private EnterpriseDirectory enterpriseDirectory;

    public Network() {
        enterpriseDirectory = new EnterpriseDirectory();
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public String getGeography() {
        return Geography;
    }

    public void setGeography(String Geography) {
        this.Geography = Geography;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String Continent) {
        this.Continent = Continent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
