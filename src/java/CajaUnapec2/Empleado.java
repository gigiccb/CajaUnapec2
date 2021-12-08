/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CajaUnapec2;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gianna Cedeño
 */
@Entity
@Table(name = "EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "Empleado.findByNombreEmpleado", query = "SELECT e FROM Empleado e WHERE e.nombreEmpleado = :nombreEmpleado")
    , @NamedQuery(name = "Empleado.findByCedulaEmpleado", query = "SELECT e FROM Empleado e WHERE e.cedulaEmpleado = :cedulaEmpleado")
    , @NamedQuery(name = "Empleado.findByTandaEmpleado", query = "SELECT e FROM Empleado e WHERE e.tandaEmpleado = :tandaEmpleado")
    , @NamedQuery(name = "Empleado.findByFechaIngresoEmpleado", query = "SELECT e FROM Empleado e WHERE e.fechaIngresoEmpleado = :fechaIngresoEmpleado")
    , @NamedQuery(name = "Empleado.findByEstadoEmpleado", query = "SELECT e FROM Empleado e WHERE e.estadoEmpleado = :estadoEmpleado")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMPLEADO")
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE_EMPLEADO")
    private String nombreEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEDULA_EMPLEADO")
    private int cedulaEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TANDA_EMPLEADO")
    private String tandaEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INGRESO_EMPLEADO")
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ESTADO_EMPLEADO")
    private String estadoEmpleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private Collection<FacturaFinal> facturaFinalCollection;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, String nombreEmpleado, int cedulaEmpleado, String tandaEmpleado, Date fechaIngresoEmpleado, String estadoEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.cedulaEmpleado = cedulaEmpleado;
        this.tandaEmpleado = tandaEmpleado;
        this.fechaIngresoEmpleado = fechaIngresoEmpleado;
        this.estadoEmpleado = estadoEmpleado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setCedulaEmpleado(int cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getTandaEmpleado() {
        return tandaEmpleado;
    }

    public void setTandaEmpleado(String tandaEmpleado) {
        this.tandaEmpleado = tandaEmpleado;
    }

    public Date getFechaIngresoEmpleado() {
        return fechaIngresoEmpleado;
    }

    public void setFechaIngresoEmpleado(Date fechaIngresoEmpleado) {
        this.fechaIngresoEmpleado = fechaIngresoEmpleado;
    }

    public String getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(String estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    @XmlTransient
    public Collection<FacturaFinal> getFacturaFinalCollection() {
        return facturaFinalCollection;
    }

    public void setFacturaFinalCollection(Collection<FacturaFinal> facturaFinalCollection) {
        this.facturaFinalCollection = facturaFinalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CajaUnapec2.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
