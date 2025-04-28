/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.event;
import java.time.LocalDate;
import java.util.HashSet;

public class Location {
    private String id;
    private String name;
    private int capacity;
    private String features;
    private HashSet<LocalDate> availability;
// Constructor
    public Location(String id, String name, int capacity, String features) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.features = features;
        this.availability = new HashSet<>();
    }
     
    
    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getFeatures() {
        return features;
    }

    public HashSet<LocalDate> getAvailability() {
        return availability;
    }
    public void addDate(LocalDate Date){
        this.availability.add(Date);
        System.out.println(" The Date Was Added Successfully. ");
    }
    
    
    
    
    
    
    
}
