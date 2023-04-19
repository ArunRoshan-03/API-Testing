package api.automation.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utils {

	public static void setDataIntoJsonFile(String textName, String value) {

		try (FileWriter file = new FileWriter(textName)) {
			file.write(value.toString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Object getDataFromJsonFile(String textName) {
		JSONParser jsonParser = new JSONParser();
		Object obj = null;
		try (FileReader reader = new FileReader(textName)) {
			obj = jsonParser.parse(reader);
			System.out.println(obj);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return obj;

	}
}
