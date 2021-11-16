package repository;

import entities.User;
import javax.persistence.EntityManager;
import java.util.List;

import static repository.EMFConnection.getOtiliaEMF;

public class UserDAO {
    public User getUserById(String id){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.find(User.class,id);
    }
    public User getUserByPassword(String password){
//        System.out.println("Enter the password in");
//        String password = scanner.next();
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.find(User.class,password);

    }

    public List<User> getAllUsers(){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.createQuery("Select u From User u").getResultList();

    }

    public void createUser(User user){
        EntityManager em = getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
    public void updateUser(User user){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }
    public void deleteUser(User user){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class,user.getLogin()));
        em.getTransaction().commit();
    }


}
