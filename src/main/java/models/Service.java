/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Usuario
 */
public class Service {
    int id_service;
    String name;

    public Service(int id_service, String name) {
        this.id_service = id_service;
        this.name = name;
    }
    //Getter
    public int getId_service() {
        return id_service;
    }

    public String getName() {
        return name;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }
    //Setter
    public void setName(String name) {
        this.name = name;
    }
    
    
}
