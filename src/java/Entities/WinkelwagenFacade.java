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
public class WinkelwagenFacade extends AbstractFacade<Winkelwagen> {
    @PersistenceContext(unitName = "ITTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WinkelwagenFacade() {
        super(Winkelwagen.class);
    }
    
}
