package commonlibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileData 
{

	public String fetchDataFromPropertiesFile(String enterkey) throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/GlobalVariables.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(enterkey);
		return value;
	}
	
	public String fetchDataFromExcelFile(String sheetName,int row,int col) throws Exception
	{
		FileInputStream file = new FileInputStream("./src/test/resources/TestData.xls");
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetName);
		Row r= sheet.getRow(row);
		Cell cell = r.getCell(col);
		String value = cell.getStringCellValue();
		return value;
	}
}
