package fr.cesi.IHM;

import fr.cesi.beans.pokemon.Pokemon;
import fr.cesi.beans.pokemon.Trainer;
import fr.cesi.beans.pokemon.Attack;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PokemonServlet", urlPatterns = {"/PokemonServlet"})
public class PokemonServlet extends HttpServlet {
    int pokemonsIndex = 0;
    List<Pokemon> pokemons = new ArrayList<>();
    List<Trainer> trainers = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        String precedent = request.getParameter("precedent");
        String suivant = request.getParameter("suivant");

        if (precedent != null) {
            if (pokemonsIndex > 0) {
                pokemonsIndex--;
            } else {
                pokemonsIndex = pokemons.size()-1;
            }
        }
        if (suivant != null) {
            if (pokemonsIndex < pokemons.size()-1) {
                pokemonsIndex++;
            } else {
                pokemonsIndex = 0;
            }
        }

        request.setAttribute("dresseurs", trainers);
        request.setAttribute("currentPokemon", pokemons.get(pokemonsIndex));
        */
       // RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Pokemon.jsp");
        //rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Dresseurs
        trainers.add(new Trainer("GUYONNET", "Théo"));
        trainers.add(new Trainer("GUYONNET", "Theo"));
        request.setAttribute("trainers", trainers);

        // Attaques
        Attack att01 = new Attack("statik", 17);
        Attack att02 = new Attack("paratonnerre", 30);

        // Pokemons
        pokemons.add(new Pokemon("Pikachu", 25,  1, trainers.get(0), att01, att02));
        pokemons.add(new Pokemon("Gros Piakachu", 25,  5, trainers.get(1), att01, att02));
        request.setAttribute("pokemons", pokemons);

        request.setAttribute("currentPokemon", pokemons.get(pokemonsIndex));
        request.setAttribute("index", pokemonsIndex);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Pokemon.jsp");
        rd.forward(request, response);
    }
}
