package pl.pai2.autorent3.encje;

import pl.pai2.autorent3.encje.util.JsfUtil;
import pl.pai2.autorent3.encje.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped
;import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("wypozyczenieController")
@SessionScoped
public class WypozyczenieController implements Serializable {

    @EJB
    private pl.pai2.autorent3.encje.WypozyczenieFacade ejbFacade;
    private List<Wypozyczenie> items = null;
    private Wypozyczenie selected;
    private String okresWypozyczenia;
    private String kosztWypozyczenia ;
    private ArrayList<String> elementy ;
    private Wyposazenie wyp;
    

    public ArrayList<String> getElementy() {
        if(selected != null){
           if( selected.getSamochodId().getWyposazenie().getNaped4x4()) elementy.add("Naped 4x4");
            if( selected.getSamochodId().getWyposazenie().getCentralnyZamek())elementy.add("Centralny zamek");
            if( selected.getSamochodId().getWyposazenie().getCzujnikDeszczu())   elementy.add("Czujnik deszczu");
            if( selected.getSamochodId().getWyposazenie().getCzujnikParkowania())  elementy.add("Czujnik parkowania");
            if( selected.getSamochodId().getWyposazenie().getElektrLusterka())  elementy.add("Elektryczne lusterka");
            if( selected.getSamochodId().getWyposazenie().getEleSzyby()) elementy.add("Elektryczne szyby");
            if( selected.getSamochodId().getWyposazenie().getKilmatyzacja()) elementy.add("Klimatyzacja");
            if( selected.getSamochodId().getWyposazenie().getKomputerPokladowy())   elementy.add("Komputer pokładowy");
            if( selected.getSamochodId().getWyposazenie().getPodgrzFotele())elementy.add("Podgrzewane fotele");
            if( selected.getSamochodId().getWyposazenie().getRadio()) elementy.add("Radio");
            if( selected.getSamochodId().getWyposazenie().getNawigacja())  elementy.add("Nawigacja");
            if( selected.getSamochodId().getWyposazenie().getSkorzanaTapicerka())  elementy.add("Skorzana tapicerka");
            if( selected.getSamochodId().getWyposazenie().getTempomat())elementy.add("Tempomat");
            if( selected.getSamochodId().getWyposazenie().getWspKierownicy())elementy.add("Wspomaganie kierownicy");
            if( selected.getSamochodId().getWyposazenie().getAutoAlarm())elementy.add("Auto alarm");
            if( selected.getSamochodId().getWyposazenie().getEsp())elementy.add("Esp");
            if( selected.getSamochodId().getWyposazenie().getPoduszkiPowietrzne())elementy.add("Poduszki powietrzne");
            if( selected.getSamochodId().getWyposazenie().getAluFelgi())  elementy.add("Alu felgi");
            if( selected.getSamochodId().getWyposazenie().getDodatkowyBagaznik()) elementy.add("Dodatkowy bagaznik");
            if( selected.getSamochodId().getWyposazenie().getHak())elementy.add("Hak");
            if( selected.getSamochodId().getWyposazenie().getKsenony())elementy.add("Ksenony");
            if( selected.getSamochodId().getWyposazenie().getPrzycSzyby()) elementy.add("Przyciemniane szyby");
            if( selected.getSamochodId().getWyposazenie().getSzyberDach())  elementy.add("Szyber dach");
            if( selected.getSamochodId().getWyposazenie().getAutomatycznaSkrzynia()) elementy.add("Automatyczna skrzynia biegow"); 
        } else elementy.add("PUSTE");
        return elementy;
    }

    public void setElementy(ArrayList<String> elementy) {
        this.elementy = elementy;
    }

    public String getKosztWypozyczenia() {
        Integer koszt;
        
        if (selected.getDataWypozyczenia() == null || selected.getDataZwrotu() == null) {
            return ("0");
        } else {
        koszt = Integer.parseInt(this.okresWypozyczenia) * selected.getSamochodId().getCenaDoba();
       selected.setKosztCalkowity(koszt);
        return Integer.toString(koszt);
        }
    }

    public void setKosztWypozyczenia(String kosztWypozyczenia) {
        this.kosztWypozyczenia = kosztWypozyczenia;
    }

    public WypozyczenieController() {
    }

    public Wypozyczenie getSelected() {
        if (selected == null) {
            return selected = new Wypozyczenie();
        }
        return selected;
    }

    public void setSelected(Wypozyczenie selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private WypozyczenieFacade getFacade() {
        return ejbFacade;
    }

    public Wypozyczenie prepareCreate() {
        selected = new Wypozyczenie();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("WypozyczenieCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("WypozyczenieUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("WypozyczenieDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Wypozyczenie> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public String getOkresWypozyczenia() {
        if (selected.getDataWypozyczenia() == null || selected.getDataZwrotu() == null) {
            return ("Nie wybrano daty");
        } else {
            long diff = selected.getDataZwrotu().getTime() - selected.getDataWypozyczenia().getTime();
            if (diff<0) return("Data zwrotu musi być poźniej od daty wypożyczenia");
            String message = String.format("" + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            this.okresWypozyczenia = message;
            return (message);
        }
    }

    public void setOkresWypozyczenia(String okresWypozyczenia) {
        this.okresWypozyczenia = okresWypozyczenia;
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

    public Wypozyczenie getWypozyczenie(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Wypozyczenie> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Wypozyczenie> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Wypozyczenie.class)
    public static class WypozyczenieControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            WypozyczenieController controller = (WypozyczenieController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "wypozyczenieController");
            return controller.getWypozyczenie(getKey(value));
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
            if (object instanceof Wypozyczenie) {
                Wypozyczenie o = (Wypozyczenie) object;
                return getStringKey(o.getIdWypozyczenie());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Wypozyczenie.class.getName()});
                return null;
            }
        }

    }

}
