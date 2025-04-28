/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.event;
import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String id;
    private String name;
    private String phonenumber;
    private String technicalRequirements;
    private List<Event> eventHistory;
    //Constructor
    public Artist(String id, String name, String phonenumber, String technicalRequirements) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.technicalRequirements = technicalRequirements;
        this.eventHistory = new ArrayList<>();
    }
    // Permite agrgar un evento al historial de nuestro artista
    public void AddEvent(Event event){
        eventHistory.add(event);
    }
    //Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getTechnicalRequirements() {
        return technicalRequirements;
    }

    public List<Event> getEventHistory() {
        return eventHistory;
    }    
}
