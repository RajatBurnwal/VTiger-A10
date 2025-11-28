package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataToExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\QSP\\Desktop\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell c = wb.createSheet("Trees").createRow(5).createCell(5);
		c.setCellValue("Banyan Tree");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\QSP\\Desktop\\TestData.xlsx");
		wb.write(fos);
	}

}
