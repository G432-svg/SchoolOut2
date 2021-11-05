package repository;

import entities.Person;
import javax.persistence.EntityManager;
import java.util.List;

public class PersonDAO {
    public Person getOne(int id){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.find(Person.class,id);
    }

    public List<Person> getAll(){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.createQuery("Select p From Person p").getResultList();

    }
//    public void changeFirstName(String firstName, String person){
//        EntityManager em = EMFConnection.returnOtiliaEMF().createEntityManager();
//        em.getTransaction().begin();
//        Query query = em.createQuery("UPDATE Person p SET p.firstName = :firstName Where p.id = :id");
//        query.setParameter("firstName",firstName);
//        query.setParameter("id",person.getClass());
//        query.executeUpdate();
//        em.getTransaction().commit();
//    }
//    public void changeFamilyName(String familyName, String person){
//        EntityManager em = EMFConnection.returnOtiliaEMF().createEntityManager();
//        em.getTransaction().begin();
//        Query query = em.createQuery("UPDATE Person p SET p.familyName = :familyName Where p.id = :id");
//        query.setParameter("familyName",familyName);
//        query.setParameter("id",person.getClass());
//        query.executeUpdate();
//        em.getTransaction().commit();
//    }

    public void createOne(Person person){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    public void updateOne(Person person){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    public void deleteOne(Person person){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Person.class,person.getId()));
        em.getTransaction().commit();
    }

}

