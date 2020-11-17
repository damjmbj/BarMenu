/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentebarmenu.view;

import componentebarmenu.ComponenteBarMenu;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
    private CheckBox normal;
    @FXML
    private MenuItem copiar, copiarContext;
    @FXML
    private MenuItem cortar, cortarContext;
    @FXML
    private MenuItem pegar, pegarContext;
    @FXML
    private MenuItem ayuda;
    @FXML
    private RadioMenuItem mayusculas;
    @FXML
    private RadioMenuItem minusculas;

    private JFrame ventana;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    /**
     * Para mostrar una ayuda acerca del bloc de notas
     *
     * @param e
     */
    public void actionAyuda(ActionEvent e) {
        Desktop enlace = Desktop.getDesktop();
        ayuda.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    //enlace al que queremos acceder
                    enlace.browse(new URI("https://www.bing.com/search?q=obtener+ayuda+con+el+bloc+de+notas+en+windows%c2%a010&filters=guid:%224466414-es-dia%22%20lang:%22es%22&form=T00032&ocid=HelpPane-BingIA"));
                } catch (IOException | URISyntaxException e) {
                    e.getMessage();
                }
            }
        });
    }

    /**
     * Para cambiar el texto a negrita
     *
     * @param e
     */
    public void actionNegrita(ActionEvent e) {
        negrita.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //si la cursiva está marcada, también se pondrá en negrita
                if (cursiva.isSelected()) {
                    notas.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 12));

                } else {
                    notas.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

                }

            }
        });
    }

    /**
     * Para cambiar el texto a cursiva
     *
     * @param e
     */
    public void actionCursiva(ActionEvent e) {
        cursiva.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //si la negrita está marcada, también se pondrá en cursiva
                if (negrita.isSelected()) {
                    notas.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 12));

                } else {
                    notas.setFont(Font.font("Verdana", FontPosture.ITALIC, 12));

                }

            }
        });
    }

    /**
     * Para cambiar el texto a normal
     *
     * @param e
     */
    public void actionNormal(ActionEvent e) {
        normal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                notas.setFont(Font.font("Verdana", FontPosture.REGULAR, 12));

            }
        });
    }

    /**
     * Para cambiar el texto a mayúsculas
     *
     * @param e
     */
    public void actionMayus(ActionEvent e) {
        String notasMayus = notas.getText(); //Convertimos el textArea a String
        mayusculas.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (mayusculas.isSelected()) {
                    notas.setText(notasMayus.toUpperCase()); //Convertimos el string a mayúsculas
                }

            }
        });
    }

    /**
     * Para cambiar el texto a minúsculas
     *
     * @param e
     */
    public void actionMinus(ActionEvent e) {
        String notasMinus = notas.getText(); //Convertimos el textArea a String
        minusculas.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (minusculas.isSelected()) {
                    notas.setText(notasMinus.toLowerCase()); //Convertimos el string a minúsculas
                }

            }
        });
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
        //Para elegir el fichero a abrir
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(ventana)) {
            //Creamos el objeto fichero/archivo y lo tratamos
            File archivo = fileChooser.getSelectedFile();
            FileReader lector = null;
            try {
                lector = new FileReader(archivo);
                BufferedReader bfReader = new BufferedReader(lector);

                String lineaFichero;
                StringBuilder contenidoFichero = new StringBuilder();

                // Recupera el contenido del fichero
                while ((lineaFichero = bfReader.readLine()) != null) {
                    //añade al contenido del fichero la línea
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
        //Se nos abrirá la ventana para guardar el fichero
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        //En las siguientes dos líneas de código indicamos la extensión en la que
        //guardará nuestro archivo, en este caso .txt.
        //Creamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        //Le indicamos el filtro
        fileChooser.setFileFilter(filtro);

        if (JFileChooser.APPROVE_OPTION == fileChooser.showSaveDialog(ventana)) {
            //Creamos el objeto fichero/archivo y lo tratatmos
            File archivo = fileChooser.getSelectedFile();
            FileWriter escritor = null;
            try {
                escritor = new FileWriter(archivo);
                escritor.write(notas.getText());//lo escribe en el textArea
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ComponenteBarMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ComponenteBarMenu.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    escritor.close();//Cierra el fichero
                } catch (IOException ex) {
                    Logger.getLogger(ComponenteBarMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
