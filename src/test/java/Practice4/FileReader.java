package Practice4;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReader {
    public static String configReader(String key){
        Properties properties=new Properties();
        try{
            FileInputStream files=new FileInputStream("src/test/resources/Config.properties");
            properties.load(files);
        }catch (Exception e){
            throw new RuntimeException("Unable to read the properies files"+e.getMessage());
        }
        return properties.getProperty(key);
    }
    public static String jsonReader(String key) throws IOException, ParseException {
        JSONParser parser=new JSONParser();
        JSONObject json=(JSONObject) parser.parse(new java.io.FileReader("src/test/resources/testdata/setData1.json"));
        return json.get(key).toString();
    }
    public static String ExcelReader(){
        String value;
        try {
            FileInputStream files=new FileInputStream("src/test/resources/ExcelData.xlsx");
            Workbook wb=new XSSFWorkbook(files);
            Sheet sheet=wb.getSheet("Sheet1");
            Row row=sheet.getRow(1);
            Cell cell=row.getCell(0);
            value=cell.toString();
            files.close();
            wb.close();
        }catch (Exception e){
            throw new RuntimeException("Unable to Read the Excel file data"+e.getMessage());
        }
        return value;
    }
}
