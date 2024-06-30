/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Usuario
 */
public class RoleModule {
    int id;
    int id_role;
    int id_module;
    Boolean can_edit;
    Boolean can_read;
    Boolean can_update;
    Boolean can_delete;

    public RoleModule(int id, int id_role, int id_module, Boolean can_edit, Boolean can_read, Boolean can_update, Boolean can_delete) {
        this.id = id;
        this.id_role = id_role;
        this.id_module = id_module;
        this.can_edit = can_edit;
        this.can_read = can_read;
        this.can_update = can_update;
        this.can_delete = can_delete;
    }
    //Getters
    public int getId() {
        return id;
    }

    public int getId_role() {
        return id_role;
    }

    public int getId_module() {
        return id_module;
    }

    public Boolean getCan_edit() {
        return can_edit;
    }

    public Boolean getCan_read() {
        return can_read;
    }

    public Boolean getCan_update() {
        return can_update;
    }

    public Boolean getCan_delete() {
        return can_delete;
    }
    //Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public void setId_module(int id_module) {
        this.id_module = id_module;
    }

    public void setCan_edit(Boolean can_edit) {
        this.can_edit = can_edit;
    }

    public void setCan_read(Boolean can_read) {
        this.can_read = can_read;
    }

    public void setCan_update(Boolean can_update) {
        this.can_update = can_update;
    }

    public void setCan_delete(Boolean can_delete) {
        this.can_delete = can_delete;
    }
    
    
}
