package com.tsa.appmodules;

import com.tsa.constant.Constant;
import com.tsa.pageobjects.PdfModule;
import com.tsa.pageobjects.PdfVerifySuccess;

public class VerifyProtectedPdfFile {
	public static PdfVerifySuccess execute(PdfModule pdfModule) throws Exception {
		pdfModule.getPdfUploadText("tsaplatform.pdfModule.uploadPdfInput").sendKeys(Constant.multipleSignFile);
		pdfModule.getPdfVerifyBtn("tsaplatform.pdfModule.verifyPdfBtn").click();
		return new PdfVerifySuccess(pdfModule.driver);
	}
}
