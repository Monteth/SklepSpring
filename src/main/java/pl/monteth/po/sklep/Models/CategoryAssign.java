package pl.monteth.po.sklep.Models;

import javax.persistence.*;

@Entity
public class CategoryAssign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoryAssign;

    @ManyToOne
    private Software software;

    @ManyToOne
    private SoftCategory softCategory;

    public Long getIdCategoryAssign() {
        return idCategoryAssign;
    }

    public void setIdCategoryAssign(Long idCategoryAssign) {
        this.idCategoryAssign = idCategoryAssign;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public SoftCategory getSoftCategory() {
        return softCategory;
    }

    public void setSoftCategory(SoftCategory softCategory) {
        this.softCategory = softCategory;
    }
}
