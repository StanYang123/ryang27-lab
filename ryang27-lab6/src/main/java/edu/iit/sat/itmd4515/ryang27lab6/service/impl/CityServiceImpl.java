package edu.iit.sat.itmd4515.ryang27lab6.service.impl;

import edu.iit.sat.itmd4515.ryang27lab6.pojo.Animal;
import edu.iit.sat.itmd4515.ryang27lab6.pojo.City;
import edu.iit.sat.itmd4515.ryang27lab6.service.CityService;
import jakarta.ejb.Stateless;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Wang.Kone
 * @date 2023/10/22 12:55
 */
@Stateless
@Service
public class CityServiceImpl implements CityService {

    // EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    public City select(Integer id){
        City city = (City) entityManager.find(City.class, id);
        return city;
    }

    @Transactional
    public City update(City city) {
        entityManager.merge(city);
        return city;
    }

    @Transactional
    public City deleteById(long id) {
        City city = select(Integer.valueOf(String.valueOf(id)));
        if (city != null) {
            entityManager.remove(city);
        }

        return city;
    }

    @Transactional
    public City save(City city) {
        entityManager.persist(city);
        return city;
    }


}
