package pl.monteth.po.sklep.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Manager {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManager;

    private String email;

    private String firstName;

    private String lastName;

    private Date agreementEnd;

    public Long getIdManager() {
        return idManager;
    }

    public void setIdManager(Long idManager) {
        this.idManager = idManager;
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

    public Date getAgreementEnd() {
        return agreementEnd;
    }

    public void setAgreementEnd(Date agreementEnd) {
        this.agreementEnd = agreementEnd;
    }
}
