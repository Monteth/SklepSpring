package pl.monteth.po.sklep.Models;

import javax.persistence.*;

@Entity
public class Software {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSoftware;

    private String name;

    private String description;

    @ManyToOne
    private Pegi pegi;

    @ManyToOne
    private Manager manager;

    public Long getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(Long idSoftware) {
        this.idSoftware = idSoftware;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pegi getPegi() {
        return pegi;
    }

    public void setPegi(Pegi pegi) {
        this.pegi = pegi;
    }
}
