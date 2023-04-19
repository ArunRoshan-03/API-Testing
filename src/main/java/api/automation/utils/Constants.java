package api.automation.utils;

import com.github.javafaker.Faker;

public class Constants {
	public static Faker faker = new Faker();
	public static final String USER_NAME = faker.name().username();
	public static final String PASSWORD = "Atmecs@1234";
	public static final String USER_ID = "684ca889-e76f-499c-b12b-fe1ed6f151c6";
	public static final String BEARER_TOKEN_VALUE = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkFydW5yb3NobiIsInBhc3N3b3JkIjoiQXRtZWNzQDEyMyIsImlhdCI6MTY3OTkzODA1OX0.90tpkcL87AzWnjaF5IfS7FXCX08ePEp553bFeJaE5T0";
	public static final String ISBN = "9781593277574";
	public static final String AUTHORIZATION_TEXT = "Authorization";
	public static final String BEARER_TEXT = "Bearer ";
	public static final String USER_DATA = "user_data.json";
	public static final String BOOKS_DETAILS = "all_books_details.json";
	public static final String UPDATED_BOOK_DATA_DETAILS = "updated_books_details.json";

	// BOOK STORE API
	public static final String ID = "6";
	public static final String PET_ID = " 3";
	public static final String QUANTITY = "1";
	public static final String SHIP_DATE = "2023-04-17T09:38:42.825Z";
	public static final String STATUS = "placed";
	public static final Boolean COMPLETE = true;
	public static final String USER_PET_DATA = "user_pet_data.json";
	public static final String USER_GET_DATA = "user_get_data.json";
	
	
	public static final String GET = "GET";
	public static final String POST = "POST";
	public static final String PUT = "PUT";
	public static final String PATCH = "PATCH";
	public static final String DELETE = "DELETE";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String APPLICATION_JSON = "application/json";

}
