/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.dao;

import br.edu.utfpr.model.Comment;
import br.edu.utfpr.util.JPAUtil;
import java.util.List;

/**
 *
 * @author felipe
 */
public class CommentDAO extends AbstractDAO<Long, Comment>{
    
    public List<Comment> findByOccurrence(Long occurrenceId) {
        this.entityManager = JPAUtil.getEntityManager();
        return entityManager.createQuery("FROM Comment c WHERE c.occurrence.id = :occurrenceId")
                            .setParameter("occurrenceId",occurrenceId)
                            .getResultList();
    }
}
