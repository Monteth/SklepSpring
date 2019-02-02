package pl.monteth.po.sklep.Controllers;

import org.springframework.web.bind.annotation.*;
import pl.monteth.po.sklep.Beans.HelloBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {
    //@RequestMapping(method = RequestMethod.GET, path = "/hello")
    @GetMapping(path = "/hello")  // same result
    public String hello(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-bean")
    public HelloBean helloBean(){
        return new HelloBean("Witajcie klienci, pochodzę z servera!");
    }

    @GetMapping(path = "/hello/path-variable/{name}")
    public HelloBean helloPath(@PathVariable String name){
        return new HelloBean("SIEMA " + name);
    }

}
