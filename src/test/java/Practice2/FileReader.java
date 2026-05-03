package Practice2;

import io.cucumber.java.et.Ja;
import jdk.security.jarsigner.JarSigner;
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
        try {
            FileInputStream files=new FileInputStream("src/test/resource/Config.Properties");
            prop.load(files);
        }catch (Exception e){
            throw new RuntimeException("Unable to read the properties file"+e.getMessage());
        }
        return prop.getProperty(key);
    }
    public static String jsonReader(String key) throws IOException, ParseException {
        JSONParser parser=new JSONParser();
        JSONObject json= (JSONObject) parser.parse(new java.io.FileReader("src/test/resources/testData/testSet1.json"));
        return json.get(key).toString();
    }

}
