package facebook.com;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.com.Baseclass;

import junit.framework.Assert;

public class faceBookSampleExe extends FaceBookLocators {

	@Test(priority = 1)

	public void launch() {
		Baseclass.SetProperty();
		Baseclass.url("https://www.facebook.com/");

	}

	@Parameters("username")
	@Test(priority = 2)
	public void userName(String user) {
		Baseclass.sendKeys(Baseclass.findElementByXpath(FaceBookLocators.username), user);

	}

	@Parameters("password")
	@Test(priority = 3)
	public void passWord(String pass) {
		Baseclass.sendKeys(Baseclass.findElementByXpath(FaceBookLocators.password), pass);

	}

	
	@Test(priority = 4)
	public void LoginClick() {

		Baseclass.click(Baseclass.findElementByXpath(FaceBookLocators.login));

		String s = "https://www.facebook.com/checkpoint/?next";

		String s1 = driver.getCurrentUrl();
		Assert.assertTrue(s.equals(s1));
	}

}
