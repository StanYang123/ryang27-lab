package edu.iit.sat.itmd4515.ryang27lab9.service.impl;


import edu.iit.sat.itmd4515.ryang27lab9.pojo.Animal;
import edu.iit.sat.itmd4515.ryang27lab9.service.AnimalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * @author Wang.Kone
 * @date 2023/10/22 12:54
 */

@Service
public class AnimalServiceImpl  implements AnimalService {

    // EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    public Animal select(Integer id){
        Animal animal = (Animal) entityManager.find(Animal.class, id);
        return animal;
    }

    @Transactional
    public Animal update(Animal animal) {
        entityManager.merge(animal);
        return animal;
    }

    @Transactional
    public Animal deleteById(long id) {
        Animal animal = select(Integer.valueOf(String.valueOf(id)));
        if (animal != null) {
            entityManager.remove(animal);
        }

        return animal;
    }

    @Transactional
    public Animal save(Animal animal) {
        entityManager.persist(animal);
        return animal;
    }



}
