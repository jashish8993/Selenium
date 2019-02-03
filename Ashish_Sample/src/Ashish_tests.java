import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

//import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import ashish_sourcefile;
public class Ashish_tests extends ashish_sourcefile  {
	public static String file="C:\\Users\\ashish\\Desktop\\Selenium\\My Framework\\ashish.xls";
	HSSFCell Data1;
	static FileInputStream files=null;
	static HSSFWorkbook wb=null;
	static HSSFSheet ws=null;
	static int rowCount;
	public static int sheetcount;
	public static int colCount;

	public static void Ashish_testss() throws IOException,NullPointerException
	{
		files=new FileInputStream(file);
		wb=new HSSFWorkbook(files);
		sheetcount=wb.getNumberOfSheets();
	}
	public static String[][] readData(int index) throws IOException,NullPointerException	 {	
		Ashish_testss();
		ws=wb.getSheetAt(index);
		rowCount=ws.getLastRowNum();
		//System.out.println(rowCount);
		colCount=ws.getRow(0).getLastCellNum();
		//System.out.println(colCount);
		String[][] Data=new String[rowCount+1][colCount];
		for(int i=1;i<=rowCount;i++)
		{
			HSSFRow row = ws.getRow(i);
			for(int j=0;j<colCount;j++)
			{
			
				if(row==null){
					Data[i][j] = "";
				}
				else {
					HSSFCell Data1=row.getCell(j);
					if(Data1==null)
						Data[i][j] = "";
					else 
					{
						String value=cellToString(Data1);
						if(value==null)
							return null;
						Data[i][j]=value;
						if(Data[i][j]==null)
							return null;
						//System.out.println(Data[i][j]);

					}
				}
			}
		}	
		return Data;
	}


	public static String cellToString(HSSFCell cell)
	{
		CellType type;
		Object result;
		if(cell==null)
			return null;
		type = cell.getCellTypeEnum();	
		//System.out.println(type);

		switch (type){
		case NUMERIC :
			if (DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				result = dateFormat.format(cell.getDateCellValue());
			} else {
				Double value = cell.getNumericCellValue();
				Long longValue = value.longValue();
				result = new String(longValue.toString());
			}
			break;
		case STRING : 
			result = cell.getStringCellValue();
			break;
		case BOOLEAN:
			result=cell.getBooleanCellValue();
			break;
		case BLANK:
			result=cell.getColumnIndex();
			//System.out.println(result);
			break;
		case FORMULA:
			result=cell.getCellFormula();
			break;
		default :
			//System.out.println(cell.getCellStyle());
			throw new RuntimeException("Unsupportd cell.");			
		}

		return result.toString();
	}
}
