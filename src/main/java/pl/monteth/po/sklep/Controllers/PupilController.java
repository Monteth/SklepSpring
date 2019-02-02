package pl.monteth.po.sklep.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.monteth.po.sklep.Models.Limitation;
import pl.monteth.po.sklep.Models.Pupil;
import pl.monteth.po.sklep.Services.PupilService;
import pl.monteth.po.sklep.SimplyfiedModels.SimpPupil;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/pupils")
@RestController
public class PupilController {


    private final PupilService pupilService;

    @Autowired
    public PupilController(PupilService pupilService) {
        this.pupilService = pupilService;
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity getPupil(@PathVariable("id") Long id){
        return pupilService.getPupil(id)
                .map(pupil -> new ResponseEntity(pupil, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Iterable<Pupil>> getPupils() {
        return new ResponseEntity<>(pupilService.getPupils(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}/limits")
    @ResponseBody
    public ResponseEntity<Iterable<Limitation>> getLimitationsByPupilId(@PathVariable("id") Long pupilId){
        return new ResponseEntity<>(pupilService.getPupilLimitations(pupilId), HttpStatus.OK);
    }


    //save or update, depends on RequestBody id
    @ResponseBody
    @PostMapping
    public ResponseEntity<HttpStatus> postPupil(@RequestBody SimpPupil simpPupil) {
        boolean isSaved = pupilService.saveSimpPupil(simpPupil);
        return new ResponseEntity<>(isSaved ? HttpStatus.CREATED: HttpStatus.BAD_REQUEST);
    }




    //    @Deprecated
//    @DeleteMapping(path = "/{id}")
//    @ResponseBody
//    public ResponseEntity deletePupil(@PathVariable("id") Long id){
//        pupilRepository.deleteById(id);
//        return new ResponseEntity(HttpStatus.OK);
//    }

//    @Deprecated
//    @GetMapping(path = "/account/pupils/{id}")
//    @ResponseBody
//    public ResponseEntity<List<Pupil>> getPupils(@PathVariable(name = "id") String name) {
//        Long id = Long.valueOf(name);
//        return new ResponseEntity<>(pupilRepository.findPupilsIdByPatronId(id), HttpStatus.OK);
//    }


}
