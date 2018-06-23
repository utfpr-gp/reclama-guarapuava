/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

import br.edu.utfpr.model.service.CategoryService;
import br.edu.utfpr.model.service.NeighborhoodService;
import br.edu.utfpr.model.service.ProblemService;
import br.edu.utfpr.util.MethodsUtil;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "occurrence")
public class Occurrence implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String[] ALL_STATES = {"Solucionado", "Não Solucionado", "Urgente"};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Problem problem;

    private String address;

    @ManyToOne
    private Neighborhood neighborhood;

    private String description;

    private String photo;

    private String status;

    private long views;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "occurrence", targetEntity = Comment.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "occurrence", targetEntity = Comment.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<LikeDislike> likeDislikes;

    public Occurrence() {
        super();
    }

    public Occurrence(Category category, Problem problem, String address, Neighborhood neighborhood, String description, String status, User user) {
        this.category = category;
        this.problem = problem;
        this.address = address;
        this.neighborhood = neighborhood;
        this.description = description;
        this.status = status;
        this.user = user;
    }

    public Occurrence(Category category, Problem problem, String address, Neighborhood neighborhood, String description, String photo, String status, Long views, LikeDislike likes_dislikes, User user) {
        super();
        this.category = category;
        this.problem = problem;
        this.address = address;
        this.neighborhood = neighborhood;
        this.description = description;
        this.photo = photo;
        this.status = status;
        this.views = views;
        this.user = user;
    }

    public long getViews() {
        return views;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<LikeDislike> getLikeDislikes() {
        return likeDislikes;
    }

    public void setLikeDislikes(Set<LikeDislike> likeDislikes) {
        this.likeDislikes = likeDislikes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Neighborhood neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public void setViews(long views) {
        this.views = views;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Occurrence)) {
            return false;
        }
        Occurrence other = (Occurrence) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.model.Occurrence[ id=" + id + " ]";
    }

    public boolean registerCategoryByid(Long categoryId) {
        CategoryService categoryService = new CategoryService();
        category = categoryService.getById(categoryId);

        return !MethodsUtil.isNull(category);
    }

    public boolean registerProblemByid(Long problemId) {
        ProblemService problemService = new ProblemService();
        problem = problemService.getById(problemId);

        return !MethodsUtil.isNull(problem);
    }

    public boolean registerNeighborhoodByid(Long neighborhoodId) {
        NeighborhoodService neighborhoodService = new NeighborhoodService();
        neighborhood = neighborhoodService.getById(neighborhoodId);

        return !MethodsUtil.isNull(neighborhood);
    }
}
