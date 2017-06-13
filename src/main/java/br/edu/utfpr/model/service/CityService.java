/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.service;

import br.edu.utfpr.model.City;
import br.edu.utfpr.model.dao.CityDAO;

/**
 *
 * @author felipe
 */
public class CityService extends AbstractService<Long, City>{

    public CityService() {
        dao = new CityDAO();
    }
    
}
