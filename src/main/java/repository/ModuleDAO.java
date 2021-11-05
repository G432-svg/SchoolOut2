package repository;

import entities.Module;

import javax.persistence.EntityManager;
import java.util.List;

public class ModuleDAO {

    public Module getOne(String name){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.find(Module.class,name);
    }

    public List getAll(){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        return em.createQuery("Select m From Module m").getResultList();

    }

    public void createOne(Module module){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(module);
        em.getTransaction().commit();
    }

    public void updateOne(Module module){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(module);
        em.getTransaction().commit();
    }

    public void deleteOne(Module module){
        EntityManager em = EMFConnection.getOtiliaEMF().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Module.class,module.getId()));
        em.getTransaction().commit();
    }
}
