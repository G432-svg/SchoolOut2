package repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static javax.persistence.Persistence.createEntityManagerFactory;


public class EMFConnection {

    public static EntityManagerFactory getOtiliaEMF(){

        return Persistence.createEntityManagerFactory("databaseOtilia");
    }

}

