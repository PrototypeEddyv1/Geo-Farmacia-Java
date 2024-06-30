/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Usuario
 */
public class User {
    int id_user;
    String name;
    String password;
    int id_pharmacy;

    public User(int id_user, String name, String password, int id_pharmacy) {
        this.id_user = id_user;
        this.name = name;
        this.password = password;
        this.id_pharmacy = id_pharmacy;
    }
    //Getters

    public int getId_user() {
        return id_user;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getId_pharmacy() {
        return id_pharmacy;
    }
    
    //Setters

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId_pharmacy(int id_pharmacy) {
        this.id_pharmacy = id_pharmacy;
    }
}
