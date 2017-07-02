package br.edu.utfpr.bean;

import br.edu.utfpr.model.Occurrence;
import br.edu.utfpr.model.service.OccurrenceService;
import br.edu.utfpr.util.MessageUtil;
import br.edu.utfpr.util.MethodsUtil;

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
    private Long problemId;
    private Long neighborhoodId;
    private String action;

    public OccurrenceBean() {
    }

    @PostConstruct
    public void init() {
        occurrence = new Occurrence();
        occurrenceList = new ArrayList<>();
        occurrenceService = new OccurrenceService();
    }
    
    //------------Get and Set ------------------------------

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    public Long getNeighborhoodId() {
        return neighborhoodId;
    }

    public void setNeighborhoodId(Long neighborhoodId) {
        this.neighborhoodId = neighborhoodId;
    }
    
    //------------Get and Set ----------------- end
    
    public List<Occurrence> byNeighborhood(){
        return occurrenceList = occurrenceService.getByNeighborhood(neighborhoodId);
    }
    
    public void edit(Occurrence occurrence){
        this.occurrence = occurrence;
    }
    
    public String persist() {
        if (recordRelationships() && occurrenceRecord()) {
           MessageUtil.setFlashMessage();
           resetAttrs();
           return "pretty:home";
        } 
        
        MessageUtil.showMessage("Erro ao " + action + " a ocorrência " , "", FacesMessage.SEVERITY_ERROR);
        return "";
    }
    
    public List<Occurrence> findAll() {
        return occurrenceList = occurrenceService.findAll();
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
    
    private boolean recordRelationships() {
        if (!this.occurrence.registerCategoryByid(categoryId)) { 
            MessageUtil.showMessage("Categoria inválida", "", FacesMessage.SEVERITY_ERROR);
            return false; 
        }
        if (!this.occurrence.registerProblemByid(problemId)) { 
            MessageUtil.showMessage("Problema inválido", "", FacesMessage.SEVERITY_ERROR);
            return false; 
        }
        if (!this.occurrence.registerNeighborhoodByid(neighborhoodId)) {
            MessageUtil.showMessage("Bairro inválido", "", FacesMessage.SEVERITY_ERROR);
            return false; 
        }
        
        return true;
    }
    
    private void logOccurrenceRecord() {
        System.out.println("----occurrence record-----");
        System.out.println("Category:" + this.occurrence.getCategory().getName());
        System.out.println("Neighborhood:" + this.occurrence.getNeighborhood().getName());
        System.out.println("Problem:" + this.occurrence.getProblem().getName());
        System.out.println("Address:" + this.occurrence.getAddress());
        System.out.println("Description:" + this.occurrence.getDescription());
    }
    
    private boolean occurrenceRecord() {
        logOccurrenceRecord();
        
        if (MethodsUtil.isNull(occurrence.getId())) {
            action = "registrar";
       
            if (occurrenceService.save(occurrence)) {
                MessageUtil.showMessage("Ocorrência registrada com sucesso", "", FacesMessage.SEVERITY_INFO);
                
                occurrenceList.add(occurrence);
                return true;
            }
        } else {
            action = "atualizar";
            
            if (occurrenceService.update(occurrence)) {
                MessageUtil.showMessage("Ocorrência atualizada com sucesso", "", FacesMessage.SEVERITY_INFO);
                
                return true;
            }
        }
        
        return false;
    }
    
    private void resetAttrs() {
        occurrence = new Occurrence();
        categoryId = null;
        problemId = null;
        neighborhoodId = null;
    }
}
