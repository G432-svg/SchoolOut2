package repository;

import entities.Course;


import javax.persistence.EntityManager;
import java.util.List;

public class CourseDAO {

    public Course getOne(String name){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.find(Course.class,name);
    }

    public List<Course> getAll(){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.createQuery("Select co From Course co").getResultList();

    }

    public void createOne(Course course){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }

    public void updateOne(Course course){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(course);
        em.getTransaction().commit();
    }

    public void deleteOne(Course course){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Course.class,course.getName()));
        em.getTransaction().commit();
    }
}
