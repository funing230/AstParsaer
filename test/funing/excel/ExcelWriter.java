package funing.excel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



public class ExcelWriter {


    public ArrayList<Integer> get_bugid() throws EncryptedDocumentException, InvalidFormatException, IOException{
        // Create a Workbook
        //Workbook workbook_write = new XSSFWorkbook();     // new HSSFWorkbook() for generating `.xls` file
        // Creating a Workbook from an Excel file (.xls or .xlsx)
        String SAMPLE_XLSX_FILE_PATH = "./Eclipse_Platform_UI.xlsx";
        Workbook workbook_read = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        // Retrieving the number of sheets in the Workbook
        System.out.println("Workbook has " + workbook_read.getNumberOfSheets() + " Sheets : ");

        /*
           =============================================================
           Iterating over all the sheets in the workbook (Multiple ways)
           =============================================================
        */

        // Getting the Sheet at index zero
        Sheet sheet = workbook_read.getSheetAt(0);

        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 2. Or you can use a for-each loop to iterate over the rows and columns
        ArrayList<Integer> bug_id=new ArrayList();
        
        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Row row: sheet) {
        	if(row.getRowNum()!=0) {
                for(Cell cell: row) {
                	if(cell.getColumnIndex()==1) {
                		bug_id.add(new Double(cell.getNumericCellValue()).intValue());
                        String cellValue = dataFormatter.formatCellValue(cell);
                        //System.out.print(cellValue + "\t");            		
                	}
                }        		
        	}

           // System.out.println();
        }
        workbook_read.close();        
    	
		return bug_id;
    	
    }

    public void Write_Serverity(ArrayList<Integer> bug_id) throws IOException {
    	String[] columns = {"serverity"};
    	Workbook workbook_write = new XSSFWorkbook();

        /* CreationHelper helps us create instances for various things like DataFormat,
           Hyperlink, RichTextString etc in a format (HSSF, XSSF) independent way */
    	
    	
        CreationHelper createHelper = workbook_write.getCreationHelper();

        // Create a Sheet
        Sheet sheet_in = workbook_write.createSheet("serverity");

        // Create a Font for styling header cells
        Font headerFont = workbook_write.createFont();

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook_write.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet_in.createRow(0);

        // Creating cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        
        // Cell Style for formatting Date
        CellStyle dateCellStyle = workbook_write.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        // Create Other rows and cells with employees data
        int rowNum=1;
        for(int bugid: bug_id) {
        	
            Row row = sheet_in.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(bugid);

        }
      
        // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet_in.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("serverity.xlsx");
        workbook_write.write(fileOut);
        fileOut.close();

        workbook_write.close();
    }
    
    public void Write_Serverity_s(ArrayList<String> severity_list) throws IOException {
    	String[] columns = {"serverity"};
    	Workbook workbook_write = new XSSFWorkbook();

        /* CreationHelper helps us create instances for various things like DataFormat,
           Hyperlink, RichTextString etc in a format (HSSF, XSSF) independent way */
    	
    	
        CreationHelper createHelper = workbook_write.getCreationHelper();

        // Create a Sheet
        Sheet sheet_in = workbook_write.createSheet("serverity");

        // Create a Font for styling header cells
        Font headerFont = workbook_write.createFont();

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook_write.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet_in.createRow(0);

        // Creating cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        
        // Cell Style for formatting Date
        CellStyle dateCellStyle = workbook_write.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        // Create Other rows and cells with employees data
        int rowNum=1;
        for(String severity: severity_list) {
        	
            Row row = sheet_in.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(severity);

        }
      
        // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet_in.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("serverity.xlsx");
        workbook_write.write(fileOut);
        fileOut.close();

        workbook_write.close();
    }
    public void Write_Serverity_id_s(ArrayList<bug_id_s> bug_id_list) throws IOException {
    	String[] columns = {"bug_id","serverity"};
    	Workbook workbook_write = new XSSFWorkbook();

        /* CreationHelper helps us create instances for various things like DataFormat,
           Hyperlink, RichTextString etc in a format (HSSF, XSSF) independent way */
    	
    	
        CreationHelper createHelper = workbook_write.getCreationHelper();

        // Create a Sheet
        Sheet sheet_in = workbook_write.createSheet("serverity");

        // Create a Font for styling header cells
        Font headerFont = workbook_write.createFont();

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook_write.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet_in.createRow(0);

        // Creating cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        
        // Cell Style for formatting Date
        CellStyle dateCellStyle = workbook_write.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        // Create Other rows and cells with employees data
        int rowNum=1;
        for(bug_id_s bugids: bug_id_list) {
        	
            Row row = sheet_in.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(bugids.getBug_id());
            row.createCell(1)
            .setCellValue(bugids.getServerity());

        }
      
        // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet_in.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("serverity.xlsx");
        workbook_write.write(fileOut);
        fileOut.close();

        workbook_write.close();
    }
}

