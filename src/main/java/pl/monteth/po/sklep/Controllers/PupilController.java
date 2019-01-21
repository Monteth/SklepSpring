package pl.monteth.po.sklep.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.monteth.po.sklep.Models.Pupil;
import pl.monteth.po.sklep.Repositories.PupilRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PupilController {

    private final PupilRepository pupilRepository;

    @Autowired
    public PupilController(PupilRepository pupilRepository) {
        this.pupilRepository = pupilRepository;
    }


    @GetMapping(path = "/account/pupils/{id}")
    @ResponseBody
    public ResponseEntity getPupils(@PathVariable(name = "id") String name) {
        Long id = Long.valueOf(name);
        return new ResponseEntity<>(pupilRepository.findPupilsIdByPatronId(id), HttpStatus.OK);
    }


}
