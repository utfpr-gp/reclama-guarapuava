/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Occurrence;
import br.edu.utfpr.model.dao.OccurrenceDAO;
import br.edu.utfpr.util.JPAUtil;
import java.util.List;

/**
 *
 * @author felipe
 */
public class OccurrenceService extends AbstractService<Long, Occurrence>{

    public OccurrenceService() {
        dao = new OccurrenceDAO();
    }
    
    public List<Occurrence> orderByNeighborhood() {
        List<Occurrence> occurrences = null;
        
        try {
            JPAUtil.beginTransaction();
            occurrences = ((OccurrenceDAO) dao).orderByNeighborhood();
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollBack();
        } finally {
            JPAUtil.closeEntityManager();
        }
        
        return occurrences;
    }
    
}
