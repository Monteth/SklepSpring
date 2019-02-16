package pl.monteth.po.sklep.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pl.monteth.po.sklep.Models.Software
import pl.monteth.po.sklep.Repositories.SoftwareRepository

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
@RequestMapping(path = ["/api/software"])
class SoftwareController @Autowired
constructor(private val softwareRepository: SoftwareRepository) {

    val DEFAULT_LIMIT = 40

    @GetMapping
    @ResponseBody
    fun getSoftware(@RequestParam(value = "name", required = false) name: String?,
                    @RequestParam(value = "limit", required = false) limit: Int?)
            : ResponseEntity<Iterable<Software>> {
        val qResult : Iterable<Software> = if (name.isNullOrBlank())
            softwareRepository.findRandomSoftware(limit ?: DEFAULT_LIMIT)
        else
            softwareRepository.findSoftwaresByNameLike("%$name%", limit ?: DEFAULT_LIMIT)

        return ResponseEntity(qResult, HttpStatus.OK)
    }


    //    @Deprecated
    //    @GetMapping(path = "{name}")
    //    @ResponseBody
    //    public ResponseEntity<java.util.List<pl.monteth.po.sklep.Models.Software>> searchForSoftware(@PathVariable String name) {
    //        System.out.println("Looking for software containing \"" + name + "\"");
    //        return new ResponseEntity<>(softwareRepository.findSoftwaresByNameLike("%" + name + "%"), HttpStatus.OK);
    //    }


    //    @Deprecated
    //    @GetMapping(path = "/software/recommended/{number}")
    //    @ResponseBody
    //    public ResponseEntity<java.util.List<pl.monteth.po.sklep.Models.Software>> getRandomSoftware(@PathVariable Integer number) {
    //        System.out.println("Fetching random software: " + number);
    //        return new ResponseEntity<>(softwareRepository.findRandomSoftware(number), HttpStatus.OK);
    //    }
}