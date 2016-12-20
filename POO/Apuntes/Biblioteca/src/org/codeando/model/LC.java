package org.codeando.model;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.codeando.MainApp;
import java.io.IOException;

/**
 * Created by root on 29/11/16.
 * Controlador para plantillas
 */
public class LC {
    public static Stage primaryStage;
    public static BorderPane rootLayout;
    public static Stage stage = new Stage();

    // Metodo para cargar la vista de libros
    public static void loadBook()
    {
        try{
            // Cargamos el layout para los libros
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BookLayout.fxml"));
            AnchorPane bookLayout = loader.load();
            bookLayout.setMinSize(0, 0);

            // Mostramos este layout en el centro del layout principal
            rootLayout.setCenter(bookLayout);
            rootLayout.setMargin(bookLayout, new Insets(2,2,2,2));

            BookLayoutController controller = loader.getController();
            controller.initTable();
        } catch(IOException e){
            // Mostramos mensaje de error
            e.printStackTrace();
        }
    }

    // Metodo para cargar la lista de personas
    public static void loadPerson()
    {
        try{
            // Cargamos el layout para los libros
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonLayoutController.fxml"));
            AnchorPane personLayout = loader.load();
            personLayout.setMinSize(0, 0);

            // Mostramos este layout en el centro del layout principal
            rootLayout.setCenter(personLayout);
            rootLayout.setMargin(personLayout, new Insets(2,2,2,2));

            PersonLayoutController controller = loader.getController();
            controller.initTable();
        } catch(IOException e){
            // Mostramos mensaje de error
            e.printStackTrace();
        }
    }

    // Metodo para cargar la lista de prestamos
    public static void loadLend()
    {
        try{
            // Cargamos el layout para los libros
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LendLayou.fxml"));
            AnchorPane lendLayout = loader.load();
            lendLayout.setMinSize(0, 0);

            // Mostramos este layout en el centro del layout principal
            rootLayout.setCenter(lendLayout);
            rootLayout.setMargin(lendLayout, new Insets(2,2,2,2));

            LendLayoutController controller = loader.getController();
            controller.initTable();
        } catch(IOException e){
            // Mostramos mensaje de error
            e.printStackTrace();
        }
    }

    // Metodo para cargar la lista de prestamos
    public static void loadVenLend()
    {
        try{
            // Cargamos el layout para los libros
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LendVenLayout.fxml"));
            AnchorPane lendVenLayout = loader.load();
            lendVenLayout.setMinSize(0, 0);

            // Mostramos este layout en el centro del layout principal
            rootLayout.setCenter(lendVenLayout);
            rootLayout.setMargin(lendVenLayout, new Insets(2,2,2,2));

            LendVenLayoutController controller = loader.getController();
            controller.initTable();
        } catch(IOException e){
            // Mostramos mensaje de error
            e.printStackTrace();
        }
    }

    // Metodo para cargar la ventana acerca de
    public static void loadAbout()
    {
        try{
            // Cargamos el layout para acerca de
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AboutLayout.fxml"));
            AnchorPane aboutLayout = loader.load();

            // Mostramos este layout en el centro del layout principal
            Scene scene = new Scene(aboutLayout);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Acerca de");
            stage.setResizable(false);
            stage.initOwner(primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
        } catch(IOException e){
            // Mostramos mensaje de error
            e.printStackTrace();
        }
    }

    // Metodo para cargar la ventana editar persona
    public static void loadEditPerson(Persona person)
    {
        try{
            // Cargamos el layout para persona nueva
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EditPersonLayout.fxml"));
            AnchorPane editPersonLayout = loader.load();

            // Mostramos este layout en el centro del layout principal
            Scene scene = new Scene(editPersonLayout);
            stage.setScene(scene);
            stage.setTitle("Edicion de clientes");
            stage.setResizable(false);

            // Evento disparado al intentar cerrar la ventana
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    closeWindows(); // Cerramos la ventana
                    event.consume();
                }
            });

            // Mandamos los datos
            EditPersonLayoutController controller = loader.getController();
            controller.setData(person);

            // Mostramos la ventana
            stage.initOwner(primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
        } catch(IOException e){
            // Mostramos mensaje de error
            e.printStackTrace();
        }
    }

    // Metodo para cargar la ventana editar libro
    public static void loadEditBook(Libro book)
    {
        try{
            // Cargamos el layout para persona nueva
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EditBookLayout.fxml"));
            AnchorPane editBookLayout = loader.load();

            // Mostramos este layout en el centro del layout principal
            Scene scene = new Scene(editBookLayout);
            stage.setScene(scene);
            stage.setTitle("Edicion de libros");
            stage.setResizable(false);

            // Evento disparado al intentar cerrar la ventana
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    closeWindows(); // Cerramos la ventana
                    event.consume();
                }
            });

            // Mandamos los datos
            EditBookLayoutController controller = loader.getController();
            controller.setData(book);

            // Mostramos la ventana
            stage.initOwner(primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
        } catch(IOException e){
            // Mostramos mensaje de error
            e.printStackTrace();
        }
    }

    // Metodo para cargar la ventana prestamos nuevos
    public static void loadEditLend(Libro lend) throws Exception
    {
        try{
            // Cargamos el layout para prestamos nuevos
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EditLendLayout.fxml"));
            AnchorPane newLendLayout = loader.load();

            // Mostramos este layout en el centro del layout principal
            Scene scene = new Scene(newLendLayout);
            stage.setScene(scene);
            stage.setTitle("Edicion de registro de prestamos");
            stage.setResizable(false);

            // Mandamos los datos
            EditLendLayoutController controller = loader.getController();
            controller.init(lend);

            // Evento disparado al intentar cerrar la ventana
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    closeWindows(); // Cerramos la ventana
                    event.consume();
                }
            });

            stage.initOwner(primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
        } catch(IOException e){
            // Mostramos mensaje de error
            e.printStackTrace();
        }
    }

    // Metodo para cargar la ventana prestamos nuevos
    public static void loadSetLend(Libro lend, TableView<Libro> lendTable, Boolean type) throws Exception
    {
        try{
            // Cargamos el layout para prestamos nuevos
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SetLendLayout.fxml"));
            AnchorPane newLendLayout = loader.load();

            // Mostramos este layout en el centro del layout principal
            Scene scene = new Scene(newLendLayout);
            stage.setScene(scene);
            stage.setTitle("Entrega de libros");
            stage.setResizable(false);

            // Mandamos los datos
            SetLendLayoutController controller = loader.getController();
            controller.init(lend, lendTable, type);

            // Evento disparado al intentar cerrar la ventana
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    closeWindows(); // Cerramos la ventana
                    event.consume();
                }
            });

            stage.initOwner(primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
        } catch(IOException e){
            // Mostramos mensaje de error
            e.printStackTrace();
        }
    }

    // Metodo para cargar la ventana persona nueva
    public static void loadNewPerson()
    {
        try{
            // Cargamos el layout para persona nueva
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/NewPersonLayout.fxml"));
            AnchorPane newPersonLayout = loader.load();

            // Mostramos este layout en el centro del layout principal
            Scene scene = new Scene(newPersonLayout);
            stage.setScene(scene);
            stage.setTitle("Registro de clientes");
            stage.setResizable(false);

            // Evento disparado al intentar cerrar la ventana
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    closeWindows(); // Cerramos la ventana
                    event.consume();
                }
            });

            stage.initOwner(primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
        } catch(IOException e){
            // Mostramos mensaje de error
            e.printStackTrace();
        }
    }

    // Metodo para cargar la ventana libro nuevo
    public static void loadNewBook()
    {
        try{
            // Cargamos el layout para libro nuevo
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/NewBookLayout.fxml"));
            AnchorPane newBookLayout = loader.load();

            // Mostramos este layout en el centro del layout principal
            Scene scene = new Scene(newBookLayout);
            stage.setScene(scene);
            stage.setTitle("Registro de libros");
            stage.setResizable(false);

            // Evento disparado al intentar cerrar la ventana
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    closeWindows(); // Cerramos la ventana
                    event.consume();
                }
            });

            stage.initOwner(primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
        } catch(IOException e){
            // Mostramos mensaje de error
            e.printStackTrace();
        }
    }

    // Metodo para cargar la ventana prestamos nuevos
    public static void loadNewLend() throws Exception
    {
        try{
            // Cargamos el layout para prestamos nuevos
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/NewLendLayout.fxml"));
            AnchorPane newLendLayout = loader.load();

            // Mostramos este layout en el centro del layout principal
            Scene scene = new Scene(newLendLayout);
            stage.setScene(scene);
            stage.setTitle("Registro de prestamos");
            stage.setResizable(false);

            // Mandamos los datos
            NewLendLayoutController controller = loader.getController();
            controller.init();

            // Evento disparado al intentar cerrar la ventana
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    closeWindows(); // Cerramos la ventana
                    event.consume();
                }
            });

            stage.initOwner(primaryStage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
        } catch(IOException e){
            // Mostramos mensaje de error
            e.printStackTrace();
        }
    }

    public static void closeWindows()
    {
        stage.close();
        stage = new Stage();
    }
}
