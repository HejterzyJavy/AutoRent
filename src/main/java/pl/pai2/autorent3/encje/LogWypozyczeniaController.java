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

@Named("logWypozyczeniaController")
@SessionScoped
public class LogWypozyczeniaController implements Serializable {

    @EJB
    private pl.pai2.autorent3.encje.LogWypozyczeniaFacade ejbFacade;
    private List<LogWypozyczenia> items = null;
    private LogWypozyczenia selected;

    public LogWypozyczeniaController() {
    }

    public LogWypozyczenia getSelected() {
        return selected;
    }

    public void setSelected(LogWypozyczenia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private LogWypozyczeniaFacade getFacade() {
        return ejbFacade;
    }

    public LogWypozyczenia prepareCreate() {
        selected = new LogWypozyczenia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("LogWypozyczeniaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("LogWypozyczeniaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("LogWypozyczeniaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<LogWypozyczenia> getItems() {
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

    public LogWypozyczenia getLogWypozyczenia(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<LogWypozyczenia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<LogWypozyczenia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = LogWypozyczenia.class)
    public static class LogWypozyczeniaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LogWypozyczeniaController controller = (LogWypozyczeniaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "logWypozyczeniaController");
            return controller.getLogWypozyczenia(getKey(value));
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
            if (object instanceof LogWypozyczenia) {
                LogWypozyczenia o = (LogWypozyczenia) object;
                return getStringKey(o.getIdLog());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), LogWypozyczenia.class.getName()});
                return null;
            }
        }

    }

}
