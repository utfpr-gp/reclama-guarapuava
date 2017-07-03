/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import br.edu.utfpr.model.Category;
import br.edu.utfpr.model.service.CategoryService;
import br.edu.utfpr.util.MessageUtil;
import br.edu.utfpr.util.MethodsUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author FELIPE
 */
@ManagedBean
@RequestScoped
public class CategoryBean {

    private Category category;
    private List<Category> categoryList;
    private CategoryService categoryService;

    public CategoryBean() {
    }

    @PostConstruct
    public void init() {
        category = new Category();
        categoryList = new ArrayList<>();
        categoryService = new CategoryService();
    }

    public void edit(Category category) {
        this.category = category;
    }
    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    /**
     * Creates a new instance of CategoryBean
     *
     * @param categoryService
     */
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void delete(Category category) {
        boolean isSuccess = categoryService.delete(category);
        if (isSuccess) {
            this.categoryList.remove(category);
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        } else {
            MessageUtil.showMessage("Falha na remoção", "", FacesMessage.SEVERITY_ERROR);
        }
        this.category = new Category();
    }

    public void persist() {
        if (category.getId() == null) {
            if (categoryService.save(category)) {
                this.categoryList.add(category);
                MessageUtil.showMessage("Persistido com sucesso", "", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Falha ao persistir", "", FacesMessage.SEVERITY_ERROR);
            }
        } else {
            if (categoryService.update(category)) {
                MessageUtil.showMessage("Alterado com sucesso", "", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Falha na alteração", "", FacesMessage.SEVERITY_ERROR);
            }
        }

        this.category = new Category();
    }

    public List<Category> findAll() {
        return categoryList = categoryService.findAll();
    }
}
