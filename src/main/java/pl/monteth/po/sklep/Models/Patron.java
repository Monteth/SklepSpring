package pl.monteth.po.sklep.Models;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatron;

    private String email;

    private String firstName;

    private String lastName;

    private Date subscriptionEnd;

    public Patron(){}

    public Patron(String email, String firstName, String lastName, Date subscriptionEnd) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subscriptionEnd = subscriptionEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patron patron = (Patron) o;
        return Objects.equals(idPatron, patron.idPatron) &&
                Objects.equals(email, patron.email) &&
                Objects.equals(firstName, patron.firstName) &&
                Objects.equals(lastName, patron.lastName) &&
                Objects.equals(subscriptionEnd, patron.subscriptionEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPatron, email, firstName, lastName, subscriptionEnd);
    }

    @Override
    public String toString() {
        return "Patron{" +
                "idPatron=" + idPatron +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subscriptionEnd=" + subscriptionEnd +
                '}';
    }

    public Long getIdPatron() {
        return idPatron;
    }

    public void setIdPatron(Long idPatron) {
        this.idPatron = idPatron;
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

    public Date getSubscriptionEnd() {
        return subscriptionEnd;
    }

    public void setSubscriptionEnd(Date subscriptionEnd) {
        this.subscriptionEnd = subscriptionEnd;
    }
}
