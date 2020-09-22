package com.karuturirs.gcp.webapp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Api(value="Gcp Web App", description="Operations to fetch the detail of the application")
@RequestMapping(path="/api")
public class WebappController {

    @GetMapping
    public String findByI(){
        return "Webapp" ;
    }

}
