package com.carloncho.pruebas.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:palabrasreservadasContext-TEST.xml")
public class TestInicial {

    @Test
    public void existePanel() {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("palabrasreservadasContext-TEST.xml");
    	assertNotNull(context.getBean("panel"));
    	
    }
	
}
