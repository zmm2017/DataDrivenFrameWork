package com.tsa.appmodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tsa.pageobjects.PdfModule;
import com.tsa.pageobjects.PdfVerifyFailed;

public class CheckPdfFailedPage {
	static Boolean flag=null;
	public static Boolean execute(PdfVerifyFailed pvf) throws Exception {
		WebElement resultMessage=pvf.getResultMessage("tsaplatform.pdfverifyfailed.resultmessage");
		if(resultMessage.getText().contains("电子合同未通过验证，可能存在真实性风险！")) {
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}
	public static PdfModule goBack(PdfVerifyFailed pvf) throws Exception {
		WebElement backBtn=pvf.getBackBtn("tsaplatform.pdfverifyfailed.backbtn");
		backBtn.click();
		return new PdfModule(pvf.driver);
	}
	
}
