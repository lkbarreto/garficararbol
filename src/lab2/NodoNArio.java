/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lgguzman
 */
public class NodoNArio {
    private int info;
    private List<NodoNArio> nodos;
    private NodoNArio padre;

    public NodoNArio(int info, NodoNArio padre) {
        this.info = info;
        this.padre = padre;
        this.nodos = new ArrayList<>();
        
    }
    
    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public List<NodoNArio> getNodos() {
        return nodos;
    }

    public NodoNArio getPadre() {
        return padre;
    }

    public void setPadre(NodoNArio padre) {
        this.padre = padre;
    }
    
    
}
