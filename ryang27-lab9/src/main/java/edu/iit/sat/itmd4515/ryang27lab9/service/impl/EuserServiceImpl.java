package edu.iit.sat.itmd4515.ryang27lab9.service.impl;

import edu.iit.sat.itmd4515.ryang27lab9.pojo.Euser;
import edu.iit.sat.itmd4515.ryang27lab9.service.EuserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Wang.Kone
 * @date 2023/10/22 12:56
 */

@Service
public class EuserServiceImpl implements EuserService {

    // EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    public List<Euser> select(Integer id){
        String sql = "select * from event";

        EntityManager emread = null;

        Query qr = emread.createNativeQuery(sql);

        return qr.getResultList();

//        Euser euser = (Euser) entityManager.find(Euser.class, id);
//        return euser;
    }

    @Transactional
    public Euser update(Euser euser) {
        entityManager.merge(euser);
        return euser;
    }

    @Transactional
    public Euser deleteById(long id) {
        Euser euser = select(Integer.valueOf(String.valueOf(id))).get(0);
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
