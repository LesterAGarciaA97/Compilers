package com.vorozco;

import org.apache.commons.lang3.StringUtils;

public class Frase {
    public String doPaco(){
        String frase = "juan paco pedro de la mar";
        return frase;
    }

    public String doFraseReversa(String frase) {
        String fraseReversa = frase;
        String[] palabras = fraseReversa.split(" ");
        var reversa = "";
        for (int i = palabras.length-1; i >= 0; i--){
            if (i == 0 || i == 1){
                reversa = reversa + " " + palabras[i];
            }
            else{
                reversa = reversa + palabras[i];
            }
        }
        return reversa;
    }

    public boolean doPalindromo(String frase) {
        String palabra = frase;
        palabra = frase.toLowerCase();
        palabra = palabra.replace(" ","");
        char[] letras = palabra.toCharArray();
        boolean esPalindromo = true;
        int tamanio = palabra.length();
        for (int i = 0; i < palabra.length(); i++){
            tamanio--;
            if(letras[i] != letras[tamanio]){
                esPalindromo = false;
            }
        }
        return esPalindromo;
    }

    public String doMayusculas(String frase) {
        String texto[] = frase.split(" ");
        String nuevaFrase = "";
        String quitarPaco = "paco";
        for (int i = 0; i<texto.length; i++){
            if (!(quitarPaco.equals(texto[i]))){
                nuevaFrase = nuevaFrase + texto[i] + " ";
            }
        }
        nuevaFrase = StringUtils.removeEnd(nuevaFrase, " ");
        nuevaFrase = nuevaFrase.toUpperCase();
        return nuevaFrase;
    }
}