package pl.monteth.po.sklep.SimplyfiedModels;

import pl.monteth.po.sklep.Models.Pegi;

public class SimpPupil {

    private Long idPupil;

    private String email;

    private String firstName;

    private String lastName;

    private Long idPegi;

    private Long idPatron;

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

    public Long getIdPegi() {
        return idPegi;
    }

    public void setIdPegi(Long idPegi) {
        this.idPegi = idPegi;
    }

    public Long getIdPatron() {
        return idPatron;
    }

    public void setIdPatron(Long idPatron) {
        this.idPatron = idPatron;
    }
}
