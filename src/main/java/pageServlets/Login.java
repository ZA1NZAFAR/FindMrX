package pageServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.JoueurDB;

/**
 *
 * @author z.zafar
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Menu</h1>");
            out.println("<p>" + (String) request.getAttribute("nomJ") + "</p>");
            out.println("<p>" + (String) request.getAttribute("message") + "</p>");
            if(request.getAttribute("message").equals("Vous etes autorise a jouer."))
                out.println("<a href=\"uploadCsv.jsp\"> Commencez une nouvelle. </a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (JoueurDB.joueurMap.containsKey(request.getParameter("idJ"))) {
            request.setAttribute("nomJ", "Bonjour " + JoueurDB.joueurMap.get(request.getParameter("idJ")).getPrenom() + ".");
            if (request.getParameter("pwdJ").equals(JoueurDB.joueurMap.get(request.getParameter("idJ")).getMdp())) {
                if (JoueurDB.joueurMap.get(request.getParameter("idJ")).getAge() >= 18) {
                    request.setAttribute("message", "Vous etes autorise a jouer.");
                } else {
                    request.setAttribute("message", "Vous n'etes pas autorise a jouer.");
                }
            } else {
                request.setAttribute("message", "MDP incorrect.");
            }
        } else {
            request.setAttribute("nomJ", "Utilisateur inconnue.");
            request.setAttribute("message", "Reessayer avec un autre identifiant.");

        }
        processRequest(request, response);
    }

}
