package practice;

import java.awt.datatransfer.DataFlavor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtility.ExcelUtility;

public class FetchingMultipleDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\QSP\\Desktop\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Insects");
//		System.out.println(sh.getLastRowNum());
		int lastRowNum = sh.getLastRowNum();
		DataFormatter df = new DataFormatter();
		for(int i=1;i<=lastRowNum;i++)
		{
			Row r = sh.getRow(i);
			int lastCellNum = r.getLastCellNum();
//			System.out.println(r.getLastCellNum());
			for(int j=0;j<lastCellNum;j++)
			{
				Cell c = r.getCell(j);
				String value = df.formatCellValue(c);
				System.out.print(value+" ");
			}
			System.out.println();
		}
		ExcelUtility eUtil = new ExcelUtility();
		ArrayList<String> allData = eUtil.getMultipleDataFromExcel("Insects", 1, 0);
		System.out.println(allData);
	}
}
