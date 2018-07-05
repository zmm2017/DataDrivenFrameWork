package com.tsa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tsa.constant.Constant;
import com.tsa.util.ObjectMap;

public class TsaVerifyFailed {
	public WebDriver driver;
	private WebElement element;
	private ObjectMap obj=new ObjectMap(Constant.propertyFilePath);
	
	public TsaVerifyFailed(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getResultMessage(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(obj.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getGoBackBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(obj.getLocator(elementNameInPropertyFile));
		return element;
	}

}
