package controller;

import CajaUnapec2.FacturaFinal;
import facade.FacturaFinalFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "facturaFinalController")
@ViewScoped
public class FacturaFinalController extends AbstractController<FacturaFinal> {

    @Inject
    private ClienteController idClienteController;
    @Inject
    private EmpleadoController idEmpleadoController;
    @Inject
    private FormaDePagoController idFormaDePagoController;
    @Inject
    private ModPagoController idModPagoController;
    @Inject
    private ServFacturableController idServFacturableController;
    @Inject
    private TipoDocumentoController idDocumentoController;
    @Inject
    private MobilePageController mobilePageController;

    public FacturaFinalController() {
        // Inform the Abstract parent controller of the concrete FacturaFinal Entity
        super(FacturaFinal.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idClienteController.setSelected(null);
        idEmpleadoController.setSelected(null);
        idFormaDePagoController.setSelected(null);
        idModPagoController.setSelected(null);
        idServFacturableController.setSelected(null);
        idDocumentoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Cliente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCliente(ActionEvent event) {
        FacturaFinal selected = this.getSelected();
        if (selected != null && idClienteController.getSelected() == null) {
            idClienteController.setSelected(selected.getIdCliente());
        }
    }

    /**
     * Sets the "selected" attribute of the Empleado controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEmpleado(ActionEvent event) {
        FacturaFinal selected = this.getSelected();
        if (selected != null && idEmpleadoController.getSelected() == null) {
            idEmpleadoController.setSelected(selected.getIdEmpleado());
        }
    }

    /**
     * Sets the "selected" attribute of the FormaDePago controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdFormaDePago(ActionEvent event) {
        FacturaFinal selected = this.getSelected();
        if (selected != null && idFormaDePagoController.getSelected() == null) {
            idFormaDePagoController.setSelected(selected.getIdFormaDePago());
        }
    }

    /**
     * Sets the "selected" attribute of the ModPago controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdModPago(ActionEvent event) {
        FacturaFinal selected = this.getSelected();
        if (selected != null && idModPagoController.getSelected() == null) {
            idModPagoController.setSelected(selected.getIdModPago());
        }
    }

    /**
     * Sets the "selected" attribute of the ServFacturable controller in order
     * to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdServFacturable(ActionEvent event) {
        FacturaFinal selected = this.getSelected();
        if (selected != null && idServFacturableController.getSelected() == null) {
            idServFacturableController.setSelected(selected.getIdServFacturable());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoDocumento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDocumento(ActionEvent event) {
        FacturaFinal selected = this.getSelected();
        if (selected != null && idDocumentoController.getSelected() == null) {
            idDocumentoController.setSelected(selected.getIdDocumento());
        }
    }

}
