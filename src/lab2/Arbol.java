/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author karena
 */
public class Arbol {

    int posh = 0, sw = 0, hijosolo = 0;
    int penul = 0;
    private Nodo raiz;
    private JPanel lienzo;

    public Arbol(JPanel lienzo) {
        this.lienzo = lienzo;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void insetarNodo(String info) {
        penul++;

        if (raiz == null) {
            Nodo n = new Nodo(info);
            raiz = n;

            n.setPosx(lienzo.getWidth() / 2);
            n.setPosy(0);
            n.setNivel(0);

            draw(n);

        } else {
            insertar(info, raiz, null);
        }

    }
    
    private void insertar(String info, Nodo actual, Nodo padre) {

        if (actual == null) {
            Nodo hijo = new Nodo(info);
            hijo.setPadre(padre);
            hijo.setNivel(padre.getNivel() + 1);

            double b = 2;
            double exp = hijo.getNivel() + 1;

            int factor = (int) (lienzo.getWidth() / Math.pow(b, exp));

            System.out.println(hijo.getNivel());
            System.out.println(lienzo.getWidth());
            System.out.println(factor);
            if (info.equals("*") || info.equals("+") || info.equals("?")) {
                hijosolo = 1;
                sw = 1;
            }
            if (penul == 2) {
                hijo.setPosx((padre.getPosx()) + 80);
                padre.setHd(hijo);

            } else if (penul == 3) {
                hijo.setPosx((padre.getPosx()) - 80);
                padre.setHi(hijo);
            } else {
                if (posh == 0) {
                    if (hijosolo == 2) {
                        hijo.setPosx((padre.getPosx()));
                        padre.setHi(hijo);
                        hijosolo = 0;
                    } else {
                        hijo.setPosx((padre.getPosx()) + 40);
                        padre.setHd(hijo);
                        posh++;
                        if (sw == 1) {
                            hijosolo++;
                            sw=0;
                        }
                    }

                } else {
                    if (hijosolo == 2) {
                        hijo.setPosx((padre.getPosx()));
                        padre.setHi(hijo);
                        hijosolo = 0;
                    } else {
                        hijo.setPosx((padre.getPosx()) - 40);
                        padre.setHi(hijo);
                        posh = 0;
                        if (sw == 1) {
                            hijosolo++;
                            sw=0;
                        }
                    }
                }

            }

            hijo.setPosy(padre.getPosy() + 50);

            draw(hijo);
        } else {
            if (penul == 2) {
                insertar(info, actual.getHd(), actual);
            } else {

                insertar(info, actual.getHi(), actual);

            }
        }
        /*
        if (info > actual.getInfo()) {
            insertar(info, actual.getHd(), actual);
        }else if (info < actual.getInfo()){
            insertar(info, actual.getHi(), actual);
        ¨*/
    }
   
   /* 
    private void insertar(String info, Nodo actual, Nodo padre) {

        if (actual == null) {
            Nodo hijo = new Nodo(info);
            hijo.setPadre(padre);
            hijo.setNivel(padre.getNivel() + 1);

            double b = 2;
            double exp = hijo.getNivel() + 1;

            int factor = (int) (lienzo.getWidth() / Math.pow(b, exp));

            System.out.println(hijo.getNivel());
            System.out.println(lienzo.getWidth());
            System.out.println(factor);

            if (penul == 2) {
                hijo.setPosx((padre.getPosx()) + 80);
                padre.setHd(hijo);

            } else if (penul == 3) {
                hijo.setPosx((padre.getPosx()) - 80);
                padre.setHi(hijo);
            } else {
                if (posh == 0) {
                    if (hijosolo == hijo.getNivel()) {
                        hijo.setPosx((padre.getPosx()));
                        padre.setHi(hijo);
                        hijosolo = 0;
                    } else {
                        hijo.setPosx((padre.getPosx()) + 40);
                        padre.setHd(hijo);
                        posh++;

                    }

                } else {
                    if (hijosolo == hijo.getNivel()) {
                        hijo.setPosx((padre.getPosx()));
                        padre.setHi(hijo);
                        hijosolo = 0;
                    } else {
                        hijo.setPosx((padre.getPosx()) - 40);
                        padre.setHi(hijo);
                        posh = 0;

                    }
                }

            }
            if (info.equals("*") || info.equals("+") || info.equals("?")) {
                hijosolo = (int) (hijo.getNivel() + 1);
            }

            hijo.setPosy(padre.getPosy() + 50);

            draw(hijo);
        } else {
            if (penul == 2) {
                insertar(info, actual.getHd(), actual);
            } else {

                insertar(info, actual.getHi(), actual);

            }
        }
        /*
        if (info > actual.getInfo()) {
            insertar(info, actual.getHd(), actual);
        }else if (info < actual.getInfo()){
            insertar(info, actual.getHi(), actual);
        }
    }
*/
    private void preorden(Nodo n) {

        if (n != null) {
            System.out.println(n.getInfo());
            preorden(n.getHi());
            preorden(n.getHd());
        }
    }

    public void recorridoPorNiveles() {
        Nodo p = raiz;
        LinkedList<Nodo> cola = new LinkedList<>();

        cola.add(p);
        while (!cola.isEmpty()) {
            p = cola.poll();
            if (p.getHi() != null) {
                cola.add(p.getHi());
            }
            if (p.getHd() != null) {
                cola.add(p.getHd());
            }
        }
    }

    public int altura(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        Nodo p = raiz;
        int nivelActual = 0;
        LinkedList<Nodo> colaNodos = new LinkedList<>();
        LinkedList<Integer> colaNiveles = new LinkedList<>();

        colaNodos.add(p);
        colaNiveles.add(nivelActual);

        while (!colaNodos.isEmpty()) {
            p = colaNodos.poll();
            nivelActual = colaNiveles.poll();
            if (p.getHi() != null) {
                colaNodos.add(p.getHi());
                colaNiveles.add(nivelActual + 1);
            }
            if (p.getHd() != null) {
                colaNodos.add(p.getHd());
                colaNiveles.add(nivelActual + 1);
            }
        }
        return nivelActual + 1;
    }

    public int calculateFactorDeEquilibrio(Nodo raiz) {
        int factorDeEquilibrio
                = altura(raiz.getHd())
                - altura(raiz.getHi());

        return factorDeEquilibrio;
    }

    public void asignarFactoresDeEquilibrio(Nodo p) {
        if (p != null) {
            p.setFe(calculateFactorDeEquilibrio(p));
            System.out.println(p.getInfo());
            System.out.println(p.getFe());
            System.out.println();
            asignarFactoresDeEquilibrio(p.getHi());
            asignarFactoresDeEquilibrio(p.getHd());
        }
    }

    public void draw(Nodo n) {
        Graphics g = lienzo.getGraphics();

        g.setColor(Color.yellow);
        g.fillOval(n.getPosx(), n.getPosy(), n.getRadio() * 2, n.getRadio() * 2);

        g.setColor(Color.black);
        g.drawString(n.getInfo() + "", n.getPosx() + n.getRadio() - 7, n.getPosy() + n.getRadio() + 3);
    }

    public void draw2(Nodo n) {
        Graphics g = lienzo.getGraphics();

        g.setColor(Color.red);
        g.fillOval(n.getPosx(), n.getPosy(), n.getRadio() * 2, n.getRadio() * 2);

        g.setColor(Color.black);
        g.drawString(n.getInfo() + "", n.getPosx() + n.getRadio() - 7, n.getPosy() + n.getRadio() + 3);
    }

    public void drawLI(Nodo no, Nodo nd) {
        Graphics g = lienzo.getGraphics();
        g.drawLine(no.getPosx(), no.getPosy() + no.getRadio() * 2,
                nd.getPosx() + nd.getRadio() * 2, nd.getPosy());
    }

}
