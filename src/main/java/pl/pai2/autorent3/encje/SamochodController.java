package pl.pai2.autorent3.encje;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import pl.pai2.autorent3.encje.util.JsfUtil;
import pl.pai2.autorent3.encje.util.JsfUtil.PersistAction;

@Named("samochodController")
@SessionScoped
public class SamochodController implements Serializable {
    
    

    @EJB
    private pl.pai2.autorent3.encje.SamochodFacade ejbFacade;
    private List<Samochod> items = null;
    private Samochod selected;
    private List<String> elementy;
    private String[] wybraneWyposazenie;

    public List<String> getElementy() {
        return elementy;
    }

    public void setElementy(List<String> elementy) {
        this.elementy = elementy;
    }

    public String[] getWybraneWyposazenie() {
        return wybraneWyposazenie;
    }

    public void setWybraneWyposazenie(String[] wybraneWyposazenie) {
        this.wybraneWyposazenie = wybraneWyposazenie;
    }
    
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

    public SamochodController() {
    }

    public Samochod getSelected() {
        return selected;
    }

    public void setSelected(Samochod selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SamochodFacade getFacade() {
        return ejbFacade;
    }

    public Samochod prepareCreate() {
        selected = new Samochod();
        selected.setTypSamochoduId( new TypSamochodu());
        selected.setWyposazenie(new Wyposazenie());
        selected.setOddzialId(new Oddzial());
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        stringToElements(wybraneWyposazenie);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SamochodCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SamochodUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SamochodDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Samochod> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Samochod getSamochod(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Samochod> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Samochod> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }
    
     public void handleFileUpload(FileUploadEvent event) {
        try {
            InputStream inputStream = event.getFile().getInputstream();
            
            int read = 0;
            byte[] bytes =  IOUtils.toByteArray(inputStream);
            selected.setZdjecie(bytes);
            inputStream.close();
  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
        public void stringToElements(String[] wybrane){
               
      
        for (String tmp : wybrane) {
            if(tmp.equals(elementy.get(0))) selected.getWyposazenie().setNaped4x4(true);
            if(tmp.equals(elementy.get(1))) selected.getWyposazenie().setCentralnyZamek(true);
            if(tmp.equals(elementy.get(2))) selected.getWyposazenie().setCzujnikDeszczu(true);
            if(tmp.equals(elementy.get(3))) selected.getWyposazenie().setCzujnikParkowania(true);
            if(tmp.equals(elementy.get(4))) selected.getWyposazenie().setElektrLusterka(true);
            if(tmp.equals(elementy.get(5))) selected.getWyposazenie().setEleSzyby(true);
            if(tmp.equals(elementy.get(6))) selected.getWyposazenie().setKilmatyzacja(true);
            if(tmp.equals(elementy.get(7))) selected.getWyposazenie().setKomputerPokladowy(true);
            if(tmp.equals(elementy.get(8))) selected.getWyposazenie().setPodgrzFotele(true);
            if(tmp.equals(elementy.get(9))) selected.getWyposazenie().setRadio(true);
            if(tmp.equals(elementy.get(10))) selected.getWyposazenie().setNawigacja(true);
            if(tmp.equals(elementy.get(11))) selected.getWyposazenie().setSkorzanaTapicerka(true);
            if(tmp.equals(elementy.get(12))) selected.getWyposazenie().setTempomat(true);
            if(tmp.equals(elementy.get(13))) selected.getWyposazenie().setWspKierownicy(true);
            if(tmp.equals(elementy.get(14))) selected.getWyposazenie().setAutoAlarm(true);
            if(tmp.equals(elementy.get(15))) selected.getWyposazenie().setEsp(true);
            if(tmp.equals(elementy.get(16))) selected.getWyposazenie().setPoduszkiPowietrzne(true);
            if(tmp.equals(elementy.get(17))) selected.getWyposazenie().setAluFelgi(true);
            if(tmp.equals(elementy.get(18))) selected.getWyposazenie().setDodatkowyBagaznik(true);
            if(tmp.equals(elementy.get(19))) selected.getWyposazenie().setHak(true);
            if(tmp.equals(elementy.get(20))) selected.getWyposazenie().setKsenony(true);
            if(tmp.equals(elementy.get(21))) selected.getWyposazenie().setPrzycSzyby(true);
            if(tmp.equals(elementy.get(22))) selected.getWyposazenie().setSzyberDach(true);
            if(tmp.equals(elementy.get(23))) selected.getWyposazenie().setAutomatycznaSkrzynia(true); 
        }
        
  
         
     }
     
   
     
     
    
 
     
    
    

    @FacesConverter(forClass = Samochod.class)
    public static class SamochodControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SamochodController controller = (SamochodController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "samochodController");
            return controller.getSamochod(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Samochod) {
                Samochod o = (Samochod) object;
                return getStringKey(o.getIdSamochod());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Samochod.class.getName()});
                return null;
            }
        }

    }
    
   

}
