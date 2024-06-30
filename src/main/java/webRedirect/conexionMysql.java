/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package webRedirect;

import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import models.Persona;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "conexionMysql", urlPatterns = {"/conexionMysql"})
public class conexionMysql extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet conexionMysql</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet conexionMysql at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public Map<Integer,Persona> conseguirDatos() throws ClassNotFoundException{
        Persona persona = new Persona("","");
        Map<Integer,Persona> lista = new HashMap<Integer,Persona>();
        int contador = 0;
        try{
            //crearTabla();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/geofarmaciadb","root","");
            PreparedStatement ps;
            ResultSet rs;
            ps = conn.prepareStatement("SELECT * FROM personas ");
            rs = ps.executeQuery();
            out.println("RS QUERY: "+rs);
            while (rs.next()){
                lista.put(contador,new Persona(rs.getString("nombre"),rs.getString("apellido")));
                contador += 1;
            }
            rs.next();
            return lista;
        }catch (SQLException e){            
            out.println(e.toString());
            out.println(e.toString());
        }
        return lista;
    }
    
    public void subirDatos(Persona persona) throws ClassNotFoundException{
            out.println("SUBIR DATO");
        try{
            crearTabla();
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/geofarmaciadb","root","");
            PreparedStatement ps;
            ps = conn.prepareStatement("INSERT INTO personas (nombre, apellido) VALUES (?,?)");
            ps.setString(1,persona.getNombre());
            ps.setString(2,persona.getApellido());
            ps.execute();
            System.out.println("Valor del ps: "+ps);
            System.out.println("Se subio");
        }catch (SQLException e){            
            System.out.println(e.toString());
            out.println(e.toString());
        }
    }
    public void crearTabla() throws SQLException, ClassNotFoundException{
        
            
            try{
                out.println("CREAR TABLA");
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Classname");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/geofarmaciadb","root","");
                PreparedStatement ps;
                int rs;
                ps = conn.prepareStatement("CREATE TABLE IF NOT EXISTS personas (id int NOT NULL AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(255), apellido VARCHAR(255))");
                System.out.println("Creando tabla");
                rs = ps.executeUpdate();
                if (rs == 0){
                    System.out.println("La tabla se ha creado correctamente.");
                }else{
                    System.out.println("Hubo un error al crear base de datos");
                }
                out.println("---DATOS TABLA: "+rs);
            }catch(ClassNotFoundException e){
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
        out.println("DATOS DESDE GET");
        String textoPersonas = "";
        Map<Integer,Persona> lista = new HashMap<Integer,Persona>();
        
        try {
            crearTabla();
            out.println("GET");
                Persona persona = new Persona("","");
                lista = conseguirDatos();
                lista.forEach((key, value) -> {
                    System.out.println("Id: " + key + ", Nombre: " + value.getNombre()+" Apellido: "+value.getApellido());
                });
            processRequest(request, response);
        } catch (Exception ex) {
            
        }
        try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                    } catch (IOException ex) {
                    Logger.getLogger(conexionMysql.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        try {
            crearTabla();
            System.out.println("POST");
                Persona person = new Persona(request.getParameter("nombre"),request.getParameter("apellido"));
                subirDatos(person);
            System.out.println("POST terminado");
            processRequest(request, response);
        } catch (Exception ex) {
            System.out.println("Excepcion: "+ex.getMessage());
        }
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
