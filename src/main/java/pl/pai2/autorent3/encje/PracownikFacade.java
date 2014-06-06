/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.pai2.autorent3.encje;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Karol
 */
@Stateless
public class PracownikFacade extends AbstractFacade<Pracownik> {
    @PersistenceContext(unitName = "pl.pai2_autoRent3_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PracownikFacade() {
        super(Pracownik.class);
    }
    
}
