package controller;

import CajaUnapec2.ServFacturable;
import CajaUnapec2.FacturaFinal;
import java.util.Collection;
import facade.ServFacturableFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "servFacturableController")
@ViewScoped
public class ServFacturableController extends AbstractController<ServFacturable> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isFacturaFinalCollectionEmpty;

    public ServFacturableController() {
        // Inform the Abstract parent controller of the concrete ServFacturable Entity
        super(ServFacturable.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsFacturaFinalCollectionEmpty();
    }

    public boolean getIsFacturaFinalCollectionEmpty() {
        return this.isFacturaFinalCollectionEmpty;
    }

    private void setIsFacturaFinalCollectionEmpty() {
        ServFacturable selected = this.getSelected();
        if (selected != null) {
            ServFacturableFacade ejbFacade = (ServFacturableFacade) this.getFacade();
            this.isFacturaFinalCollectionEmpty = ejbFacade.isFacturaFinalCollectionEmpty(selected);
        } else {
            this.isFacturaFinalCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of FacturaFinal entities
     * that are retrieved from ServFacturable and returns the navigation
     * outcome.
     *
     * @return navigation outcome for FacturaFinal page
     */
    public String navigateFacturaFinalCollection() {
        ServFacturable selected = this.getSelected();
        if (selected != null) {
            ServFacturableFacade ejbFacade = (ServFacturableFacade) this.getFacade();
            Collection<FacturaFinal> selectedFacturaFinalCollection = ejbFacade.findFacturaFinalCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FacturaFinal_items", selectedFacturaFinalCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/facturaFinal/index";
    }

}
