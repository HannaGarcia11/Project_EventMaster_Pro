/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.event;
import java.util.HashMap;
import java.util.Map;

public class Finance {
    private Map<Event, Double> expenses;
    private Map<Event, Double> income;
    //Constructor
    public Finance() {
        this.expenses = new HashMap<>();
        this.income = new HashMap<>();
    }
    
    //Registrar gastos
    public void registerExpense(Event event, double amount){
        double current = expenses.getOrDefault(event, 0.0);
        expenses.put(event, current + amount);
    }
    // Registrar ingresos (Revisar)
    public void registerIncome(Event event, double amount) {
        double current = income.getOrDefault(event, 0.0);
        income.put(event, current + amount);
    }
    //Utilidad neta
    public double getNetProfit(Event event){
        double totalIncome = income.getOrDefault(event, 0.0);
        double totalExpenses = expenses.getOrDefault(event, 0.0);
        return totalIncome - totalExpenses;
    }
    //Gastos o ingresos individuales
    public double getTotalExpenses(Event event){
        return expenses.getOrDefault(event, 0.0);
    }
    
    public double getTotalIncome(Event event){
        return income.getOrDefault(event, 0.0);
    }
    
}
