package com.example.CitizenServiceMod;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CitizenController.CitizenController;
import com.example.CitizenServiceApplication.CitizenServiceModApplication;


@SpringBootTest(classes = CitizenServiceModApplication.class)
class CitizenServiceModApplicationTests {

    @Autowired
    private CitizenController userController;

    @Test
    void contextLoads() {
        // Your test logic here
    }
}
