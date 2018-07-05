package com.tsa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	Properties property;
	
	public ObjectMap(String propertyFilePath){
		FileInputStream in;
		property = new Properties();
		try {
			in = new FileInputStream(propertyFilePath);
			property.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public By getLocator(String elementNameInPropertyFile) throws Exception {
		String locator=property.getProperty(elementNameInPropertyFile);
		By by=null;
		//System.out.println(locator);
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		locatorValue=new String(locatorValue.getBytes("ISO-8859-1"),"UTF-8");
		//System.out.println("定位类型是："+locatorType+"\n"+"定位值是："+locatorValue);
		switch(locatorType.toLowerCase()) {
		case "id":
			by= By.id(locatorValue);
			break;
		case "name":
			by= By.name(locatorValue);
			break;
		case "xpath":
			by=By.xpath(locatorValue);
			break;
		case "classname":
			by=By.className(locatorValue);
			break;
		case "tagname":
			by=By.tagName(locatorValue);
			break;
		case "linktext":
			by=By.linkText(locatorValue);
			break;
		case "partiallinktext":
			by=By.partialLinkText(locatorValue);
			break;
		case "cssselector":
			by=By.cssSelector(locatorValue);
			break;
		default:
			throw new Exception("输入的locator type未在程序中被定义："+locatorType);
		}
		return by;
	}
}
