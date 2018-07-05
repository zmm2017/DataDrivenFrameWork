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
	
	//设定要操作的Excel的文件路径和Excel文件中的sheet名称
	//在读/写Excel的时候，均需要先调用此方法，设定要操作的Excel文件路径和要操作的sheet名称
	public static  void setExcelFile(String filePath,String sheetName) throws FileNotFoundException {
		FileInputStream excelFile=new FileInputStream(filePath);
		try {
			excelBook=new XSSFWorkbook(excelFile);
			excelSheet=excelBook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//读取excel文件指定单元格的函数
	public static String getCellData(int rowNum,int colNum) {
		//通过函数参数制定单元格的行号和列号，获取制定的单元格对象
		cell=excelSheet.getRow(rowNum).getCell(colNum);
		
		/*
		 * 获取单元格的内容
		 * 如果单元格的内容为字符串类型，则用getStringCellValue方法获取单元格的内容
		 * 如果单元格的内容为数字类型，则用getNumericCellValue方法获取单元格的内容
		 * 注意：getNumericCellValue方法的返回值是double类型，转换字符串类型时必须在
		 * cell.getNumericCellValue()方法的前面加""，用于强制转换double类型到String类型
		 * 不加""，则会抛出double类型无法转换到String类型的异常
		 */
		String cellData=cell.getCellType()==XSSFCell.CELL_TYPE_STRING?
				cell.getStringCellValue()+"":
				String.valueOf(Math.round(cell.getNumericCellValue()));
		return cellData;
	}
	
	//在excel文件的单元格中写入数据
	public static void setCellData(int rowNum,int colNum,String result) throws FileNotFoundException {
		//获取excel文件中的行对象
		row=excelSheet.getRow(rowNum);
		//获取单元格对象
		cell=row.getCell(colNum);
		
		if(cell==null) {
			//当单元格对象是null的时候，则创建单元格
			//如果单元格是空，无法直接调用单元格对象的setCellData方法设定单元格的值
			cell=row.createCell(colNum);
			cell.setCellValue(result);
		}else {
			cell.setCellValue(result);
		}
		
		//实例化写入excel文件的文件输出流对象
		FileOutputStream fos=new FileOutputStream(Constant.TestDataExcelFilePath);
		//将内容写入excel文件中
		try {
			excelBook.write(fos);
			//调用flush()方法强制书写写入文件
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//释放资源
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
