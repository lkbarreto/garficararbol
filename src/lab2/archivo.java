/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author familia
 */
public class archivo {

    public String leerTxt(String direccion) {

        String texto = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {

                temp = temp + bfRead;
            }

            texto = temp;

        } catch (Exception e) {
            System.err.println("No se encontro archivo");
        }

        return texto;

    }

    
}
