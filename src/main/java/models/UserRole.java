/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Usuario
 */
public class UserRole {
    int id;
    int id_user;
    int id_role;

    public UserRole(int id, int id_user, int id_role) {
        this.id = id;
        this.id_user = id_user;
        this.id_role = id_role;
    }
    //Getter

    public int getId() {
        return id;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_role() {
        return id_role;
    }
    //Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }
    
}
