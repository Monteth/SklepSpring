package pl.monteth.po.sklep.Models;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Map;

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
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@idPegi")
    private Pegi pegi;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@idPatron")
    private Patron patron;

    public Pupil(String email) {
        this.email = email;
    }

    public Pupil() {
    }

    public Pupil(String email, String firstName, String lastName, Pegi pegi, Patron patron) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pegi = pegi;
        this.patron = patron;
    }
//
//    @SuppressWarnings("unchecked")
//    @JsonProperty("patron")
//    private void pack(Map<String,Object> patron) {
//        System.out.println(patron);
////        patronRepository.findById(patron
//    }


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
