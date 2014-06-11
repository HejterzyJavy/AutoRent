/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beany;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import pl.pai2.autorent3.encje.Samochod;
import pl.pai2.autorent3.encje.SamochodFacade;

/**
 *
 * @author Karol
 */
@ManagedBean 
@SessionScoped
public class SamochodManagedBean implements Serializable {
    @EJB
    private SamochodFacade samochodFacade;
    private Samochod samochod;
     private Samochod selectedCar;

    /**
     * Creates a new instance of SamochodManagedBean
     */
    public SamochodManagedBean() {
        this.samochod = new Samochod();
    }
    
    public List<Samochod> getCars() {
        return samochodFacade.findAll();
    }
    
    public Samochod getSelectedCar() {
        return selectedCar;
    }
     public void setSelectedCar(Samochod selectedCar) {
         System.out.println(selectedCar.toString());
        this.selectedCar = selectedCar;
    }
    
}
