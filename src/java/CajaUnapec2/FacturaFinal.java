/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CajaUnapec2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gianna Cedeño
 */
@Entity
@Table(name = "FACTURA_FINAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaFinal.findAll", query = "SELECT f FROM FacturaFinal f")
    , @NamedQuery(name = "FacturaFinal.findByIdFacturaFinal", query = "SELECT f FROM FacturaFinal f WHERE f.idFacturaFinal = :idFacturaFinal")})
public class FacturaFinal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FACTURA_FINAL")
    private Integer idFacturaFinal;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    @JoinColumn(name = "ID_FORMA_DE_PAGO", referencedColumnName = "ID_FORMA_DE_PAGO")
    @ManyToOne(optional = false)
    private FormaDePago idFormaDePago;
    @JoinColumn(name = "ID_MOD_PAGO", referencedColumnName = "ID_MOD_PAGO")
    @ManyToOne(optional = false)
    private ModPago idModPago;
    @JoinColumn(name = "ID_SERV_FACTURABLE", referencedColumnName = "ID_SERV_FACTURABLE")
    @ManyToOne(optional = false)
    private ServFacturable idServFacturable;
    @JoinColumn(name = "ID_DOCUMENTO", referencedColumnName = "ID_DOCUMENTO")
    @ManyToOne(optional = false)
    private TipoDocumento idDocumento;

    public FacturaFinal() {
    }

    public FacturaFinal(Integer idFacturaFinal) {
        this.idFacturaFinal = idFacturaFinal;
    }

    public Integer getIdFacturaFinal() {
        return idFacturaFinal;
    }

    public void setIdFacturaFinal(Integer idFacturaFinal) {
        this.idFacturaFinal = idFacturaFinal;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public FormaDePago getIdFormaDePago() {
        return idFormaDePago;
    }

    public void setIdFormaDePago(FormaDePago idFormaDePago) {
        this.idFormaDePago = idFormaDePago;
    }

    public ModPago getIdModPago() {
        return idModPago;
    }

    public void setIdModPago(ModPago idModPago) {
        this.idModPago = idModPago;
    }

    public ServFacturable getIdServFacturable() {
        return idServFacturable;
    }

    public void setIdServFacturable(ServFacturable idServFacturable) {
        this.idServFacturable = idServFacturable;
    }

    public TipoDocumento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(TipoDocumento idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturaFinal != null ? idFacturaFinal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaFinal)) {
            return false;
        }
        FacturaFinal other = (FacturaFinal) object;
        if ((this.idFacturaFinal == null && other.idFacturaFinal != null) || (this.idFacturaFinal != null && !this.idFacturaFinal.equals(other.idFacturaFinal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CajaUnapec2.FacturaFinal[ idFacturaFinal=" + idFacturaFinal + " ]";
    }
    
}
