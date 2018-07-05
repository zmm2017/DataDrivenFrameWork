package com.tsa.util;

import java.io.FileNotFoundException;

import com.tsa.constant.Constant;

public class MyTest2 {

	public static void main(String[] args) throws FileNotFoundException {
		ExcelUtil.setExcelFile(Constant.TestDataExcelFilePath, "测试数据");
		String applyTime=ExcelUtil.getCellData(1, 1);
		String idInfo=ExcelUtil.getCellData(1, 2);
		System.out.println("申请时间是："+applyTime);
		System.out.println("身份信息是："+idInfo);
	}

}
