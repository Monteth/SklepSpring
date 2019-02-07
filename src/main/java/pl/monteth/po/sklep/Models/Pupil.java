package pl.monteth.po.sklep.Models;

import com.fasterxml.jackson.annotation.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pupil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPupil;

    private String email;

    private String firstName;

    private String lastName;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@pegi")
    private Pegi pegi;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@patron")
    private Patron patron;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "pupil_limitations",
    joinColumns = {@JoinColumn(name = "pupil_id")},
    inverseJoinColumns = {@JoinColumn(name = "limit_id")})
    private List<Limitation> limitations;

    public Pupil(String email) {
        this.email = email;
    }

    public Pupil() {
    }

    public Pupil(Long idPupil, String email, String firstName, String lastName, Pegi pegi, Patron patron, List<Limitation> limitations) {
        this.idPupil = idPupil;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pegi = pegi;
        this.patron = patron;
        this.limitations = limitations;
    }

    public Pupil(String email, String firstName, String lastName, Pegi pegi, Patron patron, List<Limitation> limitations) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pegi = pegi;
        this.patron = patron;
        this.limitations = limitations;
    }

//
//    @SuppressWarnings("unchecked")
//    @JsonProperty("patron")
//    private void pack(Map<String,Object> patron) {
//        System.out.println(patron);
////        patronRepository.findById(patron
//    }


    public List<Limitation> getLimitations() {
        return limitations;
    }

    public void setLimitations(List<Limitation> limitations) {
        this.limitations = limitations;
    }

    public Pegi getPegi() {
        return pegi;
    }

    public void setPegi(Pegi pegi) {
        this.pegi = pegi;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Long getIdPupil() {
        return idPupil;
    }

    public void setIdPupil(Long idPupil) {
        this.idPupil = idPupil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "idPupil=" + idPupil +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pegi=" + pegi +
                ", patron=" + patron +
                '}';
    }
}
