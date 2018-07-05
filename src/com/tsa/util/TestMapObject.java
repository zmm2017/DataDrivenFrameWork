package com.tsa.util;


import java.io.FileInputStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tsa.appmodules.CheckPdfFailedPage;
import com.tsa.appmodules.CheckPdfSuccessPage;
import com.tsa.appmodules.RefreshPdfModulePage;
import com.tsa.appmodules.VerifyProtectedPdfFile;
import com.tsa.appmodules.VerifyUnprotectedPdfFile;
import com.tsa.constant.Constant;
import com.tsa.pageobjects.PdfModule;
import com.tsa.pageobjects.PdfVerifyFailed;
import com.tsa.pageobjects.PdfVerifySuccess;

public class TestMapObject {

	public static void main(String[] args) throws Exception {
		//1.������־��¼��
		Logger log = LogManager.getLogger(TestMapObject.class);
		DOMConfigurator.configure("log4j.xml");
		
		log.info("��һ����Ϊwebdriver���û�������");
		System.setProperty("webdriver.chrome.driver", "C:\\browser-drivers\\chromedriver.exe");
		
		log.info("�ڶ�����ʵ����һ��chrome webdriver����");
		WebDriver driver=new ChromeDriver();
		
		log.info("������������ָ����URL");
		driver.get(Constant.url);
		
		log.info("���Ĳ���ʵ����һ��pdf module����");
		PdfModule pdfModule=new PdfModule(driver);
		//pdfModule.getPdfUploadText("tsaplatform.pdfModule.uploadPdfText").sendKeys("���");
		pdfModule.getPdfUploadText("tsaplatform.pdfModule.uploadPdfText").sendKeys(Constant.singleSignFile);
		Thread.sleep(2000);
		System.out.println("ˢ��ǰ��"+pdfModule.getPdfUploadText("tsaplatform.pdfModule.uploadPdfText").getAttribute("value"));
		RefreshPdfModulePage.refreshByPressF5(pdfModule);
		System.out.println("ˢ�º�"+pdfModule.getPdfUploadText("tsaplatform.pdfModule.uploadPdfText").getAttribute("value"));
		Assert.assertEquals("", pdfModule.getPdfUploadText("tsaplatform.pdfModule.uploadPdfText").getAttribute("value"));
		driver.close();
	}

}
