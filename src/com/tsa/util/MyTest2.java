package com.tsa.util;

import java.io.FileNotFoundException;

import com.tsa.constant.Constant;

public class MyTest2 {

	public static void main(String[] args) throws FileNotFoundException {
		ExcelUtil.setExcelFile(Constant.TestDataExcelFilePath, "��������");
		String applyTime=ExcelUtil.getCellData(1, 1);
		String idInfo=ExcelUtil.getCellData(1, 2);
		System.out.println("����ʱ���ǣ�"+applyTime);
		System.out.println("�����Ϣ�ǣ�"+idInfo);
	}

}
