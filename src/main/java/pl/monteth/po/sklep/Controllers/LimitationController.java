package pl.monteth.po.sklep.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.monteth.po.sklep.Models.Limitation;
import pl.monteth.po.sklep.Repositories.LimitationRepository;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/limitations")
@RestController
public class LimitationController {

    @Autowired
    LimitationRepository limitationRepository;

    @GetMapping
    @ResponseBody
    public ResponseEntity<Iterable<Limitation>> getLimitations(){
        return new ResponseEntity<>(limitationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity getLimitatnionById(@PathVariable("id") Long id){
        Optional<Limitation> querry_result = limitationRepository.findById(id);
        ResponseEntity result;
        if (querry_result.isPresent()) {
            result = new ResponseEntity(querry_result, HttpStatus.OK);
        }
        else {
            result = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return result;
    }
}
