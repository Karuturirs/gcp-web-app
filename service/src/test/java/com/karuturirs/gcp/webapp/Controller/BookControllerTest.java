package com.karuturirs.gcp.webapp.Controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class BookControllerTest {


    @InjectMocks
    BookController bookController;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void findByIdTest(){

        Assertions.assertEquals(bookController.findById(1L), "Book::1");
    }

}
