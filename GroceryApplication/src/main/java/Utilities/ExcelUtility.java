package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
	
	
	public static String getStringData(int a, int b) throws IOException{
		f = new FileInputStream("");
		w = new XSSFWorkbook(f);
		sh = w.getSheet("Sheet1");
		Row r = sh.getRow(a);
		Cell c = r.getCell(b);
		return c.getStringCellValue();
	}
	
	public static String getStringData(int a, int b, String sheet) throws IOException{
		f = new FileInputStream("");
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		Row r = sh.getRow(a);
		Cell c = r.getCell(b);
		return c.getStringCellValue();
	}
	
	public static String getIntegerData(int a, int b) throws IOException{
		f = new FileInputStream("");
		w = new XSSFWorkbook(f);
		sh = w.getSheet("Sheet1");
		Row r = sh.getRow(a);
		Cell c = r.getCell(b);
		
		return c.getStringCellValue();
	}
}
