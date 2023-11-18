/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.memrade.test.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author guill
 */
@Entity
@Table(name = "blogs")
@NamedQueries({
    @NamedQuery(name = "Blogs.findAll", query = "SELECT b FROM Blogs b"),
    @NamedQuery(name = "Blogs.findById", query = "SELECT b FROM Blogs b WHERE b.id = :id"),
    @NamedQuery(name = "Blogs.findByTitle", query = "SELECT b FROM Blogs b WHERE b.title = :title"),
    @NamedQuery(name = "Blogs.findByDescription", query = "SELECT b FROM Blogs b WHERE b.description = :description")})
public class Blogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "blogsList")
    private List<Readers> readersList;

    public Blogs() {
    }

    public Blogs(Integer id) {
        this.id = id;
    }

    public Blogs(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Readers> getReadersList() {
        return readersList;
    }

    public void setReadersList(List<Readers> readersList) {
        this.readersList = readersList;
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
        if (!(object instanceof Blogs)) {
            return false;
        }
        Blogs other = (Blogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.memrade.test.entities.Blogs[ id=" + id + " ]";
    }
    
}
