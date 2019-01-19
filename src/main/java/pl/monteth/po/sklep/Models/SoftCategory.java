package pl.monteth.po.sklep.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SoftCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSoftCategory;

    private String name;

    public Long getIdSoftCategory() {
        return idSoftCategory;
    }

    public void setIdSoftCategory(Long idSoftCategory) {
        this.idSoftCategory = idSoftCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
