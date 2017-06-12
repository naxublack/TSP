/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Image;
import java.util.*;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Nacho
 */
public class Principal extends javax.swing.JFrame {
    private final JFileChooser openFileChooser;
    private BufferedReader originalBR;
    private Bays bays;
    ArrayList<Integer> secuencia;
    private String ruta;
    
    /**
     * Creates new form interfaz
     */
    public Principal() {
        this.secuencia = new ArrayList();
        initComponents();
        this.setLocationRelativeTo(null);
        openFileChooser = new JFileChooser();
        openFileChooser.setFileFilter(new FileNameExtensionFilter("Archivo de Texto", "txt"));
        jTextAreaLog.setEditable(false);
    }
    //Algoritmo de revoltijo aleatorio para generar un camino inicial.
    public static void shuffle(Object[] array)
    {
        int elementos = array.length;
        for(int i=0; i < elementos; i++)
        {
            int s = i + (int)(Math.random() * (elementos - i));
            Object temp = array[s];
            array[s] = array[i];
            array[i] = temp;                    
        }
    }
          
    
     public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/utalca_logo.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSalir = new javax.swing.JButton();
        jLabelAutor = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonAbrir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaLog = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButtonRevolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaCamino = new javax.swing.JTextArea();
        jButtonHeu = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonSalir.setBackground(new java.awt.Color(0, 0, 102));
        jButtonSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        jLabelAutor.setBackground(new java.awt.Color(153, 51, 255));
        jLabelAutor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelAutor.setText("Autor: Ignacio Muñoz R.");
        getContentPane().add(jLabelAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, -1, 30));

        jLabelTitulo.setBackground(new java.awt.Color(0, 0, 102));
        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("T S P");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 80, 40));

        jButtonAbrir.setText("Abir archivo...");
        jButtonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 130, 30));

        jTextAreaLog.setColumns(20);
        jTextAreaLog.setRows(5);
        jTextAreaLog.setText("      ##--- REGISTRO ---##");
        jScrollPane1.setViewportView(jTextAreaLog);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 370));

        jButton1.setText("PRUEBA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        jButtonRevolver.setText("Alg. Constructor");
        jButtonRevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRevolverActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRevolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 130, 30));

        jTextAreaCamino.setColumns(20);
        jTextAreaCamino.setRows(5);
        jTextAreaCamino.setText("Lista de Nodos\n[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29]\n");
        jScrollPane2.setViewportView(jTextAreaCamino);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 410, 260));

        jButtonHeu.setText("Aplicar Heurística");
        jButtonHeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHeuActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonHeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 130, 30));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tsp wallpaper.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        System.exit(0);
        
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirActionPerformed
        JFileChooser fc=new JFileChooser();
        int seleccion=fc.showOpenDialog(jLabelFondo);
        if(seleccion==JFileChooser.APPROVE_OPTION){
            File fichero=fc.getSelectedFile();
           // String nombreArchivo = fichero.getName();
            this.ruta = fichero.getAbsolutePath();
        // validar si el archivo es bueno
            try(FileReader fr=new FileReader(fichero)){
        String cadena="";
        int valorC=fr.read();
        while(valorC!=-1){
            cadena=cadena+(char)valorC;
            valorC=fr.read();
        }
       // textArea.setText(cadena);
    } catch (IOException e1) {
        System.out.print("ERROR");
    }
            try {
                // leer fichero y guardar
                leerArchivo(this.ruta);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonAbrirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Calendar cal = Calendar.getInstance();
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        jTextAreaLog.append("\n"+ sdf.format(cal.getTime()) +" Open command cancelled by user.");
        
        //Se debe hacer eso para tener el archivo de vuelta y ocuparlo en otro botón.
        File file=openFileChooser.getSelectedFile();            
            String nombre = file.getName();
            //jLabelMensaje.setText("El archivo se ha cargado exitosamente.");
            jTextAreaLog.append("\n"+ sdf.format(cal.getTime()) + " Archivo "+nombre+" cargado exitosamente!");
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonRevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRevolverActionPerformed
        // TODO add your handling code here:
        int matriz[][] = bays.getMatriz();
        int costo = 0;
        int index = 5;
        for (int i = 5; i <35; i++) {
            int menor = 1000000000;
            for (int j = 0; j< matriz[index].length; j ++) {
                if (menor > matriz[index][j] && !secuencia.contains(j+1) && matriz[index][j] != 0) {
                    menor = matriz[index][j];
                    index = j;
                }
            }
            costo = costo + menor;
            secuencia.add(index+1);
        }
        costo -= 1000000000;
        secuencia.remove(29);
        jTextAreaCamino.append("\n"+"El primer recorrido es: "+secuencia);
        jTextAreaCamino.append("\n"+"Y tiene un costo de: " + costo);
        
        
        
    }//GEN-LAST:event_jButtonRevolverActionPerformed

    private void jButtonHeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHeuActionPerformed
        int matriz[][] = bays.getMatriz();
        
        Random rnd1 = ThreadLocalRandom.current();
        for (int i = secuencia.size() - 1; i > 0; i--) {
          int index = rnd1.nextInt(i + 1);
          // Simple swap
          int a = secuencia.get(index);
          secuencia.set(index, secuencia.get(i));
          secuencia.set(i, a);
        }
        System.out.println(secuencia);
        
        //opcion a
        /*
        long peso = 0;
        for (int index = 0; index < secuencia.size(); index++) {
            if (index < 28) {
                peso += matriz[secuencia.get(index)+5][secuencia.get(index+1)+5];
            }
            else {
                peso += matriz[secuencia.get(28)+5][secuencia.get(0)+5];
            }
        }
        
        /*
        int costo = 0;
        for (int ite = 0; ite < secuencia.size(); ite++) {
            int index = secuencia.get(ite);
            for (int i = 5; i <35; i++) {
                int menor = 0;
                for (int j = 0; j< matriz[index].length; j ++) {
                    if (menor > matriz[index][j] && !secuencia.contains(j+1) && matriz[index][j] != 0) {
                        menor = matriz[index][j];
                        index = j;
                    }
                }
                costo += menor;
            }
        }
        System.out.println(costo);
        */
    }//GEN-LAST:event_jButtonHeuActionPerformed
  
        public void leerArchivo(String archivo) throws FileNotFoundException, IOException{
        
        FileReader f = new FileReader(archivo);
       
        try (BufferedReader b = new BufferedReader(f)) {
            //nombre
            String nombre=leerLinea( b.readLine());
            //System.out.println(nombre);
            //tipo
            String tipo=leerLinea( b.readLine());
            //System.out.println(tipo);
            //tipo
            String comentario=leerLinea( b.readLine());
            //System.out.println(comentario);
            //dimension
            String dimension=leerLinea( b.readLine());
            int dimension1= Integer.parseInt(dimension);
            //System.out.println(dimension1);
            //para ignorar unas lineas especificas del txt especifico.
            String ca1= b.readLine();
            String ca2= b.readLine();
            String ca3= b.readLine();
            String ca4= b.readLine();
            //-------------------------------
            this.bays =new Bays(nombre, tipo, comentario, dimension1);
            //leer matriz y guardar
            int fila=0;
            while(fila<bays.getDimension()){
                int columna=0;
                String lineaM=b.readLine();
                StringTokenizer tokens = new StringTokenizer(lineaM);
                while(tokens.hasMoreTokens() && columna<bays.getDimension()){
                    String elemento=tokens.nextToken();
                    int valor1= Integer.parseInt(elemento);
                    this.bays.addElemento(valor1, fila, columna);
                    columna++;
                }
                fila++;
            }
            
        }
    }

public String leerLinea(String linea){
    String cadena=SepararDatos(linea);
     return cadena;
}    
    
public String getRuta(){ 
    return this.ruta; 
}
// separa datos, por ejemplo "TIPE: TSP" ... retorno solo "TSP"
public String SepararDatos(String cadena){
    
StringTokenizer tokens = new StringTokenizer(cadena);
    String linea=tokens.nextToken();
    String frase=tokens.nextToken();
    while(tokens.hasMoreTokens())
        frase=frase + " " +tokens.nextToken();
        return frase;

}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAbrir;
    private javax.swing.JButton jButtonHeu;
    private javax.swing.JButton jButtonRevolver;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelAutor;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaCamino;
    private javax.swing.JTextArea jTextAreaLog;
    // End of variables declaration//GEN-END:variables
}