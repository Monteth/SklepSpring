package pl.monteth.po.sklep.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.monteth.po.sklep.Models.Limitation;
import pl.monteth.po.sklep.Models.Pupil;
import pl.monteth.po.sklep.Repositories.PupilRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/pupils")
@RestController
public class PupilController {

    private final PupilRepository pupilRepository;

    @Autowired
    public PupilController(PupilRepository pupilRepository) {
        this.pupilRepository = pupilRepository;
    }

    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity deletePupil(@PathVariable("id") Long id){
        pupilRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity getPupil(@PathVariable("id") Long id){
        Optional<Pupil> querry_result = pupilRepository.findById(id);
        return querry_result.map(
                pupil -> new ResponseEntity(pupil, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Iterable<Pupil>> getPupils() {
        return new ResponseEntity<>(pupilRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}/limits")
    @ResponseBody
    public ResponseEntity<Iterable<Limitation>> getLimitationsByPupilId(@PathVariable("id") Long pupilId){
        return new ResponseEntity<>(pupilRepository.findLimitByPupilId(pupilId), HttpStatus.OK);
    }


    //save or update, depends on RequestBody id
    @ResponseBody
    @PostMapping
    public ResponseEntity postPupil(@RequestBody Pupil pupil) {
        ResponseEntity result;
        if (isPupilValid(pupil)) {
            pupilRepository.save(pupil);
            result = new ResponseEntity(HttpStatus.CREATED);
        } else {
            result = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return result;
    }

    private boolean isPupilValid(Pupil pupil) {
        return false;
    }

//    @Deprecated
//    @GetMapping(path = "/account/pupils/{id}")
//    @ResponseBody
//    public ResponseEntity<List<Pupil>> getPupils(@PathVariable(name = "id") String name) {
//        Long id = Long.valueOf(name);
//        return new ResponseEntity<>(pupilRepository.findPupilsIdByPatronId(id), HttpStatus.OK);
//    }


}
