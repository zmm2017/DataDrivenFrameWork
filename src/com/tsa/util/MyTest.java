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
	  //hello world
	  Boolean result=null;
	  tsaModule.getTsaModuleBtn("tsaplatform.tsaModule.tsaModuleBtn").click();
	  TsaVerifyFailed tvf=VerifyUnprotectedTsaFile.execute("tsa.xls.pdf", "取证接口测试报告.docx.tsa", tsaModule);
	  result=CheckTsaFailedPage.verifyResult(tvf);
	  if(result==true) {
		  System.out.println("验证通过,flag的值是："+result);
	  }else {
		  System.out.println("验证没通过,flag的值是："+result);
	  }
	  tsaModule=CheckTsaFailedPage.goBack(tvf);
	  Assert.assertTrue(result);
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
