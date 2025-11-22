package artifact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) throws IOException, OpenXML4JException {
		FileInputStream fil=new FileInputStream("C:\\Users\\Suresh Bathula\\Documents\\Zoom\\Demodata.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fil);
	   XSSFSheet Sheet=workbook.getSheet("Surya");
	   Iterator<Row> rowiterator=Sheet.iterator();
	   while(rowiterator.hasNext()) {
		   Row row=rowiterator.next();
		   Iterator<Cell>cells=row.cellIterator();
		   while(cells.hasNext()) {
			   Cell cell=cells.next();
					   switch(cell.getCellType()){
					   case STRING:
						   System.out.println(cell.getStringCellValue()+ "\t");
						   break;
					   case NUMERIC:
						   System.out.println(cell.getStringCellValue()+ "\t");
						   break;
					   case BOOLEAN:
						   System.out.println(cell.getStringCellValue()+ "\t");
						   break;
						 default:
							 System.out.println(" cncn\t");
							 break;
							 
						 
				   
			   }
					   
		   }
		   System.out.println(" ");
	   }
		
		
		
		
		
		
//		XSSFWorkbook workbook=new XSSFWorkbook(fil);
//		int a=workbook.getNumberOfSheets();
//		System.out.println(a);
//		for(int i=0;i<a;i++) {
//			if(workbook.getSheetName(i).equalsIgnoreCase("Surya")) {
//				XSSFSheet sheet=workbook.getSheetAt(i);
//				Iterator<Row> rowIterator= sheet.iterator();
//				while(rowIterator.hasNext()) {
//					Row row=rowIterator.next();
//					Iterator<Cell> cells=row.cellIterator();
//					while(cells.hasNext()) {
//						Cell cell=cells.next();
//						switch (cell.getCellType()) {
//                        case STRING:
//                            System.out.print(cell.getStringCellValue() + "\t");
//                            break;
//                        case NUMERIC:
//                            System.out.print(cell.getNumericCellValue() + "\t");
//                            break;
//                        case BOOLEAN:
//                            System.out.print(cell.getBooleanCellValue() + "\t");
//                            break;
//                        default:
//                            System.out.print("Unknown\t");
//                            break;
//                    }
//						
//					}
//					System.out.println("  ");
//				}
//			}
//		}
	}

}
