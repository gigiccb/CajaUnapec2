package controller;

import CajaUnapec2.Cliente;
import CajaUnapec2.FacturaFinal;
import java.util.Collection;
import facade.ClienteFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "clienteController")
@ViewScoped
public class ClienteController extends AbstractController<Cliente> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isFacturaFinalCollectionEmpty;

    public ClienteController() {
        // Inform the Abstract parent controller of the concrete Cliente Entity
        super(Cliente.class);
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
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            this.isFacturaFinalCollectionEmpty = ejbFacade.isFacturaFinalCollectionEmpty(selected);
        } else {
            this.isFacturaFinalCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of FacturaFinal entities
     * that are retrieved from Cliente and returns the navigation outcome.
     *
     * @return navigation outcome for FacturaFinal page
     */
    public String navigateFacturaFinalCollection() {
        Cliente selected = this.getSelected();
        if (selected != null) {
            ClienteFacade ejbFacade = (ClienteFacade) this.getFacade();
            Collection<FacturaFinal> selectedFacturaFinalCollection = ejbFacade.findFacturaFinalCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FacturaFinal_items", selectedFacturaFinalCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/facturaFinal/index";
    }

}
