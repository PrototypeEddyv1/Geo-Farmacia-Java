/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package webRedirect;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.stream.Collectors;
import models.Pharmacy;
import models.PharmacyService;
import models.Product;
import models.Service;
import models.TestDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "searchMap", urlPatterns = {"/searchMap"})
public class goToResults extends HttpServlet {
    TestDatabase testdb = new TestDatabase();
    String query = "SELECT * FROM pharmacy";
    Double[] position = new Double[2];
    JsonArray jsonArray = new JsonArray();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String pharmacyName = request.getParameter("pharmacyName");
            String pharmacyMedicine = request.getParameter("pharmacyMedicine");
            String serviceName = request.getParameter("serviceName");
            Map<Integer,Object> pharmaciesList = testdb.getPharmacies();
            Map<Integer,Object> pharmacyServiceList = testdb.getPharmacyServices();
            Map<Integer,Object> serviceList = testdb.getServices();
            Map<Integer,Object> productList = testdb.getProducts();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet goToMap</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet goToMap at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            System.out.println("Name: "+pharmacyName);
            System.out.println("Medicine: "+pharmacyMedicine);
            System.out.println("Service: "+serviceName);
            //Search by name of pharmacy
            if (pharmacyName != null){
                /*
                System.out.println("---BUSCANDO POR NOMBRE---");
                Map<Integer,Object> filteredPharmacies = pharmaciesList.entrySet()
                    .stream()
                    .filter(entry -> {
                        if (entry.getValue() instanceof Pharmacy){
                            Pharmacy pharmacy = (Pharmacy) entry.getValue();
                            System.out.println("Comparacion: "+pharmacy.getName()+" =? "+pharmacyName+" == "+pharmacy.getName().contains(pharmacyName));
                            return pharmacy.getName().contains(pharmacyName);
                        }
                        return false;
                    })
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));*/
                query = "SELECT DISTINCT\n" +
                "                p.id_pharmacy, \n" +
                "                p.name, \n" +
                "                p.status, \n" +
                "                p.direction, \n" +
                "                p.latitude, \n" +
                "                p.longitude, \n" +
                "                p.phoneNumber, \n" +
                "                p.accepts_card\n" +
                "            FROM \n" +
                "                    pharmacy p \n" +
                "                JOIN pharmacyService ps ON p.id_pharmacy = ps.id_pharmacy \n" +
                "                JOIN services s ON ps.id_service = s.id_service \n" +
                "                JOIN productServices pr ON s.id_service = pr.id_service \n" +
                "                JOIN products prd ON pr.id_product = prd.id_product \n" +
                "            WHERE p.name like '%"+pharmacyName+"%'";
            }
            //Search by medicine name
            if (pharmacyMedicine != null){/*
                System.out.println("---BUSCANDO POR MEDICINA---");
                //Filter products by the name implemented
                Map<Integer,Object> filteredMedicine = productList.entrySet()
                    .stream()
                    .filter(entry -> {
                        if (entry.getValue() instanceof Product){
                            Product product = (Product) entry.getValue();
                            //System.out.println("Comparacion: "+product.getName()+" =? "+pharmacyMedicine+" == "+product.getName().contains(pharmacyMedicine));
                            //System.out.println("Producto es medicina? "+(product.getId_type() == 1));
                            return product.getName().contains(pharmacyMedicine);
                        }
                        return false;
                    })
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                //Filter pharmacy services with the id of the services that were found
                Map<Integer,Object> filteredPharmacyServices = pharmacyServiceList.entrySet()
                    .stream()
                    .filter(entry -> {
                        PharmacyService pharmacyService = (PharmacyService) entry.getValue();
                        //System.out.println("Size: "+filteredMedicine.size());
                        for (int i = 0; i < filteredMedicine.size(); i++){
                            Product service = (Product) filteredMedicine.values().toArray()[i];
                            if (pharmacyService.getId_service() == (Integer) filteredMedicine.keySet().toArray()[i]){
                                System.out.println("Agregando servicioFarmacia: "+pharmacyService.getId_service());
                                return true;
                            }
                        }
                        return false;
                    })
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                //Now, get all the pharmacies which id is equal to a serviceId
                Map<Integer,Object> filteredPharmacies = pharmaciesList.entrySet()
                    .stream()
                    .filter(entry -> {
                        Pharmacy pharmacy = (Pharmacy) entry.getValue();
                        //System.out.println("Pharmacy Service id: "+pharmacyService.getId_service());
                        for (int i = 0; i < filteredPharmacyServices.size(); i++){
                            PharmacyService pharmacyService = (PharmacyService) filteredPharmacyServices.values().toArray()[i];
                            if (pharmacy.getId() == pharmacyService.getId_pharmacy()){
                                System.out.println("Agregando farmacia: "+pharmacyService.getId_service());
                                return true;
                            }
                        }
                        return false;
                    })
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));*/
                query = "SELECT DISTINCT \n" +
                "                p.id_pharmacy, \n" +
                "                p.name, \n" +
                "                p.status, \n" +
                "                p.direction, \n" +
                "                p.latitude, \n" +
                "                p.longitude, \n" +
                "                p.phoneNumber, \n" +
                "                p.accepts_card\n" +
                "            FROM \n" +
                "                    pharmacy p \n" +
                "                JOIN pharmacyService ps ON p.id_pharmacy = ps.id_pharmacy \n" +
                "                JOIN services s ON ps.id_service = s.id_service \n" +
                "                JOIN productServices pr ON s.id_service = pr.id_service \n" +
                "                JOIN products prd ON pr.id_product = prd.id_product \n" +
                "            WHERE prd.name like '%"+pharmacyMedicine+"%'";
            }
            //Search by service name
            if (serviceName != null){/*
                System.out.println("---BUSCANDO POR SERVICIO---");
                //Filter services by the name implemented
                Map<Integer,Object> filteredService = serviceList.entrySet()
                    .stream()
                    .filter(entry -> {
                        if (entry.getValue() instanceof Service){
                            Service service = (Service) entry.getValue();
                            System.out.println("Comparacion: "+service.getName()+" =? "+serviceName+" == "+service.getName().contains(serviceName));
                            return service.getName().contains(serviceName);
                        }
                        return false;
                    })
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                System.out.println("Size: "+filteredService.size());
                //Filter pharmacy services with the id of the services that were found
                Map<Integer,Object> filteredPharmacyServices = pharmacyServiceList.entrySet()
                    .stream()
                    .filter(entry -> {
                        PharmacyService pharmacyService = (PharmacyService) entry.getValue();
                        //System.out.println("Pharmacy Service id: "+pharmacyService.getId_service());
                        for (int i = 0; i < filteredService.size(); i++){
                            Service service = (Service) filteredService.values().toArray()[i];
                            
                            if (pharmacyService.getId_service() == (Integer) filteredService.keySet().toArray()[i]){
                                System.out.println("Agregando servicioFarmacia: "+pharmacyService.getId_service());
                                return true;
                            }
                        }
                        return false;
                    })
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                //Now, get all the pharmacies which id is equal to a serviceId
                Map<Integer,Object> filteredPharmacies = pharmaciesList.entrySet()
                    .stream()
                    .filter(entry -> {
                        Pharmacy pharmacy = (Pharmacy) entry.getValue();
                        //System.out.println("Pharmacy Service id: "+pharmacyService.getId_service());
                        for (int i = 0; i < filteredPharmacyServices.size(); i++){
                            PharmacyService pharmacyService = (PharmacyService) filteredPharmacyServices.values().toArray()[i];
                            if (pharmacy.getId() == pharmacyService.getId_pharmacy()){
                                System.out.println("Agregando farmacia: "+pharmacyService.getId_service());
                                return true;
                            }
                        }
                        return false;
                    })
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));*/
                query = "SELECT DISTINCT \n" +
                "                p.id_pharmacy, \n" +
                "                p.name, \n" +
                "                p.status, \n" +
                "                p.direction, \n" +
                "                p.latitude, \n" +
                "                p.longitude, \n" +
                "                p.phoneNumber, \n" +
                "                p.accepts_card\n" +
                "            FROM \n" +
                "                    pharmacy p \n" +
                "                JOIN pharmacyService ps ON p.id_pharmacy = ps.id_pharmacy \n" +
                "                JOIN services s ON ps.id_service = s.id_service \n" +
                "                JOIN productServices pr ON s.id_service = pr.id_service \n" +
                "                JOIN products prd ON pr.id_product = prd.id_product \n" +
                "            WHERE s.name like '%"+serviceName+"%'";
            }
            /*
            SQL TO HAVE PHARMACY WITH PRODUCT NAME
            SELECT 
                p.id_pharmacy, 
                p.status, 
                p.direction, 
                p.latitude, 
                p.longitude, 
                p.phoneNumber, 
                p.accepts_card, 
                ps.id_pharmacyService, 
                s.name AS service_name, 
                ps.open_time, ps.close_time, 
                prd.name AS product_name, 
                pr.cost 
            FROM 
                    pharmacy p 
                JOIN pharmacyService ps ON p.id_pharmacy = ps.id_pharmacy 
                JOIN services s ON ps.id_service = s.id_service 
                JOIN productServices pr ON s.id_service = pr.id_service 
                JOIN products prd ON pr.id_product = prd.id_product 
            WHERE prd.name like '%Medicina%';
            */
            //Make a SQL query request
            String jdbcUrl = "jdbc:mysql://localhost/geofarmaciadb";
            String jdbcUser = "root";
            String jdbcPassword = "";
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;

            try {
                // Conectar a la base de datos
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
                statement = connection.createStatement();

                // Ejecutar la consulta
                resultSet = statement.executeQuery(query);

                // Convertir los resultados a JSON
                System.out.println("Convirtiendo a JSON");
                System.out.println(resultSet);
                while (resultSet.next()) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("id_pharmacy", resultSet.getInt("id_pharmacy"));
                    jsonObject.addProperty("name", resultSet.getString("name"));
                    jsonObject.addProperty("status", resultSet.getString("status"));
                    jsonObject.addProperty("direction", resultSet.getString("direction"));
                    jsonObject.addProperty("latitude", resultSet.getDouble("latitude"));
                    jsonObject.addProperty("longitude", resultSet.getDouble("longitude"));
                    jsonObject.addProperty("phoneNumber", resultSet.getString("phoneNumber"));
                    jsonObject.addProperty("accepts_card", resultSet.getBoolean("accepts_card"));
                    jsonArray.add(jsonObject);
                }
                // Imprimir el JSON resultante
                System.out.println(jsonArray.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(goToResults.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // Cerrar los recursos
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            request.setAttribute("pharmaciesList", jsonArray);
            request.getRequestDispatcher("/folderSearch/pharmacyTableResults.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
