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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import models.Pharmacy;
import models.PharmacyService;
import models.Product;
import models.ProductService;
import models.Service;
import models.TestDatabase;
import models.Type;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "directToMap", urlPatterns = {"/directToMap"})
public class DirectToMap extends HttpServlet {
    public static TestDatabase testdb = new TestDatabase();

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
            /* Declare */
            String selectedMedicine = request.getParameter("selectedMedicineList");
            String selectedProducts = request.getParameter("selectedProductList");
            String[] open_time = new String[2];
            String[] close_time = new String[2];
            Double minCost = 0.0;
            Double maxCost = 0.0;
            int notAvaliables = 0;
            int[] selectedMedicineIds;
            String[] string_arr;
            Map<Integer,Object> pharmacyList = new HashMap<Integer,Object>();
            Map<Integer,Object> pharmacyServiceList = new HashMap<Integer,Object>();
            Map<Integer,Object> serviceList = new HashMap<Integer,Object>();
            Map<Integer,Object> serviceProductList = new HashMap<Integer,Object>();
            Map<Integer,Object> productList = new HashMap<Integer,Object>();
            Map<Integer,Object> typeList = new HashMap<Integer,Object>();
            List<Integer> keys;
            //Do code
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet directToMap</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet directToMap at </h1>");
            //Get database stuff
            pharmacyList = testdb.getPharmacies();
            //Si los campos estan vacios, entonces cambiarlos por cosas
            if (selectedMedicine == null){
                selectedMedicine = "";
                notAvaliables += 1;
            }
            if (selectedProducts == null){
                selectedProducts = "";
                notAvaliables += 1;
            }
            if (!request.getParameter("open_time").isBlank()){
                out.println("<p>"+(request.getParameter("open_time"))+"</p>");
                open_time = request.getParameter("open_time").split(":"); 
            }else{
                open_time[0] = "0";
                open_time[1] = "0";
            }
            if (!request.getParameter("close_time").isBlank()){
                out.println("<p>"+(request.getParameter("close_time").isBlank())+"</p>");
                close_time = request.getParameter("close_time").split(":"); 
            }else{
                close_time[0] = "23";
                close_time[1] = "59";
            }
            if (!request.getParameter("minCost").isBlank()){
                out.println("<p>"+(request.getParameter("minCost").isBlank())+"</p>");
                minCost = Double.parseDouble(request.getParameter("minCost"));
            }else{
                minCost = 0.0;
            }if (!request.getParameter("maxCost").isBlank()){
                out.println("<p>"+(request.getParameter("maxCost").isBlank())+"</p>");
                maxCost = Double.parseDouble(request.getParameter("maxCost"));
            }else{
                maxCost = Double.MAX_VALUE;
            }
            out.println("<p>"+(request.getParameter("pharmacy_name").isBlank())+"</p>");
            out.println("<p>"+(request.getParameter("maxCost").isBlank())+"</p>");
            out.println("<p>"+(request.getParameter("minCost").isBlank())+"</p>");
            
            //Get the ids of the selectedMedicine
            if ((!selectedMedicine.isBlank()) || (!selectedProducts.isBlank())){
                out.println("<h2>Selected medicine: " + selectedMedicine + "</h2>");
                selectedMedicineIds = new int[selectedMedicine.split(",").length + selectedProducts.split(",").length - notAvaliables];
                out.println("<p> array size: "+selectedMedicineIds.length+"</p>");
                string_arr = selectedMedicine.split(",");
                for (int i = 0; i < selectedMedicine.split(",").length ; i++){
                    selectedMedicineIds[i] = Integer.parseInt(string_arr[i]);
                }
                for (int i = selectedMedicine.split(",").length; i < string_arr.length ; i++){
                    selectedMedicineIds[i] = Integer.parseInt(string_arr[i]);
                }
                //Obtain serviceProducts with the selected products id
                for (int i = 0; i < testdb.getProductServices().size() ; i++){
                    ProductService ps = (ProductService) testdb.getProductServices().values().toArray()[i];
                    for (int j = 0; j < selectedMedicineIds.length;j++){
                        if ((Integer) ps.getId_product() == (Integer) selectedMedicineIds[j]){
                            out.println("<p>Medicine: " + ps.getId_product()+" == "+ selectedMedicineIds[j] +"</p>");
                            if (ps.getCost() >= minCost && ps.getCost() <= maxCost){
                                serviceProductList.put(serviceProductList.size(),ps);
                            }
                        }
                    }
                    
                }
                //Obtain pharmacyService with the serviceProductList
                for (int i = 0; i < testdb.getPharmacyServices().size(); i++){
                    PharmacyService phs = (PharmacyService) testdb.getPharmacyServices().values().toArray()[i];
                    for (int j = 0; j < serviceProductList.size(); j++){
                        ProductService ps = (ProductService) serviceProductList.values().toArray()[j];
                        if ((Integer) phs.getId_pharmacy() == (Integer) ps.getId_service()){
                            pharmacyServiceList.put(pharmacyServiceList.size(),phs);
                            out.println("<p>PharmacyService: " + ps.getId_service()+" == "+ phs.getId_service() +"</p>");
                        }
                    }
                }
                //Obtain pharmacy with the pharmacyService
                for (int i = 0; i < testdb.getPharmacies().size(); i++){
                    Pharmacy p = (Pharmacy) testdb.getPharmacies().values().toArray()[i];
                    for (int j = 0; j < pharmacyServiceList.size(); j++){
                        PharmacyService phs = (PharmacyService) pharmacyServiceList.values().toArray()[j];
                        if ((Integer) p.getId() == (Integer) phs.getId_pharmacy()){
                            if (request.getParameter("pharmacy_name").isBlank()){
                                if (p.getName().contains(request.getParameter("pharmacy_name"))){
                                    pharmacyList.put(pharmacyList.size(),p);
                                }
                            }else{
                                pharmacyList.put(pharmacyList.size(),p);
                            }
                        }
                    }
                }
                
                //obtener id del servicio de productService usando id producto
                //obtener id de farmacia de farmaciaService usando el id servicio obtenido de productService
                //obtener farmacia de farmacia usando el id servicio obtenido de farmaciaService
                
                //Al final conseguir la farmacia usando el id de farmacia (obtenido se servicioFarmacias
            }else{
                pharmacyList = testdb.getPharmacies();
                pharmacyServiceList = testdb.getPharmacyServices();
                serviceList = testdb.getServices();
                serviceProductList = testdb.getProductServices();
                productList = testdb.getProducts();
            }
            
            //ORDEN
            
            
            out.println("</body>");
            out.println("</html>");
            
            request.getRequestDispatcher("/mapPage.jsp").forward(request, response);
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
