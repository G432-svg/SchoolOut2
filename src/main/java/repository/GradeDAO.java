package repository;

import entities.Grade;
import entities.Person;
import entities.User;

import javax.persistence.EntityManager;
import java.util.List;

import static repository.EMFConnection.getOtiliaEMF;

public class GradeDAO {

    public Grade getOne(long id){
        EntityManager em = getOtiliaEMF().createEntityManager();
        return em.find(Grade.class,id);
    }

    public List<Grade> getAll(){
        EntityManager em = getOtiliaEMF().createEntityManager();
        return em.createQuery("Select g From Grade g").getResultList();

    }

    public void createGrade(Grade grade){
        EntityManager em = getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(grade);
        em.getTransaction().commit();
    }

    public void updateGrade(Grade grade){
        EntityManager em = getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(grade);
        em.getTransaction().commit();
    }

    public void deleteGrade(Grade grade){
        EntityManager em = getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Grade.class,grade.getExam()));
        em.getTransaction().commit();
    }
//    public Grade getGradeByPerson(Person grade){
//        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
//        return em.find(Person.class,grade);
//    }
}

