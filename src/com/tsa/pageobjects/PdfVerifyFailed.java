package com.tsa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tsa.constant.Constant;
import com.tsa.util.ObjectMap;

public class PdfVerifyFailed {
	private WebElement element;
	public WebDriver driver;
	private ObjectMap objectMap=new ObjectMap(Constant.propertyFilePath);
	
	public PdfVerifyFailed(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getResultMessage(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getBackBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}

}
