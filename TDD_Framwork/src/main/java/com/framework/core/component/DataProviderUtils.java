package com.framework.core.component;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.framework.core.helper.Configs;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderUtils
{
    @DataProvider(name="ExcelDataProvider")
    public static Object[][] getDataFromExcel(Method methodName) throws Exception {
        File excelWorkBook = new File(System.getProperty("user.dir")
                + Configs.testResourceFolder + "testData//testDataSheet.xlsx");


        Workbook wb=new XSSFWorkbook(excelWorkBook);
      //  Sheet sheet= wb.getSheet(System.getProperty("evnName"));
        Sheet sheet= wb.getSheet("STAGING");
        //String testName= methodName.toString();
        String testName= "loginScenario";
        int totalRows= sheet.getPhysicalNumberOfRows();
        int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();
        Row headingRow = sheet.getRow(0);
        List<List<String>> listsOfList = new ArrayList<List<String>>();

      //To fetch all the row
        for (int i = 1; i < totalRows; i++)
        {
            Row currentRow=sheet.getRow(i);
            String rowTestName=currentRow.getCell(0).getStringCellValue();
            int indexForColumns = getIndexForColumn(headingRow, "FetchValueFor");
            String FetchValuesFor = currentRow.getCell(indexForColumns).getStringCellValue();
            String [] arrOfColumns= FetchValuesFor.split(",");
            List<String> colList = new ArrayList<String>();
            // System.out.println("Index for FetchValueFor   " + indexForColumn);
            // String listOfColumn=currentRow.getCell(indexForColumns).getStringCellValue();
            //  System.out.println(FetchValuesFor);
            // System.out.println(rowTestName);
            //To fetch all the coloum
           /* for (int j=0;j<totalColumns; j++)
            {
                String colsForCurrentRow=currentRow.getCell(j).getStringCellValue();*/
               if(rowTestName.equalsIgnoreCase(testName))
               {
                   for(int k=0;k<arrOfColumns.length; k++)
                   {
                       int colIndex = getIndexForColumn(headingRow,arrOfColumns[k]);
                       //System.out.print(arrOfColumns[k]+ ": "+ currentRow.getCell(colIndex).getStringCellValue()+ " ");
                       colList.add(currentRow.getCell(colIndex).getStringCellValue());

                   }
                  // System.out.println(colList);
                   listsOfList.add(colList);
            }

        }

        //System.out.println(listsOfList);
        Object testSet[][] = new Object[listsOfList.size()][listsOfList.get(0).size()];

        for (int i = 0; i < listsOfList.size(); i++) {// rows
            List<String> testRow = listsOfList.get(i); // columns
            System.out.println(testRow);
            for (int j = 0; j < testRow.size(); j++) {
                testSet[i][j] = testRow.get(j);
            }
        }
        return testSet;
    }

    public static int getIndexForColumn(Row row, String columnName) {
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            if (row.getCell(i).getStringCellValue().equalsIgnoreCase(columnName)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        	//new DataProviderUtils().getDataFromExcel("loginScenario");
    }

}