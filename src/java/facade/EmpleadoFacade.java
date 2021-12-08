/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import CajaUnapec2.Empleado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import CajaUnapec2.Empleado_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import CajaUnapec2.FacturaFinal;
import java.util.Collection;

/**
 *
 * @author Gianna Cedeño
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> {

    @PersistenceContext(unitName = "CajaDeUnapec2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }

    public boolean isFacturaFinalCollectionEmpty(Empleado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empleado> empleado = cq.from(Empleado.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empleado, entity), cb.isNotEmpty(empleado.get(Empleado_.facturaFinalCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<FacturaFinal> findFacturaFinalCollection(Empleado entity) {
        Empleado mergedEntity = this.getMergedEntity(entity);
        Collection<FacturaFinal> facturaFinalCollection = mergedEntity.getFacturaFinalCollection();
        facturaFinalCollection.size();
        return facturaFinalCollection;
    }
    
}
