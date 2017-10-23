package vista;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Main;
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
import modelo.BDManager;
import modelo.Empleado;
import modelo.Lugar;
import modelo.Modelo;
import modelo.Notificacion;

public class LugarController implements Initializable {
	private Main programaPrincipal;
	private Modelo database;
	private Connection connection;
	private ObservableList<Empleado> masterData = FXCollections.observableArrayList();
	private ObservableList<Lugar> masterData3 = FXCollections.observableArrayList();
	private ObservableList<Notificacion> masterData2 = FXCollections.observableArrayList();
	private BDManager fichero;


	 
	
	
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
		try {
			fichero.main(null);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		database= new Modelo();
		int inde= empleadosTable.getSelectionModel().getSelectedIndex();
		Empleado em = empleadosTable.getSelectionModel().getSelectedItem();
		masterData.remove(inde);
		String EM= em.codInternoProperty().get();
		try {
			database.BorrarEmpleado(EM);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void borrarTodoEmpleado() {
		database= new Modelo();
		masterData.clear();
		database.BorrarTodoEmpleado();
	}
	
	@FXML
	private void borrarTodoLugar() {
		database= new Modelo();
		masterData3.clear();
		database.BorrarTodoLugar();
	}
	
	@FXML
	private void borrarTodoNotificacion() {
		database= new Modelo();
		masterData2.clear();
		database.BorrarTodoNotificacion();
	}
	

	@FXML
	private void modLugar() {
		
		
		
		
	}
	@FXML
	private void borrarLugar() {
		database= new Modelo();
		int inde= lugarTable.getSelectionModel().getSelectedIndex();
		Lugar em = lugarTable.getSelectionModel().getSelectedItem();
		masterData3.remove(inde);
		String EM= em.codParqueProperty().get();
		try {
			database.BorrarLugar(EM);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void modNotificacion() {
		
		
		
		
	}
	@FXML
	private void borrarNotificacion() {
		database= new Modelo();
		int inde= notificacionTable.getSelectionModel().getSelectedIndex();
		Notificacion em = notificacionTable.getSelectionModel().getSelectedItem();
		masterData2.remove(inde);
		String EM= em.codNotificacionProperty().get();
		try {
			database.BorrarNotificacion(EM);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void cargarLugar() {
		database = new Modelo();

		masterData3 = database.getDatosLugar();
		
		lugarCodigo.setCellValueFactory(cellData -> cellData.getValue().codParqueProperty());
		lugarTlf.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
		lugarNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
		lugarDireccion.setCellValueFactory(cellData -> cellData.getValue().direccionProperty());
		
		FilteredList<Lugar> filteredData3 = new FilteredList<>(masterData3, p -> true);
		lugarFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData3.setPredicate(person3 -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (person3.getCodParque().toLowerCase().indexOf(lowerCaseFilter) != -1) {
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
		database = new Modelo();

		masterData2 = database.getDatosNotificacion();

		notificacionCod.setCellValueFactory(cellData -> cellData.getValue().codNotificacionProperty());
		notificacionUrgencia.setCellValueFactory(cellData -> cellData.getValue().urgenciaProperty());
		notificacionTipo.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());
		notificacionDireccion.setCellValueFactory(cellData -> cellData.getValue().direccionProperty());
		
		FilteredList<Notificacion> filteredData2 = new FilteredList<>(masterData2, p -> true);

		notificacionFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData2.setPredicate(person2 -> {
				// If filter text is empty, display all persons.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (person2.getCodNotificacion().toLowerCase().indexOf(lowerCaseFilter) != -1) {
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
		database = new Modelo();
		masterData = database.getDatosEmpleado();

		// 0. Initialize the columns.
		empleadosDni.setCellValueFactory(cellData -> cellData.getValue().dniProperty());
		empleadosNombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
		empleadosFechaNacimiento.setCellValueFactory(cellData -> cellData.getValue().fechaNacimientoProperty());
		empleadosId.setCellValueFactory(cellData -> cellData.getValue().codInternoProperty());
		empleadosApe.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());
		empleadosCodParque.setCellValueFactory(cellData -> cellData.getValue().codParqueProperty());

		
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
				
				if (person.getCodInterno().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} else if (person.getDni().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				} else if (person.getNombre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nota.
				}else if (person.getfechaNacimiento().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}else if (person.getApellidos().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (person.getCodParque().toLowerCase().indexOf(lowerCaseFilter) != -1) {
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
