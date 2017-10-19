package vista;

import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Modelo;

public class newEmpleadoController implements Initializable {
	private Modelo empleado;
	
	@FXML
	private Button empleadosSave;
	@FXML
	private Button empleadosCancel;
	
	@FXML
	private TextField txtfDNI;
	@FXML
	private TextField txtfNombre;
	@FXML
	private TextField txtfApellidos;
	@FXML
	private DatePicker fechaNac;
	
	private void estilos() {
		Image clos = new Image(getClass().getResourceAsStream("close.png"));
		empleadosCancel.setGraphic(new ImageView(clos));
	}
	
	@FXML
	private void saveEmpleado(ActionEvent sv) throws ClassNotFoundException, SQLException {
		empleado=new Modelo();		
		String fecha = fechaNac.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		empleado.registrarEmpleado(txtfDNI.getText(), txtfNombre.getText(), txtfApellidos.getText(), fecha);
		Stage stage = (Stage) empleadosCancel.getScene().getWindow();
	    stage.close();
	    
	}
	
	@FXML
	private void cancelEmpleado(ActionEvent cl) {
		Stage stage = (Stage) empleadosCancel.getScene().getWindow();
	    stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		estilos();
	}
	
}
