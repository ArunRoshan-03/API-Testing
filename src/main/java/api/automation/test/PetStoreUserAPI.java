package api.automation.test;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.automation.utils.Constants;
import api.automation.utils.Utils;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetStoreUserAPI {

	@Test(priority = 1)
	public void postPetStore() {
		RequestSpecification requestSpecification = RestAssured.given();

		JSONObject userRequestParams = new JSONObject();
		userRequestParams.put("id", Constants.ID);
		userRequestParams.put("petId", Constants.PET_ID);
		userRequestParams.put("quantity", Constants.QUANTITY);
		userRequestParams.put("shipDate", Constants.SHIP_DATE);
		userRequestParams.put("status", Constants.STATUS);
		userRequestParams.put("complete", Constants.COMPLETE);

		requestSpecification.header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON);
		requestSpecification.body(userRequestParams.toJSONString());
		Response response = requestSpecification.post(Routes.USER_POST_PET_URL);

		JsonPath jsonPathEvaluator = response.jsonPath();
		String jsonvalue = jsonPathEvaluator.prettify();

		Utils.setDataIntoJsonFile(Constants.USER_PET_DATA, jsonvalue);
		Utils.getDataFromJsonFile(Constants.USER_PET_DATA);

		Integer userID = jsonPathEvaluator.get("id");
		System.out.println("userID received from Response " + userID);

		Assert.assertTrue(userID != null);
		Assert.assertEquals(response.getStatusCode(), 200);

		System.out.println("The status received: " + response.statusLine());
		System.out.println("Response =>" + response.prettyPeek());
	}

	@Test(priority = 2)
	public void getPetStore() {
		RequestSpecification requestSpecification = RestAssured.given();

		Response response = requestSpecification
				.get(Routes.USER_GET_PET_URL.replace(Routes.INDEX_NAME_WITH_BRACKET_KEY, Constants.ID));
		String petStore = response.prettyPrint();
		System.out.println(petStore);

		JsonPath jsonPathEvaluator = response.jsonPath();
		String jsonvalue = jsonPathEvaluator.prettify();
		System.out.println(jsonvalue);

		Assert.assertEquals(response.getStatusCode(), 20);
	}
}
