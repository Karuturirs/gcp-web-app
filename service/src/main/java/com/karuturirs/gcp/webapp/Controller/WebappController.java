package com.karuturirs.gcp.webapp.Controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiResponse(description="Operations to fetch the detail of the application")
@RequestMapping(path="/api")
public class WebappController {

    @GetMapping("/home")
    public String getMyInterests(){

        return "Webapp" ;
    }

}
