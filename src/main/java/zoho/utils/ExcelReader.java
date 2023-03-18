package zoho.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class ExcelReader {
	private String excelPath = null;
	private Workbook book = null;

	public ExcelReader(String dataFilePath) throws Exception {
		this.excelPath = dataFilePath;
		this.book = new XSSFWorkbook(new File(this.excelPath));
	}

	public String[][] getData(String sheetName) {
		Sheet sheet = this.book.getSheet(sheetName);
		int total_rows = sheet.getLastRowNum()+1;
		if (total_rows == -1)
			return null;
		int total_columns = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[total_rows][total_columns];

		int i = 0;
		int j = 0;

		for (Row row : sheet) {
				for (Cell cell : row) {
					data[i][j] = cell.getStringCellValue();
					j++;
				}
				i++;
				j=0;
		}

		return data;
	}

}
