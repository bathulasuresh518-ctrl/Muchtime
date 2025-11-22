package artifact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excell {
    public static void main(String[] args) {
        try {
            FileInputStream fil = new FileInputStream("C:\\Users\\Suresh Bathula\\Documents\\Zoom\\Demodata.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fil);
            int sheetCount = workbook.getNumberOfSheets();
            
            System.out.println("Number of sheets: " + sheetCount);
            
            // Loop through all sheets
            for (int i = 0; i < sheetCount; i++) {
                if (workbook.getSheetName(i).equalsIgnoreCase("Surya")) {
                    XSSFSheet sheet = workbook.getSheetAt(i);
                    
                    Iterator<Row> rowIterator = sheet.iterator();
                    
                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        Iterator<Cell> cellIterator = row.cellIterator();
                        
                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            
                            // Print cell content based on type
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
                        System.out.println(); // Move to next line after each row
                    }
                }
            }

            workbook.close();
            fil.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found or access denied: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        }
    }
}
