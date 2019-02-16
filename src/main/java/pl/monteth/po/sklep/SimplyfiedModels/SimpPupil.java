package pl.monteth.po.sklep.SimplyfiedModels;

import java.util.List;

public class SimpPupil {

    private Long idPupil;

    private String email;

    private String firstName;

    private String lastName;

    private Long pegi;

    private Long patron;

    private List<Long> limitations;

    public SimpPupil(Long idPupil, String email, String firstName, String lastName, Long idPegi, Long idPatron, List<Long> limitations) {
        this.idPupil = idPupil;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pegi = idPegi;
        this.patron = idPatron;
        this.limitations = limitations;
    }

    public List<Long> getLimitations() {
        return limitations;
    }

    public void setLimitations(List<Long> limitations) {
        this.limitations = limitations;
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

    public Long getPegi() {
        return pegi;
    }

    public void setPegi(Long pegi) {
        this.pegi = pegi;
    }

    public Long getPatron() {
        return patron;
    }

    public void setPatron(Long patron) {
        this.patron = patron;
    }

    @Override
    public String toString() {
        return "SimpPupil{" +
                "idPupil=" + idPupil +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pegi=" + pegi +
                ", patron=" + patron +
                ", limitations=" + limitations +
                '}';
    }
}
