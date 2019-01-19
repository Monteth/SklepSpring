package pl.monteth.po.sklep.Controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.monteth.po.sklep.Beans.RelProtegesBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatronController {

    @GetMapping(path = "/{username}/proteges")
    public RelProtegesBean getProteges(@PathVariable String username){
        return new RelProtegesBean(username);
    }
}

