package application;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modelo.Modelo;
import vista.LugarController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
    private static Stage stagePrincipal;
    private AnchorPane rootPane;

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        Main.stagePrincipal = stagePrincipal;
        mostrarVentanaPrincipal();

    }
    public static void main(String[] args) {
        launch(args);
    }
    /*
     * cargamos la ventana principal
     */
    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/Lugar.fxml"));
            rootPane=(AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Ventana Principal");
            stagePrincipal.setScene(scene);
            stagePrincipal.setResizable(false);
            /*
             * A�adidos las llamadas del main al Controlador y del controlador al main ***/
            LugarController controller = loader.getController();
            controller.setProgramaPrincipal(this);

            stagePrincipal.show();
        } catch (IOException e) {
            //tratar la excepci�n.
        	System.out.println (e.toString());
        }
   }
	

}
