package pl.monteth.po.sklep.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
public class Pupil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPupil;

    private String email;

    private String firstName;

    private String lastName;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Pegi pegi;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Patron patron;

    public Pupil(String email) {
        this.email = email;
    }

    public Pupil() {
    }

    public Pupil(String email, String firstName, String lastName, Patron patron) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patron = patron;
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
}
