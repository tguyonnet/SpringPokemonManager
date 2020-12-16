package fr.cesi.dao;

import fr.cesi.beans.pokemon.Pokemon;
import fr.cesi.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PokemonDAO {
    private EntityManager em;

    public PokemonDAO() {
        this.em = DAOfactory.getEm();

        Pokemon p = new Pokemon();
        em.getTransaction().begin();
        p.setName("Pikachu");
        p.setHeight(188);
        p.setWeight(98);
        em.persist(p);
        em.getTransaction().commit();
    }

    public Pokemon find(String name) {
        TypedQuery<Pokemon> request = em.createQuery("SELECT pokemon FROM Pokemon pokemon WHERE pokemon.name = ?1", Pokemon.class);
        request.setParameter(1, name);
        return request.getSingleResult();
    }

    public void del(Pokemon pokemon) throws DAOException {
        em.getTransaction().begin();
        try {
            em.remove(pokemon);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new DAOException("Erreur à la suppression");
        }
    }

    public void add(Pokemon pokemon) throws DAOException {
        em.getTransaction().begin();
        try {
            em.persist(pokemon);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new DAOException("Erreur à l'insertion");
        }
    }

    public List<Pokemon> findAll() {
        em.getTransaction().begin();
        TypedQuery<Pokemon> request = em.createNamedQuery("findAllPokemons", Pokemon.class);
        return request.getResultList();
    }
}
