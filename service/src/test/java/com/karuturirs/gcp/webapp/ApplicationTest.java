package com.karuturirs.gcp.webapp;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;


public class ApplicationTest {

    Application application ;

    @BeforeEach
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        application = new Application();
    }


}


