/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentebarmenu.view;

import componentebarmenu.ComponenteBarMenu;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author DAM-2
 */
public class ContextMenuController implements Initializable {

    @FXML
    private TextArea notas;
    @FXML
    private CheckBox cursiva;
    @FXML
    private CheckBox negrita;
    @FXML
    private MenuItem copiar, copiarContext;
    @FXML
    private MenuItem cortar, cortarContext;
    @FXML
    private MenuItem pegar, pegarContext;

    private JFrame ventana;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    //Para cambiar a cursiva el texto
    public void cursiva() {

        notas.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

    }

    //Para cambiar a negrita el texto
    public void negrita() {

        notas.setFont(Font.font("Verdana", FontPosture.ITALIC, 12));

    }

    /**
     * Este método cierra la aplicación al pulsar la opción de Salir
     *
     * @param event
     */
    public void CloseApp(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    public void actionAbrir(ActionEvent e) {
        abrirArchivo();
    }

    public void actionGuardar(ActionEvent e) {
        guardarArchivo();
    }

    public void actionGuardarComo(ActionEvent e) {
        guardarComoArchivo();
    }

    public void actionNegrita(ActionEvent e) {
        negrita();
    }

    public void actionCursiva(ActionEvent e) {
        cursiva();
    }

    public void actionBuscar(ActionEvent e) {
        buscarPalabra();
    }

    /**
     * Para copiar el texto
     *
     * @param e
     */
    public void actionCopiar(ActionEvent e) {
        copiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                notas.copy();
            }
        });
    }

    public void actionCopiarContext(ActionEvent e) {
        copiarContext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                notas.copy();
            }
        });
    }

    /**
     * Pegar texto
     *
     * @param e
     */
    public void actionPegar(ActionEvent e) {
        pegar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                notas.paste();
            }
        });
    }

    public void actionPegarContext(ActionEvent e) {
        pegarContext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                notas.paste();
            }
        });
    }

    /**
     * Cortar texto
     *
     * @param e
     */
    public void actionCortar(ActionEvent e) {
        cortar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                notas.cut();
            }
        });
    }

    public void actionCortarContext(ActionEvent e) {
        cortarContext.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                notas.cut();
            }
        });
    }

    /**
     * Método para abrir un archivo.txt existente
     */
    public void abrirArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(ventana)) {
            File archivo = fileChooser.getSelectedFile();
            FileReader lector = null;
            try {
                lector = new FileReader(archivo);
                BufferedReader bfReader = new BufferedReader(lector);

                String lineaFichero;
                StringBuilder contenidoFichero = new StringBuilder();

                // Recupera el contenido del fichero
                while ((lineaFichero = bfReader.readLine()) != null) {
                    contenidoFichero.append(lineaFichero);
                    contenidoFichero.append("\n");
                }

                // Pone el contenido del fichero en el area de texto
                notas.setText(contenidoFichero.toString());

            } catch (FileNotFoundException ex) {
                Logger.getLogger(ComponenteBarMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ComponenteBarMenu.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    lector.close();
                } catch (IOException ex) {
                    Logger.getLogger(ComponenteBarMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Método para guardar el archivo en edición
     */
    public void guardarArchivo() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        //En las siguientes dos líneas de código indicamos la extensión en la que
        //guardará nuestro archivo, en este caso .txt
        //Creamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        //Le indicamos el filtro
        fileChooser.setFileFilter(filtro);

        if (JFileChooser.APPROVE_OPTION == fileChooser.showSaveDialog(ventana)) {
            File archivo = fileChooser.getSelectedFile();
            FileWriter escritor = null;
            try {
                escritor = new FileWriter(archivo);
                escritor.write(notas.getText());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ComponenteBarMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ComponenteBarMenu.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    escritor.close();
                } catch (IOException ex) {
                    Logger.getLogger(ComponenteBarMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void guardarComoArchivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void buscarPalabra() {
        Component textArea = null;
        //Para mostrar la ventana del texto a buscar

        String textoABuscar = JOptionPane.showInputDialog(textArea, "Texto a buscar", "");
        /*
        Esto nos devolverá en posicion la posición en la que se ha encontrado
        el texto a buscar. Si devuelve -1 es que no lo ha encontrado.
         */
        String textoTotal = notas.getText();
        int posicion = textoTotal.indexOf(textoABuscar);
        String textoInicialDeBusqueda = notas.getSelectedText();
        if (textoInicialDeBusqueda == null) {
            textoInicialDeBusqueda = "";
        }
        //textoABuscar = JOptionPane.showInputDialog(textArea, "Texto a buscar", textoInicialDeBusqueda);

    }

}
