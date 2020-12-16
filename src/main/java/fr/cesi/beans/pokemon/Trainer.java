package fr.cesi.beans.pokemon;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String firstname;
//    @OneToMany(mappedBy = "trainer")
//    private List<Pokemon> pokemons = new ArrayList<>();

    public Trainer() {
    }

    public Trainer(String name, String firstname) {
        this.name = name;
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

//    public List<Pokemon> getPokemons() {
//        return pokemons;
//    }
//
//    public void setPokemons(List<Pokemon> pokemons) {
//        this.pokemons = pokemons;
//    }
}
