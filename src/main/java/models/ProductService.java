/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Usuario
 */
public class ProductService {
    int id;
    int id_product;
    int id_service;
    float cost;

    public ProductService(int id, int id_product, int id_service, float cost) {
        this.id = id;
        this.id_product = id_product;
        this.id_service = id_service;
        this.cost = cost;
    }
    //Getter
    public int getId() {
        return id;
    }

    public int getId_product() {
        return id_product;
    }

    public int getId_service() {
        return id_service;
    }

    public float getCost() {
        return cost;
    }
    //Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    
    
}
