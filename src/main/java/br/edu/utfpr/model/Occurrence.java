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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "occurrence")
public class Occurrence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    private Category category;
    
    @OneToOne
    private Problem problem;
    
    private String address;
    
    @ManyToOne
    private Neighborhood neighborhood;
    
    private String description;
    
    private String photo;
    
    @OneToOne
    private Status status;
    
    private Long views;
    
    @ManyToOne
    private LikeDislike likes_dislikes;
    
    @ManyToOne
    private User user;
    
    @OneToMany
    private Set<Comment> comments;
    
    @OneToMany
    private Set<LikeDislike> likeDislikes;

    public Occurrence() {
        super();
    }

    public Occurrence(Category category, Problem problem, String address, Neighborhood neighborhood, String description, String photo, Status status, Long views, LikeDislike likes_dislikes, User user) {
        super();
        this.category = category;
        this.problem = problem;
        this.address = address;
        this.neighborhood = neighborhood;
        this.description = description;
        this.photo = photo;
        this.status = status;
        this.views = views;
        this.likes_dislikes = likes_dislikes;
        this.user = user;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public LikeDislike getLikes_dislikes() {
        return likes_dislikes;
    }

    public void setLikes_dislikes(LikeDislike likes_dislikes) {
        this.likes_dislikes = likes_dislikes;
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

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Occurrence)) {
            return false;
        }
        Occurrence other = (Occurrence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
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
