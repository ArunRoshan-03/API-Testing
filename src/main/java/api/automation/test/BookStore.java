package api.automation.test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.automation.utils.Constants;
import api.automation.utils.Utils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookStore {

	@Test(priority = 1)
	public static void postUserAccountAPI() {
		RequestSpecification request = RestAssured.given();

		JSONObject userRequestParams = new JSONObject();
		userRequestParams.put("userName", Constants.USER_NAME);
		userRequestParams.put("password", Constants.PASSWORD);

		request.header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON);
		request.body(userRequestParams.toJSONString());
		Response response = request.post(Routes.USER_POST_URL);

		JsonPath jsonPathEvaluator = response.jsonPath();
		String jsonvalue = jsonPathEvaluator.prettify();
		
		Utils.setDataIntoJsonFile(Constants.USER_DATA, jsonvalue);
		Utils.getDataFromJsonFile(Constants.USER_DATA);
		
		String userID = jsonPathEvaluator.get("userID");	
		System.out.println("userID received from Response " + userID);

		Assert.assertTrue(userID != null);
		Assert.assertEquals(response.getStatusCode(), 201);

		System.out.println("The status received: " + response.statusLine());
		System.out.println("Response =>" + response.prettyPeek());
	}
	
	@Test(priority = 2)
	public void GetBooksDetails() {
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, Routes.GET_BOOK_URL);
		String booksData = response.prettyPrint();
		
		System.out.println(booksData);
		Utils.setDataIntoJsonFile(Constants.BOOKS_DETAILS, booksData);
		Utils.getDataFromJsonFile(Constants.BOOKS_DETAILS);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Status received => " + response.getStatusLine());
		System.out.println("Response=>" + response.prettyPrint());
	}
}
