package pl.monteth.po.sklep.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.monteth.po.sklep.Repositories.SoftwareRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SoftwareController {
    private final SoftwareRepository softwareRepository;

    @Autowired
    public SoftwareController(SoftwareRepository softwareRepository) {
        this.softwareRepository = softwareRepository;
    }

    @GetMapping(path = "/software/search/{name}")
    @ResponseBody
    public ResponseEntity<java.util.List<pl.monteth.po.sklep.Models.Software>> searchForSoftware(@PathVariable String name) {
        System.out.println("Looking for software containing \"" + name +"\"");
        return new ResponseEntity<>(softwareRepository.findSoftwaresByNameLike("%" + name + "%"), HttpStatus.OK);
    }


    @GetMapping(path = "/software/recommended/{number}")
    @ResponseBody
    public ResponseEntity<java.util.List<pl.monteth.po.sklep.Models.Software>> getRandomSoftware(@PathVariable Integer number) {
        System.out.println("Fetching random software: " + number);
        return new ResponseEntity<>(softwareRepository.findRandomSoftware(number), HttpStatus.OK);
    }
}
