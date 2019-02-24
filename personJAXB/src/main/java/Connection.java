

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 *
 * @author mariosilva
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class Connection extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass().getName());
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, JAXBException {
        PersonService person = new PersonService();
        response.setContentType("text/html;charset=UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        Enumeration<String> headers = request.getHeaderNames();
        String header;
        while ((header = headers.nextElement()) != null) {
            String message = header + " : " + request.getHeader(header);
            logger.log(Level.INFO, message);
        }
/*
        String file = "Person.xml";
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        
        Marshaller marshaller = this.context.createMarshaller();
        marshaller.marshal(new File("Person.xml"));

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        InputStream inputStream = new FileInputStream(file);
        Person person =(Person) unmarshaller.unmarshal(inputStream);*/
       
        

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Person Info " + person.getPerson() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        try {
            processRequest(request, response);
        } catch (JAXBException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            processRequest(request, response);
        } catch (JAXBException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
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
