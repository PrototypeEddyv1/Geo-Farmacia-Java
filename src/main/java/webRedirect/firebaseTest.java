/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package webRedirect;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import firebasePack.Conection;
import firebasePack.FirebaseExample;
import firebasePack.FirebaseInitializer;
import firebasePack.ShowDbChanges;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Persona;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "firebaseTesting", urlPatterns = {"/firebaseTesting"})
public class firebaseTest extends HttpServlet {
    String idea;
    Conection firebasecon = new Conection();
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
            // Inicializar Firebase
            firebasecon = new Conection();
            //map.put("Dato1","Texto");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet firebaseTest</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet firebaseTest at " + request.getContextPath() + "</h1>");
            out.println("<p>Servlet firebaseTest at " + request.getContextPath() + "</p>");
            
            //fb.addFirebase(new Persona("Eduardo","Ruelas"));
            //Conection.connectToFirebase();
            //Conection.tryToConnect();
            //Conection.guardarDato();
            //FirebaseExample.conectar();
            //out.println("<p>Estado de la escritura de datos: "+Conection.writeData("Hola","12345",map)+"</p>");
            //Conection.addNewData();
            /*
            if (){
                out.println("<p>Todo salio bien</p>");
            }else{
                out.println("<p>Algo salio mal</p>");
            }*/
            //out.println("<p>"+Conection.connectToFirebase()+"</p>");
            
            
            out.println("</body>");
            out.println("</html>");
        }    }

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
        Conection.tryToConnect();
        /*
        Thread t=new Thread(new ShowDbChanges());

        t.run();
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
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
