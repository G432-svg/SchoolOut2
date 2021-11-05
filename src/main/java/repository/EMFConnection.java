package repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EMFConnection {

    public static EntityManagerFactory getOtiliaEMF(){

        return Persistence.createEntityManagerFactory("databaseOtilia");
    }

}

