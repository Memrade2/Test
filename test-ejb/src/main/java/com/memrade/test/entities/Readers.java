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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@Table(name = "readers")
@NamedQueries({
    @NamedQuery(name = "Readers.findAll", query = "SELECT r FROM Readers r"),
    @NamedQuery(name = "Readers.findById", query = "SELECT r FROM Readers r WHERE r.id = :id"),
    @NamedQuery(name = "Readers.findByName", query = "SELECT r FROM Readers r WHERE r.name = :name")})
public class Readers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @JoinTable(name = "blogs_readers", joinColumns = {
        @JoinColumn(name = "r_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "b_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Blogs> blogsList;

    public Readers() {
    }

    public Readers(Integer id) {
        this.id = id;
    }

    public Readers(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blogs> getBlogsList() {
        return blogsList;
    }

    public void setBlogsList(List<Blogs> blogsList) {
        this.blogsList = blogsList;
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
        if (!(object instanceof Readers)) {
            return false;
        }
        Readers other = (Readers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.memrade.test.entities.Readers[ id=" + id + " ]";
    }
    
}
