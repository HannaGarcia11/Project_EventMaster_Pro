/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.event;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Event {
    private String id;
    private String name;
    private String category;
    private LocalDate date;
    private String time;
    private Location location;
    private double budget;
    private List<Artist> artists;
    private List<Ticket> tickets;

    //Constructor
    public Event(String id, String name, String category, LocalDate date, String time, double budget) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.time = time;
        this.budget = budget;
        this.artists = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }
   // Métodos para modificar los datos del evento
    public void updateEventDetails(String name, String category, LocalDate date, String time, double budget){
        this.name = name;
        this.category = category;
        this.date = date;
        this.time = time;
        this.budget = budget;  
    }
    
    public void assignLocation(Location location){
        this.location = location;
    }
    
    public void addArtist(Artist artist){
        artists.add(artist);
    }
    
    public void addTicketType(Ticket ticket){
        tickets.add(ticket);
    }
    //Calcula los ingresos de ventas por entradas
    public double calculateTotalIncome(){
        double income = 0;
        for (Ticket ticket : tickets){
            income += ticket.getPrice() * ticket.getSold();
        }
        return income;
    }
    
    public double getBudget(){
        return budget;
    }

    // Getters (permitimos acceso a los atributos privados)
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public Location getLocation() {
        return location;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
  
}
