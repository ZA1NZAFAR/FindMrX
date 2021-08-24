<%-- 
    Document   : mainGame
    Created on : Jan 11, 2021, 6:56:51 PM
    Author     : z.zafar
--%>

<%@page import="models.Tableau"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            table, td, th {
                border: 1px solid black;
                text-align: center;
                padding : 15px
            }
            table {
                border-collapse: collapse;
            }
            .win{
                size: 50 px;
                color: green;
            }
            .loss{
                size: 50 px;
                color: red; 
            }
        </style>
    </head>
    <h1>Find Mr. X</h1>
    <h2>Tour <%out.print(session.getAttribute("nbTour"));%>/20 </h1>
    <body>
        <%
            Tableau t = (Tableau) session.getAttribute("tabGame");
            if (t.stuckX()) {
        %>
        <h1 class="win">Vous avez gagne!</h1>
        <%} else if ((Integer) session.getAttribute("nbTour") >= 20) {%>
        <h1 class="loss">Vous avez perdu!</h1>
        <%
            }
            out.print(t.getHtml());

        %>
        <h2>Les mouvements :</h2>
        <form action="PlayATurn" method="post">
            <table>
                <tbody>
                    <tr>
                        <td>A</td>
                        <td>B</td>
                        <td>C</td>
                        <td>D</td>
                    </tr>
                    <tr>
                        <td><select name="jobA">
                                <option value="No move">Pas de mouvement</option>
                                <option value="Left">Gauche</option>
                                <option value="Right">Droite</option>
                                <option value="Up">Haut</option>
                                <option value="Down">Bas</option>
                            </select></td>
                        <td><select name="jobB">
                                <option value="No move">Pas de mouvement</option>
                                <option value="Left">Gauche</option>
                                <option value="Right">Droite</option>
                                <option value="Up">Haut</option>
                                <option value="Down">Bas</option>
                            </select></td>
                        <td><select name="jobC">
                                <option value="No move">Pas de mouvement</option>
                                <option value="Left">Gauche</option>
                                <option value="Right">Droite</option>
                                <option value="Up">Haut</option>
                                <option value="Down">Bas</option>
                            </select></td>
                        <td><select name="jobD">
                                <option value="No move">Pas de mouvement</option>
                                <option value="Left">Gauche</option>
                                <option value="Right">Droite</option>
                                <option value="Up">Haut</option>
                                <option value="Down">Bas</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" name="action" value="Jouer">
                            </form>
                        </td>


                        <td>
                            <form action='uploadCsv.jsp' method='post'>
                                <input type="submit" value="Réinitialiser le jeu" />
                            </form>
                        </td>

                    </tr>
                </tbody>
            </table>


    </body>
</html>
