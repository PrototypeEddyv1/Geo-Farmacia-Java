/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Usuario
 */
public class Product {
    int id_product;
    int id_type;
    String name;
    String measurement_unit;
    float measurement_quantity;
    Boolean for_kids;
    String provider;

    public Product(int id_product, int id_type, String name, String measurement_unit, float measurement_quantity, Boolean for_kids, String provider) {
        this.id_product = id_product;
        this.id_type = id_type;
        this.name = name;
        this.measurement_unit = measurement_unit;
        this.measurement_quantity = measurement_quantity;
        this.for_kids = for_kids;
        this.provider = provider;
    }
    //Getter
    public int getId_product() {
        return id_product;
    }

    public int getId_type() {
        return id_type;
    }

    public String getName() {
        return name;
    }

    public String getMeasurement_unit() {
        return measurement_unit;
    }

    public float getMeasurement_quantity() {
        return measurement_quantity;
    }

    public Boolean getFor_kids() {
        return for_kids;
    }

    public String getProvider() {
        return provider;
    }
    //Setter
    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMeasurement_unit(String measurement_unit) {
        this.measurement_unit = measurement_unit;
    }

    public void setMeasurement_quantity(float measurement_quantity) {
        this.measurement_quantity = measurement_quantity;
    }

    public void setFor_kids(Boolean for_kids) {
        this.for_kids = for_kids;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
    
    
    
}
