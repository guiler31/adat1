package vista;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.AccesoHibernate;
import modelo.Modelo;
import modelo.Notificacion;

public class newNotificacionController implements Initializable{
	private Modelo notificacion;
	private AccesoHibernate hib;
	private Notificacion not;
	
	@FXML
	private Button notificacionSave;
	@FXML
	private Button notificacionCancel;
	
	@FXML
	private TextField txtfTipo;
	
	@FXML
	private ChoiceBox<String> urgencia;
	
	@FXML
	private TextField txtfDireccion;
	
	private void estilos() {
		Image clos = new Image(getClass().getResourceAsStream("close.png"));
		notificacionCancel.setGraphic(new ImageView(clos));
		urgencia.getItems().addAll("alta", "media", "baja");
		urgencia.getSelectionModel().selectFirst();

		  
	}
	
	@FXML
	private void saveNotificacion(ActionEvent sv) throws ClassNotFoundException, SQLException {
		hib=new AccesoHibernate();
		hib.guardarNotificacion(new Notificacion(0,txtfDireccion.getText(), urgencia.getSelectionModel().getSelectedItem(), txtfTipo.getText()));
		Stage stage = (Stage) notificacionCancel.getScene().getWindow();
	    stage.close();
	    
	}
	
	@FXML
	private void cancelNotificacion(ActionEvent cl) {
		Stage stage = (Stage) notificacionCancel.getScene().getWindow();
	    stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		estilos();
	}
	
}
