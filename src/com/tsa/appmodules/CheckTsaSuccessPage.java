package com.tsa.appmodules;

import com.tsa.pageobjects.TsaModule;
import com.tsa.pageobjects.TsaVerifySuccess;
import com.tsa.util.DragScrollBar;

public class CheckTsaSuccessPage {
	public static Boolean verifyResult(String applyTime,String dataFingerPrint,TsaVerifySuccess tvs) throws Exception {
		Boolean flag=null;
		String actualApplyTime=tvs.getApplyTime("tsaplatform.tsaverifysuccess.applytime").getText();
		String actualDataFingerPrint=tvs.getDataFingerPrint("tsaplatform.tsaverifysuccess.datafingerprint").getText();
		if(tvs.driver.getPageSource().contains("该文件已通过验证")&&
				tvs.driver.getPageSource().contains("该凭证自申请时间戳时起，内容保持完整、未被更改")&&
				actualApplyTime.equals(applyTime)&&
				actualDataFingerPrint.equals(dataFingerPrint)) {
			flag=true;
		}else {
			flag=false;
		}
		return flag;
	}
	
	public static TsaModule goBack(TsaVerifySuccess tvs) throws Exception {
		DragScrollBar.execute();
		tvs.getGoBackBtn("tsaplatform.tsaverifysuccess.backbtn").click();
		return new TsaModule(tvs.driver);
	}


}
