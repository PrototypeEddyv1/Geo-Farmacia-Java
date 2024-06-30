/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Usuario
 */
public class Pharmacy {
    int id_pharmacy;
    String name;
    String status;
    String location;
    double latitude;
    double longitude;
    String phoneNumber;
    Boolean accepts_credit_card;

    public Pharmacy(int id_pharmacy, String name, String status, String location, double latitude, double longitude, String phoneNumber, Boolean accepts_credit_card) {
        this.id_pharmacy = id_pharmacy;
        this.name = name;
        this.status = status;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phoneNumber = phoneNumber;
        this.accepts_credit_card = accepts_credit_card;
    }
    
    //Getters
    public int getId() {
        return id_pharmacy;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getLocation() {
        return location;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Boolean getAccepts_credit_card() {
        return accepts_credit_card;
    }

    //Setters
    public void setId(int id_pharmacy) {
        this.id_pharmacy = id_pharmacy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAccepts_credit_card(Boolean accepts_credit_card) {
        this.accepts_credit_card = accepts_credit_card;
    }
    
}
