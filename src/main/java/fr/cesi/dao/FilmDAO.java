package fr.cesi.dao;

import fr.cesi.beans.film.Film;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FilmDAO {
    private final EntityManager em;

    public FilmDAO() {
        this.em = DAOfactory.getEm();
    }

    public void add(Film film) {
        EntityManager em = DAOfactory.getEm();
        em.getTransaction().begin();
        em.persist(film);
        em.getTransaction().commit();
    }

    public Film find(String titre) {
        TypedQuery<Film> request = em.createQuery("SELECT film FROM Film film WHERE film.title = ?1", Film.class);
        request.setParameter(1, titre);
        return request.getSingleResult();
    }

    public Film findGladiator() {
        // Cette méthode recherche le film gladiator dans la liste de film
        TypedQuery<Film> request = em.createQuery("SELECT film FROM Film film WHERE film.title = 'Gladiator'", Film.class);
        return request.getSingleResult();
    }

    public List<Film> selectAll() {
        em.getTransaction().begin();
        TypedQuery<Film> request = em.createNamedQuery("namedRequest", Film.class);
        return request.getResultList();
    }
}
