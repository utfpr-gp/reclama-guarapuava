/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Comment;
import br.edu.utfpr.model.dao.CommentDAO;
import br.edu.utfpr.util.JPAUtil;
import java.util.List;

/**
 *
 * @author felipe
 */
public class CommentService extends AbstractService<Long, Comment>{

    public CommentService() {
        dao = new CommentDAO();
    }
    
    public List<Comment> findByOccurrence(Long occurrenceId) {
        List<Comment> list = null;
        try {
            JPAUtil.beginTransaction();
            list = ((CommentDAO) dao).findByOccurrence(occurrenceId);
            JPAUtil.commit();
        } catch (Exception e) {
            JPAUtil.rollBack();
        } finally {
            JPAUtil.closeEntityManager();
        }

        return list;
    }
    
}
