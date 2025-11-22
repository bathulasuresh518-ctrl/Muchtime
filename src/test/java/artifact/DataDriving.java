package artifact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriving {

	public static void main(String[] args) throws IOException {
		FileInputStream fil=new FileInputStream("C:\\Users\\Suresh Bathula\\Documents\\Zoom\\Demodata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fil);
		int a=workbook.getNumberOfSheets();
		for(int i=0;i<a;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("Surya")) {
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row>rows=sheet.rowIterator();
				while(rows.hasNext()) {
					Row row=rows.next();
					Iterator<Cell>cells=row.cellIterator();
					while(cells.hasNext())
					{
						Cell cell=cells.next();
						switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("Unknown\t");
                            break;
                    }
					}
					System.out.println();
				}
			}
		}
		

	}

}
