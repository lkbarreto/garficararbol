/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * 
 */
public class Nodo {
    
    private String info;
    private Nodo hd;
    private Nodo hi;
    private Nodo padre;
    private int fe;
    private int posx;
    private int posy;
    private int radio;
    private double nivel;

    public Nodo(String info) {
        this.info = info;
        this.fe = -3;
        this.radio = 15;
    }

    public double getNivel() {
        return nivel;
    }

    public void setNivel(double nivel) {
        this.nivel = nivel;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Nodo getHd() {
        return hd;
    }

    public void setHd(Nodo hd) {
        this.hd = hd;
    }

    public Nodo getHi() {
        return hi;
    }

    public void setHi(Nodo hi) {
        this.hi = hi;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }
    
    
}
