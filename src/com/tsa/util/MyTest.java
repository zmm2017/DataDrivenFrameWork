package com.tsa.util;

import org.testng.annotations.Test;

import com.tsa.appmodules.CheckPdfSuccessPage;
import com.tsa.appmodules.CheckTsaFailedPage;
import com.tsa.appmodules.CheckTsaSuccessPage;
import com.tsa.appmodules.VerifyProtectedPdfFile;
import com.tsa.appmodules.VerifyProtectedTsaFile;
import com.tsa.appmodules.VerifyUnprotectedTsaFile;
import com.tsa.constant.Constant;
import com.tsa.pageobjects.PdfModule;
import com.tsa.pageobjects.PdfVerifySuccess;
import com.tsa.pageobjects.TsaModule;
import com.tsa.pageobjects.TsaVerifyFailed;
import com.tsa.pageobjects.TsaVerifySuccess;

import org.testng.annotations.BeforeClass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class MyTest {
	public static PdfModule pdfModule;
	public static TsaModule tsaModule;
	public static WebDriver driver;
	
  @Test
  public void test() throws Exception {
	  //��ת��tsaģ��
	  tsaModule.getTsaModuleBtn("tsaplatform.tsaModule.tsaModuleBtn").click();
	  Boolean result=null;
	  
	  for(int i=1;i<7;i++) {
		//��ȡ��������
		TsaVerifySuccess tvs=null;
		ExcelUtil.setExcelFile("C:\\Users\\unitrust\\Desktop\\selenium\\��������.xlsx", "��������");
		String sourceFileName=ExcelUtil.getCellData(i, 1);
		String tsaFileName=ExcelUtil.getCellData(i, 2);
		String applyTime=ExcelUtil.getCellData(i, 3);
		String dataFinger=ExcelUtil.getCellData(i, 4);
		if(i==1) {
			tvs=VerifyProtectedTsaFile.executeWithLocatePath(sourceFileName, tsaFileName, tsaModule);
		}else {
			tvs=VerifyProtectedTsaFile.execute(sourceFileName, tsaFileName, tsaModule);
		}
			 
		//�Բ��Խ�������жϲ�д�뵽�����ļ���
		result=CheckTsaSuccessPage.verifyResult(applyTime, dataFinger, tvs);
		if(result==true) {
			System.out.println("i��ֵ��:"+i+"���Գɹ�����鿴���������ļ��Ƿ�д����Խ��");
			ExcelUtil.setCellData(i, 5, "���Գɹ�");
		}else {
			System.out.println("i��ֵ�ǣ�"+i+"����ʧ�ܣ���鿴���������ļ��Ƿ�д����Խ��");
			ExcelUtil.setCellData(i, 5, "����ʧ�ܣ����Ų�ԭ��");
		}
			 
		//���ص�tsaģ��
		tvs.getGoBackBtn("tsaplatform.tsaverifysuccess.backbtn").click();
	}
  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", "C:\\browser-drivers\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.get(Constant.url);
	  pdfModule=new PdfModule(driver);
	  tsaModule=new TsaModule(driver);
  }

  @AfterClass
  public void afterClass() {
	  //driver.close();
  }

}
