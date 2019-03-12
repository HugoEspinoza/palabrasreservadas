package com.carloncho.pruebas.front;

import java.util.Enumeration;
import java.util.Hashtable;

public class Palabras {

	public static Hashtable<String, String> htPalabras = new Hashtable<String, String>();
	public static final int intentos = 3;
	public static Hashtable<String, String> htPistas = new Hashtable<String, String>();

	private static final String CADENA_VACIA = "";
	
	static {
		cargarHashtablePalabras();
		cargarHashtablePistas();
	}

	private static void cargarHashtablePalabras() {
		htPalabras.put("00", "abstract");
		htPalabras.put("01", "assert");
		htPalabras.put("02", "boolean");
		htPalabras.put("03", "break");
		htPalabras.put("04", "byte");
		htPalabras.put("05", "case");
		htPalabras.put("06", "catch");
		htPalabras.put("07", "char");
		htPalabras.put("08", "class");
		htPalabras.put("09", "const");
		htPalabras.put("10", "continue");
		htPalabras.put("11", "default");
		htPalabras.put("12", "do");
		htPalabras.put("13", "double");
		htPalabras.put("14", "else");
		htPalabras.put("15", "enum");
		htPalabras.put("16", "extends");
		htPalabras.put("17", "final");
		htPalabras.put("18", "finally");
		htPalabras.put("19", "float");
		htPalabras.put("20", "for");
		htPalabras.put("21", "goto");
		htPalabras.put("22", "if");
		htPalabras.put("23", "implements");
		htPalabras.put("24", "import");
		htPalabras.put("25", "instanceof");
		htPalabras.put("26", "int");
		htPalabras.put("27", "interface");
		htPalabras.put("28", "long");
		htPalabras.put("29", "native");
		htPalabras.put("30", "new");
		htPalabras.put("31", "package");
		htPalabras.put("32", "private");
		htPalabras.put("33", "protected");
		htPalabras.put("34", "public");
		htPalabras.put("35", "return");
		htPalabras.put("36", "short");
		htPalabras.put("37", "static");
		htPalabras.put("38", "strictfp");
		htPalabras.put("39", "super");
		htPalabras.put("40", "switch");
		htPalabras.put("41", "synchronized");
		htPalabras.put("42", "this");
		htPalabras.put("43", "throw");
		htPalabras.put("44", "throws");
		htPalabras.put("45", "transient");
		htPalabras.put("46", "try");
		htPalabras.put("47", "void");
		htPalabras.put("48", "volatile");
		htPalabras.put("49", "while");
	}

	private static void cargarHashtablePistas() {
		htPistas.put("00", "Puede tener metodos sin desarrollo y metodos con desarrollo");
		htPistas.put("01", "Para que compile y para ejecutarlo se tiene habilitar en el JRE");
		htPistas.put("02", "Tipo de dato que solo tiene 2 valores");
		htPistas.put("03", "Para salir de un bucle o de un switch");
		htPistas.put("04", "Tipo de dato de rango:-128 a 127");
		htPistas.put("05", "Determina los \"casos\" en un switch");
		htPistas.put("06", "\"Agarra\" la excepcion");
		htPistas.put("07", "Es la unidad de la clase String");
		htPistas.put("08", "Para indicar que es una clase");
		htPistas.put("09", "Constante para objetos creados por el usuario");
		htPistas.put("10", "Detiene la iteración actual y pasa a la siguiente iteración del bucle sin salir de él");
		htPistas.put("11", "Usada en el última sentencia de un switch");
		htPistas.put("12", "Con esta palabra, la expresión se prueba en la parte inferior del bucle");
		htPistas.put("13", "Tipo de dato de rango:+/- 1.8E+308 y tamaño: 64bits");
		htPistas.put("14", "Usado en una Estructura de selección doble");
		htPistas.put("15", "Clase cuyo contenido es un conjunto de constantes");
		htPistas.put("16", "Para determinar uso de herencia");
		htPistas.put("17", "Para impedir que una clase herede de esta clase");
		htPistas.put("18", "Permite ejecutar codigo a pesar de encontrar una excepcion");
		htPistas.put("19", "Tipo de dato de rango:+/- 3.4E+38F y tamaño: 32bits");
		htPistas.put("20", "Bucle cuya repetición es controlada mediante contador");
		htPistas.put("21", "Ya no se usa, pero hay que aprenderla");
		htPistas.put("22", "Estructura Selectiva Simple");
		htPistas.put("23", "Para determinar uso de interfaces");
		htPistas.put("24", "Para hacer refencia a clases de otros paquetes");
		htPistas.put("25", "Sirve para consultar si un objecto es una instancia de una clase determinada, o de su padre");
		htPistas.put("26", "Tipo de dato de rango:-2,147,483,648 a 2,147,483,647");
		htPistas.put("27", "Sus metodos no estan desarrollados solo muestra los enunciados");
		htPistas.put("28", "Tipo de dato de rango:-9,223,372,036,854,775,808L a 9,223,372,036,854,775,807L");
		htPistas.put("29", "hace uso de librerías y métodos implementados en otro lenguaje como C o C++");
		htPistas.put("30", "Usado para instanciar objetos de una clase");
		htPistas.put("31", "Utilizado para \"agrupar\" clases y otros archivos");
		htPistas.put("32", "Indica que solo los miembros de la misma clase pueden acceder");
		htPistas.put("33", "Indica que solo los miembros de relacion padre-hijo pueden acceder");
		htPistas.put("34", "Indica que todos pueden acceder");
		htPistas.put("35", "Para los metodos que SI tienen retorno");
		htPistas.put("36", "Tipo de dato de rango:-32,768 a 32,767");
		htPistas.put("37", "Para evitar que una clase se instancie");
		htPistas.put("38", "Es usado para controlar aspectos de operaciones aritmeticas con punto-flotante");
		htPistas.put("39", "Para llamar al método padre dentro de una clase que ha reemplazado ese método");
		htPistas.put("40", "Estructura de selección múltiple que emplea otras palabras reservadas");
		htPistas.put("41", "Usado en el programación de multihilos");
		htPistas.put("42", "Hace referencia a los miembros de la propia clase en el objeto actual");
		htPistas.put("43", "Sentencia que requiere como único argumento un Objeto throwable");
		htPistas.put("44", "Se coloca al momento de definir un método y sirve para \"lanzar\" una excepción ");
		htPistas.put("45", "Se pide a la JVM que ignore esta variable cuando el objeto que la contiene es serializado");
		htPistas.put("46", "... es seguido, al menos, por una cláusula catch o una cláusula finally");
		htPistas.put("47", "Para indicar que el metodo NO tiene retorno");
		htPistas.put("48", "El valor de una variable volátil puede ser modificado de forma segura por diferentes hilos");
		htPistas.put("49", "La expresión se prueba en la parte superior del bucle");
	}

	@SuppressWarnings("rawtypes")
	public static String busquedaPalabra(String palabra) {
		Enumeration llaves = htPalabras.keys();
		while (llaves.hasMoreElements()) {
			String key = (String) llaves.nextElement();
			if (palabra.equals((String) htPalabras.get(key))) {
				return key;
			}
		}

		return CADENA_VACIA;
	}

	@SuppressWarnings("rawtypes")
	public static String busquedaPista(String posicion) {
		Enumeration llaves = htPistas.keys();
		while (llaves.hasMoreElements()) {
			String key = (String) llaves.nextElement();
			if (posicion.equals(key)) {
				return (String) htPistas.get(key);
			}
		}
		return CADENA_VACIA;
	}

}
