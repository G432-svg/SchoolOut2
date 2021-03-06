package repository;

import entities.Person;
import javax.persistence.EntityManager;
import java.util.List;

import static repository.EMFConnection.getOtiliaEMF;

public class PersonDAO {

    public Person getOne(Integer id){
        EntityManager em = getOtiliaEMF().createEntityManager();
        return em.find(Person.class,id);
    }

    public List<Person> getAll(){
        EntityManager em = getOtiliaEMF().createEntityManager();
        return em.createQuery("Select p From Person p").getResultList();

    }


    public void createOne(Person person){
        EntityManager em = getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    public void updateOne(Person person){
        EntityManager em = getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    public void deleteOne(Person person){
        EntityManager em = getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();

        em.remove(em.find(Person.class,person.getId()));
        em.getTransaction().commit();
    }

}

