package fr.cesi.service;

import fr.cesi.beans.pokemon.Pokemon;
import fr.cesi.dao.PokemonDAO;

import java.util.List;

public class PokemonService {
    PokemonDAO pokemonDAO;

    public PokemonService() {
        this.pokemonDAO = new PokemonDAO();
    }

    public List<Pokemon> findAll(){
        return pokemonDAO.findAll();
    }
}
