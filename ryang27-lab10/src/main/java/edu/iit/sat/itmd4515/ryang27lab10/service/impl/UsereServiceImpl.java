package edu.iit.sat.itmd4515.ryang27lab10.service.impl;

import edu.iit.sat.itmd4515.ryang27lab10.service.UsereService;
import edu.iit.sat.itmd4515.ryang27lab10.pojo.Usere;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Random;

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

    @Transactional
    public void save(String username,String password){
        Usere usere = new Usere();
        Random random = new Random();
        usere.setId(random.nextInt());
        usere.setUsername(username);
        usere.setPassword(password);
        entityManager.persist(usere);
    }




}
