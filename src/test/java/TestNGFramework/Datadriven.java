package TestNGFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datadriven {
//	@DataProvider(name="sending")
//	public static Object[][] prodider() throws Throwable {
//		FileInputStream fis =new FileInputStream("C:\\Users\\Suresh Bathula\\Documents\\DataDriven");
//		XSSFWorkbook wb=new XSSFWorkbook(fis);
//		XSSFSheet sheet=wb.getSheet("Surya");
//		int row=sheet.getPhysicalNumberOfRows();
//		int colomn=sheet.getRow(0).getPhysicalNumberOfCells();
//		
//		
//		return ;
//		
//	}
	@Test
	public void Taking() throws IOException {
		FileInputStream fis =new FileInputStream("C:\\Users\\Suresh Bathula\\Desktop\\productiondata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("ProdData");
		int row=sheet.getPhysicalNumberOfRows();
		int colomn=sheet.getRow(0).getPhysicalNumberOfCells();
		for(int i=1;i<row;i++) {
			for(int j=0;j<colomn;j++) {
				System.out.print(sheet.getRow(i).getCell(j).toString()+"  ");
			}
			System.out.println();
		}
		
	}

}
