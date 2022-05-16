package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SightController {

    @GetMapping("Sight/{id}")
//    @CrossOrigin("http://localhost:63342")
    public Sight[] getSight(@PathVariable("id") String id) throws IOException {
        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        Sight[] sights = crawler.getItems(id);
//        for (Sight s: sights) {
//            if(s != null) {
//                System.out.println(s);
//            }
//        }
       return sights;
    }
}
