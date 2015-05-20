package entityclassesxhtml;

import entityclasses.Prodaja;
import entityclassesxhtml.util.JsfUtil;
import entityclassesxhtml.util.PaginationHelper;
import sessionbeans.ProdajaFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@ManagedBean(name = "prodajaController")
@SessionScoped
public class ProdajaController implements Serializable {

    private Prodaja current;
    private DataModel items = null;
    @EJB
    private sessionbeans.ProdajaFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public ProdajaController() {
    }

    public Prodaja getSelected() {
        if (current == null) {
            current = new Prodaja();
            current.setProdajaPK(new entityclasses.ProdajaPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private ProdajaFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Prodaja) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Prodaja();
        current.setProdajaPK(new entityclasses.ProdajaPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getProdajaPK().setProdizvodid(current.getProizvod().getProizvodid());
            current.getProdajaPK().setUserid(current.getUsers().getUser());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProdajaCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Prodaja) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getProdajaPK().setProdizvodid(current.getProizvod().getProizvodid());
            current.getProdajaPK().setUserid(current.getUsers().getUser());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProdajaUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Prodaja) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProdajaDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = Prodaja.class)
    public static class ProdajaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProdajaController controller = (ProdajaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "prodajaController");
            return controller.ejbFacade.find(getKey(value));
        }

        entityclasses.ProdajaPK getKey(String value) {
            entityclasses.ProdajaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entityclasses.ProdajaPK();
            key.setProdizvodid(Integer.parseInt(values[0]));
            key.setUserid(values[1]);
            return key;
        }

        String getStringKey(entityclasses.ProdajaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getProdizvodid());
            sb.append(SEPARATOR);
            sb.append(value.getUserid());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Prodaja) {
                Prodaja o = (Prodaja) object;
                return getStringKey(o.getProdajaPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Prodaja.class.getName());
            }
        }

    }

}
