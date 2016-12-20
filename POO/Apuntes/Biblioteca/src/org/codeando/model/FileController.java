package org.codeando.model;

import javafx.collections.ObservableList;

import java.io.*;

/**
 * Created by root on 30/11/16.
 * Controlador para archivos
 */

public class FileController
{
    private String path; // Guardamos la ruta del archivo
    private File archivo; // Guardamos el archivo abierto
    private BufferedWriter bw; // Escribir en archivos

    FileController(String path)
    {
        this.path = path;
        this.archivo = null;
        this.bw = null;
    }

    /*
    Metodos getter y setter
     */

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public File getArchivo() {
        return archivo;
    }
    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    public BufferedWriter getBw() {
        return bw;
    }
    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }

    /*
    Metodos
     */

    // Metodo para abrir el archivo
    private void openFile(Boolean type)
    {
        try {
            this.archivo = new File(this.path);

            if (this.archivo.exists()) {
                // Si el archivo existe
                this.bw = new BufferedWriter(new FileWriter(archivo, type));
            } else {
                // Si el archivo no existe
                this.bw = new BufferedWriter(new FileWriter(archivo, type));
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    // Metodo para escribir en el archivo
    public void writeFile(String cadena) throws Exception
    {
        // Abrimos el archivo
        this.openFile(true);

        this.bw.write(cadena);
        this.bw.newLine();

        // Ceramos el arrchivo
        this.bw.close();
    }

    // Metodo para leer un archivo
    public String[] readFile() throws Exception
    {
        String[] contenido = null;
        String cadena;
        int control = 0;

        // Leemos el archivo
        FileReader f = new FileReader(this.path);
        BufferedReader b = new BufferedReader(f);

        // Obtenemos el total de lineas
        while((b.readLine()) != null) {
            control++;
        }

        // Creamos el array
        contenido = new String[control];
        control = 0; // Resetemos el control
        b.close();
        FileReader auxF = new FileReader(this.path);
        BufferedReader c = new BufferedReader(auxF);

        // Obtenemos el contenido
        while((cadena = c.readLine()) != null) {
            contenido[control] = cadena;
            control++;
        }

        // Cerramos el archivo
        c.close();

        return contenido;
    }

    // Actualizamos archivo
    public void updatePersonFile(ObservableList<Persona> objeto)
    {
        // abrimos el archivo para que se sobreescriba todo
        this.openFile(false);

        try{
            String cadena;

            // Recorremos el objeto
            for(Persona temp: objeto){
                // Armamo la cadena
                cadena = temp.getNombre()+"#"+temp.getDomicilio()+"#"+temp.getTelefono();

                // Escribimos en el archivo
                this.bw.write(cadena);
                this.bw.newLine();
            }

            // Cerramos el archivo
            this.bw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    // Actualizamos archivo
    public void updateBookFile(ObservableList<Libro> objeto)
    {
        // abrimos el archivo para que se sobreescriba todo
        this.openFile(false);

        try{
            String cadena;

            // Recorremos el objeto
            for(Libro temp: objeto){
                // Armamo la cadena
                cadena = temp.getTitulo()+"#"+temp.getAutor()+"#"+temp.getIsbn()+"#"+temp.getEditorial()+"#"+temp.getAnio();

                // Escribimos en el archivo
                this.bw.write(cadena);
                this.bw.newLine();
            }

            // Cerramos el archivo
            this.bw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    // Actualizamos registro
    public void updateLendFile(ObservableList<Libro> objeto) throws Exception
    {
        // abrimos el archivo para que se sobreescriba todo
        this.openFile(false);


        String cadena;

        // Recorremos el objeto
        for(Libro temp: objeto){
            // Armamos la cadena
            cadena = temp.getTitulo()+"#"+temp.getAutor()+"#"+temp.getIsbn()+"#"+temp.getEditorial()+"#"+temp.getAnio()+"#"+temp.getNombre()+"#"+temp.getDomicilio()+"#"+temp.getTelefono()+"#"+temp.getFechaIn()+"#"+temp.getFechaOut();

            // Escribimos en el archivo
            this.bw.write(cadena);
            this.bw.newLine();
        }

        // Cerramos el archivo
        this.bw.close();
    }

    // Actualizamos registros vencidos
    public void updateVenLendFile(ObservableList<Libro> objeto, String nombre)
    {
        // abrimos el archivo para que se sobreescriba todo
        this.openFile(false);

        try{
            String cadena;

            // Recorremos el objeto
            for(Libro temp: objeto){
                if(!temp.getNombre().equals(nombre)) {
                    // Armamos la cadena
                    cadena = temp.getTitulo() + "#" + temp.getAutor() + "#" + temp.getIsbn() + "#" + temp.getEditorial() + "#" + temp.getAnio() + "#" + temp.getNombre() + "#" + temp.getDomicilio() + "#" + temp.getTelefono() + "#" + temp.getFechaIn() + "#" + temp.getFechaOut();

                    // Escribimos en el archivo
                    this.bw.write(cadena);
                    this.bw.newLine();
                }
            }

            // Cerramos el archivo
            this.bw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
