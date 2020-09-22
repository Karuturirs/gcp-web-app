package com.karuturirs.gcp.webapp;

import com.karuturirs.gcp.webapp.Controller.BookController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebappTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    BookController bookController;

    @Test
    public void livenessCheckTest() throws URISyntaxException
    {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:"+randomServerPort+"/gcp-web-app/actuator/health/liveness";
        URI uri = new URI(baseUrl);

        HttpEntity<String> request = new HttpEntity<>(null, null);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        //Verify request succeed
        Assertions.assertEquals(200, result.getStatusCodeValue());
        Assertions.assertEquals("{\"status\":\"UP\"}", result.getBody());
    }


    @Test
    public void webapiTest(){
        Assertions.assertNotNull(
                bookController
        );
    }

}
