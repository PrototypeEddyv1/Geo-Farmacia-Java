/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.time.LocalTime;
/**
 *
 * @author Usuario
 */
public class PharmacyService {
    int id;
    int id_service;
    int id_pharmacy;
    LocalTime open_time;
    LocalTime close_time;

    public PharmacyService(int id, int id_service, int id_pharmacy, LocalTime open_time, LocalTime close_time) {
        this.id = id;
        this.id_service = id_service;
        this.id_pharmacy = id_pharmacy;
        this.open_time = open_time;
        this.close_time = close_time;
    }
    //Setters
    public int getId() {
        return id;
    }

    public int getId_service() {
        return id_service;
    }

    public int getId_pharmacy() {
        return id_pharmacy;
    }

    public LocalTime getOpen_time() {
        return open_time;
    }

    public LocalTime getClose_time() {
        return close_time;
    }

    public void setId(int id) {
        this.id = id;
    }
    //Getters
    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public void setId_pharmacy(int id_pharmacy) {
        this.id_pharmacy = id_pharmacy;
    }

    public void setOpen_time(LocalTime open_time) {
        this.open_time = open_time;
    }

    public void setClose_time(LocalTime close_time) {
        this.close_time = close_time;
    }
    
    
    
}
