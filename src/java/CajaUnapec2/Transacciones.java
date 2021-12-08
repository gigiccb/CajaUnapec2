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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gianna Cedeño
 */
@Entity
@Table(name = "TRANSACCIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacciones.findAll", query = "SELECT t FROM Transacciones t")
    , @NamedQuery(name = "Transacciones.findByIdTransaccion", query = "SELECT t FROM Transacciones t WHERE t.idTransaccion = :idTransaccion")
    , @NamedQuery(name = "Transacciones.findByIdCliente", query = "SELECT t FROM Transacciones t WHERE t.idCliente = :idCliente")
    , @NamedQuery(name = "Transacciones.findByTipoMovimiento", query = "SELECT t FROM Transacciones t WHERE t.tipoMovimiento = :tipoMovimiento")
    , @NamedQuery(name = "Transacciones.findByMontoTransaccion", query = "SELECT t FROM Transacciones t WHERE t.montoTransaccion = :montoTransaccion")})
public class Transacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TRANSACCION")
    private Integer idTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TIPO_MOVIMIENTO")
    private String tipoMovimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO_TRANSACCION")
    private double montoTransaccion;

    public Transacciones() {
    }

    public Transacciones(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Transacciones(Integer idTransaccion, int idCliente, String tipoMovimiento, double montoTransaccion) {
        this.idTransaccion = idTransaccion;
        this.idCliente = idCliente;
        this.tipoMovimiento = tipoMovimiento;
        this.montoTransaccion = montoTransaccion;
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public double getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(double montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaccion != null ? idTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacciones)) {
            return false;
        }
        Transacciones other = (Transacciones) object;
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
     public String toString() {
        //return "com.jp.entity.Transacciones[ idTransaccion=" + idTransaccion + " ]";
        return idCliente + ":"  + tipoMovimiento +  ":" + montoTransaccion;
    }
    
}
