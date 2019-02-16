package pl.monteth.po.sklep.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.monteth.po.sklep.Models.Manager;
import pl.monteth.po.sklep.Repositories.ManagerRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/managers")
@RestController
public class ManagerController {

    @Autowired
    private final ManagerRepository managerRepository;


    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity<Iterable> getManagers(){
        return new ResponseEntity<>(managerRepository.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(path = "/{id}")
    public ResponseEntity<Manager> getManater(@PathVariable("id") Long id){
        Optional<Manager> querry_result = managerRepository.findById(id);
        ResponseEntity result;
        if (querry_result.isPresent()){
            result = new ResponseEntity(querry_result, HttpStatus.OK);
        } else {
            result = new ResponseEntity((HttpStatus.NOT_FOUND));
        }
        return result;
    }
}
