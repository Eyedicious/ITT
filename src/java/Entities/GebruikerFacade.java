/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Bart
 */
@Stateless
public class GebruikerFacade extends AbstractFacade<Gebruiker> {
    @PersistenceContext(unitName = "ITTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GebruikerFacade() {
        super(Gebruiker.class);
    }
    
}
