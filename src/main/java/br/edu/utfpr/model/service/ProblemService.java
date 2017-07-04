/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Problem;
import br.edu.utfpr.model.dao.ProblemDAO;

/**
 *
 * @author felipe
 */
public class ProblemService extends AbstractService<Long, Problem> {

    public ProblemService() {
        dao = new ProblemDAO();
    }

}
