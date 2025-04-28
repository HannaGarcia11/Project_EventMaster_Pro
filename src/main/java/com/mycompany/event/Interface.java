/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.event;
import java.time.LocalDate;
import java.util.Scanner;


abstract class Interface {
    private EventManager eventManager;
    private Scanner scanner;
    private Finance finance;
    
    public Interface() {
        this.eventManager = new EventManager();
        this.scanner = new Scanner(System.in);
        this.finance = new Finance();
    }
    
    
    public void start(){
        boolean exit = false;
        while (!exit) {
            showMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> startMenuEvent(); 
                case 2 -> startMenuLocation();
                case 3 -> startMenuArtist();
                case 4 -> ticketSales();
                case 5 -> listEvents();
                case 6 -> startMenuFinance();
                case 0 -> {
                    System.out.println("Exiting...");
                    exit = true;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
    public void startMenuEvent(){
        boolean exit = false;
        while (!exit) {
            showMenuEvents();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> createEvent(); 
                case 2 -> listEvents();
                case 3 -> updateEvent();
                case 4 -> deleteEvent();
                case 0 -> {
                    System.out.println("Exiting...");
                    exit = true;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
    public void startMenuLocation(){
        boolean exit = false;
        while (!exit) {
            showMenuLocations();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> createLocation(); 
                case 2 -> listLocationsDate();
                case 3 -> addDateLocation();
                case 4 -> listLocation();
                case 0 -> {
                    System.out.println("Exiting...");
                    exit = true;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
      public void startMenuArtist(){
        boolean exit = false;
        Artist artist = null; // Declaramos una variable para los artistas
        while (!exit) {
            showMenuArtist();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> {
                   artist = createArtist(); 
                }
                case 2 -> {
                    if (artist !=null){
                        listEventHistory(artist); // Pasamos el artista al método
                    } else {
                        System.out.println("No artist created yet.");
                    }
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    exit = true;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
    public void startMenuFinance(){
        boolean exit = false;
        while (!exit) {
            showMenuFinance();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> registerIncome(finance); 
                case 2 -> registerExpense(finance);
                case 3 -> checkNetProfit(finance);
                case 0 -> {
                    System.out.println("Exiting...");
                    exit = true;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }  
    private void showMenu() {
        System.out.println("\n--- EventMaster Pro Menu ---");
        System.out.println("1. Open Events Menu");
        System.out.println("2. Open Location Menu");
        System.out.println("3. Open Artist Menu");
        System.out.println("4. Sell Ticket");
        System.out.println("5. List All Events");
        System.out.println("6. Open Finance Menu");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }
      private void showMenuEvents() {
        System.out.println("\n--- EventMaster Pro Menu ---");
        System.out.println("1. Create Event");
        System.out.println("2. List All Events");
        System.out.println("3. Update Event");
        System.out.println("4. Delete Event");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
    }
      private void showMenuLocations() {
        System.out.println("\n--- EventMaster Pro Menu ---");
        System.out.println("1. Create Location");
        System.out.println("2. Availability By Dates");
        System.out.println("3. Add Date");
        System.out.println("4. List All Location");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
      }
      private void showMenuArtist() {
        System.out.println("\n--- EventMaster Pro Menu ---");
        System.out.println("1. Register Artists Or Speakers");
        System.out.println("2. Participation History");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
      }
      private void showMenuFinance() {
        System.out.println("\n--- EventMaster Pro Menu ---");
        System.out.println("1. Register Income");
        System.out.println("2. Register Expense");
        System.out.println("3. Check Net Profit");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");
      }
     
    private void createEvent() {
        System.out.print("Event ID: ");
        String id = scanner.nextLine();

        System.out.print("Event Name: ");
        String name = scanner.nextLine();

        System.out.print("Category (Concert, Festival, etc): ");
        String category = scanner.nextLine();

        System.out.print("Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Time (HH:MM): ");
        String time = scanner.nextLine();

        System.out.print("Budget: ");
        double budget = scanner.nextDouble();
        scanner.nextLine();

        Event event = new Event(id, name, category, date, time, budget);
        eventManager.createEvent(event);
        System.out.println(" Event created.");
    }
    private void updateEvent() {
        System.out.print("Event ID: ");
        String id = scanner.nextLine();
        
        Event event = eventManager.findEventById(id);
        if(event != null){
            System.out.print("Event Name: ");
            String name = scanner.nextLine();

            System.out.print("Category (Concert, Festival, etc): ");
            String category = scanner.nextLine();

            System.out.print("Date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(scanner.nextLine());

            System.out.print("Time (HH:MM): ");
            String time = scanner.nextLine();

            System.out.print("Budget: ");
            double budget = scanner.nextDouble();
            scanner.nextLine();
            
            event.updateEventDetails(name, category, date, time, budget);
            System.out.println(" Event updated.");
        }
        else{
            System.out.println("--The Event Was Not Found--");
        }
    }
    private void deleteEvent() {
        System.out.print("Event ID: ");
        String id = scanner.nextLine();
        
        eventManager.deleteEvent(id);
        System.out.println("--Is Removed Correctly--");  
    }
    
    private void createLocation() {
        System.out.print("Location ID: ");
        String id = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Features: ");
        String features = scanner.nextLine();

        Location location = new Location(id, name, capacity, features);
        eventManager.registerLocation(location);
        System.out.println(" Location registered.");
        
        
    }
    private Artist createArtist() {
        System.out.print("Artist ID: ");
        String id = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Contact Info: ");
        String contact = scanner.nextLine();

        System.out.print("Technical Requirements: ");
        String techReq = scanner.nextLine();

        Artist artist = new Artist(id, name, contact, techReq);
        eventManager.registerArtist(artist); //Registramos el artista
        System.out.println(" Artist registered.");
        return artist; //Nos ayuda a devolver el artista creado para que el case 1 funcione correctamente
    }

    private void ticketSales() {
        System.out.print("Event ID: ");
        String eventId = scanner.nextLine();

        System.out.print("Ticket Type: ");
        String type = scanner.nextLine();

        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        boolean sold = eventManager.sellTicket(eventId, type, quantity);
        if (sold) {
            System.out.println("️ Tickets sold successfully.");
        } else {
            System.out.println(" Could not sell tickets. Check availability or event.");
        }
    }
    private void registerIncome(Finance finance) {
    System.out.print("Event ID: ");
    String eventId = scanner.nextLine();

    Event event = eventManager.findEventById(eventId);
    if (event != null) {
        System.out.print("Income Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        eventManager.registerIncome(event, amount); // Registrar ingreso a través de EventManager
        System.out.println("Income registered.");
    } else {
        System.out.println("Event not found.");
    }
}
   private void registerExpense(Finance finance) {
    System.out.print("Event ID: ");
    String eventId = scanner.nextLine();

    Event event = eventManager.findEventById(eventId);
    if (event != null) {
        System.out.print("Expense Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        eventManager.registerExpense(event, amount); // Registrar gasto a través de EventManager
        System.out.println("Expense registered.");
    } else {
        System.out.println("Event not found.");
    }
}
   private void checkNetProfit(Finance finance) {
    System.out.print("Event ID: ");
    String eventId = scanner.nextLine();

    Event event = eventManager.findEventById(eventId);
    if (event != null) {
        double netProfit = eventManager.getNetProfit(event); // Obtener beneficio neto a través de EventManager
        System.out.println("Net Profit for event '" + event.getName() + "': " + netProfit);
    } else {
        System.out.println("Event not found.");
    }
}

    private void listEvents() {
        System.out.println("--- Events ---");
        for (Event e : eventManager.getEvents()) {
            System.out.println("ID: " + e.getId() + " | Name: " + e.getName() + " | Date: " + e.getDate());
        }
    }
    private void listLocation() {
        System.out.println("--- Location ---");
        for (Location e : eventManager.getLocations()) {
            System.out.println("ID: " + e.getId() + " | Name: " + e.getName() + " | Date: " + e.getAvailability());
        }
    }
     private void listLocationsDate() {
        System.out.println("--- AvailableLocations ---");
        System.out.println(" Enter a Date: ");
        LocalDate Date = LocalDate.parse(scanner.nextLine());
        for (Location e : eventManager.getAvailableLocationsByDate(Date)) {
            System.out.println("ID: " + e.getId() + " | Name: " + e.getName() + "| Capacity: " + e.getCapacity() + " | Features: " + e.getFeatures());
        }
    }
     private void addDateLocation(){
         System.out.print("Location ID: ");
        String id = scanner.nextLine();
        
        Location location = eventManager.findLocationById(id);
        if(location != null){
            System.out.print("Date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(scanner.nextLine());
            location.addDate(date);
            System.out.println(" Date Added Successfully.");
        }
        else{
            System.out.println("--The Location Was Not Found--");
        } 
     }
     private void listEventHistory(Artist artist) {
        System.out.println(" Event History:" + artist.getName());
        for (Event e : artist.getEventHistory()) {
            System.out.println("ID: " + e.getId() + " | Name: " + e.getName() + " | Date: " + e.getDate());
        }
    }
}
    
        
    


    
    
    
    

