package pl.monteth.po.sklep.Controllers;


import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.monteth.po.sklep.Models.Patron;
import pl.monteth.po.sklep.Repositories.PatronRepository;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/api/patrons")
@RestController
public class PatronController {

    private final PatronRepository patronRepository;

    @Autowired
    public PatronController(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }


//    @Deprecated
//    @GetMapping(path = "/{email}")
//    public Patron getPatron(@PathVariable String email) {
//        return patronRepository.getPatronByEmail(email);
//    }


//    Is it even useful?
    @ResponseBody
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletePatron(@PathVariable("id") Long id) {
        patronRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(path = "/{id}")
    public ResponseEntity getPatron(@PathVariable("id") Long id) {
        Optional<Patron> querry_result = patronRepository.findById(id);
        return querry_result.map(
                patron -> new ResponseEntity(patron, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity<Iterable<Patron>> getPatrons(){
        return new ResponseEntity<>(patronRepository.findAll(), HttpStatus.OK);
    }


    @ResponseBody
    @PostMapping
    public ResponseEntity postPatron(@RequestBody Patron patron) {
        return savePatron(patron);
    }

    @PutMapping
    public ResponseEntity putPatron(@RequestBody Patron patron) {
        return savePatron(patron);
    }

    @NotNull
    private ResponseEntity savePatron(@RequestBody Patron patron) {
        ResponseEntity result;
        if (isPatronValid(patron)){
            patronRepository.save(patron);//should i check the output?
            result = new ResponseEntity(HttpStatus.CREATED);
        }else {
            result = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return result;
    }

    private boolean isPatronValid(Patron patron){
        return false;
    }
}

