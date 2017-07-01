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
        
        return entityManager.createQuery("SELECT o FROM Occurrence o"
                                        + " JOIN o.neighborhood n ORDER BY n.name")
                .getResultList();
    }

    public int occurrenceTotalCategory(Long id_category){
        this.entityManager = JPAUtil.getEntityManager();
        return entityManager.createQuery("select count(o) from Occurrence o where o.category = :param")
                .setParameter("param",id_category)
                .getMaxResults();
    }

    public List<Occurrence> occurrenceNeighboorhod(Long id_neghborhood){
        this.entityManager = JPAUtil.getEntityManager();
        return  this.entityManager.createQuery(" select o from "+"Occurrence "+" o where o.neighborhood.id = :param")
                .setParameter("param", id_neghborhood)
                .getResultList();

    }
}
