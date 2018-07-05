package com.tsa.appmodules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.tsa.pageobjects.PdfModule;

public class RefreshPdfVerifyResultPage {
	public static PdfModule refreshByPressF5(PdfModule pm) throws AWTException {
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_F5);
		rb.keyRelease(KeyEvent.VK_F5);
		return new PdfModule(pm.driver);
	}
	
	public static PdfModule refreshByClickBtn(PdfModule pm) {
		pm.driver.navigate().refresh();
		return new PdfModule(pm.driver);
	}

}
