package com.tsa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tsa.constant.Constant;
import com.tsa.util.ObjectMap;

public class PdfModule {
	private WebElement element;
	public WebDriver driver;
	private ObjectMap pdfModuleMap=new ObjectMap(Constant.propertyFilePath);
	
	public PdfModule(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getPdfModuleBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(pdfModuleMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getPdfUploadInput(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(pdfModuleMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getPdfUploadText(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(pdfModuleMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getPdfUploadBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(pdfModuleMap.getLocator(elementNameInPropertyFile));
		return element;
	}
	
	public WebElement getPdfVerifyBtn(String elementNameInPropertyFile) throws Exception {
		element=driver.findElement(pdfModuleMap.getLocator(elementNameInPropertyFile));
		return element;
	}
}
