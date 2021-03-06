package vista;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.AccesoHibernate;
import modelo.BDManager;
import modelo.Empleado;
import modelo.Lugar;
import modelo.Modelo;
import modelo.Notificacion;

public class LugarController implements Initializable {
	private Main programaPrincipal;
	private Connection connection;
	private ObservableList<Empleado> masterData = FXCollections.observableArrayList();
	private ObservableList<Lugar> masterData3 = FXCollections.observableArrayList();
	private ObservableList<Notificacion> masterData2 = FXCollections.observableArrayList();
	private BDManager fichero;
	private AccesoHibernate hiber;


	 
	
	
	@FXML
	private TextField empleadosFilterField;
	@FXML
	private TableView<Empleado> empleadosTable;
	@FXML
	private TableColumn<Empleado, String> empleadosDni;
	@FXML
	private TableColumn<Empleado, String> empleadosNombre;
	@FXML
	private TableColumn<Empleado, String> empleadosFechaNacimiento;
	@FXML
	private TableColumn<Empleado, String> empleadosId;
	@FXML
	private TableColumn<Empleado, String> empleadosApe;
	@FXML
	private TableColumn<Empleado, String> empleadosCodParque;
	
	@FXML
	private Button empleadosNuevo;
	@FXML
	private Button empleadosBorrar;
	@FXML
	private Button empleadosMod;
	
	@FXML
	private TextField lugarFilterField;
	@FXML
	private TableView<Lugar> lugarTable;
	@FXML
	private TableColumn<Lugar, String> lugarCodigo;
	@FXML
	private TableColumn<Lugar, String> lugarNombre;
	@FXML
	private TableColumn<Lugar, String> lugarDireccion;
	@FXML
	private TableColumn<Lugar, String> lugarTlf;
	@FXML
	private Button lugarNuevo;
	@FXML
	private Button lugarBorrar;
	@FXML
	private Button lugarMod;
	@FXML
	private TextField notificacionFilterField;
	@FXML
	private TableView<Notificacion> notificacionTable;
	@FXML
	private TableColumn<Notificacion, String> notificacionCod;
	@FXML
	private TableColumn<Notificacion, String> notificacionUrgencia;
	@FXML
	private TableColumn<Notificacion, String> notificacionTipo;
	@FXML
	private TableColumn<Notificacion, String> notificacionDireccion;
	@FXML
	private Button notificacionNuevo;
	@FXML
	private Button notificacionBorrar;
	@FXML
	private Button notificacionMod;
	@FXML
	private Button refEmpleado;
	@FXML
	private Button refLugar;
	@FXML
	private Button refNotificacion;
	
	@FXML
	private Button notificacionBorrarTodo;
	
	@FXML
	private Button lugarBorrarTodo;
	
	@FXML
	private Button empleadoBorrarTodo;
	
	private void estilos() {
		
		Image clos = new Image(getClass().getResourceAsStream("refresh.png"));
		refLugar.setGraphic(new ImageView(clos));
		refNotificacion.setGraphic(new ImageView(clos));
		refEmpleado.setGraphic(new ImageView(clos));
	}
	
	
	@FXML
	private void nuevoEmpleado(ActionEvent ev) {
		try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newEmpleado.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Empleado");
            stage.setScene(new Scene(root1));  
            stage.show();
          }catch (IOException e) {
              //tratar la excepci�n.
          	System.out.println (e.toString());
          }
		
	}
	
	@FXML
	private void nuevaNotificacion(ActionEvent v) {
		try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newNotificacion.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Notificacion");
            stage.setScene(new Scene(root1));  
            stage.show();
          }catch (IOException e) {
              //tratar la excepci�n.
          	System.out.println (e.toString());
          }
		
	}
	
	@FXML
	private void nuevoLugar(ActionEvent z) {
		try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("newLugar.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Lugar");
            stage.setScene(new Scene(root1));  
            stage.show();
          }catch (IOException e) {
              //tratar la excepci�n.
          	System.out.println (e.toString());
          }
		
	}
	
	@FXML
	private void refresh() {
		cargarTodo();
	}

	
	@FXML
	private void modEmpleado() {
		
		
		
		
	}
	
	@FXML
	private void borrarEmpleado() {
		hiber=new AccesoHibernate();
		int inde= empleadosTable.getSelectionModel().getSelectedIndex();
		Empleado em = empleadosTable.getSelectionModel().getSelectedItem();
		masterData.remove(inde);
		String EM= String.valueOf(em.getCodInterno());
		hiber.borrarEmpleado(EM);
		
	}
	
	@FXML
	private void borrarTodoEmpleado() {
		hiber=new AccesoHibernate();
		masterData.clear();
		hiber.borrarEmpleadoTodo();
	}
	
	@FXML
	private void borrarTodoLugar() {
		hiber=new AccesoHibernate();
		masterData3.clear();
		hiber.borrarLugarTodo();
	}
	
	@FXML
	private void borrarTodoNotificacion() {
		hiber=new AccesoHibernate();
		masterData2.clear();
		hiber.borrarNotificacionTodo();
	}
	

	@FXML
	private void modLugar() {
		
		
		
		
	}
	@FXML
	private void borrarLugar() {
		hiber=new AccesoHibernate();
		int inde= lugarTable.getSelectionModel().getSelectedIndex();
		Lugar em = lugarTable.getSelectionModel().getSelectedItem();
		masterData3.remove(inde);
		String EM= String.valueOf(em.getCodParque());
		hiber.borrarLugar(EM);
	}

	@FXML
	private void modNotificacion() {
		
		
		
		
	}
	@FXML
	private void borrarNotificacion() {
		hiber=new AccesoHibernate();
		int inde= notificacionTable.getSelectionModel().getSelectedIndex();
		Notificacion em = notificacionTable.getSelectionModel().getSelectedItem();
		masterData2.remove(inde);
		String EM= String.valueOf(em.getCodNotificacion());
		hiber.borrarNotificacion(EM);
	}
	
	
	
	@FXML
	private void cargarLugar() {
		hiber=new AccesoHibernate();
		masterData3.clear();
		for (int i = 0; i < hiber.obtenerLugar().size(); i++) {
			masterData3.add((Lugar) hiber.obtenerLugar().values().toArray()[i]);
		}

		lugarCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodParque())));
		lugarTlf.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
		lugarNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
		lugarDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
		
		FilteredList<Lugar> filteredData3 = new FilteredList<>(masterData3, p -> true);
		lugarFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData3.setPredicate(person3 -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (String.valueOf(person3.getCodParque()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} else if (person3.getDireccion().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				} else if (person3.getNombre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nota.
				}else if (person3.getTelefono().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				return false; // Does not match.
			});
		});
		SortedList<Lugar> sortedData3 = new SortedList<>(filteredData3);
		sortedData3.comparatorProperty().bind(lugarTable.comparatorProperty());
		lugarTable.setItems(sortedData3);

		
	}
	
	@FXML
	private void cargarNotificacion() {

		hiber=new AccesoHibernate();
		masterData2.clear();
		for (int i = 0; i < hiber.obtenerNotificacion().size(); i++) {
			masterData2.add((Notificacion) hiber.obtenerNotificacion().values().toArray()[i]);
		}

		notificacionCod.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodNotificacion())));
		notificacionUrgencia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUrgencia()));
		notificacionTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipo()));
		notificacionDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
		
		FilteredList<Notificacion> filteredData2 = new FilteredList<>(masterData2, p -> true);

		notificacionFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData2.setPredicate(person2 -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (String.valueOf(person2.getCodNotificacion()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} else if (person2.getDireccion().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				} else if (person2.getTipo().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nota.
				}else if (person2.getUrgencia().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				return false; // Does not match.
			});
		});
		
		SortedList<Notificacion> sortedData2 = new SortedList<>(filteredData2);
		sortedData2.comparatorProperty().bind(notificacionTable.comparatorProperty());
		notificacionTable.setItems(sortedData2);
		
	}
	
	@FXML
	private void cargarEmpleado() {
		hiber=new AccesoHibernate();
		masterData.clear();
		for (int i = 0; i < hiber.obtenerEmpleado().size(); i++) {
			masterData.add((Empleado) hiber.obtenerEmpleado().values().toArray()[i]);
		}
		// 0. Initialize the columns.
		empleadosDni.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDni()));
		empleadosNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
		empleadosFechaNacimiento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
		empleadosId.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodInterno())));
		empleadosApe.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaNacimiento()));
		empleadosCodParque.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCodParque())));

		
		// 1. Wrap the ObservableList in a FilteredList (initially display all data).
		FilteredList<Empleado> filteredData = new FilteredList<>(masterData, p -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		empleadosFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(person -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (String.valueOf(person.getCodInterno()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} else if (person.getDni().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				} else if (person.getNombre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nota.
				}else if (person.getFechaNacimiento().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}else if (person.getApellidos().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (String.valueOf(person.getCodParque()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Empleado> sortedData = new SortedList<>(filteredData);

		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(empleadosTable.comparatorProperty());

		// 5. Add sorted (and filtered) data to the table.
		
		empleadosTable.setItems(sortedData);
		

	}


	public void cargarTodo(){
		cargarLugar();
		cargarNotificacion();
		cargarEmpleado();
		
	}
	
	@SuppressWarnings("unused")
	private Stage ventana;

    public void setProgramaPrincipal(Main programaPrincipal) {
        this.programaPrincipal = programaPrincipal;
    }
	
	public void setStagePrincipal(Stage ventana) {
		this.ventana = ventana;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		estilos();
		cargarTodo();
	}
	
}
