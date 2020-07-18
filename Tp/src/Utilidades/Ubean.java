package Utilidades;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class Ubean {

	
	public static ArrayList<Field> obtenerAtributos(Object o)
	{
		ArrayList<Field> retorno = new ArrayList<Field>();
		Class c = o.getClass();
		
		for(Field f: c.getDeclaredFields()) 
		{
			retorno.add(f);
		}
		
		return retorno;
	}
	
	public static void ejecutarSet(Object o, String att, Object valor) 
	{		
		if(o != null && valor != null) 
		{
			Class c = o.getClass();
			
			String atributo = att.substring(0, 1).toUpperCase() + att.substring(1);
			
			for(Method m : c.getDeclaredMethods()) 
			{
				if(m.getName().startsWith("set" + atributo)) 
				{
					try 
					{
						m.invoke(o, valor);
					} 
					catch (IllegalAccessException e) 
					{
						e.printStackTrace();
					} 
					catch (IllegalArgumentException e) 
					{
						e.printStackTrace();
					} 
					catch (InvocationTargetException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
	public static Object ejecutarGet(Object o, String att) 
	{
		Object retorno = null;
		
		if(o != null) 
		{
			Class c = o.getClass();
			
			String atributo = att.substring(0, 1).toUpperCase() + att.substring(1);			
			for(Method m : c.getDeclaredMethods()) 
			{
				if(m.getName().startsWith("get" + atributo))
				{
					try 
					{
						retorno = m.invoke(o);
					} 
					catch (IllegalAccessException e) 
					{
						e.printStackTrace();
					} 
					catch (IllegalArgumentException e) 
					{
						e.printStackTrace();
					} 
					catch (InvocationTargetException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
		return retorno;
	}
	
	
}
