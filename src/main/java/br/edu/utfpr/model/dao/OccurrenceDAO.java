/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.dao;

import br.edu.utfpr.model.Occurrence;
import br.edu.utfpr.util.JPAUtil;
import java.util.List;

/**
 *
 * @author felipe
 */
public class OccurrenceDAO extends AbstractDAO<Long, Occurrence>{
    
    public List<Occurrence> orderByNeighborhood() {
        this.entityManager = JPAUtil.getEntityManager();
        
        return entityManager.createQuery("SELECT o FROM Occurrence"
                                        + "JOIN o.neighborhood n ORDER BY n.name")
                .getResultList();
    }
}
