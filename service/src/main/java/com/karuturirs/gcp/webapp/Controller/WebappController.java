package com.karuturirs.gcp.webapp.Controller;

import com.karuturirs.gcp.webapp.pojo.Keys;
import com.karuturirs.gcp.webapp.service.KeysService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@ApiResponse(description="Operations to fetch the detail of the application")
@RequestMapping(path="/api")
public class WebappController {

    @Autowired
    KeysService keysService;

    @GetMapping("/home")
    public String getMyInterests(){

        return "Webapp" ;
    }

    @GetMapping("/keys/{count}")
    public Keys getRandomKeys(@PathVariable("count") int count){

        return keysService.randomKeysGenerator(count);
    }

}
