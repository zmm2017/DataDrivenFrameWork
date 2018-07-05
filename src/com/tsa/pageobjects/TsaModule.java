package com.tsa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tsa.constant.Constant;
import com.tsa.util.ObjectMap;

public class TsaModule {
	public  WebDriver driver;
	public  ObjectMap obj=new ObjectMap(Constant.propertyFilePath);
	private  WebElement element;
	
	public TsaModule(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getTsaModuleBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(obj.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getSourceFileBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(obj.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getSourceFileText(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(obj.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getTsaFileBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(obj.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getTsaFileText(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(obj.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getTsaVerifyBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(obj.getLocator(elementNameInPropertyFile));
		return element;
	}
}
