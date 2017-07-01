/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model.dao;

import br.edu.utfpr.model.Category;
import br.edu.utfpr.util.JPAUtil;

import java.util.List;

/**
 *
 * @author felipe
 */
public class CategoryDAO extends AbstractDAO<Long, Category>{

    public List<Category> getCategories(){
        this.entityManager = JPAUtil.getEntityManager();
        return entityManager.createQuery("select o.category.name, count(o) from Occurrence o where o.category = :param")
           .getResultList();
    }
}
