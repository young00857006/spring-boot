package com.example.demo.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import org.jsoup.nodes.*;



public class KeelungSightsCrawler {
    private Sight[] sights;
    private int index = 0;
    public KeelungSightsCrawler(){
        this.sights = new Sight[20];
        this.index = 0;
    }

    public Sight[] getItems(String zone) throws IOException {
        setItems(zone);
        return sights;
    }

    public void setItems(String Zone) throws IOException {
        Document doc = Jsoup.connect("https://www.travelking.com.tw/tourguide/taiwan/keelungcity/").get();

        Elements masthead = doc.select("div.tourgudes.fold");
        int count = 1;
        for (Element mas : masthead.select("h4")){
            if(mas.text().equals(Zone)) {
                break;
            }
            else{
                count++;
            }
        }

        Element linkUl = masthead.select("ul").get(count);//七堵區
        for(Element linkLi : linkUl.select("li")){
            sights[index] = new Sight();
            String a = linkLi.select("a").attr("href");
            a = "https://www.travelking.com.tw" + a;
            Document doc2 = Jsoup.connect(a).get();

            Element sightname = doc2.select("h1.h1").get(0);
            sights[index].setSightName(sightname.text());

            Element zone =doc2.select("li.bc_last").first();
            sights[index].setZone(zone.text());

            Element mas = doc2.select("span.point_type").get(0);
            Element category = mas.select("strong").get(0);
            sights[index].setCategory(category.text());


            Elements photo = doc2.select("div.gpic");
            if(photo.size() > 0){
                String photoURL = photo.select("img").attr("data-src");
                sights[index].setPhotoURL(photoURL);
            }


            Element descripton = doc2.select("div.text").get(0);
            sights[index].setDescription(descripton.text());

            Element address = doc2.select("div.address").get(0);
            Element addr = address.select("span").get(0);
            sights[index].setAddress(addr.text());

            index++;
        }
    }

}
