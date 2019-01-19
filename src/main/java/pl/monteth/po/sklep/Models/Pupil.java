package pl.monteth.po.sklep.Models;

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
    private Patron patron;

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
