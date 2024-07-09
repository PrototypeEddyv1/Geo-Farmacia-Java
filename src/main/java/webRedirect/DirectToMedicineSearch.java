/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package webRedirect;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import models.Product;
import models.TestDatabase;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "medicineSearch", urlPatterns = {"/medicineSearch"})
public class DirectToMedicineSearch extends HttpServlet {
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
            /* TODO output your page here. You may use following sample code. */
            //Conseguir las medicinas
            System.out.println("Declarando variables");
            Map<Integer,Object> medicineList = new HashMap<Integer,Object>();
            Map<Integer,Object> products = new HashMap<Integer,Object>();
            Product currentP;
            Gson gson = new Gson();
            products = testdb.getProducts();
            System.out.println("Products: "+products);
            System.out.println("Products: "+products.get(1));
            System.out.println("Usando el loop");
            for (int i = 1; i < products.size()+1; i++){
                System.out.println("Dato: "+i);
                currentP = (Product) products.get(i);
                System.out.println("Checando si dato "+currentP+" es medicina");
                if (currentP.getId_type() > 1){
                    System.out.println("Agregando medicina");
                    medicineList.put(medicineList.size(),currentP);
                }
            }
            System.out.println("Loop terminado, ahora agregando atributo");
            String productsJson = gson.toJson(medicineList);
            System.out.println(productsJson);
            request.setAttribute("MedicineList", productsJson);
            System.out.println("Accediendo al menu de buscar farmacias");
            request.getRequestDispatcher("/busquedaMedicinas.jsp").forward(request, response);
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
