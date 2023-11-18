/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package com.memrade.test.controllers;

import com.memrade.test.entities.Blogs;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author guill
 */
@Stateless
public class BlogsFacade extends AbstractFacade<Blogs> {
    
    @PersistenceContext(unitName = "test_pu")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BlogsFacade(EntityManager em) {
        super(Blogs.class);
    }
}
