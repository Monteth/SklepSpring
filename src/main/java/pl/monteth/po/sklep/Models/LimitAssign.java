package pl.monteth.po.sklep.Models;

import javax.persistence.*;

@Entity
public class LimitAssign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLimitAssign;

    @ManyToOne
    private Software software;

    @ManyToOne
    private Limitation limitation;

    public Long getIdLimitAssign() {
        return idLimitAssign;
    }

    public void setIdLimitAssign(Long idLimitAssign) {
        this.idLimitAssign = idLimitAssign;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public Limitation getLimitation() {
        return limitation;
    }

    public void setLimitation(Limitation limitation) {
        this.limitation = limitation;
    }
}
