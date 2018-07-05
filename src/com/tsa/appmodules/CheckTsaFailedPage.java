package com.tsa.appmodules;

import java.awt.AWTException;

import com.tsa.pageobjects.TsaModule;
import com.tsa.pageobjects.TsaVerifyFailed;
import com.tsa.pageobjects.TsaVerifySuccess;
import com.tsa.util.DragScrollBar;

public class CheckTsaFailedPage {
	public static Boolean verifyResult(TsaVerifyFailed tvf) {
		Boolean flag=null;
		if(tvf.driver.getPageSource().contains("���ļ�δͨ����֤�����ܴ�����ʵ�Է��գ�")&&
				tvf.driver.getPageSource().contains("������ʾ����ԭ�ļ���ʱ����ļ���ƥ��")) {
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
