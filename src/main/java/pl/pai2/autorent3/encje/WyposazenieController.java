package pl.pai2.autorent3.encje;

import pl.pai2.autorent3.encje.util.JsfUtil;
import pl.pai2.autorent3.encje.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("wyposazenieController")
@SessionScoped
public class WyposazenieController implements Serializable {

    @EJB
    private pl.pai2.autorent3.encje.WyposazenieFacade ejbFacade;
    private List<Wyposazenie> items = null;
    private Wyposazenie selected;
   

    public WyposazenieController() {
    }

    public Wyposazenie getSelected() {
        return selected;
    }

    public void setSelected(Wyposazenie selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private WyposazenieFacade getFacade() {
        return ejbFacade;
    }

    public Wyposazenie prepareCreate() {
        selected = new Wyposazenie();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("WyposazenieCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("WyposazenieUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("WyposazenieDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Wyposazenie> getItems() {
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

    public Wyposazenie getWyposazenie(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Wyposazenie> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Wyposazenie> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }
    
 

    @FacesConverter(forClass = Wyposazenie.class)
    public static class WyposazenieControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            WyposazenieController controller = (WyposazenieController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "wyposazenieController");
            return controller.getWyposazenie(getKey(value));
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
            if (object instanceof Wyposazenie) {
                Wyposazenie o = (Wyposazenie) object;
                return getStringKey(o.getIdWyposazenie());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Wyposazenie.class.getName()});
                return null;
            }
        }
        
         

    }

}
