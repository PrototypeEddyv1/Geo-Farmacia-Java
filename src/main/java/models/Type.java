/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Usuario
 */
public class Type {
    int id_type;
    String type;

    public Type(int id_type, String type) {
        this.id_type = id_type;
        this.type = type;
    }
    //Getter
    public int getId_type() {
        return id_type;
    }

    public String getType() {
        return type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }
    //Setter
    public void setType(String type) {
        this.type = type;
    }
    
}
