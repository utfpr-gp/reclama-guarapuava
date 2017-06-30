/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.bean;

import br.edu.utfpr.model.Problem;
import br.edu.utfpr.model.service.ProblemService;
import br.edu.utfpr.util.MessageUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author filipe
 */
@ManagedBean
@RequestScoped
public class ProblemBean {

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public List<Problem> getProblemList() {
        return problemList;
    }

    public void setProblemList(List<Problem> problemList) {
        this.problemList = problemList;
    }

    public ProblemService getProblemService() {
        return problemService;
    }

    /**
     * Creates a new instance of ProblemBean
     *
     * @param problemService
     */
    public void setProblemService(ProblemService problemService) {
        this.problemService = problemService;
    }

    private Problem problem;
    private List<Problem> problemList;
    private ProblemService problemService;

    public ProblemBean() {
    }

    @PostConstruct
    public void init() {
        problem = new Problem();
        problemList = new ArrayList<>();
        problemService = new ProblemService();
    }

    public void edit(Problem problem) {
        this.problem = problem;
    }

    public void delete(Problem problem) {
        boolean isSuccess = problemService.delete(problem);
        if (isSuccess) {
            this.problemList.remove(problem);
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        } else {
            MessageUtil.showMessage("Falha na remoção", "", FacesMessage.SEVERITY_ERROR);
        }
        this.problem = new Problem();
    }

    public void persist() {

        if (problem.getId() == null) {
            if (problemService.save(problem)) {
                this.problemList.add(problem);
                MessageUtil.showMessage("Persistido com sucesso", "", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Falha ao persistir", "", FacesMessage.SEVERITY_ERROR);
            }
        } else {
            if (problemService.update(problem)) {
                MessageUtil.showMessage("Alterado com sucesso", "", FacesMessage.SEVERITY_INFO);
            } else {
                MessageUtil.showMessage("Falha na alteração", "", FacesMessage.SEVERITY_ERROR);
            }
        }

        this.problem = new Problem();
    }

    public List<Problem> findAll() {
        return problemList = problemService.findAll();
    }
}