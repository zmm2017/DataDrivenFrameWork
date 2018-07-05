package com.tsa.appmodules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.tsa.pageobjects.PdfVerifySuccess;

public class RefreshPdfSuccessPage {
	public static PdfVerifySuccess refreshByPressF5(PdfVerifySuccess pvs) throws AWTException {
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_F5);
		rb.keyRelease(KeyEvent.VK_F5);
		return new PdfVerifySuccess(pvs.driver);
	}
	
	public static PdfVerifySuccess refreshByClickBtn(PdfVerifySuccess pvs) {
		pvs.driver.navigate().refresh();
		return new PdfVerifySuccess(pvs.driver);
	}

}
