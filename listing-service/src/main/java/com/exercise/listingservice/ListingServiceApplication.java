package com.exercise.listingservice;

import com.exercise.listingservice.entity.Listing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class ListingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListingServiceApplication.class, args);
    }
//    @GetMapping("/test")
//    public String test(@RequestParam(value = )) {}

}
