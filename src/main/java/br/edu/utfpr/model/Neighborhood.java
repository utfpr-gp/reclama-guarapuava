/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "neighborhood")
public class Neighborhood implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.REMOVE)
    private Set<Occurrence> occurrences;

    public Neighborhood() {
        super();
    }

    public Neighborhood(String name) {
        super();
        this.name = name;
    }

    public Set<Occurrence> getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(Set<Occurrence> occurrences) {
        this.occurrences = occurrences;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Neighborhood)) {
            return false;
        }
        Neighborhood other = (Neighborhood) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.model.Neighborhood[ id=" + id + " ]";
    }

}
