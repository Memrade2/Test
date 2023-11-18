/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.memrade.test.controllers;

import com.memrade.test.entities.Readers;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author guill
 */

@Stateless
public class ReadersFacade extends AbstractFacade<Readers> {

    @PersistenceContext(unitName = "test_pu")
    private EntityManager em;
    
    public ReadersFacade(Class<Readers> entityClass) {
        super(Readers.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
