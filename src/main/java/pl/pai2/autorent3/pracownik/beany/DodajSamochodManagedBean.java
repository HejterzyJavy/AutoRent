/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.pai2.autorent3.pracownik.beany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import pl.pai2.autorent3.encje.Samochod;
import pl.pai2.autorent3.encje.SamochodController;
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
    private String[] wybraneWyposazenie;
    private List<String> elementy;
    
    
     @PostConstruct
    public void init() {
        elementy = new ArrayList<String>();
        elementy.add("Naped 4x4");
        elementy.add("Centralny zamek");
        elementy.add("Czujnik deszczu");
        elementy.add("Czujnik parkowania");
        elementy.add("Elektryczne lusterka");
        elementy.add("Elektryczne szyby");
        elementy.add("Klimatyzacja");
        elementy.add("Komputer pokładowy");
        elementy.add("Podgrzewane fotele");
        elementy.add("Radio");
        elementy.add("Nawigacja");
        elementy.add("Skorzana tapicerka");
        elementy.add("Tempomat");
        elementy.add("Wspomaganie kierownicy");
        elementy.add("Auto alarm");
        elementy.add("Esp");
        elementy.add("Poduszki powietrzne");
        elementy.add("Alu felgi");
        elementy.add("Dodatkowy bagaznik");
        elementy.add("Hak");
        elementy.add("Ksenony");
        elementy.add("Przyciemniane szyby");
        elementy.add("Szyber dach");
        elementy.add("Automatyczna skrzynia biegow");
        
    }

    public String[] getWybraneWyposazenie() {
        return wybraneWyposazenie;
    }

    public void setWybraneWyposazenie(String[] wybraneWyposazenie) {
        this.wybraneWyposazenie = wybraneWyposazenie;
    }

    public List<String> getElementy() {
        return elementy;
    }

    public void setElementy(List<String> elementy) {
        this.elementy = elementy;
    }
    


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
