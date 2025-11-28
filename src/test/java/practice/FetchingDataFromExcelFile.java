package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtility.ExcelUtility;

public class FetchingDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

//		FileInputStream fis = new FileInputStream("C:\\Users\\QSP\\Desktop\\TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("Animals");
//		Row r = sh.getRow(4);
//		Cell c = r.getCell(2);
////		String value = c.getStringCellValue();
//		DataFormatter df = new DataFormatter();
//		String value = df.formatCellValue(c);
		ExcelUtility eUtil = new ExcelUtility();
		String value = eUtil.getSingleCellDataFromExcel("Animals", 0, 0);
		String value1 = eUtil.getSingleCellDataFromExcel("Fish", 2, 2);
		System.out.println(value);
		System.out.println(value1);
	}

}
