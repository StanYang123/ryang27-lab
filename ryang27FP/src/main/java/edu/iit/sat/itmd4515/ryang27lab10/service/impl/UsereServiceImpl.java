package edu.iit.sat.itmd4515.ryang27lab10.service.impl;

import edu.iit.sat.itmd4515.ryang27lab10.service.UsereService;
import edu.iit.sat.itmd4515.ryang27lab10.pojo.Usere;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Random;

/**
 * @author ryang27
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


        StringBuilder  sql =new StringBuilder("select * from usere ");


        sql.append(" where username = :username");
        sql.append(" and password = :password");

        Query dataQuery = entityManager.createNativeQuery(sql.toString(),Usere.class);
        dataQuery.setParameter("username", username);
        dataQuery.setParameter("password", password);

        try {
            return (Usere) dataQuery.getResultList().get(0);
        }catch (IndexOutOfBoundsException e){
            return null;
        }



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
