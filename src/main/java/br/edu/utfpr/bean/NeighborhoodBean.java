package br.edu.utfpr.bean;

import br.edu.utfpr.model.Neighborhood;
import br.edu.utfpr.model.service.NeighborhoodService;
import br.edu.utfpr.util.MessageUtil;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sartori on 27/06/17.
 */
@ManagedBean
@SessionScoped
public class NeighborhoodBean implements Serializable {

    private Neighborhood neighborhood;
    private List<Neighborhood> neighborhoodList;
    private NeighborhoodService neighborhoodService;
    private Long occurranceId;

    public NeighborhoodBean() {
    }

    @PostConstruct
    public void init() {
        neighborhood = new Neighborhood();
        neighborhoodList = new ArrayList<>();
        neighborhoodService = new NeighborhoodService();
    }

    public void persist() {
        if (this.neighborhood.getId() == null) {
            if (neighborhoodService.save(neighborhood)) {
                this.neighborhoodList.add(neighborhood);
                MessageUtil.showMessage("Persistido com sucesso", "", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Por favor escolha um artista", "", FacesMessage.SEVERITY_ERROR);
            }
        } else {
            neighborhoodService.update(neighborhood);
        }
        this.neighborhood = new Neighborhood();
    }

    public void edit(Neighborhood artist) {
        this.neighborhood = artist;
    }

    public void delete(Neighborhood neighborhood) {
        boolean isSuccess = neighborhoodService.delete(neighborhood);
        if (isSuccess) {
            this.neighborhoodList.remove(neighborhood);
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        }
        this.neighborhood = new Neighborhood();
    }

    public List<Neighborhood> findAll() {
        return neighborhoodService.findAll();
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    public List<Neighborhood> getNeighborhoodList() {
        return neighborhoodList;
    }

    public void setNeighborhoodList(List<Neighborhood> neighborhoodList) {
        this.neighborhoodList = neighborhoodList;
    }

    public NeighborhoodService getNeighborhoodService() {
        return neighborhoodService;
    }

    public void setNeighborhoodService(NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }

    public Long getOccurranceId() {
        return occurranceId;
    }

    public void setOccurranceId(Long occurranceId) {
        this.occurranceId = occurranceId;
    }
}
