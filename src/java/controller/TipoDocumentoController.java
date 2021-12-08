package controller;

import CajaUnapec2.TipoDocumento;
import CajaUnapec2.FacturaFinal;
import java.util.Collection;
import facade.TipoDocumentoFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoDocumentoController")
@ViewScoped
public class TipoDocumentoController extends AbstractController<TipoDocumento> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isFacturaFinalCollectionEmpty;

    public TipoDocumentoController() {
        // Inform the Abstract parent controller of the concrete TipoDocumento Entity
        super(TipoDocumento.class);
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
        TipoDocumento selected = this.getSelected();
        if (selected != null) {
            TipoDocumentoFacade ejbFacade = (TipoDocumentoFacade) this.getFacade();
            this.isFacturaFinalCollectionEmpty = ejbFacade.isFacturaFinalCollectionEmpty(selected);
        } else {
            this.isFacturaFinalCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of FacturaFinal entities
     * that are retrieved from TipoDocumento and returns the navigation outcome.
     *
     * @return navigation outcome for FacturaFinal page
     */
    public String navigateFacturaFinalCollection() {
        TipoDocumento selected = this.getSelected();
        if (selected != null) {
            TipoDocumentoFacade ejbFacade = (TipoDocumentoFacade) this.getFacade();
            Collection<FacturaFinal> selectedFacturaFinalCollection = ejbFacade.findFacturaFinalCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("FacturaFinal_items", selectedFacturaFinalCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/facturaFinal/index";
    }

}
