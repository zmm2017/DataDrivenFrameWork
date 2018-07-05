package com.tsa.util;

import org.testng.annotations.Test;

import com.tsa.appmodules.CheckPdfSuccessPage;
import com.tsa.appmodules.RefreshPdfModulePage;
import com.tsa.appmodules.VerifyProtectedPdfFile;
import com.tsa.constant.Constant;
import com.tsa.keyboardutil.KeyBoardUtil;
import com.tsa.pageobjects.PdfModule;
import com.tsa.pageobjects.PdfVerifySuccess;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestPdfModuleByChrome {
	public WebDriver driver;
	public static PdfModule pm;
	
  /*@Test
  //电子合同/单证（PDF）验证各输入字段的有效性检验, case id:347
  public void test_case_id347() throws Exception {
	  pm.getPdfVerifyBtn("tsaplatform.pdfModule.verifyPdfBtn").click();
	  Alert alert=pm.driver.switchTo().alert();
	  Assert.assertEquals(alert.getText(), "请上传pdf格式文件");
	  alert.accept();
  }*/
  
  /*@Test
  //打开并上传电子合同文件,case id: 348（第1部分，通过点击文本框上传文件）
  public void test_case_id348_1() throws Exception {
	  //通过点击文本框上传文件
	  pm.getPdfUploadInput("tsaplatform.pdfModule.uploadPdfText").click();
	  KeyBoardUtil.setAndctrlVClipboardData("网页取证V1.0（修订版）8-3-多方签署.pdf");
	  KeyBoardUtil.pressEnterKey();
	  String str1=pm.getPdfUploadText("tsaplatform.pdfModule.uploadPdfText").getText();
	  String str2=pm.getPdfUploadText("tsaplatform.pdfModule.uploadPdfText").getAttribute("value");
	  Assert.assertTrue(str2.contains("网页取证V1.0（修订版）8-3-多方签署.pdf"));
  }*/
  
  /*@Test
  //打开并上传电子合同文件,case id: 348（第2部分，通过点击按钮上传文件）
  public void test_case_id348_2() throws Exception {
	  //点击按钮上传文件
	  //RefreshPdfModulePage.refreshByPressF5(pm);
	  pm.getPdfUploadBtn("tsaplatform.pdfModule.uploadPdfBtn").click();
	  KeyBoardUtil.setAndctrlVClipboardData("tsa.xls.pdf");
	  KeyBoardUtil.pressEnterKey();
	  pm.getPdfUploadText("tsaplatform.pdfModule.uploadPdfText").getText();
	  Thread.sleep(1000);
	  Assert.assertTrue(pm.getPdfUploadText("tsaplatform.pdfModule.uploadPdfText").getAttribute("value").contains("tsa.xls.pdf"));
  }*/
  
  @Test
  //验证一个已保护的电子合同文件,case id:349
  public void test_case_id349() throws Exception {
	  RefreshPdfModulePage.refreshByPressF5(pm);
	  PdfVerifySuccess pvs=VerifyProtectedPdfFile.execute(pm);
	  ExcelUtil.setExcelFile(Constant.TestDataExcelFilePath, "测试数据");
	  Boolean result=CheckPdfSuccessPage.execute(pvs,ExcelUtil.getCellData(1, 1), ExcelUtil.getCellData(1, 2));
	  Assert.assertTrue(result);
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "C:\\browser-drivers\\chromedriver.exe");
	  this.driver=new ChromeDriver();
	  this.driver.get(Constant.url);
	  pm=new PdfModule(this.driver);
  }

  @AfterClass
  public void afterClass() {
	  //this.driver.close();
  }

}
