/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

/**
 *
 * @author Nacho
 */
public class Bays {

    private String name;
    private String tipo;
    private String comentario;
    private int dimension;
    private final int matriz[][];
    

    public Bays(String name, String tipo, String comentario, int dimension) {
        this.name = name;
        this.tipo = tipo;
        this.comentario = comentario;
        this.dimension = dimension;
        this.matriz=new int[dimension][dimension];
    }
    
 
    
    public int getElemento(int f){
    int numero=matriz[f][0];
   
        for (int y = 0; y < this.dimension; y++){	
		if(matriz[f][y]>0){
                    if(numero>matriz[f][y]){
                       numero=matriz[f][y];
                       
                    }
                }       
        }
     return numero;
    }
        
    public void addElemento(int valor, int f, int c){
        matriz[f][c]=valor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    
}
