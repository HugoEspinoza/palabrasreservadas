package com.carloncho.pruebas.front;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Date;


public class Record {

	private static final String CADENA_VACIA = "";

	public String leerArchivo() {
		String linea = "";
		String valor = "";
		try {
			InputStream in = getClass().getResourceAsStream("record.dat");
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			while (true) {
				linea = br.readLine();
				if (linea == null) {
					break;
				}
				valor = linea;
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valor;
	}

	public String compararTiempo(String tiempo, String record) {
		Date tiempoActual = new Date("23/09/2009 " + tiempo);
		Date tiempoRecord = new Date("23/09/2009 " + record);

		if (tiempoActual.compareTo(tiempoRecord) < 0) {
			System.out.println("Un nuevo tiempo record:  TiempoActual:" + tiempoActual);
			return tiempo;
		}

		System.out.println("El tiempo record antiguio: tiempoRecord: " + tiempoRecord);
		return "";
	}

}
