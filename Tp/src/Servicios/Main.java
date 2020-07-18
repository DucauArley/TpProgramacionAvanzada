package Servicios;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Integer id;
		String nombre;
		String apellido;
		Persona p = new Persona();
		
		System.out.println("Ingrese el numero de operacion que desea ingresar");
		System.out.println("1- Dar de alta Persona");
		System.out.println("2- Dar de baja Persona"); 
		System.out.println("3- Modificar Persona");
		System.out.println("4- Obtener Persona por id");
		
		Scanner sc = new Scanner(System.in);
        String numero = sc.nextLine();
        
        switch(numero) 
		{
			case "1":
				System.out.println("Ingrese el id");
				id = Integer.parseInt(sc.nextLine());
				System.out.println("Ingrese el nombre");
				nombre = sc.nextLine();
				System.out.println("Ingrese el apellido");
				apellido = sc.nextLine();
				p = new Persona(id, nombre, apellido);
				
				Consultas.guardar(p);
				
				System.out.println("Alta exitosa");
				break;
			case "2":
				System.out.println("Ingrese el id de la persona a eliminar");
				id = Integer.parseInt(sc.nextLine());
				
				p.setId(id);

				Consultas.eliminar(p);
				
				System.out.println("Baja exitosa");
				break;
			case "3":
				System.out.println("Ingrese el id de la persona a Modificar");
				id = Integer.parseInt(sc.nextLine());
				System.out.println("Ingrese el nombre");
				nombre = sc.nextLine();
				System.out.println("Ingrese el apellido");
				apellido = sc.nextLine();
				p = new Persona(id, nombre, apellido);
				
				Consultas.modificar(p);
				 
				break;
			case "4":
				System.out.println("Ingrese el id de la persona que desea obtener");
				id = Integer.parseInt(sc.nextLine());
				
				Persona o = (Persona) Consultas.obtenerPorId(Persona.class, id);			
				System.out.println(o.toString());
				
				break;			
		}
		

	}

}
