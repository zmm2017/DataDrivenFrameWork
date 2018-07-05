package com.tsa.appmodules;

import com.tsa.pageobjects.TsaModule;
import com.tsa.pageobjects.TsaVerifySuccess;
import com.tsa.util.DragScrollBar;

public class CheckTsaSuccessPage {
	public static Boolean verifyResult(String applyTime,String dataFingerPrint,TsaVerifySuccess tvs) throws Exception {
		Boolean flag=null;
		String actualApplyTime=tvs.getApplyTime("tsaplatform.tsaverifysuccess.applytime").getText();
		String actualDataFingerPrint=tvs.getDataFingerPrint("tsaplatform.tsaverifysuccess.datafingerprint").getText();
		if(tvs.driver.getPageSource().contains("���ļ���ͨ����֤")&&
				tvs.driver.getPageSource().contains("��ƾ֤������ʱ���ʱ�����ݱ���������δ������")&&
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
