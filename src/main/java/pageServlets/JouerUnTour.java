package pageServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Tableau;

/**
 *
 * @author z.zafar
 */
@WebServlet(name = "PlayATurn", urlPatterns = {"/PlayATurn"})
public class JouerUnTour extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PlayATurn</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PlayATurn at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Tableau t = (Tableau) session.getAttribute("tabGame");

        t.moveX();
        t.move('A', request.getParameter("jobA"));
        t.move('B', request.getParameter("jobB"));
        t.move('C', request.getParameter("jobC"));
        t.move('D', request.getParameter("jobD"));
        

        session.setAttribute("nbTour", (Integer) session.getAttribute("nbTour") + 1);

        RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/mainGame.jsp");
        RequetsDispatcherObj.forward(request, response);
        processRequest(request, response);
    }
}
