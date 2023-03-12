package com.automation.tests;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyDemo {

	public static void main(String[] args) throws Exception {
		Properties msg = new Properties();
		
		msg.load(new FileInputStream("src//test//resources//data//config.properties"));
		
		System.out.println(msg.getProperty("message.to.class"));
		
	}

	}
