package com.tsa.appmodules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import com.tsa.pageobjects.PdfVerifyFailed;

public class RefreshPdfFailedPage {
	public static PdfVerifyFailed refreshByPressF5(PdfVerifyFailed pvf) throws AWTException {
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_F5);
		rb.keyRelease(KeyEvent.VK_F5);
		return new PdfVerifyFailed(pvf.driver);
	}
	
	public static PdfVerifyFailed refreshByClickBtn(PdfVerifyFailed pvf) {
		pvf.driver.navigate().refresh();
		return new PdfVerifyFailed(pvf.driver);
	}

}
