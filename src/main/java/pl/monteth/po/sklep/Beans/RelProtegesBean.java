package pl.monteth.po.sklep.Beans;

import java.util.ArrayList;
import java.util.List;

public class RelProtegesBean {

    private List kidsList;

    public RelProtegesBean(String userID){
        kidsList = new ArrayList();
        kidsList.add("Krzyś");
        kidsList.add("Jaś");
    }

    public List getKidsList() {
        return kidsList;
    }

    public void setKidsList(List kidsList) {
        this.kidsList = kidsList;
    }

    @Override
    public String toString() {
        return "RelProtegesBean{" +
                "kidsList=" + kidsList +
                '}';
    }
}
