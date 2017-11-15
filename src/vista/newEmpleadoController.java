package vista;

import java.net.URL;
import java.sql.SQLException;
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
import modelo.AccesoHibernate;
import modelo.Empleado;
import modelo.Lugar;
import modelo.Modelo;

public class newEmpleadoController implements Initializable {
	private Modelo empleado;
	private AccesoHibernate hib;
	private Empleado emp;
	
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
	private TextField txtfCodPark;
	@FXML
	private DatePicker fechaNac;
	
	private void estilos() {
		Image clos = new Image(getClass().getResourceAsStream("close.png"));
		empleadosCancel.setGraphic(new ImageView(clos));
	}
	
	@FXML
	private void saveEmpleado(ActionEvent sv) throws ClassNotFoundException, SQLException {
		String fecha = fechaNac.getValue().toString();
		hib=new AccesoHibernate();
		hib.guardarEmpleados(new Empleado(0,txtfDNI.getText(), txtfNombre.getText(), txtfApellidos.getText(), fecha, Integer.parseInt(txtfCodPark.getText())));
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
