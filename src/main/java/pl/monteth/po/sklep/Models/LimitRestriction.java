package pl.monteth.po.sklep.Models;

import javax.persistence.*;

@Entity
public class LimitRestriction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLimitRestriction;

    @ManyToOne
    private Patron patron;

    @ManyToOne
    private Limitation limitation;

    @ManyToOne
    private Pupil pupil;

    public long getIdLimitRestriction() {
        return idLimitRestriction;
    }

    public void setIdLimitRestriction(long idLimitRestriction) {
        this.idLimitRestriction = idLimitRestriction;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }
}
