package utils;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataDriven {

    public static String jsonReader(String logintype,String credential, String filepath) throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(filepath));
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject loginObject = (JSONObject) jsonObject.get(logintype);

        String value = (String) loginObject.get(credential);



        return value;

    }

}
