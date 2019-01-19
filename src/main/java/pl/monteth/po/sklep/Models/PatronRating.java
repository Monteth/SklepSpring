package pl.monteth.po.sklep.Models;

import javax.persistence.*;

@Entity
public class PatronRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParentRating;

    private Integer rating;

    private String comment;

    @ManyToOne
    private Patron patron;

    @ManyToOne
    private Software software;

    public Long getIdParentRating() {
        return idParentRating;
    }

    public void setIdParentRating(Long idParentRating) {
        this.idParentRating = idParentRating;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }
}
