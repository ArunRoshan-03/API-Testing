package api.automation.test;

public class Routes {

	public static final String BASE_URL = "https://bookstore.toolsqa.com/Account/v1";

	// Book Store Module
	public static final String GET_BOOK_URL = "https://bookstore.toolsqa.com/BookStore/v1/Books ";
	public static final String USER_POST_URL = BASE_URL + "/user";
	public static final String DELETE_BOOK_URL = "https://bookstore.toolsqa.com/BookStore/v1/Book";
	public static final String UPDATE_BOOK_URL = "https://bookstore.toolsqa.com/BookStore/v1/Books/9781449325862";

	// PET STORE API
	public static final String USER_POST_PET_URL = "https://petstore.swagger.io/v2/store/order";
	public static final String INDEX_NAME_WITH_BRACKET_KEY = "$INDEX$";
	public static final String USER_GET_PET_URL = "https://petstore.swagger.io/v2/store/order/$INDEX$";
}
