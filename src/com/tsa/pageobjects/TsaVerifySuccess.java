package com.tsa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tsa.constant.Constant;
import com.tsa.util.ObjectMap;

public class TsaVerifySuccess {
	public WebDriver driver;
	private WebElement element;
	private ObjectMap obj=new ObjectMap(Constant.propertyFilePath);
	
	public TsaVerifySuccess(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getResultMessage(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(obj.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getApplyTime(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(obj.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getDataFingerPrint(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(obj.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getGoBackBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(obj.getLocator(elementNameInPropertyFile));
		return element;
	}
}
