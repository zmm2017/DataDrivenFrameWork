package com.tsa.appmodules;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tsa.constant.Constant;
import com.tsa.pageobjects.PdfModule;
import com.tsa.pageobjects.PdfVerifySuccess;

public class CheckPdfSuccessPage {
	
	public static Boolean execute(PdfVerifySuccess pdfSuccess,String time,String idInfo) throws Exception {
		Boolean flag = null;
		WebElement resultMessage=pdfSuccess.getResultMessage("tsaplatform.pdfverifysuccess.resultmessage");
		WebElement authorityOrg=pdfSuccess.getAuthorityOrg("tsaplatform.pdfverifysuccess.authorityorg");
		WebElement applyTime=pdfSuccess.getApplyTime("tsaplatform.pdfverifysuccess.applytime");
		WebElement identityInfo=pdfSuccess.getIdentityInfo("tsaplatform.pdfverifysuccess.identityinfo");
		if(pdfSuccess.driver.getPageSource().contains("该电子合同已通过验证") &&
			authorityOrg.getText().equals(Constant.authorityOrg) &&
			applyTime.getText().equals(time) &&
			identityInfo.getText().equals(idInfo)) {
			flag=true;
		}else {
			flag=false;
		}	
		
		return flag;
	}
	
	public static PdfModule goBack(PdfVerifySuccess pdfSuccess) throws Exception {
		WebElement backBtn=pdfSuccess.getBackBtn("tsaplatform.pdfverifysuccess.backbtn");
		Robot rb=new Robot();
		for(int i=1;i<=5;i++) {
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}
		
		Thread.sleep(1000);
		
		backBtn.click();
		return new PdfModule(pdfSuccess.driver);
	}

}
