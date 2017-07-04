/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.LikeDislike;
import br.edu.utfpr.model.dao.LikeDislikeDAO;

/**
 *
 * @author felipe
 */
public class LikeDislikeService extends AbstractService<Long, LikeDislike> {

    public LikeDislikeService() {
        dao = new LikeDislikeDAO();
    }

}
