/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Usuario
 */
public class Role {
    int id_role;
    String name;

    public Role(int id_role, String name) {
        this.id_role = id_role;
        this.name = name;
    }
    //Setter
    public int getId_role() {
        return id_role;
    }

    public String getName() {
        return name;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }
    //Getter
    public void setName(String name) {
        this.name = name;
    }
    
}
