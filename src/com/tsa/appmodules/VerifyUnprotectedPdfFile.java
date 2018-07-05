package com.tsa.appmodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tsa.constant.Constant;
import com.tsa.pageobjects.PdfModule;
import com.tsa.pageobjects.PdfVerifyFailed;

public class VerifyUnprotectedPdfFile {
	public static PdfVerifyFailed execute(PdfModule pdfModule) throws Exception {
		pdfModule.getPdfUploadText("tsaplatform.pdfModule.uploadPdfText").sendKeys(Constant.unprotectedPdfFile);
		pdfModule.getPdfVerifyBtn("tsaplatform.pdfModule.verifyPdfBtn").click();
		return new PdfVerifyFailed(pdfModule.driver);
	}
}
