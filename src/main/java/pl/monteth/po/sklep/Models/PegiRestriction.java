package pl.monteth.po.sklep.Models;


import javax.persistence.*;

@Entity
public class PegiRestriction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPegiRestriction;

    @ManyToOne()
    private Patron patron;

    @ManyToOne
    private Pegi pegi;

    @ManyToOne
    private Pupil pupil;

    public PegiRestriction(Patron patron) {
        this.patron = patron;
    }

    public Long getIdPegiRestriction() {
        return idPegiRestriction;
    }

    public void setIdPegiRestriction(Long idPegiRestriction) {
        this.idPegiRestriction = idPegiRestriction;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }
}
