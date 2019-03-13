package com.carloncho.pruebas.test;

import static org.assertj.core.api.Assertions.*;

import java.io.InputStream;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.carloncho.pruebas.front.Panel;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:palabrasreservadasContext-TEST.xml")
public class TestInicial {

	private static Properties propiedades;

	@Autowired
	private Panel panel;
	
	@BeforeClass
	public static void prepararPruebas() {
		
		propiedades = new Properties();
		
    	try {

    		InputStream fileIn = TestInicial.class.getClassLoader().getResourceAsStream("config-TEST.properties");
    		propiedades.load(fileIn);

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
    @Test
    public void contenidoPanel() {
    	
    	String panelTitulo = propiedades.getProperty("panel.principal.titulo.app");
    	assertThat(panelTitulo).isEqualTo(panel.getTitle());
    }
    
    
}
