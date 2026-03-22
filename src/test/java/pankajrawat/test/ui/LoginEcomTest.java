package pankajrawat.test.ui;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pankajrawat.test.common.resources.Retry;
import pankajrawat.testUtils.ui.BaseTest;
import pankajrawat.ui.pageobjects.HomePage;

public class LoginEcomTest extends BaseTest {

	@Test(groups={"loginErrorTest"})
	public void invalidUsername() throws IOException {

		loginpage.login("invali", "July14@1994");
		String text = loginpage.getInvaliEmailErrorText();
		Assert.assertEquals(text, "*Enter Valid Email");

	}

	@Test(groups={"loginErrorTest"}, retryAnalyzer=Retry.class)
	public void invalidPassword() throws IOException {

		loginpage.login("m.pankajrawat@gmail.com", "July");
		String text = loginpage.getErrorText();
		Assert.assertEquals(text, "Incorrect email or password.");

	}
	
	@Test
	public void validLogin() {
		HomePage hompage =loginpage.login("m.pankajrawat@gmail.com", "July14@1994");
		hompage.validateHomePageNavigation();
	}
}
