package vista;

import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Modelo;

public class newLugarController implements Initializable {
	private Modelo lugar;
	
	@FXML
	private Button lugarSave;
	@FXML
	private Button lugarCancel;
	
	@FXML
	private TextField txtfNombre;
		
	@FXML
	private TextField txtfTlf;
	
	@FXML
	private TextField txtfDireccion;
	

	
	private void estilos() {
		Image clos = new Image(getClass().getResourceAsStream("close.png"));
		lugarCancel.setGraphic(new ImageView(clos));
	}
	
	@FXML
	private void saveLugar(ActionEvent sv) throws ClassNotFoundException, SQLException {
		lugar=new Modelo();		
		lugar.registrarLugar(txtfNombre.getText(), txtfTlf.getText(), txtfDireccion.getText());
		Stage stage = (Stage) lugarCancel.getScene().getWindow();
	    stage.close();
	    
	}
	
	@FXML
	private void cancelLugar(ActionEvent cl) {
		Stage stage = (Stage) lugarCancel.getScene().getWindow();
	    stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		estilos();
	}
	
}
