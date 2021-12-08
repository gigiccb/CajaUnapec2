/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import CajaUnapec2.TipoDocumento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import CajaUnapec2.TipoDocumento_;
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
public class TipoDocumentoFacade extends AbstractFacade<TipoDocumento> {

    @PersistenceContext(unitName = "CajaDeUnapec2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDocumentoFacade() {
        super(TipoDocumento.class);
    }

    public boolean isFacturaFinalCollectionEmpty(TipoDocumento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoDocumento> tipoDocumento = cq.from(TipoDocumento.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoDocumento, entity), cb.isNotEmpty(tipoDocumento.get(TipoDocumento_.facturaFinalCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<FacturaFinal> findFacturaFinalCollection(TipoDocumento entity) {
        TipoDocumento mergedEntity = this.getMergedEntity(entity);
        Collection<FacturaFinal> facturaFinalCollection = mergedEntity.getFacturaFinalCollection();
        facturaFinalCollection.size();
        return facturaFinalCollection;
    }
    
}
