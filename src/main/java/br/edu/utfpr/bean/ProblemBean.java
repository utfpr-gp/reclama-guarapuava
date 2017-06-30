package br.edu.utfpr.bean;

import br.edu.utfpr.model.Problem;
import br.edu.utfpr.model.service.ProblemService;
import br.edu.utfpr.util.MessageUtil;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sartori on 29/06/17.
 */
@ManagedBean
@SessionScoped
public class ProblemBean {
    private Problem problem;
    private List<Problem> problemList;
    private ProblemService problemService;

    @PostConstruct
    public void init() {
       problem = new Problem();
       problemList = new ArrayList<>();
       problemService = new ProblemService();
    }

    public void edit(Problem problem){
        this.problem = problem;
    }

    public List<Problem> findAll() {
        return problemList = problemService.findAll();
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

    public void setProblemService(ProblemService problemService) {
        this.problemService = problemService;
    }
}
