package repository;
import entities.Exam;

import javax.persistence.EntityManager;
import java.util.List;

public class ExamDAO {
    public Exam getOne(String name){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.find(Exam.class,name);
    }

    public List<Exam> getAll(){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.createQuery("Select e From Exam e").getResultList();

    }

    public void createOne(Exam exam){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(exam);
        em.getTransaction().commit();
    }

    public void updateOne(Exam exam){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(exam);
        em.getTransaction().commit();
    }

    public void deleteOne(Exam exam){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Exam.class,exam.getName()));
        em.getTransaction().commit();
    }
}