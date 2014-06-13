/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.pai2.autorent3.pracownik.beany;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import pl.pai2.autorent3.encje.Samochod;
import pl.pai2.autorent3.encje.Wyposazenie;

/**
 *
 * @author Karol
 */
@ManagedBean(name="addSamochodWizard")
@ViewScoped
public class DodajSamochodManagedBean implements Serializable  {

   
    public DodajSamochodManagedBean() {
    }
    
    private Samochod samochod = new Samochod();
    private Wyposazenie wyposazenie = new Wyposazenie();
    private boolean skip;

    public Wyposazenie getWyposazenie() {
        return wyposazenie;
    }

    public void setWyposazenie(Wyposazenie wyposazenie) {
        this.wyposazenie = wyposazenie;
    }
     
     
    public Samochod getSamochod() {
        return samochod;
    }
 
    public void setSamochod(Samochod samochod) {
        this.samochod = samochod;
    }
     
    public void save() {        
        FacesMessage msg = new FacesMessage("Dodano pomyslnie");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
    
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
     
  
     
   
    
}
