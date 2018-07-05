package com.tsa.appmodules;

import java.awt.AWTException;

import com.tsa.pageobjects.TsaModule;
import com.tsa.pageobjects.TsaVerifyFailed;
import com.tsa.pageobjects.TsaVerifySuccess;
import com.tsa.util.DragScrollBar;

public class CheckTsaFailedPage {
	public static Boolean verifyResult(TsaVerifyFailed tvf) {
		Boolean flag=null;
		if(tvf.driver.getPageSource().contains("该文件未通过验证，可能存在真实性风险！")&&
				tvf.driver.getPageSource().contains("错误提示：该原文件与时间戳文件不匹配")) {
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}
	
	public static TsaModule goBack(TsaVerifyFailed tvf) throws Exception {
		DragScrollBar.execute();
		tvf.getGoBackBtn("tsaplatform.tsaverifyfailed.backbtn").click();
		return new TsaModule(tvf.driver);
	}

}
