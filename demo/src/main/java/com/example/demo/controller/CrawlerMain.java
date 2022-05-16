package com.example.demo.controller;

import java.io.IOException;

public class CrawlerMain {

    public static void main(String[] args) throws IOException {

        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        Sight[] sights = crawler.getItems("安樂區");
        for (Sight s: sights) {
            if(s != null)
                System.out.println(s);
        }
    }

}
