/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Usuario
 */
public class Module {
    int id_module;
    String name;

    public Module(int id_module, String name) {
        this.id_module = id_module;
        this.name = name;
    }
    //Getter
    public int getId_module() {
        return id_module;
    }

    public String getName() {
        return name;
    }

    public void setId_module(int id_module) {
        this.id_module = id_module;
    }
    //Setter
    public void setName(String name) {
        this.name = name;
    }
    
}
