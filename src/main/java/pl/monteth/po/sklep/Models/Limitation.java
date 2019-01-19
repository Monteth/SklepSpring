package pl.monteth.po.sklep.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Limitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLimit;

    private String value;

    public Long getIdLimit() {
        return idLimit;
    }

    public void setIdLimit(Long idLimit) {
        this.idLimit = idLimit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
