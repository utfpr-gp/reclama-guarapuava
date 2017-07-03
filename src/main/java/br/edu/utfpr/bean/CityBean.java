/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import br.edu.utfpr.model.City;
import br.edu.utfpr.model.service.CityService;
import br.edu.utfpr.util.MessageUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author cabrito
 */
@ManagedBean
@RequestScoped
public class CityBean {

    private City city;
    private List<City> cityList;
    private CityService cityService;

    private Long stateId;

    public CityBean() {
    }

    public CityBean(City city, List<City> cityList, CityService cityService) {
        this.city = city;
        this.cityList = cityList;
        this.cityService = cityService;
    }

    @PostConstruct
    public void init() {
        city = new City();
        cityList = new ArrayList<>();
        cityService = new CityService();
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public CityService getCityService() {
        return cityService;
    }

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    public void edit(City city) {
        this.city = city;
    }

    public void delete(City city) {
        boolean isSuccess = cityService.delete(city);
        if (isSuccess) {
            this.cityList.remove(city);
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        } else {
            MessageUtil.showMessage("Falha na remoção", "", FacesMessage.SEVERITY_ERROR);
        }
        this.city = new City();
    }

    public void persist() {
        System.out.println("veio aqui***************");
        if (city.getId() == null) {
            if (cityService.save(city)) {
                this.cityList.add(city);
                MessageUtil.showMessage("Cadastrado com sucesso", "", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Falha ao cadastrar", "", FacesMessage.SEVERITY_ERROR);
            }
        } else {
            if (cityService.update(city)) {
                MessageUtil.showMessage("Alterado com sucesso", "", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Falha na alteração", "", FacesMessage.SEVERITY_ERROR);
            }
        }

        this.city = new City();
    }

    public List<City> findAll() {
        return cityList = cityService.findAll();
    }

}
