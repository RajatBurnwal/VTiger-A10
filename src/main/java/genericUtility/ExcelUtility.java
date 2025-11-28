package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This is an utility class which deals with Excel file
 * @author QSP
 * @version 25-10-29
 */
public class ExcelUtility {

	/**
	 * This is a generic method to fetch single cell data from Excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getSingleCellDataFromExcel(String sheetName, int rowIndex, 
			int cellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell c = wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex);
		DataFormatter df = new DataFormatter();
		String value = df.formatCellValue(c);
		return value;
	}
	
	/**
	 * This is a generic method to fetch multiple data from Excel file
	 * @param sheetName
	 * @param startRowIndex
	 * @param startCellIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public ArrayList<String> getMultipleDataFromExcel(String sheetName,
			int startRowIndex,int startCellIndex)
					throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRowNum = sh.getLastRowNum();
		DataFormatter df = new DataFormatter();
		ArrayList<String> a1 = new ArrayList<String>();
		for(int i=startRowIndex;i<=lastRowNum;i++)
		{
			Row r = sh.getRow(i);
			int lastCellNum = r.getLastCellNum();
			for(int j=startCellIndex;j<lastCellNum;j++)
			{
				Cell c = r.getCell(j);
				String value = df.formatCellValue(c);
				a1.add(value);
			}
		}
		return a1;
	}
	
	/**
	 * This is a generic method to write data to Excel file
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @param cellValue
	 * @throws IOException
	 */
	public void writeDataToExcel(String sheetName, int rowIndex,
			int cellIndex, String cellValue) throws IOException
	{
		FileInputStream fis = new FileInputStream(IPathUtility.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell c = wb.getSheet(sheetName).createRow(rowIndex).createCell(cellIndex);
		c.setCellValue(cellValue);
		FileOutputStream fos = new FileOutputStream(IPathUtility.excelPath);
		wb.write(fos);
	}
}
