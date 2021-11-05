package repository;

import entities.User;
import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO {
    public User getOne(String login){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.find(User.class,login);
    }

    public List getAll(){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.createQuery("Select u From User u").getResultList();

    }

    public void createOne(User user){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
    public void updateOne(User user){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }
    public void deleteOne(User user){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class,user.getLogin()));
        em.getTransaction().commit();
    }
}
