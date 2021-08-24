package models;

import java.io.StringWriter;

/**
 *
 * @author z.zafar
 */
public class Tableau {

    private static final int CASE_OCCUPIED = 99;
    private static int[][] tab;
    private static Case A, B, C, D, X;

    public Tableau(int[][] t) {
        tab = t;
        A = getEmptyCase('A');
        B = getEmptyCase('B');
        C = getEmptyCase('C');
        D = getEmptyCase('D');
        X = getEmptyCase('X');
    }

    private Case getEmptyCase(char val) {
        int x = (int) (Math.random() * ((tab.length - 1) - 1 + 1) + 1), y = (int) (Math.random() * ((tab[0].length - 1) - 1 + 1) + 1);
        while (tab[x][y] == 1) {
            x = (int) (Math.random() * ((tab.length - 1) - 1 + 1) + 1);
            y = (int) (Math.random() * ((tab[0].length - 1) - 1 + 1) + 1);
        }
        tab[x][y] = 1;
        return new Case(val, x, y);
    }

    public boolean stuckX() {
        return available(X.getX() + 1, X.getY()) == false && available(X.getX() - 1, X.getY()) == false
                && available(X.getX(), X.getY() + 1) == false && available(X.getX(), X.getY() - 1) == false;
    }

    public void move(char val, String direction) {
        switch (val) {
            case 'A':
                switch (direction) {
                    case "Left": //down
                        if (available(A.getX(), A.getY() - 1)) {
                            tab[A.getX()][A.getY()] = 0;
                            A.moveDown();
                            tab[A.getX()][A.getY()] = 1;
                        }
                        break;
                    case "Right": //up
                        if (available(A.getX(), A.getY() + 1)) {
                            tab[A.getX()][A.getY()] = 0;
                            A.moveUp();
                            tab[A.getX()][A.getY()] = 1;
                        }
                        break;
                    case "Up": //left
                        if (available(A.getX() - 1, A.getY())) {
                            tab[A.getX()][A.getY()] = 0;
                            A.moveLeft();
                            tab[A.getX()][A.getY()] = 1;
                        }
                        break;
                    case "Down"://right
                        if (available(A.getX() + 1, A.getY())) {
                            tab[A.getX()][A.getY()] = 0;
                            A.moveRight();
                            tab[A.getX()][A.getY()] = 1;
                        }
                        break;
                    default:
                        break;
                }
                break;
            case 'B':
                switch (direction) {
                    case "Left": //down
                        if (available(B.getX(), B.getY() - 1)) {
                            tab[B.getX()][B.getY()] = 0;
                            B.moveDown();
                            tab[B.getX()][B.getY()] = 1;
                        }
                        break;
                    case "Right": //up
                        if (available(B.getX(), B.getY() + 1)) {
                            tab[B.getX()][B.getY()] = 0;
                            B.moveUp();
                            tab[B.getX()][B.getY()] = 1;
                        }
                        break;
                    case "Up": //left
                        if (available(B.getX() - 1, B.getY())) {
                            tab[B.getX()][B.getY()] = 0;
                            B.moveLeft();
                            tab[B.getX()][B.getY()] = 1;
                        }
                        break;
                    case "Down"://right
                        if (available(B.getX() + 1, B.getY())) {
                            tab[B.getX()][B.getY()] = 0;
                            B.moveRight();
                            tab[B.getX()][B.getY()] = 1;
                        }
                        break;
                    default:
                        break;
                }
                break;
            case 'C':
                switch (direction) {
                    case "Left": //down
                        if (available(C.getX(), C.getY() - 1)) {
                            tab[C.getX()][C.getY()] = 0;
                            C.moveDown();
                            tab[C.getX()][C.getY()] = 1;
                        }
                        break;
                    case "Right": //up
                        if (available(C.getX(), C.getY() + 1)) {
                            tab[C.getX()][C.getY()] = 0;
                            C.moveUp();
                            tab[C.getX()][C.getY()] = 1;
                        }
                        break;
                    case "Up": //left
                        if (available(C.getX() - 1, C.getY())) {
                            tab[C.getX()][C.getY()] = 0;
                            C.moveLeft();
                            tab[C.getX()][C.getY()] = 1;
                        }
                        break;
                    case "Down"://right
                        if (available(C.getX() + 1, C.getY())) {
                            tab[C.getX()][C.getY()] = 0;
                            C.moveRight();
                            tab[C.getX()][C.getY()] = 1;
                        }
                        break;
                    default:
                        break;
                }
                break;
            case 'D':
                switch (direction) {
                    case "Left": //down
                        if (available(D.getX(), D.getY() - 1)) {
                            tab[D.getX()][D.getY()] = 0;
                            D.moveDown();
                            tab[D.getX()][D.getY()] = 1;
                        }
                        break;
                    case "Right": //up
                        if (available(D.getX(), D.getY() + 1)) {
                            tab[D.getX()][D.getY()] = 0;
                            D.moveUp();
                            tab[D.getX()][D.getY()] = 1;
                        }
                        break;
                    case "Up": //left
                        if (available(D.getX() - 1, D.getY())) {
                            tab[D.getX()][D.getY()] = 0;
                            D.moveLeft();
                            tab[D.getX()][D.getY()] = 1;
                        }
                        break;
                    case "Down"://right
                        if (available(D.getX() + 1, D.getY())) {
                            tab[D.getX()][D.getY()] = 0;
                            D.moveRight();
                            tab[D.getX()][D.getY()] = 1;
                        }
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;

        }
    }

    public void moveCase(Case c, String direction) {

    }

    public void moveX() {
        if (stuckX()) {
            return;
        }
        boolean moved = false;
        do {
            int direction = (int) (Math.random() * (4 - 1 + 1) + 1);
            switch (direction) {
                case 1: //down
                    if (available(X.getX(), X.getY() - 1)) {
                        tab[X.getX()][X.getY()] = 0;
                        X.moveDown();
                        tab[X.getX()][X.getY()] = 1;
                        moved = true;
                    }
                    break;
                case 2: //up
                    if (available(X.getX(), X.getY() + 1)) {
                        tab[X.getX()][X.getY()] = 0;
                        X.moveUp();
                        tab[X.getX()][X.getY()] = 1;
                        moved = true;
                    }
                    break;
                case 3: //left
                    if (available(X.getX() - 1, X.getY())) {
                        tab[X.getX()][X.getY()] = 0;
                        X.moveLeft();
                        tab[X.getX()][X.getY()] = 1;
                        moved = true;
                    }
                    break;
                case 4://right
                    if (available(X.getX() + 1, X.getY())) {
                        tab[X.getX()][X.getY()] = 0;
                        X.moveRight();
                        tab[X.getX()][X.getY()] = 1;
                        moved = true;
                    }
                    break;
                default:
                    break;
            }
        } while (moved == false);
    }

    public boolean available(int x, int y) {
        if (x >= tab.length || x < 0 || y >= tab.length || y < 0) {
            return false;
        }
        return !(tab[x][y] == 1);
    }

    public String getHtml() {
        StringWriter out = new StringWriter();

        out.write("<table>");
        for (int j = 0; j < tab[0].length - 1; j++) {
            if (j == 0) {
                out.write("<td></td>");
            }
            out.write("<td>" + (j + 1) + "</td>");
        }
        for (int i = 0; i < tab.length; i++) {
            out.write("<tr>");
            for (int j = 0; j < tab[0].length; j++) {
                if (j == 0) {
                    out.write("<td>" + (i + 1) + "</td>");
                } else if (tab[i][j] == 0) {
                    out.write("<td></td>");
                } else if (i == A.getX() && j == A.getY()) {
                    out.write("<td>" + A.getVal() + "</td>");
                } else if (i == B.getX() && j == B.getY()) {
                    out.write("<td>" + B.getVal() + "</td>");
                } else if (i == C.getX() && j == C.getY()) {
                    out.write("<td>" + C.getVal() + "</td>");
                } else if (i == D.getX() && j == D.getY()) {
                    out.write("<td>" + D.getVal() + "</td>");
                } else if (i == X.getX() && j == X.getY()) {
                    out.write("<td>" + X.getVal() + "</td>");
                } else {
                    out.write("<td bgcolor = \"black\"></td>");
                }
            }
            out.write("</tr>");
        }
        out.write("</table>");
        return out.toString();
    }

    public int[][] getTab() {
        return tab;
    }

    public void setTab(int[][] tab) {
        this.tab = tab;
    }

    public Case getA() {
        return A;
    }

    public void setA(Case A) {
        this.A = A;
    }

    public Case getB() {
        return B;
    }

    public void setB(Case B) {
        this.B = B;
    }

    public Case getC() {
        return C;
    }

    public void setC(Case C) {
        this.C = C;
    }

    public Case getD() {
        return D;
    }

    public void setD(Case D) {
        this.D = D;
    }

    public Case getX() {
        return X;
    }

    public void setX(Case X) {
        this.X = X;
    }

}
