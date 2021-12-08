/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CajaUnapec2;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gianna Cedeño
 */
@Entity
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente")
    , @NamedQuery(name = "Cliente.findByTipoCliente", query = "SELECT c FROM Cliente c WHERE c.tipoCliente = :tipoCliente")
    , @NamedQuery(name = "Cliente.findByCarreraCliente", query = "SELECT c FROM Cliente c WHERE c.carreraCliente = :carreraCliente")
    , @NamedQuery(name = "Cliente.findByEstadoCliente", query = "SELECT c FROM Cliente c WHERE c.estadoCliente = :estadoCliente")
    , @NamedQuery(name = "Cliente.findByBalanceCliente", query = "SELECT c FROM Cliente c WHERE c.balanceCliente = :balanceCliente")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TIPO_CLIENTE")
    private String tipoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CARRERA_CLIENTE")
    private String carreraCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ESTADO_CLIENTE")
    private String estadoCliente;
    @Column(name = "BALANCE_CLIENTE")
    private Double balanceCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<FacturaFinal> facturaFinalCollection;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nombreCliente, String tipoCliente, String carreraCliente, String estadoCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.tipoCliente = tipoCliente;
        this.carreraCliente = carreraCliente;
        this.estadoCliente = estadoCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCarreraCliente() {
        return carreraCliente;
    }

    public void setCarreraCliente(String carreraCliente) {
        this.carreraCliente = carreraCliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public Double getBalanceCliente() {
        return balanceCliente;
    }

    public void setBalanceCliente(Double balanceCliente) {
        this.balanceCliente = balanceCliente;
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
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CajaUnapec2.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
