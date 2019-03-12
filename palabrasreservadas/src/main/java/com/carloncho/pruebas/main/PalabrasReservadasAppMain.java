package com.carloncho.pruebas.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.carloncho.pruebas.front.Panel;


public class PalabrasReservadasAppMain {

	public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("palabrasreservadasContext.xml");

        Panel panelPrincipal = (Panel) context.getBean("panel");
        panelPrincipal.setDefaultCloseOperation(3);
        panelPrincipal.setVisible(true);
	}

}
