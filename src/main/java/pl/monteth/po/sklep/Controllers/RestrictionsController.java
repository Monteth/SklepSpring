package pl.monteth.po.sklep.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.monteth.po.sklep.Beans.RestrictionsBean;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RestrictionsController {

    @GetMapping(path = "/restrictions")
    public ResponseEntity<RestrictionsBean> getRestrictions(){
//        List pegi = repo.getPegiRestrictions();
//        List content = repo.getContentRestrictions();
        List<String> content = new ArrayList<String>();
        content.add("Sex");
        content.add("Fear");
        content.add("Bad Language");
        content.add("Discrimination");

        List<String> pegi = new ArrayList<>();
        pegi.add("3");
        pegi.add("7");
        pegi.add("12");
        pegi.add("16");
        pegi.add("18");
        return new ResponseEntity<>(new RestrictionsBean(pegi, content), HttpStatus.OK);
    }
}
