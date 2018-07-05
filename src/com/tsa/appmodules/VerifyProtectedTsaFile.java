package com.tsa.appmodules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.tsa.keyboardutil.KeyBoardUtil;
import com.tsa.pageobjects.TsaModule;
import com.tsa.pageobjects.TsaVerifySuccess;
import com.tsa.util.DragScrollBar;
import com.tsa.util.LocateDefinitePath;

public class VerifyProtectedTsaFile {
	public static TsaVerifySuccess execute(String sourceFile,String tsaFile,TsaModule tsaModule) throws Exception {
		DragScrollBar.execute();
		
		tsaModule.getSourceFileBtn("tsaplatform.tsaModule.sourceFileBtn").click();
		LocateDefinitePath.execute();
		KeyBoardUtil.setAndctrlVClipboardData(sourceFile);
		KeyBoardUtil.pressEnterKey();
		Thread.sleep(2000);
		
		tsaModule.getTsaFileBtn("tsaplatform.tsaModule.tsaFileBtn").click();
		KeyBoardUtil.setAndctrlVClipboardData(tsaFile);
		KeyBoardUtil.pressEnterKey();
		Thread.sleep(2000);
		
		tsaModule.getTsaVerifyBtn("tsaplatform.tsaModule.tsaVerifyBtn").click();
		
		return new TsaVerifySuccess(tsaModule.driver);
	}

}
