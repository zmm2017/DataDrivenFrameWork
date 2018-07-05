package com.tsa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tsa.constant.Constant;

public class ExcelUtil {
	private static XSSFWorkbook excelBook;
	private static XSSFSheet excelSheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	//�趨Ҫ������Excel���ļ�·����Excel�ļ��е�sheet����
	//�ڶ�/дExcel��ʱ�򣬾���Ҫ�ȵ��ô˷������趨Ҫ������Excel�ļ�·����Ҫ������sheet����
	public static  void setExcelFile(String filePath,String sheetName) throws FileNotFoundException {
		FileInputStream excelFile=new FileInputStream(filePath);
		try {
			excelBook=new XSSFWorkbook(excelFile);
			excelSheet=excelBook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//��ȡexcel�ļ�ָ����Ԫ��ĺ���
	public static String getCellData(int rowNum,int colNum) {
		//ͨ�����������ƶ���Ԫ����кź��кţ���ȡ�ƶ��ĵ�Ԫ�����
		cell=excelSheet.getRow(rowNum).getCell(colNum);
		
		/*
		 * ��ȡ��Ԫ�������
		 * �����Ԫ�������Ϊ�ַ������ͣ�����getStringCellValue������ȡ��Ԫ�������
		 * �����Ԫ�������Ϊ�������ͣ�����getNumericCellValue������ȡ��Ԫ�������
		 * ע�⣺getNumericCellValue�����ķ���ֵ��double���ͣ�ת���ַ�������ʱ������
		 * cell.getNumericCellValue()������ǰ���""������ǿ��ת��double���͵�String����
		 * ����""������׳�double�����޷�ת����String���͵��쳣
		 */
		String cellData=cell.getCellType()==XSSFCell.CELL_TYPE_STRING?
				cell.getStringCellValue()+"":
				String.valueOf(Math.round(cell.getNumericCellValue()));
		return cellData;
	}
	
	//��excel�ļ��ĵ�Ԫ����д������
	public static void setCellData(int rowNum,int colNum,String result) throws FileNotFoundException {
		//��ȡexcel�ļ��е��ж���
		row=excelSheet.getRow(rowNum);
		//��ȡ��Ԫ�����
		cell=row.getCell(colNum);
		
		if(cell==null) {
			//����Ԫ�������null��ʱ���򴴽���Ԫ��
			//�����Ԫ���ǿգ��޷�ֱ�ӵ��õ�Ԫ������setCellData�����趨��Ԫ���ֵ
			cell=row.createCell(colNum);
			cell.setCellValue(result);
		}else {
			cell.setCellValue(result);
		}
		
		//ʵ����д��excel�ļ����ļ����������
		FileOutputStream fos=new FileOutputStream(Constant.TestDataExcelFilePath);
		//������д��excel�ļ���
		try {
			excelBook.write(fos);
			//����flush()����ǿ����дд���ļ�
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//�ͷ���Դ
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
