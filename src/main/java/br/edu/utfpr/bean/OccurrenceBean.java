package br.edu.utfpr.bean;

import br.edu.utfpr.model.Category;
import br.edu.utfpr.model.Neighborhood;
import br.edu.utfpr.model.Occurrence;
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

    public Long getNeigIdSelected() {
        return neigIdSelected;
    }

    public void setNeigIdSelected(Long neigIdSelected) {
        this.neigIdSelected = neigIdSelected;
    }
    private Long neigIdSelected;

    public Long getCatIdSelected() {
        return catIdSelected;
    }

    public void setCatIdSelected(Long catIdSelected) {
        this.catIdSelected = catIdSelected;
    }
    private Long catIdSelected;

    public OccurrenceBean() {
    }

    @PostConstruct
    public void init() {
        occurrence = new Occurrence();
        occurrenceList = new ArrayList<>();
        occurrenceService = new OccurrenceService();
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
        System.out.println("ID ABAIXO");

        System.out.println(catIdSelected);

        Neighborhood n = new Neighborhood();
        Category c = new Category();
        if (catIdSelected != null && neigIdSelected != null) {
            c.setId(occurrenceService.getById(catIdSelected).getId());
            n.setId(occurrenceService.getById(neigIdSelected).getId());
            occurrence.setNeighborhood(n);
            occurrence.setCategory(c);
        }
        if (catIdSelected == null || neigIdSelected == null) {
            MessageUtil.showMessage("Falha ao persistir um ou mais campos estao em branco", "", FacesMessage.SEVERITY_ERROR);
        } else if (occurrence.getId() == null) {
            if (occurrenceService.save(occurrence)) {
                this.occurrenceList.add(occurrence);
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

}
