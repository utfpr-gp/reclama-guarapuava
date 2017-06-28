package br.edu.utfpr.bean;

import br.edu.utfpr.model.Occurrence;
import br.edu.utfpr.model.service.NeighborhoodService;
import br.edu.utfpr.model.service.OccurrenceService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sartori on 27/06/17.
 */
@ManagedBean
@SessionScoped
public class OccurrenceBean {
    private Occurrence occurrence;
    private List<Occurrence> occurrenceList;
    private OccurrenceService occurrenceService;

    public OccurrenceBean() {
    }

    @PostConstruct
    public void init(){
        occurrence = new Occurrence();
        occurrenceList = new ArrayList<>();
        occurrenceService = new OccurrenceService();
    }

    public List<Occurrence> findAll(){
        return occurrenceService.findAll();
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
}
