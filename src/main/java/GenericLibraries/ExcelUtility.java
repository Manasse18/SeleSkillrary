package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{

	private Workbook wb;
	public void excel_Intilization(String excelpath) {
		FileInputStream fis=null;
		try {
			fis= new FileInputStream(excelpath);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try {
			wb=WorkbookFactory.create(fis);
		}
		catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		
	}
	public String fetchDatafromExcel(String sheetName, int rowNum,int cellNum)
	{
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
	
	public List<String> fetchDataFromExcel(String sheetName)
	{
		List<String> datalist=new ArrayList<>();
		Sheet sheet=wb.getSheet(sheetName);
		for(int i=0;i<4;i++)
		{
			String data= sheet.getRow(i).getCell(1).getStringCellValue();
			datalist.add(data);
		}
		return datalist;
	}
	public void closeExcel()
	{
		try
		{
			wb.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}


}
