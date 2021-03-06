package Servicios;

@Anotaciones.Tabla(nombre = "personas")
public class Persona {
	
	@Anotaciones.id
	private Integer id;
	@Anotaciones.Columna(nombre = "nombre")
	private String nombre;
	@Anotaciones.Columna(nombre = "apellido")
	private String apellido;
	
	public Persona() 
	{
		
	}
	
	public Persona(Integer id, String nombre, String apellido) 
	{
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Integer getId() 
	{
		return this.id;
	}
	
	public String getNombre() 
	{
		return this.nombre;
	}
	
	public String getApellido() 
	{
		return this.apellido;
	}
	
	public void setId(Integer id) 
	{
		this.id = id;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}
	
	
	@Override
	public boolean equals(Object obj) 
	{
		boolean retorno = false;
		
		if(obj != null) 
		{
			if(obj.getClass().equals(this.getClass())) 
			{
				Persona p = (Persona) obj;
			
				if(p.id == this.id) 
				{
					retorno = true;
				}
			}
		}
		
		return retorno;
	}
	
	@Override
	public int hashCode() 
	{
		int retorno = 1;
		retorno = retorno * 17 + this.id;
				
		return retorno;
	}
	
	
	@Override
	public String toString() 
	{
		return this.id + " " + this.nombre + " " + this.apellido;
	}

}
