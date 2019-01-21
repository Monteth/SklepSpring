package pl.monteth.po.sklep.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.monteth.po.sklep.Models.Patron;
import pl.monteth.po.sklep.Repositories.PatronRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatronController {

    private final PatronRepository patronRepository;

    @Autowired
    public PatronController(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }


    @GetMapping(path = "/patron/{email}")
    public Patron getPatron(@PathVariable String email){
        return patronRepository.getPatronByEmail(email);
    }
}

