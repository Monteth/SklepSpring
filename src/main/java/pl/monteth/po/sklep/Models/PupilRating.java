package pl.monteth.po.sklep.Models;

import javax.persistence.*;

@Entity
public class PupilRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPupilRating;

    private Integer rating;

    private String comment;

    @ManyToOne
    private Pupil pupil;

    @ManyToOne
    private Software software;


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

    public Long getIdPupilRating() {
        return idPupilRating;
    }

    public void setIdPupilRating(Long idPupilRating) {
        this.idPupilRating = idPupilRating;
    }

    public Pupil getPupil() {
        return pupil;
    }

    public void setPupil(Pupil pupil) {
        this.pupil = pupil;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }
}
