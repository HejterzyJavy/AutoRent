/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beany;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import pl.pai2.autorent3.encje.Samochod;

/**
 *
 * @author Karol
 */
@ManagedBean 
@SessionScoped
public class SamochodManagedBean implements Serializable {
    private Samochod samochod;
     private Samochod selectedCar;

    /**
     * Creates a new instance of SamochodManagedBean
     */
    public SamochodManagedBean() {
        this.samochod = new Samochod();
    }
    

    
    public Samochod getSelectedCar() {
        return selectedCar;
    }
     public void setSelectedCar(Samochod selectedCar) {
        this.selectedCar = selectedCar;
    }
    
}
