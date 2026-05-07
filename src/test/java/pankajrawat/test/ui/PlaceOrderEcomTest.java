package pankajrawat.test.ui;

import java.io.IOException;
import java.util.HashMap;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pankajrawat.testUtils.ui.BaseUiTest;
import pankajrawat.ui.pageobjects.CartPage;
import pankajrawat.ui.pageobjects.CheckoutPage;
import pankajrawat.ui.pageobjects.HomePage;
import pankajrawat.ui.pageobjects.OrderConfirmationPage;

public class PlaceOrderEcomTest extends BaseUiTest {
	
	@Test(dataProvider = "getData", groups= {"dataset"})
	public void submitOrder(HashMap<String,String> data) throws IOException {
		
//		Understand driverlifecycle and create objects accordingly
		
		HomePage homePage = loginpage.login(data.get("email"), data.get("password")); //improvement : use factory pattern here

		homePage.addProductToCart(data.get("product"));
		CartPage cartPage = homePage.clickOnCartIcon();
		
		AssertJUnit.assertTrue(cartPage.validateProductPresentIncart(data.get("product")));
		
		CheckoutPage checkout = cartPage.clickCheckoutBtn();
		
	    //improvement : use factory pattern here
		checkout.enterCardDetails("123", "Pankaj Singh Rawat", "cupon123", "06", "12", "India");
		OrderConfirmationPage ocp = checkout.clickPlaceOrderBtn();
		
		AssertJUnit.assertTrue(ocp.validateIsProductPresentInOrder(data.get("product")));
		System.out.println("Test Completed without issues.");
	}
	
	@DataProvider
	public Object[][] getData(){
		HashMap<String, String> data1 = new HashMap<>();
		data1.put("email", "zaaraa@gmail.com");
		data1.put("password", "Password@123");
		data1.put("product", "ZARA COAT 3");
		
		HashMap<String, String> data2 = new HashMap<>();
		data2.put("email", "addiddass@gmail.com");
		data2.put("password", "Password@123");
		data2.put("product", "ADIDAS ORIGINAL");
		return new Object[][] {{data1},{data2}};
	}

}
