package com.tsa.appmodules;

import com.tsa.keyboardutil.KeyBoardUtil;
import com.tsa.pageobjects.TsaModule;
import com.tsa.pageobjects.TsaVerifyFailed;
import com.tsa.util.DragScrollBar;
import com.tsa.util.LocateDefinitePath;

public class VerifyUnprotectedTsaFile {
	public static TsaVerifyFailed execute(String sourceFile,String tsaFile,TsaModule tsaModule) throws Exception {
		DragScrollBar.execute();
		
		tsaModule.getSourceFileBtn("tsaplatform.tsaModule.sourceFileBtn").click();
		LocateDefinitePath.execute();
		KeyBoardUtil.setAndctrlVClipboardData(sourceFile);
		KeyBoardUtil.pressEnterKey();
		Thread.sleep(2000);
		
		tsaModule.getTsaFileBtn("tsaplatform.tsaModule.tsaFileBtn").click();
		KeyBoardUtil.setAndctrlVClipboardData(tsaFile);
		KeyBoardUtil.pressEnterKey();
		
		tsaModule.getTsaVerifyBtn("tsaplatform.tsaModule.tsaVerifyBtn").click();
		
		return new TsaVerifyFailed(tsaModule.driver);
	}

}
