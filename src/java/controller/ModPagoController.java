package controller;

import CajaUnapec2.ModPago;
import CajaUnapec2.FacturaFinal;
import java.util.Collection;
import facade.ModPagoFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "modPagoController")
@ViewScoped
public class ModPagoController extends AbstractController<ModPago> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isFacturaFinalCollectionEmpty;

    public ModPagoController() {
        // Inform the Abstract parent controller of the concrete ModPago Entity
        super(ModPago.class);
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
        ModPago selected = this.getSelected();
        if (selected != null) {
            ModPagoFacade ejbFacade = (ModPagoFacade) this.getFacade();
            this.isFacturaFinalCollectionEmpty = ejbFacade.isFacturaFinalCollectionEmpty(selected);
        } else {
            this.isFacturaFinalCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of FacturaFinal entities
     * that are retrieved from ModPago and returns the navigation outcome.
     *
     * @return navigation outcome for FacturaFinal page
     */
    public String navigateFacturaFinalCollection() {
        ModPago selected = this.getSelected();
        if (selected != null) {
            ModPagoFacade ejbFacade = (ModPagoFacade) this.getFacade();
            Collection<FacturaFinal> selectedFacturaFinalCollection = ejbFacade.findFacturaFinalCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FacturaFinal_items", selectedFacturaFinalCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/facturaFinal/index";
    }

}
