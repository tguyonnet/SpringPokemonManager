package fr.cesi.beans.pokemon;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllPokemons", query = "SELECT pokemonTable FROM Pokemon pokemonTable")
})
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private double height;
    private double weight;
    @ManyToOne
    private Trainer trainer;
    @OneToOne
    private Attack attaque01;
    @OneToOne
    private Attack attaque02;

    public Pokemon() {
    }

    public Pokemon(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public Pokemon(String name, double height, double weight, Trainer trainer) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.trainer = trainer;
    }

    public Pokemon(String name, double height, double weight, Trainer trainer, Attack attaque01, Attack attaque02) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.trainer = trainer;
        this.attaque01 = attaque01;
        this.attaque02 = attaque02;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Attack getAttaque01() {
        return attaque01;
    }

    public void setAttaque01(Attack attaque01) {
        this.attaque01 = attaque01;
    }

    public Attack getAttaque02() {
        return attaque02;
    }

    public void setAttaque02(Attack attaque02) {
        this.attaque02 = attaque02;
    }
}
