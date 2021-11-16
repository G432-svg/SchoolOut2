package repository;
import com.mysql.cj.jdbc.DatabaseMetaData;
import entities.Course;
import entities.Exam;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamDAO{



    public Exam getExamById(long id) throws SQLException {
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.find(Exam .class,id);
    }

    public List<Exam> getAllExams(){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.createQuery("Select e From Exam e").getResultList();

    }
    public void addExam(Exam exam){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(exam);
        em.getTransaction().commit();
    }


    public void createOne(Exam exam){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(exam);
        em.getTransaction().commit();
    }

    public void updateExam(Exam exam){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(exam);
        em.getTransaction().commit();
    }

    public void deleteExam(Exam exam){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Exam.class,exam.getName()));
        em.getTransaction().commit();
    }
}
