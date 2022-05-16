package com.example.demo.controller;

public class Sight {

    private String sightName;
    private String zone;
    private String category;
    private String photoURL;
    private String description;
    private String address;

    public Sight(){
        this.sightName = "";
        this.zone = "";
        this.category = "";
        this.photoURL = "";
        this.description = "";
        this.address = "";
    }

    public void setSightName(String sightName){
        this.sightName = sightName;
    }
    public  String getSightName(){return this.sightName;}

    public void setZone(String zone){this.zone = zone;}
    public String getZone(){return this.zone;}

    public void setCategory(String category){
        this.category = category;
    }
    public String getCategory(){ return this.category;}

    public void setPhotoURL(String photoURL){
        this.photoURL = photoURL;
    }
    public String getPhotoURL(){ return this.photoURL;}

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){ return this.description;}

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){ return this.address;}

    @Override
    public String toString() {
        return "Sightname: "+this.sightName+"\nZone: "+this.zone+"\nCategory: "+this.category+
                "\nPhotoURL: "+this.photoURL+"\nDescription: "+this.description+"\nAddress: "+this.address+"\n";
    }
}
