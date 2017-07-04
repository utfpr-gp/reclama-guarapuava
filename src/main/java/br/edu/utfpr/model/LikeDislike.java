/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "like_dislike")
public class LikeDislike implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Occurrence occurrence;

    @ManyToOne
    private User user;

    private Character like_dislike;

    public LikeDislike() {
        super();
    }

    public LikeDislike(Occurrence occurrence, User user, Character like_dislike) {
        super();
        this.occurrence = occurrence;
        this.user = user;
        this.like_dislike = like_dislike;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Occurrence getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Occurrence occurrence) {
        this.occurrence = occurrence;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Character getLike_dislike() {
        return like_dislike;
    }

    public void setLike_dislike(Character like_dislike) {
        this.like_dislike = like_dislike;
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
        if (!(object instanceof LikeDislike)) {
            return false;
        }
        LikeDislike other = (LikeDislike) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.model.LikeDislike[ id=" + id + " ]";
    }

}
