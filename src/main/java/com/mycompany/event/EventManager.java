/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.event;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EventManager {
    private List<Event> events;
    private List<Location> locations;
    private List<Artist> artists;
    private Map<String, Ticket> allTickets;
    private Finance finance;
    //Constructor
    public EventManager() {
        this.events = new ArrayList<>();
        this.locations = new ArrayList<>();
        this.artists = new ArrayList<>();
        this.allTickets = new HashMap<>();
        this.finance = new Finance();
    }
    // Registrar o crear nuevos eventos
    public void createEvent(Event event){
        events.add(event);
    }
    //Eliminar un evento por id
    public void deleteEvent(String id){
         for (Event e : events){
            if (e.getId().equals(id)){
             events.remove(e);
             return;
            }
        }        
    }
    public void registerIncome(Event event, double amount) {
        finance.registerIncome(event, amount);
    }
     public void registerExpense(Event event, double amount) {
        finance.registerExpense(event, amount);
    }
    public double getNetProfit(Event event) {
        return finance.getNetProfit(event);
    } 
    //Registrar la locacion de un evento
    public void registerLocation(Location location) {
        locations.add(location);
    }
    public List<Location> getAvailableLocationsByDate(LocalDate date){
        List<Location> availableLocations = new ArrayList<>();
        for (Location loc : this.locations) {
            if (loc.getAvailability().contains(date)) {
                availableLocations.add(loc);
            }
        }
        return availableLocations;
    }
    
    // Registrar un nuevo artitas, ponente, etc...
    public void registerArtist(Artist artist){
        artists.add(artist);
    }
    // Agregar tiquetes al sistema por id
    public void registerTicket(Ticket ticket){
        allTickets.put(ticket.getId(), ticket);
    }
    //Encontrar eventos por medio del id
    public Event findEventById(String id){
        for (Event e : events){
            if (e.getId().equals(id)){
                return e;
            }
        }
        //System.out.println("-- The Event Was Not Found --");
        return null;
        
    }
    public Location findLocationById(String id){
        for (Location e : locations){
            if (e.getId().equals(id)){
                return e;
            }
        }
        //System.out.println("-- The Event Was Not Found --");
        return null;
        
    }
    //Presentar eventos por fechas
    public List<Event> getEventByDate(LocalDate date){
        List<Event> result = new ArrayList<>();
        for (Event e : events) {
            if(e.getDate().equals(date)){
                result.add(e);
            }
        }
        return result;
    }
    //Vender entradas por medio del id del evento y el tipo de entrada
  public boolean sellTicket(String eventId, String ticketType, int quantity){
      Event event = findEventById(eventId);
      if (event != null){
          for (Ticket t : event.getTickets()) {
              if (t.getType().equalsIgnoreCase(ticketType)) {
                    boolean sold = t.ticketSales(quantity);// Realiza la venta
                    if (sold) {
                        double totalIncome = t.getPrice() * quantity; // Calculamos el ingreso de esta venta
                        finance.registerIncome(event, totalIncome); // Registramos el ingeso en finanzas
                        return true;
                    }
                }
            }
        }
        return false;
  }  
    // Getters 
    public List<Event> getEvents() {
        return events;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public Map<String, Ticket> getAllTickets() {
        return allTickets;
    }   
}
