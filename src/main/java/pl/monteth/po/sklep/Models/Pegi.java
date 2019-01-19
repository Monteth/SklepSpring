package pl.monteth.po.sklep.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pegi {

    @Id
    @GeneratedValue
    private Long idPegi;

    private String value;

    public Long getIdPegi() {
        return idPegi;
    }

    public void setIdPegi(Long idPegi) {
        this.idPegi = idPegi;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
