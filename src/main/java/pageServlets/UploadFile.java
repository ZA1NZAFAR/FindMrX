package pageServlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import models.Tableau;

/**
 *
 * @author z.zafar
 */
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(name = "UploadFile", urlPatterns = {"/UploadFile"})
public class UploadFile extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int[][] tableau = (int[][]) request.getAttribute("tableau");

        Tableau t = new Tableau(tableau);
        RequestDispatcher RequetsDispatcherObj = request.getRequestDispatcher("/mainGame.jsp");
        HttpSession session = request.getSession();
        session.setAttribute("nbTour", 0);
        session.setAttribute("tabGame", t);
        RequetsDispatcherObj.forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int nbLine = 0, nbColonne = 0;
        String line1;

        Part filePart = request.getPart("fileName");
        InputStream fileContent = filePart.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent, "UTF8"));

        line1 = reader.readLine();
        String[] line1coupe = line1.split(":");
        nbLine = Integer.parseInt(line1coupe[1]);
        nbColonne = Integer.parseInt(line1coupe[2]);

        int[][] tab = new int[nbLine][nbColonne];

        int compteur = 1;
        while (reader.ready()) {
            String line = reader.readLine();
            String[] linecoupe = line.split(":");
            linecoupe[0] = compteur + "";

            int[] tabTransforme = new int[linecoupe.length];

            for (int i = 0; i < tabTransforme.length; i++) {
                tabTransforme[i] = Integer.parseInt(linecoupe[i]); //String > int
            }
            tab[compteur - 1] = tabTransforme;
            compteur++;
        }

        request.setAttribute("nbLine", nbLine);
        request.setAttribute("nbColonne", nbColonne);
        request.setAttribute("tableau", tab);
        processRequest(request, response);
    }

}
