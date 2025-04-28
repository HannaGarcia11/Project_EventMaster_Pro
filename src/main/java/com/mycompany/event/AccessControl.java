/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.event;
import java.util.HashMap;
import java.util.Map;


public class AccessControl {
    private Map<String, Boolean> validatedTickets;
    //Constructor
    public AccessControl(Map<String, Boolean> validateTickets) {
        this.validatedTickets = new HashMap<>();
    }
    // Validación de entradas
    public boolean validateTicket(String ticketId){
        if (!validatedTickets.containsKey(ticketId)){
            validatedTickets.put(ticketId, true);
            return true; //confirmacion de validación
        }
        return false; // Ya se habia validado anteriormente
    }
    //Registrar asistentes
    public void registerAttendee(String ticketId){
        validatedTickets.put(ticketId, true);
    }
    //Verificacion de validacion de las entradas o tiquetes
    public boolean isTicketValidated(String ticketId){
        return validatedTickets.getOrDefault(ticketId, false);
    }
    //Obtener total de entradas validadas 
    public int getTotalAttendees(){
        return validatedTickets.size();
    }
    
}
