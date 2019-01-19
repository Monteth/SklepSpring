package pl.monteth.po.sklep.Beans;

import java.util.List;

public class RestrictionsBean {

    private List pegiRestrictions;
    private List contentRestrictions;

    public RestrictionsBean(List pegiRestrictions, List contentRestrictions) {
        this.pegiRestrictions = pegiRestrictions;
        this.contentRestrictions = contentRestrictions;
    }

    @Override
    public String toString() {
        return "RestrictionsBean{" +
                "pegiRestrictions=" + pegiRestrictions +
                ", contentRestrictions=" + contentRestrictions +
                '}';
    }

    public List getPegiRestrictions() {
        return pegiRestrictions;
    }

    public void setPegiRestrictions(List pegiRestrictions) {
        this.pegiRestrictions = pegiRestrictions;
    }

    public List getContentRestrictions() {
        return contentRestrictions;
    }

    public void setContentRestrictions(List contentRestrictions) {
        this.contentRestrictions = contentRestrictions;
    }
}
