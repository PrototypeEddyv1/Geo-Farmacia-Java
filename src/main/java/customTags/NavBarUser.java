/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customTags;

/**
 *
 * @author Usuario
 */
import java.io.IOException;
import java.io.StringWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import jakarta.servlet.http.HttpServletRequest;


/**
 *
 * @author Usuario
 */
public class NavBarUser extends SimpleTagSupport{
    StringWriter sw = new StringWriter();
    
    @Override
    public void doTag() throws JspException, IOException{
        
        getJspContext().getOut().println("<nav style=\"justify-content: space-between; flex-wrap:wrap; display:flex\">");
        getJspContext().getOut().println("<h2 style=\"display: flex; \">Nombre de usuario</h2>");
        getJspContext().getOut().println("<form style=\"margin-top:28px\">");
        getJspContext().getOut().println("<input type=\"submit\" value=\"Cerrar sesion\">");
        getJspContext().getOut().println("</form>");
        getJspContext().getOut().println("</nav>");
    }
}
