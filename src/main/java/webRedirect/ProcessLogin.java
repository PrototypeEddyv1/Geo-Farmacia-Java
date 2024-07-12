/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package webRedirect;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import models.TestDatabase;
import models.User;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ProcessLogin", urlPatterns = {"/ProcessLogin"})
public class ProcessLogin extends HttpServlet {
    public static TestDatabase testdb = new TestDatabase();
    Map<Integer,Object> users = new HashMap<Integer,Object>();
    Boolean correctData = false;
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
            JsonArray jsonArray = new JsonArray();
            String resultResponse = "";
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Datos incorrectos</h1>");
             //Get username equals
             correctData = false;
             //Conexion a la api
            String ip = "IP Adress";
            URL url = new URL("http://"+ip+"/geofarmaciasAPI/api_comands/authenticate_user.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            String userData = "{\"name\":\""+request.getParameter("username")+"\", \"pass\":\""+request.getParameter("password")+"\"}";
            try(OutputStream os = conn.getOutputStream()) {
                byte[] input = userData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            //To get the response from the builder (get the status of the authentication)
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder responseBuilder = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                responseBuilder.append(responseLine.trim());
            }
            System.out.println("Response: " + responseBuilder.toString());
            Gson gson = new Gson();
            
            JsonObject jsonObject = gson.fromJson(responseBuilder.toString(), JsonObject.class);
            String statusAuth = jsonObject.get("status").toString();
            System.out.println("status: "+statusAuth);
            if (statusAuth.equals("\"Successful\"")){
                correctData = true;
            }
}
             /*
             for (int i = 0; i < testdb.getUsers().size(); i++){
                 User user = (User) testdb.getUsers().values().toArray()[i];
                 out.println("<p> User: "+user.getName()+"="+request.getParameter("username")+"</p>");
                 out.println("<p> Pass: "+user.getPassword()+"="+request.getParameter("password")+"</p>");
                 if (user.getName().equals(request.getParameter("username"))){
                     if (user.getPassword().equals(request.getParameter("password"))){
                         out.println("<p>Contraseña incorrecta</p>");
                         correctData = true;
                     }
                 }
             }*/
            out.println("</body>");
            out.println("</html>");
            if (correctData == true){
                request.getRequestDispatcher("/folderAdmin/mainAdminMenu.jsp").forward(request, response);
            }
            //request.getParameter("nombre")
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
