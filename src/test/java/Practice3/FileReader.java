package Practice3;

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
        Properties prop=new Properties();
        try{
            FileInputStream files=new FileInputStream("src/test/resources/Config.properties");
            prop.load(files);
        }catch (Exception e){
            throw new RuntimeException("unable to read the config files"+e.getMessage());
        }
        return prop.getProperty(key);
    }
    public static String jsonReader(String key) throws IOException, ParseException {
        JSONParser parser=new JSONParser();
        JSONObject json= (JSONObject) parser.parse(new java.io.FileReader("src/test/resources/testData/testSet.json"));
        return json.get(key).toString();
    }
    public static String excelReader(){
        String value;
        try {
            FileInputStream files=new FileInputStream("src/test/resources/testData/setData.xlsx");
            Workbook workbook= new XSSFWorkbook(files);
            Sheet sheet=workbook.getSheet("sheet1");
            Row row=sheet.getRow(1);
            Cell cell=row.getCell(0);
            value=cell.toString();
            workbook.close();
            files.close();

        }catch (Exception e){
            throw new RuntimeException(""+e.getMessage());
        }
       return value;
    }
}
