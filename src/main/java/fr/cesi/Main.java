package fr.cesi;

import fr.cesi.beans.film.Address;
import fr.cesi.beans.film.Film;
import fr.cesi.beans.film.Director;
import fr.cesi.beans.pokemon.Attack;
import fr.cesi.beans.pokemon.Pokemon;
import fr.cesi.beans.pokemon.Trainer;
import fr.cesi.dao.FilmDAO;
import fr.cesi.dao.PokemonDAO;
import fr.cesi.exception.DAOException;
import fr.cesi.service.PokemonService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DAOException {
        //film();
        //pokemon();
        //address();
        //attaque();

//        PokemonService pokemonService = new PokemonService();
//        List<Pokemon> pokemons = pokemonService.findAll();
//
//        System.out.println(pokemons);

    }

    private static void attaque() {
        Attack att01 = new Attack("Parratonerre",200);
        Attack att02 = new Attack("Statick",1000);

        Trainer trainer = new Trainer("GUYONNET", "THEO");

        Pokemon pokemon = new Pokemon("Pikachu", 25,  1, trainer, att01, att02);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cesiBDD");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
//            em.persist(att01);
//            em.persist(att02);
//            em.persist(trainer);
//            em.persist(pokemon);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        em.close();
        entityManagerFactory.close();
    }

    private static void address() {
        Address address = new Address("Bd de la republique", "LRSY", 85000);
        Director director = new Director("GUYONNET", "Théo", address);
        Film film = new Film("La reine des neiges", director);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cesiBDD");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(film);
            em.persist(director);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        em.close();
        entityManagerFactory.close();
    }

    private static void pokemon() throws DAOException {
        PokemonDAO pokemonDAO = new PokemonDAO();

        Pokemon onePokemon = new Pokemon("Pikachu", 5,4);
        pokemonDAO.add(onePokemon);

        try {
            Pokemon pikachu = pokemonDAO.find("Pikachu");
            System.out.println("---" + pikachu + "---");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Pokemon> listeDesPokemons = pokemonDAO.findAll();
        for (Pokemon pokemon : listeDesPokemons) {
            System.err.println(pokemon.getName());
        }
    }

    private static void film() {
        FilmDAO filmsDAO = new FilmDAO();
        try {
            Film gladiator = filmsDAO.findGladiator();
            System.out.println("---" + gladiator + "---");
        } catch (Exception e) {
            System.out.println("Le film n'a pas été trouvé");
        }

        Film monFilm = new Film();
        monFilm.setTitle("Gladiator");
        filmsDAO.add(monFilm);

        try {
            Film gladiator = filmsDAO.findGladiator();
            System.out.println("---" + gladiator + "---");
        } catch (Exception e) {
            System.out.println("Le film n'a pas été trouvé");
        }

        List<Film> listeDesFilms = filmsDAO.selectAll();
        for (Film film : listeDesFilms) {
            System.err.println(film.getTitle());
        }
    }
}
