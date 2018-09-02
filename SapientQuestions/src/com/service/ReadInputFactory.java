package com.service;

import com.constant.Constant;

public class ReadInputFactory {
	
	
	
	private ReadInputFactory() {
	}
	private static ReadInputFactory readInputFactory;
	private static ReadInput readInputCSV ;
	private static ReadInput readInputTXT ;
	private static ReadInput readInputXML ;
	
	public static ReadInputFactory instantiateObject() {
		if (null == readInputFactory) {
			synchronized (ReadInputFactory.class) {
				if (null == readInputFactory) {
					readInputFactory = new ReadInputFactory();
					readInputCSV = new ReadInputCSV();
					readInputTXT = new ReadInputTXT();
					readInputXML = new ReadInputXML();
				}
				
			}
			
		}
		return readInputFactory;
			
	}
	public ReadInput readInputFactoryExposer(String ext) {
		if(ext.equalsIgnoreCase(Constant.FILETYPE.CSV.getType())) {
			return readInputCSV;
		}
		else if(ext.equalsIgnoreCase(Constant.FILETYPE.TEXT.getType())) {
			return readInputTXT;
		}
		else if(ext.equalsIgnoreCase(Constant.FILETYPE.XML.getType())) {
			return readInputXML;
		}
		return null;
	}

}
