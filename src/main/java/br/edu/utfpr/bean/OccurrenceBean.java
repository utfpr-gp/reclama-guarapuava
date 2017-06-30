package br.edu.utfpr.bean;

import br.edu.utfpr.model.Category;
import br.edu.utfpr.model.Neighborhood;
import br.edu.utfpr.model.Occurrence;
import br.edu.utfpr.model.service.CategoryService;
import br.edu.utfpr.model.service.NeighborhoodService;
import br.edu.utfpr.model.service.OccurrenceService;
import br.edu.utfpr.util.MessageUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;

/**
 * Created by sartori on 27/06/17.
 */
@ManagedBean
@SessionScoped
public class OccurrenceBean {

    private Occurrence occurrence;
    private List<Occurrence> occurrenceList;
    private OccurrenceService occurrenceService;
    private Long categoryId;

    public OccurrenceBean() {
    }

    @PostConstruct
    public void init() {
        occurrence = new Occurrence();
        occurrenceList = new ArrayList<>();
        occurrenceService = new OccurrenceService();
    }

    public void edit(Occurrence occurrence){
        this.occurrence = occurrence;
    }


    public List<Occurrence> findAll() {
        return occurrenceList = occurrenceService.findAll();
    }

    public Occurrence getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Occurrence occurrence) {
        this.occurrence = occurrence;
    }

    public List<Occurrence> getOccurrenceList() {
        return occurrenceList;
    }

    public void setOccurrenceList(List<Occurrence> occurrenceList) {
        this.occurrenceList = occurrenceList;
    }

    public OccurrenceService getOccurrenceService() {
        return occurrenceService;
    }

    public void setOccurrenceService(OccurrenceService occurrenceService) {
        this.occurrenceService = occurrenceService;
    }

    public void delete(Occurrence occurrence) {
        boolean isSuccess = occurrenceService.delete(occurrence);
        if (isSuccess) {
            this.occurrenceList.remove(occurrence);
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        } else {
            MessageUtil.showMessage("Falha na remoção", "", FacesMessage.SEVERITY_ERROR);
        }
        this.occurrence = new Occurrence();
    }

    public void persist() {

        if (occurrence.getId() == null) {
            CategoryService categoryService = new CategoryService();
            Category category = categoryService.getById(categoryId);
            occurrence.setCategory(category);

            if (occurrenceService.save(occurrence)) {
                this.occurrenceList.add(occurrence);
                setCategoryId(categoryId);
                MessageUtil.showMessage("Persistido com sucesso", "", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Falha ao persistir", "", FacesMessage.SEVERITY_ERROR);
            }
        } else {
            if (occurrenceService.update(occurrence)) {
                MessageUtil.showMessage("Alterado com sucesso", "", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Falha na alteração", "", FacesMessage.SEVERITY_ERROR);
            }
        }

        this.occurrence = new Occurrence();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
