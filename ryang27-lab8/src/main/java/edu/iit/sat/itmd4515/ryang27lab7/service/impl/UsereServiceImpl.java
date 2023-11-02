package edu.iit.sat.itmd4515.ryang27lab7.service.impl;

import edu.iit.sat.itmd4515.ryang27lab7.pojo.Animal;
import edu.iit.sat.itmd4515.ryang27lab7.pojo.Usere;
import edu.iit.sat.itmd4515.ryang27lab7.service.UsereService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Wang.Kone
 * @date 2023/11/2 15:09
 */

@Service
public class UsereServiceImpl implements UsereService {

    // EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    public Usere select(String username,String password){
        Usere usere = new Usere();
        usere.setUsername(username);
        usere.setUsername(password);

        Usere usere1 = (Usere) entityManager.find(Usere.class, usere);
        return usere1;
    }




}
