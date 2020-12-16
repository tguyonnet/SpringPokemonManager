package fr.cesi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOfactory {
    private static EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("pokemonManagerBDD");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static EntityManager getEm() {
        return emf.createEntityManager();
    }
}
