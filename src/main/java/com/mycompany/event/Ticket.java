/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.event;


public class Ticket {
    private String id;
    private String type;
    private double price;
    private int quantityAvailable;
    private int sold;
    // Constructor
    public Ticket(String id, String type, double price, int quantityAvailable, int sold) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.sold = 0;
    }
    //Verificación de entradas (Si tenemos entradas disponibles o no)(nuestro contador es el sold)
    public boolean ticketSales(int quantity) {
        if (quantity <= getAvailableQuantity()){
        sold += quantity;
        return true;
        }
        return false;
    }
    // Obtenemos cantidad de entradas disponibles 
    public int getAvailableQuantity(){
        return quantityAvailable - sold;
    }
    //Getters
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public int getSold() {
        return sold;
    }
    
    
    
    
}
