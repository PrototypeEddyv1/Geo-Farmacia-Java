/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class TestDatabase {
    Map<Integer,Object> pharmacies = new HashMap<>();
    Map<Integer,Object> pharmacyServices = new HashMap<>();
    Map<Integer,Object> services = new HashMap<>();
    Map<Integer,Object> productServices = new HashMap<>();
    Map<Integer,Object> products = new HashMap<>();
    Map<Integer,Object> types = new HashMap<>();
    Map<Integer,Object> users = new HashMap<>();
    Map<Integer,Object> userRoles = new HashMap<>();
    Map<Integer,Object> roles = new HashMap<>();
    Map<Integer,Object> roleModules = new HashMap<>();
    Map<Integer,Object> modules = new HashMap<>();
    Random random = new Random();

    public TestDatabase() {
        // Crear 10 Pharmacy
        for (int i = 1; i <= 10; i++) {
            Pharmacy pharmacy = new Pharmacy(
                    i,
                    "Pharmacy " + i,
                    "Open",
                    "Location " + i,
                    random.nextDouble() * 180 - 90, // Latitude between -90 and 90
                    random.nextDouble() * 360 - 180, // Longitude between -180 and 180
                    "123456789" + i,
                    random.nextBoolean()
            );
            pharmacies.put(i, pharmacy);
        }

        // Crear 10 PharmacyService
        for (int i = 1; i <= 10; i++) {
            PharmacyService pharmacyService = new PharmacyService(
                    i,
                    i,
                    i,
                    LocalTime.of(random.nextInt(24), random.nextInt(60)),
                    LocalTime.of(random.nextInt(24), random.nextInt(60))
            );
            pharmacyServices.put(i, pharmacyService);
        }

        // Crear 10 Service
        for (int i = 1; i <= 10; i++) {
            Service service = new Service(i, "Service " + i);
            services.put(i, service);
        }

        // Crear 10 ProductService
        for (int i = 1; i <= 10; i++) {
            ProductService productService = new ProductService(
                    i,
                    i,
                    i,
                    random.nextFloat() * 100
            );
            productServices.put(i, productService);
        }

        // Crear 10 Product
        for (int i = 1; i <= 10; i++) {
            Product product = new Product(
                    i,
                    i,
                    "Product " + i,
                    "Unit " + i,
                    random.nextFloat() * 100,
                    random.nextBoolean(),
                    "Provider " + i
            );
            products.put(i, product);
        }

        // Crear 10 Type
        for (int i = 1; i <= 10; i++) {
            Type type = new Type(i, "Type " + i);
            types.put(i, type);
        }

        // Crear 1 User
        for (int i = 1; i <= 1; i++) {
            User user = new User(i, "Admin", "123456789", i);
            users.put(i, user);
        }

        // Crear 10 UserRole
        for (int i = 1; i <= 10; i++) {
            UserRole userRole = new UserRole(i, i, i);
            userRoles.put(i, userRole);
        }

        // Crear 10 Role
        for (int i = 1; i <= 10; i++) {
            Role role = new Role(i, "Role " + i);
            roles.put(i, role);
        }

        // Crear 10 RoleModule
        for (int i = 1; i <= 10; i++) {
            RoleModule roleModule = new RoleModule(
                    i,
                    i,
                    i,
                    random.nextBoolean(),
                    random.nextBoolean(),
                    random.nextBoolean(),
                    random.nextBoolean()
            );
            roleModules.put(i, roleModule);
        }

        // Crear 10 Module
        for (int i = 1; i <= 10; i++) {
            Module module = new Module(i, "Module " + i);
            modules.put(i, module);
        }
    }
    //Getters
    public Map<Integer, Object> getPharmacies() {
        return pharmacies;
    }

    public Map<Integer, Object> getPharmacyServices() {
        return pharmacyServices;
    }

    public Map<Integer, Object> getServices() {
        return services;
    }

    public Map<Integer, Object> getProductServices() {
        return productServices;
    }

    public Map<Integer, Object> getProducts() {
        return products;
    }

    public Map<Integer, Object> getTypes() {
        return types;
    }

    public Map<Integer, Object> getUsers() {
        return users;
    }

    public Map<Integer, Object> getUserRoles() {
        return userRoles;
    }

    public Map<Integer, Object> getRoles() {
        return roles;
    }

    public Map<Integer, Object> getRoleModules() {
        return roleModules;
    }

    public Map<Integer, Object> getModules() {
        return modules;
    }

    public Random getRandom() {
        return random;
    }
    //Setters
    public void setPharmacies(Map<Integer, Object> pharmacies) {
        this.pharmacies = pharmacies;
    }

    public void setPharmacyServices(Map<Integer, Object> pharmacyServices) {
        this.pharmacyServices = pharmacyServices;
    }

    public void setServices(Map<Integer, Object> services) {
        this.services = services;
    }

    public void setProductServices(Map<Integer, Object> productServices) {
        this.productServices = productServices;
    }

    public void setProducts(Map<Integer, Object> products) {
        this.products = products;
    }

    public void setTypes(Map<Integer, Object> types) {
        this.types = types;
    }

    public void setUsers(Map<Integer, Object> users) {
        this.users = users;
    }

    public void setUserRoles(Map<Integer, Object> userRoles) {
        this.userRoles = userRoles;
    }

    public void setRoles(Map<Integer, Object> roles) {
        this.roles = roles;
    }

    public void setRoleModules(Map<Integer, Object> roleModules) {
        this.roleModules = roleModules;
    }

    public void setModules(Map<Integer, Object> modules) {
        this.modules = modules;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Object getPharmacy() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
