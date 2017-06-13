/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.Occurrence;
import br.edu.utfpr.model.dao.OccurrenceDAO;

/**
 *
 * @author felipe
 */
public class OccurrenceService extends AbstractService<Long, Occurrence>{

    public OccurrenceService() {
        dao = new OccurrenceDAO();
    }
    
}
