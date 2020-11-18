/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentebarmenu;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Alumnos: Alejandro Escudero, Jose Manuel Becerra y Adrián Beaterio
 * Curso: 2º DAM
 */
public class ComponenteBarMenu extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ComponenteBarMenu.class.getResource("view/ContextMenuOverview.fxml"));
        
        stage.setTitle("Ejemplo de uso MenuBar");
        BorderPane page = (BorderPane) loader.load();
        Scene scene = new Scene(page);
        stage.setScene(scene);
        stage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
