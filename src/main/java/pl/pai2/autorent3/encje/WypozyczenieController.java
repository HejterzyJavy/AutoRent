package pl.pai2.autorent3.encje;

import pl.pai2.autorent3.encje.util.JsfUtil;
import pl.pai2.autorent3.encje.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
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
    private String kosztWypozyczenia;

    public WypozyczenieController() {
    }

    public Wypozyczenie getSelected() {
        if(selected == null) return selected = new Wypozyczenie();
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
        if (selected.getDataWypozyczenia() == null || selected.getDataZwrotu()== null) {
            return ("No date selected.");
        } else {
            long diff = selected.getDataZwrotu().getTime() - selected.getDataWypozyczenia().getTime();
            String message        = String.format("" + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
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
