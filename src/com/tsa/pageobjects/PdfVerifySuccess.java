package com.tsa.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tsa.constant.Constant;
import com.tsa.util.ObjectMap;

public class PdfVerifySuccess {
	private WebElement element;
	public WebDriver driver;
	private ObjectMap objectMap=new ObjectMap(Constant.propertyFilePath);
	
	public PdfVerifySuccess(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getResultMessage(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getContractVersion(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getAuthorityOrg(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getApplyTime(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getIdentityInfo(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getBackBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(objectMap.getLocator(elementNameInPropertyFile));
		return element;
	}
}
