package com.carloncho.pruebas.front;

import java.awt.Color;
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Panel extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private final String ERROR_EN_HILO = "Ha sucedido un error inesperado en el hilo";
	private final String GAME_OVER = "GAME OVER...Tienes que repasar mas!";
	private final String WIN_GAME = "FELICITACIONES!!!";
	private final String WIN_GAME_RECORD_TIME = "FELICITACIONES hay un nuevo record: ";
	private final String CADENA_VACIA = "";
	private final String NRO_INTENTOS_ERRADOS = "Nro de intentos errados: ";
	private final String CIA_SOFTWARE = "CHVE Software Corporation";
	private final String PALABRA_YA_ENCONTRADA = "Ya se había encontrado la palabra: ";

	private int fila = 10;
	private int columna = 5;
	private byte numeroIntentos = 0;
	private byte numeroMaximoIntentos = 0;
	
	
	private Label lblIngrese;
	private Label lblMensaje;
	private Label lblMsgTiempo;
	private JTextField txtPalabra;
	private JButton jbProcesar;
	private JButton jbReiniciar;
	private JButton[][] arregloBotones = new JButton[fila][columna];
	private Thread crono;
	private int min = 0;
	private int seg = 0;
	private int hor = 0;
	private boolean flagTiempo = false;
	private String record;
	private Record datafile;

	public Panel() {}
	public Panel(String tituloApp, Integer parametroX, Integer parametroY, Byte numeroMaximoIntentos) {
		super(tituloApp);

		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		this.numeroMaximoIntentos = numeroMaximoIntentos;
		
		this.datafile = new Record();
		//this.record = this.datafile.leerArchivo();	//TODO: Lectura de record
		this.record = "23/09/2009";
		
		this.jbProcesar = new JButton("Procesar");
		this.jbReiniciar = new JButton("R");
		this.lblIngrese = new Label("Ingresar Palabra Reservada");
		this.lblMensaje = new Label("CHVE Software Corporation");

		this.lblMsgTiempo = new Label();
		this.txtPalabra = new JTextField();
		this.lblIngrese.setBounds(10, 0, 160, 25);

		this.txtPalabra.setBounds(175, 0, 125, 25);
		this.jbProcesar.setBounds(305, 0, 100, 25);
		this.jbReiniciar.setBounds(410, 0, 50, 25);
		this.lblMensaje.setBounds(0, 325, 480, 20);
		this.lblMsgTiempo.setBounds(480, 325, 90, 20);
		this.lblMsgTiempo.setAlignment(0);
		this.lblMensaje.setBackground(Color.gray);
		this.lblMsgTiempo.setBackground(Color.white);

		this.jbProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar(txtPalabra.getText().trim());
			}
		});
		this.jbReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarTodo();
			}
		});
		arregloBotones();

		crono = new Thread(this);
		crono.start();

		contentPane.add(lblIngrese);
		contentPane.add(lblMensaje);
		contentPane.add(lblMsgTiempo);
		contentPane.add(txtPalabra);
		contentPane.add(jbProcesar);
		contentPane.add(jbReiniciar);
		limpiar();
		setSize(parametroX, parametroY);
	}

	public void arregloBotones() {
		int x = 10;
		int y = 50;
		for (int i = 0; i < this.fila; i++) {
			for (int j = 0; j < this.columna; j++) {
				arregloBotones[i][j] = new JButton(CADENA_VACIA);
				arregloBotones[i][j].setBounds(x, y, 110, 25);
				arregloBotones[i][j].setBackground(Color.lightGray);
				arregloBotones[i][j].setVisible(true);
				arregloBotones[i][j].setEnabled(false);
				String pista = Palabras.busquedaPista(CADENA_VACIA +j + i);
				arregloBotones[i][j].setToolTipText(pista);
				add(arregloBotones[i][j]);
				x += 110;
			}
			x = 10;
			y += 25;
		}
	}

	public void pintarBoton(String vExito, String palabra) {
		int primer = Integer.parseInt(vExito.substring(0, 1));
		int segundo = Integer.parseInt(vExito.substring(1, 2));
		String tiempoActual = lblMsgTiempo.getText();

		if (CADENA_VACIA.equals(arregloBotones[segundo][primer].getText())) {
			arregloBotones[segundo][primer].setText(palabra);
			arregloBotones[segundo][primer].setBackground(Color.white);
			if (validaExitoJuego()) {
				lblMensaje.setText(WIN_GAME);
				lblMensaje.setBackground(Color.lightGray);
				try {
					Thread.sleep(2500L);
				} catch (InterruptedException e) {
					lblMensaje.setText(ERROR_EN_HILO);
				}

				if (!CADENA_VACIA.equals(this.datafile.compararTiempo(tiempoActual, this.record))) {
					lblMensaje.setText(WIN_GAME_RECORD_TIME + tiempoActual);
					lblMensaje.setBackground(Color.lightGray);
					record = tiempoActual;
					try {
						Thread.sleep(2500L);
					} catch (InterruptedException e) {
						lblMensaje.setText(ERROR_EN_HILO);
					}

				}

				limpiarTodo();
			}
		} else {
			pintarMensaje(palabra, true);
		}
		limpiar();
	}

	public boolean validaExitoJuego() {
		boolean flag = true;
		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				if (CADENA_VACIA.equals(arregloBotones[i][j].getText()))
					flag = false;
			}
		}
		return flag;
	}

	public void validar(String palabra) {
		String vExito = Palabras.busquedaPalabra(palabra);
		if (vExito.length() > 0) {
			pintarBoton(vExito, palabra);
		} else {
			pintarMensaje(CADENA_VACIA, false);
			limpiar();
		}
	}

	private void pintarMensaje(String cadena, boolean flagIntento) {
		this.numeroIntentos += 1;
		try {
			if (flagIntento) {
				lblMensaje.setText("Ya se había encontrado la palabra: " + cadena);
				lblMensaje.setBackground(Color.lightGray);
				Thread.sleep(2500L);
			}
			lblMensaje.setText("Nro de intentos errados: " + this.numeroIntentos);
			lblMensaje.setBackground(Color.lightGray);
			Thread.sleep(2500L);

			if (this.numeroIntentos == numeroMaximoIntentos) {
				lblMensaje.setText(GAME_OVER);
				lblMensaje.setBackground(Color.red);
				Thread.sleep(2500L);
				limpiarTodo();
			}
		} catch (InterruptedException e) {
			lblMensaje.setText(ERROR_EN_HILO);
		} finally {
			lblMensaje.setText("CHVE Software Corporation");
			lblMensaje.setBackground(Color.gray);
		}
	}

	private void limpiar() {
		txtPalabra.setText(CADENA_VACIA);
		txtPalabra.requestFocus();
	}

	private void limpiarTodo() {
		limpiar();
		numeroIntentos = 0;
		limpiarCronometro();

		for (int i = 0; i < this.fila; i++) {
			for (int j = 0; j < this.columna; j++) {
				arregloBotones[i][j].setVisible(true);
				arregloBotones[i][j].setBackground(Color.lightGray);
				arregloBotones[i][j].setText(CADENA_VACIA);
			}
		}
		lblMensaje.setText("CHVE Software Corporation");
		lblMensaje.setBackground(Color.gray);
	}

	private void limpiarCronometro() {
		flagTiempo = true;
	}
/*
	public static void main(String[] arg) {
		
		Panel PanelPrincipal = new Panel("Palabras Reservadas en JAVA 8", 580, 375);
		PanelPrincipal.setDefaultCloseOperation(3);
		PanelPrincipal.setVisible(true);
		
	}
*/
	public void run() {
		try {
			while (true) {
				if (flagTiempo) {
					this.seg = -1;
					this.min = 0;
					this.hor = 0;
					this.flagTiempo = false;
				}

				if (this.seg == 59) {
					this.seg = 0;
					this.min += 1;
				}
				if (this.min == 59) {
					this.min = 0;
					this.hor += 1;
				}
				this.seg += 1;

				String s = "0" + this.seg;
				String m = "0" + this.min;
				String h = "0" + this.hor;
				lblMsgTiempo.setText(h + ":" + m + ":" + s);

				Thread.sleep(1000L);
			}
		} catch (InterruptedException e) {
			lblMensaje.setText(ERROR_EN_HILO);
		}
	}

}
