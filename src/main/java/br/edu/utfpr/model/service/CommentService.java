/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Comment;
import br.edu.utfpr.model.dao.CommentDAO;

/**
 *
 * @author felipe
 */
public class CommentService extends AbstractService<Long, Comment>{

    public CommentService() {
        dao = new CommentDAO();
    }
    
}
