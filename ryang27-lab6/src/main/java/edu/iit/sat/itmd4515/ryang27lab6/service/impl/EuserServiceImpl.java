package edu.iit.sat.itmd4515.ryang27lab6.service.impl;

import edu.iit.sat.itmd4515.ryang27lab6.pojo.City;
import edu.iit.sat.itmd4515.ryang27lab6.pojo.Euser;
import edu.iit.sat.itmd4515.ryang27lab6.pojo.Event;
import edu.iit.sat.itmd4515.ryang27lab6.service.EuserService;
import jakarta.ejb.Stateless;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Wang.Kone
 * @date 2023/10/22 12:56
 */

@Stateless
@Service
public class EuserServiceImpl implements EuserService {

    // EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    public Euser select(Integer id){
        Euser euser = (Euser) entityManager.find(Euser.class, id);
        return euser;
    }

    @Transactional
    public Euser update(Euser euser) {
        entityManager.merge(euser);
        return euser;
    }

    @Transactional
    public Euser deleteById(long id) {
        Euser euser = select(Integer.valueOf(String.valueOf(id)));
        if (euser != null) {
            entityManager.remove(euser);
        }

        return euser;
    }

    @Transactional
    public Euser save(Euser euser) {
        entityManager.persist(euser);
        return euser;
    }


}
