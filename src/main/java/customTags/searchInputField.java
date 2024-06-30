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
public class searchInputField extends SimpleTagSupport{
    StringWriter sw = new StringWriter();
    
    @Override
    public void doTag() throws JspException, IOException{
        getJspContext().getOut().println(sw.toString());
        getJspContext().getOut().println("<tr>");
        getJspContext().getOut().println("<td>Buscar por "+sw.toString().toLowerCase()+"</td>");
        getJspContext().getOut().println("<td><input type=\"text\" id=\""+sw.toString()+"Search\"></td>");
        getJspContext().getOut().println("</tr>");
    }
}
