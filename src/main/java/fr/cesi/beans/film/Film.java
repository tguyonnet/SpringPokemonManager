package fr.cesi.beans.film;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "namedRequest", query = "SELECT filmTable FROM Film filmTable")
})
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String title;
    @ManyToOne
    private Director director;

    public Film() {
        if (!this.getDirector().getFilms().contains(this)) {
            this.getDirector().getFilms().add(this);
        }
    }

    public Film(String title, Director director) {
        this.title = title;
        this.director = director;
        if (!this.getDirector().getFilms().contains(this)) {
            this.getDirector().getFilms().add(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titre) {
        this.title = titre;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
