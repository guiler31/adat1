package modelo;



public interface AccesoDatos {

	public void addOne(String [] datos );
	
	public String[][] leeTodos();
	
	public void escribeTodos(String[][] listaDatos);
	

}
