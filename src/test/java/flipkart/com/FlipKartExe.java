package flipkart.com;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.com.Baseclass;

import junit.framework.Assert;

public class FlipKartExe extends FlipKartLocators {

	@Test(priority = 1)

	public void launch() {
		Baseclass.SetProperty();
		Baseclass.url("https://www.flipkart.com/account/login");

	}

	@Parameters("username")
	@Test(priority = 2)
	public void userName(String user) {
		Baseclass.sendKeys(Baseclass.findElementByXpath(FlipKartLocators.username), user);

	}

	@Parameters("password")
	@Test(priority = 3)
	public void passWord(String pass) {
		Baseclass.sendKeys(Baseclass.findElementByXpath(FlipKartLocators.password), pass);

	}

	
	@Test(priority = 4)
	public void LoginClick() {

		Baseclass.click(Baseclass.findElementByXpath(FlipKartLocators.login));

//		String s = "https://www.facebook.com/checkpoint/?next";
//
//		String s1 = driver.getCurrentUrl();
//		Assert.assertTrue(s.equals(s1));
	}

}
