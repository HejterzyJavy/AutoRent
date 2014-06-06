package pl.pai2.autorent3.encje;

import pl.pai2.autorent3.encje.util.JsfUtil;
import pl.pai2.autorent3.encje.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
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

@Named("daneKontaktoweController")
@SessionScoped
public class DaneKontaktoweController implements Serializable {

    @EJB
    private pl.pai2.autorent3.encje.DaneKontaktoweFacade ejbFacade;
    private List<DaneKontaktowe> items = null;
    private DaneKontaktowe selected;

    public DaneKontaktoweController() {
    }

    public DaneKontaktowe getSelected() {
        return selected;
    }

    public void setSelected(DaneKontaktowe selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DaneKontaktoweFacade getFacade() {
        return ejbFacade;
    }

    public DaneKontaktowe prepareCreate() {
        selected = new DaneKontaktowe();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DaneKontaktoweCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DaneKontaktoweUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DaneKontaktoweDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<DaneKontaktowe> getItems() {
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

    public DaneKontaktowe getDaneKontaktowe(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<DaneKontaktowe> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<DaneKontaktowe> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = DaneKontaktowe.class)
    public static class DaneKontaktoweControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DaneKontaktoweController controller = (DaneKontaktoweController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "daneKontaktoweController");
            return controller.getDaneKontaktowe(getKey(value));
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
            if (object instanceof DaneKontaktowe) {
                DaneKontaktowe o = (DaneKontaktowe) object;
                return getStringKey(o.getIdDaneKontaktowe());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DaneKontaktowe.class.getName()});
                return null;
            }
        }

    }

}
