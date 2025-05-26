package SheetAdmin;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class admin_DEL {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    public static int rowNumber, colNumber ;
    //Object
    public  static Object[][] ExcelData() {
        Object[][] x = new Object[0][];
        try {
            DataFormatter formatter = new DataFormatter();
            workbook = new XSSFWorkbook("resources/Admin.xlsx");  //Excel workbook Path
            sheet = workbook.getSheet("Delete");  //sheet name
            rowNumber = sheet.getPhysicalNumberOfRows();   //no of rows
            colNumber = sheet.getRow(0).getPhysicalNumberOfCells(); //no of columns
            x = new Object[rowNumber - 1][colNumber];  //declare matrix size
            for (int i = 1; i < rowNumber; i++) {  //start from 1 because first row has column names
                for(int j = 0; j < colNumber; j++){
                    Cell cell=sheet.getRow(i).getCell(j);
                    String temp= formatter.formatCellValue(cell);
                    x[i-1][j]=temp;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return x;
    }
}
